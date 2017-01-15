package com.finch.appcompattest;
import java.io.Serializable;
import java.util.ArrayList;

public class ItemObj implements Serializable
{
	public ArrayList<String> aTitle;
	public ArrayList<String> aLink;
	
	ItemObj(ArrayList<String> aTitle,ArrayList<String> aLink)
	{
		this.aTitle = aTitle;
		this.aLink = aLink;
	}
}
