package com.hardeep.sqlitepractice


import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources

class PreferencesClass{

    private var sharedPreferences: SharedPreferences? = null
    constructor(context: Context)
    {
        sharedPreferences = context.getSharedPreferences(R.string.preference_key.toString(),Context.MODE_PRIVATE)
    }

    fun addSession(name: String)
    {
        val editor: SharedPreferences.Editor = sharedPreferences!!.edit()
        editor.putString(R.string.user_session.toString(),name)
        editor.apply()
    }

    fun getSession(): String?
    {
        return sharedPreferences!!.getString(R.string.user_session.toString(),"")
    }
}

