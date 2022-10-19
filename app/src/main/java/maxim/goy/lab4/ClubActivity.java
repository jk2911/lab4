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
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);

        calendar = new GregorianCalendar();

        name = findViewById(R.id.name);
        coach = findViewById(R.id.coach);
        stadium = findViewById(R.id.stadium);
        date = findViewById(R.id.date);

        clubs = JsonHelper.importFromJSON(this);

        if (clubs == null)
            clubs = new ArrayList<>();

        setDateCreate();

    }

    public void setDate(View v) {
        new DatePickerDialog(ClubActivity.this, d,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, monthOfYear);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setDateCreate();
        }
    };

    @SuppressLint("SetTextI18n")
    public void setDateCreate() {
        date.setText(getStringCalendar());
    }

    public void save(View v) {

        List<String> tournaments = new ArrayList<>();
        Club club = new Club(name.getText().toString(),
                calendar,
                coach.getText().toString(),
                stadium.getText().toString(),
                tournaments);

        if (clubs.contains(club)) {
            Toast.makeText(this, "Такой клуб уже есть", Toast.LENGTH_LONG).show();
            return;
        }

        clubs.add(club);
        if (JsonHelper.exportToJSON(this, clubs))
            Toast.makeText(this, "Сохранено", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Не удалось сохранить", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public String getStringCalendar() {
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);
        return (day < 10 ? "0" + day : day) + "." +
                (month < 10 ? "0" + month : month) + "." +
                year;
    }
}