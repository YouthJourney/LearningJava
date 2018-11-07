package com.hong.test;
/*@version 1.0
 *@author hong
 *@date 2018.11.7
 * 输出图案
 */

public class Pattern {
    public static void main(String[] args){
        for(int i=0;i<3;i++){
            for(int j=i;j<3;j++)
                System.out.printf(" ");
            for(int n=0;n<2*i+1;n++)
                System.out.print("*");
            System.out.print("\n");
            //System.out.println("\n");
        }
    }
}

//总结注意Java中三种输出的区别：print, printf, println
//print 将它的参数显示在命令窗口，并将输出光标定位在所显示的最后一个字符之后。
//println 将它的参数显示在命令窗口，并在结尾加上换行符，将输出光标定位在下一行的开始。(换行)
//printf 是格式化输出的形式。(与C语言相同)