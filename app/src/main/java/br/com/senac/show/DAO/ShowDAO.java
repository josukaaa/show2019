package br.com.senac.show.DAO;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.senac.show.modelo.Show;

public class ShowDAO extends SQLiteOpenHelper {
    public ShowDAO(Context context){
        super(context, "bdshow",null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE tbshow(id INTEGER PRIMARY KEY,show TEXT ,dias TEXT,horas TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS tbshow";
        db.execSQL(sql);
    }

    public void inserirShow(Show show) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues dados = new ContentValues();
        dados.put("show", show.getShow());
        dados.put("dias",show.getDias());
        dados.put("horas",show.getHoras());


        writableDatabase.insert("tbshow",null,dados);
    }

    public List<Show> listashow() {
        String sql = "Select * From tbshow;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql,null);

        List<Show>  shows = new ArrayList<Show>();

        while (c.moveToNext()){
            Show show = new Show();

            show.setId(c.getLong(c.getColumnIndex("id")));
            show.setShow(c.getString(c.getColumnIndex("show")));
            show.setDias(c.getString(c.getColumnIndex("dias")));
            show.setHoras(c.getString(c.getColumnIndex("horas")));


            shows.add(show);
        }
        c.close();
        return shows;
    }

    public void deleta (Show show){
        SQLiteDatabase db   =getWritableDatabase();
        String[] params ={show.getId().toString()};
        db.delete("tbshow", "id = ?", params);
    }
}
