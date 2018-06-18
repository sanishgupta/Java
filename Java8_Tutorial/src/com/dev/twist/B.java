package com.dev.twist;

public class B extends A {

	public B(int x) {
		super(x);
	}

	void print ()
	{
		System.out.println("x = " + (++x));
	}
	
}
