
package com.dev.java7.features;

public class SwitchOnString2
{

	public static void main(String[] args)
	{
		String day = "SAT";
		switch (day) {
		   case "MON": System.out.println("Monday"); break;
		   case "TUE": System.out.println("Tuesday"); break;
		   case "WED": System.out.println("Wednesday"); break;
		   case "THU": System.out.println("Thursday"); break;
		   case "FRI": System.out.println("Friday"); break;
		   case "SAT": System.out.println("Saturday"); break;
		   case "SUN": System.out.println("Sunday"); break;
		   default: System.out.println("Invalid");
		}

		
		//Example#2
		// This program accepts three command-line options
	//   -c : create
	//   -v : verbose
	//   -d : debug
	// More than one options can be specified in any order.
	      boolean create = false;
	      boolean verbose = false;
	      boolean debug = false;
	      args = new String[6];
	      args[0] = "-c";
	      args[1] = "-C";
	      args[2] = "-v";
	      args[3] = "-V";
	      args[4] = "-d";
	      args[5] = "-D";
	      
	      for (String arg: args) {
	         switch (arg) {
	            case "-c": create = true; break;
	            case "-v": verbose = true; break;
	            case "-d": debug = true; break;
	            default:
	               System.out.println("invalid option");
	               System.exit(1);
	         }
	      }
	 
	      System.out.println("create: " + create);
	      System.out.println("verbose: " + verbose);
	      System.out.println("debug: " + debug);
	   }
	}		

