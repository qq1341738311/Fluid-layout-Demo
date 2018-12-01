package text.bwie.com.zdyview_lsbj;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.LongDef;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class newView_LS extends LinearLayout{

    private int MaxWhith;
    private int newDataWhith;
    private LinearLayout layout;
    private int shengxiadeWhith;

    public newView_LS(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        //设置屏幕最大宽度
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        MaxWhith = metrics.widthPixels;

        //设置布局为垂直显示
        setOrientation(VERTICAL);

        layout = initLinearLayout();

    }

    public int setDataWhith(String data){
        TextView textView = initTextView();
        TextPaint paint = textView.getPaint();
        // 得到使用该paint写上text的时候,像素为多少
        float textLength = paint.measureText(data);
        //转化成数据的宽度
        int textWhith = (int) textLength;
        return textWhith;
    }


    public void setData(String data){

        //获取字符串的宽度
        int dataWhith = setDataWhith(data);
        //Log.v("文字宽度",dataWhith+"");
        //获取总文字的宽度
        newDataWhith += dataWhith;

        TextView textView = initTextView();
        textView.setText(data);

        if(newDataWhith>=MaxWhith){
            layout = initLinearLayout();
            layout.addView(textView);
            return;
        }else{
            Log.v("1","x");
            shengxiadeWhith = MaxWhith - newDataWhith;
            Log.v("dataWhith",dataWhith+"x");
            Log.v("shengxiadeWhith",shengxiadeWhith+"x");
            if(dataWhith>=shengxiadeWhith) {
                Log.v("1","y");
                newDataWhith = 0;
                layout = initLinearLayout();
                layout.addView(textView);
                shengxiadeWhith = MaxWhith;
                return;
            }else{
                layout.addView(textView);
            }
        }


        /*shengxiadeWhith = MaxWhith - newDataWhith;
        if(shengxiadeWhith>dataWhith) {
            layout = initLinearLayout();
            layout.addView(textView);
            shengxiadeWhith = 0;
            return;
        }else{
        layout.addView(textView);
    }*/
    }

    public LinearLayout initLinearLayout(){
        LinearLayout layout = new LinearLayout(getContext());
        //设置宽高
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        layout.setLayoutParams(params);
        this.addView(layout);
        return layout;
    }

    public TextView initTextView(){
        TextView textView = new TextView(getContext());
        textView.setTextColor(Color.GRAY);
        textView.setTextSize(30);
        //引用XML实现TextView带边框
        textView.setBackgroundResource(R.drawable.text_shape);
        //设置宽高
        //LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //为textView设置间距
        //params.setMargins(30,15,0,0);
        //textView.setLayoutParams(params);
        return textView;
    }
}
