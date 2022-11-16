package lk.carrental.carrental.service.impl;


import lk.carrental.carrental.dto.CustomerDTO;
import lk.carrental.carrental.dto.CustomerDTO2;
import lk.carrental.carrental.dto.UserDTO;
import lk.carrental.carrental.entity.Customer;
import lk.carrental.carrental.repo.CustomerRepo;
import lk.carrental.carrental.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public CustomerDTO2 getCustomerForLogIn(UserDTO userDTO) {
        List<Customer> all = repo.findAll();
        for (Customer customer:all) {
            if (customer.getEmail().equals(userDTO.getUsername()) & customer.getPassword().equals(userDTO.getPassword())){
                return new CustomerDTO2(customer.getId(),customer.getName(),customer.getAddress(),customer.getContactNumber(),customer.getEmail(),customer.getPassword(),customer.getLicenseNumber(),customer.getLicensePhoto(),customer.getNICPhoto());
            }
        }
        return null;
    }

    @Override
    public void saveCustomer(CustomerDTO2 dto) {
        if (!repo.existsById(dto.getId())) {
            repo.save(mapper.map(dto, Customer.class));
        } else {
            throw new RuntimeException("Customer Already Exist..!");
        }
    }

    @Override
    public void deleteCustomer(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Please check the Customer ID.. No Such Customer..!");
        }
    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        if (repo.existsById(dto.getNICNumber())) {
            repo.save(mapper.map(dto, Customer.class));
        } else {
            throw new RuntimeException("No Such Customer To Update..! Please Check the ID..!");
        }
    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        if (repo.existsById(id)) {
            return mapper.map(repo.findById(id).get(), CustomerDTO.class);
        } else {
            throw new RuntimeException("No Customer For " + id + " ..!");
        }
    }

    @Override
    public List<CustomerDTO2> getAllCustomers() {
        return mapper.map(repo.findAll(), new TypeToken<List<CustomerDTO2>>() {
        }.getType());
    }
}
