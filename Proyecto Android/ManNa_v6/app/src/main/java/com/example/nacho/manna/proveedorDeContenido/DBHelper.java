package com.example.nacho.manna.proveedorDeContenido;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context, String name,
                    SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Tabla Orden-------------------------------------------------------------------------------

        db.execSQL("CREATE TABLE "
                + Contrato.Orden.NOMBRE_TABLA
                + "(_id LONG PRIMARY KEY ON CONFLICT ROLLBACK, "
                + Contrato.Orden.ID_EMPLEADO + " INTEGER ,"
                + Contrato.Orden.FECHA + " TEXT ,"
                + Contrato.Orden.PRIORIDAD + " TEXT , "
                + Contrato.Orden.SINTOMA + " TEXT , "
                + Contrato.Orden.UBICACION + " TEXT , "
                + Contrato.Orden.DESCRIPCION + " TEXT , "
                + Contrato.Orden.ESTADO + " TEXT ,"
                + Contrato.Orden.CONTIENE_IMAGEN + " INTEGER "
                + "); "
        );

        //Tabla Usuario-----------------------------------------------------------------------------

        db.execSQL("CREATE TABLE "
                + Contrato.Usuario.NOMBRE_TABLA
                + "(_id INTEGER PRIMARY KEY ON CONFLICT ROLLBACK , "
                + Contrato.Usuario.CODIGO_USUARIO + " INTEGER UNIQUE,"
                + Contrato.Usuario.NOMBRE_USUARIO + " TEXT ,"
                + Contrato.Usuario.ADMIN_USUARIO + " TEXT "
                + "); "
        );

        //Tabla Tarea-----------------------------------------------------------------------------

        db.execSQL("CREATE TABLE "
                + Contrato.Tarea.NOMBRE_TABLA
                + "(_id LONG PRIMARY KEY ON CONFLICT ROLLBACK , "
                + Contrato.Tarea.ID_ORDEN + " LONG ,"
                + Contrato.Tarea.FECHA_INICIO + " TEXT ,"
                + Contrato.Tarea.FECHA_FIN + " TEXT ,"
                + Contrato.Tarea.DESCRIPCION + " TEXT "
                + "); "
        );
        //Tabla operarios-----------------------------------------------------------------------------

        db.execSQL("CREATE TABLE "
                + Contrato.Operarios.NOMBRE_TABLA
                + "(_id INTEGER PRIMARY KEY ON CONFLICT ROLLBACK AUTOINCREMENT, "
                + Contrato.Operarios.ID_TAREA + " LONG ,"
                + Contrato.Operarios.ID_USUARIO + " INTEGER "
                + "); "
        );

        //Tabla BitacoraOrden----------------------------------------------------------------------------

        db.execSQL("CREATE TABLE "
                + Contrato.BitacoraOrden.NOMBRE_TABLA
                + "(_id INTEGER PRIMARY KEY ON CONFLICT ROLLBACK AUTOINCREMENT, "
                + Contrato.BitacoraOrden.ID_ORDEN + " INTEGER ,"
                + Contrato.BitacoraOrden.OPERACION + " INTEGER "
                + "); "
        );

        //Tabla BitacoraUsuario----------------------------------------------------------------------------

        db.execSQL("CREATE TABLE "
                + Contrato.BitacoraUsuario.NOMBRE_TABLA
                + "(_id INTEGER PRIMARY KEY ON CONFLICT ROLLBACK , "
                + Contrato.BitacoraUsuario.ID_USUARIO + " INTEGER ,"
                + Contrato.BitacoraUsuario.OPERACION + " INTEGER "
                + "); "
        );
        //Tabla BitacoraTarea----------------------------------------------------------------------------

        db.execSQL("CREATE TABLE "
                + Contrato.BitacoraTarea.NOMBRE_TABLA
                + "(_id INTEGER PRIMARY KEY ON CONFLICT ROLLBACK , "
                + Contrato.BitacoraTarea.ID_TAREA + " INTEGER ,"
                + Contrato.BitacoraTarea.OPERACION + " INTEGER "
                + "); "
        );

        //Tabla BitacoraOperarios----------------------------------------------------------------------------

        db.execSQL("CREATE TABLE "
                + Contrato.BitacoraOperarios.NOMBRE_TABLA
                + "(_id INTEGER PRIMARY KEY ON CONFLICT ROLLBACK , "
                + Contrato.BitacoraOperarios.ID_OPERARIOS + " INTEGER ,"
                + Contrato.BitacoraOperarios.OPERACION + " INTEGER "
                + "); "
        );
        //-------------------------------------------------------------------------------

        inicializarDatos(db);

    }


    void inicializarDatos(SQLiteDatabase db) {

        db.execSQL(
                "INSERT INTO " + Contrato.Usuario.NOMBRE_TABLA
                        + " (" + Contrato.Usuario._ID+ ","
                        + Contrato.Usuario.CODIGO_USUARIO + ","
                        + Contrato.Usuario.NOMBRE_USUARIO + ","
                        + Contrato.Usuario.ADMIN_USUARIO + ") "
                        + " VALUES (1,1234,'Admin', 'Si'),(2,9999,'ManNa', 'No')"
        );


    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + Contrato.Orden.NOMBRE_TABLA);
        db.execSQL("DROP TABLE IF EXISTS " + Contrato.Usuario.NOMBRE_TABLA);
        db.execSQL("DROP TABLE IF EXISTS " + Contrato.Tarea.NOMBRE_TABLA);
        db.execSQL("DROP TABLE IF EXISTS " + Contrato.Operarios.NOMBRE_TABLA);
        db.execSQL("DROP TABLE IF EXISTS " + Contrato.BitacoraOrden.NOMBRE_TABLA);
        db.execSQL("DROP TABLE IF EXISTS " + Contrato.BitacoraUsuario.NOMBRE_TABLA);
        db.execSQL("DROP TABLE IF EXISTS " + Contrato.BitacoraTarea.NOMBRE_TABLA);
        db.execSQL("DROP TABLE IF EXISTS " + Contrato.BitacoraOperarios.NOMBRE_TABLA);

        onCreate(db);
    }


}
