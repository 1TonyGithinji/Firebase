package com.example.anthony.firebase;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, mail, age;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.editText);
        mail=(EditText)findViewById(R.id.editText2);
        age=(EditText)findViewById(R.id.editText3);
    }
    public void save (View view){
        String names = name.getText().toString();
        String emails = mail.getText().toString();
        String ages = age.getText().toString();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Saving Details");
        if (names.isEmpty() || emails.isEmpty()|| ages.isEmpty())
        Toast.makeText(this,
                "Fill in all slots",

                Toast.LENGTH_SHORT).show();
        return;
    }
    long time=System.currentTimeMillis();
    DatabaseReference ref=FirebaseDatabase.getInstance()
            .getReference ().child("Names/+time");
    User one=new User(names,emails,ages);

}
