package com.example.sanket.kaalix3;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    NavigationView nv;
    DrawerLayout d;
    ActionBarDrawerToggle a;
    FloatingActionButton fab;
    MenuItem search;
    SearchView searchView;
    Button btnDelivery;
    ImageButton btnAnything, btnCourier, btnBienEtre, btnBienBio, btnChhouittoLamima, btnMarche, btnEnvieDeManger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDelivery = (Button)findViewById(R.id.btnDelivery);
        //btnAnything = (ImageButton)findViewById(R.id.btnAnything);

        /*btnCourier = (ImageButton) findViewById(R.id.btnCourier);
        btnBienEtre = (ImageButton) findViewById(R.id.btnBienEtre);
        btnBienBio = (ImageButton) findViewById(R.id.btnBienBio);

        btnChhouittoLamima = (ImageButton) findViewById(R.id.btnChhouittoLamima);
        btnMarche = (ImageButton) findViewById(R.id.btnMarche);
        btnEnvieDeManger = (ImageButton) findViewById(R.id.btnEnvieDeManger);*/


        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //center button = btnAnything
        /*btnAnything.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "btnAnything", Toast.LENGTH_SHORT).show();
                Log.i("My Button = ","btnAnything");
            }
        });*/

        /*btnCourier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "btnCourier", Toast.LENGTH_SHORT).show();
                Log.i("My Button = ","btnCourier");
            }
        });

        btnBienEtre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "btnBienEtre", Toast.LENGTH_SHORT).show();
                Log.i("My Button = ","btnBienEtre");
            }
        });

        btnBienBio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "btnBienBio", Toast.LENGTH_SHORT).show();
                Log.i("My Button = ","btnBienBio");
            }
        });

        btnChhouittoLamima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "btnChhouittoLamima", Toast.LENGTH_SHORT).show();
                Log.i("My Button = ","btnChhouittoLamima");
            }
        });

        btnMarche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "btnMarche", Toast.LENGTH_SHORT).show();
                Log.i("My Button = ","btnMarche");
            }
        });

        btnEnvieDeManger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "btnEnvieDeManger", Toast.LENGTH_SHORT).show();
                Log.i("My Button = ","btnEnvieDeManger");
            }
        });*/
        /*fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "My Action", Toast.LENGTH_SHORT).show();
                Snackbar.make(v, "My Action", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
            }
        });*/

        d = (DrawerLayout)findViewById(R.id.d);
        a = new ActionBarDrawerToggle(this, d, R.string.Open,R.string.Close);
        //a = new ActionBarDrawerToggle(this, d, "open", "close");
        a.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.nav);
        nv =(NavigationView)findViewById(R.id.nav_view);
        NavigationMenuView nmv = (NavigationMenuView)nv.getChildAt(0);
        nv.setItemTextColor(null);
        nv.setItemTextAppearance(R.style.MenuTextStyle);


        nmv.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL));

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                //menuItem.findItem(R.id.search).setVisible(false);

                switch (menuItem.getItemId())
                {
                    case R.id.home:
                        Toast.makeText(MainActivity.this, "Navigation My Home", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.basket:
                        Toast.makeText(MainActivity.this, "Navigation My Basket", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.orders:
                        Toast.makeText(MainActivity.this, "Navigation My Orders", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.account:
                        Toast.makeText(MainActivity.this, "Navigation My Account", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return true;
                }
            }
        });

        btnDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Location", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.search_menu, menu);

        search = menu.findItem(R.id.search);
        searchView  = (SearchView) MenuItemCompat.getActionView(search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(MainActivity.this, "Text change = "+newText, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(a.onOptionsItemSelected(item))
        {
            //Toast.makeText(this, "true", Toast.LENGTH_SHORT).show();
            if(d.isDrawerOpen(GravityCompat.START))
            {
                d.closeDrawer(GravityCompat.START);
            }
            else
            {
                d.openDrawer(GravityCompat.START);
            }
            return true;
        }
        switch (item.getItemId())
        {
            case R.id.home:
                Toast.makeText(MainActivity.this, "Navigation My Home", Toast.LENGTH_SHORT).show();
            case R.id.basket:
                Toast.makeText(MainActivity.this, "Navigation My Basket", Toast.LENGTH_SHORT).show();
            case R.id.orders:
                Toast.makeText(MainActivity.this, "Navigation My Orders", Toast.LENGTH_SHORT).show();
            case R.id.account:
                Toast.makeText(MainActivity.this, "Navigation My Account", Toast.LENGTH_SHORT).show();
            default:
                return true;
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        d.closeDrawer(GravityCompat.START);
    }
}
