package com.example.tugas1.model;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class KelurahanModel {
	@NotNull
	private int id;
	@NotNull
	private String kodeKelurahan;
	@NotNull
	private String idKecamatan;
	@NotNull
	private String namaKelurahan;
	@NotNull
	private String kodePos;
	
	private List<KeluargaModel> keluarga;
}
