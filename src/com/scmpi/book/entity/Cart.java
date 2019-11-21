package com.scmpi.book.entity;
import java.util.*;

public class Cart {  
	Map<Integer,OrderItem> map=new HashMap<Integer,OrderItem>();
	private double cost;
	
	public Map<Integer, OrderItem> getMap() {
		return map;
	}
	public void setMap(Map<Integer, OrderItem> map) {
		this.map = map;
	}
	public double getCost() {
		return this.sumCost();
	}
	public void setCost(double cost) {
		this.cost = cost;
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
			oim.setNumber(oim.getNumber()+oi.getNumber());
			oim.setCost(oim.getNumber()*oi.getP().getPrice());
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
		im.setNumber(oi.getNumber());
		im.setCost(oi.getP().getPrice()*im.getNumber());
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
	public double sumCost(){
		Collection<OrderItem> its=map.values();
		double sum=0.0;
		for(OrderItem oi:its){
			sum+=oi.getCost();
		}
		return sum;
		
	}

}
