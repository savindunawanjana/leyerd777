package edu.lk.ijse.projectgym.demo76promax.bo.util;


import edu.lk.ijse.projectgym.demo76promax.Dtos.EmployeDto;
import edu.lk.ijse.projectgym.demo76promax.entity.Coach;
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
        System.out.println("//////////////////////////////////hallo/////////////");
       // System.out.println( (Date) dto.getDate());
        System.out.println(dto.getDate());
        System.out.println("/////////////////////////////////halll//////////////");

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
}
