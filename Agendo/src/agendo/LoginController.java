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
    private int status=-1;
    private int accountID = 0;
    private UserAccount ua;
    private AdminAccount ac;

    @FXML
    private void tombolLogin(ActionEvent event) throws IOException {
    	String str="Akun yang ada:\n";
    	for(int i=0;i<accountList.size();i++) {
    		str += accountList.get(i).toString();
    	}
    	System.out.println(str);
    	cekAkun();
    	if(status==0) {
			System.out.println("ADMin lur");
			FXMLLoader loader = new FXMLLoader();
	    	loader.setLocation(getClass().getResource("adminPage.fxml"));
	    	Parent utamaParent = loader.load();
	    	
	    	Scene utamaScene = new Scene(utamaParent);
	    	AdminPageController controller = loader.getController();
	    	controller.initData(ac);
	    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();   	
	    	window.setScene(utamaScene);
	    	window.show(); 	
		}else if(status==1){
			System.out.println("Jumlah event milik user: "+ua.getListEvent().size());
			System.out.println("Pindah scene ke utama");
			FXMLLoader loader = new FXMLLoader();
	    	loader.setLocation(getClass().getResource("utama.fxml"));
	    	Parent utamaParent = loader.load();
	    	
	    	Scene utamaScene = new Scene(utamaParent);
	    	UtamaController controller = loader.getController();
	    	controller.initData(ua);
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
    			if(accountList.get(i) instanceof AdminAccount) {
    				System.out.println("Statusnya admin");
    				ac = (AdminAccount) accountList.get(i);
    				status=0;
    			}else if(accountList.get(i) instanceof UserAccount) {
    				System.out.println("Statusnya user");
    				ua = (UserAccount) accountList.get(i);
    				status=1;
    			}
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
