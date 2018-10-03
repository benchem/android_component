package team.benchan.androiddemo.component;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import team.benchan.androiddemo.R;

public class SearchComponent extends RelativeLayout {

    public SearchComponent(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.component_search,this);
    }


}
