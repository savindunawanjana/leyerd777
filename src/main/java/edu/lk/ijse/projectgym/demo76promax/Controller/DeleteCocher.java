package edu.lk.ijse.projectgym.demo76promax.Controller;

import edu.lk.ijse.projectgym.demo76promax.Dtos.EmployeDto;
//import edu.lk.ijse.projectgym.demo76promax.Modal.EmployeModal;

import edu.lk.ijse.projectgym.demo76promax.bo.BOFactory;
import edu.lk.ijse.projectgym.demo76promax.bo.BOTypes;
import edu.lk.ijse.projectgym.demo76promax.bo.Custom.CoachdeleteBO;
import edu.lk.ijse.projectgym.demo76promax.bo.Custom.EmployeeManegeFirstpageBO;
import edu.lk.ijse.projectgym.demo76promax.dao.util.Publicforcoachandclener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

//import static jdk.internal.org.jline.reader.impl.LineReaderImpl.CompletionType.List;

public class DeleteCocher implements Initializable {

    private CoachdeleteBO coachdeleteBO = BOFactory.getInstance().getBOTypes(BOTypes.DELETECOACH);
    public Label lblCoachCount;
    public TableView tblView;
    @FXML
    private TableColumn<EmployeDto, String> colCochId;

    @FXML
    private TableColumn<EmployeDto, String> ColCoachName;

    private EmployeeManegeFirstpageBO employeeManegeFirstpageBO= BOFactory.getInstance().getBOTypes(BOTypes.EMPLOYEEMANEGEFIRSTPAGE);

  //  private EmployeModal employeModal = new EmployeModal();
    public AnchorPane AnchorPane;
    public Button buttenId;
    public TextField textFildId;
    //private EmployeedataModel employeedataModel = new EmployeedataModel();

    public void delete_butten_on_action(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

       // employeedataModel
        Publicforcoachandclener.shouldBeRunThisMethod();
        String rsp =coachdeleteBO.deleteCoach(textFildId.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION, rsp);
        alert.show();
       // int rsp = employeModal.setlableCoachCount();
        //lblCoachCount.setText(rsp + "");
        textFildId.clear();
        loadCocherTable();
    }

    public void loadCocherTable() throws SQLException, ClassNotFoundException {
        //ObservableList<EmployeDto> cleaner =

              List<EmployeDto>emplist =employeeManegeFirstpageBO.getcoachdata();
        ObservableList<EmployeDto> cleaner = FXCollections.observableArrayList(emplist);
        colCochId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        ColCoachName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        tblView.setItems(cleaner);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
          //  int rsp = employeModal.setlableCoachCount();
            //lblCoachCount.setText(rsp + "");
            loadCocherTable();
        } catch (SQLException e) {

            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());

        } catch (ClassNotFoundException e) {

            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
        }
    }
}
