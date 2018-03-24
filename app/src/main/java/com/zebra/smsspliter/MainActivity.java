package com.zebra.smsspliter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText message = (EditText) findViewById(R.id.messageText);
        final EditText phone = (EditText) findViewById(R.id.phoneText);
        Button sendButton = (Button) findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                splitMessage(phone.getText().toString(), message.getText().toString());
            }
        });
    }


    private void splitMessage(String phoneNumber, String message) {

        int i = 0;
        String[] strMessage = message.split(" ");


        SmsManager sms = SmsManager.getDefault();
        //sms.sendTextMessage(phoneNumber, null, message, null, null);

        while (i < strMessage.length) {

// переписать всю хрень ниже. Не выйдет использовать один индекс для двух массивов

                sms.sendTextMessage(phoneNumber, null, strMessage[i],
                        null, null);
                i++;

            }



        }

    }




