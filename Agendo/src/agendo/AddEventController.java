/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendo;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author USER
 */
public class AddEventController implements Initializable {
	@FXML private AnchorPane kanan;
	@FXML private TextField judul;
	@FXML private TextField kategori;
	@FXML private TextArea deskripsi;
	@FXML private DatePicker tanggal;
	private UserAccount ua=null;
	private DatabaseAgendo da = new DatabaseAgendo();
	
    @FXML
    private void cancel() throws IOException {
//    	Node node;
//    	node = (Node)FXMLLoader.load(getClass().getResource("listEvent.fxml"));
//    	kanan.getChildren().setAll(node);
//    	
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("listEvent.fxml"));
    	Pane node = loader.load();
    	
    	ListEventController controller = loader.getController();
    	controller.initData(ua);	
    	kanan.getChildren().setAll(node);
    	
    }
	
    public void initData(UserAccount ua) {
    	this.ua = ua;
    	System.out.println(ua.getAccountID()+" boss");
    }
    
    //tombol delete
    
    @FXML
    private void save() throws IOException {
    	String date = tanggal.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    	Event e = new Event(judul.getText(),date,deskripsi.getText(),kategori.getText());
    	ua.addEvent(e);
    	da.addEvent(ua, e);
    	cancel();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }    
    
}
