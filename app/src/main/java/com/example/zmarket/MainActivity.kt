package com.example.zmarket

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val listaProductos = ArrayList<Producto>()
    val displayList = ArrayList<Producto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lista = findViewById<ListView>(R.id.lista)

        listaProductos.add(Producto("Camara", 22000.0, "Camara ultimo modelo", R.drawable.camara))
        listaProductos.add(Producto("MAC PRO", 15000.0, "16 GB RAM", R.drawable.pc))
        listaProductos.add(Producto("Camara Sony", 22000.0, "Camara ultimo modelo", R.drawable.camara))
        listaProductos.add(Producto("PC LENOVO", 15000.0, "16 GB RAM", R.drawable.pc))
        listaProductos.add(Producto("Camara", 22000.0, "Camara ultimo modelo", R.drawable.camara))
        listaProductos.add(Producto("PC HP", 15000.0, "16 GB RAM", R.drawable.pc))
        listaProductos.add(Producto("Camara", 22000.0, "Camara ultimo modelo", R.drawable.camara))
        listaProductos.add(Producto("PC Toshiba", 1000.0, "16 GB RAM", R.drawable.pc))
        listaProductos.add(Producto("Camara", 22000.0, "Camara ultimo modelo", R.drawable.camara))
        listaProductos.add(Producto("PC DELL", 15000.0, "16 GB RAM", R.drawable.pc))



        //val searchView = findViewById<SearchView>(R.id.searchView1)
        val adapter = ProductosAdapter(this, listaProductos)
        lista.adapter = adapter

        lista.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, ProductoActivity::class.java)
            intent.putExtra("producto", listaProductos[position])
            startActivity(intent)
        }

         fun onCreateOptionsMenu(menu: Menu): Boolean {
            menuInflater.inflate(R.menu.menu, menu)

            val searchItem = menu.findItem(R.id.searchView1)
            if (searchItem != null) {
                val searchView = searchItem.actionView as SearchView

                    searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

                        override fun onQueryTextSubmit(query: String?): Boolean {
                            if (listaProductos.containsAll(listaProductos)) {
                                adapter.filter.filter(query)
                            } else {
                                Toast.makeText(this@MainActivity, "No Match Found", Toast.LENGTH_SHORT).show()
                            }
                            return true
                        }

                        override fun onQueryTextChange(newText: String?): Boolean {
                            displayList.clear()
                            adapter.filter.filter(newText)
                            return false
                        }
                    })
                }
            return onCreateOptionsMenu(menu)
        }
    }
}
