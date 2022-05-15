package edu.fa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.fa.model.BangCap;
import edu.fa.model.LoaiNhanVien;
import edu.fa.model.NhanVien;
import edu.fa.service.BangCapService;
import edu.fa.service.LoaiNhanVienService;
import edu.fa.service.NhanVienService;

@Controller
public class NhanVienController {

	@Autowired
	NhanVienService nhanVienService;

	@Autowired
	LoaiNhanVienService loaiNhanVienService;

	@Autowired
	BangCapService bangCapService;

	@RequestMapping("showInsert")
	public String showInsert(Model model) {
		List<LoaiNhanVien> loaiNhanViens = new ArrayList<LoaiNhanVien>();
		loaiNhanViens = loaiNhanVienService.getAllLoaiNhanVien();
		model.addAttribute("loaiNV", loaiNhanViens);
		model.addAttribute("nhanvien", new NhanVien());
		return "themnhanvien";

	}

	@RequestMapping(value = "insertNhanVien", method = RequestMethod.POST)
	public String insertNhanVien(NhanVien nhanVien, Model model) {
		nhanVienService.themNhanVien(nhanVien);
		for (String strBangCap : nhanVien.getListBangCap()) {
			BangCap bangCap = new BangCap(strBangCap, nhanVien.getIdNhanvien());
			bangCapService.themBangCap(bangCap);
		}
		model.addAttribute("nhanvien", new NhanVien());
		return "redirect:/showInsert";
	}

	@RequestMapping("showListNhanVien")
	public String showListNhanVien(Model model) {
		List<NhanVien> listNhanVien = new ArrayList<NhanVien>();
		listNhanVien = nhanVienService.getAlNhanVien();
		model.addAttribute("listNhanVien", listNhanVien);
		return "danhsachnhanvien";
	}

	@RequestMapping("showUpdateNhanVien/{id}")
	public String showUpdateNhanVien(@PathVariable("id") int id, Model model) {
		List<NhanVien> listNhanVien = new ArrayList<NhanVien>();
		listNhanVien = nhanVienService.getNhanVienById(id);
		model.addAttribute("nhanvien", listNhanVien.get(0));
		String[] arrBangCap = new String[3];
		int idx = 0;
		int[] idBangCap = new int[3];
		if (listNhanVien.get(0).getBangCaps().size() > 0) {
			for (BangCap bangCap : listNhanVien.get(0).getBangCaps()) {
				arrBangCap[idx] = bangCap.getXepLoai();
				idBangCap[idx] = bangCap.getId();
				idx++;
			}
		}
		model.addAttribute("bangcap", arrBangCap);
		model.addAttribute("idBangCap", idBangCap);
		List<LoaiNhanVien> loaiNhanViens = new ArrayList<LoaiNhanVien>();
		loaiNhanViens = loaiNhanVienService.getAllLoaiNhanVien();
		model.addAttribute("loaiNV", loaiNhanViens);
		return "suanhanvien";
	}

	@RequestMapping(value = "updateNhanVien", method = RequestMethod.POST)
	public String updateNhanVien(@ModelAttribute("nhanvien") NhanVien nhanVien) {
		nhanVienService.updateNhanVien(nhanVien);
		int soLuongBangCap = nhanVien.getIdBangCap().length;
		for (int i = 0; i < soLuongBangCap; i++) {
			bangCapService.updateBangCap(
					new BangCap(nhanVien.getIdBangCap()[i], nhanVien.getListBangCap()[i], nhanVien.getIdNhanvien()));
		}
		return "redirect:/showListNhanVien";
	}

	@RequestMapping(value = "deleteNhanVien/{id}", method = RequestMethod.GET)
	public String deleteNhanVien(@PathVariable("id") int id, Model model) {
		nhanVienService.deleteNhanVien(id);
		return "redirect:/showListNhanVien";
	}
}
