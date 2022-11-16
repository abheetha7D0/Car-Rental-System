package lk.carrental.carrental.controller;

import lk.carrental.carrental.dto.VehicleScheduleDTO;
import lk.carrental.carrental.service.VehicleScheduleService;
import lk.carrental.carrental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicleSchedule")
@CrossOrigin
public class VehicleScheduleController {
    @Autowired
    VehicleScheduleService vehicleScheduleService;

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateDriverSchedule(@RequestBody VehicleScheduleDTO dto){
        vehicleScheduleService.updateVehicleSchedule(dto);
        return new ResponseUtil(200,"updated",null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllDriverSchedule(){
        return new ResponseUtil(200,"OK",vehicleScheduleService.getAllVehicleSchedules());
    }

}
