package com.finch.appcompattest;
import java.io.Serializable;
import java.util.ArrayList;
import javax.net.ssl.*;

public class ItemObj implements Serializable
{
	Integer i;
	public ArrayList<String> aTitle;
	public ArrayList<String> aLink;
	
	ItemObj(ArrayList<String> aTitle,ArrayList<String> aLink)
	{
		this.aTitle = aTitle;
		this.aLink = aLink;
		this.i = 0;
	}
	
	ItemObj()
	{
		this.aLink = null;
		this.aTitle = null;
		this.i = 0;
	}
	
	public void Init()
	{
		this.i = 1;
	}
	
	public boolean isInited()
	{
		boolean b = false;
		if (this.i == 1)
		{
			b = true;
		}
		return b;
	}
}
