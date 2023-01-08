package id.ac.poliban.mi.vb.e020320055.roomwordssample;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {
    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;


    //Constructor that gets a handle to the database and initializes the member variables
    WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();
    }

    //Wrapper to return the words as LiveData which basically notifies the MainActivity (Observer) when the words have been changed and the UI is updated
    LiveData<List<Word>> getAllWords()
    {
        return mAllWords;
    }

    //Wrapper for the insert method called from the WordViewModel which uses the WordDao
    public void insert(Word word) {/*Have to use an AsnycTask to call insert so it will be on a non-UI thread or the app will crash*/new insertAsyncTask(mWordDao).execute(word);}

    //AsyncTask<Parameter Type, Type to publish progress, Result type>
    private static class insertAsyncTask extends AsyncTask<Word, Void, Void>
    {
        private WordDao mAsyncTaskDao;

        //Constructor for the AsyncTask. Passed in a id.ac.poliban.mi.ramlan.roomwordssample_101a.
        // WordDao to call the insert method
        insertAsyncTask(WordDao dao) { mAsyncTaskDao = dao;}

        //Calling insert on another thread
        @Override
        protected Void doInBackground(final Word... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

}