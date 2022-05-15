package edu.fa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "BangCap")
@Table(name = "BANGCAP")
public class BangCap {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String xepLoai;
	private int idNhanVien;

	@ManyToOne
	@JoinColumn(name = "idNhanVien", insertable = false, updatable = false)
	private NhanVien nhanVien;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getXepLoai() {
		return xepLoai;
	}

	public void setXepLoai(String xepLoai) {
		this.xepLoai = xepLoai;
	}

	public int getIdNhanVien() {
		return idNhanVien;
	}

	public void setIdNhanVien(int idNhanVien) {
		this.idNhanVien = idNhanVien;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public BangCap() {
		super();
	}

	public BangCap(String xepLoai, int idNhanVien) {
		super();
		this.xepLoai = xepLoai;
		this.idNhanVien = idNhanVien;
	}

	public BangCap(int id, String xepLoai, int idNhanVien) {
		super();
		this.id = id;
		this.xepLoai = xepLoai;
		this.idNhanVien = idNhanVien;
	}

	public BangCap(String xepLoai, int idNhanVien, NhanVien nhanVien) {
		super();
		this.xepLoai = xepLoai;
		this.idNhanVien = idNhanVien;
		this.nhanVien = nhanVien;
	}

	public BangCap(int id, String xepLoai, int idNhanVien, NhanVien nhanVien) {
		super();
		this.id = id;
		this.xepLoai = xepLoai;
		this.idNhanVien = idNhanVien;
		this.nhanVien = nhanVien;
	}

}
