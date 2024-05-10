package com.example.tp6;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class getEtudiant extends AsyncTask<String, Void, String> {
    ListView lv;
    Context context;

    public getEtudiant(ListView lv, Context context) {
        this.lv = lv;
        this.context = context;
    }

    @Override
    protected String doInBackground(String... url) {
        try{
            HttpURLConnection conn=(HttpURLConnection) new URL(url[0]).openConnection();
            /*conn.setReadTimeout(1000);
            conn.setConnectTimeout(1000);*/
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.connect();
            InputStream in=conn.getInputStream();
            InputStreamReader reader=new InputStreamReader(in);
            BufferedReader r=new BufferedReader(reader);
            StringBuilder sb=new StringBuilder();
            String line;
            while((line=r.readLine())!=null){
                sb.append(line).append("\n");
            }
            return sb.toString();
        }catch (Exception e){
            Log.e("Error"," ",e);
        }
        return null;
    }

    protected void onPostExecute(String result){
        ArrayList<Etudiant> etudiants=new ArrayList<>();
        try{
            JSONArray array=new JSONArray(result);
            for(int i=0;i<array.length();i++){
                JSONObject obj=array.getJSONObject(i);
                String matricule=obj.getString("matricule");
                String nom=obj.getString("nom");
                String prenom=obj.getString("prenom");
                Etudiant e=new Etudiant(matricule,nom,prenom);
                etudiants.add(e);
            }
        }
        catch (JSONException e){
            Log.e("Error"," ",e);
        }
        MyAdapter adapter=new MyAdapter(context,etudiants);
        lv.setAdapter(adapter);
    }
}
