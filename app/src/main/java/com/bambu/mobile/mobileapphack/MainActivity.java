package com.bambu.mobile.mobileapphack;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.gimbal.android.CommunicationManager;
import com.gimbal.android.Gimbal;
import com.gimbal.android.PlaceEventListener;
import com.gimbal.android.PlaceManager;
import com.gimbal.android.Visit;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private PlaceManager placeManager;
    private PlaceEventListener placeEventListener;
    private ArrayAdapter<String> listAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Beavent");

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(listAdapter);

        listAdapter.add("Campus Party");
        listAdapter.notifyDataSetChanged();
        Gimbal.setApiKey(this.getApplication(), "2ffe0930-c0a0-42f3-b073-c11c53fc19bb");
        listView.setOnItemClickListener(this);


        placeEventListener = new PlaceEventListener() {
            @Override
            public void onVisitStart(Visit visit) {
                log(visit.toString());
//                listAdapter.add(String.format("Start Visit for %s", visit.getPlace().getName()));
                log(visit.getPlace().getName());
                log(visit.getArrivalTimeInMillis() + "");
                Date date = new Date(visit.getArrivalTimeInMillis());
                DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                String dateFormatted = formatter.format(date);
                log("Time enter: " + dateFormatted);
//                listAdapter.notifyDataSetChanged();
                Intent intent = new Intent(MainActivity.this, IntinerarioActivity.class);
                intent.putExtra("timeLlegada", dateFormatted);
                intent.putExtra("flag", 1);
                startActivity(intent);
                overridePendingTransition(R.anim.slider_in_right, R.anim.slide_out_left);
            }

            @Override
            public void onVisitEnd(Visit visit) {
                log(visit.toString());
//                log(visit.getDepartureTimeInMillis() + "");

                Date date = new Date(visit.getDepartureTimeInMillis());
                DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                String dateFormatted = formatter.format(date);
                log("Time exit: " + dateFormatted);
//                Snackbar.make(fab, "Salio del evento a las " + dateFormatted, Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

                Intent intent = new Intent(MainActivity.this, IntinerarioActivity.class);
                intent.putExtra("timeLlegada", dateFormatted);
                intent.putExtra("flag", 2);
                startActivity(intent);
                overridePendingTransition(R.anim.slider_in_right, R.anim.slide_out_left);
//                listAdapter.add(String.format("End Visit for %s", visit.getPlace().getName()));
//                listAdapter.notifyDataSetChanged();
            }
        };


        placeManager = PlaceManager.getInstance();
        placeManager.addListener(placeEventListener);
        placeManager.startMonitoring();

        CommunicationManager.getInstance().startReceivingCommunications();

    }

    public void log(String content) {
        Log.i("myLog", content);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startActivity(new Intent(MainActivity.this, EventsActivity.class));
        overridePendingTransition(R.anim.slider_in_right, R.anim.slide_out_left);
    }
}
