package lk.carrental.carrental.service;

import lk.carrental.carrental.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {
    void saveVehicle(VehicleDTO dto);
    void deleteVehicle(String id);
    void updateVehicle(VehicleDTO dto);
    VehicleDTO searchVehicle(String id);
    List<VehicleDTO> getAllVehicles();

}
