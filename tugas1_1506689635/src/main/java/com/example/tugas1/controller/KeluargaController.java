package com.example.tugas1.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.tugas1.model.KecamatanModel;
import com.example.tugas1.model.KeluargaModel;
import com.example.tugas1.model.KelurahanModel;
import com.example.tugas1.model.KotaModel;
import com.example.tugas1.model.PendudukModel;
import com.example.tugas1.service.KecamatanService;
import com.example.tugas1.service.KeluargaService;
import com.example.tugas1.service.KelurahanService;
import com.example.tugas1.service.KotaService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class KeluargaController 
{

	@Autowired
    KeluargaService keluargaDAO;
	
	@Autowired
    KelurahanService kelurahanDAO;
	
	@Autowired
    KecamatanService kecamatanDAO;
	
	@Autowired
    KotaService kotaDAO;
	 
	 @RequestMapping("/keluarga")
	 	public String viewKeluarga(@RequestParam(value = "nkk", required = false) String nkk, Model model) {
		 KeluargaModel keluarga = keluargaDAO.selectDataKeluarga(nkk);
		 KelurahanModel kelurahan = kelurahanDAO.selectKelurahan(keluarga.getIdKelurahan());
		 KecamatanModel kecamatan = kecamatanDAO.selectKecamatan(kelurahan.getIdKecamatan());
		 KotaModel kota = kotaDAO.selectKota(kecamatan.getIdKota());
		 if (nkk != null) {
	            model.addAttribute ("keluarga", keluarga);
	            model.addAttribute ("kelurahan", kelurahan);
	            model.addAttribute ("kecamatan", kecamatan);
	            model.addAttribute ("kota", kota);
	            return "view-keluarga";
	        } else {
	            model.addAttribute ("nkk", nkk);
	            return "not-found";
	        }
	 }
	 
	 @RequestMapping("/keluarga/tambah")
	    public String tambahKeluarga (Model model) {
	    	KeluargaModel keluarga = new KeluargaModel();
		   	
	    	model.addAttribute("action", "/keluarga/tambah");
	    	model.addAttribute("keluarga", keluarga);
	    	return "add-keluarga";
	    }
	 @RequestMapping(value = "/keluarga/tambah", method = RequestMethod.POST)
	    public String tambahKeluarga (Model model, 
	    		@RequestParam(value = "kecamatan", required = false) String namaKecamatan,
	    		@RequestParam(value = "alamat", required = false) String alamat,
	    		@RequestParam(value = "RT", required = false) String RT,
	    		@RequestParam(value = "RW", required = false) String RW,
	    		@RequestParam(value = "kelurahan", required = false) String idKelurahan,
	    		@RequestParam(value = "kota", required = false) String namaKota,
	    		@RequestParam(value = "kelurahan", required = false) String namaKelurahan,
	    		@ModelAttribute KeluargaModel keluarga) {

	    	String date = new SimpleDateFormat("ddMMyy").format(Calendar.getInstance().getTime());
	    	
	    	String kode_kecamatan = kecamatanDAO.selectKodeKecamatanNKK(namaKecamatan).substring(0,6);
	    	
	    	String id_kelurahan = kelurahanDAO.selectKelurahanId(namaKelurahan); 
	    	
	    	String prefix = kode_kecamatan + date;
	    	String query = prefix + "%";
	    	
	    	int hitungKeluarga = keluargaDAO.countKeluarga(query);
	    	
	    	String nomor_kk = prefix + String.format("%04d", hitungKeluarga + 1);
	    	
	    	keluarga.setNomorKK(nomor_kk);
	    	keluarga.setIdKelurahan(id_kelurahan);
	    	
	    	keluargaDAO.addKeluarga(keluarga);
			model.addAttribute("nomor_kk", keluarga.getNomorKK());
			return "add-keluarga-sukses";
	    	
	    }
	 @RequestMapping("/keluarga/ubah/{nkk}")
	    public String updateKeluarga(@PathVariable(value = "nkk") String nkk, Model model) {
	    	
	    	KeluargaModel keluarga = keluargaDAO.selectKeluargaNKK (nkk);
	    	KelurahanModel kelurahan = kelurahanDAO.selectKelurahan(keluarga.getIdKelurahan());
	    	KecamatanModel kecamatan = kecamatanDAO.selectKecamatan(kelurahan.getIdKecamatan());
	    	KotaModel kota = kotaDAO.selectKota(kecamatan.getIdKota());
	    	String namaKelurahan = kelurahan.getNamaKelurahan();
	    	String namaKecamatan = kecamatan.getNamaKecamatan();
	    	String namaKota = kota.getNamaKota(); 
	    	keluarga.setNamaKelurahan(namaKelurahan);
	    	keluarga.setNamaKecamatan(namaKecamatan);
	    	keluarga.setNamaKota(namaKota);
	    	
	        if(keluarga == null) {
	        	model.addAttribute("nkk", nkk);
	        	return "not-found";
	        }
	        model.addAttribute("keluarga", keluarga);
	    	return "update-keluarga";
	    }
	    
	    @RequestMapping(value ="/keluarga/ubah/{nkk}", method = RequestMethod.POST)
	    public String updateKeluarga (@PathVariable(value = "nkk", required = false) String nkk,
	    		@RequestParam(value = "kecamatan", required = false) String namaKecamatan,
	    		@RequestParam(value = "alamat", required = false) String alamat,
	    		@RequestParam(value = "RT", required = false) String RT,
	    		@RequestParam(value = "RW", required = false) String RW,
	    		@RequestParam(value = "kelurahan", required = false) String idKelurahan,
	    		@RequestParam(value = "kota", required = false) String namaKota,
	    		@RequestParam(value = "kelurahan", required = false) String namaKelurahan,@ModelAttribute KeluargaModel keluarga, Model model) {
	    	
	    	String date = new SimpleDateFormat("ddMMyy").format(Calendar.getInstance().getTime());
	    	
	    	String kode_kecamatan = kecamatanDAO.selectKodeKecamatanNKK(keluarga.getNamaKecamatan()).substring(0,6);
	    	String id_kelurahan = kelurahanDAO.selectKelurahanId(keluarga.getNamaKelurahan()); 
	    	
	    	String prefix = kode_kecamatan + date;
	    	String query = prefix + "%";
	    	
	    	int hitungKeluarga = keluargaDAO.countKeluarga(query);
	    	
	    	String nomor_kk = prefix + String.format("%04d", hitungKeluarga + 1);
	    	String oldNKK = nkk;
	    	
	    	keluarga.setNomorKK(nomor_kk);
	    	keluarga.setIdKelurahan(id_kelurahan);	
	    	
	    	keluargaDAO.updateKeluarga(keluarga);
			model.addAttribute("nkk", oldNKK);	        
	        return "update-keluarga-sukses";
	    }
}
