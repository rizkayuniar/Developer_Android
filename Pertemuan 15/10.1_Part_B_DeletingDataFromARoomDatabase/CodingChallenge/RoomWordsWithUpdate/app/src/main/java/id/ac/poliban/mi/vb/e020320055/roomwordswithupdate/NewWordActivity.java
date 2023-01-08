package id.ac.poliban.mi.vb.e020320055.roomwordswithupdate;

import static id.ac.poliban.mi.vb.e020320055.roomwordswithupdate.MainActivity.EXTRA_DATA_ID;
import static id.ac.poliban.mi.vb.e020320055.roomwordswithupdate.MainActivity.EXTRA_DATA_UPDATE_WORD;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

public class NewWordActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "id.ac.poliban.mi.vb.e020320055.roomwordswithupdate";
    public static final String EXTRA_REPLY_ID = "id.ac.poliban.mi.vb.e020320055.roomwordswithupdate";

    private EditText mEditWordView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);

        mEditWordView = findViewById(R.id.edit_word);

        final Bundle extras = getIntent().getExtras();

        // If we are passed content, fill it in for the user to edit.
        if (extras != null) {
            String word = extras.getString(EXTRA_DATA_UPDATE_WORD, "");
            if (!word.isEmpty()) {
                mEditWordView.setText(word);
                mEditWordView.setSelection(word.length());
                mEditWordView.requestFocus();
            }
        } // Otherwise, start with empty fields.


        final Button button = findViewById(R.id.button_save);

        // When the user presses the Save button, create a new Intent for the reply.
        // The reply Intent will be sent back to the calling activity (in this case, MainActivity).
        button.setOnClickListener(view -> {
            // Create a new Intent for the reply.
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(mEditWordView.getText())) {
                // No word was entered, set the result accordingly.
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                // Get the new word that the user entered.
                String word = mEditWordView.getText().toString();
                // Put the new word in the extras for the reply Intent.
                replyIntent.putExtra(EXTRA_REPLY, word);
                if (extras != null && extras.containsKey(EXTRA_DATA_ID)) {
                    int id1 = extras.getInt(EXTRA_DATA_ID, -1);
                    if (id1 != -1) {
                        replyIntent.putExtra(EXTRA_REPLY_ID, id1);
                    }
                }
                // Set the result status to indicate success.
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }
}