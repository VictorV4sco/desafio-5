package com.devsuperior.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.demo.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
