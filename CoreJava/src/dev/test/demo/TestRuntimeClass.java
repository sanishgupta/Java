package dev.test.demo;

import java.io.File;
import java.io.IOException;

public class TestRuntimeClass
{

	public static void main(String []args)
	{
		
		Runtime rt = Runtime.getRuntime();
		 rt.gc();
		 try
		{
			Process  process = rt.exec("", args, new File("C:\\temp.txt"));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (Exception e)
		 {
			 
		 }
		
	}
	
	
}
