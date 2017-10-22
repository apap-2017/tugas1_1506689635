package com.example.tugas1.service;

import com.example.tugas1.model.KelurahanModel;

public interface KelurahanService {

	KelurahanModel selectKelurahan(String id);
	
	String selectKelurahanId(String id_kelurahan);
	
}
