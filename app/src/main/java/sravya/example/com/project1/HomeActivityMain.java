package sravya.example.com.project1;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HomeActivityMain extends AppCompatActivity {
    private static int SPLASH_TIME =1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mian1);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeintent=new Intent(HomeActivityMain.this,MainActivity.class);
                startActivity(homeintent);
                finish();
            }
        },SPLASH_TIME);
    }
}
