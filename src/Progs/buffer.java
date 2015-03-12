package Progs;

import org.testng.annotations.Test;


public class buffer 
{
	@Test
	public void foo()
	{
		System.out.println("inside foo");
		bar();
	}
	public void bar()
	{
		System.out.println("inside bar");
	}
}
