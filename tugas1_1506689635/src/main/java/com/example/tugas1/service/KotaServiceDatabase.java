package com.example.tugas1.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tugas1.dao.KotaMapper;
import com.example.tugas1.model.KotaModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KotaServiceDatabase implements KotaService {
	@Autowired
	 private KotaMapper kotaMapper;
	 
	 @Override
	    public KotaModel selectKota (String id)
	    {
	        log.info ("select kota with id {}", id);
	        return kotaMapper.selectKota (id);
	    }
}
