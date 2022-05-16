package com.example.daoduythang_asm_assignment;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    AppDatabase db;
    EditText et_name, et_email, et_description;
    Spinner sp_type;
    Button btn_send;
    CheckBox cb_agree;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messenger_launcher_form);
        db = AppDatabase.getAppDatabase(this);
        init();
    }

    private void init() {
        et_name = findViewById(R.id.et_name);
        et_email = findViewById(R.id.et_email);
        et_description = findViewById(R.id.et_description);
        btn_send = findViewById(R.id.btn_send);
        sp_type = findViewById(R.id.sp_type);
        cb_agree = findViewById(R.id.cb_agree);

        btn_send.setOnClickListener(this);

        String[] types = {"Gripe", "Gripe1", "Gripe2"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                types);
        this.sp_type.setAdapter(adapter);

    }

    private void saveFeedback() {
        String require = "";
        if (et_name.getText().toString().isEmpty()) {
            require += "name,";
        }
        if (et_email.getText().toString().isEmpty()) {
            require += "mail,";
        }
        if (et_description.getText().toString().isEmpty()) {
            require += "description,";
        }
        if (!require.equals("")) {
            Toast.makeText(MainActivity.this, "Field " + require + " cant not be null", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this, "Success!", Toast.LENGTH_LONG).show();
            FeedBackEntity feedBack = new FeedBackEntity();
            feedBack.name = et_name.getText().toString();
            feedBack.email = et_email.getText().toString();
            feedBack.type = sp_type.getSelectedItem().toString();
            feedBack.description = et_description.getText().toString();
            db.feedBackDao().insertFeedBack(feedBack);
            viewTotalRecord();
        }
    }


    private void viewTotalRecord() {
        Integer count = db.feedBackDao().countTotalRecord();
        Toast.makeText(MainActivity.this, "Total : " + count + "\trecord", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_send:
                saveFeedback();
        }
    }
}
