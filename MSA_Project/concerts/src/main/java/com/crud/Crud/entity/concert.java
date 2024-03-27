package com.crud.Crud.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "concert")
public class concert {
    @Id
    private String cid;
    private String cname;
    private String singer;
    private String city;
    private String location;
    private Date cdate;
    private String ctime;
    private String zone;
    private float price;
    private int tickets_available;
}
