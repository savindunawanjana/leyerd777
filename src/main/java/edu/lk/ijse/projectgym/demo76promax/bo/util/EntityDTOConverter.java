package edu.lk.ijse.projectgym.demo76promax.bo.util;


import edu.lk.ijse.projectgym.demo76promax.Dtos.EmployeDto;
import edu.lk.ijse.projectgym.demo76promax.Dtos.EmployeeDataDto;
import edu.lk.ijse.projectgym.demo76promax.Dtos.employePaymentDto;
import edu.lk.ijse.projectgym.demo76promax.entity.Coach;
import edu.lk.ijse.projectgym.demo76promax.entity.EmployeePayments;
import edu.lk.ijse.projectgym.demo76promax.entity.EmployeeTable;
import edu.lk.ijse.projectgym.demo76promax.entity.Worker;

import java.sql.Date;

public class EntityDTOConverter {
    //modalmap

    public EmployeDto getCoachDto(Coach coach) {

        EmployeDto dto = new EmployeDto(
                coach.getCoachId(),
                coach.getName(),
              coach.getContactNumber(),
                coach.getSystemUserRole(),
                coach.getAddDate(),
            coach.getEmail()

        );

        return dto;

    }


    public Coach getCoachEntity(EmployeDto dto) {

        Coach coach = new Coach(
                dto.getEmployeeId(),
                dto.getName(),
                dto.getCnumber(),
                dto.getSystemUserId(),
                dto.getDate(),
                dto.getEmail()
        );
        return coach;
    }
// / /////////////////////////////////////////////////////////////////////

        public EmployeDto getWorkerDtos(Worker worker) {

            EmployeDto dto = new EmployeDto(
                    worker.getWorkerId(),
                    worker.getName(),
                    worker.getContactNumber(),
                    worker.getSystemUserRole(),
                    worker.getAddDate(),
                    worker.getEmail()
            );

            return dto;

        }


        public Worker getworkerEntity(EmployeDto dto) {
            Worker worker = new Worker(
                    dto.getEmployeeId(),
                    dto.getName(),
                    dto.getCnumber(),
                    dto.getSystemUserId(),
                    (Date) dto.getDate(),
                    dto.getEmail()
            );
            return worker;
        }


        public EmployeeTable getEntytyemp(EmployeeDataDto employeeDataDto){

            EmployeeTable employeeTable =new EmployeeTable(

                    employeeDataDto.getId(),
                    employeeDataDto.getName(),
                    employeeDataDto.getNumber(),
                    employeeDataDto.getRole(),
                    employeeDataDto.getEmail()

            );
        return employeeTable;

        }


    public EmployeeDataDto  getDtoemp(EmployeeTable employeeTable){

        EmployeeDataDto employeeDataDto = new EmployeeDataDto(

                employeeTable.getEmployeeId(),
                employeeTable.getEmployeeName(),
                employeeTable.getEmployeeContact(),
                employeeTable.getEmployeeRole(),
                employeeTable.getEmployeeEmail()
        );


        return employeeDataDto;

    }

     public employePaymentDto getemployeepaymentDto(EmployeePayments employeePayments){

         employePaymentDto employePaymentDto = new employePaymentDto();
         employePaymentDto.setSystem_user_id(employeePayments.getSystemUserRoll());
         employePaymentDto.setEmployee_roll(employeePayments.getEmployeeRole());
         employePaymentDto.setEmployee_Id(employeePayments.getEmployeeId());
         employePaymentDto.setDate(String.valueOf(employeePayments.getPaymentDate()));
         employePaymentDto.setSalary(employeePayments.getSalary());

          return employePaymentDto;


     }

    public EmployeePayments getemployeepaymentEntyty(employePaymentDto employeepaymentDto){

        EmployeePayments employeePayments = new EmployeePayments(

                employeepaymentDto.getSystem_user_id(),
                employeepaymentDto.getEmployee_roll(),
                employeepaymentDto.getEmployee_Id(),
                employeepaymentDto.getDate(),
                employeepaymentDto.getSalary()
        );


        return employeePayments;

    }



}
