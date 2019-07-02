package example.projectbaru.angrychicken;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RincianPesanan extends AppCompatActivity {
    private TextView edtnamapes, edtharga, edtjumlahbay;
    private Button btnproses;
    private Button btnhapus;
    private Button btnexit;
    private TextView txtnamapemb;
    private TextView txtnamapes;
    private TextView txtharga;
    private TextView txtjumlahbay;
    private TextView txttotalpembelian;
    private TextView txtuangkembali;
    private TextView txtketerangan;
    private TextView edtnamapemb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rincian_pesananan);

        edtnamapes = (TextView) findViewById(R.id.namabarang);
        edtharga = (TextView) findViewById(R.id.harga);
        edtjumlahbay = (EditText) findViewById(R.id.uangbayar);
        btnproses = (Button) findViewById(R.id.tombol1);
        btnhapus = (Button) findViewById(R.id.tombol2);
        btnexit = (Button) findViewById(R.id.tombol3);
        txtnamapes = (TextView) findViewById(R.id.namabarang);
        txtharga = (TextView) findViewById(R.id.harga);
        txtjumlahbay = (TextView) findViewById(R.id.uangbayar);
        txttotalpembelian = (TextView) findViewById(R.id.totalbelanja);
        txtuangkembali = (TextView) findViewById(R.id.uangkembali);
        txtketerangan = (TextView) findViewById(R.id.keterangan);

        edtnamapemb.setText(getIntent().getExtras().getString("nama"));
        edtnamapes.setText(getIntent().getExtras().getString("ket"));
        edtharga.setText(String.valueOf(getIntent().getExtras().getInt("total")));

        btnproses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jumlahbayar = edtjumlahbay.getText().toString();
                double ub = (double) Double.parseDouble(jumlahbayar);
                txttotalpembelian.setText("Total Belanja : " + String.valueOf(getIntent().getExtras().getInt("total")));
                double uangkembalian = (ub - getIntent().getExtras().getInt("total"));

                if (ub < getIntent().getExtras().getInt("total")){
                    txtketerangan.setText("Keterangan : uang bayar kurang Rp " + (-uangkembalian));
                    txtuangkembali.setText("Uang Kembali : Rp 0" );
                }else{
                    txtketerangan.setText("Keterangan : Tunggu Kembalian");
                    txtuangkembali.setText("Uang Kembali : " + uangkembalian);
                }

            }
        });
        btnhapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
        btnexit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                moveTaskToBack(true);
            }
        });

    }
}
