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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class EditAccountController implements Initializable {

	private Account acc;
	@FXML private TextField email;
	@FXML private TextField username;
	@FXML private TextField password;
	@FXML private Label nama;
	private String emailOld;
	private String usernameOld;
	private String passwordOld;
	private DatabaseAgendo da = new DatabaseAgendo();
	
	
	public void initData(Account a) {
		this.acc = a;
		System.out.println("Berhasil passwing data ke edit");
		System.out.println(acc.toString());
		email.setText(acc.getEmail());
    	username.setText(acc.getUsername());
    	password.setText(acc.getPassword());
//    	nama.setText("Halo, "+acc.getUsername());
    	emailOld = acc.getEmail();
    	usernameOld = acc.getUsername();
    	passwordOld = acc.getPassword();
	}
	
    @FXML
    private void tombolMetu(ActionEvent event) throws IOException {
    	Parent utamaParent = FXMLLoader.load(getClass().getResource("login.fxml"));
    	Scene utamaScene = new Scene(utamaParent);
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	
    	window.setScene(utamaScene);
    	window.show();
    }
	
    @FXML
    private void goBack(ActionEvent event) throws IOException {
    	if(acc instanceof UserAccount) {
    		System.out.println("user bsoku");
        	FXMLLoader loader = new FXMLLoader();
        	loader.setLocation(getClass().getResource("utama.fxml"));
        	Parent utamaParent = loader.load();
        	
        	Scene utamaScene = new Scene(utamaParent);
        	UtamaController controller = loader.getController();
        	controller.initData(acc);
        	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();   	
        	window.setScene(utamaScene);
        	window.show();
    	}else {
        	FXMLLoader loader = new FXMLLoader();
        	loader.setLocation(getClass().getResource("adminPage.fxml"));
        	Parent utamaParent = loader.load();
        	
        	Scene utamaScene = new Scene(utamaParent);
        	AdminPageController controller = loader.getController();
        	controller.initData(acc);
        	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();   	
        	window.setScene(utamaScene);
        	window.show();
    	}
    }
    
    @FXML
    private void save() {
    	boolean change = false;
    	if(!email.getText().equalsIgnoreCase(emailOld)) {
    		emailOld = email.getText();
    		change = true;
    	}
    	if(!username.getText().equalsIgnoreCase(usernameOld)) {
    		usernameOld = username.getText();
    		change = true;
    	}
    	if(!password.getText().equalsIgnoreCase(passwordOld)) {
    		passwordOld = password.getText();
    		change = true;
    	}
    	if(change) {
    		da.updateAccount(acc, usernameOld, emailOld, passwordOld);
    	}
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
