package com.scmpi.book.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scmpi.book.entity.Cart;
import com.scmpi.book.entity.OrderItem;
import com.scmpi.book.service.ProductService;
import com.scmpi.book.service.impl.ProductServiceImpl;

public class AddCartServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
	     String name=new String(req.getParameter("pname").getBytes("iso-8859-1"),"utf-8");
		HttpSession session=req.getSession(true);
		//��ȡ���ﳵ
		Cart c=(Cart)session.getAttribute("cart");
		ProductService pservice =new ProductServiceImpl();
		try{
			OrderItem oi=new OrderItem();//���������
			oi.setNumber(1);
			oi.setP(pservice.queryByName(name));
			oi.setCost(pservice.queryByName(name).getPrice()*oi.getNumber());
			c.addItem(oi);//����������빺�ﳵ
			//req.getRequestDispatcher("/servlet/PageServlet").forward(req,res);
			req.setAttribute("datas",session.getAttribute("datas"));
			req.setAttribute("pageNo", session.getAttribute("pageNo"));
			req.setAttribute("pageSize", session.getAttribute("pageSize"));
			req.setAttribute("recordCount", session.getAttribute("recordCount"));
		    req.getRequestDispatcher("/queryProduct.jsp").forward(req,res);
		}catch(Exception e){
			req.getRequestDispatcher("/error.jsp").forward(req,res);
		}
		
	}
    
}
