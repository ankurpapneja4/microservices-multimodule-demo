package com.example.demoapp.mappers;

import com.example.demoapp.web.model.CustomerDTO;
import com.exapmple.demoapp.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerDTOMapper {

    final CustomerDTOMapper INSTANCE = Mappers.getMapper(CustomerDTOMapper.class);

    Customer customerDtoToCustomer(CustomerDTO customerDTO);

    CustomerDTO customerToCustomerDto(Customer customer);

}
