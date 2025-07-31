package edu.lk.ijse.projectgym.demo76promax.Controller;

import edu.lk.ijse.projectgym.demo76promax.Dtos.EmployeeDataDto;
//import edu.lk.ijse.projectgym.demo76promax.Modal.EmployeModal;
import edu.lk.ijse.projectgym.demo76promax.bo.BOFactory;
import edu.lk.ijse.projectgym.demo76promax.bo.BOTypes;
import edu.lk.ijse.projectgym.demo76promax.bo.Custom.EmployedeatilesmanegementBO;
import edu.lk.ijse.projectgym.demo76promax.dao.util.Publicforcoachandclener;
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

public class EmployeedatafromtableController  implements Initializable {


    public AnchorPane anchorpane;
    public TableView tableView;

    @FXML
    private TableColumn<EmployeeDataDto,String>colId;
    @FXML
    private TableColumn<EmployeeDataDto, String>colname;
    @FXML
    private TableColumn<EmployeeDataDto, String>colNumber;
    @FXML
    private TableColumn<EmployeeDataDto, String>collEmail;
    @FXML
    private TableColumn<EmployeeDataDto, String>colJobroll;

    public Label lblCoachCount;
    public Label lblCleanerCount;
    public Label lbltodayIsCoachCome;
    public Label lbltodayIsCleanerCome;
  //s  private  EmployeModal employeedataModal=new EmployeModal();
//private EmployeedataModel  employeedataModel=new EmployeedataModel();
private EmployedeatilesmanegementBO employedeatilesmanegementBO = BOFactory.getInstance().getBOTypes(BOTypes.EMPLOYEEDATAFROMATABLE);

    public void lodetable() throws SQLException, ClassNotFoundException {

//            ObservableList<EmployeeDataDto> list =
                         List<EmployeeDataDto> employeeDataDtoList =employedeatilesmanegementBO.getallMethod();
                         ObservableList<EmployeeDataDto> list = FXCollections.observableArrayList(employeeDataDtoList);
            colId.setCellValueFactory(new PropertyValueFactory<>("id"));
            colname.setCellValueFactory(new PropertyValueFactory<>("name"));
            colNumber.setCellValueFactory(new PropertyValueFactory<>("number"));
            collEmail.setCellValueFactory(new PropertyValueFactory<>("role"));
            colJobroll.setCellValueFactory(new PropertyValueFactory<>("email"));
            tableView.setItems(list);

        }

        public void setlableMethod() throws SQLException, ClassNotFoundException {


            String coachCount = String.valueOf(employedeatilesmanegementBO.setlableCoachCount());
            String cleaner = String.valueOf(employedeatilesmanegementBO.setlableCleanerCount());
            lblCoachCount.setText(coachCount);
            lblCleanerCount.setText(cleaner);

        }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            setlableMethod();
          //  employeedataModel
            Publicforcoachandclener.shouldBeRunThisMethod();
            lodetable();
        } catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.show();
            System.out.println("Error loading employee table: " + e.getMessage());
        }

    }
}