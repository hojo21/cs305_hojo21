package com.example.hw2;

import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.Random;

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
    /** initializes Button called randomButton */
    private Button randomButton;
    /** initializes RadioButton called radioHair */
    private RadioButton radioHair;
    /** initializes RadioButton called radioSkin */
    private RadioButton radioSkin;
    /** initializes RadioButton called radioEyes */
    private RadioButton radioEyes;
    /** initializes CustomElement called element */
    private CustomElement element = null;
    /** initializes MySurfaceView object called mainSurface */
    MySurfaceView mainSurface;
    MainActivity activity;
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
     * @param initRandom
     * @param initHair
     * @param initSkin
     * @param initEyes
     * @param initMainSurface
     */
    public Controller(TextView initDisplay, TextView initRedDis, TextView initGreenDis,
                      TextView initBlueDis, SeekBar initRed,
                      SeekBar initGreen, SeekBar initBlue, Button initRandom,
                      RadioButton initHair, RadioButton initSkin, RadioButton initEyes,
                      MySurfaceView initMainSurface) {
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
        // assigns value for randomButton
        randomButton = initRandom;
        // assigns value for radioHair
        radioHair = initHair;
        // assigns value for radioSkin
        radioSkin = initSkin;
        // assigns value for radioEyes
        radioEyes = initEyes;
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
        /** checks to see if coordinates from user's touch are within the face image on
         * the surface view
         */
        if(mainSurface.face.containsPoint(xTouch, yTouch)){
            // sets element to face object
            element = mainSurface.face;
            // changes object name TextView to Face
            displayText.setText("Skin");
            // sets red RGB value to red integer
            red = red(mainSurface.face.getColor());
            // changes red TextView and displays the red integer value of the color
            redDisplay.setText("Red Value: "+red);
            // updates red SeekBar position
            redSeekBar.setProgress(red);
            // sets green RGB value to green integer
            green = green(mainSurface.face.getColor());
            // changes green TextView and displays the green integer value of the color
            greenDisplay.setText("Green Value: "+green);
            // updates green SeekBar position
            greenSeekBar.setProgress(green);
            // sets blue RGB value to blue integer
            blue = blue(mainSurface.face.getColor());
            // changes blue TextView and displays the blue integer value of the color
            blueDisplay.setText("Blue Value: "+blue);
            // updates blue SeekBar position
            radioSkin.isChecked();
            radioEyes.setChecked(false);
            radioHair.setChecked(false);
        }
        /**
         * same methods and actions are applied to the remaining image objects
         */
        if(mainSurface.leftEye.containsPoint(xTouch, yTouch)){
            element = mainSurface.leftEye;
            displayText.setText("Left Eye");
            red = red(mainSurface.leftEye.getColor());
            redDisplay.setText("Red Value: "+red);
            redSeekBar.setProgress(red);
            green = green(mainSurface.leftEye.getColor());
            greenDisplay.setText("Green Value: "+green);
            greenSeekBar.setProgress(green);
            blue = blue(mainSurface.leftEye.getColor());
            blueDisplay.setText("Blue Value: "+blue);
            blueSeekBar.setProgress(blue);
            radioEyes.isChecked();
            radioSkin.setChecked(false);
            radioHair.setChecked(false);
        }
        if(mainSurface.rightEye.containsPoint(xTouch, yTouch)){
            element = mainSurface.rightEye;
            displayText.setText("Right Eye");
            red = red(mainSurface.rightEye.getColor());
            redDisplay.setText("Red Value: "+red);
            redSeekBar.setProgress(red);
            green = green(mainSurface.rightEye.getColor());
            greenDisplay.setText("Green Value: "+green);
            greenSeekBar.setProgress(green);
            blue = blue(mainSurface.rightEye.getColor());
            blueDisplay.setText("Blue Value: "+blue);
            blueSeekBar.setProgress(blue);
            radioEyes.isChecked();
            radioSkin.setChecked(false);
            radioHair.setChecked(false);
        }
        if(mainSurface.hair.containsPoint(xTouch, yTouch)){
            element = mainSurface.hair;
            displayText.setText("Hair");
            red = red(mainSurface.hair.getColor());
            redDisplay.setText("Red Value: "+red);
            redSeekBar.setProgress(red);
            green = green(mainSurface.hair.getColor());
            greenDisplay.setText("Green Value: "+green);
            greenSeekBar.setProgress(green);
            blue = blue(mainSurface.hair.getColor());
            blueDisplay.setText("Blue Value: "+blue);
            blueSeekBar.setProgress(blue);
            radioHair.isChecked();
            radioSkin.setChecked(false);
            radioEyes.setChecked(false);
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
        if(activity.getText() == "Blond"){
            element = mainSurface.hair;
            displayText.setText("Hair");
            red = 255;
            redDisplay.setText("Red Value: "+red);
            redSeekBar.setProgress(red);
            green = 255;
            greenDisplay.setText("Green Value: "+green);
            greenSeekBar.setProgress(green);
            blue = 0;
            blueDisplay.setText("Blue Value: "+blue);
            blueSeekBar.setProgress(blue);
            radioHair.isChecked();
            radioEyes.setChecked(false);
            radioSkin.setChecked(false);
        }
        if(activity.getText() == "Brunette"){
            element = mainSurface.hair;
            displayText.setText("Hair");
            red = 139;
            redDisplay.setText("Red Value: "+red);
            redSeekBar.setProgress(red);
            green = 69;
            greenDisplay.setText("Green Value: "+green);
            greenSeekBar.setProgress(green);
            blue = 19;
            blueDisplay.setText("Blue Value: "+blue);
            blueSeekBar.setProgress(blue);
            radioHair.isChecked();
            radioEyes.setChecked(false);
            radioSkin.setChecked(false);
        }
        if(activity.getText() == "Black"){
            element = mainSurface.hair;
            displayText.setText("Hair");
            red = 0;
            redDisplay.setText("Red Value: "+red);
            redSeekBar.setProgress(red);
            green = 0;
            greenDisplay.setText("Green Value: "+green);
            greenSeekBar.setProgress(green);
            blue = 0;
            blueDisplay.setText("Blue Value: "+blue);
            blueSeekBar.setProgress(blue);
            radioHair.isChecked();
            radioEyes.setChecked(false);
            radioSkin.setChecked(false);
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
        /** checks to see if CustomElement is equal to the face image and if the user is changing
         * the seek bar
         */
        if(element == mainSurface.face && fromUser == true){
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
            // sets the color of the face image to the RGB integers found above
            mainSurface.face.setColor(rgb(red, green, blue));
            /**
             * uses the invalidate method to approve and output the changes made by the
             * user through the SeekBar
              */
            mainSurface.invalidate();
        }
        /**
         * same actions applied to the remaining image objects
         */
        if(element == mainSurface.leftEye && fromUser == true){
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
            mainSurface.leftEye.setColor(rgb(red, green, blue));
            mainSurface.invalidate();
        }
        if(element == mainSurface.rightEye && fromUser == true){
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
            mainSurface.rightEye.setColor(rgb(red, green, blue));
            mainSurface.invalidate();
        }
        if(element == mainSurface.hair && fromUser == true){
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
            mainSurface.hair.setColor(rgb(red, green, blue));
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
        Random rRand = new Random();
        Random gRand = new Random();
        Random bRand = new Random();
        Random xRand = new Random();
        int r = rRand.nextInt(256);
        int g = gRand.nextInt(256);
        int b = bRand.nextInt(256);
        int x = xRand.nextInt(9);

        if(v == randomButton){
            if(x < 3){
                element = mainSurface.face;
                red = r;
                redSeekBar.setProgress(red);
                redDisplay.setText("Red Value: "+ red);
                green = g;
                greenSeekBar.setProgress(green);
                greenDisplay.setText("Green Value: "+ green);
                blue = b;
                blueSeekBar.setProgress(blue);
                blueDisplay.setText("Blue Value: "+ blue);
                displayText.setText("Skin");
                mainSurface.face.setColor(rgb(red, green, blue));
                mainSurface.invalidate();
            }
            if(x >3 && x <6){
                element = mainSurface.rightEye;
                red = r;
                redSeekBar.setProgress(red);
                redDisplay.setText("Red Value: "+ red);
                green = g;
                greenSeekBar.setProgress(green);
                greenDisplay.setText("Green Value: "+ green);
                blue = b;
                blueSeekBar.setProgress(blue);
                blueDisplay.setText("Blue Value: "+ blue);
                displayText.setText("Right Eye");
                mainSurface.rightEye.setColor(rgb(red, green, blue));
                mainSurface.invalidate();
            }
            if(x == 3){
                element = mainSurface.leftEye;
                red = r;
                redSeekBar.setProgress(red);
                redDisplay.setText("Red Value: "+ red);
                green = g;
                greenSeekBar.setProgress(green);
                greenDisplay.setText("Green Value: "+ green);
                blue = b;
                blueSeekBar.setProgress(blue);
                blueDisplay.setText("Blue Value: "+ blue);
                displayText.setText("Left Eye");
                mainSurface.leftEye.setColor(rgb(red, green, blue));
                mainSurface.invalidate();
            }
            if(x >6){
                element = mainSurface.hair;
                red = r;
                redSeekBar.setProgress(red);
                redDisplay.setText("Red Value: "+ red);
                green = g;
                greenSeekBar.setProgress(green);
                greenDisplay.setText("Green Value: "+ green);
                blue = b;
                blueSeekBar.setProgress(blue);
                blueDisplay.setText("Blue Value: "+ blue);
                displayText.setText("Hair");
                mainSurface.hair.setColor(rgb(red, green, blue));
                mainSurface.invalidate();
            }
        }
        if(v == radioEyes){
            element = mainSurface.leftEye;
            displayText.setText("Eyes");
            red = red(mainSurface.leftEye.getColor());
            redDisplay.setText("Red Value: "+red);
            redSeekBar.setProgress(red);
            green = green(mainSurface.leftEye.getColor());
            greenDisplay.setText("Green Value: "+green);
            greenSeekBar.setProgress(green);
            blue = blue(mainSurface.leftEye.getColor());
            blueDisplay.setText("Blue Value: "+blue);
            blueSeekBar.setProgress(blue);
            radioEyes.isChecked();
            radioSkin.setChecked(false);
            radioHair.setChecked(false);

        }
        if(v == radioHair){
            element = mainSurface.hair;
            displayText.setText("Hair");
            red = red(mainSurface.hair.getColor());
            redDisplay.setText("Red Value: "+red);
            redSeekBar.setProgress(red);
            green = green(mainSurface.hair.getColor());
            greenDisplay.setText("Green Value: "+green);
            greenSeekBar.setProgress(green);
            blue = blue(mainSurface.hair.getColor());
            blueDisplay.setText("Blue Value: "+blue);
            blueSeekBar.setProgress(blue);
            radioHair.isChecked();
            radioEyes.setChecked(false);
            radioSkin.setChecked(false);
        }
        if(v == radioSkin){
            element = mainSurface.face;
            displayText.setText("Skin");
            red = red(mainSurface.face.getColor());
            redDisplay.setText("Red Value: "+red);
            redSeekBar.setProgress(red);
            green = green(mainSurface.face.getColor());
            greenDisplay.setText("Green Value: "+green);
            greenSeekBar.setProgress(green);
            blue = blue(mainSurface.face.getColor());
            blueDisplay.setText("Blue Value: "+blue);
            blueSeekBar.setProgress(blue);
            radioSkin.isChecked();
            radioHair.setChecked(false);
            radioEyes.setChecked(false);
        }
    }

    public void spinner() {
        if(activity.getText() == "Blond"){
            element = mainSurface.hair;
            displayText.setText("Hair");
            red = 255;
            redDisplay.setText("Red Value: "+red);
            redSeekBar.setProgress(red);
            green = 255;
            greenDisplay.setText("Green Value: "+green);
            greenSeekBar.setProgress(green);
            blue = 0;
            blueDisplay.setText("Blue Value: "+blue);
            blueSeekBar.setProgress(blue);
            radioHair.isChecked();
            radioEyes.setChecked(false);
            radioSkin.setChecked(false);
        }
        if(activity.getText() == "Brunette"){
            element = mainSurface.hair;
            displayText.setText("Hair");
            red = 139;
            redDisplay.setText("Red Value: "+red);
            redSeekBar.setProgress(red);
            green = 69;
            greenDisplay.setText("Green Value: "+green);
            greenSeekBar.setProgress(green);
            blue = 19;
            blueDisplay.setText("Blue Value: "+blue);
            blueSeekBar.setProgress(blue);
            radioHair.isChecked();
            radioEyes.setChecked(false);
            radioSkin.setChecked(false);
        }
        if(activity.getText() == "Black"){
            element = mainSurface.hair;
            displayText.setText("Hair");
            red = 0;
            redDisplay.setText("Red Value: "+red);
            redSeekBar.setProgress(red);
            green = 0;
            greenDisplay.setText("Green Value: "+green);
            greenSeekBar.setProgress(green);
            blue = 0;
            blueDisplay.setText("Blue Value: "+blue);
            blueSeekBar.setProgress(blue);
            radioHair.isChecked();
            radioEyes.setChecked(false);
            radioSkin.setChecked(false);
        }
    }

}
