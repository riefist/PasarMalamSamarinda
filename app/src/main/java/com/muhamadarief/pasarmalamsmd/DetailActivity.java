package com.muhamadarief.pasarmalamsmd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.muhamadarief.pasarmalamsmd.API.ApiUtils;
import com.muhamadarief.pasarmalamsmd.model.Pasar;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    public static final String TAG = "DetailActivity";
    public static final String DATA_PASAR = "data_pasar";

    private Pasar mPasar;

    private ImageView img_pasar;
    private TextView txt_nama_pasar;
    private TextView txt_deskripsi;
    private TextView txt_hari;
    private TextView txt_jam;
    private Button btnMaps;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mPasar = (Pasar)getIntent().getSerializableExtra(DATA_PASAR);
        Log.d(TAG, mPasar.getNama_lokasi());
        if (mPasar == null) {
            throw new IllegalArgumentException("Must pass DATA_PASAR");
        }

        getSupportActionBar().setTitle(mPasar.getNama_lokasi());

        img_pasar = (ImageView) findViewById(R.id.img_pasar);
        txt_nama_pasar = (TextView) findViewById(R.id.txt_nama_pasar);
        txt_deskripsi = (TextView) findViewById(R.id.txt_deskripsi);
        txt_hari = (TextView) findViewById(R.id.txt_hari);
        txt_jam = (TextView) findViewById(R.id.txt_jam);
        btnMaps = (Button) findViewById(R.id.btnMaps);

        //txt_nama_pasar.setText(mPasar.getNama_lokasi());
        txt_deskripsi.setText(mPasar.getDeskripsi());
        txt_hari.setText(mPasar.getHari());
        txt_jam.setText(mPasar.getJam());

        String photoUrl = ApiUtils.BASE_URL +""+mPasar.getFoto_lokasi();
        Picasso.with(DetailActivity.this)
                .load(photoUrl)
                .into(img_pasar);


        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailActivity.this, "Tampilkan peta.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DetailActivity.this, MapsActivity.class);
                intent.putExtra("data", mPasar);
                startActivity(intent);
            }
        });

    }
}
