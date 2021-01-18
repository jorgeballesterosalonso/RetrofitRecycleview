package com.example.retrofitrecycle;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class AccesoADatos {

    static Incidenciaaas inci= null;

    public static Incidenciaaas pedirDatosXML(Actualizacion a) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://informo.madrid.es/")
                .addConverterFactory(SimpleXmlConverterFactory.create()).build();

        ServicioIncidencia service = retrofit.create(ServicioIncidencia.class);

        Call<Incidenciaaas> llamada = service.getIncidencias();
        llamada.enqueue(new Callback<Incidenciaaas>() {

            @Override
            public void onResponse(Call<Incidenciaaas> call, Response<Incidenciaaas> response) {
                inci = response.body();
                Log.d("Mensaje",inci.getListaIncidencias().toString());
                a.recuperarDatos(inci);
                // System.out.println(p);

            }

            @Override
            public void onFailure(Call<Incidenciaaas> call, Throwable t) {
                Log.d("Mensaje",t.getLocalizedMessage());
            }
        });
        return inci;
    }
}
