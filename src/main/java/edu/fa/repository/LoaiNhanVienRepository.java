package edu.fa.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.fa.model.LoaiNhanVien;
import edu.fa.util.ConnectionUtils;

@Repository
public class LoaiNhanVienRepository {

	@Autowired
	ConnectionUtils connectionUtils;

	public List<LoaiNhanVien> getAllLoaiNhanVien() {
		List<LoaiNhanVien> loaiNhanViens = new ArrayList<LoaiNhanVien>();
		SessionFactory sessionFactory = connectionUtils.getSessionFactory();
		try {
			Session session = sessionFactory.openSession();
			String sql = "SELECT l FROM LoaiNhanVien l";
			Query query = session.createQuery(sql);
			loaiNhanViens = query.list();
			return loaiNhanViens;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			sessionFactory.close();
		}
	}
}
