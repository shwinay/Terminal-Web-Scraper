package web;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScrapeWeather 
{
	
	//VARIABLES
	Document doc;
	Document parser;
	String weather;
	
	
	//CONSTRUCTOR
	public ScrapeWeather()
	{
		
	}
	
	
	//METHODS
	public void scrapeWeather(String searchQuery)
	{
		try
		{
			doc = Jsoup.connect("https://www.timeanddate.com/worldclock/results.html?query=" + searchQuery).get();
		}
		catch (Exception e)
		{
			System.out.println("Something has gone wrong with your query. Please check your spelling, ensure network connection and try again.");
		}
		
		//If query specific enough to pull webpage directly, then, will be done in the try block
		try
		{
			Element weatherElement = doc.getElementById("wt-tp");
			weather = Jsoup.parse(weatherElement.toString()).text();
			
			Elements locationElement = doc.select("h1");
			String locationString = Jsoup.parse(locationElement.toString()).text().replace("Local Time", "Temperature");
			
			System.out.println(locationString + ": " + weather);
		}
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
					System.out.println("Something has gone wrong with your query. Please check your spelling, ensure network connection and try again.");
				}
				
				Element weatherElement = d.getElementById("wt-tp");
				weather = Jsoup.parse(weatherElement.toString()).text();
				
				Elements locationElement = d.select("h1");
				String locationString = Jsoup.parse(locationElement.toString()).text().replace("Local Time", "Temperature");
				
				System.out.println(locationString + ": " + weather);
			}
			
			//If query is misspelled or extraneous
			catch(Exception e2)
			{
				System.out.println("Something has gone wrong with your query. Please check your spelling, ensure network connection and try again.");
			}
		}
		
		
	}
	
	
}
