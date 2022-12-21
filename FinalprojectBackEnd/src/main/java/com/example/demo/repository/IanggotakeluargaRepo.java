package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.anggotakeluargamodel;

public interface IanggotakeluargaRepo {
	public anggotakeluargamodel insertAnggotakeluarga (anggotakeluargamodel anggotakeluarga);
	public List<anggotakeluargamodel> getAllanggota();
	public anggotakeluargamodel updateAnggota(long id, anggotakeluargamodel anggotakeluarga);
	public anggotakeluargamodel deleteAnggota (long id);
	public anggotakeluargamodel getAnggotaById (long id);
	public List<anggotakeluargamodel> getAnggotaKeluarga(long id);
}
