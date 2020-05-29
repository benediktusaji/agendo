/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendo;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class AdminPageController implements Initializable {
    
    @FXML private TableView<Account> tableView;
    @FXML private TableColumn<Account, String> namaColumn;
    @FXML private TableColumn<Account, String> emailColumn;
    @FXML private TableColumn<Account, String> passwordColumn;
    @FXML private TableColumn<Account, String> eventsColumn;
//    @FXML private TableColumn<Account, String> aksiColumn;
    private ArrayList<Account> accountList = new ArrayList<Account>();
    private DatabaseAgendo da = new DatabaseAgendo();
    @FXML
    private void logOut(ActionEvent event) throws IOException {
    	Parent utamaParent = FXMLLoader.load(getClass().getResource("login.fxml"));
    	Scene utamaScene = new Scene(utamaParent);
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	
    	window.setScene(utamaScene);
    	window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	accountList = da.selectAllAccount();
    	namaColumn.setCellValueFactory(new PropertyValueFactory<Account, String>("username"));
    	emailColumn.setCellValueFactory(new PropertyValueFactory<Account, String>("email"));
    	passwordColumn.setCellValueFactory(new PropertyValueFactory<Account, String>("password"));
    	
    	ObservableList<Account> oblist = FXCollections.observableArrayList();
    	for(int i=0;i<accountList.size();i++) {
    		oblist.add(accountList.get(i));
    	}
    	tableView.setItems(oblist);
    }    
    
}
