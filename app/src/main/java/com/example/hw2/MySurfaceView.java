package com.example.hw2;

import android.content.Context;
import android.graphics.Canvas;
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
    /** creates instance of CustomCircle for the face drawing */
    protected CustomCircle face = new CustomCircle("Face",0xFFFFFF00, 1000, 450,
            350);
    /** creates instance of CustomCircle for the left eye drawing */
    protected CustomCircle leftEye = new CustomCircle("Left Eye",0xFFFFFFFF, 850,
            350, 100);
    /** creates instance of CustomCircle for the left pupil drawing */
    protected CustomCircle leftP = new CustomCircle("Left P", 0xFF000000, 850,
            400, 50);
    /** creates instance of CustomCircle for the right eye drawing */
    protected CustomCircle rightEye = new CustomCircle("Right Eye",0xFFFFFFFF, 1150,
            350, 100);
    /** creates instance of CustomCircle for the right pupil drawing */
    protected CustomCircle rightP = new CustomCircle("Right P", 0xFF000000, 1150,
            400, 50);
    /** creates instance of CustomRect for the hair drawing */
    protected CustomRect hair = new CustomRect("Hair", 0xFF000000,
            600, 100, 1400, 200);
    /** creates instance of CustomRect for the door drawing */
    protected CustomRect door = new CustomRect("Door", 0xFFFF0000,
            0, 0, 0, 0);
    /**creates instance of CustomRect for the roof drawing */
    protected CustomRect roof = new CustomRect("Roof", 0xFF228B22,
            0, 0, 0, 0);

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
        /** runs drawMe on the face instance to draw image */
        face.drawMe(canvas);
        /** runs drawMe on the left eye instance to draw image */
        leftEye.drawMe(canvas);
        /** runs drawMe on the right eye instance to draw image */
        rightEye.drawMe(canvas);
        /** runs drawMe on the left pupil instance to draw image */
        leftP.drawMe(canvas);
        /** runs drawMe on the right pupil instance to draw image */
        rightP.drawMe(canvas);
        /** runs drawMe on the hair instance to draw image */
        hair.drawMe(canvas);
        /** runs drawMe on the roof instance to draw image */
        roof.drawMe(canvas);
        /** runs drawMe on the door instance to draw image */
        door.drawMe(canvas);
    }
}

