package edu.fa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.fa.model.LoaiNhanVien;


@Service
public interface LoaiNhanVienService {
	List<LoaiNhanVien> getAllLoaiNhanVien();
	
}
