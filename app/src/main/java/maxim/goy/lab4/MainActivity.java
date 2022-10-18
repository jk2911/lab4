package maxim.goy.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        Intent intent = new Intent(this, ClubActivity.class);

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

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Club club = (Club) parent.getItemAtPosition(i);
                intent.putExtra("club", club);
                startActivity(intent);
            }
        };
        clubs.setOnItemClickListener(itemClickListener);
    }
}