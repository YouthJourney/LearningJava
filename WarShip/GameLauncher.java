package games;

import java.awt.Point;
import java.util.Random;
import java.util.Scanner;

class Player{
	public int chance; //���һ���ɲ´���
	public int score;  //�û��÷�
	
	public Player() {  //��ʼ����
		chance=3;
		score=0;
	}
	
	public Point guessPosition() {  //������µĵ�����ꡣ
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		System.out.print("������µ�ս��������(��Χ��0-6��������6)��");	
		Point point=new Point(in.nextInt(), in.nextInt());
		chance--;
		return point;
	}
}

class WarShip{
	private Point bodyPoint; //ս������λ�ã����о�ը�٣�
	private Point headPoint; //ս��ͷ�����������ˣ�
	private Point footPoint; //ս��β������������
	
	public int life; //����ս������ֵ
	
	public WarShip() {
		Random random=new Random();
		//����ս����λ���������[0-6)
		int bodyX=random.nextInt(6);
		int bodyY=random.nextInt(6);
		bodyPoint=new Point(bodyX, bodyY);
		//bodyPoint�ĺ�һ����ΪheadPoint
		headPoint=new Point(bodyX+1, bodyY);
		footPoint=new Point(bodyX-1, bodyY);
		System.out.println("Ϊ���ڲ��ԣ���ӡ��bodyPoint�㣺"+bodyPoint);
		life=2;
	}
	
	public int getLife() {
		return life;
	}
	
	//����ս����Ѫ��
	public void setLife(int life) {
		this.life = life;
	}
	//��ȡ������λ��
	public Point getBodyPoint() {
		return bodyPoint;
	}
	//��ȡ��ͷλ��
	public Point getHeadPoint() {
		return headPoint;
	}
	//��ȡ��βλ��
	public Point getFootPoint() {
		return footPoint;
	}
}

public class GameLauncher {
	
	/**
	 * �ж��Ƿ���У������ص÷�
	 * @param point �û������point
	 * @param warShip ս���࣬����ս����λ�ã�Ѫ��
	 * @return
	 */
	public static int judgehit(Point point,WarShip warShip) {
		int score=0;//��¼�÷�
		//��������
		if(point.equals(warShip.getBodyPoint())) {
			//�����������
			score+=2;
			warShip.setLife(0);
		}
		//����ͷ��
		if(point.equals(warShip.getHeadPoint())){
			score+=1;
			System.out.println("ս���Ѿ����˼��ͣ�");
			warShip.life--;
		}
		//����β��
		if(point.equals(warShip.getFootPoint())) {
			score+=1;
			System.out.println("ս���Ѿ����˼��ͣ�");
			warShip.life--;
		}
		return score;
	}
	public static void main(String[] args) {
		WarShip warShip=new WarShip();
		Player player=new Player();
		int chance= player.chance;
		//�û���ս��λ��
		for (int i = chance; i >0; i--) {
			Point guessPoint=player.guessPosition();
			
			player.score+=GameLauncher.judgehit(guessPoint, warShip);
			if(warShip.life<=0) {
				System.out.println("���Ѿ�ʤ��");
				break;
			}else {
				System.out.println("���ͣ��㻹��"+i+"����");
			}
		}
		if(warShip.life>0) {
			System.out.println("��ʧ����");
		}
		System.out.println("������յ÷�Ϊ��"+player.score);

	}
}
