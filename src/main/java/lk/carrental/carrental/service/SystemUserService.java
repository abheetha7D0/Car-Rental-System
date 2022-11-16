package lk.carrental.carrental.service;


import lk.carrental.carrental.dto.SystemUserDTO;
import lk.carrental.carrental.dto.UserDTO;

public interface SystemUserService {
    SystemUserDTO getUserForLogIn(UserDTO userDTO);
    void saveUser(SystemUserDTO dto);

}
