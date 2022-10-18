package maxim.goy.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {
    ListView clubs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clubs = findViewById(R.id.listView);
        ArrayList<Club> c = new ArrayList<>();

        ArrayList<String> t = new ArrayList<>();

        t.add("Ла Лига");
        t.add("Кубок Испании");
        t.add("Лига Чемпионов");

        c.add(new Club("Barcelona", new GregorianCalendar(), "Xavi", "Nou Camp", t));
        c.add(new Club("Real Madrid", new GregorianCalendar(), "Ancelotti", "Bernabeu", t));

        ArrayAdapter<Club> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, c);
        clubs.setAdapter(adapter);
    }
}