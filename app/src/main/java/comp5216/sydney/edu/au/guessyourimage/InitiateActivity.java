package comp5216.sydney.edu.au.guessyourimage;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class InitiateActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int KEEP_TIME = 2000;
    private Handler handler;
    private ImageView imageView;
    private ImageView nameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "----------onCreate----------");

        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_initiate);
        handler = new Handler();
        imageView = (ImageView) findViewById(R.id.logo);
        imageView.setImageResource(R.mipmap.ic_launcher);
        nameView = (ImageView) findViewById(R.id.name);
        nameView.setImageResource(R.mipmap.name);


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(InitiateActivity.this,  MainActivity.class);

                Log.d(TAG, "----------startActivityIntent----------");
                startActivity(intent);
                finish();
            }
        }, KEEP_TIME);
    }
}