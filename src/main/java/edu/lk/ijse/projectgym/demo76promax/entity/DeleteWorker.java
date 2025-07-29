package edu.lk.ijse.projectgym.demo76promax.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.Text;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class DeleteWorker {
    private int deleteId;
    private String workerId;
    private String workername;
    private String deleteDate;
    private String SystemUserId;
    private Text ResonTodelete;
}
