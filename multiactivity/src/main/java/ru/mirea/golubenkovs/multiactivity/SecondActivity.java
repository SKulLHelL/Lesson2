package ru.mirea.golubenkovs.multiactivity;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String text = (String) getIntent().getSerializableExtra("key");

        TextView tvReceived = findViewById(R.id.tvReceivedText);
        if (text != null) {
            tvReceived.setText(text);
        } else {
            tvReceived.setText("Данные не получены");
        }
    }
}