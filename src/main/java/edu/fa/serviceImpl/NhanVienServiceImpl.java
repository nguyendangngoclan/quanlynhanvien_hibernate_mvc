package edu.fa.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fa.model.NhanVien;
import edu.fa.repository.NhanVienRepository;
import edu.fa.service.NhanVienService;

@Service
public class NhanVienServiceImpl implements NhanVienService {

	@Autowired
	NhanVienRepository nhanVienRepository;

	public void themNhanVien(NhanVien nhanVien) {
		nhanVienRepository.themNhanVien(nhanVien);

	}

	public List<NhanVien> getAlNhanVien() {
		return nhanVienRepository.getAllNhanVien();
	}

	public List<NhanVien> getNhanVienById(int id) {
		return nhanVienRepository.getNhanVienById(id);
	}

	public void updateNhanVien(NhanVien nhanVien) {
		nhanVienRepository.updateNhanVien(nhanVien);

	}

	public void deleteNhanVien(int id) {
		nhanVienRepository.deleteNhanVien(id);

	}

}
