package com.example.coalamobile

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.example.coalamobile.ui.login.LoginFragment
import com.firebase.ui.auth.util.GoogleApiUtils
import com.google.android.gms.common.api.GoogleApi
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.credentials.Credentials
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class HomeActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    val firebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(findViewById(R.id.toolbar))

        val firebaseUser = firebaseAuth.currentUser

        if (firebaseUser == null) {
             chamaLogin()
        }  else {
            Toast.makeText(applicationContext,"entrei", Toast.LENGTH_SHORT).show()
        }
        Toast.makeText(applicationContext,"entreiCaramba", Toast.LENGTH_SHORT).show()
        menu()
       /*val navView : NavigationView = findViewById(R.id.nav_view)
        navView.setNavigationItemSelectedListener {

            if (it.itemId == R.id.Sair) {

                AlertDialog.Builder(this).apply {
                    setTitle("Quer realmente sair?")
                    setPositiveButton("Sim") { _, _ ->
                        firebaseAuth.signOut()
                        chamaLogin()
                    } //Fim do set positive button
                    setNegativeButton("Não") { _, _ ->
                    } // do NefativeButton
                }.create().show()
            }//fim da condicional if

            true

        }*/
    }

    fun menu(){
        //setando a gaveta de menu
        val drawerLayout : DrawerLayout = findViewById(R.id.drawerLayout)
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    fun chamaLogin(){
        supportFragmentManager
                .beginTransaction()
                .add(R.id.drawerLayout, LoginFragment())
                .commit()
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)) {
            return true

        }
        return super.onOptionsItemSelected(item)
    }

}

/*
navView.setNavigationItemSelectedListener {

    if (it.itemId == R.id.Sair) {

        AlertDialog.Builder(this).apply {
            setTitle("Quer realmente sair?")
            setPositiveButton("Sim") { _, _ ->
                firebaseAuth.signOut()
                chamaLogin()
            } //Fim do set positive button
            setNegativeButton("Não") { _, _ ->
            } // do NefativeButton
        }.create().show()
    }//fim da condicional if

    true

}*/
