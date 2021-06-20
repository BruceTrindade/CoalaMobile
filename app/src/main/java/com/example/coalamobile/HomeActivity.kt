package com.example.coalamobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class HomeActivity : AppCompatActivity() {




    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(findViewById(R.id.toolbar))

        val drawerLayout : DrawerLayout = findViewById(R.id.drawerLayout)
        val navView : NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener {

            when(it.itemId){

                R.id.MeusProdutos -> Toast.makeText(applicationContext, "clicked Home", Toast.LENGTH_SHORT).show()
                R.id.MinhasCategorias -> Toast.makeText(applicationContext, "clicked Home", Toast.LENGTH_SHORT).show()
                R.id.MeusClientes -> Toast.makeText(applicationContext, "clicked Home", Toast.LENGTH_SHORT).show()
                R.id.MeusPedidos -> Toast.makeText(applicationContext, "clicked Home", Toast.LENGTH_SHORT).show()
                R.id.VendasFiado -> Toast.makeText(applicationContext, "clicked Home", Toast.LENGTH_SHORT).show()
                R.id.MeusResultados -> Toast.makeText(applicationContext, "clicked Home", Toast.LENGTH_SHORT).show()
                R.id.IndicarCoala -> Toast.makeText(applicationContext, "clicked Home", Toast.LENGTH_SHORT).show()
                R.id.Ajuda -> Toast.makeText(applicationContext, "clicked Home", Toast.LENGTH_SHORT).show()
                R.id.Sair -> Toast.makeText(applicationContext, "clicked Home", Toast.LENGTH_SHORT).show()
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