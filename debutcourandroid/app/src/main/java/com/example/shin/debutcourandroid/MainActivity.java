package com.example.shin.debutcourandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
   private Button btn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("oc_rss", "ca marche");
                Intent myIntent = new Intent(MainActivity.this , next.class);
                startActivities(myIntent);
            }

            private void startActivities(Intent myIntent) {
                setContentView(R.layout.next);
            }
        });
    }

    
}
