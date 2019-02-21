package com.example.hw2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

/**
 * <!-- class MySurfaceView -->
 *
 * This class defines instances for CustomCircle and CustomRect. It then
 * uses the onDraw method to illustrate images.
 *
 * @author Jordan Ho
 * @version 2-16-19
 *
 */

public class MySurfaceView extends SurfaceView {
    /** creates instance of CustomCircle for the sun drawing */
    protected CustomCircle sun = new CustomCircle("Sun",0xFFFFFF00, 200, 200,
            150);
    /** creates instance of CustomCircle for the snowman body drawing */
    protected CustomCircle snowMan1 = new CustomCircle("Snowman Body",0xFFFFFFFF, 1400,
            650, 150);
    /** creates instance of CustomCircle for the snowman head drawing */
    protected CustomCircle snowMan2 = new CustomCircle("Snowman Head",0xFFFFFFFF, 1400,
            450, 100);
    /** creates instance of CustomRect for the elevator drawing */
    protected CustomRect elevator = new CustomRect("Elevator", 0xFFD2B48C,
            500, 400, 1000, 1000);
    /** creates instance of CustomRect for the door drawing */
    protected CustomRect door = new CustomRect("Door", 0xFFFF0000,
            600, 500, 900, 1000);
    /** creates instance of CustomRect for the roof drawing */
    protected CustomRect roof = new CustomRect("Roof", 0xFF228B22,
            450, 375, 1050, 400);

    public MySurfaceView(Context context){
        super(context);
        init();
    }
    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MySurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setWillNotDraw(false);
    }

    /**
     *
     * onDraw method draws all of the instances of CustomRect and CustomCircle as well as
     * the canvas background
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        /** sets color for canvas background */
        canvas.drawColor(0xFF87ceeb);
        /** runs drawMe on the sun instance to draw image */
        sun.drawMe(canvas);
        /** runs drawMe on the snowman body instance to draw image */
        snowMan1.drawMe(canvas);
        /** runs drawMe on the snowman head instance to draw image */
        snowMan2.drawMe(canvas);
        /** runs drawMe on the elevator instance to draw image */
        elevator.drawMe(canvas);
        /** runs drawMe on the roof instance to draw image */
        roof.drawMe(canvas);
        /** runs drawMe on the door instance to draw image */
        door.drawMe(canvas);
    }
}

