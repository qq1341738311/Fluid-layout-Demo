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

public class MainActivity extends AppCompatActivity {

    private View_LS_List zdyView;
    private List<String> dataAll = new ArrayList<>();
    private List<String> newDataAll = new ArrayList<>();
    private View_Title zdyTitle;

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
        zdyTitle = findViewById(R.id.zdyTitle);
        zdyView = (View_LS_List) findViewById(R.id.zdyView);
        zdyTitle.setOnClickListeners(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String trim = zdyTitle.setEdText();
                zdyView.removeChildView();
                newDataAll.add(trim);
                zdyView.setData(newDataAll);
                zdyView.setData(dataAll);
            }
        });
    }

}
