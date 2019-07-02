package example.projectbaru.angrychicken;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ListViewActivity extends AppCompatActivity {

    //Data yang akan dimasukan
    private String[] pesanan = {"Ayam Glondongan", "Ayam Paha", "Ayam Sayap", "Ayam Paha", "Ayam Ceker", "Ayam Jeroan"};

    //untuk menampung data
    private ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        ListView listView = findViewById(R.id.list);
        data = new ArrayList <>() ;

        getData ();
        ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, data);
        listView.setAdapter(adapter);
    }

    private void getData () {
        Collections.addAll(data, pesanan);

    }
}
