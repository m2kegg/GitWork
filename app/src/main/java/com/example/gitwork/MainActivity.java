package com.example.gitwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText email, passw;
    final int MIN_LENGTH = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button login = findViewById(R.id.button);
        init();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValid()) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                    startActivity(intent);
                };
            }
        });
    }

    void init() {
        email = findViewById(R.id.editTextTextEmailAddress);
        passw = findViewById(R.id.editTextTextPassword);
    }
    boolean isValid(){
        if (email.getText().toString().equals("")){
            email.setError("Enter a goddamn email, you piece of shit");
            return false;
        }
        else if (passw.getText().toString().equals("")){
            passw.setError("Enter a goddamn password, you piece of shit");
            return false;
        }

        else if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()){
            email.setError("Enter a goddamn valid email, you piece of shit");
            return false;
        }

       else if (passw.getText().toString().length() <= MIN_LENGTH) {
            passw.setError("Enter a goddamn valid password, you piece of shit");
            return false;
        }
       else
        return true;
    }


    public void goToSignup(View view) {
    }
}
