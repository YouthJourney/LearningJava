package com.hong.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * @version 1.0
 * @author 22053
 * @category Java,abstract,implements
 * @illustration 
 */

//交通工具抽象类
abstract class Transportation{
	public String transName;  //交通工具名称
	public Date setOffTime; //到站时间
	public Date returnTime; //返回时间
	public Date checkInTime; //取票时间
	public Date securityCheckTime; //安检时间
	public Date waitTime; //等候时间
	public double speed;  //车速
	public double unitPrice; //单价
	abstract ArrayList<String>cost(String departure,String destination,double disdance);//计算消耗的时间和金钱
	void TimeAndPrice(String departure,String distination,double distance) { //计算消耗的时间和价格
		ArrayList<String>list=cost(departure,distination,distance);  //时间和费用表
		System.out.println("乘坐"+transName+"花费时间: "+list.get(0)); //获取时间
		System.out.println("费用是："+list.get(1));  //获取费用
	}  
}

//汽车类
class Car extends Transportation{
	Car() {
		transName="汽车";
		SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");
		try {
			setOffTime=dateFormat.parse("00:10:00");
			returnTime=dateFormat.parse("00:10:00");
			checkInTime=dateFormat.parse("00:05:00");
			securityCheckTime=dateFormat.parse("00:05:00");
			waitTime=dateFormat.parse("00:20:00");
		}catch (ParseException e) {
			e.printStackTrace();
		}
		speed=100;
		unitPrice=0.32;
	}

	@Override
	ArrayList<String> cost(String departure, String destination, double disdance) {
		double money=disdance*unitPrice;
		double time=disdance/speed;
		double time_m=(time-(int)time)*60;
		double time_s=(time_m-(int)time_m)*60;
		String hour =String.valueOf((int)time);
		String minute=String.valueOf((int)time_m);
		String second=String.valueOf((int)time_s);
		SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");//HH大写代表24小时进制，hh小写代表12进制
		Date times=null;
		try {
			times=dateFormat.parse(hour+":"+minute+":"+second);
		}catch (ParseException e) {
			e.printStackTrace();
		}
		ArrayList<String>list=new ArrayList<String>();
		list.add(dateFormat.format(times));
		list.add(String.valueOf(money));
		return list;
	}
}

//高铁类
class HighSpeedRail extends Transportation{
	
	public HighSpeedRail() {
		transName="高铁";
		SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");
		try {
			setOffTime=dateFormat.parse("00:10:00");
			returnTime=dateFormat.parse("00:10:00");
			checkInTime=dateFormat.parse("00:05:00");
			securityCheckTime=dateFormat.parse("00:05:00");
			waitTime=dateFormat.parse("00:10:00");
		}catch (ParseException e) {
			e.printStackTrace();
		}
		speed=300;
		unitPrice=0.42;
	}
	@Override
	ArrayList<String> cost(String departure, String destination, double disdance) {
		double money=disdance*unitPrice;
		double time=disdance/speed;
		double time_m=(time-(int)time)*60;
		double time_s=(time_m-(int)time_m)*60;
		String hour =String.valueOf((int)time);
		String minute=String.valueOf((int)time_m);
		String second=String.valueOf((int)time_s);
		SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");
		Date times=null;
		try {
			times=dateFormat.parse(hour+":"+minute+":"+second);
		}catch (ParseException e) {
			e.printStackTrace();
		}
		
		ArrayList<String>list=new ArrayList<String>();
		list.add(dateFormat.format(times));
		list.add(String.valueOf(money));
		return list;
	}

	
}

//飞机类
class Aircraft extends Transportation{
	public Aircraft() {
		transName="飞机";
		SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");
		try {
			setOffTime=dateFormat.parse("00:20:00");
			returnTime=dateFormat.parse("00:20:00");
			checkInTime=dateFormat.parse("00:05:00");
			securityCheckTime=dateFormat.parse("00:10:00");
			waitTime=dateFormat.parse("00:5:00");
		}catch (ParseException e) {
			e.printStackTrace();
		}
		speed=900;
		unitPrice=0.75;
	}
	@Override
	ArrayList<String> cost(String departure, String destination, double disdance) {
		double money=disdance*unitPrice;
		double time=disdance/speed;
		double time_m=(time-(int)time)*60; //获取分钟
		double time_s=(time_m-(int)time_m)*60; //获取秒钟
		String hour =String.valueOf((int)time);  //时
		String minute=String.valueOf((int)time_m); //分
		String second=String.valueOf((int)time_s); //秒
		SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");
		Date times=null;
		try {
			times=dateFormat.parse(hour+":"+minute+":"+second);
		}catch (ParseException e) {
			e.printStackTrace();
		}
		
		ArrayList<String>list=new ArrayList<String>();
		list.add(dateFormat.format(times));
		list.add(String.valueOf(money));
		return list;
	}
	
}

//总控制类
public class MainControl {
	public void show() {
		Car car=new Car();  //创建Car对象
		HighSpeedRail highSpeedRail=new HighSpeedRail(); //创建HighSpeedRail对象
		Aircraft aircraft=new Aircraft();  //创建aircraft对象
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入出发地: ");
		String departure=scanner.nextLine();
		System.out.println("请输入目的地：");
		String distination=scanner.nextLine();
		System.out.println("请输入两地距离：");
		double distance=scanner.nextDouble();
		
		car.TimeAndPrice(departure, distination, distance);
		highSpeedRail.TimeAndPrice(departure, distination, distance);
		aircraft.TimeAndPrice(departure, distination, distance);
		scanner.close();
	}
	public static void main(String[] args) {
		MainControl test=new MainControl();
		test.show();
	}
}

