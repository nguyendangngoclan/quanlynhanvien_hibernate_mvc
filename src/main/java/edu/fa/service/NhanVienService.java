package edu.fa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.fa.model.NhanVien;

@Service
public interface NhanVienService {
	void themNhanVien(NhanVien nhanVien);

	List<NhanVien> getAlNhanVien();

	List<NhanVien> getNhanVienById(int id);

	void updateNhanVien(NhanVien nhanVien);

	void deleteNhanVien(int id);
}
