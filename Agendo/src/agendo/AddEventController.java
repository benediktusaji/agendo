/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendo;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
	private boolean edit = false;
	private DatabaseAgendo da = new DatabaseAgendo();
	private Event e;
	
	public static final LocalDate LOCAL_DATE (String dateString){
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate localDate = LocalDate.parse(dateString, formatter);
	    return localDate;
	}
	
	
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
    
    public void iniDataForEdit(UserAccount ua, Event e) {
    	this.ua = ua;
    	this.edit = true;
    	this.e = e;
    	System.out.println("passing data event pilihan");
    	System.out.println(e.getEventID());
    	System.out.println(e.getJudul());
    	System.out.println(e.getKategori());
    	System.out.println(e.getTanggal());
    	tanggal.setValue(LOCAL_DATE(e.getTanggal()));
    	judul.setText(e.getJudul());
    	kategori.setText(e.getKategori());
    	deskripsi.setText(e.getDeskripsi());
    }
    
    
    
    //tombol delete
    @FXML
    private void delete() throws IOException {
    	da.deleteEvent(e);
    	System.out.println("coba delete");
    	cancel();
    }
    @FXML
    private void save() throws IOException {
    	System.out.println("TOMBOL SVAE DIKLIK BOSKU");
		String date = tanggal.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		Event e = new Event(0,judul.getText(),date,deskripsi.getText(),kategori.getText());
    	if(edit) {
    		boolean change=false;
    		if(!tanggal.toString().equalsIgnoreCase(e.getTanggal())) {
    			change = true;
    			System.out.println("TANGGALNYA GANTI");
    		}
    		if(!judul.getText().equalsIgnoreCase(e.getJudul())) {
    			change = true;
    			System.out.println("Judul ganti");
    		}
    		if(!kategori.getText().equalsIgnoreCase(e.getKategori())) {
    			change = true;
    			System.out.println("kategori berubah");
    		}
    		if(!deskripsi.getText().equalsIgnoreCase(e.getDeskripsi())) {
    			change = true;
    			System.out.println("deskrisasfas");
    		}
    		if(change) {
    			da.updateEvent(e, judul.getText(), kategori.getText(), tanggal.toString(), deskripsi.getText());
    		}
    	}else {
    		ua.addEvent(e);
    		da.addEvent(ua, e);    		
    	}
    	cancel();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }    
    
}
