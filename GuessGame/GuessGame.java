/**
@version 1.0
@author Hong
@rule �¶����ֵ�һ�֣��´�����
*/

import java.util.*;
import java.lang.String;
import java.util.Random;

public class GuessGame {
	public int counter; //�÷�
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
		System.out.println("������Ѿ�����,�������0~9������: ");
		Random random=new Random();
		
		return random.nextInt(10); //����0~9�����������
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int randNum,num;
		GuessGame player=new GuessGame();
		while(true) {
			//���������
			randNum=player.RandomNum();	
			System.out.println("��������µ�����(��ֻ��3�λ���)");
			for(int i=3;i>0;i--) {
				num=player.inputNum();
				if(player.isTrue(randNum, num)) {
					System.out.println("��¶���,��ĵ÷��ǣ�"+player.counter);
					break;
				}else {
					if(i-1!=0)
						System.out.println("��´���,�㻹��"+(i-1)+"�λ���");
						
					else {
						System.out.println("��´���,�Ѿ�û�л����ˡ�");
						System.out.println("���յ÷֣�"+player.counter);
						System.out.println("�����Ϊ��"+randNum);
					}
						
				}
			}
			System.out.println("��Ϸ����������1�������棬����0���˳�");
			if(player.inputNum()==0)
				break;
			else
				player.counter=0;//���÷���Ϊ0			
		}		
	}
}