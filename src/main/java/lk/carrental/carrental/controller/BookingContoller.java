package lk.carrental.carrental.controller;


import lk.carrental.carrental.dto.BookingDTO;
import lk.carrental.carrental.service.BookingService;
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
@RequestMapping("/booking")
@CrossOrigin
public class BookingContoller {
    @Autowired
    BookingService bookingService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllBooking(){
        return new ResponseUtil(200,"OK",bookingService.getAllBooking());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "addBooking", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil registerCustomer(@RequestPart("bookingLoseDamageSlipFile") MultipartFile[] file, @RequestPart("booking") BookingDTO bookingDTO) {
        System.out.println("awo 111");

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
        System.out.println(bookingDTO);
        bookingService.saveBooking(bookingDTO);
        return new ResponseUtil(200,"Booking Saved",bookingDTO);
    }

    @GetMapping(path = "/lastID/rentID")
    public ResponseUtil getLastRid() {
        String lastRid = bookingService.getLastRid();
        return new ResponseUtil(200,"Booking is Updated",lastRid);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateBooking(@RequestBody BookingDTO bookingDTO){
        bookingService.updateBooking(bookingDTO);
        return new ResponseUtil(200,"updated",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteBooking(@RequestParam String id){
        bookingService.deleteBooking(id);
        return new ResponseUtil(200,"Deleted",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchBooking(@PathVariable String id){
        return new ResponseUtil(200,"ok",bookingService.searchBooking(id));
    }
}
