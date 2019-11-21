package com.scmpi.book.util;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public  class  DBUtil {
	//��������
private static String driverName=null;
private static String connUrl=null;
private static String user=null;
private static String password=null;
private static Connection conn=null;
private static ResultSet rs=null;
private static Statement stm=null;
 static//��̬��
 {
	InputStream ips=null;
	try
	{
		ips=DBUtil.class.getResourceAsStream("DBConfig.properties");
		Properties prop=new Properties();
		prop.load(ips);
		driverName=prop.getProperty("driverName");
		connUrl=prop.getProperty("connUrl");
		user=prop.getProperty("user");
		password=prop.getProperty("password");
		System.out.println("start to SQL driver");
		ips.close();
	}catch(Exception e)
	{
		e.getStackTrace();
	}

 }
 //��ȡ���ݿ�����
public static Connection getConnection() throws ClassNotFoundException, SQLException
 {
	
	 Class.forName(driverName);
	 conn=DriverManager.getConnection(connUrl,user,password);
	 return conn;
 }
 //���ݲ�ѯ
 public static ResultSet queryData(String sql) throws ClassNotFoundException
 {
	Statement stm=null;
	try
	{
	 conn=getConnection();
	 stm=conn.createStatement();
	 rs=stm.executeQuery(sql);
	}catch(SQLException e)
	{
		e.printStackTrace();
	}

	return rs;
 }
 // ���ݸ���
 public static boolean Update(String sql) throws ClassNotFoundException
 {  int a=0;
	try {
		conn=getConnection();
		stm=conn.createStatement();
		 a=stm.executeUpdate(sql);
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	finally
	{

		 if(rs!=null)
		 {
			 try {
					rs.close();
				} catch (SQLException e) {
					rs=null;
				} 
		 }
		 if(stm!=null)
			{
				try {
					stm.close();
				} catch (SQLException e) {
					stm=null;
				}
			}
		if(conn!=null)
			{
				try {
					conn.close();
				} catch (SQLException e) {
					conn=null;
				}
			}
	 
	}
	if(a>0)
	{
		return true;
	}
	else
	{
	return false;
	}
	
 }
 //�ر����ݿ�
 public static void closeConnection()
 {
	 if(rs!=null)
	 {
		 try {
				rs.close();
			} catch (SQLException e) {
				rs=null;
			} 
	 }
	 if(stm!=null)
		{
			try {
				stm.close();
			} catch (SQLException e) {
				stm=null;
			}
		}
	if(conn!=null)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				conn=null;
			}
		}
 }
}
