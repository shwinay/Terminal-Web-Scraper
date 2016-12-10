package web;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScrapeTime 
{

	//VARIABLES
	Document doc;
	Document parser;
	String time;
	
	//CONSTRUCTOR
	public ScrapeTime()
	{
		
	}
	
	
	//METHODS
	public void scrapeTime(String searchQuery)
	{
		try 
		{
			doc = Jsoup.connect("https://www.timeanddate.com/worldclock/results.html?query=" + searchQuery).get();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		try
		{
			Element timeElement = doc.getElementById("ct");
			time = Jsoup.parse(timeElement.toString()).text();
			
			Elements locationElement = doc.select("h1");
			String locationString = Jsoup.parse(locationElement.toString()).text();
			
			System.out.println(locationString + ": " + time);
		}
		catch(Exception e)
		{
			Element timeElement = doc.getElementById("p0");
			time = Jsoup.parse(timeElement.toString()).text();
			System.out.println(time);
		}
		
		
	}
	
}
