package guru.springframework.msscbrewery.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import guru.springframework.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Override
    public void deleteCustomer(final UUID id) {
        log.info("DELETING CUSTOMER");
    }

    @Override
    public CustomerDto getCustomerById(final UUID id) {
        return CustomerDto.builder() //
                .id(UUID.randomUUID()) //
                .name("John Doe") //
                .build();
    }

    @Override
    public CustomerDto saveCustomer(final CustomerDto customer) {
        return CustomerDto.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateCustomer(final UUID id, final CustomerDto customer) {
        log.info("Updating Customer");
    }

}
