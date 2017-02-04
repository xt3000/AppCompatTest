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
import android.widget.*;
import android.support.design.widget.*;
import android.transition.*;

public class ArticleFrag extends Fragment
{
	String url;
	String title;
	FloatingActionButton fab;
	String articleHTML = "";

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		Bundle args = getArguments();
		if (args != null) 
		{
			url = args.getString("url");
			title = args.getString("title");
		}
		
		if (articleHTML == "") {parsAticleStart();}
		
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View v = inflater.inflate(com.finch.appcompattest.R.layout.article_frag, null);
		WebView webView=(WebView)v.findViewById(com.finch.appcompattest.R.id.webView);
		TextView tv = (TextView)v.findViewById(com.finch.appcompattest.R.id.tvArticleTitle);
		tv.setText(title);
		
		LinearLayout ll = (LinearLayout)getActivity().findViewById(com.finch.appcompattest.R.id.content_main);
		ll.setBackgroundColor(Color.WHITE);
		fab = (FloatingActionButton)getActivity().findViewById(com.finch.appcompattest.R.id.fab);
		fab.show();

		webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
		webView.getSettings().setUseWideViewPort(true);
		webView.getSettings().setLoadWithOverviewMode(true);
		webView.getSettings().setDefaultTextEncodingName("utf-8");
		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setEnableSmoothTransition(true);
		articleHTML = "<style>img{display: inline;height: auto;max-width: 100%;}</style>" +articleHTML;
		webView.loadDataWithBaseURL(null, articleHTML, "text/html","utf-8", null);
		
		return v;
	}

	@Override
	public void onPause()
	{
		fab.hide();
		// TODO: Implement this method
		super.onPause();
	}

	@Override
	public void onSaveInstanceState(Bundle outState)
	{
		setRetainInstance(true);
		// TODO: Implement this method
		super.onSaveInstanceState(outState);
	}
	
	private void parsAticleStart()
	{
		parsAticle pAticle = new parsAticle();
		pAticle.execute(url);

		try
		{
			articleHTML = pAticle.get();
		}
		catch (ExecutionException e)
		{}
		catch (InterruptedException e)
		{}
	}
	
	
}
