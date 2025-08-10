package edu.lk.ijse.projectgym.demo76promax.entity;

import edu.lk.ijse.projectgym.demo76promax.Dtos.OrderDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Oders {

    private String orderId;
    private String customerId;
    private Date OderDate;
    private List<OderDeatiles> cartList;


 }
