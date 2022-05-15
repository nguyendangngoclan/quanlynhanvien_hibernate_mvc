package edu.fa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name = "NhanVien")
@Table(name = "NHANVIEN")
public class NhanVien {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idNhanvien;
	private String hoTen;
	private int namSinh;
	private String queQuan;
	private String email;
	private int loaiNhanVien;

	@ManyToOne
	@JoinColumn(name = "loaiNhanVien", insertable = false, updatable = false)
	private LoaiNhanVien loaiNV;

	@OneToMany(mappedBy = "nhanVien", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<BangCap> bangCaps = new ArrayList<BangCap>();
//	private Set<BangCap> bangCaps = new HashSet<BangCap>();

//	@OneToOne
//	private BangCap bangCap;

	@Transient
	private String[] listBangCap;

	@Transient
	private Integer[] idBangCap;

	public Integer[] getIdBangCap() {
		return idBangCap;
	}

	public void setIdBangCap(Integer[] idBangCap) {
		this.idBangCap = idBangCap;
	}

	public int getIdNhanvien() {
		return idNhanvien;
	}

	public void setIdNhanvien(Integer idNhanvien) {
		this.idNhanvien = idNhanvien;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public String getQueQuan() {
		return queQuan;
	}

	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getLoaiNhanVien() {
		return loaiNhanVien;
	}

	public void setLoaiNhanVien(Integer loaiNhanVien) {
		this.loaiNhanVien = loaiNhanVien;
	}

	public LoaiNhanVien getLoaiNV() {
		return loaiNV;
	}

	public void setLoaiNV(LoaiNhanVien loaiNV) {
		this.loaiNV = loaiNV;
	}

	public List<BangCap> getBangCaps() {
		return bangCaps;
	}

	public void setBangCaps(List<BangCap> bangCaps) {
		this.bangCaps = bangCaps;
	}

	public String[] getListBangCap() {
		return listBangCap;
	}

//	public Set<BangCap> getBangCaps() {
//		return bangCaps;
//	}
//
//	public void setBangCaps(Set<BangCap> bangCaps) {
//		this.bangCaps = bangCaps;
//	}

	public void setListBangCap(String[] listBangCap) {
		this.listBangCap = listBangCap;
	}

	public NhanVien() {
		super();
	}

	public NhanVien(String hoTen, int namSinh, String queQuan, String email, int loaiNhanVien) {
		super();
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.queQuan = queQuan;
		this.email = email;
		this.loaiNhanVien = loaiNhanVien;
	}

	public NhanVien(int idNhanvien, String hoTen, int namSinh, String queQuan, String email, int loaiNhanVien) {
		super();
		this.idNhanvien = idNhanvien;
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.queQuan = queQuan;
		this.email = email;
		this.loaiNhanVien = loaiNhanVien;
	}

//	public NhanVien(String hoTen, int namSinh, String queQuan, String email, int loaiNhanVien, LoaiNhanVien loaiNV,
//			Set<BangCap> bangCaps, String[] listBangCap, int[] idBangCap) {
//		super();
//		this.hoTen = hoTen;
//		this.namSinh = namSinh;
//		this.queQuan = queQuan;
//		this.email = email;
//		this.loaiNhanVien = loaiNhanVien;
//		this.loaiNV = loaiNV;
//		this.bangCaps = bangCaps;
//		this.listBangCap = listBangCap;
//		this.idBangCap = idBangCap;
//	}
//
//	public NhanVien(int idNhanvien, String hoTen, int namSinh, String queQuan, String email, int loaiNhanVien,
//			LoaiNhanVien loaiNV, Set<BangCap> bangCaps, String[] listBangCap, int[] idBangCap) {
//		super();
//		this.idNhanvien = idNhanvien;
//		this.hoTen = hoTen;
//		this.namSinh = namSinh;
//		this.queQuan = queQuan;
//		this.email = email;
//		this.loaiNhanVien = loaiNhanVien;
//		this.loaiNV = loaiNV;
//		this.bangCaps = bangCaps;
//		this.listBangCap = listBangCap;
//		this.idBangCap = idBangCap;
//	}

	public NhanVien(String hoTen, int namSinh, String queQuan, String email, Integer loaiNhanVien, LoaiNhanVien loaiNV,
			List<BangCap> bangCaps, String[] listBangCap) {
		super();
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.queQuan = queQuan;
		this.email = email;
		this.loaiNhanVien = loaiNhanVien;
		this.loaiNV = loaiNV;
		this.bangCaps = bangCaps;
		this.listBangCap = listBangCap;
	}

	public NhanVien(int idNhanvien, String hoTen, int namSinh, String queQuan, String email, Integer loaiNhanVien,
			LoaiNhanVien loaiNV, List<BangCap> bangCaps, String[] listBangCap) {
		super();
		this.idNhanvien = idNhanvien;
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.queQuan = queQuan;
		this.email = email;
		this.loaiNhanVien = loaiNhanVien;
		this.loaiNV = loaiNV;
		this.bangCaps = bangCaps;
		this.listBangCap = listBangCap;
	}

	public NhanVien(String hoTen, int namSinh, String queQuan, String email, int loaiNhanVien, LoaiNhanVien loaiNV,
			List<BangCap> bangCaps, String[] listBangCap, Integer[] idBangCap) {
		super();
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.queQuan = queQuan;
		this.email = email;
		this.loaiNhanVien = loaiNhanVien;
		this.loaiNV = loaiNV;
		this.bangCaps = bangCaps;
		this.listBangCap = listBangCap;
		this.idBangCap = idBangCap;
	}

	public NhanVien(int idNhanvien, String hoTen, int namSinh, String queQuan, String email, int loaiNhanVien,
			LoaiNhanVien loaiNV, List<BangCap> bangCaps, String[] listBangCap, Integer[] idBangCap) {
		super();
		this.idNhanvien = idNhanvien;
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.queQuan = queQuan;
		this.email = email;
		this.loaiNhanVien = loaiNhanVien;
		this.loaiNV = loaiNV;
		this.bangCaps = bangCaps;
		this.listBangCap = listBangCap;
		this.idBangCap = idBangCap;
	}

}
