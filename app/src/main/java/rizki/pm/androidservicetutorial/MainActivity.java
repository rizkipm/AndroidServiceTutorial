package rizki.pm.androidservicetutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnStart, btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = (Button)findViewById(R.id.buttonStart);
        btnStop = (Button)findViewById(R.id.buttonStop);

        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v == btnStart){

            //starting service
            startService(new Intent(this, MyService.class));

        }else  if (v == btnStop){

            //stopping service
            stopService(new Intent(this, MyService.class));

        }

    }
}
