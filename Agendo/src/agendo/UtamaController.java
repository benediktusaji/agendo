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

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class UtamaController implements Initializable {
    
    @FXML private Label jumlahHari;
    @FXML private GridPane grid = new GridPane();
    @FXML private ComboBox bulan;
    @FXML private ComboBox tahun;
    @FXML private AnchorPane kanan;
    private UserAccount ua;
    private ArrayList<Event> eventList = new ArrayList<Event>();
    private int hari;
    private int lastday;
    private String targetTahun="2020";
    private String targetBulan="06";
    private Calendar calendar = Calendar.getInstance();
    

    private int getLastDateOfMonth(int dateMonth) {
        calendar.set(Calendar.MONTH, dateMonth);
        int lastDate = calendar.getActualMaximum(Calendar.DATE);
        return lastDate;
    }
    
    
    @FXML 
    private void tombolBulan() {
    	targetBulan=null;
    	int dateMonth=0;
    	if(bulan.getValue().toString()=="Januari") {
    		dateMonth=0;
    		targetBulan="01";
    	}
    	if(bulan.getValue().toString()=="Februari") {
    		dateMonth=1;
    		targetBulan="02";
    	}
    	if(bulan.getValue().toString()=="Maret") {
    		dateMonth=2;
    		targetBulan="03";
    	}
    	if(bulan.getValue().toString()=="April") {
    		dateMonth=3;
    		targetBulan="04";
    	}
    	if(bulan.getValue().toString()=="Mei") {
    		dateMonth=4;
    		targetBulan="05";
    	}
    	if(bulan.getValue().toString()=="Juni") {
    		dateMonth=5;
    		targetBulan="06";
    	}
    	if(bulan.getValue().toString()=="Juli") {
    		dateMonth=6;
    		targetBulan="07";
    	}
    	if(bulan.getValue().toString()=="Agustus") {
    		dateMonth=7;
    		targetBulan="08";
    	}
    	if(bulan.getValue().toString()=="September") {
    		dateMonth=8;
    		targetBulan="09";
    	}
    	if(bulan.getValue().toString()=="Oktober") {
    		dateMonth=9;
    		targetBulan="10";
    	}
    	if(bulan.getValue().toString()=="November") {
    		dateMonth=10;
    		targetBulan="11";
    	}
    	if(bulan.getValue().toString()=="Desember") {
    		dateMonth=11;
    		targetBulan="12";
    	}
    	this.lastday = getLastDateOfMonth(dateMonth);
    	calendar.set(Calendar.DATE, 1);
    	this.hari = calendar.get(Calendar.DAY_OF_WEEK);
    	jumlahHari.setText("Ada: "+lastday+"\n Hari pertama adalah hari:"+hari+"\n "+calendar.getTime());
    	tombolPopulate();
    }
    
    @FXML
    private void tombolTahun() {
    	targetTahun=null;
    	int iTahun=2020;
    	if(tahun.getValue().toString()=="2020") {
    		iTahun=2020;
    		targetTahun="2020";
    	}
    	if(tahun.getValue().toString()=="2021") {
    		iTahun=2021;
    		targetTahun="2021";
    	}
    	if(tahun.getValue().toString()=="2022") {
    		iTahun=2022;
    		targetTahun="2022";
    	}
    	if(tahun.getValue().toString()=="2023") {
    		iTahun=2023;
    		targetTahun="2023";
    	}
    	if(tahun.getValue().toString()=="2024") {
    		iTahun=2024;
    		targetTahun="2024";
    	}
    	if(tahun.getValue().toString()=="2025") {
    		iTahun=2025;
    		targetTahun="2025";
    	}
    	calendar.set(Calendar.YEAR, iTahun);
    	jumlahHari.setText("Ada: "+lastday+"\n Hari pertama adalah hari:"+hari+"\n "+calendar.getTime());
    	tombolBulan();
    }
    
    @FXML
    private void tombolPopulate() {
    	System.out.println(eventList.size());
    	System.out.println("=======================");
    	for(int k=0;k<eventList.size();k++) {
    		System.out.println(eventList.get(k).getTanggal());
		}
    	System.out.println("=======================");
    	int day=1,count=1;
    	grid.getChildren().clear();
    	for(int i=0;i<6;i++) {
    		for(int j=0;j<7;j++) {
    			if(count<hari) {
    				Label angka = new Label();
					angka.setText(" ");
					grid.add(angka, j, i);    				
					count++;
    			}else {
    				if(day<=lastday) {
    					String sample = targetTahun+"-"+targetBulan+"-";
    					String str="/images/Icon Tanggal Blue/"+day+".png";
    					if(day<10) {
    						sample+="0"+day;
    					}else {
    						sample+=day;
    					}
    					System.out.println(sample);
    					for(int k=0;k<eventList.size();k++) {
    						if(sample.equalsIgnoreCase(eventList.get(k).getTanggal())) {
    							str = "/images/Icon Tanggal White/"+day+".png";    
    							System.out.println("Event Found: "+eventList.get(k).getTanggal());
    							break;
    						}else {
    							str = "/images/Icon Tanggal Blue/"+day+".png";
    						}
    					}
    					
						Image image = new Image(getClass().getResourceAsStream(str));
	    				ImageView iv = new ImageView(image);
	    				iv.setFitHeight(35); 
	    			    iv.setFitWidth(35); 
	    				grid.add(iv, j, i);
    					day++;    				
    				}else {
    					break;
    				}    				
    			}
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
    
    @FXML
    private void addEvent(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("addEvent.fxml"));
    	Pane utamaParent = loader.load();
    	
    	AddEventController controller = loader.getController();
    	controller.initData(ua);	
    	kanan.getChildren().setAll(utamaParent);
    }
    
    public void initData(UserAccount ua) {
    	this.ua = ua;
    	System.out.println("Jumlah event milik ua: " + ua.getListEvent().size());
    	eventList = ua.getListEvent();
    	System.out.println("berhasil passing user ke utama controller");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	bulan.getItems().addAll("Januari","Februari","Maret","April","Mei","Juni","Juli","Agustus","September","Oktober","November","Desember");
    	bulan.setValue("Juni");
    	tahun.getItems().addAll("2020","2021","2022","2023","2024","2025");
    	tahun.setValue("2020");
    	this.tombolTahun();
    	Node node=null;
    	try {
			node = (Node)FXMLLoader.load(getClass().getResource("listEvent.fxml"));
//			FXMLLoader loader = new FXMLLoader();
//	    	loader.setLocation(getClass().getResource("listEvent.fxml"));
//	    	ListEventController controller = loader.getController();
//			controller.initData(ua);
			
//			FXMLLoader loader = new FXMLLoader();
//	    	loader.setLocation(getClass().getResource("addEvent.fxml"));
//	    	Pane utamaParent = loader.load();
//	    	
//	    	AddEventController controller = loader.getController();
//	    	controller.initData(ua);	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	kanan.getChildren().setAll(node);
    }    
    
}
