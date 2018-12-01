package text.bwie.com.zdyview_lsbj;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText ed_text;
    private Button ed_btn;
    private View_LS_List zdyView;
    private List<String> dataAll = new ArrayList<>();
    private List<String> newDataAll = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        zdyView.setData(dataAll);
    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            dataAll.add("sss"+i);
        }
    }

    private void initView() {
        ed_text = (EditText) findViewById(R.id.ed_text);
        ed_btn = (Button) findViewById(R.id.ed_btn);
        zdyView = (View_LS_List) findViewById(R.id.zdyView);
        ed_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ed_btn:
                String trim = ed_text.getText().toString().trim();
                zdyView.removeChildView();
                newDataAll.add(trim);
                zdyView.setData(newDataAll);
                zdyView.setData(dataAll);
                break;
        }
    }

}
