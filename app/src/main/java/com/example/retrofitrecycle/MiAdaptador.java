package com.example.retrofitrecycle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.MiContenedorDeVista> {

    private List<Incidencia> lista = new ArrayList<>();

    public MiAdaptador(List<Incidencia> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public MiContenedorDeVista onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.vista_incidencia,parent,false);

        TextView tv_fechaInicio = vista.findViewById(R.id.tv_fechaInicio);
        TextView tv_fechaFin = vista.findViewById(R.id.tv_fechaFin);
        TextView tv_descripcion = vista.findViewById(R.id.tv_descripcion);
        MiContenedorDeVista contenedor = new MiContenedorDeVista(vista);
        return contenedor;
    }

    @Override
    public void onBindViewHolder(@NonNull MiContenedorDeVista holder, int position) {

        Incidencia i = lista.get(position);
        holder.tv_descripcion.setText(i.getDescripcion());
        holder.tv_fechaFin.setText(i.getFechaFin());
        holder.tv_fechaInicio.setText(i.getFechaInicio());
        Log.d("Contenedor","Vinculado posicion "+position);

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class MiContenedorDeVista extends RecyclerView.ViewHolder{
        public TextView tv_fechaInicio,tv_fechaFin,tv_descripcion;

        public MiContenedorDeVista(View vista) {
            super(vista);
            this.tv_fechaInicio = vista.findViewById(R.id.tv_fechaInicio);
            this.tv_fechaFin = vista.findViewById(R.id.tv_fechaFin);
            this.tv_descripcion = vista.findViewById(R.id.tv_descripcion);
        }


    }
}
