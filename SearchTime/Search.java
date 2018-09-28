package com.search.time;

import java.util.ArrayList;
import java.util.List;

public class Search {
	//private static final int COUNT=1000;  //һǧ��
	//private static final int COUNT=10000;  //һ��
	//private static final int COUNT=100000;  //ʮ��
	//private static final int COUNT=500000;  //��ʮ��
	private static final int COUNT=1000000;  //һ����
	private static ArrayList<Object>arrayList=new ArrayList<Object>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("......��ʼ��������.........");
		///�������ݲ��ԣ�
		insertData(arrayList, "ArrayList");
		
		System.out.println("......��ʼ��ȡ����..........");
		///��ȡ���ݲ���
		readAccessData(arrayList, "ArrayList");
		
		System.out.println("......��ʼɾ������............");
		///ɾ�����ݲ���
		deleteData(arrayList, "ArrayList");
		
	}
	
	/**
	 * �������ݣ���ͳ�Ʋ���ʱ��
	 */
	private static void insertData(List<Object>list,String name) {
		long startTime=System.currentTimeMillis();
		
		//��list��0λ�ÿ�ʼ�����COUNT����
		for(int i=0;i<COUNT;i++) {
			list.add(0,i);
		}
		
		long endTime =System.currentTimeMillis();
		long inteval=endTime-startTime;
		System.out.println(name+": ����"+COUNT+"��Ԫ�أ�ʹ�õ�ʱ���ǣ�"+inteval+"ms");
	}
	
	/**
	 * ɾ��Ԫ�أ���ͳ��ɾ��ʱ�䣻
	 */
	
	private static void deleteData(List<Object>list,String name) {
		long startTime =System.currentTimeMillis();
		
		//ɾ��Ԫ�أ�
		for(int i=0;i<COUNT;i++)
		{
			list.remove(0);
		}
		long endTime= System.currentTimeMillis();
		long inteval=endTime-startTime;
		System.out.println(name+": ɾ��"+COUNT+"��Ԫ�أ���Ҫ��ʱ���ǣ�"+inteval+"ms");	
	}
	
	/**
	 * ��ȡ���ݣ���ͳ��ʱ��
	 */
	
	private static void readAccessData(List<Object>list,String name) {
		long startTime =System.currentTimeMillis();
		
		//��ȡlist����
		for(int i=0;i<COUNT;i++) {
			list.get(i);
		}
		long endTime=System.currentTimeMillis();
		long inteval=endTime-startTime;
		
		System.out.println(name+": ��ȡ"+COUNT+"��Ԫ�أ���Ҫ��ʱ���ǣ�"+inteval+"ms");
	}
	
}
