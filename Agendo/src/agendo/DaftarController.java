/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class DaftarController implements Initializable {
    
    @FXML private Label label;
    @FXML private TextField email;
    @FXML private PasswordField password;
    @FXML private ComboBox akses;
    
    @FXML
    private void tombolDaftar(ActionEvent event) throws IOException {
    	Parent utamaParent = FXMLLoader.load(getClass().getResource("login.fxml"));
    	Scene utamaScene = new Scene(utamaParent);
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	
    	window.setScene(utamaScene);
    	window.show();
    }
    
    @FXML
    private void daftarSekarang() {
    	System.out.println("daftar lure");
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	akses.getItems().addAll("USER","ADMIN");
    	akses.setValue("USER");
    }    
    
}
