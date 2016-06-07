/*
 * Copyright 2004 by TotyuEdu CO.,LTD.
 * All rights reserved.
 */
class SuperClass
{
	public SuperClass()
	{
		System.out.println("new SuperClass!!!!!!!!!!!");
	}
}
class SubClass extends SuperClass
{
	public SubClass()
	{
		System.out.println("new SubClass!!!!!!!!!!!");
	}
}

public class TestInitSort
{
	public static void main(String[] args)
	{
		SubClass subClass = new SubClass();
	}
}