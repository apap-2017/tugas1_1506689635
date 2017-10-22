package com.example.tugas1.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tugas1.dao.PendudukMapper;
import com.example.tugas1.model.PendudukModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PendudukServiceDatabase implements PendudukService
{

	 @Autowired
	 private PendudukMapper pendudukMapper;
	 
	 @Override
	    public PendudukModel selectPenduduk (String nik)
	    {
	        log.info ("select penduduk with nik {}", nik);
	        return pendudukMapper.selectPenduduk (nik);
	    }
	 
	 @Override
		public int countPenduduk(String query) {
			return pendudukMapper.countPenduduk(query);
		}

		@Override
		public String selectPendudukID(String id_kelurahan) {
			log.info("select penduduk with id_kelurahan",id_kelurahan);
			return pendudukMapper.selectPendudukID(id_kelurahan);
		}
		
		@Override
		public void addPenduduk(PendudukModel penduduk) {
			log.info("add penduduk with list of {}", penduduk);
			pendudukMapper.addPenduduk(penduduk);
		}
		
		@Override
		public void updatePenduduk(PendudukModel penduduk) {
			log.info("update penduduk with penduduk {}", penduduk);
			pendudukMapper.updatePenduduk(penduduk);
		}
}
