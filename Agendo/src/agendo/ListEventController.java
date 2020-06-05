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
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class ListEventController implements Initializable {
	
    @FXML private TableView<Event> tableView;
    @FXML private TableColumn<Event, String> tanggalColumn;
    @FXML private TableColumn<Event, String> judulColumn;
    @FXML private AnchorPane kanan;
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
    	tanggalColumn.setCellValueFactory(new PropertyValueFactory<Event, String>("tanggal"));
    	judulColumn.setCellValueFactory(new PropertyValueFactory<Event, String>("judul"));
    	ObservableList<Event> oblist = FXCollections.observableArrayList();
		for(int i=0;i<ua.getListEvent().size();i++) {
			oblist.add(ua.getListEvent().get(i));
			System.out.println("added");
		}    		
    	tableView.setItems(oblist);
    	tableView.setOnMouseReleased((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2){
            	//Ini buat tombol baru
				try {
					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(getClass().getResource("addEvent.fxml"));
					Pane utamaParent=loader.load();
					AddEventController controller = loader.getController();
					controller.iniDataForEdit(ua,tableView.getSelectionModel().getSelectedItem());	
					kanan.getChildren().setAll(utamaParent);
					System.out.println(tableView.getSelectionModel().getSelectedItem());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
            }
        });
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	System.out.println("initialize dulu");
    }    
    
}
