package com.demo.sqlTest.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;
    private String pdate;
    private String ptime;
    private String pstatus;
    private Integer tickets_bought;
    private String cid;

}
