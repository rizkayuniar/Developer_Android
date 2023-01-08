package id.ac.poliban.mi.vb.e020320055.threebuttonschallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView scrollTextView;
    TextView headerView;
    TextView subheaderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("Rizka - Three Buttons Challenge");

        Intent intent = getIntent();
        scrollTextView = findViewById(R.id.article);
        headerView = findViewById(R.id.article_heading);
        subheaderView = findViewById(R.id.article_subheading);

        headerView.setText(intent.getStringExtra(MainActivity.TITLE));
        subheaderView.setText(intent.getStringExtra(MainActivity.SUBTITLE));
        switch (intent.getStringExtra(MainActivity.CHOICE)) {
            case "one":
                scrollTextView.setText(R.string.article_text_1);
                break;
            case "two":
                scrollTextView.setText(R.string.article_text_2);
                break;
            case "three":
                scrollTextView.setText(R.string.article_text_3);
                break;
            default:
                throw new IllegalStateException("Unexpected Value: "
                        + intent.getStringExtra(MainActivity.CHOICE));
        }
    }
}