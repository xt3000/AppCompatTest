package com.finch.appcompattest;

import android.os.AsyncTask;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;
import java.util.*;

public class Parser extends AsyncTask<Void,Void,ItemObj>
{
	String title;
	ItemObj itemObj;

	@Override
	protected ItemObj doInBackground(Void... args)
	{
		ArrayList<String> aTitle = new ArrayList<>();
		ArrayList<String> aLink = new ArrayList<>();
		
		Document doc=null;
		
		try
		{
			doc=Jsoup.connect("http://startandroid.ru/ru/uroki/vse-uroki-spiskom.html").get();
			Elements elems = doc.select("td.list-title");
			
			for (Element elem : elems)
			{
				aTitle.add(elem.text());
				aLink.add(elem.select("a[href]").first().attr("abs:href"));
			}
		
		} catch (IOException e) 
			{
				e.printStackTrace();
			}
			
			itemObj = new ItemObj(aTitle,aLink);
		return itemObj;
	}
}
