package edu.fa.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fa.model.LoaiNhanVien;
import edu.fa.repository.LoaiNhanVienRepository;
import edu.fa.service.LoaiNhanVienService;

@Service
public class LoaiNhanVienServiceImpl implements LoaiNhanVienService {

	@Autowired
	LoaiNhanVienRepository loaiNhanVienRepository;

	public List<LoaiNhanVien> getAllLoaiNhanVien() {
		// TODO Auto-generated method stub
		return loaiNhanVienRepository.getAllLoaiNhanVien();
	}

}
