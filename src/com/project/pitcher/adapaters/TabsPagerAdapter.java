package com.project.pitcher.adapaters;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;

import com.project.pitcher.HomeFragment;
import com.project.pitcher.ProfileFragment;
import com.project.pitcher.SeekFragment;




public class TabsPagerAdapter extends FragmentPagerAdapter {
		 
	    public TabsPagerAdapter(FragmentManager fm) {
	        super(fm);
	    }
	 
	    @Override
	    public ListFragment getItem(int index) {
	 
	        switch (index) {
		        case 0:		            		           
		        	return new HomeFragment();
		        case 1:
		        	return new ProfileFragment();
		        case 2:
		        	return new SeekFragment();
	        }
	        
	        return null;
	    }
	 
	    @Override
	    public int getCount() {
	        // get item count - equal to number of tabs
	        return 3;
	    }
}
