package com.demo.sqlTest.controller;

import java.util.List;

import com.demo.sqlTest.dto.PaymentDTO;
import com.demo.sqlTest.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @GetMapping(value = "/getPayments")
    public List<PaymentDTO> getPayment(){
        return service.getAllUsers();
    }

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/addPayment/{id}/{cid}/{num}")
    public PaymentDTO addPayment(@PathVariable("id") Long id, @PathVariable("cid") String cid, @PathVariable("num") Integer num ) {
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setUid(id);
        paymentDTO.setCid(cid);
        paymentDTO.setTickets_bought(num);
        paymentDTO.setPdate(LocalDate.now().toString());
        paymentDTO.setPtime(LocalTime.now().toString());
        paymentDTO.setPstatus("Reserved");
        return paymentService.save(paymentDTO);
    }
//    @PostMapping("/addPayment/{id}/{cid}/{num}")
//
//    public ResponseEntity<PaymentDTO> addPayment(@RequestBody PaymentDTO paymentDTO, @PathVariable("id") Long id, @PathVariable("cid") String cid, @PathVariable("num") Integer num ){
//
//        paymentDTO.setUid(id);
//        paymentDTO.setCid(cid);
//        paymentDTO.setTickets_bought(num);
//        paymentDTO.setPdate(LocalDate.now().toString());
//        paymentDTO.setPtime(LocalTime.now().toString());
//        paymentDTO.setPstatus("Reserved");
//        PaymentDTO savedPaymentDTO = service.save(paymentDTO);
//        return new ResponseEntity<>(savedPaymentDTO, HttpStatus.CREATED);
//    }

}
