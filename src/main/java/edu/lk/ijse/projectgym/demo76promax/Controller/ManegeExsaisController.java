package edu.lk.ijse.projectgym.demo76promax.Controller;



import edu.lk.ijse.projectgym.demo76promax.Dtos.tm.ExsaisTm;
//import edu.lk.ijse.projectgym.demo76promax.Modal.ExsasaisModel;
import edu.lk.ijse.projectgym.demo76promax.bo.BOFactory;
import edu.lk.ijse.projectgym.demo76promax.bo.BOTypes;
import edu.lk.ijse.projectgym.demo76promax.bo.Custom.ExsasaisdeatilesBo;
import edu.lk.ijse.projectgym.demo76promax.bo.Custom.UsermanegeBO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ManegeExsaisController implements Initializable {
    //private SystemuserDAO systemuserDAO = DAOFactory.getInstance().getDao(DAOTipes.SYSTEMUSER);
    private UsermanegeBO systemusermanegeBo = BOFactory.getInstance().getBOTypes(BOTypes.USERMANEGE);
    private static ExsasaisdeatilesBo exsasaisdeatilesBo = BOFactory.getInstance().getBOTypes(BOTypes.MANEGEEXSAIS);
   // private Registetionmodal registetionmodal = new Registetionmodal();
   // private ExsasaisModel exsasaisModel = new ExsasaisModel();
    public AnchorPane AnchorPane;
    public TextField txtExercisId;
    public TextField txtCategory;
    public TextField textexsaisName;
    public Button btnAdd;
    public Button btnUpdate;
    public Button btnDelete;
    public TableView tblExercises;

    @FXML
    private TableColumn<ExsaisTm,Integer>colId;

    @FXML
    private TableColumn<ExsaisTm,String>colName;

    @FXML
    private TableColumn<ExsaisTm,String>colSystemUser;

    @FXML
    private TableColumn<ExsaisTm,String>colCategory;

    @FXML
    private TableColumn<ExsaisTm,String>colAddedDate;

    public ManegeExsaisController() throws SQLException, ClassNotFoundException {



    }

    public void lodeMethod() throws SQLException, ClassNotFoundException {

        ObservableList<ExsaisTm> observableList = FXCollections.observableArrayList(exsasaisdeatilesBo.getAll());
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("exsaisName"));
        colSystemUser.setCellValueFactory(new PropertyValueFactory<>("systemUserRoll"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("exsaisCategory"));
        colAddedDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        tblExercises.setItems(observableList);

    }

    public void btnAddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {


        try {
            String cach = loginManeger.arry[0];
            String id = systemusermanegeBo.getuserId(cach);
            System.out.println(id);
//            ExsaisDto dto = new ExsaisDto(Integer.parseInt(txtExercisId.getText()), textexsaisName.getText(), txtCategory.getText(),id);

            LocalDateTime localDateTime = LocalDateTime.now();
            Timestamp timestamp = Timestamp.valueOf(localDateTime);

            ExsaisTm exsaisTm= new ExsaisTm(
                    Integer.parseInt(txtExercisId.getText()),
                    textexsaisName.getText(),
                    txtCategory.getText(),
                    timestamp,
                    id
            );

            Boolean rsp = exsasaisdeatilesBo.save(exsaisTm);
            lodeMethod();
          String cach1 = (rsp== true) ? "Saved Sucsess fully":"Saved Unsucsess fully !";

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(cach1);
            alert.show();

        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        try {
            String cach = loginManeger.arry[0];
            String id = systemusermanegeBo.getuserId(cach);
            System.out.println(id);
          //  ExsaisDto dto = new ExsaisDto(Integer.parseInt(txtExercisId.getText()), textexsaisName.getText(), txtCategory.getText(), id);

//            //String textFieldValue = "2025-07-31 14:30:00";
//
//            // Step 1: Define format (must match the input string format)
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//            // Step 2: Parse to LocalDateTime
//            LocalDateTime localDateTime = LocalDateTime.parse(textFieldValue, formatter);
//
//            // Step 3: Convert to java.sql.Timestamp
//            Timestamp timestamp = Timestamp.valueOf(localDateTime);

            LocalDateTime localDateTime = LocalDateTime.now();
            Timestamp timestamp = Timestamp.valueOf(localDateTime);

            ExsaisTm exsaisTm= new ExsaisTm(
                    Integer.parseInt(txtExercisId.getText()),
                    textexsaisName.getText(),
                    txtCategory.getText(),
                    timestamp,
                    id
            );
            Boolean rsp = exsasaisdeatilesBo.update(exsaisTm);
            lodeMethod();
            String cach1 = (rsp== true) ? "Update Sucsess fully":"Update Unsucsess fully !";
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(cach1);
            alert.show();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {

        try {
            String id = txtExercisId.getText();
            Boolean rsp = exsasaisdeatilesBo.delete(id);
            lodeMethod();

            String cach1 = (rsp== true) ? "Delete Sucsess fully":"Delete Unsucsess fully !";
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(cach1);
            alert.show();


        } catch (Exception e) {

            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            // alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();

        }

    }

    public void On_mouse_clicked(MouseEvent mouseEvent) {

        //==================================importation=================
        ExsaisTm tm = (ExsaisTm) tblExercises.getSelectionModel().getSelectedItem();
        if (tm != null) {
            txtExercisId.setText(String.valueOf(tm.getId()));
            textexsaisName.setText(tm.getExsaisName());
            txtCategory.setText(tm.getExsaisCategory());
        }

        btnUpdate.setDisable(false);
        btnDelete.setDisable(false);
        //==================================importation=================

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btnAdd.setDisable(false);
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);



        try {
            lodeMethod();
        } catch (SQLException e) {
           e.printStackTrace();
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }

    }
}
