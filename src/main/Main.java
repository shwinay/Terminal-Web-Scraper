package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import web.ScrapeTime;
import web.ScrapeWeather;

public class Main 
{
	//VARIABLES
	static ScrapeTime scrapeTime;
	static ScrapeWeather scrapeWeather;
	static ArrayList<String> commandList;
	
	//METHODS
	
	public static void main(String[] args)
	{
		init();
		userInteraction();
	}
	
	public static void init()
	{
		scrapeTime = new ScrapeTime();
		scrapeWeather = new ScrapeWeather();
		commandList = new ArrayList<String>();
		commandList.addAll(Arrays.asList("time", "weather", "quit/exit", "help"));
	}
	
	public static void userInteraction()
	{
		String input = "";
		Scanner scanner = new Scanner(System.in);
		
		while (!input.toLowerCase().equals("quit"))
		{
			System.out.println(" What would you like to find? For a list of commands, type 'help' ");
			input = scanner.nextLine().toLowerCase();
			
			switch (input)
			{
				case "time":
					
					System.out.println("In what place would you like to know the time in?");
					input = scanner.nextLine();
					scrapeTime.scrapeTime(input);
					
					try{Thread.sleep(1000);}catch(Exception e){e.printStackTrace();}
					
					break;
				
				case "temperature":
				case "weather":
					
					System.out.println("In what place would you like to know the weather in?");
					input = scanner.nextLine();
					scrapeWeather.scrapeWeather(input);
					
					try{Thread.sleep(1000);}catch(Exception e){e.printStackTrace();}
					
					break;
				
				case "quit":
				case "exit":
					
					System.out.println("Exiting program");
					System.exit(0);
					
					break;
					
				case "help":
					
					for (String element : commandList)
					{
						System.out.println("Command: " + element);
					}
					
					break;
				
				default:
					
					System.out.println(" Command not recognized. For a list of commands, type 'help' ");
					
					try{Thread.sleep(1000);}catch(Exception e){e.printStackTrace();}
			
			}
			
			System.out.println("");
			
		}
		
		System.out.println("Exiting program");
		System.exit(0);
		scanner.close();
		
	}
	
	
}
