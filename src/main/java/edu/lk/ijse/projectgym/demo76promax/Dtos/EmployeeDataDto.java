package edu.lk.ijse.projectgym.demo76promax.Dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeDataDto {

    private String id;
    private String name;
    private String number;
    private String role ;
    private String email;

//    public EmployeeDataDto (String employeeId,String name, String number, String rolle, String email) {
//
//       this.id=employeeId;
//       this.name=name;
//       this.number=number;
//       this.role=rolle;
//       this.email=email;
//    }
//

    public EmployeeDataDto (String employeeId, String rolle, String name) {

        this.id = employeeId;
        this.role = rolle;
        this.name= name;
    }



}
