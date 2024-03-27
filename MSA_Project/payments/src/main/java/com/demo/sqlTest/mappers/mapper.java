package com.demo.sqlTest.mappers;

import com.demo.sqlTest.entity.Payment;
import com.demo.sqlTest.dto.PaymentDTO;
public class mapper {
    public static PaymentDTO mapToPaymentDTO(Payment payment){


        return new PaymentDTO(
                payment.getUid(),
                payment.getPdate(),
                payment.getPtime(),
                payment.getPstatus(),
                payment.getTickets_bought(),
                payment.getCid()
        );
    }
    public static Payment mapToPayment(PaymentDTO paymentDTO){
        return new Payment(
                paymentDTO.getUid(),
                paymentDTO.getPdate(),
                paymentDTO.getPtime(),
                paymentDTO.getPstatus(),
                paymentDTO.getTickets_bought(),
                paymentDTO.getCid()
        );
    }
}
