package com.android.sergio.taskmanager;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    PreferencesHelper preferencesHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PreferencesHelper.getInstance().init(getApplicationContext());
        preferencesHelper = PreferencesHelper.getInstance();

        fragmentManager = getFragmentManager();

        runSplash();
    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem splashItem = (MenuItem) findViewById(R.id.action_splash);
        splashItem.setChecked(preferencesHelper.getBoolean(PreferencesHelper.SPLASH_IS_INVISIBLE));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_splash){
            item.setChecked(!item.isChecked());
            preferencesHelper.putBoolean(PreferencesHelper.SPLASH_IS_INVISIBLE, item.isChecked());
        }
        return super.onOptionsItemSelected(item);
    }

    public void runSplash(){

        if (! preferencesHelper.getBoolean(PreferencesHelper.SPLASH_IS_INVISIBLE)){

            SplashFragment splashFragment = new SplashFragment();


            fragmentManager.beginTransaction()
                    .replace(R.id.container, splashFragment)
                    .addToBackStack(null)
                    .commit();

        }


    }
}
