package com.jock.noteable;

import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class StaffDisplay extends Fragment implements OnClickListener, OnTouchListener
{
	private Button a_btn;
	private Button b_btn;
	private Button c_btn;
	private Button d_btn;
	private Button e_btn;
	private Button f_btn;
	private Button g_btn;
	private RelativeLayout staffLayout;

	private enum NOTES
	{
		C_NATURAL, D_NATURAL, E_NATURAL, F_NATURAL, G_NATURAL, A_NATURAL, B_NATURAL
	};

	private static final int ON_TOUCH_NOTE_ID = 101;
	private static final int TEST_NOTE_ID = 102;


	@Override
	public void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
	}


	@Override
	public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
	{
		View view = inflater.inflate( R.layout.staff_display, container, false );

		a_btn = (Button) view.findViewById( R.id.btn_a );
		b_btn = (Button) view.findViewById( R.id.btn_b );
		c_btn = (Button) view.findViewById( R.id.btn_c );
		d_btn = (Button) view.findViewById( R.id.btn_d );
		e_btn = (Button) view.findViewById( R.id.btn_e );
		f_btn = (Button) view.findViewById( R.id.btn_f );
		g_btn = (Button) view.findViewById( R.id.btn_g );

		staffLayout = (RelativeLayout) view.findViewById( R.id.staff_layout );

		// addBassClef();
		// addTrebleClef();

		a_btn.setOnTouchListener( this );
		b_btn.setOnTouchListener( this );
		c_btn.setOnTouchListener( this );
		d_btn.setOnTouchListener( this );
		e_btn.setOnTouchListener( this );
		f_btn.setOnTouchListener( this );
		g_btn.setOnTouchListener( this );

		showNote( NOTES.F_NATURAL, TEST_NOTE_ID );
		return view;
	}


	@Override
	public boolean onTouch( View v, MotionEvent event )
	{
		switch (event.getAction())
		{
			case MotionEvent.ACTION_DOWN:
				if( v.getId() == R.id.btn_c )
				{
					showNote( NOTES.C_NATURAL, ON_TOUCH_NOTE_ID );
				}
				else if( v.getId() == R.id.btn_d )
				{
					showNote( NOTES.D_NATURAL, ON_TOUCH_NOTE_ID );
				}
				else if( v.getId() == R.id.btn_e )
				{
					showNote( NOTES.E_NATURAL, ON_TOUCH_NOTE_ID );
				}
				else if( v.getId() == R.id.btn_f )
				{
					showNote( NOTES.F_NATURAL, ON_TOUCH_NOTE_ID );
				}
				else if( v.getId() == R.id.btn_g )
				{
					showNote( NOTES.G_NATURAL, ON_TOUCH_NOTE_ID );
				}
				else if( v.getId() == R.id.btn_a )
				{
					showNote( NOTES.A_NATURAL, ON_TOUCH_NOTE_ID );
				}
				else if( v.getId() == R.id.btn_b )
				{
					showNote( NOTES.B_NATURAL, ON_TOUCH_NOTE_ID );
				}
				break;

			case MotionEvent.ACTION_UP:

				staffLayout.removeView( staffLayout.findViewById( ON_TOUCH_NOTE_ID ) );

				break;

			default:
				break;
		}
		return false;
	}


	private void showNote( NOTES note, int noteID )
	{
		ImageView crotchet = new ImageView( getActivity() );

		crotchet.setImageResource( R.drawable.up_crotchet );
		float[] positions = getNotPosition( note );
		crotchet.setX( positions[0] );
		crotchet.setY( positions[1] );
		crotchet.setLayoutParams( new LayoutParams( 130, 130 ) );
		crotchet.setId( noteID );

		staffLayout.addView( crotchet );

	}


	private float[] getNotPosition( NOTES noteType )
	{
		float[] positions = new float[2];

		if( getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT )
		{
			positions[0] = 228;
			positions[1] = 125;
		}
		else
		{
			positions[0] = 468;
			positions[1] = 125;
		}
		int offset = 0;

		float x = 0;
		float y = 0;
		switch (noteType)
		{
			case D_NATURAL:
				offset = 1;
				break;
			case E_NATURAL:
				offset = 2;
				break;
			case F_NATURAL:
				offset = 3;
				break;
			case G_NATURAL:
				offset = 4;
				break;
			case A_NATURAL:
				offset = 5;
				break;
			case B_NATURAL:
				offset = 6;
				break;

			default:
				break;
		}
		x = offset * 47F;
		y = offset * -16.5F;

		positions[0] += x;
		positions[1] += y;

		return positions;
	}


	public void onClick( View v )
	{
		Log.d( Main.APP_TAG, "in the onclick" );

	}


	// ---------------

	public void addTrebleClef()
	{
		RelativeLayout.LayoutParams imParams = new RelativeLayout.LayoutParams( 150, 210 );
		ImageView clef = new ImageView( getActivity() );

		clef.setImageResource( R.drawable.treble_clef );
		clef.setX( -20 );
		clef.setY( -295 );
		clef.setId( 1 );

		staffLayout.addView( clef, imParams );

	}


	public void addBassClef()
	{
		RelativeLayout.LayoutParams imParams = new RelativeLayout.LayoutParams( 100, 105 );
		ImageView clef = new ImageView( getActivity() );

		clef.setImageResource( R.drawable.bass_clef );
		clef.setX( 0 );
		clef.setY( -260 );
		clef.setId( 1 );

		staffLayout.addView( clef, imParams );

	}

}
