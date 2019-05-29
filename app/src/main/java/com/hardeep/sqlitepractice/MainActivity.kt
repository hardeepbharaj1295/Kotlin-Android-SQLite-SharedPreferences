package com.hardeep.sqlitepractice

import android.content.Intent
import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var editName: EditText? = null
    private var editPassword: EditText? = null
    private var shared: PreferencesClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editName = findViewById(R.id.email)
        editPassword = findViewById(R.id.password)

        shared = PreferencesClass(this)
        if (!shared!!.getSession().equals(""))
        {
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun submit(v: View) {
        val db = SqliteQueries(this)
        val cursor: Cursor = db.loginUser(editName!!.text.toString(),editPassword!!.text.toString())
        if (cursor.moveToFirst())
        {
            Toast.makeText(applicationContext,"Login Working",
                Toast.LENGTH_SHORT).show()

            shared!!.addSession(editName!!.text.toString())

            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
        else
        {
            Toast.makeText(applicationContext,"Wrong Username/Password",
                Toast.LENGTH_SHORT).show()
        }
    }

    fun register(v: View){
        val intent = Intent(this,RegisterActivity::class.java)
        startActivity(intent)
        finish()
    }

}
