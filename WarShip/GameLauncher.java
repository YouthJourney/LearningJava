package com.hong.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//战舰类
class WarShip{
	private String warName; //战舰名称
	private String[] position; //战舰位置
	private String[] hitPosition; //击中位置
	private boolean status; //当前状态
	private int hitCnt; //击中次数
	public WarShip(String warName) { //初始化战舰信息
		this.warName=warName;
	}
	
	public boolean hitFlag(String gussPosi) {
		
		return true;
	}
	
	public void createPosition(){
		
	}
}

//玩家类
class Player{
	private List<String>hitHistory;
	private String achievement;
	public Player() {
		hitHistory=new ArrayList<String>();
	}
	public boolean hit(WarShip warShip) {
		Scanner scanner=new Scanner(System.in);
		
		scanner.close();
		return true;
	}
}

//游戏类
class GameMain{
	WarShip warShip;
	Player player;
	
	public GameMain() {
		player=new Player();
	}
	public void startGame() {
		
	}
	private void computeAchievement() {
		// TODO Auto-generated method stub

	}
}

//游戏控制类
public class GameLauncher {

	public static void main(String[] args) {
		GameLauncher gameLauncher=new GameLauncher();
		
		
	}

}
