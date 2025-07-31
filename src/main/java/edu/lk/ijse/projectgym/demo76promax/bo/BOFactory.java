package edu.lk.ijse.projectgym.demo76promax.bo;

import edu.lk.ijse.projectgym.demo76promax.bo.Custom.impl.*;

import static edu.lk.ijse.projectgym.demo76promax.bo.BOTypes.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {


    }

    public static BOFactory getInstance() {

        return boFactory == null ? boFactory = new BOFactory() : boFactory;

    }

    public <T extends SuperBO> T getBOTypes(BOTypes botypes) {

        return switch (botypes) {
            case SAVECOACH -> (T) new CoachsaveBOimpl();
            case CUSTORMERDEATILESMENU -> (T) new CustomerDetailsMenuBOImpl();
            case SAVECLEANER -> (T) new ClenerSaveBOimpl();
//            case ADDITEMS -> (T) new AdditemsBOImpl();
//            case ADDSUPLAYERS -> (T) new AddsuplayersBOImpl();
            case CUSTORMERMANEGE -> (T)new CustormerManegeBOImpl();
           case CUSTORMERDORPAYMENTS -> (T) new CustormerpaymentBOImpl();
//            case DASHBORD -> (T) new DashboardBOImpl();
           case DELETECLENER -> (T) new ClenerdeleteBOimpl();
            case DELETECOACH -> (T) new CoachdeleteBOimpl();
//            case EDITEOTOJENARETMASSEGE -> (T) new EditAutoGenerateMessageBOImpl();
//            case EMPLOYEEATENDENS -> (T) new EmployeeAttendanceBOImpl();
            case EMPLOYEEDATAFROMATABLE -> (T) new EmployedeatilesmanegementBOimpl();
           case EMPLOYEEPAYMENTS -> (T) new EmployeePaymentmanegementBOimpl();
//            case EMPLOYEEPAGEDEATILES -> (T) new EmployeePageDetailsBOImpl();
            case EMPLOYEEMANEGEFIRSTPAGE -> (T) new EmployeeManegeFirstpageBOimpl();
//            case INVENTORYPAGE -> (T) new InventoryPageBOImpl();
//            case LOGINFORSYSTEM -> (T) new LoginForSystemBOImpl();
//            case LOGINMANEGER -> (T) new LoginManagerBOImpl();
//            case LOGIMNOWNER -> (T) new LoginOwnerBOImpl();
//            case MANEGEEXSAIS -> (T) new ManageExerciseBOImpl();
//            case MANEGERLOGIN -> (T) new ManagerLoginBOImpl();
//            case MONTHLYMASSEGESENDPAGE -> (T) new MonthlyMessageSendPageBOImpl();
//            case MONTHLYRIPORTPAGE -> (T) new MonthlyReportPageBOImpl();
//            case ODERPAGE -> (T) new OrderPageBOImpl();
//            case OWNERANDADMINLOGINPAGE -> (T) new OwnerAndAdminLoginPageBOImpl();
//            case SENDMASSEGEPAGE -> (T) new SendMessagePageBOImpl();
//            case SENDSHEDULTOCUSTORMER -> (T) new SendScheduleToCustomerBOImpl();
            case USERDEATILESPAGE -> (T) new UserdeatilesmenuBOImpl();
            case USERDORPASWORD -> (T) new UserDoorPwuiBOImpl();
              case USERMANEGE -> (T) new UsermanegeBOImpl();

        };


    }

}
