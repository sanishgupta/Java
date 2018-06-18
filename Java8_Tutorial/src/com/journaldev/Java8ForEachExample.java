package com.journaldev;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class Java8ForEachExample {

	public static void main(String[] args) {

		// creating sample Collection
		List<Integer> myList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++)
			myList.add(i);

		// traversing using Iterator
		Iterator<Integer> it = myList.iterator();
		while (it.hasNext()) {
			Integer i = it.next();
			System.out.println("Iterator Value::" + i);
		}

		// traversing through forEach method of Iterable with anonymous class
		myList.forEach(new Consumer<Integer>() {

			public void accept(Integer t) {
				System.out.println("forEach anonymous class Value::" + t);
			}

		});

		// traversing with Consumer interface implementation
		MyConsumer action = new MyConsumer();
		myList.forEach(action);

		Sum sum = null;

		List<Sum> sumList = new ArrayList<Sum>();

		for (int i = 0; i <= 10; i++) {
			sum = new Sum(i * 1, i * 3);
			sumList.add(sum);
		}

		sumList.add(null);
		SumConsumer sumAction = new SumConsumer();
		System.out.println("Iterating the SumAction List<Sum> consumer's.....");
		sumList.forEach(sumAction);
		
	}

}

// Consumer implementation that can be reused
class MyConsumer implements Consumer<Integer> {

	public void accept(Integer t) {
		System.out.println("Consumer impl Value::" + t);
	}
}

class Sum {
	Sum(Integer a, Integer b) {
		this.a = a;
		this.b = b;
	}

	protected Integer a;
	protected Integer b;
}

class SumConsumer implements Consumer<Sum> {

	@Override
	public void accept(Sum sum) {
		//Objects.requireNonNull(sum);
		Objects.requireNonNull(sum, "Object of class Sum, seems to be empty....check it and provide the concrete values to the class elements. ");
		System.out.println("Sum of Two number (a + b) is # " + (sum.a + sum.b));

	}

}