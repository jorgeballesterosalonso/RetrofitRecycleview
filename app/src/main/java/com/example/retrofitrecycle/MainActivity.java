package com.example.retrofitrecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Actualizacion{

    MainActivity contexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contexto = this;
        AccesoADatos.pedirDatosXML(contexto);

    }

    @Override
    public void recuperarDatos(Incidenciaaas i) {
        
        List<Incidencia> listaIncidencias = i.getListaIncidencias();
        Log.d("Mensaje",listaIncidencias.toString());

        MiAdaptador adaptador = new MiAdaptador(listaIncidencias);
        RecyclerView rec = findViewById(R.id.recycleView);
        RecyclerView.LayoutManager gestor = new LinearLayoutManager(this);

        rec.setLayoutManager(gestor);
        rec.setAdapter(adaptador);


    }
}