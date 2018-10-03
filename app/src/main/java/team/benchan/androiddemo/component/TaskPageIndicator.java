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
    private final int ITEM_HEIGHT = 10;
    private float itemWidth = 1/3F;
    private static final String TAG = "TaskPageIndicator";

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
        itemWidth = w/3;
        rebuildItem();
    }

    private void rebuildItem() {
        mPath = new Path();
        mPath.moveTo(mTranslationX,0);
        mPath.lineTo(mTranslationX + itemWidth, 0);
        mPath.lineTo(mTranslationX + itemWidth, ITEM_HEIGHT * -1);
        mPath.lineTo(mTranslationX, ITEM_HEIGHT * -1);
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
        int tabWidth = getWidth() / 3;
        mTranslationX = (int)(tabWidth * (positionOffset + position));
        rebuildItem();
        invalidate();
    }
}
