package com.example.semesterprojectmc;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_1 extends Activity {
    private List<Contacts> contactsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prepareSamplecontactsData();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        ContactsAdapter contactsAdapter = new ContactsAdapter(contactsList);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(contactsAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                Contacts contacts = contactsList.get(position);
                FriendDAO friendDAO=(FriendDAO) AppDatabase.getInstance(getApplicationContext()).friend();
                Intent i=getIntent();
                int gid=i.getIntExtra("gidd",-1);
               // SharedPreferences sp=getSharedPreferences("Sharedpref",0);
              // int userid= Integer.parseInt(sp.getString("id",null));
                Friend friend= new Friend(121,contacts.getName(),gid);
                Toast.makeText(getApplicationContext(), contacts.getName() + " added to the Group!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

    }

    private void prepareSamplecontactsData() {
        Contacts contacts = new Contacts("Adil Khan",  "0323-4358258");
        contactsList.add(contacts);


        contacts = new Contacts("Bilal Arshad",  "0305-5179501");
        contactsList.add(contacts);

        contacts = new Contacts("Talha Sohail",  "0305-5175431");
        contactsList.add(contacts);

        contacts = new Contacts("Rameel Ahmad",  "0332-5179501");
        contactsList.add(contacts);

        contacts = new Contacts("Azeem Hamza",  "0322-7179501");
        contactsList.add(contacts);

        contacts = new Contacts("Alisha Munir",  "0305-5179501");
        contactsList.add(contacts);

        contacts = new Contacts("Bilal Arshad",  "0305-5179501");
        contactsList.add(contacts);

        contacts = new Contacts("Talha Sohail",  "0305-5175431");
        contactsList.add(contacts);

        contacts = new Contacts("Rameel Ahmad",  "0332-5179501");
        contactsList.add(contacts);

        contacts = new Contacts("Azeem Hamza",  "0322-7179501");
        contactsList.add(contacts);

        contacts = new Contacts("Alisha Munir",  "0305-5179501");
        contactsList.add(contacts);
        contacts = new Contacts("Bilal Arshad",  "0305-5179501");
        contactsList.add(contacts);

        contacts = new Contacts("Talha Sohail",  "0305-5175431");
        contactsList.add(contacts);

        contacts = new Contacts("Rameel Ahmad",  "0332-5179501");
        contactsList.add(contacts);

        contacts = new Contacts("Azeem Hamza",  "0322-7179501");
        contactsList.add(contacts);

        contacts = new Contacts("Alisha Munir",  "0305-5179501");
        contactsList.add(contacts);

        contacts = new Contacts("Bilal Arshad",  "0305-5179501");
        contactsList.add(contacts);

        contacts = new Contacts("Talha Sohail",  "0305-5175431");
        contactsList.add(contacts);

        contacts = new Contacts("Rameel Ahmad",  "0332-5179501");
        contactsList.add(contacts);

        contacts = new Contacts("Azeem Hamza",  "0322-7179501");
        contactsList.add(contacts);

        contacts = new Contacts("Alisha Munir",  "0305-5179501");
        contactsList.add(contacts);
    }

}
