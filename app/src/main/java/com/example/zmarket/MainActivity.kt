package com.example.zmarket

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    var listaProductos = ArrayList<Producto>()
    var displayList = ArrayList<Producto>()
    lateinit var adapter: ProductosAdapter
    lateinit var lista: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadData()

        lista = findViewById(R.id.lista)
        adapter = ProductosAdapter(this, listaProductos)
        lista.adapter = adapter

        lista.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, ProductoActivity::class.java)
            intent.putExtra("producto", listaProductos[position])
            startActivity(intent)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        val searchItem = menu.findItem(R.id.searchView1)
        if (searchItem != null) {
            val searchView = searchItem.actionView as SearchView

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

                override fun onQueryTextSubmit(query: String?): Boolean {


                    val l = listaProductos.filter { it.nombre.contains(query.toString(), true) }

                    if (!l.isNullOrEmpty()) {

                        adapter = ProductosAdapter(this@MainActivity,l)
                        lista.adapter = adapter

                    } else {
                        Toast.makeText(this@MainActivity, "No Match Found", Toast.LENGTH_SHORT).show()
                    }

                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {

                    adapter.filter.filter(newText)
                    return true
                }
            })
        }
        return super.onCreateOptionsMenu(menu)
    }

    private fun loadData (){
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
        displayList.addAll(listaProductos)

    }
}
