package com.example.tugas1.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.tugas1.model.KotaModel;


@Mapper
public interface KotaMapper {

	@Select("select id, kode_kota, nama_kota "
			+ "from kota "
			+ "where id = #{id}")
	@Results(value = {
    		@Result(property = "id", column = "id"),
    		@Result(property = "kodeKota", column = "kode_kota"),
    		@Result(property = "namaKota", column = "nama_kota"),
    })
    KotaModel selectKota (@Param("id") String id);
}
