package com.music.player;

/**
 * @author ASUS
 * @version Music 1.0
 * @rule player���裬��˳�򲥷š�
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//�����ࣻ
class Song {
	private String songName;  //������
	private String Singer;    //����
	private double Time;      //����ʱ��
	public Song(String songname,String singer,double time) {
		songName=songname;
		Singer=singer;
		Time=time;
	}
	
	public String toString()
	{
		StringBuffer stringBuffer=new StringBuffer("");
		//StringBuffer��Stringһ���������Ա仯��
		stringBuffer.append("��������"+songName);
		stringBuffer.append("  ���֣�"+Singer);
		stringBuffer.append("  ����ʱ�䣺"+Time);
		//������д����ַ�����
		return stringBuffer.toString();
	}
	
	public static void main(String[] args) {
		//���������ڣ�
		SongDrive songDrive=new SongDrive();
		songDrive.player.addSong();
//		songDrive.player.addSong();
		songDrive.master.play();
		
	}
}

//�����
class Player{
	public boolean addSong() {
		Scanner in=new Scanner(System.in);
		
		//��������Ϣ��
		System.out.println("�����������");
		String songName=in.nextLine();
		System.out.println("�����������");
		String singer=in.nextLine();
		System.out.println("�������ʱ����");
		double songTime=in.nextDouble();
		in.close();//����Scanner����
		
		Song song =new Song(songName,singer,songTime);
		Master.listSong.add(song); //����ĸ�������������б�
		return true;
	}
}

//�������ࣻ
class Master{
	static List<Song> listSong; //�����б�
	public Master() {  //��ʼ�������б�
		listSong=new ArrayList<Song>();
	}
	public boolean play() {
		//��ӡ�������ŵĸ�����Ϣ��
		System.out.println(listSong.get(0).toString());
		return true;
	}
}

//���������ࣻ
class SongDrive{
	public Master master;
	public Player player;
	
	public SongDrive() { //��ʼ��master��player��
		master=new Master();
		player=new Player();
	}
	
}
