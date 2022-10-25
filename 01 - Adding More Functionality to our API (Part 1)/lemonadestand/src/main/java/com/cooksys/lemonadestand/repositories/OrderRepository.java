package com.cooksys.lemonadestand.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.lemonadestand.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
