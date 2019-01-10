package com.example.aamersohail.listthings;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    ListView listView;

    //Assign names
    String[] names = {"Cheetah", "Deer", "Eagle", "Elephant", "Fox", "Leopard", "Lion", "Rhino", "Tiger", "Zebra"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing list view with the custom adapter
        ArrayList<Item> itemList = new ArrayList<Item>();
        ItemArrayAdapter itemArrayAdapter = new ItemArrayAdapter(this, R.layout.list_item, itemList);
        listView = (ListView) findViewById(R.id.item_list);
        listView.setAdapter(itemArrayAdapter);

        // Initialize the image


        // Populating list items
        for (int i = 0; i < 10; i++) {
            itemList.add(new Item("Item " + i));
            //itemList.add(new Item())
        }

        // Set up list item onclick listener
        setUpListItemClickListener();
    }

    private void setUpListItemClickListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), "item " + position + " clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}