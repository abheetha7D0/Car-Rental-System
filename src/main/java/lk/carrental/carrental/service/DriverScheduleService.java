package lk.carrental.carrental.service;



import lk.carrental.carrental.dto.DriverScheduleDTO;

import java.util.List;

public interface DriverScheduleService {
    void updateDriverSchedule(DriverScheduleDTO dto);
    DriverScheduleDTO searchDriverSchedule(String id);
    List<DriverScheduleDTO> getAllDriverSchedules();
}
