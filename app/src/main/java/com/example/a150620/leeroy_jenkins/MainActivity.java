package com.example.a150620.leeroy_jenkins;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText chatName, username;
    String chatNameStr, usernameStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chatName = (EditText)findViewById(R.id.chatName);
        username = (EditText)findViewById(R.id.username);





    }

    public void enterChat(View view){
        Intent intent = new Intent(this, ChatActivity.class);

        chatNameStr = chatName.getText().toString();
        usernameStr = username.getText().toString();

        intent.putExtra("chatName", chatNameStr);
        intent.putExtra("username", usernameStr);

        Log.d("chatName", chatNameStr);
        Log.d("username", usernameStr);

        startActivity(intent);
    }
}