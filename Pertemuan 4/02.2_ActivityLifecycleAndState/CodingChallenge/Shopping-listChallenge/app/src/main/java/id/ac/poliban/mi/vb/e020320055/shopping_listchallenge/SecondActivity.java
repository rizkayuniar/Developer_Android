package id.ac.poliban.mi.vb.e020320055.shopping_listchallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    public static final String PRODUCT =
            "id.ac.poliban.mi.vb.e020320055.shopping_listchallenge.PRODUCT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("Rizka - Second Activity");
    }

    public void getProduct(View view) {
        Button button = (Button) view;
        Intent replyIntent = new Intent();
        replyIntent.putExtra(PRODUCT, button.getText().toString());
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}