/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendo;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class ListEventController implements Initializable {
	
    @FXML private TableView<Event> tableView;
    @FXML private TableColumn<Event, String> tanggalColumn;
    @FXML private TableColumn<Event, String> judulColumn;
	private UserAccount ua;
	private ArrayList<Event> eventList;
	private DatabaseAgendo da = new DatabaseAgendo();
	
    public void initData(UserAccount ua) {
    	this.ua = ua;
    	ua.setListEvent(da.selectEvent(ua));
    	System.out.println("berhasil oper user ke list event");
    	System.out.println(ua.getListEvent().size());
    	for(int i=0;i<ua.getListEvent().size();i++) {
    		System.out.println(ua.getListEvent().get(i).toString());
    	}
    	

    	
    }
    public void initData(UserAccount ua, String tanggal) {
    	this.ua = ua;
    	ua.setListEvent(da.selectEventWithinMonth(ua, tanggal));
    	System.out.println("berhasil oper user ke list event, kemudian cetak event dalam bulan yang sama");
    	System.out.println(ua.getListEvent().size());
    	for(int i=0;i<ua.getListEvent().size();i++) {
    		System.out.println(ua.getListEvent().get(i).toString());
    	}
    	eventList = ua.getListEvent();
    	tanggalColumn.setCellValueFactory(new PropertyValueFactory<Event, String>("date"));
    	judulColumn.setCellValueFactory(new PropertyValueFactory<Event, String>("title"));
    	ObservableList<Event> oblist = FXCollections.observableArrayList();
		for(int i=0;i<eventList.size();i++) {
			oblist.add(eventList.get(i));
		}    		
    	tableView.setItems(oblist);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    
    }    
    
}
