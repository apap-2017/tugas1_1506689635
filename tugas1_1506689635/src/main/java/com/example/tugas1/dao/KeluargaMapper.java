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

import com.example.tugas1.model.KeluargaModel;
import com.example.tugas1.model.PendudukModel;

@Mapper
public interface KeluargaMapper {
	
	@Select("select id, nomor_kk, alamat, RT, RW, id_kelurahan, is_tidak_berlaku from keluarga where id = #{id} ")
	@Results(value = {
    		@Result(property = "nomorKK", column = "nomor_kk"),
    		@Result(property = "alamat", column = "alamat"),
    		@Result(property = "rt", column = "RT"),
    		@Result(property = "rw", column = "RW"),
    		@Result(property = "id", column = "id"),
    		@Result(property = "idKelurahan", column = "id_kelurahan"),
    		@Result(property = "isTidakBerlaku", column = "is_tidak_berlaku"),
    })
	KeluargaModel selectKeluarga(@Param("id")String id);
	
	@Select("select id, nomor_kk, alamat, RT, RW, id_kelurahan, is_tidak_berlaku from keluarga where nomor_kk = #{nkk}")
	@Results(value = {
    		@Result(property = "nomorKK", column = "nomor_kk"),
    		@Result(property = "alamat", column = "alamat"),
    		@Result(property = "rt", column = "rt"),
    		@Result(property = "rw", column = "rw"),
    		@Result(property = "id", column = "id"),
    		@Result(property = "idKelurahan", column = "id_kelurahan"),
    		@Result(property = "isTidakBerlaku", column = "is_tidak_berlaku"),
    		@Result(property = "listPenduduk" , column = "nomor_kk", javaType = List.class, many=@Many(select="selectAnggota"))
    })
	KeluargaModel selectDataKeluarga(@Param("nkk")String nkk);
	
	@Select("select nik, nama, jenis_kelamin, tempat_lahir, tanggal_lahir, agama, pekerjaan, status_perkawinan, status_dalam_keluarga, is_wni "
			+ "from penduduk join keluarga on penduduk.id_keluarga = keluarga.id "
			+ "where keluarga.nomor_kk = #{nkk}")
	@Results(value = {
			@Result(property = "jenisKelamin", column = "jenis_kelamin"),
			@Result(property = "isWNI", column = "is_wni"),
			@Result(property = "statusPerkawinan", column = "status_perkawinan"),
			@Result(property = "statusDalamKeluarga", column = "status_dalam_keluarga"),
			@Result(property = "tempatLahir", column = "tempat_lahir"),
			@Result(property = "tanggalLahir", column = "tanggal_lahir")
	})
	List<PendudukModel> selectAnggota(@Param("nkk")String nkk);
	
	@Insert("insert into keluarga (nomor_kk,alamat,RT,RW,id_kelurahan,is_tidak_berlaku) "
			   + "values ('${nomorKK}','${alamat}','${rt}','${rw}','${idKelurahan}',0)")
	void addKeluarga (KeluargaModel keluarga);
	
	@Select("SELECT COUNT(nomor_kk) FROM keluarga WHERE nomor_kk LIKE #{query}")
	int countKeluarga(String query);
	
	@Select("select id, nomor_kk, alamat, RT, RW, id_kelurahan, is_tidak_berlaku from keluarga where nomor_kk = #{nkk} ")
	@Results(value = {
    		@Result(property = "nomorKK", column = "nomor_kk"),
    		@Result(property = "alamat", column = "alamat"),
    		@Result(property = "rt", column = "RT"),
    		@Result(property = "rw", column = "RW"),
    		@Result(property = "id", column = "id"),
    		@Result(property = "idKelurahan", column = "id_kelurahan"),
    		@Result(property = "isTidakBerlaku", column = "is_tidak_berlaku"),
    })
	KeluargaModel selectKeluargaNKK(@Param("nkk")String id);
	
	@Update("UPDATE keluarga SET nomor_kk = #{nomorKK}, alamat = #{alamat}, RT = #{rt}, RW = #{rw}, id_kelurahan = #{idKelurahan}, "
			+ "is_tidak_berlaku = #{isTidakBerlaku} WHERE id = #{id}")
    void updateKeluarga (KeluargaModel keluarga);
}
