package miguellopez.olavilaboaapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;


import miguellopez.olavilaboaapp.databinding.ActivityNavDrawerBinding;
import miguellopez.olavilaboaapp.fragments.CultureFragment;
import miguellopez.olavilaboaapp.fragments.InicioFragment;
import miguellopez.olavilaboaapp.fragments.NewsFragment;
import miguellopez.olavilaboaapp.ui.eat.EatFragment;
import miguellopez.olavilaboaapp.ui.sleep.SleepFragment;
import miguellopez.olavilaboaapp.ui.tourism.TourismFragment;

public class NavDrawerActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityNavDrawerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNavDrawerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        setSupportActionBar(binding.appBarNavDrawer.toolbar);
        binding.appBarNavDrawer.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Sen acción disponible", Snackbar.LENGTH_LONG)
                        .setAction("Acción", null).show();
            }
        });

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        navigationView.setItemIconTintList(null);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                 R.id.nav_eat, R.id.nav_sleep, R.id.nav_culture, R.id.nav_tourism,R.id.nav_news, R.id.nav_inicio, R.id.nav_about
        )
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_nav_drawer);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_drawer, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_nav_drawer);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    public boolean onNavigationItemSelected(MenuItem item){

        int id = item.getItemId();
        Fragment miFragment = null;
        boolean fragmentSelect = false;


        if(id == R.id.nav_inicio) {
            miFragment = new InicioFragment();
            fragmentSelect = true;
        }
        else if(id == R.id.nav_culture) {
            miFragment = new CultureFragment();
            fragmentSelect = true;
        }
        else if(id == R.id.nav_tourism){
            miFragment = new TourismFragment();
            fragmentSelect = true;}

        else if(id == R.id.nav_news) {
            miFragment = new NewsFragment();
            fragmentSelect = true;

        }else if(id == R.id.nav_eat) {
            miFragment = new EatFragment();
            fragmentSelect = true;
        }else if(id == R.id.nav_sleep) {
            miFragment = new SleepFragment();
            fragmentSelect = true;
        }else if(id == R.id.nav_about) {
           fragmentSelect = false;
        }
        if(fragmentSelect){
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_nav_drawer, miFragment).commit();
        }
        else{
           finish();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }
}