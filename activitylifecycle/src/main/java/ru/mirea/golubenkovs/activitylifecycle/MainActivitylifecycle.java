package ru.mirea.golubenkovs.activitylifecycle;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivitylifecycle extends AppCompatActivity {
    private static final String TAG = "ActivityLifecycle";
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_activitylifecycle);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editText = findViewById(R.id.editText);
        Log.i(TAG, "onCreate() - EditText value: " + editText.getText().toString());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart() - EditText value: " + editText.getText().toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume() - EditText value: " + editText.getText().toString());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause() - EditText value: " + editText.getText().toString());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop() - EditText value: " + editText.getText().toString());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart() - EditText value: " + editText.getText().toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy() - EditText value: " + editText.getText().toString());
    }
}