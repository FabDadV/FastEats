package a.fasteats.ui;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import a.fasteats.R;
import a.fasteats.models.Restaurant;
import a.fasteats.utils.RestaurantGen;

public class MainActivity extends AppCompatActivity {
    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firestore = FirebaseFirestore.getInstance();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            // TODO(developer): Добавить случайные рестораны
            // Получение ссылки на созданную коллекцию ресторанов «restaurants»:
            CollectionReference restaurants = firestore.collection("restaurants");
            for (int i = 0; i < 9; i++) {
                // Получить случайным образом экземпляр объекта (POJO) Restaurant
                Restaurant restaurant = RestaurantGen.getRandom(this);
                // Добавляем новый документ «restaurant» в коллекцию «restaurants»:
                restaurants.add(restaurant);
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
