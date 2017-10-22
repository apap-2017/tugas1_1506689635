package com.example.tugas1.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.tugas1.model.KecamatanModel;


@Mapper
public interface KecamatanMapper {

	@Select("select id, id_kota, kode_kecamatan, nama_kecamatan "
			+ "from kecamatan "
			+ "where id = #{id}")
	@Results(value = {
    		@Result(property = "id", column = "id"),
    		@Result(property = "idKota", column = "id_kota"),
    		@Result(property = "kodeKecamatan", column = "kode_kecamatan"),
    		@Result(property = "namaKecamatan", column = "nama_kecamatan"),
    })
    KecamatanModel selectKecamatan (@Param("id") String id);
	
	@Select("select kode_kecamatan from kecamatan ke, kelurahan kel where kel.id = #{id_kelurahan} AND "
			+ "ke.id = kel.id_kecamatan")
	String selectKodeKecamatan(String id_kelurahan);
	
	@Select("select kode_kecamatan from kecamatan where nama_kecamatan = #{nama_kecamatan}")
	String selectKodeKecamatanNKK(String nama_kecamatan);
	
	
}
