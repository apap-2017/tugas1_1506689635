package com.example.tugas1.model;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class KecamatanModel {
	@NotNull
	private int id;
	@NotNull
	private String kodeKecamatan;
	@NotNull
	private String idKota;
	@NotNull
	private String namaKecamatan;
	
	private List<KelurahanModel> listKelurahan;
}
