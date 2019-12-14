package com.example.demo.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ModelDataPelamar;
import com.example.demo.model.ModelDataPenilaianPelamar;
import com.example.demo.model.ModelResultPelamar;
import com.example.demo.service.Service;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/restapimandiri")
@SuppressWarnings("deprecation")
public class Controller {

	@RequestMapping(value = "/datapelamar", method = RequestMethod.POST)
	public String getDataPelamar(@RequestBody ModelDataPelamar model) throws SQLException {
		String id = model.getId();
		String nama = model.getNama();
		String alamat = model.getAlamat();
		String tempat_tgllahir = model.getTempat_tanggal_lahir();
		
		return Service.Table1(id, nama, alamat, tempat_tgllahir);
	}
	
	@RequestMapping(value = "/datapenilaianpelamar", method = RequestMethod.POST)
	public String getDataPenilaianPelamar(@RequestBody ModelDataPenilaianPelamar model) throws SQLException {
		String id = model.getId();
		String jurusan = model.getJurusan();
		String posisi_lamaran = model.getPosisi_lamaran();
		Integer nilai_sikap = model.getNilai_sikap();
		Integer nilai_wawancara = model.getNilai_wawancara();
		Integer nilai_technical_test = model.getNilai_technical_test();
		
		return Service.Table2(id,jurusan,posisi_lamaran,nilai_sikap,nilai_wawancara,nilai_technical_test);
	}
	
	@RequestMapping(value = "/resultpelamar", method = RequestMethod.POST)
	public String getResultPelamar(@RequestBody ModelResultPelamar model) throws SQLException {
		String id = model.getId();
		String nama = model.getNama();
		return Service.Table3(id,nama);
	}
	
	@RequestMapping(value = "/getresultdatafinal", method = RequestMethod.GET)
	public String getResultDataFinal() throws SQLException {
		return Service.TableResult();
	}
	
	
	
	
}
