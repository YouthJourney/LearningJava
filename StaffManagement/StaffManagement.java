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
	public String name;	//����
	public int salarys=0;	//ÿ�¹���
	public String birthday;	//����
}

class Staff extends CompanyMember{
	int totalSal;	//���ܹ���
	int giftMoney;	//������
	Staff(String name,int sal,String birth){
		this.name=name;
		salarys=sal;
		birthday=birth;
		Random  r = new Random();
		giftMoney=r.nextInt(400)+100;
	}
}

class Director extends CompanyMember{
	int totalSal;	//���ܹ���
	int giftMoney;	//������
	int totalBonus;	//���ܽ���
	int bonus;	//����
	Director(String name,int sal,String birth){
		this.name=name;
		salarys=sal;
		birthday=birth;
		Random  r = new Random();
		giftMoney=r.nextInt(500)+500;
	}
}

class Shareholder extends CompanyMember{
	int dividend;	//�ֺ�
	double stock;	//�ɷ�
	Shareholder(String name,double st,String birth){
		this.name=name;
		birthday=birth;
		stock=st;
	}
}

class CompanyRecord{
	static ArrayList<String> month=new ArrayList<String>();
	ArrayList<String> info=new ArrayList<String>();	//���ڴ洢������ļ�����Ϣ
	CompanyRecord(){	//��01-12����month��
		for(int j=1;j<=12;j++) {
			if(j<=9) {
				month.add("0"+Integer.toString(j));
			}
			else {
				month.add(Integer.toString(j));
			}
		}
	}
	public static LinkedList<Staff> memberStaff=new LinkedList<Staff>();	//��˾ְԱ��
	public static LinkedList<Director> memberDirector=new LinkedList<Director>(); //���ܱ�
	public static LinkedList<Shareholder> memberShareholder=new LinkedList<Shareholder>(); //�ֺ��
	
	public LinkedList<Staff> staff=new LinkedList<Staff>();//һ����������Ա���ļ�¼
	public LinkedList<Director> director=new LinkedList<Director>();
	public LinkedList<Shareholder> shareholder=new LinkedList<Shareholder>();
	public static HashMap<String, CompanyRecord> memberMap=new HashMap<String,CompanyRecord>();//date��CompanyRecord�ļ�ֵ��
	static boolean staffRecord(String date) {
		if(memberMap.containsKey(date)) {
			String month=date.split("-")[1];
			CompanyRecord record=memberMap.get(date);
			for(Staff c:record.staff) {
				String staffMonth=c.birthday.split("-")[1];
				if(!staffMonth.equals(month)){	//��Ա������ʱ������
					String output=c.name+" ����:"+c.salarys+" "+date;
					System.out.println(output);
					if(!record.info.contains(output))
						record.info.add(output);
				}			
				else{
					String output=c.name+" ����:"+c.salarys+" ����:"+c.giftMoney+" "+date;
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
				if(!directorMonth.equals(month))	//����������ʱ������
				{
					String output=c.name+" ����:"+c.salarys+" ����:"+c.bonus+" "+date;
					System.out.println(output);
					if(!record.info.contains(output))
						record.info.add(output);
				}			
				else{
					String output=c.name+" ����:"+c.salarys+" ����:"+c.bonus+c.bonus+" ����:"+" "+date;
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
				if(!month.equals("12"))	//�ɶ�ֻ��12���м�¼
					System.out.println("�޼�¼!");
				else{
					String output=c.name+" �ֺ�:"+c.dividend+" "+date;
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
			System.out.println("�ѳɹ����txt�ļ���");
		}
			
	}

	public void ouputInfoToXML(String date){

	}
	
	public static int annualSalary(int year) {	//ȫ�깤��
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
	public HashMap<String,Staff> staff=new HashMap<String,Staff>();//һ��Ա�������м�¼,��Ϊ����
	public static HashMap<String, StaffRecord> staffMap=new HashMap<String,StaffRecord>();//��Ϊ����
	public boolean record(String name) {
		if(staffMap.containsKey(name)) {
			StaffRecord record=staffMap.get(name);
			for (Entry<String, Staff> entry : record.staff.entrySet()) {
				Staff temp=entry.getValue();
				String date=temp.birthday.split("-")[1];
				if(!date.equals(entry.getKey().split("-")[1])) {

					System.out.println(temp.name+" ����:"+temp.salarys+" "+entry.getKey());
				}
				else {
					System.out.println(temp.name+" ����:"+temp.salarys+" ����:"+temp.giftMoney+" "+entry.getKey());
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
	public HashMap<String,Director> director=new HashMap<String,Director>();//һ����������м�¼,��Ϊ����
	public static HashMap<String, DirectorRecord> directorMap=new HashMap<String,DirectorRecord>();//��Ϊ����
	public boolean record(String name) {
		if(directorMap.containsKey(name)) {
			DirectorRecord record=directorMap.get(name);
			for (Entry<String, Director> entry : record.director.entrySet()) {
				Director temp=entry.getValue();
				String date=temp.birthday.split("-")[1];
				if(!date.equals(entry.getKey().split("-")[1])) {
					System.out.println(temp.name+" ����:"+temp.salarys+" ����:"+temp.bonus+" "+entry.getKey());
				}
				else {
					System.out.println(temp.name+" ����:"+temp.salarys+" ����:"+temp.bonus+" ����:"+temp.giftMoney+" "+entry.getKey());
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
	public HashMap<String,Shareholder> shareholder=new HashMap<String,Shareholder>();//һ���ɶ������м�¼,��Ϊ����
	public static HashMap<String, ShareholderRecord> shareholderMap=new HashMap<String,ShareholderRecord>();//��Ϊ����
	public boolean record(String name) {
		if(shareholderMap.containsKey(name)) {
			ShareholderRecord record=shareholderMap.get(name);
			for (Entry<String, Shareholder> entry : record.shareholder.entrySet()) {
				Shareholder temp=entry.getValue();
				String month=entry.getKey().split("-")[1];
				if(month.equals("12"))	//ʮ���·ݷֺ�
					System.out.println(temp.name+" �ֺ�:"+temp.dividend+" "+entry.getKey());	
			}
			return true;
		}
		else {
			return false;
		}
	}
}



class CompanyInOut{
	private double yearProfit;	//ȫ������
	private double yearDividend;	//���շֺ�
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
		if(date.split("-")[1].equals("12")) {	// 12�·ݷֺ�
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
	* �߼����Ƽ��˵�ʵ��
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
            	System.out.println("����������������룡");
	        else if(input==1){
				demo.addMember("����","1998-06-06",1800,"Ա��");
				demo.addMember("����", "1988-12-12", 2600, "Ա��");
				demo.addMember("����","2000-02-02",8000,"����");
				demo.addMember("�ɶ�01","1999-01-01",0.2,"�ɶ�");
				demo.addMember("�ɶ�02","1999-02-05",0.3,"�ɶ�");
				System.out.println("��Ա�������������!");
	        }
	        else if(input==2){
				CompanyInOut temp=new CompanyInOut();
				temp.monthPayoff("2018-10");
				temp.monthPayoff("2018-11");
				temp.monthPayoff("2018-12");
				System.out.println("���ʲ������������!");
	        }
			else if(input==3){
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
	        	System.out.println(">>>������Ҫ��ѯ��Ա��������ְλ:");
	        	String s = sc.nextLine();
	        	String[] arr=s.split(" ");
	        	if(arr[1].equals("Ա��")){
	        		StaffRecord sr=new StaffRecord();
					sr.record(arr[0]);
	        	}
	        	else if(arr[1].equals("����")){
	        		DirectorRecord dr=new DirectorRecord();
					dr.record(arr[0]);
	        	}
	        	else if(arr[1].equals("�ɶ�")){
	        		ShareholderRecord sr=new ShareholderRecord();
					sr.record(arr[0]);
	        	}
			}
			else if(input==4){
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
	        	System.out.println(">>>������Ҫ��ѯ������:");
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
            	System.out.println(">>>������Ҫ������¼������:");
            	@SuppressWarnings("unused")
				CompanyInOut temp=new CompanyInOut();
            	try {
					CompanyRecord.printAllMember(sc.nextLine(),true);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else if(input==6){
				System.out.println("---------------------- ���˳� ----------------------");
				break;
			}
		}
		
	}
	public static int printMenu(){
		System.out.println("------------------ ���ʸ������Ź���ƽ̨ ------------------");
		System.out.println("1.��ӹ�˾��Ա");
		System.out.println("2.���Ź���");
		System.out.println("3.��Ա��¼��ѯ");
		System.out.println("4.ȫ��Ա����¼��ѯ");
		System.out.println("5.���ʷ��ż�¼����");
		System.out.println("6.�˳�");
		System.out.print(">>>������:");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		return input;
	}

	public void addMember(String name,String birth,double sal,String type) {
		if(type.equals("Ա��")) {
			Staff s=new Staff(name,(int)sal,birth);
			CompanyRecord.memberStaff.add(s);
			StaffRecord s2=new StaffRecord();
			StaffRecord.staffMap.put(name,s2);
		}
		if(type.equals("����")){
			Director d=new Director(name,(int)sal,birth);
			CompanyRecord.memberDirector.add(d);
			DirectorRecord s2=new DirectorRecord();
			DirectorRecord.directorMap.put(name,s2);
		}
		if(type.equals("�ɶ�")){
			Shareholder s=new Shareholder(name,sal,birth);	//salΪ�ɷ�
			CompanyRecord.memberShareholder.add(s);
			ShareholderRecord s2=new ShareholderRecord();
			ShareholderRecord.shareholderMap.put(name,s2);
		}
	}
}
