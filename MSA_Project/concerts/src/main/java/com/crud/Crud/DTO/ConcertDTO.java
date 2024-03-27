package com.crud.Crud.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConcertDTO {
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
