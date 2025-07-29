package edu.lk.ijse.projectgym.demo76promax.Controller;

import edu.lk.ijse.projectgym.demo76promax.Dtos.memberPaymentDto;
import edu.lk.ijse.projectgym.demo76promax.bo.BOFactory;
import edu.lk.ijse.projectgym.demo76promax.bo.BOTypes;
import edu.lk.ijse.projectgym.demo76promax.bo.Custom.CustormerpaymentBO;
import edu.lk.ijse.projectgym.demo76promax.bo.Custom.UsermanegeBO;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CustormerDorrPaymentController implements Initializable {
    private UsermanegeBO usermanegeBO = BOFactory.getInstance().getBOTypes(BOTypes.USERMANEGE);

    public AnchorPane anchorpaneid;
    public TextField textCustormerId;
    public Button buttenId;
    public TextField txtpaymentsId;
    public TextField txtNumberofMonthValidId;

   // private Registetionmodal rmodel = new Registetionmodal();
    // private MemberpaymentModal memberPaymentmodel = new MemberpaymentModal();
    private CustormerpaymentBO custormerpaymentBO = BOFactory.getInstance().getBOTypes(BOTypes.CUSTORMERDORPAYMENTS);

    public void OnButtenAction(ActionEvent actionEvent) {
        String customerId = textCustormerId.getText().trim();
        String mathlypayment = txtpaymentsId.getText().trim();
        String numberOfMonth = txtNumberofMonthValidId.getText().trim();


        if (customerId.isEmpty() || mathlypayment.isEmpty() || numberOfMonth.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "කරුණාකර සියලුම අවශ්‍ය තොරතුරු ඇතුළත් කරන්න!", ButtonType.OK).show();
            return;
        }

        try {

            double payment = Double.parseDouble(mathlypayment);
            int monthCount = Integer.parseInt(numberOfMonth);

            LocalDate today = LocalDate.now();
            String date_now = today.toString();
            LocalDate newDate = today.plusMonths(monthCount);
            String expayeDate = newDate.toString();

            String system_user_Id = loginManeger.arry[0];
            String user_Roll = usermanegeBO.getuserRollmethod(system_user_Id);
            System.out.println(user_Roll);
            memberPaymentDto dto = new memberPaymentDto(
                    customerId,
                    expayeDate,
                    monthCount,
                    user_Roll,
                    date_now,
                    payment
            );


            String resultMessage = custormerpaymentBO.save(dto);
            new Alert(Alert.AlertType.INFORMATION, resultMessage, ButtonType.OK).show();

            String cach = custormerpaymentBO.deleteLowerPaymentIdsPerCustomer();
            clearMethod();

        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "there is no such Custormer Id ", ButtonType.OK).show();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, " Error " + e.getMessage(), ButtonType.OK).show();
        }
    }

    public void clearMethod() {

        txtpaymentsId.clear();
        txtNumberofMonthValidId.clear();
        textCustormerId.clear();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            String cach = custormerpaymentBO.deleteLowerPaymentIdsPerCustomer();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
