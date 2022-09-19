package guru.springframework.msscbrewery.services;

import java.util.UUID;

import guru.springframework.msscbrewery.web.model.CustomerDto;

public interface CustomerService {

    void deleteCustomer(UUID id);

    CustomerDto getCustomerById(UUID id);

    CustomerDto saveCustomer(CustomerDto customer);

    void updateCustomer(UUID id, CustomerDto customer);

}
