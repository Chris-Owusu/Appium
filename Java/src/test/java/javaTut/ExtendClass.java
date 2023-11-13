package javaTut;

public class ExtendClass extends MethodsDemo {
	public  void color() {
		System.out.println(color);
	}
	
	public static void main(String[] args) {
		System.out.println("Pancakes");
		ExtendClass ex = new ExtendClass();
		System.out.println(ex.color);
	}
}
