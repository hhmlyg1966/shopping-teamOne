package com.scmpi.book.util;
import java.sql.*;
public class CheckId {
	
	public  static Integer  getOid(String tableName) throws Exception{

		  ResultSet rs=null;
		  try{
	
		   int i=1;
		   //����Ĵ������жϱ�����û�м�¼
		   String sql2="select oid from "+tableName;
		   rs=DBUtil.queryData(sql2);
		   boolean b=rs.next();//b=true[֤�����������ݣ���Ҫ���и���]b=false[����û�����ݣ����Ҫ���в���]
		   if(!b){
		    //����û�����ݣ��ҾͲ���
		     String sql1="insert into "+tableName+"(oid) values("+i+")";
		     DBUtil.Update(sql1);
		     //�Ҳ�ѯ�ղ���ļ�¼,rs��������¸�ֵ
		     String sql4="select oid from "+tableName;
		     rs=DBUtil.queryData(sql4);
		     rs.next();
		   }else{
		    //���������ݣ��Ҵӽ�������ó�������ĸ���Ҫ�ڴλ����ϼ�һ
		    int j=rs.getInt(1);
		    String sql3="update "+tableName+" set oid ="+(j+1);
		    DBUtil.Update(sql3);
		 
		    //�Ҳ�ѡ�ո��µļ�¼,rs��������¸�ֵ
		    String sql5="select oid from "+tableName;
		    rs=DBUtil.queryData(sql5);
		    rs.next();
		   }
		   int oid=rs.getInt(1);//��rs�����������Ҫ������
		   return oid;
		  }finally{
		  
		  }
		 }


}
