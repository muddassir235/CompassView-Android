package com.example.hp.sunshine;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by hp on 9/22/2016.
 */
public class Compass extends View {
    float angle;

    int bitmap_width;
    int bitmap_height;

    Path path = new Path();
    Path trianglePath = new Path();
    Paint arrow_brush = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint triangle_fill = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Compass(Context context) {
        super(context);
        setWillNotDraw(false);
        this.bitmap_width = getPxFromDP(22);
        this.bitmap_height = getPxFromDP(22);
        angle = 0;
        this.setRotation(angle);
        definePath(11,11,1f);
        arrow_brush.setStyle(Paint.Style.STROKE);
        trianglePath.setFillType(Path.FillType.EVEN_ODD);
        arrow_brush.setColor(getResources().getColor(R.color.sunshine_blue));
        arrow_brush.setStrokeWidth(getPxFromDP(4));
        triangle_fill.setStyle(Paint.Style.FILL);
        triangle_fill.setColor(getResources().getColor(R.color.sunshine_blue));
        arrow_brush.setAntiAlias(true);
        arrow_brush.setFilterBitmap(true);
        triangle_fill.setAntiAlias(true);
        triangle_fill.setFilterBitmap(true);
        defineTriangle(11,11,1f);
    }

    public Compass(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        this.bitmap_width = getPxFromDP(22);
        this.bitmap_height = getPxFromDP(22);
        angle = 0;
        this.setRotation(angle);
        definePath(11,11,1f);
        trianglePath.setFillType(Path.FillType.EVEN_ODD);
        arrow_brush.setStyle(Paint.Style.STROKE);
        arrow_brush.setColor(getResources().getColor(R.color.sunshine_blue));
        arrow_brush.setStrokeWidth(getPxFromDP(4));
        triangle_fill.setStyle(Paint.Style.FILL);
        triangle_fill.setColor(getResources().getColor(R.color.sunshine_blue));
        arrow_brush.setAntiAlias(true);
        arrow_brush.setFilterBitmap(true);
        triangle_fill.setAntiAlias(true);
        triangle_fill.setFilterBitmap(true);
        defineTriangle(11,11,1f);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // Measure Modes
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        // dimensions passed by parent
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        int widthToDraw;
        int heightToDraw;

        if(widthMode == MeasureSpec.EXACTLY){
            widthToDraw = width;
        }else{
            widthToDraw = bitmap_width;
        }


        if(heightMode == MeasureSpec.EXACTLY){
            heightToDraw = height;
        }else{
            heightToDraw = bitmap_height;
        }

        setMeasuredDimension(widthToDraw,heightToDraw);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path,arrow_brush);
        canvas.drawPath(trianglePath,triangle_fill);
    }

    public void setAngle(float angle){
        this.angle = angle;
        this.setRotation(this.angle);
        this.invalidate();
        this.requestLayout();
    }

    public void setScale(float scale){
        path = new Path();
        trianglePath = new Path();
        trianglePath.setFillType(Path.FillType.EVEN_ODD);
        this.defineTriangle(11,11,scale);
        this.definePath(11,11,scale);
        arrow_brush.setStrokeWidth(getPxFromDP(4f*scale));
        this.invalidate();
        this.requestLayout();
    }

    void definePath(int x_dps, int y_dps, float scale){
        path.moveTo(getPxFromDP(x_dps),getPxFromDP(y_dps+11f*scale));
        path.lineTo(getPxFromDP(x_dps),getPxFromDP(y_dps-9f*scale));
    }

    void defineTriangle(int x_dps, int y_dps, float scale){
        trianglePath.moveTo(getPxFromDP(x_dps),getPxFromDP(y_dps-11f*scale));
        trianglePath.lineTo(getPxFromDP(x_dps-9f*scale),getPxFromDP(y_dps-3f*scale));
        //trianglePath.moveTo(getPxFromDP(x_dps-7f*scale),getPxFromDP(y_dps-5.5f*scale));
        trianglePath.lineTo(getPxFromDP(x_dps),getPxFromDP(y_dps-5f*scale));
        //trianglePath.moveTo(getPxFromDP(x_dps),getPxFromDP(y_dps-7f*scale));
        trianglePath.lineTo(getPxFromDP(x_dps+9f*scale),getPxFromDP(y_dps-3f*scale));
        //trianglePath.moveTo(getPxFromDP(x_dps+7f*scale),getPxFromDP(y_dps-5.5f*scale));
        trianglePath.lineTo(getPxFromDP(x_dps),getPxFromDP(y_dps-11f*scale));
        trianglePath.moveTo(getPxFromDP(x_dps),getPxFromDP(y_dps-11f*scale));
        trianglePath.close();
    }

    void scaleBrushWidth(float scale){
        arrow_brush.setStrokeWidth(getPxFromDP(4*scale));
    }

    int getPxFromDP(float dps){
        return (int) (dps* getResources().getDisplayMetrics().density);
    }
}
