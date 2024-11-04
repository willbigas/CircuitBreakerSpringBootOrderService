package br.com.willbigas.circuitbreakerspringbootsecondms.controller;

import br.com.willbigas.circuitbreakerspringbootsecondms.model.dto.Type;
import br.com.willbigas.circuitbreakerspringbootsecondms.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;

	@GetMapping
	public Type getOrderByPostCode(@RequestParam("orderNumber") String orderNumber) {
		return orderService.getOrderByPostCode(orderNumber);
	}
}
