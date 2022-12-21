package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.anggotakeluargamodel;
import com.example.demo.service.IanggotakeluargaService;

@RestController
@CrossOrigin(origins = "http://localhost:8080" )
@RequestMapping("api/anggotakeluarga")
public class anggotakeluargaController {
	@Autowired
	IanggotakeluargaService ianggotakeluargaService;
	
	@PostMapping("/insert")
	public anggotakeluargamodel insertAnggotakeluarga(@RequestBody anggotakeluargamodel anggotakeluarga) {
		return ianggotakeluargaService.insertAnggotakeluarga(anggotakeluarga);
	}
	@GetMapping("/getAll")
	public List<anggotakeluargamodel> getaAllanggota(){
		return ianggotakeluargaService.getAllanggota();
	}
	@DeleteMapping("/delete/{id}")
	public anggotakeluargamodel deleteAnggota (@PathVariable long id) {
		return ianggotakeluargaService.deleteAnggota(id);
	}
	@PutMapping("/update/{id}")
	public anggotakeluargamodel updateAnggota(@PathVariable long id, @RequestBody anggotakeluargamodel anggotakeluarga) {
		return ianggotakeluargaService.updateAnggota(id, anggotakeluarga);
	}
	@GetMapping("/getAnggotaById/{id}")
	public anggotakeluargamodel getAnggotaById (@PathVariable long id){
		return ianggotakeluargaService.getAnggotaById(id);
	}
	
	@GetMapping("/getAnggotaKeluarga/{id}")
	public List<anggotakeluargamodel> getAnggotaKeluarga(@PathVariable long id) {
		return ianggotakeluargaService.getAnggotaKeluarga(id);
	}

}
