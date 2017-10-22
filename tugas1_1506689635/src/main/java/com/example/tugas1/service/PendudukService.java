package com.example.tugas1.service;


import com.example.tugas1.model.PendudukModel;

public interface PendudukService {
	PendudukModel selectPenduduk(String nik);
	
	String selectPendudukID(String id_kelurahan);
	
	int countPenduduk(String query);
	
	void addPenduduk (PendudukModel penduduk);
	
	void updatePenduduk (PendudukModel penduduk);
}
