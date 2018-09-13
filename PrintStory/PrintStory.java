public class PrintStory {
	public static void main(String[] args) {
		int N=5;
		for(int i=N;i>0;i--)
		{
			if(i>=3)
				System.out.println(i +" bottles of beer on the wall,"+(i-1)+" bottles of beer on the wall.");
			else if(i==2)
				System.out.println(i +" bottles of beer on the wall,"+(i-1)+" bottle of beer on the wall.");
			else
				System.out.println(i +" bottles of beer on the wall,"+(i-1)+" bottle of beer on the wall.");
		}
		System.out.println("No more bottles of beer on the wall.");
	}
}