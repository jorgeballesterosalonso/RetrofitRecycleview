package com.example.retrofitrecycle;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServicioIncidencia {
    @GET("informo/tmadrid/incid_aytomadrid.xml")
    Call<Incidenciaaas> getIncidencias();
}
