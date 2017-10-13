package nl.tkeur;

import com.sun.org.glassfish.gmbal.Description;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class OverviewController implements Initializable {

    public class TestData {

        private String name;
        private String description;

        TestData(String name, String description) {
            this.name = name;

            this.description = description;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }
    }

    @FXML
    private TableView<TestData> overviewTableView;

    @FXML
    private TableColumn<TestData, String> overviewName;

    @FXML
    private TableColumn<TestData, String> overviewDescription;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        overviewName.setCellValueFactory(new PropertyValueFactory<>("name"));
        overviewDescription.setCellValueFactory(new PropertyValueFactory<>("description"));

        ObservableList<TestData> list = FXCollections.observableArrayList();

        for (int i = 0; i < 100; i++) {
            list.add(new TestData(String.format("Test%d", i), "Lorem ipsum"));
        }

        overviewTableView.setItems(list);
    }
}
