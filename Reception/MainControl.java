package com.hong.staffs;

import java.util.Scanner;

interface Reception{
	double eat();
	double live();
	double wlak();
	void ConDetails(String departure,String distination,int day, double distance);
}
interface Gift{
	double sendGift();
}
class Student implements Reception{

	@Override
	public double eat() {
		return 30;
	}

	@Override
	public double live() {
		return 80;
	}

	@Override
	public double wlak() {
		return 0.35;
	}

	@Override
	public void ConDetails(String departure, String distination, int day, double distance) {
		System.out.println("\nѧ��");
		System.out.println("������: "+eat()*day+"Ԫ");
		System.out.println("ס����: "+live()*day+"Ԫ");
		System.out.println("������: "+wlak()*distance+"Ԫ");
		System.out.println("�ܹ������ˣ�"+(eat()*day+live()*day+wlak()*distance)+"Ԫ");
	}
	
}

class Teacher implements Reception{

	@Override
	public double eat() {
		return 30;
	}

	@Override
	public double live() {
		return 80;
	}

	@Override
	public double wlak() {
		return 0.35;
	}

	@Override
	public void ConDetails(String departure, String distination, int day, double distance) {
		System.out.println("\n��ʦ");
		System.out.println("������: "+eat()*day+"Ԫ");
		System.out.println("ס����: "+live()*day+"Ԫ");
		System.out.println("������: "+wlak()*distance+"Ԫ");
		System.out.println("�ܹ������ˣ�"+(eat()*day+live()*day+wlak()*distance)+"Ԫ");
	}
	
}

class Parents implements Reception{

	@Override
	public double eat() {
		return 30;
	}

	@Override
	public double live() {
		return 80;
	}

	@Override
	public double wlak() {
		return 0.35;
	}

	@Override
	public void ConDetails(String departure, String distination, int day, double distance) {
		System.out.println("\n�ҳ�");
		System.out.println("������: "+eat()*day+"Ԫ");
		System.out.println("ס����: "+live()*day+"Ԫ");
		System.out.println("������: "+wlak()*distance+"Ԫ");
		System.out.println("�ܹ������ˣ�"+(eat()*day+live()*day+wlak()*distance)+"Ԫ");
	}
	
}

class Leader implements Reception,Gift{

	@Override
	public double sendGift() {
		return 1000;
	}

	@Override
	public double eat() {
		return 100;
	}

	@Override
	public double live() {
		return 80;
	}

	@Override
	public double wlak() {
		return 0.75;
	}

	@Override
	public void ConDetails(String departure, String distination, int day, double distance) {
		System.out.println("\n�쵼");
		System.out.println("������: "+eat()*day+"Ԫ");
		System.out.println("ס����: "+live()*day+"Ԫ");
		System.out.println("������: "+wlak()*distance+"Ԫ");
		System.out.println("��������: "+sendGift()+"Ԫ");
		System.out.println("�ܹ������ˣ�"+(eat()*day+live()*day+wlak()*distance+sendGift())+"Ԫ");
	}
	
}

class ForGuest implements Reception,Gift{

	@Override
	public double sendGift() {
		return 500;
	}

	@Override
	public double eat() {
		return 100;
	}

	@Override
	public double live() {
		return 80;
	}

	@Override
	public double wlak() {
		return 0.75;
	}

	@Override
	public void ConDetails(String departure, String distination, int day, double distance) {
		System.out.println("\n���");
		System.out.println("������: "+eat()*day+"Ԫ");
		System.out.println("ס����: "+live()*day+"Ԫ");
		System.out.println("������: "+wlak()*distance+"Ԫ");
		System.out.println("��������: "+sendGift()+"Ԫ");
		System.out.println("�ܹ������ˣ�"+(eat()*day+live()*day+wlak()*distance+sendGift())+"Ԫ");
	}
	
}

public class MainControl {
	public void show() {
		Student student = new Student();
		Teacher teacher = new Teacher();
		Parents parents = new Parents();
		Leader leader = new Leader();
		ForGuest forGuest = new ForGuest();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("����������أ�");
		String departure = scanner.nextLine();
		System.out.println("������Ŀ�ĵأ�");
		String distination = scanner.nextLine();
		System.out.println("������Ӵ�������");
		int day = scanner.nextInt();
		System.out.println("��������룺");
		double distance = scanner.nextDouble();
		
		student.ConDetails(departure, distination, day, distance);
		teacher.ConDetails(departure, distination, day, distance);
		parents.ConDetails(departure, distination, day, distance);
		leader.ConDetails(departure, distination, day, distance);
		forGuest.ConDetails(departure, distination, day, distance);
		scanner.close();
	}
	public static void main(String[] args) {
		MainControl test = new MainControl();
		test.show();
	}

}
