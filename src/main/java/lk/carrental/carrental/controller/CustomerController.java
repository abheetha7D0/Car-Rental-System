package lk.carrental.carrental.controller;

import lk.carrental.carrental.dto.CustomerDTO;
import lk.carrental.carrental.dto.CustomerDTO2;
import lk.carrental.carrental.service.CustomerService;
import lk.carrental.carrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    final
    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCustomer(){
        return new ResponseUtil(200,"OK",customerService.getAllCustomers());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "register", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil registerCustomer(@RequestPart("customerFile") MultipartFile[] file, @RequestPart("customer") CustomerDTO2 customerDTO) {

        for (MultipartFile myFile : file) {

            try {
                String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
                File uploadsDir = new File(projectPath + "/uploads");
                uploadsDir.mkdir();
                myFile.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + myFile.getOriginalFilename()));
                System.out.println(projectPath);
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
                return new ResponseUtil(500, "Registration Failed.Try Again Latter", null);
            }
        }

        customerDTO.setLicensePhoto("uploads/" + customerDTO.getLicensePhoto());
        customerDTO.setIdentyPhoto("uploads/" + customerDTO.getIdentyPhoto());
        System.out.println(customerDTO.toString());
        customerService.saveCustomer(customerDTO);
        return new ResponseUtil(200,"Customer Saved",customerDTO);
    }
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.updateCustomer(customerDTO);
        return new ResponseUtil(200,"updated",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteCustomer(@RequestParam String id){
        customerService.deleteCustomer(id);
        return new ResponseUtil(200,"Deleted",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCustomer(@PathVariable String id){
        return new ResponseUtil(200,"ok",customerService.searchCustomer(id));
    }

}
