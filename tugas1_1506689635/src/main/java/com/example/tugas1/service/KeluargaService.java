package com.example.tugas1.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.tugas1.model.KeluargaModel;
import com.example.tugas1.model.PendudukModel;

public interface KeluargaService {
	
	KeluargaModel selectKeluarga(String id);
	
	KeluargaModel selectDataKeluarga(String nkk);
	
	List<PendudukModel> selectAnggota(String nkk);
	
	void addKeluarga (KeluargaModel keluarga);
	
	int countKeluarga(String query);
	
	void updateKeluarga (KeluargaModel keluarga);
	
	KeluargaModel selectKeluargaNKK(String nkk);
	
}
