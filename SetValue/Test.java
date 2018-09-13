public class Test{
	public static void main (String[] args){
		String a="Hello World";	
		String c=a;
		c="Yangtze University";
		System.out.println(a);
		System.out.println(c);
		int adda=System.identityHashCode(a);
		System.out.println("The address of a is "+adda);
		int addc=System.identityHashCode(c);
		System.out.println("The address of c is "+addc);
		
	}
}