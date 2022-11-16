package lk.carrental.carrental.service;




import lk.carrental.carrental.dto.VehicleScheduleDTO;

import java.util.List;

public interface VehicleScheduleService {
    void updateVehicleSchedule(VehicleScheduleDTO dto);
    VehicleScheduleDTO searchVehicleSchedule(String id);
    List<VehicleScheduleDTO> getAllVehicleSchedules();
}
