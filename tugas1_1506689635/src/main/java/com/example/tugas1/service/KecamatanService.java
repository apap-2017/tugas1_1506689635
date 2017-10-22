package com.example.tugas1.service;

import com.example.tugas1.model.KecamatanModel;

public interface KecamatanService {

	KecamatanModel selectKecamatan(String id);
	
	String selectKodeKecamatan(String id_kelurahan);
	
	String selectKodeKecamatanNKK(String nama_kecamatan);
}
