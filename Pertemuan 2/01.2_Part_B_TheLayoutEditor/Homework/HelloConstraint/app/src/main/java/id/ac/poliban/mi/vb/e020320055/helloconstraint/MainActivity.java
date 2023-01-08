package id.ac.poliban.mi.vb.e020320055.helloconstraint;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Rizka - Hello Constraint");

        mShowCount = findViewById(R.id.show_count);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
            Button btn_count = findViewById(R.id.button_count);
            if (mCount % 2 == 0) {
                btn_count.setBackgroundColor(Color.CYAN);
            } else {
                btn_count.setBackgroundColor(Color.MAGENTA);
            }
            if (mCount >= 0) {
                Button btnZero = this.findViewById(R.id.button_zero);
                btnZero.setBackgroundColor(Color.GREEN);
            }
        }
    }

    public void resetCount(View view) {
        mCount = 0;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
            Button button = findViewById(R.id.button_zero);
            if (mCount == 0) {
                button.setBackgroundColor(Color.GRAY);
            }
        }
    }
}