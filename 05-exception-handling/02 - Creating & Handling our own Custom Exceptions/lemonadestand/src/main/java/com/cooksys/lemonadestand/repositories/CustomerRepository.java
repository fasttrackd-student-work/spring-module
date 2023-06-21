package com.cooksys.lemonadestand.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.lemonadestand.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
