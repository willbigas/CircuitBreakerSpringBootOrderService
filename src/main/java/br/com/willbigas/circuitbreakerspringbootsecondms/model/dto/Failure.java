package br.com.willbigas.circuitbreakerspringbootsecondms.model.dto;

import lombok.Data;

@Data
public class Failure implements Type {

	private final String msg;
}
