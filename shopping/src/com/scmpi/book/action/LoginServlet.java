package com.scmpi.book.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scmpi.book.entity.Cart;
import com.scmpi.book.entity.User;
import com.scmpi.book.service.*;
import com.scmpi.book.service.impl.*;
public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String name = req.getParameter("userName");
		String password = req.getParameter("userPassword");
		//创建session保存用户信息
    	HttpSession session=req.getSession(true);
        UserService uservice= new UserServiceImpl();
        try{
        	User u=uservice.login(name, password);
        	
        	if(u ==null){
        		throw new Exception("can not find user or passwd not mach");
        	}
        	session.setAttribute("user", u);
        	//查询得到所有图书信息
        	Cart c=new Cart();//购物车
        	session.setAttribute("cart", c);
        	req.getRequestDispatcher("/servlet/PageServlet").forward(req,res);
        }catch(Exception e){
        	 //e.printStackTrace();
        
           req.getRequestDispatcher("/login.jsp").forward(req, res);	
        }
	}

}
