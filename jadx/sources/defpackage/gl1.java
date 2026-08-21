package defpackage;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gl1 implements Closeable {
    public final SQLiteDatabase b;
    public static final String[] f = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    public static final String[] z = new String[0];
    public static final z82 A = ek0.v(new t4(5));
    public static final z82 X = ek0.v(new t4(6));

    public gl1(SQLiteDatabase sQLiteDatabase) {
        this.b = sQLiteDatabase;
    }

    public final void C(String str) {
        this.b.execSQL(str);
    }

    public final void F(Object[] objArr) {
        this.b.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", objArr);
    }

    public final boolean I() {
        return this.b.inTransaction();
    }

    public final void M() {
        this.b.setTransactionSuccessful();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.b.close();
    }

    public final void g() {
        this.b.beginTransaction();
    }

    public final void n() {
        this.b.beginTransactionNonExclusive();
    }

    public final nl1 s(String str) {
        str.getClass();
        SQLiteStatement sQLiteStatementCompileStatement = this.b.compileStatement(str);
        sQLiteStatementCompileStatement.getClass();
        return new nl1(sQLiteStatementCompileStatement);
    }

    public final void x() {
        this.b.endTransaction();
    }
}
