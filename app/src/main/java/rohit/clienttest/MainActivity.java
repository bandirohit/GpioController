package rohit.clienttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Client myClient = new Client("128.237.219.218",12555);
        //myClient.execute();
        new Thread(new ClientThread()).start();

        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButton);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    ClientThread ct = new ClientThread();
                    ct.msg = "0";
                    new Thread(ct).start();
                    // The toggle is enabled
                } else
                {
                    // The toggle is disabled
                    ClientThread ct = new ClientThread();
                    ct.msg = "1";
                    new Thread(ct).start();
                }
            }
        });
    }
}
