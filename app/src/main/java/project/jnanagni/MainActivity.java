package project.jnanagni;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String title = "Home";
    long lastPress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Set a Toolbar to replace the ActionBar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Create Drawer Layout
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        //Setup Drawer View
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        if (savedInstanceState == null) {
            navigationView.setCheckedItem(R.id.nav_second_fragment);
            setFragment(new Home(), title);
        } else {
            title = savedInstanceState.getString("title");
            setTitle(title);
        }

        //On Header Icon Touch
        View headerView = navigationView.getHeaderView(0);
        ImageView headerImage = (ImageView) headerView.findViewById(R.id.header_image);
        headerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.closeDrawer(GravityCompat.START);
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("title", title);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
                long currentTime = System.currentTimeMillis();
                if (currentTime - lastPress > 3000) {
                    Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_LONG).show();
                    lastPress = currentTime;
                } else {
                    super.onBackPressed();
                }
            }
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        title = item.getTitle().toString();
        if (id == R.id.nav_first_fragment) {
            setFragment(new PreRegister(), title);
        } else if (id == R.id.nav_second_fragment) {
            setFragment(new Home(), title);
        } else if (id == R.id.nav_third_fragment) {
            setFragment(new Events(), title);
        } else if (id == R.id.nav_fourth_fragment) {
            setFragment(new Location(), title);
        } else if (id == R.id.nav_fifth_fragment) {
            setFragment(new Spread(), title);
        } else if (id == R.id.nav_sixth_fragment) {
            setFragment(new Feedback(), title);
        } else if (id == R.id.nav_seventh_fragment) {
            setFragment(new ContactUs(), title);
        }
        // Highlight the selected item has been done by NavigationView
        item.setChecked(true);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setFragment(final Fragment fragment, final String title) {
        //Set Title
        setTitle(title);
        //Set Fragment
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_main, fragment)
                .commit();
    }
}
