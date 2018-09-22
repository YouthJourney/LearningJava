/**
@version 1.0
@author Hong
@rule 猜对数字得一分，猜错得零分
*/

import java.util.*;
import java.lang.String;
import java.util.Random;

public class GuessGame {
	public int counter; //得分
	Scanner input;
	
	public GuessGame() {
		counter=0;
		input=new Scanner(System.in);
	}
	
	public int inputNum() {
		return input.nextInt();
	}
	
	public boolean isTrue(int randnum,int num) {
		if(randnum==num) {
			counter++;
			return true;
			
		}else {
			return false;
		}
	}
	public int RandomNum() {
		System.out.println("随机数已经生成,随机数在0~9的整数: ");
		Random random=new Random();
		
		return random.nextInt(10); //产生0~9的随机整数；
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int randNum,num;
		GuessGame player=new GuessGame();
		while(true) {
			//生成随机数
			randNum=player.RandomNum();	
			System.out.println("请输入你猜的数字(你只有3次机会)");
			for(int i=3;i>0;i--) {
				num=player.inputNum();
				if(player.isTrue(randNum, num)) {
					System.out.println("你猜对了,你的得分是："+player.counter);
					break;
				}else {
					if(i-1!=0)
						System.out.println("你猜错了,你还有"+(i-1)+"次机会");
						
					else {
						System.out.println("你猜错了,已经没有机会了。");
						System.out.println("最终得分："+player.counter);
						System.out.println("随机数为："+randNum);
					}
						
				}
			}
			System.out.println("游戏结束，按“1”，重玩，按“0”退出");
			if(player.inputNum()==0)
				break;
			else
				player.counter=0;//重置分数为0			
		}		
	}
}