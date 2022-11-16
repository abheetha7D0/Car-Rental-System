package lk.carrental.carrental.service.impl;


import lk.carrental.carrental.dto.DriverScheduleDTO;
import lk.carrental.carrental.entity.DriverSchedule;
import lk.carrental.carrental.repo.DriverScheduleRepo;
import lk.carrental.carrental.service.DriverScheduleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class DriverScheduleServiceImpl implements DriverScheduleService {
    @Autowired
    DriverScheduleRepo repo;

    @Autowired
    private ModelMapper mapper;
    @Override
    public void updateDriverSchedule(DriverScheduleDTO dto) {
        repo.save(mapper.map(dto, DriverSchedule.class));
    }

    @Override
    public DriverScheduleDTO searchDriverSchedule(String id) {
        return mapper.map(repo.findById(id).get(), DriverScheduleDTO.class);
    }

    @Override
    public List<DriverScheduleDTO> getAllDriverSchedules() {
        return mapper.map(repo.findAll(), new TypeToken<List<DriverScheduleDTO>>() {
        }.getType());
    }
}
