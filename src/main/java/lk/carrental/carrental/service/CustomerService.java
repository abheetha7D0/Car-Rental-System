package lk.carrental.carrental.service;



import lk.carrental.carrental.dto.CustomerDTO;
import lk.carrental.carrental.dto.CustomerDTO2;
import lk.carrental.carrental.dto.UserDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO2 getCustomerForLogIn(UserDTO userDTO);
    void saveCustomer(CustomerDTO2 dto);
    void deleteCustomer(String id);
    void updateCustomer(CustomerDTO dto);
    CustomerDTO searchCustomer(String id);
    List<CustomerDTO2> getAllCustomers();
}
