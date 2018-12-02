package text.bwie.com.zdyview_lsbj;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class View_Title extends LinearLayout {

    private EditText title_text;
    private Button title_btn;

    public View_Title(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.titile,this);
        title_text = findViewById(R.id.title_text);
        title_btn = findViewById(R.id.title_btn);
    }


    public String setEdText(){
        String data = title_text.getText().toString().trim();
        return data;
    }

    public void setOnClickListeners(OnClickListener onClickListener){
        title_btn.setOnClickListener(onClickListener);
    }
}
