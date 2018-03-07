package sravya.example.com.project1;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SearchViewCompat;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.SearchEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, SearchViewCompat.OnQueryTextListener, android.widget.SearchView.OnQueryTextListener {
    List<Hero> herolist;
    ListView listView;
    DrawerLayout drawerLayout;
    Button button,button1,button2;
    android.support.v4.app.Fragment fragment=null,fragment1=null,fragment2=null,fragment3=null;
    Intent SearchIntent,LoginIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView= navigationView.getHeaderView(0);
        navigationView.setNavigationItemSelectedListener(this);
        herolist=new ArrayList<>();

       /* herolist.add(new Hero(R.drawable.ic_menu_send));
        herolist.add(new Hero(R.drawable.ic_menu_manage));
        herolist.add(new Hero(R.drawable.ic_menu_camera))
        */
        herolist.add(new Hero(R.drawable.ic_menu_gallery));
        herolist.add(new Hero(R.drawable.ic_menu_camera));
        herolist.add(new Hero((R.drawable.ic_menu_gallery)));
        herolist.add(new Hero(R.drawable.books));
        herolist.add(new Hero(R.drawable.electronics));
        herolist.add(new Hero(R.drawable.civil));
        herolist.add(new Hero(R.drawable.software));
        herolist.add(new Hero(R.drawable.mechanical));
        listView=(ListView)findViewById(R.id.listView);
        MyCustomListAdapter adapter=new MyCustomListAdapter(this,R.layout.my_list,herolist);
        listView.setAdapter(adapter);
        button= (Button) findViewById(R.id.search_button);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                openactivity2();

            }

        });
        //final LayoutInflater factory = getLayoutInflater();

        //final View textEntryView = factory.inflate(R.layout.nav_header_main, null);

        button1 = (Button) headerView.findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Toast.makeText(curr_context, "SHOW", Toast.LENGTH_LONG).show();
                // openactivity();
                fragment2=new RegistrationpageFragment();
                if(fragment2!=null)
                {
                    FragmentManager fragmentManager=getSupportFragmentManager();
                    FragmentTransaction ft3=fragmentManager.beginTransaction();
                    ft3.replace(R.id.drawer_layout,fragment2);
                    ft3.commit();
                }

            }
        });

        button2=(Button)headerView.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                // Toast.makeText(curr_context, "SHOW", Toast.LENGTH_LONG).show();
                // openactivity();
                fragment3=new LoginFragment();
                if(fragment3!=null)
                {
                    FragmentManager fragmentManager=getSupportFragmentManager();
                    FragmentTransaction ft4=fragmentManager.beginTransaction();
                    ft4.replace(R.id.drawer_layout,fragment3);
                    ft4.commit();
                }


            }

        });

        // navigationView.setNavigationItemSelectedListener(this);

    }
    /*private void listen()
    {
        search_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(SearchIntent);
            }
        });
    }
    private void init()
    {
        SearchIntent=new Intent(this,SearchResultsActivity.class);
    }*/
    public void openactivity2(){

        SearchIntent= new Intent(this,SearchResultsActivity.class);

        startActivity(SearchIntent);

    }


    /*
      @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

        }
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        /*SearchView searchView = (SearchView) menu.findItem(R.id.searchid).getActionView();
        searchView.setOnQueryTextListener((SearchView.OnQueryTextListener) this);
*/
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            fragment1=new HomeFragment();
            if(fragment1!=null)
            {
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction ft1=fragmentManager.beginTransaction();
                ft1.replace(R.id.content_frame,fragment1);
                ft1.commit();
            }
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

            fragment = new ProductFragment();
            if (fragment != null) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.content_frame, fragment);
                ft.commit();
            }
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
      /*  if(query!=null) {
            Toast.makeText(this, "you searchitem" + query, Toast.LENGTH_SHORT).show();
return true;
        }*/
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
