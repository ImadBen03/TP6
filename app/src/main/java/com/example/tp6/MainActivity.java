package com.example.tp6;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ListView lv;

    getEtudiant g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv);
        g = new getEtudiant(lv, this);
        //CHANGE THIS IP TO YOUR PC'S IPV4 FOR IT TO WORK+LOCATION TA3 LE FICHIER PHP IN THE XAMPP/htdocs/whatever/fichier.php
        String url="http://192.168.3.163/androidtest/data.php";
        g.execute(url);
    }
}