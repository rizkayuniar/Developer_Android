package id.ac.poliban.mi.vb.e020320055.keyboarddialphone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Rizka - Keyboard Dial Phone");

        EditText editText = findViewById(R.id.editText_main);

        if (editText != null)
            editText.setOnEditorActionListener(
                    (textView, i, keyEvent) -> {
                        boolean handled = false;

                        if (i == EditorInfo.IME_ACTION_SEND) {
                            dialNumber();
                            handled = true;
                        }
                        return handled;
                    }
            );
    }

    private void dialNumber() {
        EditText editText = findViewById(R.id.editText_main);
        String phoneNum = null;

        if (editText != null) phoneNum = "tel:" + editText.getText().toString();

        Log.d(TAG, "dialnumber: " + phoneNum);

        Intent intent = new Intent(Intent.ACTION_DIAL);

        intent.setData(Uri.parse(phoneNum));

        if (intent. resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d(TAG, "ImplicitIntents: Cant' handle this!");
        }
    }
}