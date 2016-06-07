/*
 * Copyright 2004 by TotyuEdu CO.,LTD.
 * All rights reserved.
 */
 
class StaticCode
{
	static String country;
	static int i = 0;
	static 
	{
		country = "china";
		System.out.println("StaticCode is loading");
	}

	public StaticCode()
	{
		i++;
	}
	public static void Func1()
	{
		System.out.println("StaticCode.Func1 is called");
	}
	public static int getCount()
	{
		return i;
	}
}
public class TestStaticCode
{
	static
	{
		System.out.println("TestStaticCode is loading");
	}
	public static void main(String [] args)
	{
		System.out.println("begin executing main method");
		StaticCode.Func1();
		new StaticCode();
		System.out.println("count = " + StaticCode.getCount());
		new StaticCode();
		System.out.println("count = " + StaticCode.getCount());
	}
}