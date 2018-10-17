package com.hong.staffs;

import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.io.*;

@SuppressWarnings("unused")
class CompanyMember{
	public String name;	//姓名
	public int salarys=0;	//每月工资
	public String birthday;	//生日
}

class Staff extends CompanyMember{
	int totalSal;	//年总工资
	int giftMoney;	//礼物金额
	Staff(String name,int sal,String birth){
		this.name=name;
		salarys=sal;
		birthday=birth;
		Random  r = new Random();
		giftMoney=r.nextInt(400)+100;
	}
}

class Director extends CompanyMember{
	int totalSal;	//年总工资
	int giftMoney;	//礼物金额
	int totalBonus;	//年总奖金
	int bonus;	//奖金
	Director(String name,int sal,String birth){
		this.name=name;
		salarys=sal;
		birthday=birth;
		Random  r = new Random();
		giftMoney=r.nextInt(500)+500;
	}
}

class Shareholder extends CompanyMember{
	int dividend;	//分红
	double stock;	//股份
	Shareholder(String name,double st,String birth){
		this.name=name;
		birthday=birth;
		stock=st;
	}
}

class CompanyRecord{
	static ArrayList<String> month=new ArrayList<String>();
	ArrayList<String> info=new ArrayList<String>();	//用于存储输出到文件的信息
	CompanyRecord(){	//把01-12放入month中
		for(int j=1;j<=12;j++) {
			if(j<=9) {
				month.add("0"+Integer.toString(j));
			}
			else {
				month.add(Integer.toString(j));
			}
		}
	}
	public static LinkedList<Staff> memberStaff=new LinkedList<Staff>();	//公司职员表
	public static LinkedList<Director> memberDirector=new LinkedList<Director>(); //主管表
	public static LinkedList<Shareholder> memberShareholder=new LinkedList<Shareholder>(); //分红表
	
	public LinkedList<Staff> staff=new LinkedList<Staff>();//一个月内所有员工的记录
	public LinkedList<Director> director=new LinkedList<Director>();
	public LinkedList<Shareholder> shareholder=new LinkedList<Shareholder>();
	public static HashMap<String, CompanyRecord> memberMap=new HashMap<String,CompanyRecord>();//date与CompanyRecord的键值对
	static boolean staffRecord(String date) {
		if(memberMap.containsKey(date)) {
			String month=date.split("-")[1];
			CompanyRecord record=memberMap.get(date);
			for(Staff c:record.staff) {
				String staffMonth=c.birthday.split("-")[1];
				if(!staffMonth.equals(month)){	//当员工生日时有礼物
					String output=c.name+" 工资:"+c.salarys+" "+date;
					System.out.println(output);
					if(!record.info.contains(output))
						record.info.add(output);
				}			
				else{
					String output=c.name+" 工资:"+c.salarys+" 礼物:"+c.giftMoney+" "+date;
					System.out.println(output);
					if(!record.info.contains(output))
						record.info.add(output);
				}
			}
			return true;
		}
		else {
			return false;
		}	
	}
	
	static boolean directorRecord(String date) {
		if(memberMap.containsKey(date)) {
			String month=date.split("-")[1];
			CompanyRecord record=memberMap.get(date);
			for(Director c:record.director) {
				String directorMonth=c.birthday.split("-")[1];
				if(!directorMonth.equals(month))	//当经理生日时有礼物
				{
					String output=c.name+" 工资:"+c.salarys+" 奖金:"+c.bonus+" "+date;
					System.out.println(output);
					if(!record.info.contains(output))
						record.info.add(output);
				}			
				else{
					String output=c.name+" 工资:"+c.salarys+" 奖金:"+c.bonus+c.bonus+" 礼物:"+" "+date;
					System.out.println(output);
					if(!record.info.contains(output))
						record.info.add(output);
				}
			}
			return true;
		}
		else {
			return false;
		}	
	}
	
	static boolean shareholderRecord(String date) {
		if(memberMap.containsKey(date)) {
			String month=date.split("-")[1];
			CompanyRecord record=memberMap.get(date);
			for(Shareholder c:record.shareholder) {
				if(!month.equals("12"))	//股东只有12月有记录
					System.out.println("无记录!");
				else{
					String output=c.name+" 分红:"+c.dividend+" "+date;
					System.out.println(output);
					if(!record.info.contains(output))
						record.info.add(output);
				}
			}
			return true;
		}
		else {
			return false;
		}	
	}
	
	public static void printAllMember(String date,boolean txt) throws IOException {
		staffRecord(date);
		directorRecord(date);
		shareholderRecord(date);
		if(txt){
			CompanyRecord record=memberMap.get(date);
			FileWriter  w = new FileWriter ("info_output.txt",true);
	    	for(String s:record.info) {
				w.write(s);
				w.write("\r\n");
			}
	    	w.close();
			System.out.println("已成功输出txt文件！");
		}
			
	}

	public void ouputInfoToXML(String date){

	}
	
	public static int annualSalary(int year) {	//全年工资
		int total = 0;
		for(int i=0;i<12;i++) {
			String date=year+month.get(i);
			if(memberMap.containsKey(date)) {
				CompanyRecord record=memberMap.get(date);
				for(Staff c:record.staff) {
					String staffMonth=c.birthday.split("-")[1];
					if(!staffMonth.equals(month.get(i)))
						total=total+c.salarys;
					else
						total=total+c.salarys+c.giftMoney;			
				}//staff
				for(Director c:record.director) {
					String directorMonth=c.birthday.split("-")[1];
					if(!directorMonth.equals(month.get(i))) {
						total=total+c.salarys+c.bonus;
					}
					else {
						total=total+c.salarys+c.bonus+c.giftMoney;
					}
				}//director
			}//if
		}//for
		
		return total;		
	}
}

class StaffRecord{
	public HashMap<String,Staff> staff=new HashMap<String,Staff>();//一个员工的所有记录,键为日期
	public static HashMap<String, StaffRecord> staffMap=new HashMap<String,StaffRecord>();//键为姓名
	public boolean record(String name) {
		if(staffMap.containsKey(name)) {
			StaffRecord record=staffMap.get(name);
			for (Entry<String, Staff> entry : record.staff.entrySet()) {
				Staff temp=entry.getValue();
				String date=temp.birthday.split("-")[1];
				if(!date.equals(entry.getKey().split("-")[1])) {

					System.out.println(temp.name+" 工资:"+temp.salarys+" "+entry.getKey());
				}
				else {
					System.out.println(temp.name+" 工资:"+temp.salarys+" 礼物:"+temp.giftMoney+" "+entry.getKey());
				}
				}
			return true;
		}
		else {
			return false;
		}
	}
}

class DirectorRecord{
	public HashMap<String,Director> director=new HashMap<String,Director>();//一个经理的所有记录,键为日期
	public static HashMap<String, DirectorRecord> directorMap=new HashMap<String,DirectorRecord>();//键为姓名
	public boolean record(String name) {
		if(directorMap.containsKey(name)) {
			DirectorRecord record=directorMap.get(name);
			for (Entry<String, Director> entry : record.director.entrySet()) {
				Director temp=entry.getValue();
				String date=temp.birthday.split("-")[1];
				if(!date.equals(entry.getKey().split("-")[1])) {
					System.out.println(temp.name+" 工资:"+temp.salarys+" 奖金:"+temp.bonus+" "+entry.getKey());
				}
				else {
					System.out.println(temp.name+" 工资:"+temp.salarys+" 奖金:"+temp.bonus+" 礼物:"+temp.giftMoney+" "+entry.getKey());
				}
				}
			return true;
		}
		else {
			return false;
		}
	}
}

class ShareholderRecord{
	public HashMap<String,Shareholder> shareholder=new HashMap<String,Shareholder>();//一个股东的所有记录,键为日期
	public static HashMap<String, ShareholderRecord> shareholderMap=new HashMap<String,ShareholderRecord>();//键为姓名
	public boolean record(String name) {
		if(shareholderMap.containsKey(name)) {
			ShareholderRecord record=shareholderMap.get(name);
			for (Entry<String, Shareholder> entry : record.shareholder.entrySet()) {
				Shareholder temp=entry.getValue();
				String month=entry.getKey().split("-")[1];
				if(month.equals("12"))	//十二月份分红
					System.out.println(temp.name+" 分红:"+temp.dividend+" "+entry.getKey());	
			}
			return true;
		}
		else {
			return false;
		}
	}
}



class CompanyInOut{
	private double yearProfit;	//全年利润
	private double yearDividend;	//年终分红
	public boolean monthPayoff(String date){
		CompanyRecord temp=new CompanyRecord();
		@SuppressWarnings("unused")
		StaffRecord sr=new StaffRecord();
		@SuppressWarnings("unused")
		DirectorRecord dr=new DirectorRecord();
		@SuppressWarnings("unused")
		ShareholderRecord shr=new ShareholderRecord();
		for(Staff c:CompanyRecord.memberStaff) {
			c.totalSal+=c.salarys;
			temp.staff.add(c);
			StaffRecord.staffMap.get(c.name).staff.put(date, c);
		}
		for(Director c:CompanyRecord.memberDirector) {
			c.totalSal+=c.salarys;
			Random  r = new Random();
			c.bonus=r.nextInt(1000)+1000;
			c.totalBonus+=c.bonus;
			temp.director.add(c);
			DirectorRecord.directorMap.get(c.name).director.put(date, c);
		}
		if(date.split("-")[1].equals("12")) {	// 12月份分红
			Random  r = new Random();
			yearProfit=r.nextInt(900000)+100000;
			yearDividend = yearProfit*0.2;
			for(Shareholder c:CompanyRecord.memberShareholder) {
				Shareholder c2=new Shareholder(c.name,c.stock,c.birthday);
				c2.dividend=(int) (c2.stock * yearDividend);
				temp.shareholder.add(c2);
				ShareholderRecord.shareholderMap.get(c.name).shareholder.put(date, c2);
			}
		}
		
		if(CompanyRecord.memberMap.put(date, temp)==null)
			return true;
		else
			return false;
	}
}

public class StaffManagement {
	/**
	* 逻辑控制及菜单实现
	*/	
	public static void main(String args[]) {
		StaffManagement demo=new StaffManagement();
		ArrayList<Integer> serial=new ArrayList<Integer>(6);
		for(int i=1;i<=6;i++){
			serial.add(i);
		}
		while(true)
		{
			int input=printMenu();
			if (!(serial.contains(input)))
            	System.out.println("输入错误，请重新输入！");
	        else if(input==1){
				demo.addMember("张三","1998-06-06",1800,"员工");
				demo.addMember("王五", "1988-12-12", 2600, "员工");
				demo.addMember("李四","2000-02-02",8000,"经理");
				demo.addMember("股东01","1999-01-01",0.2,"股东");
				demo.addMember("股东02","1999-02-05",0.3,"股东");
				System.out.println("成员测试数据已添加!");
	        }
	        else if(input==2){
				CompanyInOut temp=new CompanyInOut();
				temp.monthPayoff("2018-10");
				temp.monthPayoff("2018-11");
				temp.monthPayoff("2018-12");
				System.out.println("工资测试数据已添加!");
	        }
			else if(input==3){
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
	        	System.out.println(">>>请输入要查询成员的姓名和职位:");
	        	String s = sc.nextLine();
	        	String[] arr=s.split(" ");
	        	if(arr[1].equals("员工")){
	        		StaffRecord sr=new StaffRecord();
					sr.record(arr[0]);
	        	}
	        	else if(arr[1].equals("经理")){
	        		DirectorRecord dr=new DirectorRecord();
					dr.record(arr[0]);
	        	}
	        	else if(arr[1].equals("股东")){
	        		ShareholderRecord sr=new ShareholderRecord();
					sr.record(arr[0]);
	        	}
			}
			else if(input==4){
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
	        	System.out.println(">>>请输入要查询的日期:");
	        	@SuppressWarnings("unused")
				CompanyInOut temp=new CompanyInOut();
				try {
					CompanyRecord.printAllMember(sc.nextLine(),false);
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
			else if(input==5){
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
            	System.out.println(">>>请输入要导出记录的日期:");
            	@SuppressWarnings("unused")
				CompanyInOut temp=new CompanyInOut();
            	try {
					CompanyRecord.printAllMember(sc.nextLine(),true);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else if(input==6){
				System.out.println("---------------------- 已退出 ----------------------");
				break;
			}
		}
		
	}
	public static int printMenu(){
		System.out.println("------------------ 工资福利发放管理平台 ------------------");
		System.out.println("1.添加公司成员");
		System.out.println("2.发放工资");
		System.out.println("3.成员记录查询");
		System.out.println("4.全体员工记录查询");
		System.out.println("5.工资发放记录导出");
		System.out.println("6.退出");
		System.out.print(">>>请输入:");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		return input;
	}

	public void addMember(String name,String birth,double sal,String type) {
		if(type.equals("员工")) {
			Staff s=new Staff(name,(int)sal,birth);
			CompanyRecord.memberStaff.add(s);
			StaffRecord s2=new StaffRecord();
			StaffRecord.staffMap.put(name,s2);
		}
		if(type.equals("经理")){
			Director d=new Director(name,(int)sal,birth);
			CompanyRecord.memberDirector.add(d);
			DirectorRecord s2=new DirectorRecord();
			DirectorRecord.directorMap.put(name,s2);
		}
		if(type.equals("股东")){
			Shareholder s=new Shareholder(name,sal,birth);	//sal为股份
			CompanyRecord.memberShareholder.add(s);
			ShareholderRecord s2=new ShareholderRecord();
			ShareholderRecord.shareholderMap.put(name,s2);
		}
	}
}
