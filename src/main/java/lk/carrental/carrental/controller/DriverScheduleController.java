package lk.carrental.carrental.controller;


import lk.carrental.carrental.dto.DriverScheduleDTO;
import lk.carrental.carrental.service.DriverScheduleService;
import lk.carrental.carrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driverSchedule")
@CrossOrigin
public class DriverScheduleController {
    @Autowired
    DriverScheduleService driverScheduleService;

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateDriverSchedule(@RequestBody DriverScheduleDTO dto){
        driverScheduleService.updateDriverSchedule(dto);
        return new ResponseUtil(200,"updated",null);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllDriverSchedule(){
        return new ResponseUtil(200,"OK",driverScheduleService.getAllDriverSchedules());
    }

}
