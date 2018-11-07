package games;

import java.awt.Point;
import java.util.Random;
import java.util.Scanner;

class Player{
	public int chance; //玩家一共可猜次数
	public int score;  //用户得分
	
	public Player() {  //初始化；
		chance=3;
		score=0;
	}
	
	public Point guessPosition() {  //输入你猜的点的坐标。
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		System.out.print("输入你猜的战舰的坐标(范围在0-6，不包括6)：");	
		Point point=new Point(in.nextInt(), in.nextInt());
		chance--;
		return point;
	}
}

class WarShip{
	private Point bodyPoint; //战舰身体位置（击中就炸毁）
	private Point headPoint; //战舰头部（击中受伤）
	private Point footPoint; //战舰尾部，击中受伤
	
	public int life; //设置战舰生命值
	
	public WarShip() {
		Random random=new Random();
		//设置战舰的位置是随机的[0-6)
		int bodyX=random.nextInt(6);
		int bodyY=random.nextInt(6);
		bodyPoint=new Point(bodyX, bodyY);
		//bodyPoint的后一个点为headPoint
		headPoint=new Point(bodyX+1, bodyY);
		footPoint=new Point(bodyX-1, bodyY);
		System.out.println("为便于测试，打印出bodyPoint点："+bodyPoint);
		life=2;
	}
	
	public int getLife() {
		return life;
	}
	
	//设置战舰的血量
	public void setLife(int life) {
		this.life = life;
	}
	//获取船身体位置
	public Point getBodyPoint() {
		return bodyPoint;
	}
	//获取船头位置
	public Point getHeadPoint() {
		return headPoint;
	}
	//获取船尾位置
	public Point getFootPoint() {
		return footPoint;
	}
}

public class GameLauncher {
	
	/**
	 * 判断是否击中，并返回得分
	 * @param point 用户输入的point
	 * @param warShip 战舰类，包括战舰的位置，血量
	 * @return
	 */
	public static int judgehit(Point point,WarShip warShip) {
		int score=0;//记录得分
		//击中身体
		if(point.equals(warShip.getBodyPoint())) {
			//如果击中身体
			score+=2;
			warShip.setLife(0);
		}
		//击中头部
		if(point.equals(warShip.getHeadPoint())){
			score+=1;
			System.out.println("战舰已经受伤加油！");
			warShip.life--;
		}
		//击中尾部
		if(point.equals(warShip.getFootPoint())) {
			score+=1;
			System.out.println("战舰已经受伤加油！");
			warShip.life--;
		}
		return score;
	}
	public static void main(String[] args) {
		WarShip warShip=new WarShip();
		Player player=new Player();
		int chance= player.chance;
		//用户猜战舰位置
		for (int i = chance; i >0; i--) {
			Point guessPoint=player.guessPosition();
			
			player.score+=GameLauncher.judgehit(guessPoint, warShip);
			if(warShip.life<=0) {
				System.out.println("你已经胜利");
				break;
			}else {
				System.out.println("加油，你还有"+i+"机会");
			}
		}
		if(warShip.life>0) {
			System.out.println("你失败了");
		}
		System.out.println("你的最终得分为："+player.score);

	}
}
