package lk.carrental.carrental.controller;


import lk.carrental.carrental.dto.PaymentDTO;
import lk.carrental.carrental.service.PaymentService;
import lk.carrental.carrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@CrossOrigin
public class PaymentController {
    @Autowired
    PaymentService paymentService;
    
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil savePayment(@RequestBody PaymentDTO dto){
        paymentService.savePayment(dto);
        return new ResponseUtil(200,"Saved",null);
    }
}
