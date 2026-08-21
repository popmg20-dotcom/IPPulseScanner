package defpackage;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j64 extends l64 {
    public int[] A;
    public long[] X;
    public double[] Y;
    public String[] Z;
    public byte[][] y0;
    public Cursor z0;

    public static void x(Cursor cursor, int i) {
        if (i < 0 || i >= cursor.getColumnCount()) {
            ez4.Y(25, "column index out of range");
            throw null;
        }
    }

    public final Cursor C() {
        Cursor cursor = this.z0;
        if (cursor != null) {
            return cursor;
        }
        ez4.Y(21, "no row");
        throw null;
    }

    @Override // defpackage.io3
    public final boolean C0() {
        g();
        s();
        Cursor cursor = this.z0;
        if (cursor != null) {
            return cursor.moveToNext();
        }
        xe.q("Required value was null.");
        return false;
    }

    @Override // defpackage.io3
    public final void K(int i, String str) {
        str.getClass();
        g();
        n(3, i);
        this.A[i] = 3;
        this.Z[i] = str;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        if (!this.z) {
            g();
            this.A = new int[0];
            this.X = new long[0];
            this.Y = new double[0];
            this.Z = new String[0];
            this.y0 = new byte[0][];
            reset();
        }
        this.z = true;
    }

    @Override // defpackage.io3
    public final String e0(int i) {
        g();
        Cursor cursorC = C();
        x(cursorC, i);
        String string = cursorC.getString(i);
        string.getClass();
        return string;
    }

    @Override // defpackage.io3
    public final byte[] getBlob(int i) {
        g();
        Cursor cursorC = C();
        x(cursorC, i);
        byte[] blob = cursorC.getBlob(i);
        blob.getClass();
        return blob;
    }

    @Override // defpackage.io3
    public final int getColumnCount() {
        g();
        s();
        Cursor cursor = this.z0;
        if (cursor != null) {
            return cursor.getColumnCount();
        }
        return 0;
    }

    @Override // defpackage.io3
    public final String getColumnName(int i) {
        g();
        s();
        Cursor cursor = this.z0;
        if (cursor == null) {
            xe.q("Required value was null.");
            return null;
        }
        x(cursor, i);
        String columnName = cursor.getColumnName(i);
        columnName.getClass();
        return columnName;
    }

    @Override // defpackage.io3
    public final long getLong(int i) {
        g();
        Cursor cursorC = C();
        x(cursorC, i);
        return cursorC.getLong(i);
    }

    @Override // defpackage.io3
    public final boolean isNull(int i) {
        g();
        Cursor cursorC = C();
        x(cursorC, i);
        return cursorC.isNull(i);
    }

    @Override // defpackage.io3
    public final void j(int i, long j) {
        g();
        n(1, i);
        this.A[i] = 1;
        this.X[i] = j;
    }

    @Override // defpackage.io3
    public final void k(int i, byte[] bArr) {
        g();
        n(4, i);
        this.A[i] = 4;
        this.y0[i] = bArr;
    }

    @Override // defpackage.io3
    public final void l(int i) {
        g();
        n(5, i);
        this.A[i] = 5;
    }

    public final void n(int i, int i2) {
        int i3 = i2 + 1;
        int[] iArr = this.A;
        if (iArr.length < i3) {
            this.A = Arrays.copyOf(iArr, i3);
        }
        if (i == 1) {
            long[] jArr = this.X;
            if (jArr.length < i3) {
                this.X = Arrays.copyOf(jArr, i3);
                return;
            }
            return;
        }
        if (i == 2) {
            double[] dArr = this.Y;
            if (dArr.length < i3) {
                this.Y = Arrays.copyOf(dArr, i3);
                return;
            }
            return;
        }
        if (i == 3) {
            String[] strArr = this.Z;
            if (strArr.length < i3) {
                this.Z = (String[]) Arrays.copyOf(strArr, i3);
                return;
            }
            return;
        }
        if (i != 4) {
            return;
        }
        byte[][] bArr = this.y0;
        if (bArr.length < i3) {
            this.y0 = (byte[][]) Arrays.copyOf(bArr, i3);
        }
    }

    @Override // defpackage.io3
    public final void reset() {
        g();
        Cursor cursor = this.z0;
        if (cursor != null) {
            cursor.close();
        }
        this.z0 = null;
    }

    public final void s() {
        if (this.z0 == null) {
            oj1 oj1Var = new oj1(28, this);
            gl1 gl1Var = this.b;
            gl1Var.getClass();
            final el1 el1Var = new el1(0, oj1Var);
            Cursor cursorRawQueryWithFactory = gl1Var.b.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: fl1
                @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
                public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                    return (Cursor) el1Var.i(sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
                }
            }, ((j64) oj1Var.f).f, gl1.z, null);
            cursorRawQueryWithFactory.getClass();
            this.z0 = cursorRawQueryWithFactory;
        }
    }
}
