package com.example.tugas1.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.tugas1.model.KelurahanModel;

@Mapper
public interface KelurahanMapper {
	
	@Select("select id, id_kecamatan, kode_kelurahan, nama_kelurahan, kode_pos "
			+ "from kelurahan "
			+ "where id = #{id}")
	@Results(value = {
    		@Result(property = "id", column = "id"),
    		@Result(property = "kodePos", column = "kode_pos"),
    		@Result(property = "kodeKelurahan", column = "kode_kelurahan"),
    		@Result(property = "namaKelurahan", column = "nama_kelurahan"),
    		@Result(property = "idKecamatan", column = "id_kecamatan")
    })
    KelurahanModel selectKelurahan (@Param("id") String id);
	
	@Select("select id from kelurahan where nama_kelurahan = #{nama_kelurahan}")
	String selectKelurahanId(String nama_kelurahan);
}
