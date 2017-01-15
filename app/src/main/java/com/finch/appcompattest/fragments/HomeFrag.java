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

public class HomeFrag extends Fragment
{
	RecyclerView rv;
	ItemObj itemObj;
	public RVAdapter adapter;
	public ArrayList<String> aTitle;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		Bundle args = getArguments();
		itemObj = (ItemObj) args.getSerializable("itemObj");
		adapter = new RVAdapter(itemObj.aTitle);
		
		
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
	}
	
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View v = inflater.inflate(com.finch.appcompattest.R.layout.main_list, null);
		rv = (RecyclerView) v.findViewById(com.finch.appcompattest.R.id.rv);
		
		LinearLayoutManager llm = new LinearLayoutManager(getActivity());
		rv.setLayoutManager(llm);
		rv.setHasFixedSize(true);
		
		rv.setAdapter(adapter);
		// TODO: Implement this method
		return v;
	}
	
}
