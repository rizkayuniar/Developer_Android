package id.ac.poliban.mi.vb.e020320055.droidcafeoptions2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import id.ac.poliban.mi.vb.e020320055.droidcafeoptions2.databinding.ActivityMainBinding;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    public static final String EXTRA_MESSAGE =
            "id.ac.poliban.mi.vb.e020320055.droidcafeoptions2.extra.MESSAGE";

    private String mOrderMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        setTitle("Rizka - Droid Cafe Options 2");

        binding.fab.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, OrderActivity.class);
            intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
            startActivity(intent);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_order) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void showDonutOrder(View view) {
        mOrderMessage = getString(R.string.donut_order_message);
        displayToast(mOrderMessage);
    }

    public void showIceCreamOrder(View view) {
        mOrderMessage = getString(R.string.ice_cream_order_message);
        displayToast(mOrderMessage);
    }

    public void showFroyoOrder(View view) {
        mOrderMessage = getString(R.string.froyo_order_message);
        displayToast(mOrderMessage);
    }
}