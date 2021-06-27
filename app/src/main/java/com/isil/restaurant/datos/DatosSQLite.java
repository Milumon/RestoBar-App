package com.isil.restaurant.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatosSQLite extends SQLiteOpenHelper {
    public DatosSQLite(@Nullable Context context) {
        super(context, "cajita", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE movimientos(" +
                "idmovimiento INTEGER PRIMARY KEY AUTOINCREMENT," +
                "fecha DATETIME DEFAULT CURRENT_TIMESTAMP,"+
                "descripcion TEXT," +
                "monto float," +
                "movimiento int)");
    }


    public int registrarMovimiento(DatosSQLite datosSQLite, String descripcion, float monto, int movimiento ){
        SQLiteDatabase db = datosSQLite.getWritableDatabase();
        //db.execSQL("Insert Into .....");
        ContentValues contentValues = new ContentValues();
        contentValues.put("descripcion",descripcion);
        contentValues.put("monto",monto);
        contentValues.put("movimiento",movimiento);
        int autonumerico = (int) db.insert("movimientos",null,contentValues);
        return autonumerico;
    }

    public Cursor mostrarTodo(DatosSQLite datosSQLite){
        SQLiteDatabase db = datosSQLite.getReadableDatabase();
        String sql = "select * from movimientos";
        return db.rawQuery(sql,null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
