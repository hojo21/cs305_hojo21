package com.example.hw2;

import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.SeekBar;
import android.widget.TextView;
import static android.graphics.Color.red;
import static android.graphics.Color.green;
import static android.graphics.Color.blue;
import static android.graphics.Color.rgb;

/**
 * <!-- class Controller -->
 *
 * This class initializes all of the objects including the TextViews, SeekBars, CustomElement,
 * SurfaceView, and integers. These objects are assigned values. This class also handles the
 * events for when the user touches the screen to select an image, and when the values of
 * the seek bars are changed.
 *
 * @author Jordan Ho
 * @version 2-16-19
 *
 */

public class Controller implements View.OnClickListener, View.OnTouchListener,
        SeekBar.OnSeekBarChangeListener{

    /** initializes TextView called displayText */
    private TextView displayText = null;
    /** initializes TextView called redDisplay */
    private TextView redDisplay = null;
    /** initializes TextView called greenDisplay */
    private TextView greenDisplay = null;
    /** initializes TextView called blueDisplay */
    private TextView blueDisplay = null;
    /** initializes SeekBar called redSeekBar */
    private SeekBar redSeekBar = null;
    /** initializes SeekBar called greenSeekBar  */
    private SeekBar greenSeekBar = null;
    /** initializes SeekBar called blueSeekBar */
    private SeekBar blueSeekBar = null;
    /** initializes CustomElement called element */
    private CustomElement element = null;
    /** initializes MySurfaceView object called mainSurface */
    MySurfaceView mainSurface;
    /** initializes red integer for the red RGB value */
    int red;
    /** initializes green integer for the green RGB value */
    int green;
    /** initializes blue integer for the blue RGB value */
    int blue;

    /**
     *
     * Constructor for the Controller
     *
     * @param initDisplay
     * @param initRedDis
     * @param initGreenDis
     * @param initBlueDis
     * @param initRed
     * @param initGreen
     * @param initBlue
     * @param initMainSurface
     */
    public Controller(TextView initDisplay, TextView initRedDis, TextView initGreenDis,
                      TextView initBlueDis, SeekBar initRed,
                      SeekBar initGreen, SeekBar initBlue, MySurfaceView initMainSurface) {
        //assigns value for displayText
        displayText = initDisplay;
        // assigns value for redDisplay
        redDisplay = initRedDis;
        // assigns value for greenDisplay
        greenDisplay = initGreenDis;
        // assigns value for blueDisplay
        blueDisplay = initBlueDis;
        // assigns value for redSeekBar
        redSeekBar = initRed;
        // assigns value for greenSeekBar
        greenSeekBar = initGreen;
        // assigns value for blueSeekBar
        blueSeekBar = initBlue;
        // assigns value for mainSurface
        mainSurface = initMainSurface;
    }

    /**
     *
     * Gets coordinates of touches from the user and assigns them to integers. Uses these
     * coordinates to determine which image has been selected. Once an image is selected,
     * the object name TextView changes to whichever image has been selected. In addition to
     * this, the RGB text values are changed and the seek bars are adjusted to match those
     * values.
     *
     * @param v
     * @param event
     * @return
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        // creates integer for x coordinate of user's touch
        int xTouch = (int)event.getX();
        // creates integer for y coordinate of user's touch
        int yTouch = (int)event.getY();
        /** checks to see if coordinates from user's touch are within the sun image on
         * the surface view
         */
        if(mainSurface.sun.containsPoint(xTouch, yTouch)){
            // sets element to sun object
            element = mainSurface.sun;
            // changes object name TextView to Sun
            displayText.setText("Sun");
            // sets red RGB value to red integer
            red = red(mainSurface.sun.getColor());
            // changes red TextView and displays the red integer value of the color
            redDisplay.setText("Red Value: "+red);
            // updates red SeekBar position
            redSeekBar.setProgress(red);
            // sets green RGB value to green integer
            green = green(mainSurface.sun.getColor());
            // changes green TextView and displays the green integer value of the color
            greenDisplay.setText("Green Value: "+green);
            // updates green SeekBar position
            greenSeekBar.setProgress(green);
            // sets blue RGB value to blue integer
            blue = blue(mainSurface.sun.getColor());
            // changes blue TextView and displays the blue integer value of the color
            blueDisplay.setText("Blue Value: "+blue);
            // updates blue SeekBar position
        }
        /**
         * same methods and actions are applied to the remaining image objects
         */
        if(mainSurface.snowMan1.containsPoint(xTouch, yTouch)){
            element = mainSurface.snowMan1;
            displayText.setText("Snowman Body");
            red = red(mainSurface.snowMan1.getColor());
            redDisplay.setText("Red Value: "+red);
            redSeekBar.setProgress(red);
            green = green(mainSurface.snowMan1.getColor());
            greenDisplay.setText("Green Value: "+green);
            greenSeekBar.setProgress(green);
            blue = blue(mainSurface.snowMan1.getColor());
            blueDisplay.setText("Blue Value: "+blue);
            blueSeekBar.setProgress(blue);
        }
        if(mainSurface.snowMan2.containsPoint(xTouch, yTouch)){
            element = mainSurface.snowMan2;
            displayText.setText("Snowman Head");
            red = red(mainSurface.snowMan2.getColor());
            redDisplay.setText("Red Value: "+red);
            redSeekBar.setProgress(red);
            green = green(mainSurface.snowMan2.getColor());
            greenDisplay.setText("Green Value: "+green);
            greenSeekBar.setProgress(green);
            blue = blue(mainSurface.snowMan2.getColor());
            blueDisplay.setText("Blue Value: "+blue);
            blueSeekBar.setProgress(blue);
        }
        if(mainSurface.elevator.containsPoint(xTouch, yTouch)){
            element = mainSurface.elevator;
            displayText.setText("Elevator");
            red = red(mainSurface.elevator.getColor());
            redDisplay.setText("Red Value: "+red);
            redSeekBar.setProgress(red);
            green = green(mainSurface.elevator.getColor());
            greenDisplay.setText("Green Value: "+green);
            greenSeekBar.setProgress(green);
            blue = blue(mainSurface.elevator.getColor());
            blueDisplay.setText("Blue Value: "+blue);
            blueSeekBar.setProgress(blue);
        }
        if(mainSurface.door.containsPoint(xTouch, yTouch)){
            element = mainSurface.door;
            displayText.setText("Door");
            red = red(mainSurface.door.getColor());
            redDisplay.setText("Red Value: "+red);
            redSeekBar.setProgress(red);
            green = green(mainSurface.door.getColor());
            greenDisplay.setText("Green Value: "+green);
            greenSeekBar.setProgress(green);
            blue = blue(mainSurface.door.getColor());
            blueDisplay.setText("Blue Value: "+blue);
            blueSeekBar.setProgress(blue);
        }
        if(mainSurface.roof.containsPoint(xTouch, yTouch)){
            element = mainSurface.roof;
            displayText.setText("Roof");
            red = red(mainSurface.roof.getColor());
            redDisplay.setText("Red Value: "+red);
            redSeekBar.setProgress(red);
            green =green(mainSurface.roof.getColor());
            greenDisplay.setText("Green Value: "+green);
            greenSeekBar.setProgress(green);
            blue = blue(mainSurface.roof.getColor());
            blueDisplay.setText("Blue Value: "+blue);
            blueSeekBar.setProgress(blue);
        }
        return true;
    }
    /**
     *
     * This method changes the TextViews next to the SeekBars to match the position on the
     * SeekBar. It does this by using the progress integer parameter.
     * @param seekBar
     * @param progress
     * @param fromUser
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        /** checks to see if CustomElement is equal to the sun image and if the user is changing
         * the seek bar
         */
        if(element == mainSurface.sun && fromUser == true){
            // checks to see if the SeekBar being changed is the red SeekBar
            if(seekBar == redSeekBar){
                // changes red TextView to match the current value of the SeekBar
                redDisplay.setText("Red Value: "+ progress);
                // sets the red color integer to the current value of the red SeekBar
                red = progress;
            }
            // checks to see if the SeekBar being changed is the green seekBar
            if(seekBar == greenSeekBar){
                // changes the green TextView to match the current value of the SeekBar
                greenDisplay.setText("Green Value: "+ progress);
                // sets the green color integer to the current value of the green SeekBar
                green = progress;
            }
            // checks to see if the SeekBar being changed is the blue seekBar
            if(seekBar == blueSeekBar){
                // changes the blue TextView to match the current value of the SeekBar
                blueDisplay.setText("Blue Value: "+ progress);
                // sets the blue color integer to the current value of the blue SeekBar
                blue = progress;
            }
            // sets the color of the sun image to the RGB integers found above
            mainSurface.sun.setColor(rgb(red, green, blue));
            /**
             * uses the invalidate method to approve and output the changes made by the
             * user through the SeekBar
              */
            mainSurface.invalidate();
        }
        /**
         * same actions applied to the remaining image objects
         */
        if(element == mainSurface.snowMan1 && fromUser == true){
            if(seekBar == redSeekBar){
                redDisplay.setText("Red Value: "+ progress);
                red = progress;
            }
            if(seekBar == greenSeekBar){
                greenDisplay.setText("Green Value: "+ progress);
                green = progress;
            }
            if(seekBar == blueSeekBar){
                blueDisplay.setText("Blue Value: "+ progress);
                blue = progress;
            }
            mainSurface.snowMan1.setColor(rgb(red, green, blue));
            mainSurface.invalidate();
        }
        if(element == mainSurface.snowMan2 && fromUser == true){
            if(seekBar == redSeekBar){
                redDisplay.setText("Red Value: "+ progress);
                red = progress;
            }
            if(seekBar == greenSeekBar){
                greenDisplay.setText("Green Value: "+ progress);
                green = progress;
            }
            if(seekBar == blueSeekBar){
                blueDisplay.setText("Blue Value: "+ progress);
                blue = progress;
            }
            mainSurface.snowMan2.setColor(rgb(red, green, blue));
            mainSurface.invalidate();
        }
        if(element == mainSurface.elevator && fromUser == true){
            if(seekBar == redSeekBar){
                redDisplay.setText("Red Value: "+ progress);
                red = progress;
            }
            if(seekBar == greenSeekBar){
                greenDisplay.setText("Green Value: "+ progress);
                green = progress;
            }
            if(seekBar == blueSeekBar){
                blueDisplay.setText("Blue Value: "+ progress);
                blue = progress;
            }
            mainSurface.elevator.setColor(rgb(red, green, blue));
            mainSurface.invalidate();
        }
        if(element == mainSurface.door && fromUser == true){
            if(seekBar == redSeekBar){
                redDisplay.setText("Red Value: "+ progress);
                red = progress;
            }
            if(seekBar == greenSeekBar){
                greenDisplay.setText("Green Value: "+ progress);
                green = progress;
            }
            if(seekBar == blueSeekBar){
                blueDisplay.setText("Blue Value: "+ progress);
                blue = progress;
            }
            mainSurface.door.setColor(rgb(red, green, blue));
            mainSurface.invalidate();
        }
        if(element == mainSurface.roof && fromUser == true){
            if(seekBar == redSeekBar){
                redDisplay.setText("Red Value: "+ progress);
                red = progress;
            }
            if(seekBar == greenSeekBar){
                greenDisplay.setText("Green Value: "+ progress);
                green = progress;
            }
            if(seekBar == blueSeekBar){
                blueDisplay.setText("Blue Value: "+ progress);
                blue = progress;
            }
            mainSurface.roof.setColor(rgb(red, green, blue));
            mainSurface.invalidate();
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onClick(View v) {

    }
}
