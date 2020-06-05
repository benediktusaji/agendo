package agendo;

import java.util.Date;

public class Event {
	private int eventID;
	private String judul;
	private String tanggal;
	private String deskripsi;
	private String kategori;  //bisa dikembangin jadi class sendiri
	
	public Event(int eventID, String judul, String tanggal, String deskripsi, String kategori) {
		this.eventID = eventID;
		this.judul = judul;
		this.tanggal = tanggal;
		this.deskripsi = deskripsi;
		this.kategori = kategori;
	}
	
//	public void editEvent(String indikator, String newData) {
//		if(indikator.equals("judul")) {
//			this.judul = newData;
//		}else if(indikator.equals("deskripsi")) {
//			this.deskripsi = newData;
//		}else if(indikator.equals("kategori")){
//			this.kategori = newData;
//		}else {
//			this.tanggal = newData;
//		}
//	}

	public int getEventID() {
		return eventID;
	}

	public String getJudul() {
		return judul;
	}

	public String getTanggal() {
		return tanggal;
	}

	public String getDeskripsi() {
		return deskripsi;
	}

	public String getKategori() {
		return kategori;
	}
	
	public void setJudul(String judul) {
		this.judul = judul;
	}

	public void setTanggal(String tanggal) {
		this.tanggal = tanggal;
	}

	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}

	public void setKategori(String kategori) {
		this.kategori = kategori;
	}

	public String toString() {
		return tanggal+" "+judul+" "+kategori+" "+deskripsi;
	}
}
