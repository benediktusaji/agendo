package agendo;

import java.util.Date;

public class Event {
	private String judul;
	private String tanggal;
	private String deskripsi;
	private String kategori;  //bisa dikembangin jadi class sendiri
	
	public Event(String judul, String tanggal, String deskripsi, String kategori) {
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
		}else if(indikator.equals("kategori")){
			this.kategori = newData;
		}else {
			this.tanggal = newData;
		}
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
	
}
