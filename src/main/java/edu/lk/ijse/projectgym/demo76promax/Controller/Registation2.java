package edu.lk.ijse.projectgym.demo76promax.Controller;//package edu.lk.ijse.projectgym.demo76promax.Controller;
//
//import edu.lk.ijse.projectgym.demo76promax.Dtos.SystemUser;
//import edu.lk.ijse.projectgym.demo76promax.Modal.Registetionmodal;
//import edu.lk.ijse.projectgym.demo76promax.bo.BOFactory;
//import edu.lk.ijse.projectgym.demo76promax.bo.BOTypes;
//import edu.lk.ijse.projectgym.demo76promax.bo.Custom.UsermanegeBO;
//import edu.lk.ijse.projectgym.demo76promax.dao.DAOFactory;
//import edu.lk.ijse.projectgym.demo76promax.dao.custom.SystemuserDAO;
//import edu.lk.ijse.projectgym.demo76promax.dao.util.DAOTipes;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.Alert;
//import javafx.scene.control.ButtonType;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.AnchorPane;
//import javafx.stage.Stage;
//
//import java.sql.SQLException;
//
//public class Registation2 {
//    private UsermanegeBO usermanegeBO = BOFactory.getInstance().getBOTypes(BOTypes.USERMANEGE);
//
//    private Registetionmodal registetionmodal;
//    private SystemUser systemUser;
//
//    @FXML
//    public AnchorPane ancpaneRegistation;
//    @FXML
//    public TextField textfildUserPassword;
//
//    @FXML
//    public TextField textfildUserName;
//
//    @FXML
//    public TextField textfildUserRoll;
//
//    @FXML
//    public TextField textfildUserNumber;
//
//    @FXML
//    public TextField textfildUserid;
//
//
//    public Registation2() {
//
//
//        registetionmodal = new Registetionmodal();
//
//    }
//
//    public void textfildUseridAction(ActionEvent actionEvent) {
//
//
//    }
//
//    public void textfildUserPasswordAction(ActionEvent actionEvent) {
//
//
//    }
//
//    public void textfildUserRollAction(ActionEvent actionEvent) {
//
//    }
//
//    public void textfildUserNameAction(ActionEvent actionEvent) {
//
//    }
//
//    public void textfildUserNumberAction(ActionEvent actionEvent) {
//
//    }
//
//    public void createNewMember() throws SQLException, ClassNotFoundException {
//
//        if (textfildUserid.getText() == null || textfildUserid.getText().trim().isEmpty() || textfildUserPassword.getText() == null || textfildUserPassword.getText().trim().isEmpty() || textfildUserRoll.getText() == null || textfildUserRoll.getText().trim().isEmpty() || textfildUserName.getText() == null || textfildUserName.getText().trim().isEmpty() || textfildUserNumber.getText() == null || textfildUserNumber.getText().trim().isEmpty()) {
//            System.out.println(" some textfild is null or empty");
//            new Alert(Alert.AlertType.ERROR, "some textfild is null or empty", ButtonType.OK).show();
//            //e.printStackTrace();
//
//        } else {
//
//            String userId1 = textfildUserid.getText();
//            String userPassword1 = textfildUserPassword.getText();
//            String userRoll1 = textfildUserRoll.getText();
//            String userName1 = textfildUserName.getText();
//            String userNumber1 = textfildUserNumber.getText();
//
//            SystemUser systemUser = new SystemUser(userId1, userPassword1, userRoll1, userName1, userNumber1);
//            usermanegeBO.save(systemUser);
//        }
//
//    }
//
//    public void clickRegistretionButtenAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
//
//
//        createNewMember();
//
//    }
//
//}
