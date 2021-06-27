package co.edu.myconstraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTo;
    private EditText editTextSubject;
    private EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTo = findViewById(R.id.edit_to);
        editTextSubject = findViewById(R.id.edit_subject);
        editTextMessage = findViewById(R.id.edit_message);

        Button buttonSend = findViewById(R.id.button_send);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                sendEmail();
            }
        });
    }

    private void sendEmail(){
        String recipientList = editTextTo.getText().toString();
        String[] recipients = recipientList.split(",");
        String subject = editTextSubject.getText().toString();
        String message = editTextMessage.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,message);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"Escoja un email de cliente"));

    }
}