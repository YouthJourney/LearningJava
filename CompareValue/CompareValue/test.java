package com.hong.value;

import java.util.ArrayList;

//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List; �İ��Զ����δʹ��

public class test {
	public static void main(String[] args) {
		java.util.List<Integer> list01=new ArrayList<>(1);
		@SuppressWarnings("deprecation")
		Integer integer =new Integer(10);  //�߰汾��������д������Ȼ����
		list01.add(integer);
		
		Integer integer1=list01.get(0);
		int cnt=integer.intValue();
		
		System.out.println(integer);
		System.out.println(integer1);
		System.out.println(cnt);
		System.out.println(integer.equals(integer1));
	}
}
