package lk.carrental.carrental.service.impl;

import lk.carrental.carrental.dto.VehicleScheduleDTO;
import lk.carrental.carrental.entity.VehicleSchedule;
import lk.carrental.carrental.repo.VehicleScheduleRepo;
import lk.carrental.carrental.service.VehicleScheduleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class VehicleScheduleServiceImpl implements VehicleScheduleService {
    final
    VehicleScheduleRepo repo;

    private final ModelMapper mapper;

    public VehicleScheduleServiceImpl(VehicleScheduleRepo repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public void updateVehicleSchedule(VehicleScheduleDTO dto) {
        repo.save(mapper.map(dto, VehicleSchedule.class));
    }

    @Override
    public VehicleScheduleDTO searchVehicleSchedule(String id) {
        return mapper.map(repo.findById(id).get(), VehicleScheduleDTO.class);
    }

    @Override
    public List<VehicleScheduleDTO> getAllVehicleSchedules() {
        return mapper.map(repo.findAll(), new TypeToken<List<VehicleScheduleDTO>>() {
        }.getType());
    }
}
