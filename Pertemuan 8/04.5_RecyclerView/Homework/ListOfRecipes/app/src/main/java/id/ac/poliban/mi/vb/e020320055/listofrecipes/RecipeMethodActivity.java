package id.ac.poliban.mi.vb.e020320055.listofrecipes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RecipeMethodActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_method);
        setTitle("Rizka - Recipe");

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String item_name = null;
        if (extras != null) {
            item_name = extras.getString(RecipeListAdapter.EXTRA_NAME);
        }
        TextView heading = findViewById(R.id.food_name);
        TextView desc = findViewById(R.id.recipe_description);
        ImageView imageView = findViewById(R.id.food_image);
        heading.setText(item_name);
        if (item_name != null) {
            switch (item_name){
                case "Blackforest":
                    imageView.setImageResource(R.drawable.blackforest);
                    desc.setText(R.string.blackforest);
                    break;
                case "Blueberry Cupcakes":
                    imageView.setImageResource(R.drawable.blueberry_cupcake);
                    desc.setText(R.string.blueberrycupcake);
                    break;
                case "Chocolate Cake":
                    imageView.setImageResource(R.drawable.chocolate_cake);
                    desc.setText(R.string.chocolatecake);
                    break;
                case "Cookies":
                    imageView.setImageResource(R.drawable.cookies);
                    desc.setText(R.string.cookies);
                    break;
                case "Croissant":
                    imageView.setImageResource(R.drawable.croissant);
                    desc.setText(R.string.croissant);
                    break;
                case "Donut":
                    imageView.setImageResource(R.drawable.donut);
                    desc.setText(R.string.donut);
                    break;
                case "Macaron":
                    imageView.setImageResource(R.drawable.macaron);
                    desc.setText(R.string.macaron);
                    break;
                case "Pancake":
                    imageView.setImageResource(R.drawable.pancake);
                    desc.setText(R.string.pancake);
                    break;
                case "Rainbow Cake":
                    imageView.setImageResource(R.drawable.rainbow_cake);
                    desc.setText(R.string.rainbowcake);
                    break;
                case "Waffle":
                    imageView.setImageResource(R.drawable.waffle);
                    desc.setText(R.string.waffle);
                    break;
                default: break;
            }
        }
    }
}