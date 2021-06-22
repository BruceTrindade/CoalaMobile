package com.example.coalamobile

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.example.coalamobile.ui.login.LoginFragment
import com.firebase.ui.auth.AuthUI
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth


class HomeActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(findViewById(R.id.toolbar))
        //Meu e-mail: brucetrindade2000@gmail.com
        //setando a gaveta de menu
        val drawerLayout : DrawerLayout = findViewById(R.id.drawerLayout)
        val navView : NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

          navView.setNavigationItemSelectedListener {

              if (it.itemId == R.id.Sair) {
                  AlertDialog.Builder(this).apply {
                      setTitle("Are you sure?")
                      setPositiveButton("Yes") { _, _ ->
                          FirebaseAuth.getInstance().signOut()
                        /*  supportFragmentManager
                                  .beginTransaction()
                                  .add(R.id.drawerLayout, LoginFragment())
                                  .commit()*/
                      }
                      setNegativeButton("Cancel") { _, _ ->
                      }
                  }.create().show()
              }

/*

              */
            when(it.itemId){

                R.id.MeusProdutos -> Toast.makeText(applicationContext, "clicked Home", Toast.LENGTH_SHORT).show()
                R.id.MinhasCategorias -> Toast.makeText(applicationContext, "clicked Home", Toast.LENGTH_SHORT).show()
                R.id.MeusClientes -> Toast.makeText(applicationContext, "clicked Home", Toast.LENGTH_SHORT).show()
                R.id.MeusPedidos -> Toast.makeText(applicationContext, "clicked Home", Toast.LENGTH_SHORT).show()
                R.id.VendasFiado -> Toast.makeText(applicationContext, "clicked Home", Toast.LENGTH_SHORT).show()
                R.id.MeusResultados -> Toast.makeText(applicationContext, "clicked Home", Toast.LENGTH_SHORT).show()
                R.id.IndicarCoala -> Toast.makeText(applicationContext, "clicked Home", Toast.LENGTH_SHORT).show()
                R.id.Ajuda -> Toast.makeText(applicationContext, "clicked Home", Toast.LENGTH_SHORT).show()
                              /*R.id.Sair -> Toast.makeText(applicationContext, "clicked Home", Toast.LENGTH_SHORT).show()*/
            }

            true

        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)) {
            return true

        }
        return super.onOptionsItemSelected(item)
    }
}
