package com.finch.appcompattest.fragments;

import android.support.v4.app.Fragment;
import android.view.View;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import com.finch.appcompattest.RVAdapter;
import java.util.ArrayList;
import android.support.v7.widget.LinearLayoutManager;
import com.finch.appcompattest.ItemObj;
import com.finch.appcompattest.*;
import android.widget.*;
import android.widget.AdapterView.*;
import android.app.*;

public class HomeFrag extends Fragment
{
	RecyclerView rv;
	ItemObj itemObj = null;
	public RVAdapter adapter = null;
	public ArrayList<String> aTitle;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		Bundle args = getArguments();
		if (args != null) itemObj = (ItemObj) args.getSerializable("itemObj");
		if (itemObj != null) adapter = new RVAdapter(itemObj.aTitle);
		
		
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
	}
	
	

	@Override
	public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View v = inflater.inflate(com.finch.appcompattest.R.layout.main_list, null);
		rv = (RecyclerView) v.findViewById(com.finch.appcompattest.R.id.rv);
		
		LinearLayoutManager llm = new LinearLayoutManager(getActivity());
		rv.setLayoutManager(llm);
		rv.setHasFixedSize(true);
		
		rv.setAdapter(adapter);
		rv.addOnItemTouchListener(new RecyclerClickListener(getActivity(), new RecyclerClickListener.OnItemClickListener()
		{
			@Override
			public void onItemClick(View v, int pos)
			{
				String url = itemObj.aLink.get(pos);
				//Toast.makeText(getActivity(), url, Toast.LENGTH_SHORT).show();
				if (getActivity()!=null)
				{
					MainActivity act = (MainActivity) getActivity();
					act.articleFragReplace(url);
					
				}
			}
		}));
		// TODO: Implement this method
		return v;
	}
	
}
