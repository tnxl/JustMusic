package com.wlg.bookstore.dao;

import com.wlg.bookstore.vo.User;

public interface IUserDAO {
	public void saveUser(User user);
	public User validateUser(String username, String password);
	public boolean exitUser(String username);
	
}
