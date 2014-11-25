package com.juancastano.ejemplo;
	
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements SeekBar.OnSeekBarChangeListener{


    /* Seeks Bars */
	private SeekBar sbarRed = null;
	private SeekBar sbarGreen = null;
	private SeekBar sbarBlue = null;
	private SeekBar sbarAlpha = null;

    /* Views */
	private View vieColor = null;

    /* Linear Background */
    private LinearLayout linearBackground = null;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.sbarRed = (SeekBar) findViewById(R.id.sbarRed);
		this.sbarGreen = (SeekBar) findViewById(R.id.sbarGreen);
		this.sbarBlue = (SeekBar) findViewById(R.id.sbarBlue);
		this.sbarAlpha = (SeekBar) findViewById(R.id.sbarAlpha);
		this.vieColor = (View) findViewById(R.id.vieColor);
        this.linearBackground = (LinearLayout) findViewById(R.id.linearBackground);

		sbarRed.setOnSeekBarChangeListener(this);
		sbarGreen.setOnSeekBarChangeListener(this);
		sbarBlue.setOnSeekBarChangeListener(this);
		sbarAlpha.setOnSeekBarChangeListener(this);

        registerForContextMenu(this.linearBackground);
	}

    @Override
    public void onCreateContextMenu(ContextMenu contextMenu, View view,
                                    ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(contextMenu,view, menuInfo);
        getMenuInflater().inflate(R.menu.menu_main_colors, contextMenu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem menuItem) {


        int id = menuItem.getItemId();

        boolean resp = true;


        switch (id) {

            case R.id.itemRed:
                this.sbarRed.setProgress(255);
                this.sbarGreen.setProgress(0);
                this.sbarBlue.setProgress(0);
                this.sbarAlpha.setProgress(128);
                break;

            case R.id.itemGreen:
                this.sbarRed.setProgress(0);
                this.sbarGreen.setProgress(255);
                this.sbarBlue.setProgress(0);
                this.sbarAlpha.setProgress(128);
                break;
            case R.id.itemBlue:
                this.sbarRed.setProgress(0);
                this.sbarGreen.setProgress(0);
                this.sbarBlue.setProgress(255);
                this.sbarAlpha.setProgress(128);
                break;

            case R.id.itemCyan:
                this.sbarRed.setProgress(0);
                this.sbarGreen.setProgress(255);
                this.sbarBlue.setProgress(255);
                this.sbarAlpha.setProgress(128);
                break;
            case R.id.itemMagenta:
                this.sbarRed.setProgress(255);
                this.sbarGreen.setProgress(0);
                this.sbarBlue.setProgress(255);
                this.sbarAlpha.setProgress(128);
                break;

            case R.id.itemYellow:
                this.sbarRed.setProgress(255);
                this.sbarGreen.setProgress(255);
                this.sbarBlue.setProgress(0);
                this.sbarAlpha.setProgress(128);
                break;

            case R.id.itemBlack:
                this.sbarRed.setProgress(0);
                this.sbarGreen.setProgress(0);
                this.sbarBlue.setProgress(0);
                this.sbarAlpha.setProgress(128);
                break;

            case R.id.itemWhite:
                this.sbarRed.setProgress(255);
                this.sbarGreen.setProgress(255);
                this.sbarBlue.setProgress(255);
                this.sbarAlpha.setProgress(128);
                break;

            default:
                Toast toast = Toast.makeText(getApplicationContext(), "La opción colors no se encuentra activa", Toast.LENGTH_SHORT);
                toast.show();
                break;
        }


        return resp;


    }



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main_images, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        boolean resp = true;

        switch (id) {

            case R.id.itemImage1:
                this.linearBackground.setBackgroundResource(R.drawable.image00);
                break;

            case R.id.itemImage2:
                this.linearBackground.setBackgroundResource(R.drawable.image01);
                break;

            case R.id.itemImage3:
                this.linearBackground.setBackgroundResource(R.drawable.image02);
                break;

            case R.id.itemImage4:
                this.linearBackground.setBackgroundResource(R.drawable.image03);
                break;

            case R.id.itemImage5:
                this.linearBackground.setBackgroundResource(R.drawable.image04);
                break;

            case R.id.itemAboutof:
                Intent intAbout = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intAbout);
                break;


            default:
                Toast toast = Toast.makeText(getApplicationContext(), "La opción Images no está disponible", Toast.LENGTH_SHORT);
                toast.show();
                break;

        }
        return resp;
	}

	@Override
	public void onProgressChanged(SeekBar arg0, int progress, boolean fromUser) {
		// TODO Auto-generated method stub

		int red = this.sbarRed.getProgress();
		int green = this.sbarGreen.getProgress();
		int blue = this.sbarBlue.getProgress();
		int alpha = this.sbarAlpha.getProgress();

		int color = Color.argb(alpha, red, green, blue);

		this.vieColor.setBackgroundColor(color);

	}

	@Override
	public void onStartTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStopTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub

	}
}
