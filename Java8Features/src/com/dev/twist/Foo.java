
package com.dev.twist;

interface Foo
{
	boolean equals(Object obj);
}
// Not functional because equals is already an implicit member (Object class)

interface Comparator<T>
{
	boolean equals(Object obj);

	int compare(T o1, T o2);
}
// Functional because Comparator has only one abstract non-Object method

interface Foo
{
	int m();

	Object clone();
}
// Not functional because method Object.clone is not public

interface X
{
	int m(Iterable<String> arg);
}

interface Y
{
	int m(Iterable<String> arg);
}

interface Z extends X, Y
{
}
// Functional: two methods, but they have the same signature

interface X
{
	Iterable m(Iterable<String> arg);
}

interface Y
{
	Iterable<String> m(Iterable arg);
}

interface Z extends X, Y
{
}
// Functional: Y.m is a subsignature & return-type-substitutable

interface X
{
	int m(Iterable<String> arg);
}

interface Y
{
	int m(Iterable<Integer> arg);
}

interface Z extends X, Y
{
}
// Not functional: No method has a subsignature of all abstract methods

interface X
{
	int m(Iterable<String> arg, Class c);
}

interface Y
{
	int m(Iterable arg, Class<?> c);
}

interface Z extends X, Y
{
}
// Not functional: No method has a subsignature of all abstract methods

interface X
{
	long m();
}

interface Y
{
	int m();
}

interface Z extends X, Y
{
}
// Compiler error: no method is return type substitutable

interface Foo<T>
{
	void m(T arg);
}

interface Bar<T>
{
	void m(T arg);
}

interface FooBar<X, Y> extends Foo<X>, Bar<Y>
{
}
// Compiler error: different signatures, same erasure