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
public class LoginController implements Initializable {
    
	
	
    @FXML private Label keterangan;
    @FXML private TextField email;
    @FXML private PasswordField password;
    private ArrayList<Account> accountList = new ArrayList<Account>();
    private DatabaseAgendo da = new DatabaseAgendo();
    
//    public void initDataAccount(ArrayList<Account> accountList) {
//    	this.accountList = accountList;
//    }
//    
    @FXML
    private void tombolLogin(ActionEvent event) throws IOException {
    	String str="Akun yang ada:\n";
    	for(int i=0;i<accountList.size();i++) {
    		str += accountList.get(i).toString();
    	}
    	System.out.println(str);
    	if(cekAkun()) {
    		System.out.println("harusnya masuk");
    		Parent utamaParent = FXMLLoader.load(getClass().getResource("utama.fxml"));
    		Scene utamaScene = new Scene(utamaParent);
    		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    		window.setScene(utamaScene);
    		window.show();    		
    	}
    }
    
    @FXML
    private void daftarSekarang(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("daftar.fxml"));
    	Parent utamaParent = loader.load();
    	
    	Scene utamaScene = new Scene(utamaParent);
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();   	
    	window.setScene(utamaScene);
    	window.show();
    }
    
    private void passAccountList() throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("daftar.fxml"));
    	Parent utamaParent = loader.load();
    	
    	Scene utamaScene = new Scene(utamaParent);
    	DaftarController controller = loader.getController();
//    	controller.initDataAccount(accountList);
    }
    
//    cek apakah akun ada di list
    private boolean cekAkun() {
    	System.out.println("cekcek");
    	boolean masuk=false;
    	for(int i=0;i<accountList.size();i++) {
    		if(accountList.get(i).getEmail().equals(email.getText())&&accountList.get(i).getPassword().equals(password.getText())) {
    			masuk=true;
    		}
    	}
    	return masuk;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	accountList = da.selectAllAccount();
    }    
    
}
