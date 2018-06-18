package dev.test.demo.objectlifecycle;
class SuperclassA {
	public SuperclassA() {
		System.out.println("Constructor in SuperclassA");
	}
}

class SubclassB extends SuperclassA {
	public SubclassB() {
		this(3);
		System.out.println("Default constructor in SubclassB");
	}

	public SubclassB(int i) {
		System.out.println("Non-default constructor in SubclassB");
		int value = i;
	}

	private int value = initializerExpression();
	{
		System.out.println("Instance initializer block in SubclassB");
	}
	
	

	private int initializerExpression() {
		System.out.println("Instance initializer expression in SubclassB");
		return 1;
	}
	
	void display(){
		System.out.println("method invoked");
	}
}

public class ObjectConstruction {
	public static void main(String[] args) {
		new SubclassB();
	}

}
