package com.linkedin.events.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerService
{
    private final CustomerRepository customerRepository;

    private final ApplicationEventPublisher publisher;

    public void register(Customer customer)
    {
        customerRepository.save(customer);
        publisher.publishEvent(new CustomerRegisteredEvent(customer));
    }

    public void remove(Customer customer)
    {
        customerRepository.delete(customer);
        publisher.publishEvent(new CustomerRemovedEvent(customer));
    }
}
