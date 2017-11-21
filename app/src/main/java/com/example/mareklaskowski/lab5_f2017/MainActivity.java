package com.example.mareklaskowski.lab5_f2017;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    //declare an array to store references to the icons in the res folder
    //notice that their type is int
    //also note that we are storing them in a particular order that will match their descriptions
    public static int[] icons = {R.drawable.facebook, R.drawable.google, R.drawable.instagram};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //as directed, the descriptions of each site should come from an xml string-array resource
        //get a reference to the string array
        String[] descriptions = getResources().getStringArray(R.array.description_array);
        //get a reference to our ListView
        ListView listView = (ListView) findViewById(R.id.listView);
        //in order to set up our listView to work properly, we also need to provide a custom
        //ArrayAdaptor that will use a custom ListItem layout
        //instantiate our MyCustomListAdaptor class
        MyCustomAdaptor myCustomAdaptor = new MyCustomAdaptor(this, descriptions, icons );
        //connect the ListView with MyCustomAdaptor
        listView.setAdapter(myCustomAdaptor);

    }
}
