package com.satyam.newswala;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;


public class MainActivity extends AppCompatActivity
{
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    BottomNavigationView chipNavigationBar;
    Toolbar toolbar;
    int query=1;
    LinearLayout linearLayout;

    Button button1,button2,button3,button4,button5,button6;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.linear);
        button1 = findViewById(R.id.sports);
        button2 = findViewById(R.id.economics);
        button3 = findViewById(R.id.tech);
        button4 = findViewById(R.id.politics);
        button5 = findViewById(R.id.entertainment);
        button6 = findViewById(R.id.science);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        chipNavigationBar = findViewById(R.id.nav);
        setFragment(new India());


        chipNavigationBar.setSelectedItemId(R.id.item1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,CategoryNews.class);
                startActivity(i);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,CategoryNewsEco.class);
                startActivity(i);

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,CategoryNewsTech.class);
                startActivity(i);

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,CategoryNewsPol.class);
                startActivity(i);

            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,CategoryNewsEnter.class);
                startActivity(i);

            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,CategoryNewsSci.class);
                startActivity(i);

            }
        });



        chipNavigationBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()) {
                    case R.id.item1:
                        toolbar.setVisibility(View.VISIBLE);
                        linearLayout.setVisibility(View.VISIBLE);
                        setFragment(new India());
                        setTitle("India");


                        break;

                    case R.id.item2:
                        toolbar.setVisibility(View.VISIBLE);
                        linearLayout.setVisibility(View.VISIBLE);

                        setFragment(new World());


                        break;
                    case R.id.item4:
                        toolbar.setVisibility(View.VISIBLE);
                        linearLayout.setVisibility(View.VISIBLE);

                        setFragment(new Hot());


                        break;
                    case R.id.item5:
                        linearLayout.setVisibility(View.GONE);

                        setFragment(new Account());

                        break;
                }
                return true;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {


        getMenuInflater().inflate(R.menu.searched_item,menu);

        MenuItem menuItem = menu.findItem(R.id.search_bar);
        final SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Search");

        //searchView.onActionViewCollapsed();
        searchView.setBackgroundColor(Color.BLACK);

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

         searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                Bundle bundle = new Bundle();
                if(!query.isEmpty())
                {
                    bundle.putString("Search", query);
                    Searched searched = new Searched();
                    searched.setArguments(bundle);
                    setFragment(searched);


                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {


                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    public void setFragment(Fragment fragment) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.setFragment, fragment);
        fragmentTransaction.addToBackStack("");
        fragmentTransaction.commit();
    }
    /*
    @Override
    public void onBackPressed() {
        if(getTitle()=="India") {
            finish();
        }
        super.onBackPressed();
    }

     */
    @Override
    public void onBackPressed() {


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.nav);
        int seletedItemId = bottomNavigationView.getSelectedItemId();
        if (R.id.item1 != seletedItemId ) {
             setHomeItem(MainActivity.this);
        }
        else if (getTitle()=="Searched"){
            setHomeItem(MainActivity.this);
        }
            else {
             finish();

        }
    }

    public static void setHomeItem(Activity activity) {
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                activity.findViewById(R.id.nav);
        bottomNavigationView.setSelectedItemId(R.id.item1);
    }

}
