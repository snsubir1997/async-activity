package com.example.subir.asynctasks;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Bitmap bmp;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = findViewById(R.id.img);
    }

    public void loadImageButtonClicked(View v){
        loadImage();
    }

    public void showToastButtonClicked(View v){
        Toast.makeText(getApplicationContext(),"I am alive",Toast.LENGTH_SHORT).show();
    }

    private void loadImage(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                bmp = BitmapFactory.decodeResource(getResources(), R.drawable.image);

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        iv.setImageBitmap(bmp);
                    }
                });
            }
        }).start();
    }
}
