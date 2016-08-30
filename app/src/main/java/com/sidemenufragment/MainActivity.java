package com.sidemenufragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.sidemenufragment.adapter.SideMenuAdapter;
import com.sidemenufragment.fragment.FragmentA;
import com.sidemenufragment.fragment.FragmentB;
import com.sidemenufragment.fragment.FragmentC;
import com.sidemenufragment.model.ItemSideMenu;

import java.util.ArrayList;
import java.util.List;

import constant.Constant;

public class MainActivity extends AppCompatActivity {

    private List<ItemSideMenu> listSliding;
    private SideMenuAdapter adapter;
    private ListView listViewSliding;
    private DrawerLayout drawerLayout;
//    private RelativeLayout mainContent;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Init Component
        listViewSliding = (ListView) findViewById(R.id.lv_sidemenu);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        mainContent = (RelativeLayout) findViewById(R.id.main_content);
        listSliding = new ArrayList<>();
//        Add item for Sliding List
        listSliding.add(new ItemSideMenu(R.drawable.ic_settings_black_24dp, Constant.settings));
        listSliding.add(new ItemSideMenu(R.drawable.ic_info_outline_black_24dp, Constant.about));
        listSliding.add(new ItemSideMenu(R.mipmap.ic_launcher, Constant.android));
        adapter = new SideMenuAdapter(this, listSliding);
        listViewSliding.setAdapter(adapter);

//        Display icon to Open/Close Sliding list
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


//        Set title
        setTitle(listSliding.get(0).getTitle());
//        item Selected
        listViewSliding.setItemChecked(0, true);
//        close Menu
        drawerLayout.closeDrawer(listViewSliding);
//        Display FragmentA when start
        replaceFragment(0);
//        Handle on item Click

        listViewSliding.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//        Set title
                setTitle(listSliding.get(i).getTitle());
//        item Selected
                listViewSliding.setItemChecked(i, true);
//                replace Fragment
                replaceFragment(i);
//        close Menu
                drawerLayout.closeDrawer(listViewSliding);
            }
        });

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_opened, R.string.drawer_closed) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }
        };
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    //    create method replace fragment
    public void replaceFragment(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = new FragmentA();
                break;
            case 1:
                fragment = new FragmentB();
                break;
            case 2:
                fragment = new FragmentC();
                break;
            default:
                fragment = new FragmentA();
                break;
        }
        if (fragment != null) {
            FragmentManager manager = getFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.main_content, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}
