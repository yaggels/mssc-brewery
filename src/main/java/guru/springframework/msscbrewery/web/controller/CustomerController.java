package guru.springframework.msscbrewery.web.controller;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.CustomerDto;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable final UUID customerId) {
        customerService.deleteCustomer(customerId);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable final UUID customerId) {
        final CustomerDto customer = customerService.getCustomerById(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> saveCustomer(@RequestBody final CustomerDto customer) {
        final CustomerDto saveCustomer = customerService.saveCustomer(customer);
        final HttpHeaders header = new HttpHeaders();
        header.add("Location", "/api/v1/customer/" + saveCustomer.getId());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void updateCustomer(@PathVariable final UUID customerId, @RequestBody final CustomerDto customer) {
        customerService.updateCustomer(customerId, customer);
    }

}
