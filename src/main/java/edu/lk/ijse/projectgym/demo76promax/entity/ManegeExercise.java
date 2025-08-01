package edu.lk.ijse.projectgym.demo76promax.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ManegeExercise {

    private int exerciseId;
    private String exerciseName;
    private String category;
    private Timestamp addDate;
    private String SystemUserId;
}
