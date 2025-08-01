package edu.lk.ijse.projectgym.demo76promax.Dtos.tm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExsaisTm {

    private int id;
    private String exsaisName;
    private String exsaisCategory;
    private Timestamp date;
    private String systemUserRoll;

}
