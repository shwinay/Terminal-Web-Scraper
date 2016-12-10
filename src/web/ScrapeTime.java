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
			System.out.println("Something has gone wrong with your query. Please check your spelling and try again.");
		}
		
		//If query specific enough to pull webpage directly, then, will be done in the try block
		try
		{
			Element timeElement = doc.getElementById("ct");
			time = Jsoup.parse(timeElement.toString()).text();
			
			Elements locationElement = doc.select("h1");
			String locationString = Jsoup.parse(locationElement.toString()).text();
			
			System.out.println(locationString + ": " + time);
		}
		
		//If query is not specific enough, then will resort to using the first link location in search results
		catch(Exception e)
		{
			
			try
			{
				Elements linkElement = doc.select("td").first().getElementsByAttribute("href");
				String link = linkElement.attr("abs:href");
				
				Document d = null;
				
				try 
				{
					d = Jsoup.connect(link).get();
				} 
				catch (IOException e1) 
				{
					System.out.println("Something has gone wrong with your query. Please check your spelling and try again.");
				}
				
				Element timeElement = d.getElementById("ct");
				time = Jsoup.parse(timeElement.toString()).text();
				
				Elements locationElement = d.select("h1");
				String locationString = Jsoup.parse(locationElement.toString()).text();
				
				System.out.println(locationString + ": " + time);
			}
			
			//If query is misspelled or extraneous
			catch(Exception e2)
			{
				System.out.println("Something has gone wrong with your query. Please check your spelling and try again.");
			}
			
		}
		
		
	}
	
}
