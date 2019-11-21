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
		//����session�����û���Ϣ
    	HttpSession session=req.getSession(true);
        UserService uservice= new UserServiceImpl();
        try{
        	User u=uservice.login(name, password);
        	session.setAttribute("user", u);
        	//��ѯ�õ�����ͼ����Ϣ
        	Cart c=new Cart();//���ﳵ
        	session.setAttribute("cart", c);
        	req.getRequestDispatcher("/servlet/PageServlet").forward(req,res);
        }catch(Exception e){
        	 //e.printStackTrace();
           req.getRequestDispatcher("/login.jsp").forward(req, res);	
        }
	}

}
