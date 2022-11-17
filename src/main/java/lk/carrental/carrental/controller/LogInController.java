package lk.carrental.carrental.controller;


import lk.carrental.carrental.dto.CustomerDTO2;
import lk.carrental.carrental.dto.DriverDTO;
import lk.carrental.carrental.dto.SystemUserDTO;
import lk.carrental.carrental.dto.UserDTO;
import lk.carrental.carrental.service.CustomerService;
import lk.carrental.carrental.service.DriverService;
import lk.carrental.carrental.service.SystemUserService;
import lk.carrental.carrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logIn")
@CrossOrigin
public class LogInController {
    final
    CustomerService customerService;

    final
    DriverService driverService;

    final
    SystemUserService userService;

    public LogInController(CustomerService customerService, DriverService driverService, SystemUserService userService) {
        this.customerService = customerService;
        this.driverService = driverService;
        this.userService = userService;
    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil checkLodging(@RequestBody UserDTO userDTO){

        CustomerDTO2 customerDTO = customerService.getCustomerForLogIn(userDTO);
        if(customerDTO==null){
            DriverDTO driverForLoging = driverService.getDriverForLogIn(userDTO);
            if(driverForLoging==null){
                SystemUserDTO adminForLoging = userService.getUserForLogIn(userDTO);
                if (!(adminForLoging==null)){
                    return new ResponseUtil(200,"Admin",adminForLoging);
                }else {
                    return new ResponseUtil(200,"Incorrect user name and password",null);
                }
            }else {
                return new ResponseUtil(200,"Driver",driverForLoging);

            }
        }else {
            return new ResponseUtil(200,"Customer",customerDTO);
        }

    }
}
