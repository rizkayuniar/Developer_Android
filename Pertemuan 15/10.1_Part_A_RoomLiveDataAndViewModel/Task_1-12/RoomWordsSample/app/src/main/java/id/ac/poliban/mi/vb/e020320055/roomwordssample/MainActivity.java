package id.ac.poliban.mi.vb.e020320055.roomwordssample;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.lifecycle.ViewModelProviders;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecylerView;
    private WordListAdapter mAdapter;
    private WordViewModel mWordViewModel;

    public static final String UPDATE_WORD = "word_to_be_updated";
    public static final String WORD_ID = "word_id";

    //Request Code
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Rizka - Room Words Sample");
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Once the FAB is clicked the NewWordActivity is called with an intent and if a word is inputted by the user onActivityResult will be called
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, NewWordActivity.class);
            startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
        });

        //Handle to RecyclerView
        mRecylerView = findViewById(R.id.recyclerview);
        //initializing the adapter
        mAdapter = new WordListAdapter(this);
        //Connect the adapter with the recycle view above
        mRecylerView.setAdapter(mAdapter);
        //Giving the recycle view a layout manager
        mRecylerView.setLayoutManager(new LinearLayoutManager(this));

        //Associating our ViewModel with our UI controller
        //ViewModelProviders creates and manages ViewModels
        mWordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);

        //Observer for the LiveData that is returned by the getAllWords() method in WordViewModel
        mWordViewModel.getAllWords().observe(this, new Observer<List<Word>>() {
            //This then updates the words in the adapter which then updates the recycler view
            @Override
            public void onChanged(@Nullable final List<Word> words) {
                // Update the cached copy of the words in the adapter.
                mAdapter.setWords(words);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Word word = new Word(data.getStringExtra(NewWordActivity.EXTRA_REPLY));
            mWordViewModel.insert(word);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }
}