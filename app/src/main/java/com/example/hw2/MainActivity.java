package com.example.hw2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;


/**
 * <!-- class CustomElement -->
 *
 * This class assigns ids for all TextViews, SeekBars, and the SurfaceView. It also creates an
 * instance of the controller and sets listeners for the SeekBars and the controller.
 *
 * @author Jordan Ho
 * @version 2-16-19
 *
 */

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private String text;
    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** assigns id for the object name TextView to displayText */
        TextView displayText = findViewById(R.id.displayText);

        /** assigns id for the red RGB value TextView to redDisplay */
        TextView redDisplay = findViewById(R.id.redDisplay);

        /** assigns id for the green RGB value TextView to greenDisplay */
        TextView greenDisplay = findViewById(R.id.greenDisplay);

        /** assigns id for the blue RGB value TextView to blueDisplay */
        TextView blueDisplay = findViewById(R.id.blueDisplay);

        /** assigns id for the red SeekBar to redSeekBar */
        SeekBar redSeekBar = findViewById(R.id.redSeekBar);

        /** assigns id for the green SeekBar to greenSeekBar */
        SeekBar greenSeekBar = findViewById(R.id.greenSeekBar);

        /** assigns id for the blue SeekBar to blueSeekBar */
        SeekBar blueSeekBar = findViewById(R.id.blueSeekBar);

        /** assigns id for the random Button to randomButton */
        Button randomButton = findViewById(R.id.randomButton);

        /** assigns id for the hair RadioButton to radioHair */
        RadioButton radioHair = findViewById(R.id.radioHair);

        /** assigns id for the skin RadioButton to radioSkin */
        RadioButton radioSkin = findViewById(R.id.radioSkin);

        /** assigns id for the eye RadioButton to radioEyes */
        RadioButton radioEyes = findViewById(R.id.radioEyes);

        /** assigns id for the hair Spinner to hairSpinner */
        Spinner hairSpinner = findViewById(R.id.hairSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.hairArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hairSpinner.setAdapter(adapter);
        hairSpinner.setOnItemSelectedListener(this);

        /** assigns id for the SurfaceView to mainSurface */
        MySurfaceView mainSurface = findViewById(R.id.mainSurface);

        /** registers the Controller object */
        Controller theController = new Controller(displayText, redDisplay, greenDisplay,
                blueDisplay, redSeekBar, greenSeekBar, blueSeekBar, randomButton, radioHair,
                radioEyes, radioSkin, mainSurface);

        /** finds a listener for the red SeekBar and implements it*/
        redSeekBar.setOnSeekBarChangeListener(theController);

        /** finds a listener for the green SeekBar and implements it */
        greenSeekBar.setOnSeekBarChangeListener(theController);

        /** finds a listener for the blue SeekBar and implements it */
        blueSeekBar.setOnSeekBarChangeListener(theController);

        /** finds a listener for the random Button and implements it */
        randomButton.setOnClickListener(theController);

        /** finds a listener for the hair RadioButton and implements it */
        radioHair.setOnClickListener(theController);

        /** finds a listener for the skin RadioButton and implements it */
        radioSkin.setOnClickListener(theController);

        /** finds a listener for the eyes RadioButton and implements it */
        radioEyes.setOnClickListener(theController);

        /** finds a listener for the controller and implements it */
        mainSurface.setOnTouchListener(theController);
        //theController.spinner();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        this.text = adapterView.getItemAtPosition(i).toString();
    }
    public String getText(){
        return this.text;

    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        text = "";
    }



    /**
     * External Citations:
     *      Date 17 February 2019
     *      Problem: Had trouble getting my text views centered
     *      Resource:
     *          https://stackoverflow.com/questions/432037/how-do-i-center-text-horizontally-
     *          and-vertically-in-a-textview
     *      Solution: I used center, center_vertical, center_horizontal for the layout's gravity
     *
     *      Date: 18 February 2019
     *      Problem: Had trouble imagining the parameters of drawing rectangles
     *      Resource:
     *          https://stackoverflow.com/questions/22589322/what-does-top-left-right-and-bottom
     *          -mean-in-android-rect-object
     *      Solution: I used the image from this post to help form my rectangles
     *
     *      Date 18 February 2019
     *      Problem: Couldn't come up with the proper hex codes for the colors I wanted
     *      Resource:
     *          https://htmlcolorcodes.com/
     *      Solution: The website gave me the hex code for any color I wanted
     *
     *      Date 19 February 2019
     *      Problem: Didn't know how to set max value for the seek bar
     *      Resource:
     *          https://stackoverflow.com/questions/3490951/how-to-limit-seekbar
     *      Solution: I used the android:max="255"
     *
     *      Date 19 February 2019
     *      Problem: Didn't know how to change hex code to integer for the RBG value
     *      Resource:
     *          https://stackoverflow.com/questions/6926644/android-color-to-int-conversion
     *      Solution: I imported android.graphics.Color and assigned three integers to keep
     *      track of RGB values
     *
     *      Date 19 February 2019
     *      Problem: Wasn't sure how to implement the rectangle and circle images
     *      Resource:
     *          https://learning.up.edu/moodle/course/view.php?id=16718
     *      Solution: I used Professor Nuxoll's example code
     */
}
