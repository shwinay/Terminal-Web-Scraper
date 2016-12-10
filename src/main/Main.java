package main;

import java.util.Scanner;

import web.ScrapeTime;

public class Main 
{
	//VARIABLES
	static ScrapeTime scrapeTime;
	
	
	//METHODS
	
	public static void main(String[] args)
	{
		init();
		userInteraction();
	}
	
	public static void init()
	{
		scrapeTime = new ScrapeTime();
	}
	
	public static void userInteraction()
	{
		String input;
		Scanner scanner = new Scanner(System.in);
		System.out.println(" What would you like to find? For a list of commands, type 'help' ");
		input = scanner.nextLine();
		
		if (input.toLowerCase().equals("time"))
		{
			System.out.println("In what place would you like to know the time in?");
			input = scanner.nextLine();
			scrapeTime.scrapeTime(input);
		}
		
	}
	
	
}
