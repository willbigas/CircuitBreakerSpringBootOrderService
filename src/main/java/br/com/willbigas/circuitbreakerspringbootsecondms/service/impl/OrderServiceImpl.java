package br.com.willbigas.circuitbreakerspringbootsecondms.service.impl;

import br.com.willbigas.circuitbreakerspringbootsecondms.model.Order;
import br.com.willbigas.circuitbreakerspringbootsecondms.model.dto.AddressDTO;
import br.com.willbigas.circuitbreakerspringbootsecondms.model.dto.Failure;
import br.com.willbigas.circuitbreakerspringbootsecondms.model.dto.Type;
import br.com.willbigas.circuitbreakerspringbootsecondms.repository.OrderRepository;
import br.com.willbigas.circuitbreakerspringbootsecondms.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;


    private static final String SERVICE_NAME = "address-service";
    private static final String ADDRESS_SERVICE_URL = "http://localhost:9090/addresses/";

    @CircuitBreaker(name = SERVICE_NAME, fallbackMethod = "fallbackMethod")
    public Type getOrderByPostCode(String orderNumber) {
        Order order = orderRepository.findByOrderNumber(orderNumber)
                .orElseThrow(() -> new RuntimeException("Order Not Found: " + orderNumber));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AddressDTO> entity = new HttpEntity<>(null, headers);
        ResponseEntity<AddressDTO> response = restTemplate.exchange(
                (ADDRESS_SERVICE_URL + order.getPostalCode()), HttpMethod.GET, entity,
                AddressDTO.class);
        AddressDTO addressDTO = response.getBody();
        if (addressDTO != null) {
            order.setShippingState(addressDTO.getState());
            order.setShippingCity(addressDTO.getCity());
        }
        return order;
    }

    private Type fallbackMethod(Exception e) {
        return new Failure("Address service is not responding properly");
    }
}
