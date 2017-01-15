package com.finch.appcompattest;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.View;
import android.view.LayoutInflater;
import java.util.ArrayList;
import android.content.Context;
import java.util.Map;


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.RecyclerViewHolder>
{
	ArrayList<String> aTitle;
	Context context;
	
	public RVAdapter(ArrayList<String> aTitle)
	{
		this.aTitle =  aTitle;
	}

	@Override
	public RVAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
	{
		View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new RecyclerViewHolder(v);
	}

	@Override
	public void onBindViewHolder(RVAdapter.RecyclerViewHolder viewHolder, int i)
	{
		// get the single element from the main array
        // Set the values
		viewHolder.tvItemName.setText(aTitle.get(i));
		// TODO: Implement this method
	}

	@Override
	public int getItemCount()
	{
		// TODO: Implement this method
		return aTitle.size();
	}

	public class RecyclerViewHolder extends RecyclerView.ViewHolder
	{
		TextView tvItemName;
		
		RecyclerViewHolder(View itemView)
		{
			super(itemView);
			tvItemName = (TextView)itemView.findViewById(R.id.tvItemName);
			
		}
	}
	
}
