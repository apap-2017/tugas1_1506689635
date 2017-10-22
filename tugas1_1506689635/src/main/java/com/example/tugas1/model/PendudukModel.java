package com.example.tugas1.model;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PendudukModel {
	@NotNull
	private int id;
	@NotNull
	private String nik;
	@NotNull
	private String nama;
	@NotNull
	private String tempatLahir;
	@NotNull
	private String tanggalLahir;
	@NotNull
	private int jenisKelamin;
	@NotNull
	private int isWNI;
	@NotNull
	private String idKeluarga;
	@NotNull
	private String agama;
	@NotNull
	private String pekerjaan;
	@NotNull
	private String statusPerkawinan;
	@NotNull
	private String statusDalamKeluarga;
	@NotNull
	private String golonganDarah;
	@NotNull
	private int isWafat;

	
}
