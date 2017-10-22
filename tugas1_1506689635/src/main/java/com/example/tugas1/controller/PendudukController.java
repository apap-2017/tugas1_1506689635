package com.example.tugas1.controller;

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
import com.example.tugas1.service.PendudukService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PendudukController 
{
	@Autowired
    PendudukService pendudukDAO;
    
	@Autowired
    KeluargaService keluargaDAO;

    @Autowired
    KelurahanService kelurahanDAO;
    
    @Autowired
    KecamatanService kecamatanDAO;

    @Autowired
    KotaService kotaDAO;
	 
    @RequestMapping("/")
    public String index ()
    {
        return "index";
    }
	 
	 @RequestMapping("/penduduk")
	 public String viewPenduduk(@RequestParam(value = "nik", required = false) String nik, Model model) {
	 PendudukModel penduduk = pendudukDAO.selectPenduduk(nik);
	 if (penduduk == null) {
		 model.addAttribute ("nik", nik);
		 return "not-found";
         }else{
        	 model.addAttribute ("penduduk", penduduk);
        	 KeluargaModel keluarga = keluargaDAO.selectKeluarga(penduduk.getIdKeluarga());
        	 model.addAttribute("keluarga", keluarga);
        	 KelurahanModel kelurahan = kelurahanDAO.selectKelurahan(keluarga.getIdKelurahan());
        	 model.addAttribute("kelurahan", kelurahan);
        	 KecamatanModel kecamatan = kecamatanDAO.selectKecamatan(kelurahan.getIdKecamatan());
        	 model.addAttribute("kecamatan", kecamatan);
        	 KotaModel kota = kotaDAO.selectKota(kecamatan.getIdKota());
        	 model.addAttribute("kota", kota);
        	 return "view-penduduk";
	  }
	 }
	 @RequestMapping("/penduduk/tambah")
	    public String tambahPenduduk (Model model){
	    	PendudukModel penduduk = new PendudukModel();
	    	   	
	    	model.addAttribute("action", "/penduduk/tambah");
	    	model.addAttribute("penduduk", penduduk);
	    	return "add-penduduk";
	    }
	    
	    @RequestMapping(value = "/penduduk/tambah", method = RequestMethod.POST)
	    public String tambahPenduduk (Model model, @ModelAttribute PendudukModel penduduk){
	    	
	    	String[] tanggal_lahir = penduduk.getTanggalLahir().split("-");
	    	int tahun = (Integer.parseInt(tanggal_lahir[0]) % 1000) %100;
	    	int bulan = (Integer.parseInt(tanggal_lahir[1]));
	    	int hari = (Integer.parseInt(tanggal_lahir[2]));
	    	
	    	if(penduduk.getJenisKelamin() == 1) {
	    		hari += 40;
	    	}
	   
	    	String id_kelurahan = pendudukDAO.selectPendudukID(penduduk.getIdKeluarga());
	    	String kode_kecamatan = kecamatanDAO.selectKodeKecamatan(id_kelurahan).substring(0, 6);
	    	
	    	String prefix = kode_kecamatan + String.format("%02d", hari) + String.format("%02d", bulan) + String.format("%02d", tahun);
	    	String query = prefix + "%";
	    	
	    	int hitungPenduduk = pendudukDAO.countPenduduk(query);
	   
	    	String getNewNIK = prefix + String.format("%04d", hitungPenduduk + 1);
	    	
	    	penduduk.setNik(getNewNIK);
	    	
	    	pendudukDAO.addPenduduk(penduduk);
	    	model.addAttribute("nik", penduduk.getNik());
	    	return "add-penduduk-sukses";
	    }  
	    
	    @RequestMapping("/penduduk/ubah/{nik}")
	    public String updatePenduduk(@PathVariable(value = "nik") String nik, Model model) {
	    	
	    	PendudukModel penduduk = pendudukDAO.selectPenduduk (nik);

	        if(penduduk == null) {
	        	model.addAttribute("nik", nik);
	        	return "not-found";
	        }
	        model.addAttribute("penduduk", penduduk);
	    	return "update-penduduk";
	    }
	    
	    @RequestMapping(value ="/penduduk/ubah/{nik}", method = RequestMethod.POST)
	    public String updatePenduduk (@ModelAttribute PendudukModel penduduk, Model model, @RequestParam(value = "golonganDarah", required = false) String golonganDarah) {
	    	
	    	String[] tanggal_lahir = penduduk.getTanggalLahir().split("-");
	    	int tahun = (Integer.parseInt(tanggal_lahir[0]) % 1000) %100;
	    	int bulan = (Integer.parseInt(tanggal_lahir[1]));
	    	int hari = (Integer.parseInt(tanggal_lahir[2]));
	    	
	    	if(penduduk.getJenisKelamin() == 1) {
	    		hari += 40;
	    	}
	   
	    	String id_kelurahan = pendudukDAO.selectPendudukID(penduduk.getIdKeluarga());
	    	String kode_kecamatan = kecamatanDAO.selectKodeKecamatan(id_kelurahan).substring(0, 6);
	    	
	    	String prefix = kode_kecamatan + String.format("%02d", hari) + String.format("%02d", bulan) + String.format("%02d", tahun);
	    	String query = prefix + "%";
	    	
	    	int hitungPenduduk = pendudukDAO.countPenduduk(query);
	   
	    	String getNewNIK = prefix + String.format("%04d", hitungPenduduk + 1);
	    	String oldNIK = penduduk.getNik();
	    	penduduk.setGolonganDarah(golonganDarah);
	    	
	    	penduduk.setNik(getNewNIK);
	    	
	        pendudukDAO.updatePenduduk(penduduk);
	        model.addAttribute("nik", oldNIK);
	        
	        return "update-penduduk-sukses";
	    }
	    @RequestMapping(value="/penduduk/mati", method = RequestMethod.POST)
		 public String pendudukMati(Model model,  @ModelAttribute PendudukModel penduduk) {
	    	penduduk = pendudukDAO.selectPenduduk(penduduk.getNik());
	    	penduduk.setIsWafat(1);
	    	String nik = penduduk.getNik();
	    	log.info(penduduk.getNama());
	    	log.info(penduduk.getNik());
	    	pendudukDAO.updatePenduduk(penduduk);
	    	model.addAttribute("nik", nik);
	    	return "update-penduduk-mati";
	    }
	    
}