package com.example.gitwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import org.kohsuke.github.GHRepository;

import java.io.IOException;

public class MainActivity2 extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn = findViewById(R.id.button2);
        ScrollView scrl = findViewById(R.id.scrollView);
        EditText edt = findViewById(R.id.editTextTextPersonName);
        TextView txt = findViewById(R.id.textView5);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "";
                try {
                    GithubQuery ghb = new GithubQuery(edt.getText().toString());
                    GHRepository[] ghrepos = ghb.getRepo();
                    for (GHRepository repo:
                         ghrepos) {
                        str += repo.getName();
                        str += "\n";
                    }
                    txt.setText(str);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}