package com.murach.ch10_ex5;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {


    private Timer timer;
    private TimerTask task;

    private final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void startTimer(View v) {

        timer = new Timer();

        initializeTimerTask();

        timer.schedule(task, 0, 1000);

    }

    public void stopTimerTask(View v) {

        if(timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    public void initializeTimerTask() {

        task = new TimerTask() {
            public void run() {

                handler.post(new Runnable() {
                    public void run() {

                        /*try{
                            // get the URL
                            URL url = new URL(URL_STRING);

                            // get the input stream
                            InputStream in = url.openStream();

                            // get the output stream
                            FileOutputStream out =
                                    context.openFileOutput(FILENAME, Context.MODE_PRIVATE);

                            // read input and write output
                            byte[] buffer = new byte[1024];
                            int bytesRead = in.read(buffer);
                            while (bytesRead != -1)
                            {
                                out.write(buffer, 0, bytesRead);
                                bytesRead = in.read(buffer);
                            }
                            out.close();
                            in.close();
                        }
                        catch (IOException e) {
                            Log.e("News reader", e.toString());
                        }*/

                        final String displayRSS = "File has been downloaded";

                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(getApplicationContext(), displayRSS, duration);
                        toast.show();

                    }
                });
            }
        };
    }



}