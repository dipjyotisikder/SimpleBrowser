package com.example.dipjyoti.browser;

import android.content.Context;
import android.content.Intent;
import android.support.v4.database.DatabaseUtilsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import static android.R.attr.data;
import static android.R.attr.thickness;

public class BookMarkListView extends AppCompatActivity {

    Button backBtn;
    ListView listViewItem;
     String[] data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_mark_list_view);

        listViewItem=  (ListView) findViewById(R.id.listViewItem);
        backBtn = (Button) findViewById(R.id.backBtnBookmark);

        DatabaseHelperBackup databaseObject = new DatabaseHelperBackup(getApplicationContext());

        data= databaseObject.my_data();

        listViewItem.setAdapter(new ArrayAdapter(getApplicationContext(), R.layout.list_text_view, R.id.listText, data));




        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BookMarkListView.this, BrowserActivityHomePage.class);
                startActivity(i);
            }
        });
//        MyDBFunctions mf = new MyDBFunctions(getApplicationContext());
//
//        data = mf.my_data();
//
//        lv.setAdapter(new ArrayAdapter(getApplicationContext(), R.layout.lview, R.id.mytext, data));
//
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent i = new Intent(getApplicationContext(), SingleBDay.class);
//                i.putExtra("MyKEY", position);
//                startActivity(i);
//            }
//        });



    }
}
