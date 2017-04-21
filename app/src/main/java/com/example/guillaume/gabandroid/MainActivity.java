package com.example.guillaume.gabandroid;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.microsoft.azure.mobile.MobileCenter;
import com.microsoft.azure.mobile.analytics.Analytics;
import com.microsoft.azure.mobile.crashes.Crashes;

public class MainActivity extends AppCompatActivity {


    private ImageView _imageView;
    private int _trollId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Mobile center setup
        MobileCenter.start(getApplication(), "2a75929a-76e5-4c0c-b7b4-f8512fbddd25", Analytics.class, Crashes.class);



        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        _imageView = (ImageView) findViewById(R.id.image);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void btnCrash(View view) throws Exception {
        throw new Exception("Tiens donc un crash");
    }


    public void btnChngPics(View view) {

        changePictureImage();
        Snackbar.make(view, "Coucou", Snackbar.LENGTH_LONG).setAction("Action", null).show();


    }


    private void changePictureImage()
    {
        switch (_trollId)
        {
            case 0:
                setImage(R.drawable.amc01);
                break;
            case 1:
                setImage(R.drawable.amc02);
                break;
            case 2:
                setImage(R.drawable.amc03);
                break;
            case 3:
                setImage(R.drawable.amc01);
                _trollId = 0;
                break;


        }
        _trollId ++;

    }

    private void setImage(final int drawable)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            _imageView.setImageDrawable(getResources().getDrawable(drawable, getApplicationContext().getTheme()));
        } else {
            _imageView.setImageDrawable(getResources().getDrawable(drawable));
        }
    }
}
