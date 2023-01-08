package id.ac.poliban.mi.vb.e020320055.roomwordssample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class NewWordActivity extends AppCompatActivity {

    private EditText mEditTextView;

    public static final String EXTRA_REPLY =
            "id.ac.poliban.mi.vb.e020320055.roomwordssample.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);

        mEditTextView = findViewById(R.id.edit_word);
    }

    public void saveButton(View view) {
        Intent replyIntent = new Intent();

        //User did not enter a word
        if(TextUtils.isEmpty(mEditTextView.getText()))
            setResult(RESULT_CANCELED, replyIntent);

            //User entered a word
        else {
            String word = mEditTextView.getText().toString();
            Log.d("Word: ", word);
            replyIntent.putExtra(EXTRA_REPLY, word);
            setResult(RESULT_OK, replyIntent);
        }
        finish();
    }
}