package lk.carrental.carrental.service.impl;

import lk.carrental.carrental.dto.PaymentDTO;
import lk.carrental.carrental.entity.Payment;
import lk.carrental.carrental.repo.PaymentRepo;
import lk.carrental.carrental.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void savePayment(PaymentDTO dto) {
            repo.save(mapper.map(dto, Payment.class));
    }
}
