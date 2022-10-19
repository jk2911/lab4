package maxim.goy.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ClubInformationActivity extends AppCompatActivity {
    TextView name, coach, stadium, date, phone, email, link;
    Club club;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_information);

        Bundle bundle = getIntent().getExtras();
        club = (Club) bundle.getSerializable("club");

        name = findViewById(R.id.name);
        coach = findViewById(R.id.coach);
        stadium = findViewById(R.id.stadium);
        date = findViewById(R.id.date);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        link = findViewById(R.id.link);

        name.setText(club.getName());
        coach.setText(club.getCoach());
        stadium.setText(club.getStadium());
        date.setText(club.getStringDate());
        phone.setText(club.getPhone());
        email.setText(club.getEmail());
        link.setText(club.getLink());

    }

    public void back(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}