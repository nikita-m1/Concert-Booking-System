package com.demo.sqlTest.service;
import java.util.List;

import com.demo.sqlTest.dto.PaymentDTO;
public interface PaymentService {

    PaymentDTO save(PaymentDTO user);
    List<PaymentDTO> getAllUsers();

    PaymentDTO findById(int userId);
    public void deleteById(int userId);


}
