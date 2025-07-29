package edu.lk.ijse.projectgym.demo76promax.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class MonthlySumery {
    private int id;
    private String categoryKey;
    private String categoryLable;
    private String value;
    private byte summaryMonth;
    private String year;
    private Timestamp createdAt;
}
