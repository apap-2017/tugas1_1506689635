package com.example.tugas1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tugas1.dao.KecamatanMapper;
import com.example.tugas1.model.KecamatanModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KecamatanServiceDatabase implements KecamatanService {

	@Autowired
	 private KecamatanMapper kecamatanMapper;
	 
	 @Override
	    public KecamatanModel selectKecamatan (String id)
	    {
	        log.info ("select kecamatan with id {}", id);
	        return kecamatanMapper.selectKecamatan (id);
	    }
	 @Override
		public String selectKodeKecamatan(String id_kelurahan) {
		 	log.info ("select kode kecamatan with id_kelurahan {}", id_kelurahan);
			return kecamatanMapper.selectKodeKecamatan(id_kelurahan);
		}


		@Override
		public String selectKodeKecamatanNKK(String nama_kecamatan) {
			log.info ("select kode kecamatan with nama_kecamatan {}", nama_kecamatan);
			return kecamatanMapper.selectKodeKecamatanNKK(nama_kecamatan);
			
		}
}
