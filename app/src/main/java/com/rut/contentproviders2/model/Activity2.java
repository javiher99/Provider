package com.rut.contentproviders2.model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.rut.contentproviders2.MainProviders2;
import com.rut.contentproviders2.R;
import com.rut.contentproviders2.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

// shared preferences, ciclo de vida, content provider

public class Activity2 extends AppCompatActivity {

    // Instancias
    private RecyclerView myRecycler;
    private LinearLayoutManager layoutMarager;

    private List<String> nombres = new ArrayList<>();
    private List<String> numeros = new ArrayList<>();

    private List<String> nombresFiltrados = new ArrayList<>();
    private List<String> numerosFiltrados = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        myRecycler = findViewById(R.id.myRecycler);
        layoutMarager = new LinearLayoutManager(this);
        myRecycler.setLayoutManager(layoutMarager);

        String userNombre = MainProviders2.userName;
        String userNumero = MainProviders2.userNumber;

        // Rellenar array
        for (int i = 0; i < MainProviders2.nombres.size(); i++) {
            nombres.add(MainProviders2.nombres.get(i));
            numeros.add(MainProviders2.numeros.get(i));
        }

        for (int i = 0; i < nombres.size(); i++) {
            String x = nombres.get(i);
            String a = numeros.get(i);
            if (x.contains(userNombre) && a.contains(userNumero)){
                nombresFiltrados.add(x);
                numerosFiltrados.add(a);
            }
        }

        MyAdapter myAdapter = new MyAdapter(nombresFiltrados, numerosFiltrados, new MyAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(ElementoLista elementoLista) {

            }
        });
        myRecycler.setAdapter(myAdapter);
    }





}
