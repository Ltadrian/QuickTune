package com.example.adriangracia.quicktune;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;

/**
 * Simple Tuner.
 * Works for different tunings
 * Problem:App plays multiple strings at same time
 * @author adriangracia 3-5-15
 */
public class MainActivity extends ActionBarActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private MediaPlayer mpE;
    private MediaPlayer mpA;
    private MediaPlayer mpD;
    private MediaPlayer mpG;
    private MediaPlayer mpB;
    private MediaPlayer mpe;
    private RadioButton buttonE;
    private RadioButton buttonA;
    private RadioButton buttonD;
    private RadioButton buttonG;
    private RadioButton buttonB;
    private RadioButton buttone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner1);

        buttonE = (RadioButton) findViewById(R.id.E);
        buttonA = (RadioButton) findViewById(R.id.A);
        buttonD = (RadioButton) findViewById(R.id.D);
        buttonG = (RadioButton) findViewById(R.id.G);
        buttonB = (RadioButton) findViewById(R.id.B);
        buttone = (RadioButton) findViewById(R.id.e);

        //on create let Standard tuning be set
        mpE = MediaPlayer.create(MainActivity.this, R.raw.se);
        mpA = MediaPlayer.create(MainActivity.this, R.raw.sa);
        mpD = MediaPlayer.create(MainActivity.this, R.raw.sd);
        mpG = MediaPlayer.create(MainActivity.this, R.raw.sg);
        mpB = MediaPlayer.create(MainActivity.this, R.raw.sb);
        mpe = MediaPlayer.create(MainActivity.this, R.raw.seb);



        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.tuning_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner

        //idk what this does
        spinner.setAdapter(adapter);

        //listener for buttons
        //addListenerOnButtons();

        //another listener for the spinner(WORKS-TESTED)
        spinner.setOnItemSelectedListener(this);

    }

    public void onRadioButtonClicked(View view) {
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.E:
                mpE.start();
                break;

            case R.id.A:
                mpA.start();
                break;

            case R.id.D:
                mpD.start();
                break;

            case R.id.G:
                mpG.start();
                break;

            case R.id.B:
                mpB.start();
                break;

            case R.id.e:
                mpe.start();
                break;

        }
    }
    public void addListenerOnButtons(){


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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String temp = (String) spinner.getItemAtPosition(position);
        //sets the mp3 files based on what is selected in the spinner
        switch(temp){
            case "Standard":
                mpE = MediaPlayer.create(MainActivity.this, R.raw.se);
                mpA = MediaPlayer.create(MainActivity.this, R.raw.sa);
                mpD = MediaPlayer.create(MainActivity.this, R.raw.sd);
                mpG = MediaPlayer.create(MainActivity.this, R.raw.sg);
                mpB = MediaPlayer.create(MainActivity.this, R.raw.sb);
                mpe = MediaPlayer.create(MainActivity.this, R.raw.seb);
                break;
            case "Drop D":
                mpE = MediaPlayer.create(MainActivity.this, R.raw.dropd);
                mpA = MediaPlayer.create(MainActivity.this, R.raw.sa);
                mpD = MediaPlayer.create(MainActivity.this, R.raw.sd);
                mpG = MediaPlayer.create(MainActivity.this, R.raw.sg);
                mpB = MediaPlayer.create(MainActivity.this, R.raw.sb);
                mpe = MediaPlayer.create(MainActivity.this, R.raw.seb);
                break;
            case "Half Step Down":
                mpE = MediaPlayer.create(MainActivity.this, R.raw.hsde);
                mpA = MediaPlayer.create(MainActivity.this, R.raw.hsda);
                mpD = MediaPlayer.create(MainActivity.this, R.raw.hsdd);
                mpG = MediaPlayer.create(MainActivity.this, R.raw.hsdg);
                mpB = MediaPlayer.create(MainActivity.this, R.raw.hsdb);
                mpe = MediaPlayer.create(MainActivity.this, R.raw.hsdeb);
                break;
            case "Half Step Up":
                mpE = MediaPlayer.create(MainActivity.this, R.raw.hsue);
                mpA = MediaPlayer.create(MainActivity.this, R.raw.hsua);
                mpD = MediaPlayer.create(MainActivity.this, R.raw.hsud);
                mpG = MediaPlayer.create(MainActivity.this, R.raw.hsug);
                mpB = MediaPlayer.create(MainActivity.this, R.raw.hsub);
                mpe = MediaPlayer.create(MainActivity.this, R.raw.hsueb);
                break;
            case "Quarter Step Down":
                mpE = MediaPlayer.create(MainActivity.this, R.raw.qsde);
                mpA = MediaPlayer.create(MainActivity.this, R.raw.qsda);
                mpD = MediaPlayer.create(MainActivity.this, R.raw.qsdd);
                mpG = MediaPlayer.create(MainActivity.this, R.raw.qsdg);
                mpB = MediaPlayer.create(MainActivity.this, R.raw.qsdb);
                mpe = MediaPlayer.create(MainActivity.this, R.raw.qsdeb);
                break;
            case "Quarter Step Up":
                mpE = MediaPlayer.create(MainActivity.this, R.raw.qsue);
                mpA = MediaPlayer.create(MainActivity.this, R.raw.qsua);
                mpD = MediaPlayer.create(MainActivity.this, R.raw.qsud);
                mpG = MediaPlayer.create(MainActivity.this, R.raw.qsug);
                mpB = MediaPlayer.create(MainActivity.this, R.raw.qsub);
                mpe = MediaPlayer.create(MainActivity.this, R.raw.qsueb);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
