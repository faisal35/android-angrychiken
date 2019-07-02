package example.projectbaru.angrychicken;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class InputPesanan extends AppCompatActivity {

    TextView txtGetNama, tv_glondongan, tv_kepala, tv_sayap, tv_paha, tv_ceker, tv_jeroan;
    EditText edtNama;
    CheckBox cbx_glondongan, cbx_kepala, cbx_sayap, cbx_paha, cbx_ceker, cbx_jeroan;
    int jumlah, total, harga = 10, glondongan = 0, kepala = 0, sayap = 0, paha = 0, ceker = 0, jeroan = 0;
    String nama, statusGlondongan = "tidak", statusKepala = "tidak", statusSayap = "tidak", statusPaha = "tidak", statusCeker = "tidak", statusJeroan = "tidak";
    boolean iscbx_glondongan, iscbx_kepala, iscbx_sayap, iscbx_paha, iscbx_ceker, iscbx_jeroan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_pesanan);
        cbx_glondongan = findViewById(R.id.cbx_glondongan);
        cbx_kepala = findViewById(R.id.cbx_kepala);
        cbx_sayap = findViewById(R.id.cbx_sayap);
        cbx_paha = findViewById(R.id.cbx_paha);
        cbx_ceker = findViewById(R.id.cbx_ceker);
        cbx_jeroan = findViewById(R.id.cbx_jeroan);
        tv_glondongan = findViewById(R.id.tv_glondongan);
        tv_kepala = findViewById(R.id.tv_kepala);
        tv_sayap = findViewById(R.id.tv_sayap);
        tv_paha = findViewById(R.id.tv_paha);
        tv_ceker = findViewById(R.id.tv_ceker);
        tv_jeroan = findViewById(R.id.tv_jeroan);
    }

    public void pesanan() {
        if (cbx_glondongan.isChecked()) {
            iscbx_glondongan = true;
            statusGlondongan = "Ayam Glondongan : " + tv_glondongan.getText().toString();
            glondongan = 1;
        } else {
            iscbx_glondongan = false;
            statusGlondongan = "";
            glondongan = 0;
        }
        if (cbx_kepala.isChecked()) {
            iscbx_kepala = true;
            statusKepala = "\nAyam Kepala : " + tv_kepala.getText().toString();
            kepala = 2;
        } else {
            iscbx_kepala = false;
            statusKepala = "";
            kepala = 0;
        }
        if (cbx_sayap.isChecked()) {
            iscbx_sayap = true;
            statusSayap = "\nAyam Sayap : " + tv_sayap.getText().toString();
            sayap = 3;
        } else {
            iscbx_sayap = false;
            statusSayap = "";
            sayap = 0;
        }
        if (cbx_paha.isChecked()) {
            iscbx_paha = true;
            statusPaha = "\nAyam Paha : " + tv_paha.getText().toString();
            sayap = 3;
        } else {
            iscbx_paha = false;
            statusPaha = "";
            sayap = 0;
        }
        if (cbx_ceker.isChecked()) {
            iscbx_ceker = true;
            statusCeker = "\nAyam Ceker : " + tv_ceker.getText().toString();
            ceker = 4;
        } else {
            iscbx_ceker = false;
            statusCeker = "";
            ceker = 0;
        }
        if (cbx_jeroan.isChecked()) {
            iscbx_jeroan = true;
            statusJeroan = "\nAyam Jeroan : " + tv_jeroan.getText().toString();
            ceker = 5;
        } else {
            iscbx_jeroan = false;
            statusJeroan = "";
            ceker = 0;
        }
    }

    public void tambah1(View view) {
        tv_glondongan.setText(String.valueOf(Integer.valueOf(tv_glondongan.getText().toString()) + 1));
    }

    public void kurang1(View view) {
        tv_glondongan.setText(String.valueOf(Integer.valueOf(tv_glondongan.getText().toString()) - 1));
    }

    public void tambah2(View view) {
        tv_kepala.setText(String.valueOf(Integer.valueOf(tv_kepala.getText().toString()) + 1));
    }

    public void kurang2(View view) {
        tv_kepala.setText(String.valueOf(Integer.valueOf(tv_kepala.getText().toString()) - 1));
    }

    public void tambah3(View view) {
        tv_sayap.setText(String.valueOf(Integer.valueOf(tv_sayap.getText().toString()) + 1));
    }

    public void kurang3(View view) {
        tv_sayap.setText(String.valueOf(Integer.valueOf(tv_sayap.getText().toString()) - 1));
    }

    public void tambah4(View view) {
        tv_paha.setText(String.valueOf(Integer.valueOf(tv_paha.getText().toString()) + 1));
    }

    public void kurang4(View view) {
        tv_paha.setText(String.valueOf(Integer.valueOf(tv_paha.getText().toString()) - 1));
    }

    public void tambah5(View view) {
        tv_ceker.setText(String.valueOf(Integer.valueOf(tv_ceker.getText().toString()) + 1));
    }

    public void kurang5(View view) {
        tv_ceker.setText(String.valueOf(Integer.valueOf(tv_ceker.getText().toString()) - 1));
    }

    public void tambah6(View view) {
        tv_jeroan.setText(String.valueOf(Integer.valueOf(tv_jeroan.getText().toString()) + 1));
    }

    public void kurang6(View view) {
        tv_jeroan.setText(String.valueOf(Integer.valueOf(tv_jeroan.getText().toString()) - 1));
    }

    public void order(View view) {
        display();
    }

    public void display() {
        pesanan();
        total = 0;
        if (iscbx_glondongan) {
            total += (50000 * Integer.valueOf(tv_glondongan.getText().toString()));
        }
        if (iscbx_kepala) {
            total += (5000 * Integer.valueOf(tv_kepala.getText().toString()));
        }
        if (iscbx_sayap) {
            total += (5000 * Integer.valueOf(tv_sayap.getText().toString()));
        }
        if (iscbx_paha) {
            total += (8000 * Integer.valueOf(tv_paha.getText().toString()));
        }
        if (iscbx_ceker) {
            total += (4000 * Integer.valueOf(tv_ceker.getText().toString()));
        }
        if (iscbx_jeroan) {
            total += (5000 * Integer.valueOf(tv_jeroan.getText().toString()));
        }
        Log.i("harga :", "" + total);
        Intent i = new Intent(InputPesanan.this, RincianPesanan.class);
        i.putExtra("ket", statusGlondongan +
                statusKepala +
                statusSayap +
                statusPaha +
                statusCeker +
                statusJeroan);
        i.putExtra("nama", edtNama.getText().toString());
        i.putExtra("total", total);
        startActivity(i);
    }
}
