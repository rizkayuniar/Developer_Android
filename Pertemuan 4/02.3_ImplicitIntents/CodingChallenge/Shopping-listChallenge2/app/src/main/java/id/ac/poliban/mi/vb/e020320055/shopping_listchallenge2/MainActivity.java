package id.ac.poliban.mi.vb.e020320055.shopping_listchallenge2;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TAG";
    private TextView tV1;
    private TextView tV2;
    private TextView tV3;
    private TextView tV4;
    private TextView tV5;
    private TextView tV6;
    private TextView tV7;
    private TextView tV8;
    private TextView tV9;
    private TextView tV10;
    public static final int PRODUCT_REQUEST = 1;
    private int nr = 1;
    private EditText mLocationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Rizka - Shopping List Challenge 2");

        tV1 = (TextView) findViewById(R.id.textView1);
        tV2 = (TextView) findViewById(R.id.textView2);
        tV3 = (TextView) findViewById(R.id.textView3);
        tV4 = (TextView) findViewById(R.id.textView4);
        tV5 = (TextView) findViewById(R.id.textView5);
        tV6 = (TextView) findViewById(R.id.textView6);
        tV7 = (TextView) findViewById(R.id.textView7);
        tV8 = (TextView) findViewById(R.id.textView8);
        tV9 = (TextView) findViewById(R.id.textView9);
        tV10 = (TextView) findViewById(R.id.textView10);

        if (savedInstanceState != null) {
            tV1.setText(savedInstanceState.getString("product1"));
            tV2.setText(savedInstanceState.getString("product2"));
            tV3.setText(savedInstanceState.getString("product3"));
            tV4.setText(savedInstanceState.getString("product4"));
            tV5.setText(savedInstanceState.getString("product5"));
            tV6.setText(savedInstanceState.getString("product6"));
            tV7.setText(savedInstanceState.getString("product7"));
            tV8.setText(savedInstanceState.getString("product8"));
            tV9.setText(savedInstanceState.getString("product9"));
            tV10.setText(savedInstanceState.getString("product10"));
            nr = savedInstanceState.getInt("nr");
        }

        mLocationEditText = findViewById(R.id.location_edittext);
    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, PRODUCT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PRODUCT_REQUEST) {
            if (resultCode == RESULT_OK) {
                fillList(data.getStringExtra(SecondActivity.PRODUCT));
            }
        }
    }

    @Override
    protected void onSaveInstanceState(@Nullable Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("product1", tV1.getText().toString());
        outState.putString("product2", tV2.getText().toString());
        outState.putString("product3", tV3.getText().toString());
        outState.putString("product4", tV4.getText().toString());
        outState.putString("product5", tV5.getText().toString());
        outState.putString("product6", tV6.getText().toString());
        outState.putString("product7", tV7.getText().toString());
        outState.putString("product8", tV8.getText().toString());
        outState.putString("product9", tV9.getText().toString());
        outState.putString("product10", tV10.getText().toString());
        outState.putInt("nr", nr);
    }

    private void fillList (String product) {
        switch (nr) {
            case 1:
                tV1.setText(product);
                nr++;
                break;
            case 2:
                tV2.setText(product);
                nr++;
                break;
            case 3:
                tV3.setText(product);
                nr++;
                break;
            case 4:
                tV4.setText(product);
                nr++;
                break;
            case 5:
                tV5.setText(product);
                nr++;
                break;
            case 6:
                tV6.setText(product);
                nr++;
                break;
            case 7:
                tV7.setText(product);
                nr++;
                break;
            case 8:
                tV8.setText(product);
                nr++;
                break;
            case 9:
                tV9.setText(product);
                nr++;
                break;
            default:
                tV10.setText(product);
                break;
        }
    }

    public void openLocation(View view) {
        String loc = mLocationEditText.getText().toString();

        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }
}