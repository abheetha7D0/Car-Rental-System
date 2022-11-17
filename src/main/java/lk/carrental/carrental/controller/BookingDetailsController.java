package lk.carrental.carrental.controller;


import lk.carrental.carrental.dto.BookingDetailsDTO;
import lk.carrental.carrental.service.BookingDetailsService;
import lk.carrental.carrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookingDetails")
@CrossOrigin
public class BookingDetailsController {
    final
    BookingDetailsService bookingDetailsService;

    public BookingDetailsController(BookingDetailsService bookingDetailsService) {
        this.bookingDetailsService = bookingDetailsService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAll(){
        return new ResponseUtil(200,"OK",bookingDetailsService.getAllBookingDetails());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil addDetails(@RequestBody BookingDetailsDTO dto){
        bookingDetailsService.saveBookingDetails(dto);
        return new ResponseUtil(200,"Saved",null);
    }


    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCustomer(@RequestBody BookingDetailsDTO bookingDetailsDTO){
        bookingDetailsService.updateBookingDetails(bookingDetailsDTO);
        return new ResponseUtil(200,"updated",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteCustomer(@RequestParam String id){
        bookingDetailsService.deleteBookingDetails(id);
        return new ResponseUtil(200,"Deleted",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCustomer(@PathVariable String id){
        return new ResponseUtil(200,"ok",bookingDetailsService.searchBookingDetails(id));
    }
}
