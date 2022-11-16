package lk.carrental.carrental.service;


import lk.carrental.carrental.dto.DriverDTO;
import lk.carrental.carrental.dto.UserDTO;

import java.util.List;

public interface DriverService {
    DriverDTO getDriverForLogIn(UserDTO userDTO);
    public DriverDTO getRandomDriver();
    void saveDriver(DriverDTO dto);
    void deleteDriver(String id);
    void updateDriver(DriverDTO dto);
    DriverDTO searchDriver(String id);
    List<DriverDTO> getAllDriver();
}
