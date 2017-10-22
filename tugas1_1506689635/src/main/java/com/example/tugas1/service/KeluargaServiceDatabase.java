package com.example.tugas1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tugas1.dao.KeluargaMapper;
import com.example.tugas1.model.KeluargaModel;
import com.example.tugas1.model.PendudukModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KeluargaServiceDatabase implements KeluargaService {

	@Autowired
	 private KeluargaMapper keluargaMapper;
	 
	 @Override
	    public KeluargaModel selectKeluarga (String id)
	    {
	        log.info ("select keluarga with id {}", id);
	        return keluargaMapper.selectKeluarga (id);
	    }
	 
	 @Override
	    public KeluargaModel selectDataKeluarga (String nkk)
	    {
	        log.info ("select data keluarga with nkk {}", nkk);
	        return keluargaMapper.selectDataKeluarga (nkk);
	    }
	 @Override
	    public List<PendudukModel> selectAnggota (String nkk)
	    {
	        log.info ("select daftar anggota with nkk {}", nkk);
	        return keluargaMapper.selectAnggota (nkk);
	    }
	 @Override
		public int countKeluarga(String query) {
		 	log.info ("count keluarga");
			return keluargaMapper.countKeluarga(query);
		}
	@Override
		public void addKeluarga(KeluargaModel keluarga) {
			log.info("add keluarga with list of {}", keluarga);
			keluargaMapper.addKeluarga(keluarga);
		}
	
	@Override
	public void updateKeluarga(KeluargaModel keluarga) {
		log.info("update keluarga with data {}", keluarga);
		keluargaMapper.updateKeluarga(keluarga);
	}
	 @Override
	    public KeluargaModel selectKeluargaNKK(String nkk) {
		 log.info ("select keluarga with nkk {}", nkk);
		return keluargaMapper.selectKeluargaNKK(nkk);
	 }
}
