package br.com.willbigas.circuitbreakerspringbootsecondms.service;

import br.com.willbigas.circuitbreakerspringbootsecondms.model.dto.Type;

public interface OrderService {

	 Type getOrderByPostCode(String orderNumber);
}
