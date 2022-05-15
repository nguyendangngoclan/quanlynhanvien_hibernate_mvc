package edu.fa.repository;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.fa.model.NhanVien;
import edu.fa.util.ConnectionUtils;

@Repository
public class NhanVienRepository {

	@Autowired
	ConnectionUtils connectionUtils;

	public void themNhanVien(NhanVien nhanVien) {
		SessionFactory sessionFactory = connectionUtils.getSessionFactory();
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Serializable save = session.save(nhanVien);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
	}

	public List<NhanVien> getAllNhanVien() {
		SessionFactory sessionFactory = connectionUtils.getSessionFactory();
		List<NhanVien> nhanViens = new ArrayList<NhanVien>();
		try {
			Session session = sessionFactory.openSession();
			String sql = "SELECT n FROM NhanVien n";
			Query query = session.createQuery(sql);
			nhanViens = query.list();
			return nhanViens;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			sessionFactory.close();
		}
	}

	public List<NhanVien> getNhanVienById(int id) {
		SessionFactory sessionFactory = connectionUtils.getSessionFactory();
		try {
			Session session = sessionFactory.openSession();
			String sql = "FROM NhanVien WHERE id = :id";
			Query query = session.createQuery(sql);
			query.setParameter("id", id);
			List<NhanVien> nhanVien = (List<NhanVien>) query.list();
			return nhanVien;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			sessionFactory.close();
		}
	}

	public void updateNhanVien(NhanVien nhanVien) {
		SessionFactory sessionFactory = connectionUtils.getSessionFactory();
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			String sql = "UPDATE NhanVien SET hoTen = :hoTen, namSinh = :namSinh, queQuan = :queQuan, email = :email, loaiNhanVien = :loaiNhanVien WHERE idNhanvien = :idNhanvien";
			Query query = session.createQuery(sql);
			query.setParameter("hoTen", nhanVien.getHoTen());
			query.setParameter("namSinh", nhanVien.getNamSinh());
			query.setParameter("queQuan", nhanVien.getQueQuan());
			query.setParameter("email", nhanVien.getEmail());
			query.setParameter("loaiNhanVien", nhanVien.getLoaiNhanVien());
			query.setParameter("idNhanvien", nhanVien.getIdNhanvien());
			int result = query.executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			sessionFactory.close();
		}
	}

	public void deleteNhanVien(int id) {
		SessionFactory sessionFactory = connectionUtils.getSessionFactory();
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
//			String sql = "DELETE FROM NhanVien WHERE idNhanvien = :idNhanvien";
//			Query query = session.createQuery(sql);
//			query.setParameter("idNhanvien", id);
//			query.executeUpdate();
			List<NhanVien> listNV = new ArrayList<NhanVien>();
			listNV = getNhanVienById(id);
			session.delete(listNV.get(0));

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			sessionFactory.close();
		}
	}
}
