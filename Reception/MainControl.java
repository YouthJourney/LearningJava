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
		System.out.println("\n学生");
		System.out.println("吃用了: "+eat()*day+"元");
		System.out.println("住用了: "+live()*day+"元");
		System.out.println("行用了: "+wlak()*distance+"元");
		System.out.println("总共花费了："+(eat()*day+live()*day+wlak()*distance)+"元");
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
		System.out.println("\n教师");
		System.out.println("吃用了: "+eat()*day+"元");
		System.out.println("住用了: "+live()*day+"元");
		System.out.println("行用了: "+wlak()*distance+"元");
		System.out.println("总共花费了："+(eat()*day+live()*day+wlak()*distance)+"元");
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
		System.out.println("\n家长");
		System.out.println("吃用了: "+eat()*day+"元");
		System.out.println("住用了: "+live()*day+"元");
		System.out.println("行用了: "+wlak()*distance+"元");
		System.out.println("总共花费了："+(eat()*day+live()*day+wlak()*distance)+"元");
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
		System.out.println("\n领导");
		System.out.println("吃用了: "+eat()*day+"元");
		System.out.println("住用了: "+live()*day+"元");
		System.out.println("行用了: "+wlak()*distance+"元");
		System.out.println("礼物用了: "+sendGift()+"元");
		System.out.println("总共花费了："+(eat()*day+live()*day+wlak()*distance+sendGift())+"元");
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
		System.out.println("\n外宾");
		System.out.println("吃用了: "+eat()*day+"元");
		System.out.println("住用了: "+live()*day+"元");
		System.out.println("行用了: "+wlak()*distance+"元");
		System.out.println("礼物用了: "+sendGift()+"元");
		System.out.println("总共花费了："+(eat()*day+live()*day+wlak()*distance+sendGift())+"元");
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
		System.out.println("请输入出发地：");
		String departure = scanner.nextLine();
		System.out.println("请输入目的地：");
		String distination = scanner.nextLine();
		System.out.println("请输入接待天数：");
		int day = scanner.nextInt();
		System.out.println("请输入距离：");
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
