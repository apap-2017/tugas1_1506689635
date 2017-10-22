package com.example.tugas1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tugas1.dao.KelurahanMapper;
import com.example.tugas1.model.KelurahanModel;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class KelurahanServiceDatabase implements KelurahanService {

	@Autowired
	 private KelurahanMapper kelurahanMapper;
	 
	 @Override
	    public KelurahanModel selectKelurahan (String id)
	    {
	        log.info("select kelurahan with id {}", id);
	        return kelurahanMapper.selectKelurahan (id);
	    }
	 @Override
		public String selectKelurahanId(String id_kelurahan) {
			// TODO Auto-generated method stub
			return kelurahanMapper.selectKelurahanId(id_kelurahan);
		}
}
