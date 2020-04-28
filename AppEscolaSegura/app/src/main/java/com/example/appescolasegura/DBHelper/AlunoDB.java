package com.example.appescolasegura.DBHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.appescolasegura.model.Aluno;

import java.util.ArrayList;

public class AlunoDB extends SQLiteOpenHelper {
    private static final String DATABASE = "DBProdutos";
    private static final int VESION = 1;

    public AlunoDB(Context context) {
        super(context, DATABASE, null, VESION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String aluno = "CREATE TABLE aluno(ra INTEGER PRIMARY KEY NOT NULL,nomealuno TEXT NOT NULL, responsavel TEXT NOT NULL,email TEXT NOT NULL, senha INTERGER );";
        db.execSQL(aluno);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String aluno = "DROP TABLE IF EXISTS aluno";
        db.execSQL(aluno);
    }

    //salvar dados
    public void salvarAluno(Aluno aluno) {
        ContentValues values = new ContentValues();

        values.put("ra", aluno.getRa());
        values.put("nomeAluno", aluno.getNomeAluno());
        values.put("responsavel", aluno.getNomeAluno());
        values.put("email", aluno.getEmail());
        values.put("senha", aluno.getSenha());

        getWritableDatabase().insert("aluno", null, values);
    }
    // Alterar

    public void alterarAluno(Aluno aluno) {
        ContentValues values = new ContentValues();

        values.put("ra", aluno.getRa());
        values.put("nomeAluno", aluno.getNomeAluno());
        values.put("responsavel", aluno.getNomeAluno());
        values.put("email", aluno.getEmail());
        values.put("senha", aluno.getSenha());

        String[] args = {String.valueOf(aluno.getRa())};
        getWritableDatabase().update("aluno", values, "ra=?", args);
    }

    public void deletarAluno(Aluno aluno) {
        String[] args = {Long.toString(aluno.getRa())};
        getWritableDatabase().delete("aluno", "ra=?", args);
    }

    //listar dados
    public ArrayList<Aluno> getLista() {
        String[] columns = {"ra", "nomeAluno", "responsavel","email", "senha"};
        Cursor cursor = getWritableDatabase().query("aluno", columns, null, null, null, null, null, null);
        ArrayList<Aluno> aluno = new ArrayList<Aluno>();

        while ( cursor.moveToNext()) {
            Aluno produto = new Aluno();
            produto.setRa(cursor.getLong(0));
            produto.setNomeAluno(cursor.getString(1));
            produto.setResponsavel(cursor.getString(2));
            produto.setEmail(cursor.getString(3));
            produto.setSenha(cursor.getInt(4));

            aluno.add(produto);
        }
        return aluno;
    }
}
