package edu.lk.ijse.projectgym.demo76promax.Controller;

import edu.lk.ijse.projectgym.demo76promax.Dtos.EmployeDto;
import edu.lk.ijse.projectgym.demo76promax.Modal.EmployeModal;
import edu.lk.ijse.projectgym.demo76promax.bo.BOFactory;
import edu.lk.ijse.projectgym.demo76promax.bo.BOTypes;
import edu.lk.ijse.projectgym.demo76promax.bo.Custom.EmployeeManegeFirstpageBO;
import edu.lk.ijse.projectgym.demo76promax.dao.custom.CoachDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class EmploypageController  implements Initializable {

    public AnchorPane anchorpane;
    public Label lblCleanersCount1;
    public Label lblCochesCount1;


    @FXML
    private TableColumn<EmployeDto, String> colamCleanerId;

    @FXML
    private TableColumn<EmployeDto, String> colamCleanerName;

    @FXML
    private TableColumn<EmployeDto, String> colamCleanerNumber;

    @FXML
    private TableColumn<EmployeDto, String> colamCleanerSystemuser;

    @FXML
    private TableColumn<EmployeDto, String> colamCleanerEmail;

    @FXML
    private TableView<EmployeDto> tableCleaners;

    //============================================



    @FXML
    private TableView<EmployeDto> tableCoach;

    @FXML
    private TableColumn<EmployeDto, String> colamCochId;

    @FXML
    private TableColumn<EmployeDto, String> colamCoachSystemUser;

    @FXML
    private TableColumn<EmployeDto, String> colamCochEmail;

    @FXML
    private TableColumn<EmployeDto, String> colamCoachName;

    @FXML
    private TableColumn<EmployeDto, String> colamCochNumber;
   // private EmployeModal empModal=new EmployeModal();
    private EmployeeManegeFirstpageBO employeeManegeFirstpageBO=BOFactory.getInstance().getBOTypes(BOTypes.EMPLOYEEMANEGEFIRSTPAGE);

    public void loadCoachTable() throws SQLException, ClassNotFoundException {

        List<EmployeDto> coacheslist = employeeManegeFirstpageBO.getcoachdata();
        ObservableList<EmployeDto> coaches= FXCollections.observableArrayList(coacheslist);

        colamCochId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        colamCoachName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colamCochNumber.setCellValueFactory(new PropertyValueFactory<>("cnumber"));
        colamCoachSystemUser.setCellValueFactory(new PropertyValueFactory<>("systemUserId"));
        colamCochEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        tableCoach.setItems(coaches);

    }

    public void loadCleanerTable() throws SQLException, ClassNotFoundException {

       //
                List<EmployeDto> wokerslist =employeeManegeFirstpageBO.getworkerdata();
        ObservableList<EmployeDto>cleaner =FXCollections.observableArrayList(wokerslist);
        colamCleanerId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        colamCleanerName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colamCleanerNumber.setCellValueFactory(new PropertyValueFactory<>("cnumber"));
        colamCleanerSystemuser.setCellValueFactory(new PropertyValueFactory<>("systemUserId"));
        colamCleanerEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        System.out.println("hellooooo//");

        tableCleaners.setItems(cleaner);


    }
     public void setEmployeeCountTotheLable() throws SQLException, ClassNotFoundException {


         lblCochesCount1.setText(String.valueOf(employeeManegeFirstpageBO.setlableCoachCount()));
         lblCleanersCount1.setText(String.valueOf(employeeManegeFirstpageBO.setlableCleanerCount()));




     }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {

            loadCoachTable();
            loadCleanerTable();
            setEmployeeCountTotheLable();

        } catch (Exception e) {

            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error  " + " 👈");
            alert.setTitle(e.getMessage());
            alert.showAndWait();


        }


    }


}
