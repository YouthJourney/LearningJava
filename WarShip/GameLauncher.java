package com.hong.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//ս����
class WarShip{
	private String warName; //ս������
	private String[] position; //ս��λ��
	private String[] hitPosition; //����λ��
	private boolean status; //��ǰ״̬
	private int hitCnt; //���д���
	public WarShip(String warName) { //��ʼ��ս����Ϣ
		this.warName=warName;
	}
	
	public boolean hitFlag(String gussPosi) {
		
		return true;
	}
	
	public void createPosition(){
		
	}
}

//�����
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

//��Ϸ��
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

//��Ϸ������
public class GameLauncher {

	public static void main(String[] args) {
		GameLauncher gameLauncher=new GameLauncher();
		
		
	}

}
