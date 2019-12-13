package com.rut.contentproviders2.adapter;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.rut.contentproviders2.R;
import com.rut.contentproviders2.model.ElementoLista;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private LayoutInflater inflater;

    // Constructor
    private List<String> nombres = new ArrayList<>();
    private List<String> numeros = new ArrayList<>();

    private OnItemClickListener listener;

    public interface OnItemClickListener{
        public void OnItemClick(ElementoLista elementoLista);
    }

    public MyAdapter(List<String >nombres, List<String> numeros, OnItemClickListener listener){
        this.nombres = nombres;
        this.numeros = numeros;
        this.listener = listener;
    }

    // Metodos Recycler
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(parent.getContext());
        View intentView = inflater.inflate(R.layout.my_recycler_view, parent, false);
        MyViewHolder vh = new MyViewHolder(intentView);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,final int position) {
        // Vamos a asignar a cada holder su posicion
        final String nombre = nombres.get(position);
        final String numero = numeros.get(position);
        // Log
        Log.v("abcde", "nombre: " + nombre);
        Log.v("abcde", "numero: " + numero);

        holder.tvnombreContacto.setText(nombre);
        holder.tvNumeroContacto.setText(numero);
        holder.cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "has pulsado" + position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return numeros.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvnombreContacto, tvNumeroContacto, tvEmailContacto;
        ConstraintLayout cl;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            // Hasta no crear el onCreateViewHolder no va a encontrar los id
            tvnombreContacto = itemView.findViewById(R.id.tvNombreContacto);
            tvNumeroContacto = itemView.findViewById(R.id.tvNumeroContacto);
            tvEmailContacto = itemView.findViewById(R.id.tvEmail);
            cl = itemView.findViewById(R.id.cl);
        }

    }
}
