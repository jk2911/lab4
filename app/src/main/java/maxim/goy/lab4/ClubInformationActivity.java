package maxim.goy.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
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

    public void goPhone(View v) {
        Intent intent = new Intent(Intent.ACTION_DIAL,
                Uri.parse("tel:" + phone.getText().toString()));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        startActivity(intent);
    }

    public void goEmail(View v) {
        final Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setType("plain/text");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{email.getText().toString()});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Lector");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email text");

        startActivity(Intent.createChooser(emailIntent, "Send mail..."));
    }

    public void goSocialNet(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www." + club.getLink()));
        startActivity(intent);
    }

    public void back(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}