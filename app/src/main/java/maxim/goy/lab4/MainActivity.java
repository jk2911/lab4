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
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView clubs;
    List<Club> clubList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, ClubInformationActivity.class);

        clubs = findViewById(R.id.listView);

        clubList = JsonHelper.importFromJSON(this);

        if (clubList != null) {

            ArrayAdapter<Club> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, clubList);
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

    public void add(View v) {
        Intent intent = new Intent(this, ClubActivity.class);
        startActivity(intent);
    }
}