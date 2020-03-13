package com.example.customcontacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Contact extends AppCompatActivity {
    EditText etName,etPhone,etWeb,etMap;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etWeb = findViewById(R.id.etWeb);
        etMap = findViewById(R.id.etMap);
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etName.getText().toString().isEmpty()||etPhone.getText().toString().isEmpty()
                ||etWeb.getText().toString().isEmpty()||etMap.getText().toString().isEmpty()){
                    Toast.makeText(Contact.this,"Please enter all fields",Toast.LENGTH_SHORT).show();
                }
                else{
                    String name = etName.getText().toString().trim();
                    String phone = etPhone.getText().toString().trim();
                    String web = etWeb.getText().toString().trim();
                    String map = etMap.getText().toString().trim();
                    Intent intent = new Intent();
                    intent.putExtra("phone",phone);
                    intent.putExtra("website:",web);
                    intent.putExtra("map:",map);
                    setResult(RESULT_OK,intent);
                    Contact.this.finish();
                }
            }
        });

    }
}
