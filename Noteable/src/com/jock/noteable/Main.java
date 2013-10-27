package com.jock.noteable;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;

public class Main extends Activity
{

	public static final String APP_TAG = "NOTEABLE";
	
	@Override
	protected void onCreate( Bundle savedInstanceState )
	{

		super.onCreate( savedInstanceState );
		setContentView( R.layout.main );

		FragmentManager fragMan = getFragmentManager();
		FragmentTransaction tran = fragMan.beginTransaction();
		StaffDisplay staff = new StaffDisplay();
		tran.add( R.id.mainAppFrame, staff );
		tran.commit();

	}


	@Override
	public boolean onCreateOptionsMenu( Menu menu )
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate( R.menu.main, menu );
		return true;
	}

}
