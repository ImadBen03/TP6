package com.example.tp6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<Etudiant> {

    private final ArrayList<Etudiant> etudiants;
    Context context;

    public MyAdapter(Context context, ArrayList<Etudiant> etudiants){
        super(context, R.layout.itemlist, etudiants);
        this.etudiants=etudiants;
        this.context=context;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent){
        if(v==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.itemlist, parent,false);
        }
        Etudiant etudiant=etudiants.get(position);
        if(etudiant!=null){
            TextView matricule=v.findViewById(R.id.matricule);
            TextView nom=v.findViewById(R.id.nom);
            TextView prenom=v.findViewById(R.id.prenom);
            matricule.setText(etudiant.matricule);
            nom.setText(etudiant.nom);
            prenom.setText(etudiant.prenom);
        }
        return v;
    }
}
