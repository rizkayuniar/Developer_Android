package id.ac.poliban.mi.vb.e020320055.threebuttonschallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String CHOICE =
            "id.ac.poliban.mi.vb.e020320055.threebuttonschallenge.CHOICE";
    public static final String TITLE =
            "id.ac.poliban.mi.vb.e020320055.threebuttonschallenge.TITLE";
    public static final String SUBTITLE =
            "id.ac.poliban.mi.vb.e020320055.threebuttonschallenge.SUBTITLE";
    public Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Rizka - Three Buttons Challenge");

        intent = new Intent(this, SecondActivity.class);
    }

    public void launchOne(View view) {
        intent.putExtra(CHOICE, "one");
        intent.putExtra(TITLE,"Beatles Anthology Vol. 1");
        intent.putExtra(SUBTITLE, "Behind That Locked Door: Beatles Rarities!");
        startActivity(intent);
    }

    public void launchTwo(View view) {
        intent.putExtra(CHOICE, "two");
        intent.putExtra(TITLE,"next - My Bonnie and Ain’t She Sweet");
        intent.putExtra(SUBTITLE, "Behind That Locked Door: Beatles Rarities!");
        startActivity(intent);
    }

    public void launchThree(View view) {
        intent.putExtra(CHOICE, "three");
        intent.putExtra(TITLE,"next - She Loves You");
        intent.putExtra(SUBTITLE, "Behind That Locked Door: Beatles Rarities!");
        startActivity(intent);
    }
}