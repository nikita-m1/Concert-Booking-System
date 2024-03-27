package com.demo.sqlTest.service;

import com.demo.sqlTest.entity.Payment;
import com.demo.sqlTest.mappers.mapper;
import com.demo.sqlTest.dto.PaymentDTO;
import com.demo.sqlTest.repo.PaymentRepo;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class serviceImpl implements PaymentService {

    private PaymentRepo userRepository;

//    @Override
//    public PaymentDTO save(PaymentDTO userDto) {
//            // Convert PaymentDTO to Payment entity
//            Payment payment = mapper.mapToPayment(userDto);
//
//            // Save the Payment entity
//            Payment savedPayment = userRepository.save(payment);
//
//            // Convert saved Payment entity back to PaymentDTO and return
//            return mapper.mapToPaymentDTO(savedPayment);
//    }
    public PaymentDTO save(PaymentDTO paymentDTO) {
        Payment payment = new Payment();
        payment.setCid(paymentDTO.getCid());
        payment.setUid(paymentDTO.getUid());
        payment.setTickets_bought(paymentDTO.getTickets_bought());
        payment.setPtime(paymentDTO.getPtime());
        payment.setPstatus(paymentDTO.getPstatus());
        payment.setPdate(paymentDTO.getPdate());

        Payment savedPayment = userRepository.save(payment);
        return new PaymentDTO(savedPayment.getUid(), savedPayment.getPdate(), savedPayment.getPtime(), savedPayment.getPstatus(), savedPayment.getTickets_bought(), savedPayment.getCid());
    }

    public PaymentDTO findById(int userId) {
        Optional<Payment> optionalEmployee = userRepository.findById(userId);
        Payment user = optionalEmployee.get();
        return mapper.mapToPaymentDTO(user);
    }

    public void deleteById(int userId) {
        userRepository.deleteById(userId);
    }

    public List<PaymentDTO> getAllUsers() {
        List<Payment> users = userRepository.findAll();
        return users.stream().map(mapper::mapToPaymentDTO)
                .collect(Collectors.toList());
    }

}
