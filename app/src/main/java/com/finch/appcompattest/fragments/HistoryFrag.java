package com.finch.appcompattest.fragments;

import android.support.v4.app.Fragment;
import android.view.View;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class HistoryFrag extends Fragment
{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		// TODO: Implement this method
		return inflater.inflate(com.finch.appcompattest.R.layout.history_list, null);
	}
	
}
