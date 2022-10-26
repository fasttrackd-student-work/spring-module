package com.cooksys.lemonadestand.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.cooksys.lemonadestand.entities.Order;
import com.cooksys.lemonadestand.model.OrderRequestDto;
import com.cooksys.lemonadestand.model.OrderResponseDto;

@Mapper(componentModel = "spring", uses = { CustomerMapper.class, LemonadeMapper.class, LemonadeStandMapper.class })
public interface OrderMapper {

    Order requestDtoToEntity(OrderRequestDto orderRequestDto);

    OrderResponseDto entityToResponseDto(Order order);

    List<OrderResponseDto> entitiesToResponseDtos(List<Order> orders);

}
