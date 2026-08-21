package defpackage;

import android.database.sqlite.SQLiteProgram;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ml1 implements i64 {
    public final SQLiteProgram b;

    public ml1(SQLiteProgram sQLiteProgram) {
        this.b = sQLiteProgram;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.b.close();
    }

    @Override // defpackage.i64
    public final void j(int i, long j) {
        this.b.bindLong(i, j);
    }

    @Override // defpackage.i64
    public final void k(int i, byte[] bArr) {
        this.b.bindBlob(i, bArr);
    }

    @Override // defpackage.i64
    public final void l(int i) {
        this.b.bindNull(i);
    }

    @Override // defpackage.i64
    public final void r(int i, String str) {
        str.getClass();
        this.b.bindString(i, str);
    }

    @Override // defpackage.i64
    public final void z(int i, double d) {
        this.b.bindDouble(i, d);
    }
}
