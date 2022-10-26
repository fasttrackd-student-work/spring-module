package com.cooksys.lemonadestand.services;

import com.cooksys.lemonadestand.model.OrderRequestDto;
import com.cooksys.lemonadestand.model.OrderResponseDto;

public interface OrderService {

    OrderResponseDto createOrder(OrderRequestDto orderRequestDto);

}
