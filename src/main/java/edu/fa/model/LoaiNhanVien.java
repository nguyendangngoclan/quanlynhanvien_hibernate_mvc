package edu.fa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "LoaiNhanVien")
@Table(name = "LOAINHANVIEN")
public class LoaiNhanVien {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String loaiNhanVien;

	@OneToMany(mappedBy = "loaiNV", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<NhanVien> nhanViens = new ArrayList<NhanVien>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoaiNhanVien() {
		return loaiNhanVien;
	}

	public void setLoaiNhanVien(String loaiNhanVien) {
		this.loaiNhanVien = loaiNhanVien;
	}

	public List<NhanVien> getNhanViens() {
		return nhanViens;
	}

	public void setNhanViens(List<NhanVien> nhanViens) {
		this.nhanViens = nhanViens;
	}

	public LoaiNhanVien() {
		super();
	}

	public LoaiNhanVien(String loaiNhanVien) {
		super();
		this.loaiNhanVien = loaiNhanVien;
	}

	public LoaiNhanVien(int id, String loaiNhanVien) {
		super();
		this.id = id;
		this.loaiNhanVien = loaiNhanVien;
	}

//	public LoaiNhanVien(String loaiNhanVien, List<NhanVien> nhanViens) {
//		super();
//		this.loaiNhanVien = loaiNhanVien;
//		this.nhanViens = nhanViens;
//	}
//
//	public LoaiNhanVien(int id, String loaiNhanVien, List<NhanVien> nhanViens) {
//		super();
//		this.id = id;
//		this.loaiNhanVien = loaiNhanVien;
//		this.nhanViens = nhanViens;
//	}

}
