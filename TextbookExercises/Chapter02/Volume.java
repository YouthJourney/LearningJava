package com.hong.test;

import java.util.Scanner;

public class Volume {
    void SphereVol(double radius){
        double pi=3.14;
        double volume=(4.0/3.0)*pi*radius*radius*radius; //Π取自定义的3.14
        double volume1=(4.0/3.0)*Math.PI*Math.pow(radius,3);//Π取系统PI，比较精确，调用数学基本函数使用“Math.函数名”
        System.out.println("该球体的体积是："+volume+" "+volume1);
    }
    public static void main(String[] args){
        System.out.println("请输入球体的半径：");
        Volume volume=new Volume();
        Scanner scanner = new Scanner(System.in);
        double r=scanner.nextDouble();
        volume.SphereVol(r);
        System.out.println(27*3.14); //验证4/3是否为double型
    }
}
