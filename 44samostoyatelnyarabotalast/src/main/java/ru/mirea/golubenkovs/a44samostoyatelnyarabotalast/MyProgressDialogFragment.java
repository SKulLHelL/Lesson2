package ru.mirea.golubenkovs.dialog;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class MyProgressDialogFragment extends DialogFragment {
    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
        ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Загрузка");
        progressDialog.setMessage("Пожалуйста, подождите...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(100);
        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Отмена",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "Загрузка отменена", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

        // Simulate progress
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            int progress = 0;
            @Override
            public void run() {
                if (progress < 100) {
                    progress += 10;
                    progressDialog.setProgress(progress);
                    handler.postDelayed(this, 300);
                } else {
                    progressDialog.dismiss();
                    Toast.makeText(getActivity(), "Загрузка завершена", Toast.LENGTH_SHORT).show();
                }
            }
        }, 300);

        return progressDialog;
    }
}