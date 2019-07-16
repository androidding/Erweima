package com.example.dell.erweima;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.WriterException;
import com.google.zxing.common.BitmapUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText url;
    private Button but;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        
    }

    private void initView() {
        url = (EditText) findViewById(R.id.url);
        but = (Button) findViewById(R.id.but);
        img = (ImageView) findViewById(R.id.img);

        but.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but:
                String s = url.getText().toString().trim();
                jian(s);
                url.setText(" ");
                break;
        }
    }

    private void jian(String s) {
        Bitmap bitmap = null;
        try {
            bitmap = BitmapUtils.create2DCode(s);
            img.setImageBitmap(bitmap);

        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
