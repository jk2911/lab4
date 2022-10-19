package maxim.goy.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class ClubActivity extends AppCompatActivity {
    List<Club> clubs;
    EditText name, coach, stadium;
    TextView date;
    Club club;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);

        Bundle intent = getIntent().getExtras();

        club = (Club) intent.getSerializable("club");
        calendar = club.getDate();

        name = findViewById(R.id.name);
        coach = findViewById(R.id.coach);
        stadium = findViewById(R.id.stadium);
        date = findViewById(R.id.date);

        name.setText(club.getName());
        coach.setText(club.getCoach());
        stadium.setText(club.getStadium());
        date.setText(club.getStringDate());

        clubs = JsonHelper.importFromJSON(this);
        clubs.remove(club);

    }

    public void setDate(View v) {
        new DatePickerDialog(ClubActivity.this, d,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            club.setDate(new GregorianCalendar(year, monthOfYear, dayOfMonth));
            setDateCreate();
        }
    };

    @SuppressLint("SetTextI18n")
    public void setDateCreate() {
        date.setText(club.getStringDate());
    }

    public void save(View v){
        clubs.add(club);
        if(JsonHelper.exportToJSON(this,clubs))
            Toast.makeText(this,"Сохранено",Toast.LENGTH_SHORT);
        else
            Toast.makeText(this,"Не удалось сохранить",Toast.LENGTH_SHORT);
    }
}