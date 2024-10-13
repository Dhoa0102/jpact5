package vn.iotstar.service.Impl;

import vn.iotstar.entity.User;
import vn.iotstar.service.IUserService;

import java.awt.Image;

import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.impl.UserDaoImpl;

public class UserServiceImpl implements IUserService {
	IUserDao userDao=new UserDaoImpl();

	@Override
	public User login(String username, String password) {
		User user = this.findByUsername(username);
		if (user != null && password.equals(user.getPassword())) {
		return user;
		}
		return null;
	}

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean register(String username, String password, String email, String fullname, String phone, boolean admin) {
		if (userDao.checkExistUsername(username)) {
			return false;
			}
			long millis=System.currentTimeMillis(); 
			java.sql.Date date=new java.sql.Date(millis);
			userDao.insert(new User(username,true,admin,email,phone,fullname,password,""));
			return true;
	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}

	@Override
	public boolean updatePassword(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePhone(int id, String phone) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateFullname(int id, String fullname) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateImages(int id, String images) {
		// TODO Auto-generated method stub
		return false;
	}
}
