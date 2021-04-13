package com.example.zmarket

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ProductosAdapter(private val mContext: Context, private val listaProductos: List<Producto>) : ArrayAdapter<Producto>(mContext, 0, listaProductos) {
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_producto,parent,false)

        val nombre = layout.findViewById(R.id.nombre) as TextView
        val precio = layout.findViewById(R.id.precio) as TextView
        val imagen = layout.findViewById(R.id.imageView) as ImageView

        val producto = listaProductos[position]

        nombre.text = producto.nombre
        precio.text = "$${producto.precio}"
        imagen.setImageResource(producto.imagen)

        return layout
    }

}