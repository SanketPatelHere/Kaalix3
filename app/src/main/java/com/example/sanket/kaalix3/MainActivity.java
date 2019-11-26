package com.example.sanket.kaalix3;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.navigation.NavigationView;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;
import com.szugyi.circlemenu.view.CircleImageView;
import com.szugyi.circlemenu.view.CircleLayout;

public class MainActivity extends AppCompatActivity {
    NavigationView nv;
    DrawerLayout d;
    ActionBarDrawerToggle a;
    FloatingActionButton fab;
    MenuItem search;
    SearchView searchView;
    Button btnDelivery;
    ImageButton btnAnything, btnCourier, btnBienEtre, btnBienBio, btnChhouittoLamima, btnMarche, btnEnvieDeManger;
    CircleLayout circle_layout;
    FloatingActionMenu actionMenu, actionMenu2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDelivery = (Button)findViewById(R.id.btnDelivery);
        circle_layout = (CircleLayout)findViewById(R.id.circle_layout);
        circle_layout.setOnItemSelectedListener(new CircleLayout.OnItemSelectedListener() {
            @Override
            public void onItemSelected(View view) {
                actionMenu.close(true);
                Toast.makeText(MainActivity.this, "Selected = Menu", Toast.LENGTH_SHORT).show();
            }
        });


        ///////for subactionbutton = fab button ///////////
        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);
        final ImageView itemIcon1 = new ImageView(this);
        final ImageView itemIcon2 = new ImageView(this);
        final ImageView itemIcon3 = new ImageView(this);

        itemIcon1.setImageDrawable(getResources().getDrawable(R.drawable.bein_etre));
        itemIcon2.setImageDrawable(getResources().getDrawable(R.drawable.bien_bio));
        itemIcon3.setImageDrawable(getResources().getDrawable(R.drawable.chhouitte));

        //itemIcon1.getLayoutParams().width = 150;
        //itemIcon1.getLayoutParams().height = 150;
        SubActionButton button1 = itemBuilder.setContentView(itemIcon1).build();
        SubActionButton button2 = itemBuilder.setContentView(itemIcon2).build();
        SubActionButton button3 = itemBuilder.setContentView(itemIcon3).build();
        AppBarLayout.LayoutParams params=new AppBarLayout.LayoutParams(150,150);
        button1.setLayoutParams(params);
        button2.setLayoutParams(params);
        button3.setLayoutParams(params);

        FrameLayout btn1 = (FrameLayout)findViewById(R.id.speaker_avatar_container1);
        CircleImageView btn2 = (CircleImageView)findViewById(R.id.btnBienBio);
        ///
        actionMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(button1)
                .addSubActionView(button2)
                .addSubActionView(button3)
                .setRadius(180)
                .setStartAngle(0)
                .setEndAngle(180)



                .attachTo(btn1)
                .build();
        /*actionMenu2 = new FloatingActionMenu.Builder(this)
                .addSubActionView(button1)
                .addSubActionView(button2)
                .addSubActionView(button3)
                .setRadius(150)
                .setStartAngle(0)
                .setEndAngle(180)
                .attachTo(btn2)
                .build();*/


        actionMenu.setStateChangeListener(new FloatingActionMenu.MenuStateChangeListener() {
            @Override
            public void onMenuOpened(FloatingActionMenu floatingActionMenu) {
               /*itemIcon1.setRotation(0);
                PropertyValuesHolder pvhR1 = PropertyValuesHolder.ofFloat(View.ROTATION, 45);
                ObjectAnimator animation1 = ObjectAnimator.ofPropertyValuesHolder(itemIcon1, pvhR1);
                animation1.start();

                itemIcon2.setRotation(0);
                PropertyValuesHolder pvhR2 = PropertyValuesHolder.ofFloat(View.ROTATION, 45);
                ObjectAnimator animation2 = ObjectAnimator.ofPropertyValuesHolder(itemIcon2, pvhR2);
                animation2.start();

                itemIcon3.setRotation(0);
                PropertyValuesHolder pvhR3 = PropertyValuesHolder.ofFloat(View.ROTATION, 45);
                ObjectAnimator animation3 = ObjectAnimator.ofPropertyValuesHolder(itemIcon3, pvhR3);
                animation3.start();*/

            }

            @Override
            public void onMenuClosed(FloatingActionMenu floatingActionMenu) {
                /*itemIcon1.setRotation(45);
                PropertyValuesHolder pvhR1 = PropertyValuesHolder.ofFloat(View.ROTATION, 0);
                ObjectAnimator animation1 = ObjectAnimator.ofPropertyValuesHolder(itemIcon1, pvhR1);
                animation1.start();

                itemIcon2.setRotation(45);
                PropertyValuesHolder pvhR2 = PropertyValuesHolder.ofFloat(View.ROTATION, 0);
                ObjectAnimator animation2 = ObjectAnimator.ofPropertyValuesHolder(itemIcon2, pvhR2);
                animation2.start();

                itemIcon3.setRotation(45);
                PropertyValuesHolder pvhR3 = PropertyValuesHolder.ofFloat(View.ROTATION, 0);
                ObjectAnimator animation3 = ObjectAnimator.ofPropertyValuesHolder(itemIcon3, pvhR3);
                animation3.start();*/
            }

        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //serviceWillBeDismissed = true; // the order is important
                actionMenu.close(true);
                Toast.makeText(MainActivity.this, "button1", Toast.LENGTH_SHORT).show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //serviceWillBeDismissed = true; // the order is important
                actionMenu.close(true);
                Toast.makeText(MainActivity.this, "button2", Toast.LENGTH_SHORT).show();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //serviceWillBeDismissed = true; // the order is important
                actionMenu.close(true);
                Toast.makeText(MainActivity.this, "button3", Toast.LENGTH_SHORT).show();
            }
        });

        ///////////////////////////////////////////////////

        /*circle_layout.setOnItemClickListener(new CircleLayout.OnItemClickListener() {
            @Override
            public void onItemClick(View view) {
                Toast.makeText(MainActivity.this, "Clicked = ", Toast.LENGTH_SHORT).show();
            }
        });*/
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
