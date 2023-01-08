package id.ac.poliban.mi.vb.e020320055.hellotoast2activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView mTextHello;
    TextView mTextCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("Rizka - Second Activity");

        mTextHello = findViewById(R.id.text_hello);
        mTextCount = findViewById(R.id.text_count);
        Intent intent = getIntent();
        mTextCount.setText(Integer.toString(
                intent.getIntExtra(MainActivity.EXTRA_MESSAGE,0)));
    }
}