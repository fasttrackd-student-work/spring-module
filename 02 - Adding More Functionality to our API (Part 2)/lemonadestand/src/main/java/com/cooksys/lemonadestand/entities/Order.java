package com.cooksys.lemonadestand.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "order_table")
@Entity
@NoArgsConstructor
@Data
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private double total;

    @OneToMany(mappedBy = "order")
    private List<Lemonade> lemonades = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    private Customer customer;

    @ManyToOne
    @JoinColumn
    private LemonadeStand lemonadeStand;

}
