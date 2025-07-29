package edu.lk.ijse.projectgym.demo76promax.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.Text;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Suppliers {

    private String supplierId;
    private String name;
    private String contactNumber;
    private String email;
    private Text address;
}
