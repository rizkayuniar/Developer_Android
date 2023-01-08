/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.resourcechallenge2;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Sport> mSportsData;
    private SportsAdapter mAdapter;
    private static final String BUNDLE_KEY = "Sports_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Rizka - MaterialMe Resource Challenge 2");
        setContentView(R.layout.activity_main);

        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));
        mSportsData = new ArrayList<>();

        // Initialize the adapter and set it to the RecyclerView.
        mAdapter = new SportsAdapter(this, mSportsData);
        mRecyclerView.setAdapter(mAdapter);

        if (savedInstanceState != null) {
            mSportsData = savedInstanceState.getParcelableArrayList("sports_data");
            mAdapter = new SportsAdapter(this, mSportsData);
            mRecyclerView.setAdapter(mAdapter);
        } else {
            initializeData();
        }

        int swipeDirs;
        if (gridColumnCount > 1) {
            swipeDirs = 0;
        } else {
            swipeDirs = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        }

        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT |
                        ItemTouchHelper.DOWN | ItemTouchHelper.UP,
                swipeDirs) {

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView,
                                  @NonNull RecyclerView.ViewHolder viewHolder,
                                  @NonNull RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();

                Collections.swap(mSportsData, from, to);
                mAdapter.notifyItemMoved(from, to);
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder,
                                 int direction) {
                mSportsData.remove(viewHolder.getAdapterPosition());
                mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });
        helper.attachToRecyclerView(mRecyclerView);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("sports_data", mSportsData);
    }

    private void initializeData() {
        // Get the resources from the XML file.
        String[] sportsList = getResources()
                .getStringArray(R.array.sports_titles);
        String[] sportsInfo = getResources()
                .getStringArray(R.array.sports_info);
        TypedArray sportsImageResources =
                getResources().obtainTypedArray(R.array.sports_images);
        String[] sportsDetails = getResources()
                .getStringArray(R.array.sports_details);

        // Clear the existing data (to avoid duplication).
        mSportsData.clear();

        // Create the ArrayList of Sports objects with titles and
        // information about each sport.
        for(int i=0;i<sportsList.length;i++){
            mSportsData.add(new Sport(sportsList[i],sportsInfo[i],
                    sportsImageResources.getResourceId(i,0),  sportsDetails[i]));
        }

        sportsImageResources.recycle();

        // Notify the adapter of the change.
        mAdapter.notifyDataSetChanged();
    }
    public void resetSports(View view) {
        initializeData();
    }
}