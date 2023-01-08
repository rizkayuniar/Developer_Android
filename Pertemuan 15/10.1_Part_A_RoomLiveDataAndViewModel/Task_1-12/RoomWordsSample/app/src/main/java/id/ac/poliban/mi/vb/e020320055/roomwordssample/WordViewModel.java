package id.ac.poliban.mi.vb.e020320055.roomwordssample;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel
{
    //Reference to the repo
    private WordRepository mRepository;

    //Used to cache the list of words
    private LiveData<List<Word>> mAllWords;

    public WordViewModel(Application application)
    {
        super(application);

        //Getting a list of all words from the WordRepo
        mRepository = new WordRepository(application);
        mAllWords = mRepository.getAllWords();
    }

    //Getter method that gets all the words and hides the implementation from the UI
    LiveData<List<Word>> getAllWords() { return mAllWords; }

    //Inserting a word into the repo which inserts it into the db
    //Called from the MainActivity in onActivityResult and used the Repository insert to
    // insert into the DB Room
    public void insert(Word word) { mRepository.insert(word); }
}

