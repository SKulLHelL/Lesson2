package ru.mirea.golubenkovs.multiactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickNewActivity(View view) {
        EditText etInput = findViewById(R.id.etInput);
        String userInput = etInput.getText().toString();

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);

        String textToSend = userInput.isEmpty()
                ? "MIREA - GOLUBENKO VLADIMIR SERGEEVICH"
                : userInput;

        intent.putExtra("key", textToSend);
        startActivity(intent);
    }
}