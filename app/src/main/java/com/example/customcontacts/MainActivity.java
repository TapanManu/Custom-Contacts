package com.example.customcontacts;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvHeader;
    Button btnCreate;
    ImageView ivCall,ivWeb,ivMap;
    final int CONTACT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvHeader = findViewById(R.id.tvHeader);
        btnCreate = findViewById(R.id.btnCreate);
        ivCall = findViewById(R.id.ivCall);
        ivCall.setVisibility(View.GONE);
        ivWeb = findViewById(R.id.ivWeb);
        ivWeb.setVisibility(View.GONE);
        ivMap = findViewById(R.id.ivMap);
        ivMap.setVisibility(View.GONE);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,com.example.customcontacts.Contact.class);
                startActivityForResult(intent,CONTACT);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CONTACT){
            if(resultCode == RESULT_OK){
                ivCall.setVisibility(View.VISIBLE);
                ivWeb.setVisibility(View.VISIBLE);
                ivMap.setVisibility(View.VISIBLE);
                ivCall.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String phone = data.getStringExtra("phone");
                        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone));
                        startActivity(intent);
                    }
                });
                ivMap.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String map = data.getStringExtra("map");
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0q="+map));
                        startActivity(intent);
                    }
                });
                ivWeb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String webpage = data.getStringExtra("website");
                        webpage = "http://"+ webpage;
                        Uri url = Uri.parse(webpage);
                        Intent intent = new Intent(Intent.ACTION_VIEW,url);
                        startActivity(intent);
                    }
                });
            }
        }
    }
}
