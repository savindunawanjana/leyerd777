package edu.lk.ijse.projectgym.demo76promax.Controller;

import edu.lk.ijse.projectgym.demo76promax.Dtos.employePaymentDto;

import edu.lk.ijse.projectgym.demo76promax.bo.BOFactory;
import edu.lk.ijse.projectgym.demo76promax.bo.BOTypes;
import edu.lk.ijse.projectgym.demo76promax.bo.Custom.EmployeePaymentmanegementBO;
import edu.lk.ijse.projectgym.demo76promax.bo.Custom.UsermanegeBO;
import edu.lk.ijse.projectgym.demo76promax.dao.DAOFactory;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.EmployeePaymentsDAO;
import edu.lk.ijse.projectgym.demo76promax.dao.util.DAOTipes;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class EmployePayments implements Initializable {

  //  private Registetionmodal registModel = new Registetionmodal();
    // private employePaymentDto employePaymentDto = new employePaymentDto();
   // private employePaymentModal employePaymentModal = new employePaymentModal();
  private EmployeePaymentmanegementBO employeePaymentmanegementBO = BOFactory.getInstance().getBOTypes(BOTypes.EMPLOYEEPAYMENTS);
    private UsermanegeBO systemusermanegeBo = BOFactory.getInstance().getBOTypes(BOTypes.USERMANEGE);

    public AnchorPane anchorPane;
    public TextField txtsalaryId;
    public TextField txteRolleId;
    public TextField txtemployId;
    public Button btnsave;
    public Label lblemployeShow;
    public Button btnsearch;

    public void on_buttenSerch_action(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        String rsp = employeePaymentmanegementBO.searchEmployeePaymentsById(txtemployId.getText());
        System.out.println(rsp + " <--");
        lblemployeShow.setText(rsp);

    }


    public void textfildclearmethod() {

        txtsalaryId.clear();
        txteRolleId.clear();
        txtemployId.clear();


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            employeePaymentmanegementBO.searchEmployeePaymentsById(txtemployId.getText());
        } catch (Exception e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
        }

    }

    public void on_butten_save_action(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        String system_user_Id = loginManeger.arry[0];
        String Useroll = systemusermanegeBo.getuserRollmethod(system_user_Id);
        LocalDate currentDate = LocalDate.now();
        String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        employePaymentDto employdto = new employePaymentDto(

                Useroll,
                txtemployId.getText(),
                txteRolleId.getText(),
                formattedDate,

                Double.parseDouble(txtsalaryId.getText())


        );

        String information = employeePaymentmanegementBO.saveMethod1(employdto);
        Alert alert = new  Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setContentText(information);
        alert.show();
        textfildclearmethod();


    }

}
