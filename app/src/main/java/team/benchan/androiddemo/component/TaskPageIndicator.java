package team.benchan.androiddemo.component;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class TaskPageIndicator extends LinearLayout {

    private Paint mPaint;
    private Path mPath;
    private int mTranslationX = 0;
    private int itemHeight = 0;
    private float itemWidth = 0;
    private int splitCount = 1;

    public int getSplitCount() {
        return splitCount;
    }

    public void setSplitCount(int splitCount) {
        if(splitCount <= 0) this.splitCount = 1;
        else this.splitCount = splitCount;

        rebuildItem();
        invalidate();
    }

    public TaskPageIndicator(Context context) {
        this(context, null);
    }

    public TaskPageIndicator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setColor(Color.parseColor("#ff1890FF"));
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        itemHeight = getHeight();
        itemWidth = w/getSplitCount();
        rebuildItem();
    }

    private void rebuildItem() {
        mPath = new Path();
        mPath.moveTo(mTranslationX,0);
        mPath.lineTo(mTranslationX + itemWidth, 0);
        mPath.lineTo(mTranslationX + itemWidth, -itemHeight);
        mPath.lineTo(mTranslationX, -itemHeight);
        mPath.close();
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0, getHeight());
        canvas.drawPath(mPath, mPaint);
        canvas.restore();
        super.dispatchDraw(canvas);
    }

    public void scroll(int position, float positionOffset){
        int tabWidth = getWidth() / getSplitCount();
        mTranslationX = (int)(tabWidth * (positionOffset + position));
        rebuildItem();
        invalidate();
    }
}
