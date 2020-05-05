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
    
    @FXML private Label keterangan;
    @FXML private TextField email;
    @FXML private TextField username;
    @FXML private PasswordField password;
    @FXML private ComboBox akses;
    private ArrayList<Account> accountList;
    
    public void initDataAccount(ArrayList<Account> accountList) {
    	this.accountList = accountList;
    }
    
    
    @FXML
    private void tombolDaftar(ActionEvent event) throws IOException {
//    	coba asal input ke accountList
    	if(akses.getValue().toString()=="ADMIN") {
    		AdminAccount ac = new AdminAccount(username.getText(),password.getText(),email.getText());
    		accountList.add(ac);
    	}else {
    		UserAccount uc = new UserAccount(username.getText(),password.getText(),email.getText());
    		accountList.add(uc);
    	}
    	String str="Akun yang ada:\n";
    	for(int i=0;i<accountList.size();i++) {
    		str += accountList.get(i).toString();
    	}
    	System.out.println(str);
    	
    	
    	
//    	Parent utamaParent = FXMLLoader.load(getClass().getResource("login.fxml"));
//    	Scene utamaScene = new Scene(utamaParent);
//    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//    	passAccountList();
//    	window.setScene(utamaScene);
//    	window.show();
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("login.fxml"));
    	Parent utamaParent = loader.load();
    	
    	Scene utamaScene = new Scene(utamaParent);
    	LoginController controller = loader.getController();
    	controller.initDataAccount(accountList);
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(utamaScene);
    	window.show();
    }
    
    private void passAccountList() throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("login.fxml"));
    	Parent utamaParent = loader.load();
    	
    	Scene utamaScene = new Scene(utamaParent);
    	LoginController controller = loader.getController();
    	controller.initDataAccount(accountList);
    }
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	akses.getItems().addAll("USER","ADMIN");
    	akses.setValue("USER");
    }    
    
}
