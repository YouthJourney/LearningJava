import java.util.Scanner;
public class Car {
	private String CarName;
	private float Tank;
	private float OilConsumption;
	public Car(String carname,float tank,float oilconsumption)
	{
		CarName=carname;
		Tank=tank;
		OilConsumption=oilconsumption;
	}
	public void Display()
	{
		System.out.println("������: "+CarName+" ���䣺"+Tank+" ��������"+OilConsumption);
	}
	public static void main(String[] args) {
		System.out.println("�����������ĸ�������: ");
		Scanner scanner=new Scanner(System.in);
		String carname=scanner.nextLine();
		float tank=scanner.nextFloat();
		float oilconsumption=scanner.nextFloat();
		scanner.close();
		Car car=new Car(carname, tank, oilconsumption);
		car.Display();
	}
}