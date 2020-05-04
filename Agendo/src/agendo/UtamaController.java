/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendo;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class UtamaController implements Initializable {
    
    @FXML private Label jumlahHari;
    @FXML private GridPane grid = new GridPane();
    @FXML private ComboBox bulan;
    private Calendar calendar = Calendar.getInstance();
    

    private int getLastDateOfMonth(int dateMonth) {
        calendar.set(Calendar.MONTH, dateMonth);
        int lastDate = calendar.getActualMaximum(Calendar.DATE);
        return lastDate;
    }
    
    
    @FXML 
    private void tombolBulan() {
    	int dateMonth=0;
    	if(bulan.getValue().toString()=="Januari") {
    		dateMonth=0;
    	}
    	if(bulan.getValue().toString()=="Februari") {
    		dateMonth=1;
    	}
    	if(bulan.getValue().toString()=="Maret") {
    		dateMonth=2;
    	}
    	if(bulan.getValue().toString()=="April") {
    		dateMonth=3;
    	}
    	if(bulan.getValue().toString()=="Mei") {
    		dateMonth=4;
    	}
    	if(bulan.getValue().toString()=="Juni") {
    		dateMonth=5;
    	}
    	if(bulan.getValue().toString()=="Juli") {
    		dateMonth=6;
    	}
    	if(bulan.getValue().toString()=="Agustus") {
    		dateMonth=7;
    	}
    	if(bulan.getValue().toString()=="September") {
    		dateMonth=8;
    	}
    	if(bulan.getValue().toString()=="Oktober") {
    		dateMonth=9;
    	}
    	if(bulan.getValue().toString()=="November") {
    		dateMonth=10;
    	}
    	if(bulan.getValue().toString()=="Desember") {
    		dateMonth=11;
    	}
    	int lastday = getLastDateOfMonth(dateMonth);
    	calendar.set(Calendar.DATE, 1);
    	int hari = calendar.get(Calendar.DAY_OF_WEEK);
    	jumlahHari.setText("Ada: "+lastday+"\n Hari pertama adalah hari:"+hari+"\n "+calendar.getTime());
//    	int row=lastday/7;
    	int day=1,count=1;
    	grid.getChildren().clear();
    	for(int i=0;i<6;i++) {
    		for(int j=0;j<7;j++) {
    			if(count<hari) {
    				Label angka = new Label();
					angka.setText("A");
					grid.add(angka, j, i);
					count++;
    			}else {
    				if(day<=lastday) {
    					Label angka = new Label();
    					angka.setText(""+day);
    					grid.add(angka, j, i);
    					day++;    				
    				}else {
    					break;
    				}    				
    			}
    		}
    	}
    	
    }
    
    @FXML
    private void tombolPopulate() {
    	int count=1;
    	for(int i=0;i<5;i++) {
    		for(int j=0;j<7;j++) {
    			Label angka = new Label();
    			angka.setText(""+count);
    			grid.add(angka, j, i);
    			count++;
    		}
    	}
    	
    }
    
    
    @FXML
    private void tombolMetu(ActionEvent event) throws IOException {
    	Parent utamaParent = FXMLLoader.load(getClass().getResource("login.fxml"));
    	Scene utamaScene = new Scene(utamaParent);
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	
    	window.setScene(utamaScene);
    	window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	bulan.getItems().addAll("Januari","Februari","Maret","April","Mei","Juni","Juli","Agustus","September","Oktober","November","Desember");
    }    
    
}
