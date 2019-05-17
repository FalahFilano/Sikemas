package com.filano.sikemastekber;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;


public class SessionManager {

    private static String PREF_NAME = "session";
    private static String IS_LOGIN = "is_login";
    private static String NO_IDENTITAS = "no_identitas";
    private static String NAME = "name";
    private static String TYPE = "type";
    private static String TOKEN_TYPE = "token_type";
    private static String TOKEN = "token";

    private Context context;
    private SharedPreferences sharedPreferences;
    private Editor editor;

    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void login(String no_identitas, String name, String type, String token, String token_type) {
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(NO_IDENTITAS, no_identitas);
        editor.putString(NAME, name);
        editor.putString(TYPE, type);
        editor.putString(TOKEN_TYPE, token_type);
        editor.putString(TOKEN, token);
        editor.commit();
    }

    public void logout() {
        editor.clear();
        editor.commit();
    }

    public boolean isLogin() {
        return sharedPreferences.getBoolean(IS_LOGIN, false);
    }

    public String getToken() {
        String token_type = sharedPreferences.getString(TOKEN_TYPE, null);
        String token = sharedPreferences.getString(TOKEN, null);

        return token_type + " " + token;
    }

    public String getName() {
        return sharedPreferences.getString(NAME, null);
    }

    public String getNoIdentitas() {
        return sharedPreferences.getString(NO_IDENTITAS, null);
    }
}
