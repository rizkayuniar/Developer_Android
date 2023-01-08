package id.ac.poliban.mi.vb.e020320055.checkboxesandetc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox cB1, cB2, cB3, cB4, cB5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Rizka - Checkboxes And Etc");

        cB1 = findViewById(R.id.checkBox);
        cB2 = findViewById(R.id.checkBox2);
        cB3 = findViewById(R.id.checkBox3);
        cB4 = findViewById(R.id.checkBox4);
        cB5 = findViewById(R.id.checkBox5);
    }

    public void ShowToast(View view) {
        String msg = "";

        if (cB1.isChecked())
            msg = msg + "\n" + getString(R.string.chocolate_syrup);
        if (cB2.isChecked())
            msg = msg + "\n" + getString(R.string.sprinkles);
        if (cB3.isChecked())
            msg = msg + "\n" + getString(R.string.crushed_nuts);
        if (cB4.isChecked())
            msg = msg + "\n" + getString(R.string.cherries);
        if (cB5.isChecked())
            msg = msg + "\n" + getString(R.string.orio_cookies_crumbles);

        Toast.makeText(this, "Toppings: " + msg , Toast.LENGTH_SHORT).show();
    }
}