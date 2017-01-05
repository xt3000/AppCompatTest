package com.finch.appcompattest;

import android.os.AsyncTask;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;

public class Parser extends AsyncTask<Void,Void,ArrayList<String>[]>
{
	String title;

	@Override
	protected ArrayList<String>[] doInBackground(Void... args)
	{
		ArrayList<String> arrayTitle = new ArrayList<String>();
		ArrayList<String> arrayLink = new ArrayList<String>();
		Document doc=null;
		
		try
		{
			doc=Jsoup.connect("http://startandroid.ru/ru/uroki/vse-uroki-spiskom.html").get();
			Elements elems = doc.select("td.list-title");
			for (Element elem : elems)
			{
				arrayTitle.add(elem.text());
				arrayLink.add(elem.select("a[href]").first().attr("abs:href"));
			}
		
		} catch (IOException e) 
			{
				e.printStackTrace();
			}
			
		ArrayList<String>[] arrayList= {arrayTitle,arrayLink};
			
		return arrayList;
	}
}
