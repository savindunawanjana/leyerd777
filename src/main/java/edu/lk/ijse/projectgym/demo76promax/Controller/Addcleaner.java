package edu.lk.ijse.projectgym.demo76promax.Controller;

import edu.lk.ijse.projectgym.demo76promax.Dtos.EmployeDto;
import edu.lk.ijse.projectgym.demo76promax.Modal.EmployeModal;
import edu.lk.ijse.projectgym.demo76promax.Modal.EmployeedataModel;
import edu.lk.ijse.projectgym.demo76promax.bo.BOFactory;
import edu.lk.ijse.projectgym.demo76promax.bo.BOTypes;
import edu.lk.ijse.projectgym.demo76promax.bo.Custom.ClenerSaveBO;
import edu.lk.ijse.projectgym.demo76promax.bo.Custom.UsermanegeBO;
import edu.lk.ijse.projectgym.demo76promax.dao.util.Publicforcoachandclener;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;

public class Addcleaner implements Initializable {
    private EmployeDto employeDto;

private ClenerSaveBO clenerSaveBO = BOFactory.getInstance().getBOTypes(BOTypes.SAVECLEANER);
    private final String idPattern = "^W.*$";
    private final String nicPattern = "^[0-9]{9}[vVxX]||[0-9]{12}$";
    private final String emailPattern = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    private final String phonePattern = "^(\\d+)||((\\d+\\.)(\\d){2})$";

    public AnchorPane Anchorpane;
    public TextField cleanerId;
    public TextField emailaddress;
    public TextField poneNumber;
    public TextField cleaner_name;
    public Button butten;
    private UsermanegeBO usermanegeBO = BOFactory.getInstance().getBOTypes(BOTypes.USERMANEGE);

    public void saveMethod() throws SQLException, ClassNotFoundException {
        String id = cleanerId.getText();
        String email = emailaddress.getText();
        String phone = poneNumber.getText();
        String name = cleaner_name.getText();

        boolean isvalidid = id.matches(idPattern);
        boolean isValidEmail = email.matches(emailPattern);
        boolean isValidPhone = phone.matches(phonePattern);
        boolean isValidName = !name.isEmpty();

        cleanerId.setStyle("-fx-border-color: green;");
        emailaddress.setStyle("-fx-border-color: green;");
        poneNumber.setStyle("-fx-border-color: green;");
        cleaner_name.setStyle("-fx-border-color: green;");

        if (!isvalidid) {
            cleanerId.setStyle("-fx-border-color: red;");
        }
        if (!isValidEmail) {
            emailaddress.setStyle("-fx-border-color: red;");
        }
        if (!isValidPhone) {
            poneNumber.setStyle("-fx-border-color: red;");
        }
        if (!isValidName) {
            cleaner_name.setStyle("-fx-border-color: red;");
        }

        Publicforcoachandclener.shouldBeRunThisMethod();
        String system_user_Id = loginManeger.arry[0];
        String useroll = usermanegeBO.getuserRollmethod(system_user_Id);
        LocalDate localDate = LocalDate.now();
        java.sql.Date sqlDate = Date.valueOf(localDate);

        employeDto = new EmployeDto(
                cleanerId.getText(),
                cleaner_name.getText(),
                poneNumber.getText(),
                useroll,
                sqlDate,
                emailaddress.getText());

        if (isvalidid && isValidEmail && isValidPhone && isValidName) {
            String cachrsp = clenerSaveBO.saveWorker(employeDto);
            new Alert(Alert.AlertType.INFORMATION, cachrsp).show();
        }
        //else {
//            new Alert(Alert.AlertType.ERROR, "Please check the highlighted fields").show();
//        }
    }

    public void butten_on_action(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
                Publicforcoachandclener.shouldBeRunThisMethod();
        saveMethod();
        cleanerId.clear();
        emailaddress.clear();
        poneNumber.clear();
        cleaner_name.clear();
    }

    public void on_mouse_click(MouseEvent mouseEvent) {
        navigeteto("/View/DeleteClener.fxml");
    }

    private void navigeteto(String path) {
        try {
            Anchorpane.getChildren().clear();
            AnchorPane parent = FXMLLoader.load(getClass().getResource(path));
            parent.prefWidthProperty().bind(Anchorpane.widthProperty());
            parent.prefHeightProperty().bind(Anchorpane.heightProperty());
            Anchorpane.getChildren().add(parent);
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Page Note Found", ButtonType.OK).show();
            e.printStackTrace();
        }
    }

    public void on_key_presd(KeyEvent keyEvent) throws SQLException, ClassNotFoundException {

        Publicforcoachandclener.shouldBeRunThisMethod();
        System.out.println("Key pressed: " + keyEvent.getCode());
        if (keyEvent.getCode() == KeyCode.ENTER) {
            saveMethod();
            cleanerId.clear();
            emailaddress.clear();
            poneNumber.clear();
            cleaner_name.clear();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        javafx.application.Platform.runLater(() -> {
            try {

                Publicforcoachandclener.shouldBeRunThisMethod();
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }
}