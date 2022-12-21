package com.example.demo.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.anggotakeluargamodel;
import com.example.demo.repository.IanggotakeluargaRepo;

@Repository
public class anggotakeluargaRepo implements IanggotakeluargaRepo{

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public anggotakeluargamodel insertAnggotakeluarga(anggotakeluargamodel anggotakeluarga) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO tb_anggota_keluarga("
				+ "agama, "
				+ "id_kk, "
				+ "jenis_kelamin, "
				+ "kepala_keluarga, "
				+ "nama, "
				+ "nik, "
				+ "pendidikan, "
				+ "tanggal_lahir, "
				+ "tempat_lahir) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(query, new Object[] {
				anggotakeluarga.getAgama(),
				anggotakeluarga.getId_kk(),
				anggotakeluarga.getJenis_kelamin(),
				anggotakeluarga.getKepala_keluarga(),
				anggotakeluarga.getNama(),
				anggotakeluarga.getNik(),
				anggotakeluarga.getPendidikan(),
				anggotakeluarga.getTanggal_lahir(),
				anggotakeluarga.getTempat_lahir(),
				});
		return anggotakeluarga;
	}
	@Override
	public List<anggotakeluargamodel> getAllanggota() {
		// TODO Auto-generated method stub
		String query ="SELECT * FROM tb_anggota_keluarga";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(anggotakeluargamodel.class));
	}
	@Override
	public anggotakeluargamodel deleteAnggota(long id) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_anggota_keluarga WHERE id = ?";
		var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(anggotakeluargamodel.class), id);
		
		query = "DELETE FROM tb_anggota_keluarga WHERE id = ?";
		jdbcTemplate.update(query, id);
		return result;
	}
	@Override
	public anggotakeluargamodel updateAnggota(long id, anggotakeluargamodel anggotakeluarga) {
		// TODO Auto-generated method stub
		String query = "UPDATE tb_anggota_keluarga SET "
				+ "agama = ?, "
				+ "id_kk = ?, "
				+ "jenis_kelamin = ?, "
				+ "kepala_keluarga = ?, "
				+ "nama = ?, "
				+ "nik = ?, "
				+ "pendidikan = ?, "
				+ "tanggal_lahir = ?, "
				+ "tempat_lahir = ? "
				+ "WHERE id = ?";
		jdbcTemplate.update(query, new Object[] {
				anggotakeluarga.getAgama(),
				anggotakeluarga.getId_kk(),
				anggotakeluarga.getJenis_kelamin(),
				anggotakeluarga.getKepala_keluarga(),
				anggotakeluarga.getNama(),
				anggotakeluarga.getNik(),
				anggotakeluarga.getPendidikan(),
				anggotakeluarga.getTanggal_lahir(),
				anggotakeluarga.getTempat_lahir(), id});
		return anggotakeluarga;
	}
	@Override
	public anggotakeluargamodel getAnggotaById(long id) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_anggota_keluarga WHERE id = ? ";
		return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(anggotakeluargamodel.class), id);
	}
	
	@Override
	public List<anggotakeluargamodel> getAnggotaKeluarga(long id) {
		// TODO Auto-generated method stub
		String query ="SELECT * FROM tb_anggota_keluarga WHERE id_kk = ? ";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(anggotakeluargamodel.class), id);
	}
}
