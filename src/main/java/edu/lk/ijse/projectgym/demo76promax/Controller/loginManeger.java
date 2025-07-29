package edu.lk.ijse.projectgym.demo76promax.Controller;

import edu.lk.ijse.projectgym.demo76promax.Dtos.SystemUser;
import edu.lk.ijse.projectgym.demo76promax.bo.BOFactory;
import edu.lk.ijse.projectgym.demo76promax.bo.BOTypes;
import edu.lk.ijse.projectgym.demo76promax.bo.Custom.UserdeatilesmenuBO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class loginManeger implements Initializable {

    public static String arry[] = new String[1];
    public Button btnLogin;
    public AnchorPane Anchorpane;
    public TextField txtPassworsd;

    //private ownerLoginModel ownerLoginModel;//<-----------------------------------me wenuwata BO use kara
    private UserdeatilesmenuBO userdeatilesmenuBO = BOFactory.getInstance().getBOTypes(BOTypes.USERDEATILESPAGE);

    public loginManeger() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void ON_action__btn(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
        ArrayList<SystemUser> cachobjectList = (ArrayList<SystemUser>) userdeatilesmenuBO.getuserinformation();

        String textpassword = txtPassworsd.getText();
        arry[0] = textpassword;
        int p = 0;
        for (int i = 0; i < cachobjectList.size(); i++) {

            SystemUser systemUser = cachobjectList.get(i);
            String databases_password = systemUser.getUser_password();

            if (textpassword.equals(databases_password)) {

                Anchorpane.getChildren().clear();
                Parent parent = FXMLLoader.load(getClass().getResource("/View/Dashbord.fxml"));
                Anchorpane.getChildren().add(parent);
                return;
            } else {

                p = 1;
            }
        }

        if (p == 1) {
            new Alert(Alert.AlertType.ERROR, "This is a wrong password.", ButtonType.OK).show();
            txtPassworsd.setText("");
        }

    }

    public void ON_KEY_PRES_LOGIN(KeyEvent keyEvent) {


    }
}
