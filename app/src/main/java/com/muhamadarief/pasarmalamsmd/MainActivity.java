package com.muhamadarief.pasarmalamsmd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.muhamadarief.pasarmalamsmd.API.ApiService;
import com.muhamadarief.pasarmalamsmd.API.ApiUtils;
import com.muhamadarief.pasarmalamsmd.model.Pasar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    private RecyclerView rv_item;
    private PasarAdapter adapter;
    private ApiService mApiService;
    private ArrayList<Pasar> listPasar = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mApiService = ApiUtils.getAPIService();

        rv_item = (RecyclerView) findViewById(R.id.rv_item);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv_item.setLayoutManager(linearLayoutManager);

        getDataPasar();

    }

    private void getDataPasar(){
        mApiService.getPasar().enqueue(new Callback<List<Pasar>>() {
            @Override
            public void onResponse(Call<List<Pasar>> call, Response<List<Pasar>> response) {
                int jumlah = response.body().size();

                for (int i = 0; i < jumlah; i++){
                    Pasar pasar = new Pasar(
                            response.body().get(i).getId_pasar(),
                            response.body().get(i).getNama_lokasi(),
                            response.body().get(i).getDeskripsi(),
                            response.body().get(i).getFoto_lokasi(),
                            response.body().get(i).getHari(),
                            response.body().get(i).getJam(),
                            response.body().get(i).getLattitude(),
                            response.body().get(i).getLongitude()
                            );
                    Log.d(TAG, ""+response.body().get(i).getNama_lokasi());
                    Log.d(TAG, ""+response.body().get(i).getFoto_lokasi());
                    listPasar.add(pasar);
                }

                adapter = new PasarAdapter(MainActivity.this, listPasar);
                rv_item.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Pasar>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something wrong.", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "failure because " + t);
            }
        });
    }
}

