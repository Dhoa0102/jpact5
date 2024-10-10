package vn.iotstar.dao.impl;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import vn.iotstar.configs.JPAConfig;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.entity.Category;
import vn.iotstar.entity.User;

public class UserDaoImpl implements IUserDao {

	@Override
	public void insert(User user) {
		EntityManager enma=JPAConfig.getEntityManager();
		EntityTransaction trans=enma.getTransaction();
		try {
			trans.begin();
			enma.persist(user);//insert
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}
		finally {
			enma.close();
		}

	}

	@Override
	public void update(User user) {
		EntityManager enma=JPAConfig.getEntityManager();
		EntityTransaction trans=enma.getTransaction();
		try {
			trans.begin();
			enma.merge(user);//update
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}
		finally {
			enma.close();
		}

	}

	@Override
	public void delete(int id) throws Exception {
		EntityManager enma=JPAConfig.getEntityManager();
		EntityTransaction trans=enma.getTransaction();
		try {
			trans.begin();
			User user=enma.find(User.class, id);
			if(user!=null) {
				enma.remove(user);
			}else {
				throw new Exception("Khong tim thay");
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}
		finally {
			enma.close();
		}

	}

	@Override
	public User findByUsername(String username) {
		EntityManager enma=JPAConfig.getEntityManager();
		User user=enma.find(User.class, username);
		return user;
	}

	@Override
	public List<User> findAll() {
		EntityManager enma=JPAConfig.getEntityManager();
		TypedQuery<User> query=enma.createNamedQuery("User.findAll", User.class);
		return query.getResultList();

	}

	@Override
	public List<User> findAll(int page, int pagesize) {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<User> query = enma.createNamedQuery("User.findAll", User.class);
		query.setFirstResult(page*pagesize);
		query.setMaxResults(pagesize);
		return query.getResultList();

	}

	@Override
	public int count() {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "Select count(c) from User c";
		Query query= enma.createQuery(jpql);
		return ((Long)query.getSingleResult()).intValue();

	}

}
