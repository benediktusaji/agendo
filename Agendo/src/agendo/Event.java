package agendo;

import java.util.Date;

public class Event {
	private String judul;
	private Date tanggal;
	private String deskripsi;
	private String kategori;  //bisa dikembangin jadi class sendiri
	
	public Event(String judul, Date tanggal, String deskripsi, String kategori) {
		this.judul = judul;
		this.tanggal = tanggal;
		this.deskripsi = deskripsi;
		this.kategori = kategori;
	}
	
	public void editEvent(String indikator, String newData) {
		if(indikator.equals("judul")) {
			this.judul = newData;
		}else if(indikator.equals("deskripsi")) {
			this.deskripsi = newData;
		}else {
			this.kategori = newData;
		}
	}
	
	public void editEvent(Date newData) {
		this.tanggal = newData;
	}

	public String getJudul() {
		return judul;
	}

	public Date getTanggal() {
		return tanggal;
	}

	public String getDeskripsi() {
		return deskripsi;
	}

	public String getKategori() {
		return kategori;
	}
	
}
