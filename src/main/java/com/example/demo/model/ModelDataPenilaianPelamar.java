package com.example.demo.model;

public class ModelDataPenilaianPelamar {
	String id;
	String posisi_lamaran;
	String jurusan;
	Integer nilai_sikap;
	Integer nilai_wawancara;
	Integer nilai_technical_test;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPosisi_lamaran() {
		return posisi_lamaran;
	}
	public void setPosisi_lamaran(String posisi_lamaran) {
		this.posisi_lamaran = posisi_lamaran;
	}
	public String getJurusan() {
		return jurusan;
	}
	public void setJurusan(String jurusan) {
		this.jurusan = jurusan;
	}
	public Integer getNilai_sikap() {
		return nilai_sikap;
	}
	public void setNilai_sikap(Integer nilai_sikap) {
		this.nilai_sikap = nilai_sikap;
	}
	public Integer getNilai_wawancara() {
		return nilai_wawancara;
	}
	public void setNilai_wawancara(Integer nilai_wawancara) {
		this.nilai_wawancara = nilai_wawancara;
	}
	public Integer getNilai_technical_test() {
		return nilai_technical_test;
	}
	public void setNilai_technical_test(Integer nilai_technical_test) {
		this.nilai_technical_test = nilai_technical_test;
	}
	public ModelDataPenilaianPelamar(String id, String posisi_lamaran, String jurusan, Integer nilai_sikap,
			Integer nilai_wawancara, Integer nilai_technical_test) {
		super();
		this.id = id;
		this.posisi_lamaran = posisi_lamaran;
		this.jurusan = jurusan;
		this.nilai_sikap = nilai_sikap;
		this.nilai_wawancara = nilai_wawancara;
		this.nilai_technical_test = nilai_technical_test;
	}
	
	
}
