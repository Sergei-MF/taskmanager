package com.android.sergio.taskmanager;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by sergej on 21.03.16.
 */
public class PreferencesHelper
{
    public final static String SPLASH_IS_INVISIBLE = "splash_is_invisible";

    private static PreferencesHelper instance;

    private Context context;

    private SharedPreferences preferences;

    private PreferencesHelper(){

    }

    public static PreferencesHelper getInstance(){
        if ( instance == null ) {
            instance = new PreferencesHelper();
        }
        return instance;
    }

    public void init( Context context ){
         this.context = context;
        preferences = context.getSharedPreferences("preferences", Context.MODE_PRIVATE);


    }

    public void putBoolean( String key, boolean value){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean( key, value );
        editor.apply();
    }

    public boolean getBoolean(String key){
        return preferences.getBoolean(key, false);
    }
}
