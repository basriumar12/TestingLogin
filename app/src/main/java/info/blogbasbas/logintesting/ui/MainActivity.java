package info.blogbasbas.logintesting.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import info.blogbasbas.logintesting.R;
import info.blogbasbas.logintesting.db.ResponseLogin;
import info.blogbasbas.logintesting.helper.SessionManager;
import info.blogbasbas.logintesting.ui.fragment.LibraryFragment;
import info.blogbasbas.logintesting.ui.fragment.SubscriptionFragment;
import info.blogbasbas.logintesting.ui.fragment.UserFragment;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {
    SessionManager session;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.tab)
    TabLayout tab;
    ResponseLogin responseLogin;
    private Gson data = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        session = new SessionManager(getApplicationContext());

        String getData = getIntent().getStringExtra("data");
        responseLogin = data.fromJson(getData, ResponseLogin.class);

        /*
        Timber.e("hasil :"+responseLogin.getApiMessage().toString());
        Timber.e("hasil :"+responseLogin.getDataLibrary().get(0).getTitle());
        */

        tab.addTab(tab.newTab().setText(getString(R.string.usertab)));
        tab.addTab(tab.newTab().setText(getString(R.string.subscriptiontab)));
        tab.addTab(tab.newTab().setText(getString(R.string.librarytab)));


        PagerAdapter adapter = new TabAdapter(getSupportFragmentManager());
        viewpager.setAdapter(adapter);
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));
    }

    private class TabAdapter extends FragmentPagerAdapter {
        public TabAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch  (position){
                case 0 : fragment = new UserFragment(); break;
                case 1 : fragment= new SubscriptionFragment(); break;
                case 2 : fragment = new LibraryFragment(); break;



            }

            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
    //method agar tidak kemabli ke login
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("do you want to Exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        session.logout();
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }


}
