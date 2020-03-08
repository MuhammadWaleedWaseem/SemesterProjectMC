package com.example.semesterprojectmc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddGroup extends AppCompatActivity implements View.OnClickListener{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_group);

        final EditText getGroupName = findViewById(R.id.groupNameEditText);
        final Button btn = findViewById(R.id.addGroupBtn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //gname=getGroupName.getText().toString();
        final String g1="Hello";
        final int ownerId=123;
        GroupDAO groupDao=(GroupDAO) AppDatabase.getInstance(getApplicationContext()).group();
        Group g=new Group(g1,ownerId);
        groupDao.insertNewGroup(g);
        Toast.makeText(getApplicationContext(),"Group Added",Toast.LENGTH_SHORT).show();

    }


//    public void AddGroupFunc(View v){
//        String gname=getGroupName.getText().toString();
//        GroupDAO groupDao=(GroupDAO) AppDatabase.getInstance(getApplicationContext()).group();
//        Group g=new Group(gname,123);
//        groupDao.insertNewGroup(g);
//        Toast.makeText(getApplicationContext(),"Group Added",Toast.LENGTH_SHORT).show();
//    }

}
