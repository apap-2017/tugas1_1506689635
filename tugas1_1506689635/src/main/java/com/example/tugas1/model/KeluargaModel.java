package com.example.tugas1.model;

import java.util.List;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class KeluargaModel {
	@NotNull
	private int id;
	@NotNull
	private String nomorKK;
	@NotNull
	private String alamat;
	@NotNull
	private String rt;
	@NotNull
	private String rw;
	@NotNull
	private String idKelurahan;
	@NotNull
	private int isTidakBerlaku;
	@NotNull
	private String namaKelurahan;
	@NotNull
	private String namaKecamatan;
	@NotNull
	private String namaKota;
	
	private List<PendudukModel> listPenduduk;
}
