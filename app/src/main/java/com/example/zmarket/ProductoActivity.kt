package com.example.zmarket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProductoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto)

        val producto = intent.getSerializableExtra("producto") as Producto

        val nombre_producto = findViewById(R.id.nombre_producto) as TextView
        val precio_producto = findViewById(R.id.precio_producto) as TextView
        val detalles_producto = findViewById(R.id.detalles_producto) as TextView
        val imageView = findViewById(R.id.imagen) as ImageView

        nombre_producto.text = producto.nombre
        precio_producto.text = "$${producto.precio}"
        detalles_producto.text = producto.descripcion
        imageView.setImageResource(producto.imagen)




    }
}