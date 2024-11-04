package br.com.willbigas.circuitbreakerspringbootsecondms.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private Integer id;
    private String postalCode;
    private String state;
    private String city;
}