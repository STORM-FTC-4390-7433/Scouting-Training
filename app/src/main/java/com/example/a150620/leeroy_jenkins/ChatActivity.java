package com.example.a150620.leeroy_jenkins;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {
    ListView chatLog;
    EditText chatBox;
    String chatNameStr, usernameStr;
    ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        chatNameStr = getIntent().getStringExtra("chatName");
        usernameStr = getIntent().getStringExtra("username");
        arrayList = new ArrayList<String>();
        chatLog = (ListView)findViewById(R.id.chatLog);
        chatBox = (EditText)findViewById(R.id.chatBox);

        chatBox.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN){
                    if(keyCode == KeyEvent.KEYCODE_ENTER){
                        arrayList.add(chatBox.getText().toString() + " by " + usernameStr + " in " + chatNameStr);
                        chatLog.setAdapter(new ArrayAdapter<String>(getApplicationContext(), R.layout.list_content, R.id.list_content, arrayList.toArray(new String[arrayList.size()])));
                    }
                }
                return true;
            }
        });

    }
}
