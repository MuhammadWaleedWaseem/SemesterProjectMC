package com.example.semesterprojectmc;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    final Context context = this;
    private String linkCopied;
    private String logout;
    private String logoutTitle;
    private String g1;
    private int ownerId;
    public Intent intent;

//    final EditText getGroupName = findViewById(R.id.groupNameEditText);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_group);
        logoutTitle = "Want to logout?";
        linkCopied = "Link copied to clipboard";
        logout = "You are currently signed in as shehroz@expensify.com";
        EditText getGroupName= (EditText) findViewById(R.id.groupNameEditText);
        g1=getGroupName.getText().toString();
        Button addGroupButton=(Button) findViewById(R.id.addGroupBtn);
        TextView logoutTV = (TextView) findViewById(R.id.loginNameTextView);
        TextView linkCopiedTV = (TextView) findViewById(R.id.inviteViaLinkTextView);
        //TextView addPeopleToTheGroupTV = (TextView) findViewById(R.id.addPeopleToTheGroupTextView);
 intent= new Intent(this,MainActivity_1.class);

//        addPeopleToTheGroupTV.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
// //               startActivity(intent);
//            }
//        });

        addGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ownerId=123;
                GroupDAO groupDao=(GroupDAO) AppDatabase.getInstance(getApplicationContext()).group();
                Group g=new Group(g1,ownerId);
                int gid=g.getGid();
                long l= groupDao.insertNewGroup(g);
                String k=String.valueOf(l);

                Toast.makeText(getApplicationContext()," Group Created",Toast.LENGTH_SHORT).show();

                intent.putExtra("gidd",gid);
                startActivity(intent);

            }
        });


        logoutTV.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(logoutTitle);
                builder.setMessage(logout);
                builder.setPositiveButton("CONFIRM", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
        linkCopiedTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("link","shehrozsohail786@expensify.com");
                assert clipboard != null;
                clipboard.setPrimaryClip(clip);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setTitle("Link Copied");
                alertDialogBuilder.setCancelable(false).setMessage(linkCopied).setNegativeButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.dismiss();
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}