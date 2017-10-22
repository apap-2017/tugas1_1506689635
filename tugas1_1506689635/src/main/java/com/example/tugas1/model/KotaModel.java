package com.example.tugas1.model;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class KotaModel {
	@NotNull
	private int id;
	@NotNull
	private String kodeKota;
	@NotNull
	private String namaKota;
	
	private List<KecamatanModel> kecamatan;
}
