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
		System.out.println("汽车名: "+CarName+" 油箱："+Tank+" 耗油量："+OilConsumption);
	}
	public static void main(String[] args) {
		System.out.println("请输入汽车的各个属性: ");
		Scanner scanner=new Scanner(System.in);
		String carname=scanner.nextLine();
		float tank=scanner.nextFloat();
		float oilconsumption=scanner.nextFloat();
		scanner.close();
		Car car=new Car(carname, tank, oilconsumption);
		car.Display();
	}
}