package lk.carrental.carrental.service.impl;

import lk.carrental.carrental.dto.SystemUserDTO;
import lk.carrental.carrental.dto.UserDTO;
import lk.carrental.carrental.entity.SystemUser;
import lk.carrental.carrental.repo.SystemUserRepo;
import lk.carrental.carrental.service.SystemUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SystemUserServiceImpl implements SystemUserService {
    @Autowired
    private SystemUserRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public SystemUserDTO getUserForLogIn(UserDTO userDTO) {
        List<SystemUser> all = repo.findAll();
        for (SystemUser systemUser:all) {
            if (systemUser.getUserName().equals(userDTO.getUsername()) & systemUser.getPassword().equals(userDTO.getPassword())){
                return new SystemUserDTO(systemUser.getId(),systemUser.getUserName(),systemUser.getPassword());
            }
        }
        return null;
    }

    @Override
    public void saveUser(SystemUserDTO dto) {
        if (!repo.existsById(dto.getId())) {
            repo.save(mapper.map(dto, SystemUser.class));
        } else {
            throw new RuntimeException("User Already Exist..!");
        }
    }
}
