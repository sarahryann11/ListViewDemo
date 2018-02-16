package csci490.listviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.class_schedule);

        ArrayList<Course> courses = populateData();

        //String[] classes = {"CSCI 340", "CSCI 360", "CSCI 320", "DANC 150", "DATA 101"};

        //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, classes);
        //listView.setAdapter(adapter);

        CourseAdapter adapter = new CourseAdapter(this, courses);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Short click", Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Loooooooooooooong click", Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }

    public ArrayList<Course> populateData(){
        Course course;
        ArrayList<Course> courses = new ArrayList<>();

        course = new Course();
        course.setCourseName("Database Concepts");
        course.setCourseNumber("332");
        course.setProfessor("Dr. Olmsted");
        courses.add(course);

        course = new Course();
        course.setCourseName("Capstone");
        course.setCourseNumber("462");
        course.setProfessor("Dr. Anderson");
        courses.add(course);

        return courses;
    }

}
