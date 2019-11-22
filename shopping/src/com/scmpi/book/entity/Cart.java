package com.scmpi.book.entity;
import java.util.*;

public class Cart {  
	Map<Integer,OrderItem> map=new HashMap<Integer,OrderItem>();
	private float total_amount;	//�ܼ�
	
	public float getTotal_amount() {
		return this.sumAmount();
	}
	public void setTotal_amount(float total_amount) {
		this.total_amount = total_amount;
	}
	public Map<Integer, OrderItem> getMap() {
		return map;
	}
	public void setMap(Map<Integer, OrderItem> map) {
		this.map = map;
	}
	
	/**
	 * @description 1:��һ�����ʱ��map.put����ֱ�Ӽӵ���������
	 *              2:�ڶ��λ��߶�����ʱ��Ҫ���Ѿ���Ӻõ�OrderItem�ҳ��������������޸�
	 * @version 1.0
	 * @param oi 
	 *        ��ӵ�map��������
	 * @return void
	 */
	public void addItem(OrderItem oi){
		Integer pi=oi.getP().getPid();
		if(map.containsKey(pi)){
			OrderItem oim=map.get(pi);
//			oim.setNumber(oim.getNumber()+oi.getNumber());
			oim.setOrder_num(oim.getOrder_num()+oi.getOrder_num());	//�����Ʒ
			oim.setOrder_subtotal((oim.getOrder_num()*oi.getP().getPrice())); //����С�Ƽ۸�
		}else{
			map.put(pi, oi);
		}
	}
	/**
	 * @description �޸ļ���map�����orderItem������ 
	 * @version 1.0
	 * @param oi
	 */
	public void modifyNumber(OrderItem oi){
		Integer pid=oi.getP().getPid();
		OrderItem im=map.get(pid);
//		im.setNumber(oi.getNumber());
		im.setOrder_num(oi.getOrder_num());
//		im.setCost(oi.getP().getPrice()*im.getNumber());
		im.setOrder_subtotal(oi.getP().getPrice()*im.getOrder_num()); //�޸�����
	}
	/**
	 *
	 * @description ����pidɾ��map�����еĶ���
	 * @version 1.0
	 * @param pid
	 */
	public void removeOrderItem(Integer pid){
		map.remove(pid);
	}
	public void clear(){
		map.clear();
	}
	public float sumAmount(){
		Collection<OrderItem> its=map.values();
		float sum=0;
		for(OrderItem oi:its){
			sum+=oi.getOrder_subtotal();
		}
		return sum;
		
	}

}
