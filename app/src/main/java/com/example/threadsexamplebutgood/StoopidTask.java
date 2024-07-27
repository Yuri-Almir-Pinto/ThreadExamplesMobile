package com.example.threadsexamplebutgood;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class StoopidTask extends AsyncTask<Void, Void, Void> {
    private final Button btnProcessar;
    private final TextView txtStatus;
    private int current;
    private int previous;

    public StoopidTask(Button button, TextView textView) {
        this.btnProcessar = button;
        this.txtStatus = textView;
    }

    @Override
    protected Void doInBackground(Void... nothing) {
        while (current != 0) {
            SystemClock.sleep(1000);
            this.current--;
            publishProgress(null);
        }

        return null;
    }

    @Override
    protected void onPreExecute() {
        btnProcessar.setEnabled(false);
        this.current = Integer.parseInt((String) txtStatus.getText());
        this.previous = this.current;
    }

    @Override
    protected void onProgressUpdate(Void... nothing) {
        this.txtStatus.setText(Integer.toString(this.current));
    }

    @Override
    protected void onPostExecute(Void nothing) {
        this.btnProcessar.setEnabled(true);
        this.txtStatus.setText(Integer.toString(this.previous));
        this.current = -1;
    }
}
