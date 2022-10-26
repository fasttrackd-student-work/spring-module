package com.cooksys.lemonadestand.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.lemonadestand.entities.Lemonade;
import com.cooksys.lemonadestand.entities.Order;
import com.cooksys.lemonadestand.mappers.OrderMapper;
import com.cooksys.lemonadestand.model.OrderRequestDto;
import com.cooksys.lemonadestand.model.OrderResponseDto;
import com.cooksys.lemonadestand.repositories.OrderRepository;
import com.cooksys.lemonadestand.services.CustomerService;
import com.cooksys.lemonadestand.services.LemonadeService;
import com.cooksys.lemonadestand.services.LemonadeStandService;
import com.cooksys.lemonadestand.services.OrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final LemonadeService lemonadeService;
    private final CustomerService customerService;
    private final LemonadeStandService lemonadeStandService;

    private final OrderMapper orderMapper;

    private void setupOrder(Order order) {
        double total = 0.0;
        List<Lemonade> lemonades = new ArrayList<>();
        for (Lemonade lemonade : order.getLemonades()) {
            lemonade = lemonadeService.getLemonade(lemonade.getId());
            lemonades.add(lemonade);
            total += lemonade.getPrice();
        }
        order.setLemonades(lemonades);
        order.setTotal(total);
        order.setCustomer(customerService.getCustomer(order.getCustomer().getId()));
        order.setLemonadeStand(lemonadeStandService.getLemonadeStand(order.getLemonadeStand().getId()));
    }

    @Override
    public OrderResponseDto createOrder(OrderRequestDto orderRequestDto) {
        Order order = orderMapper.requestDtoToEntity(orderRequestDto);
        setupOrder(order);
        return orderMapper.entityToResponseDto(orderRepository.saveAndFlush(order));
    }

}
