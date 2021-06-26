package com.example.personalassistant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mNavDrawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_drawer_layout);


        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,new dashbordFragment()).commit();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mNavDrawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView=findViewById(R.id.navigation_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,mNavDrawer,
                toolbar,R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        mNavDrawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

    }
    public void onBackPressed() {
        if (mNavDrawer.isDrawerOpen(GravityCompat.START)) {
            mNavDrawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){

            case R.id.nav_dashbord:
                //fragment dashbord
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,new dashbordFragment()).commit();
                                break;
            case R.id.nav_expense:
                //
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,new ExpenseFragment()).addToBackStack("Expenses").commit();
                break;
            case R.id.nav_incom:
                //
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,new IncomFragment()).addToBackStack("Income").commit();
                break;
            case R.id.nav_balance:
                //
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,new BalanceFragment()).addToBackStack("Balance").commit();
                break;



                //
            case R.id.nav_list:
                //
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,new ListFragment()).commit();
                break;

        //
        }
        mNavDrawer.closeDrawer(GravityCompat.START);
        return true;
    }
}