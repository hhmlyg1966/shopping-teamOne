package com.scmpi.book.service.impl;

import com.scmpi.book.dao.*;
import com.scmpi.book.dao.impl.*;
import com.scmpi.book.entity.User;
import com.scmpi.book.service.UserService;
public class UserServiceImpl implements UserService {
    private UserDao dao=new UserDaoImpl();
    /**
     * ��¼
     */
	public User login(String name, String password) throws Exception{
		User u=dao.queryByName(name);
		if(u!=null){
			if(u.getPassword().equals(password)){
				return u;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	/**
	 * ����û���Ϣ
	 */
	public void addUser(User u) throws Exception {
		
		dao.addUser(u);
	}

}
