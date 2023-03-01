package com.appybuilder.alioffical.insurancebazar.Activitise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.appybuilder.alioffical.insurancebazar.Activitise.Adapters.fragmentAdapter;
import com.appybuilder.alioffical.insurancebazar.Activitise.Fragments.HomeFragment;
import com.appybuilder.alioffical.insurancebazar.Activitise.Fragments.PolicyFragment;
import com.appybuilder.alioffical.insurancebazar.Activitise.Fragments.ProductFragment;
import com.appybuilder.alioffical.insurancebazar.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ViewPager viewPager;
    MenuItem menuItem;
    NavigationMenu navigationMenu;
    BottomNavigationView bottomNavigationMenuView;
    com.appybuilder.alioffical.insurancebazar.Activitise.Adapters.fragmentAdapter fragmentAdapter;
    TextView textView;
    ImageView btnAddPost;
    Fragment homeFrag,productsfrag,policyfrag;
    private DrawerLayout mdDrawerLayout;
    private ActionBarDrawerToggle mToogle;
    NavigationView navigationView;
    View header;
    TextView txt_email;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseUser=firebaseAuth.getCurrentUser();
        header=findViewById(R.id.headerNaveUser);
        mdDrawerLayout=findViewById(R.id.drawerlayout);
        mToogle=new ActionBarDrawerToggle(this,mdDrawerLayout,R.string.open,R.string.close);
        mdDrawerLayout.addDrawerListener(mToogle);
        mToogle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView=findViewById(R.id.nav_view);
        header = navigationView.getHeaderView(0);
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);
        viewPager=findViewById(R.id.viewpagermain);
        bottomNavigationMenuView=findViewById(R.id.navigation);
        txt_email=header.findViewById(R.id.email_text);
        txt_email.setText(firebaseAuth.getCurrentUser().getEmail());
        bottomNavigationMenuView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                        if (menuItem.getItemId()==R.id.navigation_newsfeed){
                            viewPager.setCurrentItem(0);
                        }
                        else if(menuItem.getItemId()==R.id.navigation_cmsportal){
                            viewPager.setCurrentItem(1);
                        }
                        else if(menuItem.getItemId()==R.id.navigation_timetable){
                            viewPager.setCurrentItem(2);
                        }
                        return false;
                    }

                });
        //VIEW PAGER IS GIVEN BELOW
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int POSITION, float POSTIONOFFSET, int POSSITIONPixel) {
                if (POSITION==0){
                  //  viewPager.setCurrentItem(0);
                  //  textView.setText("NEWS FEED");

//
//                       Toast.makeText(getApplicationContext(),"SELECT",Toast.LENGTH_LONG).show();
                }
                else if(POSITION==1){
                    // viewPager.setCurrentItem(0);
                   // textView.setText("ARID PORTAL");
//                       Toast.makeText(getApplicationContext(),"SELECT",Toast.LENGTH_LONG).show();
                }
                else if(POSITION==2){
                    // viewPager.setCurrentItem(0);
                 //   textView.setText("TIME TABLE");
//                       Toast.makeText(getApplicationContext(),"SELECT",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onPageSelected(int i) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                }
                else
                {

                    bottomNavigationMenuView.getMenu().getItem(0).setChecked(false);
                    //  textView.setBackgroundColor(getResources().getColor(R.color.blue));
                }
                Log.d("page", "onPageSelected: "+i);
                bottomNavigationMenuView.getMenu().getItem(i).setChecked(true);
                menuItem = bottomNavigationMenuView.getMenu().getItem(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        setupViewPager(viewPager);

        //Setting the actionbarToggle to drawer layout
    }

    private void setupViewPager(ViewPager viewPager) {
        fragmentAdapter = new fragmentAdapter(getSupportFragmentManager());
        homeFrag= new HomeFragment();
        productsfrag=new ProductFragment();
        policyfrag=new PolicyFragment();
        fragmentAdapter.addFragment(homeFrag);
        fragmentAdapter.addFragment(productsfrag);
        fragmentAdapter.addFragment(policyfrag);
        viewPager.setAdapter(fragmentAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToogle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.logout){
            logout_userfun();
        }if(item.getItemId()==R.id.history){
            startActivity(new Intent(HomeActivity.this,HistoryActivity.class));
        }
        return false;
    }
    public void logout_userfun(){
        Toast.makeText(getApplicationContext(),"Logout",Toast.LENGTH_SHORT).show();
        firebaseAuth.signOut();
        finish();
    }

}