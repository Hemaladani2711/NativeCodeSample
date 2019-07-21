package com.sample.nativecodesample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnPressMe;
    ListView lstView;
    ArrayList<String> list=new ArrayList<>();
    ArrayAdapter arrayAdapter;
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPressMe=findViewById(R.id.btnPress);
        lstView=findViewById(R.id.listview);


        btnPressMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                list.add(stringFromJNI());
                arrayAdapter=new ArrayAdapter(getBaseContext(),R.layout.list_item,R.id.txtItem,list);
                lstView.setAdapter(arrayAdapter);

            }
        });

        // Example of a call to a native method
        // tv.setText(stringFromJNI());

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
