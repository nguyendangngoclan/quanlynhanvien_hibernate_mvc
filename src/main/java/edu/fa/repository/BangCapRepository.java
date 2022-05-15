package edu.fa.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.fa.model.BangCap;
import edu.fa.model.NhanVien;
import edu.fa.util.ConnectionUtils;

@Repository
public class BangCapRepository {

	@Autowired
	ConnectionUtils connectionUtils;

	public void themBangCap(BangCap bangCap) {
		SessionFactory sessionFactory = connectionUtils.getSessionFactory();
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(bangCap);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
	}

	public void updateBangCap(BangCap bangCap) {
		SessionFactory sessionFactory = connectionUtils.getSessionFactory();
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			String sql = "UPDATE BangCap SET xepLoai = :xepLoai WHERE id = :id";
			Query query = session.createQuery(sql);
			query.setParameter("xepLoai", bangCap.getXepLoai());
			query.setParameter("id", bangCap.getId());
			int result = query.executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
