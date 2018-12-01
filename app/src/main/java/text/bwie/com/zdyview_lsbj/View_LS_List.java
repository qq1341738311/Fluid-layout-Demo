package text.bwie.com.zdyview_lsbj;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class View_LS_List extends LinearLayout {
    private int mScreenWidth;

    public View_LS_List(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        mScreenWidth = metrics.widthPixels;
        //设置这个布局垂直显示
        setOrientation(VERTICAL);
    }

    public void removeChildView() {
        //移除所有子控件
        removeAllViews();
    }

    public void setData(List<String> data) {
        LinearLayout linearLayout = initLearLayouy();//[lvxx,lxs,lzs,lzzs]
        for (int i = 0; i < data.size(); i++) {//lvxx
            String tmp = data.get(i);
            int numWidth = 0;
            //得到一行LinearLayout到底有多少子控件  因为我要计算每个子控件加在一起的宽度
            int childCount = linearLayout.getChildCount();
            //这个for循环只是计算一行LinearLayout的所有子控件的宽的和
            for (int j = 0; j < childCount; j++) {
                //通过index得到每一个子控件
                TextView tv = (TextView) linearLayout.getChildAt(j);
                LayoutParams layoutParams = (LayoutParams) tv.getLayoutParams();
                int leftMargin = layoutParams.leftMargin;
                //测量这个tv的高和宽
                tv.measure(getMeasuredWidth(), getMeasuredHeight());
                numWidth += tv.getMeasuredWidth() + leftMargin+tv.getPaddingLeft()+getPaddingRight();
            }

            TextView dataText = initText();
            //设置属性
            LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            params.leftMargin = 10;
            params.topMargin = 2;
            dataText.setLayoutParams(params);
            dataText.setText(tmp);
            dataText.measure(getMeasuredWidth(), getMeasuredHeight());
            int dataTextWidth = dataText.getMeasuredWidth()+dataText.getPaddingLeft()+dataText.getPaddingRight();
            //考虑到一个字符串很长 就直接超过整个屏幕的高了
            if (dataTextWidth>=mScreenWidth){
                String s = tmp.substring(0, 4);
                dataText.setText(s+"...");
                dataText.measure(getMeasuredWidth(), getMeasuredHeight());
                dataTextWidth = dataText.getMeasuredWidth();
            }
            //当TextView放满整一行的时候我们需要重新创建一个子LinearLayout重新放置TextView
            if (mScreenWidth >= numWidth + dataTextWidth) {
                linearLayout.addView(dataText);
            } else {
                //这里面对LinearLayout重新赋值  通过getLin换行
                linearLayout = initLearLayouy();
                linearLayout.addView(dataText);
            }

        }

    }


    //初始化TextView
    private TextView initText() {
        TextView textView = new TextView(getContext());
        textView.setTextSize(20);
        textView.setTextColor(Color.BLACK);
        //引用XML实现TextView带边框
        textView.setBackgroundResource(R.drawable.text_shape);
        textView.setPadding(10,10,10,10);
        return textView;
    }

    //初始化子LinearLayout

    private LinearLayout initLearLayouy() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        //LayoutParams 控制组件大小的一个工具类
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        linearLayout.setLayoutParams(params);
        //this本类对象
        this.addView(linearLayout);//只要重新添加View了自动换行了
        return linearLayout;
    }

}
