package com.example.ecampus.activities;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ecampus.R;
import com.example.ecampus.models.Blog;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import es.dmoral.toasty.Toasty;

public class NewsfeedActivity extends AppCompatActivity {

    CircularImageView profile;
    private FirebaseFirestore db;
    String thisYear, thisMonth;
    int weekNo;
    List<Blog> latestList, yesterdayList, lastWeekList, olderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsfeed);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);


        thisYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
        thisMonth = DateFormat.format("MM", new Date()).toString();
        weekNo = Calendar.getInstance().get(Calendar.WEEK_OF_MONTH);
        Log.i("YEAR FULL", thisYear + ' ' + thisMonth);


        profile = findViewById(R.id.userpic);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("YEAR FULL", thisYear + "  " + thisMonth);

                //Toast.makeText(getApplicationContext(), "Profile", Toast.LENGTH_SHORT).show();


                // Access a Cloud Firestore instance from your Activity
                db = FirebaseFirestore.getInstance();


                db.collection("news").document(thisYear)
                        .collection(thisMonth).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()) {
                            if (task.getResult().size() > 0) {
                                for (int i = 0; i < task.getResult().size(); i++) {
                                    Map<String, Object> news = task.getResult().getDocuments().get(i).getData();
                                    Log.i("New Record", task.getResult().getDocuments().get(i).getData().toString());
                                    Blog blog = new Blog(
                                            news.get("image").toString(),
                                            news.get("title").toString(),
                                            news.get("desc").toString(),
                                            news.get("date").toString());
                                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                                    Long newsDate = new Date(news.get("date").toString()).getTime();
                                    Long todaysDate = new Date().getTime();
                                    Long diff = todaysDate - newsDate;
                                    int daysDiff = (int) (diff / (1000 * 60 * 60 * 24));
                                    Log.i("DAYs DIFF", String.valueOf(daysDiff));
                                    if (daysDiff == 0) {
                                        Log.i("TODAY", "It's today");
                                        latestList.add(blog);
                                    } else if (daysDiff == 1) {
                                        Log.i("YESTERDAY", "It was yesterday");
                                        yesterdayList.add(blog);
                                    } else if (daysDiff > 1 && daysDiff <= 7) {
                                        Log.i("LAST WEEK", "It was last week");
                                        lastWeekList.add(blog);
                                    } else {
                                        Log.i("OLDER", "It's too old");
                                        olderList.add(blog);
                                    }
                                }
                            }
                            Toasty.success(getApplicationContext(), latestList.size());
                        }

                    }
                });
            }
        });
        // Log.i("YEAR",DateFormat.format("yyyy", new Date()).toString());


    }
}