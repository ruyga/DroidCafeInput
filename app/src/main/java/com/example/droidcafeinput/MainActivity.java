package com.example.droidcafeinput;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener { //untuk mendefenisikan penanganan kejadian pemilihan spinner

    @Override
    protected void onCreate(Bundle savedInstanceState) { //spinner adalah kumpulan nilai dalam array string
        //
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Membuat  spinner (kotak pilihsn)
        //Membuat Sebuah ArrayAdapter dari array string
        Spinner spinner = findViewById(R.id.label_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        // Create an ArrayAdapter using the string array and default spinner
        // layout.
        // Metode createFromResource()  membuat ArrayAdapter dari larik string
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.labels_array,
                android.R.layout.simple_spinner_item);
        //Kemudian Anda harus memanggil setDropDownViewResource(int) untuk menetapkan
        // layout yang harus digunakan adaptor untuk menampilkan daftar pilihan spinner
        // (simple_spinner_dropdown_item adalah layout standar lainnya yang didefinisikan oleh platform).
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        // Panggil setAdapter() untuk menerapkan adaptor ke Spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
    }

    //Mendefenisikan radio button yang
    public void onRadioButtonClicked(View view) {
        // kondisi pengecekan sedang dilakukan atau tidak
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.sameday://untuk service yang pertama bila diklik
                if (checked)
                    displayToast(getString(R.string.same_day_messenger_service));//menampilkan toast "sameday"
                break;
            case R.id.nextday://untuk service yang kedua yaitu
                if (checked)//jika di klik
                    displayToast(getString(R.string.next_day_ground_delivery));//maka akan memunculkan toast "ffdddad"
                break;
            case R.id.pickup://untuk service yang ketiga
                if (checked)//jika diklik
                    displayToast(getString(R.string.pick_up));//akan memunculkan toast"ahskjasgaj"
                break;
            default: //kondisi default/berhenti
                break;
        }
    }

    public void displayToast(String message) { //method untuk menapilkan toast
        Toast.makeText(getApplicationContext(), message, //mengirimkan toast sebagai pesan
                Toast.LENGTH_SHORT).show();
    }

    @Override
    //method ini merupakan metode callback dari
    // anatar muka AdapterView.OnItemSelectedListener

    // Item dipilih. Anda dapat mengambil item yang dipilih menggunakan
    //parent.getItemAtPosition(int i)
    public void onItemSelected(AdapterView<?> adapterView,
                               View view, int i, long l) {
        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
        displayToast(spinnerLabel);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // Do nothing.
    }
}