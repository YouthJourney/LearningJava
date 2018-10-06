package com.music.player;

/**
 * @author ASUS
 * @version Music 1.0
 * @rule player点歌歌，按顺序播放。
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//歌曲类；
class Song {
	private String songName;  //歌曲名
	private String Singer;    //歌手
	private double Time;      //歌曲时间
	public Song(String songname,String singer,double time) {
		songName=songname;
		Singer=singer;
		Time=time;
	}
	
	public String toString()
	{
		StringBuffer stringBuffer=new StringBuffer("");
		//StringBuffer和String一样，但可以变化。
		stringBuffer.append("歌曲名："+songName);
		stringBuffer.append("  歌手："+Singer);
		stringBuffer.append("  歌曲时间："+Time);
		//返回重写后的字符串；
		return stringBuffer.toString();
	}
	
	public static void main(String[] args) {
		//点歌启动入口；
		SongDrive songDrive=new SongDrive();
		songDrive.player.addSong();
//		songDrive.player.addSong();
		songDrive.master.play();
		
	}
}

//点歌类
class Player{
	public boolean addSong() {
		Scanner in=new Scanner(System.in);
		
		//输入点歌信息；
		System.out.println("输入歌曲名：");
		String songName=in.nextLine();
		System.out.println("输入歌手名：");
		String singer=in.nextLine();
		System.out.println("输入歌曲时长：");
		double songTime=in.nextDouble();
		in.close();//回收Scanner对象；
		
		Song song =new Song(songName,singer,songTime);
		Master.listSong.add(song); //将点的歌曲添加至歌曲列表；
		return true;
	}
}

//主持人类；
class Master{
	static List<Song> listSong; //歌曲列表；
	public Master() {  //初始化歌曲列表；
		listSong=new ArrayList<Song>();
	}
	public boolean play() {
		//打印即将播放的歌曲信息；
		System.out.println(listSong.get(0).toString());
		return true;
	}
}

//歌曲播放类；
class SongDrive{
	public Master master;
	public Player player;
	
	public SongDrive() { //初始化master和player；
		master=new Master();
		player=new Player();
	}
	
}
