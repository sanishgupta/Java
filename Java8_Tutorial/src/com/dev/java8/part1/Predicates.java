package com.dev.java8.part1;

import java.util.Objects;
import java.util.function.Predicate;

@FunctionalInterface
public interface Predicates<T> {
	
	boolean test( T t);
	
	default Predicate<T> and(Predicate<? super T> other)
	{
		Objects.requireNonNull(other);
		return (t) -> test(t) && other.test(t);
	}

}
