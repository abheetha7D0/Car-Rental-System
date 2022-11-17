package lk.carrental.carrental.controller;


import lk.carrental.carrental.dto.VehicleDTO;
import lk.carrental.carrental.service.VehicleService;
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
@RequestMapping("/vehicle")
@CrossOrigin
public class VehicleController {

    final
    VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllVehicle(){
        return new ResponseUtil(200,"OK",vehicleService.getAllVehicles());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "save", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil saveVehicle(@RequestPart("vehicleFile") MultipartFile[] file, @RequestPart("vehicle") VehicleDTO vehicleDTO) {
        //System.out.println(vehicleDTO.toString());
        for (MultipartFile myFile : file) {

            try {
                String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
                File uploadsDir = new File(projectPath + "/uploads");
                uploadsDir.mkdir();
                myFile.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + myFile.getOriginalFilename()));
                System.out.println(projectPath);
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
                return new ResponseUtil(500, "Saving Failed.Try Again Latter", null);
            }
        }

        vehicleDTO.setFrontPhoto("uploads/" + vehicleDTO.getFrontPhoto());
        vehicleDTO.setBackPhoto("uploads/" + vehicleDTO.getBackPhoto());
        vehicleDTO.setSide1Photo("uploads/" + vehicleDTO.getSide1Photo());
        vehicleDTO.setSide2Photo("uploads/" + vehicleDTO.getSide2Photo());
        vehicleService.saveVehicle(vehicleDTO);
        return new ResponseUtil(200,"Vehicle Saved",vehicleDTO);
    }
}
