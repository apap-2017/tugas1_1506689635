package com.example.tugas1.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.tugas1.model.PendudukModel;



@Mapper
public interface PendudukMapper {

	@Select("select id, nik, nama, tempat_lahir, tanggal_lahir, jenis_kelamin, golongan_darah, agama, status_perkawinan, pekerjaan, is_wni, is_wafat, id_keluarga, status_dalam_keluarga "
			+ "from penduduk "
			+ "where nik = #{nik}")
	@Results(value = {
			@Result(property = "id", column = "id"),
    		@Result(property = "nik", column = "nik"),
    		@Result(property = "nama", column = "nama"),
    		@Result(property = "tempatLahir", column = "tempat_lahir"),
    		@Result(property = "tanggalLahir", column = "tanggal_lahir"),
    		@Result(property = "jenisKelamin", column = "jenis_kelamin"),
    		@Result(property = "golonganDarah", column = "golongan_darah"),
    		@Result(property = "agama", column = "agama"),
    		@Result(property = "statusPerkawinan", column = "status_perkawinan"),
    		@Result(property = "pekerjaan", column = "pekerjaan"),
    		@Result(property = "isWNI", column = "is_wni"),
    		@Result(property = "isWafat", column = "is_wafat"),
    		@Result(property = "statusDalamKeluarga", column = "status_dalam_keluarga"),
    		@Result(property = "idKeluarga", column = "id_keluarga")
    })
    PendudukModel selectPenduduk (@Param("nik") String nik);
	
	@Select("select id_kelurahan from keluarga where id = #{id_kelurahan}")
	String selectPendudukID(String id_kelurahan);
	
	@Select("SELECT COUNT(nik) FROM penduduk WHERE nik LIKE #{query}")
	int countPenduduk(String query);
	
	@Insert("INSERT INTO penduduk (nik, nama, tempat_lahir, tanggal_lahir, jenis_kelamin, is_wni, id_keluarga, agama, pekerjaan, "
			+ "status_perkawinan, status_dalam_keluarga, golongan_darah, is_wafat ) "
			+ "VALUES (#{nik}, #{nama}, #{tempatLahir}, #{tanggalLahir}, #{jenisKelamin}, #{isWNI}, #{idKeluarga}, #{agama}, #{pekerjaan}, "
			+ "#{statusPerkawinan}, #{statusDalamKeluarga}, #{golonganDarah}, "
			+ "#{isWafat})")
    void addPenduduk (PendudukModel penduduk);
	
	@Update("UPDATE penduduk SET nik = #{nik}, nama = #{nama}, tempat_lahir = #{tempatLahir}, tanggal_lahir = #{tanggalLahir}, "
			+ "jenis_kelamin = #{jenisKelamin}, is_wni = #{isWNI}, id_keluarga = #{idKeluarga}, agama = #{agama}, "
			+ "pekerjaan = #{pekerjaan}, status_perkawinan = #{statusPerkawinan}, status_dalam_keluarga = #{statusDalamKeluarga}, "
			+ "golongan_darah = #{golonganDarah}, is_wafat = #{isWafat} WHERE id = #{id}")
    void updatePenduduk (PendudukModel penduduk);
	
}
