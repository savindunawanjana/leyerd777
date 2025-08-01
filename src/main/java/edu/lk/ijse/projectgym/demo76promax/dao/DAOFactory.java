package edu.lk.ijse.projectgym.demo76promax.dao;

import edu.lk.ijse.projectgym.demo76promax.dao.custom.impl.*;
import edu.lk.ijse.projectgym.demo76promax.dao.util.DAOTipes;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){
        
    }

    public static DAOFactory getInstance(){
        return daoFactory == null ? daoFactory= new DAOFactory():daoFactory;

    }


    public  <T extends SuperDAO>T getDao(DAOTipes daoTipes){

     return switch (daoTipes) {
            case ADDITIONALLEAVECOACH ->(T) new AdditionalLeaveCoachDAOImpl();
            case ADDITIONALLEAVEWORKER->(T) new AdditionalLeaveWorkerDAOImpl();
            case COACH->(T) new CoachDAOImpl();
            case COMMONPASSWORD->(T)new ComanpassworDAOimpl();
            case CUSTOMER->(T) new CustormerDAOImpl();
            case CUSTOMERPAYMENT->(T) new CusormerPaymentsDAOImpl();
           case DELETECOACH->(T) new DeletecoachDAOImpl();
         case DELETEWORKER->(T) new DeleteworkerDAOImpl();
            case EDITOTOGENERATMESSEGE->(T) new EditOtoGenerateMessageDAOImpl();
            case EMPLOYEEATTENDANCE->(T) new EmployeeAtendensDAOImpl();
            case EMPLOYEEPAYMENTS->(T) new EmployeePaymentsDAOImpl();
            case EMPLOYEETABLE->(T) new EmplaoyTableDAOImpl();
            case ITEMS->(T) new ItemDAOImpl();
            case LABLE->(T) new LableDAOImpl();
            case MANEGEEXERCISE->(T) new ManegeexsersaisDAOImpl();
         case SENDSHEDULTOCUSTOMER->(T) new SendshedultocustormerDAOImpl();
            case MONTHLYRIPORT->(T) new MonthlyriportDAOImpl();
            case MONTHLYSUMERY->(T) new MonthlysummeryDAOImpl();
            case ODERDEATILES->(T) new OderdeatilesDAOImpl();
            case ODERS->(T) new OdersDAOImpl();
            case SUPPLIERS->(T) new SuplayersDAOImpl();
            case SYSTEMUSER->(T) new SystemuserDAOImpl();
         //   case SYSTEMUSERADDITIONALLEAVE: return new SystemuseradditinolliveDAOImpl();
           // case SYSTEMUSERDALETE: return new systemuserdeleteDAOImpl();
         case SYSTEMUSERADDITIONALLEAVE -> null;
         case SYSTEMUSERDALETE -> null;
         case WORKER->(T) new WorkerDAOImpl();
        };


    }
}
