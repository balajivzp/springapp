package com.customerlogservice.rest.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customerlogservice.rest.springapp.model.CustomerLog;

public interface CustomerLogJpaRepository extends JpaRepository<CustomerLog, String> {
   CustomerLog findByname(String name);
   List<CustomerLog> findBydate(String date);
}
