package com.example.mareklaskowski.lab5_f2017;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * this class is a custom adaptor to work with our custom list items and data
 */

public class MyCustomAdaptor extends BaseAdapter {
    //instance variables to store essential data
    String[] descriptions;
    int[] icons;
    Context context;//also need the android context here

    //a constructor to set up our instance variables
    public MyCustomAdaptor(MainActivity c, String[] d, int[] i){
        context = c;
        icons = i;
        descriptions = d;
    }

    /*
    getCount is called by the framework when it needs to know how many list items there are in the list!
     */
    @Override
    public int getCount() {
        return descriptions.length;
    }

    /*
    This method is required by the framework, however we don't need it for anything, so we leave a stub implementation
     */
    @Override
    public Object getItem(int position) {
        return null;//TODO: implement a data structure or other mechanism to return data *if needed*
    }

    /*
    this method is supposed to get the id of an item at position
    not needed so leaving the stub implementation
     */
    @Override
    public long getItemId(int position) {
        return 0; //TODO: implement if needed!
    }

    /*
    the android framework will call getView every time it needs to draw your custom list item
    the int position inidcates which row of your listView the framework is trying to render
     */
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //create a new View
        View row = null;// a reference that will refer to the current row being rendered
        /*
        we're going to use the LayoutInflater class to instantiate a Java object from the xml layout
        first we need to get an instance of LayoutInflater through the getSystemService method
        recall that context is our reference to MainActivity which is itself an Android Context
         */
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //use the LayoutInflater instance to instantiate a new View of the "correct type"
        row = inflater.inflate(R.layout.custom_list, null); //the second argumetn is the root view (in this case none)
        //we need to set up the child views that will go into our custom_list layout
        //get a reference to the TextView and set its text
        TextView textView = (TextView) row.findViewById(R.id.textView);
        textView.setText(descriptions[position]);
        //also set the image for the image view
        ImageView imageView = (ImageView) row.findViewById(R.id.imageView);
        imageView.setImageResource(icons[position]);

        //respond to clicks on our listitems
        row.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //TODO: you will broadcast an Intent with a URI to open up the appropriate website...
                //note that URIS will be stored in strings.xml
                Toast.makeText(context, descriptions[position], Toast.LENGTH_LONG).show();
            }
        });
        return row;
    }
}
