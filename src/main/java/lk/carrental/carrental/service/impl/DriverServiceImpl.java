package lk.carrental.carrental.service.impl;

import lk.carrental.carrental.dto.DriverDTO;
import lk.carrental.carrental.dto.UserDTO;
import lk.carrental.carrental.entity.Driver;
import lk.carrental.carrental.repo.DriverRepo;
import lk.carrental.carrental.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public DriverDTO getDriverForLogIn(UserDTO userDTO) {
        List<Driver> all = repo.findAll();
        for (Driver driver:all) {
            if (driver.getName().equals(userDTO.getUsername()) & driver.getLicenseNumber().equals(userDTO.getPassword())){
                return new DriverDTO(driver.getLicenseNumber(),driver.getName(),driver.getAddress(),driver.getContactNumber(),driver.getLicensePhoto(),driver.getStatus());
            }
        }
        return null;
    }

    @Override
    public DriverDTO getRandomDriver() {
        Driver driverRandomly = repo.findDriverRandomly();
        DriverDTO driverDTO = mapper.map(driverRandomly, DriverDTO.class);
        return driverDTO;
    }

    @Override
    public void saveDriver(DriverDTO dto) {
        if (!repo.existsById(dto.getLicenseNumber())) {
            repo.save(mapper.map(dto, Driver.class));
        } else {
            throw new RuntimeException("Driver Already Exist..!");
        }
    }

    @Override
    public void deleteDriver(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Please check the Driver ID..!");
        }
    }

    @Override
    public void updateDriver(DriverDTO dto) {
        if (repo.existsById(dto.getLicenseNumber())) {
            repo.save(mapper.map(dto, Driver.class));
        } else {
            throw new RuntimeException("No Such Driver To Update..! Please Check the ID..!");
        }
    }

    @Override
    public DriverDTO searchDriver(String id) {
        if (repo.existsById(id)) {
            return mapper.map(repo.findById(id).get(), DriverDTO.class);
        } else {
            throw new RuntimeException("No Customer For " + id + " ..!");
        }
    }

    @Override
    public List<DriverDTO> getAllDriver() {
        return mapper.map(repo.findAll(), new TypeToken<List<DriverDTO>>() {
        }.getType());
    }

}
