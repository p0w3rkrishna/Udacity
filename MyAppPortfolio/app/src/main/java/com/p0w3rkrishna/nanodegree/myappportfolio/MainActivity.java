package com.p0w3rkrishna.nanodegree.myappportfolio;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>Udacity - Android Developer Nanodegree</h1>
 * Project 0: My App Portfolio
 * @author  André Galrito
 * @version 1.0
 * @since   2015.07.20
 */
public class MainActivity extends ActionBarActivity
{
    private static final String TXT_GENERAL  = "This button will launch: ";
    private static final String TXT_BUTTON01 = "Spotify Streamer";
    private static final String TXT_BUTTON02 = "Scores App";
    private static final String TXT_BUTTON03 = "Library App";
    private static final String TXT_BUTTON04 = "Build it Bigger";
    private static final String TXT_BUTTON05 = "XYZ Reader";
    private static final String TXT_BUTTON06 = "My Own App";

    private Map buttons = new HashMap();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initButtons();
    }

    /**
     * Creates a Map that holds the relationship between the buttons and their respective to show
     * texts and sets a mouse click listener for each one of them
     */
    private void initButtons()
    {
        //Map - key: button, value: text to show when button is pressed
        buttons.put(findViewById(R.id.button01), TXT_BUTTON01);
        buttons.put(findViewById(R.id.button02), TXT_BUTTON02);
        buttons.put(findViewById(R.id.button03), TXT_BUTTON03);
        buttons.put(findViewById(R.id.button04), TXT_BUTTON04);
        buttons.put(findViewById(R.id.button05), TXT_BUTTON05);
        buttons.put(findViewById(R.id.button06), TXT_BUTTON06);

        for (Object oneButton : buttons.keySet())
        {
            Button handleButton = (Button) oneButton;
            handleButton.setOnClickListener(new MyClickListener());
        }
    }

    private class MyClickListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            Toast.makeText(getApplicationContext(), this.getText(v), Toast.LENGTH_SHORT).show();
        }

        private String getText(View v)
        {
            return TXT_GENERAL + "'" + (String) buttons.get(findViewById(v.getId())) + "'";
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
