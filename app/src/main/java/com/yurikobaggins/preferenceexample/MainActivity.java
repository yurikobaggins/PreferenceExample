package com.yurikobaggins.preferenceexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText nicknameEditText = findViewById(R.id.nickname_edit_text);
        Button saveButton = findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nickname = nicknameEditText.getText().toString().trim();
                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                pref.edit().putString("NICKNAME", nickname).apply();

                TextView savedTextView = findViewById(R.id.saved_text_view);
                String savedText = pref.getString("NICKNAME", "");
                savedTextView.setText(savedText);
            }
        });
    }
}
