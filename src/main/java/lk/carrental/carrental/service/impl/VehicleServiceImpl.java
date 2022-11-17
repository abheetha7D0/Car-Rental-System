package lk.carrental.carrental.service.impl;

import lk.carrental.carrental.dto.VehicleDTO;
import lk.carrental.carrental.entity.Vehicle;
import lk.carrental.carrental.repo.VehicleRepo;
import lk.carrental.carrental.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepo repo;

    private final ModelMapper mapper;

    public VehicleServiceImpl(VehicleRepo repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public void saveVehicle(VehicleDTO dto) {
        if (!repo.existsById(dto.getNumber())) {
            repo.save(mapper.map(dto, Vehicle.class));
        } else {
            throw new RuntimeException("Vehicle Already Exist..!");
        }
    }

    @Override
    public void deleteVehicle(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Please check the Vehicle Number.. No Such Vehicle..!");
        }
    }

    @Override
    public void updateVehicle(VehicleDTO dto) {
        if (repo.existsById(dto.getNumber())) {
            repo.save(mapper.map(dto, Vehicle.class));
        } else {
            throw new RuntimeException("No Such Vehicle To Update..! Please Check the Number..!");
        }
    }

    @Override
    public VehicleDTO searchVehicle(String id) {
        if (repo.existsById(id)) {
            return mapper.map(repo.findById(id).get(), VehicleDTO.class);
        } else {
            throw new RuntimeException("No Vehicle For " + id + " ..!");
        }
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return mapper.map(repo.findAll(), new TypeToken<List<VehicleDTO>>() {
        }.getType());
    }
}
