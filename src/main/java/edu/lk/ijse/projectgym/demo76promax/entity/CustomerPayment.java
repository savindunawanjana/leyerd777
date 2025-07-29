package edu.lk.ijse.projectgym.demo76promax.entity;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter

public class CustomerPayment {

    private int paymentId;
    private String customerId;
    private Date expayerDate;
    private int validNomberOfMonths;
    private String SystemUserRoll;
    private Date paymentDate;
    private BigDecimal paymentAmount;

}
