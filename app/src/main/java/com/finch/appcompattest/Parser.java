package com.finch.appcompattest;

import android.os.AsyncTask;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;
import java.util.*;

public class Parser extends AsyncTask<Void,Void,ArrayList<Map<String,Object>>>
{
	String title;

	@Override
	protected ArrayList<Map<String,Object>> doInBackground(Void... args)
	{
		ArrayList<Map<String,Object>> arrayTitle = new ArrayList<>();
		Map<String,Object> m;
		Document doc=null;
		
		try
		{
			doc=Jsoup.connect("http://startandroid.ru/ru/uroki/vse-uroki-spiskom.html").get();
			Elements elems = doc.select("td.list-title");
			
			for (Element elem : elems)
			{
				m=new TreeMap<>();
				m.put("title",elem.text());
				m.put("link",elem.select("a[href]").first().attr("abs:href"));
				arrayTitle.add(m);
			}
		
		} catch (IOException e) 
			{
				e.printStackTrace();
			}
			
			
		return arrayTitle;
	}
}
