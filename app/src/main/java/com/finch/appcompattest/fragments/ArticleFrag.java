package com.finch.appcompattest.fragments;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.finch.appcompattest.parsAticle;
import java.util.concurrent.ExecutionException;
import android.webkit.WebSettings;
import android.graphics.*;

public class ArticleFrag extends Fragment
{
	String url;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		Bundle args = getArguments();
		if (args != null) url = args.getString("url");
		
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View v = inflater.inflate(com.finch.appcompattest.R.layout.article_frag, null);
		WebView webView=(WebView)v.findViewById(com.finch.appcompattest.R.id.webView);

		parsAticle pAticle = new parsAticle();
		pAticle.execute(url);
		String articleHTML = "";

		try
		{
			articleHTML = pAticle.get();
		}
		catch (ExecutionException e)
		{}
		catch (InterruptedException e)
		{}

		webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
		webView.getSettings().setUseWideViewPort(true);
		webView.getSettings().setLoadWithOverviewMode(true);
		webView.getSettings().setDefaultTextEncodingName("utf-8");
		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setEnableSmoothTransition(true);
		webView.loadDataWithBaseURL(null, 
									"<style>img{display: inline;height: auto;max-width: 100%;}</style>" +articleHTML,
									"text/html", "utf-8", null);
		
		return v;
	}
	
	
}
