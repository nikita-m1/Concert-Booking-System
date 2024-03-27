package com.demo.sqlTest.entity;


import jakarta.persistence.*;
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
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    private Long uid;
    private String pdate;
    private String ptime;
    private String pstatus;
    private Integer tickets_bought;
    private String cid;

}
