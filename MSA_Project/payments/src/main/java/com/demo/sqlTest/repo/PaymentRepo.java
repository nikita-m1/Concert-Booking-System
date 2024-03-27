package com.demo.sqlTest.repo;

import com.demo.sqlTest.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Integer> {

}
