package id.ac.poliban.mi.vb.e020320055.recyclerviewhomeworkadaptivelayouts;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import id.ac.poliban.mi.vb.e020320055.recyclerviewhomeworkadaptivelayouts.databinding.ActivityMainBinding;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private final LinkedList<String> mWordList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        setTitle("Rizka - Recycler View Homework Adaptive Layouts");

        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        binding.fab.setOnClickListener(view -> {
            int wordListSize = mWordList.size();
            mWordList.addLast("+ Word " + wordListSize);
            mRecyclerView.getAdapter().notifyItemInserted(wordListSize);
            mRecyclerView.smoothScrollToPosition(wordListSize);
        });

        for (int i = 0; i < 20; i++) {
            mWordList.addLast("Word " + i);
        }

        mRecyclerView = findViewById(R.id.recyclerView);
        mAdapter = new WordListAdapter(this, mWordList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_reset) {
            mWordList.clear();

            for (int i = 0; i < 20; i++) {
                mWordList.addLast("Word " + i);
            }

            mAdapter.notifyDataSetChanged();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}