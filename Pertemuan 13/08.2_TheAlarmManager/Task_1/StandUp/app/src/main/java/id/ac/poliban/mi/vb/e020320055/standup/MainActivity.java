package id.ac.poliban.mi.vb.e020320055.standup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Rizka - Stand Up!");

        ToggleButton alarmToggle = findViewById(R.id.alarmToggle);

        alarmToggle.setOnCheckedChangeListener(
                (compoundButton, isChecked) -> {
                    String toastMessage;
                    if (isChecked) {
                        toastMessage = "Stand Up Alarm On!";
                    } else {
                        toastMessage = "Stand Up Alarm Off!";
                    }
                    Toast.makeText(MainActivity.this, toastMessage,Toast.LENGTH_SHORT).show();
                });
    }

}