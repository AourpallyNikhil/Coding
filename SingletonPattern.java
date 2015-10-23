package test;

class SingletonObject{
	private SingletonObject(){
		
	}
	private static SingletonObject test = new SingletonObject();
	
	public static SingletonObject getSingletonObject(){
		return test;
	}
	public void dummy(){
		System.out.println("dummy");
	}
}

public class SingletonPattern {
    public static void main(String[] args) {
    	SingletonObject test = SingletonObject.getSingletonObject();
    	test.dummy();
	}
}
