package com.example.demo.model;

public class ModelDataPelamar {
	String id;
	String nama;
	String alamat;
	String tempat_tanggal_lahir;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getTempat_tanggal_lahir() {
		return tempat_tanggal_lahir;
	}

	public void setTempat_tanggal_lahir(String tempat_tanggal_lahir) {
		this.tempat_tanggal_lahir = tempat_tanggal_lahir;
	}

	public ModelDataPelamar(String id, String nama, String alamat, String tempat_tanggal_lahir) {
		super();
		this.id = id;
		this.nama = nama;
		this.alamat = alamat;
		this.tempat_tanggal_lahir = tempat_tanggal_lahir;
	}

}
