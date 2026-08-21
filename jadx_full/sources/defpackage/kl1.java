package defpackage;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Pair;
import io.sentry.android.core.a1;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kl1 extends SQLiteOpenHelper {
    public static final /* synthetic */ int y0 = 0;
    public final boolean A;
    public boolean X;
    public final l53 Y;
    public boolean Z;
    public final Context b;
    public final zf2 f;
    public final t6 z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kl1(Context context, String str, final zf2 zf2Var, final t6 t6Var, boolean z) {
        String string;
        super(context, str, null, t6Var.f, new DatabaseErrorHandler() { // from class: hl1
            @Override // android.database.DatabaseErrorHandler
            public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
                int i = kl1.y0;
                sQLiteDatabase.getClass();
                zf2 zf2Var2 = zf2Var;
                gl1 gl1Var = (gl1) zf2Var2.f;
                if (gl1Var == null || !gl1Var.b.equals(sQLiteDatabase)) {
                    gl1Var = new gl1(sQLiteDatabase);
                    zf2Var2.f = gl1Var;
                }
                SQLiteDatabase sQLiteDatabase2 = gl1Var.b;
                t6Var.getClass();
                a1.d("SupportSQLite", "Corruption reported by sqlite on database: " + gl1Var + ".path");
                if (!sQLiteDatabase2.isOpen()) {
                    String path = sQLiteDatabase2.getPath();
                    if (path != null) {
                        t6.i(path);
                        return;
                    }
                    return;
                }
                List<Pair<String, String>> attachedDbs = null;
                try {
                    try {
                        attachedDbs = sQLiteDatabase2.getAttachedDbs();
                    } finally {
                        if (attachedDbs != null) {
                            Iterator<T> it = attachedDbs.iterator();
                            while (it.hasNext()) {
                                Object obj = ((Pair) it.next()).second;
                                obj.getClass();
                                t6.i((String) obj);
                            }
                        } else {
                            String path2 = sQLiteDatabase2.getPath();
                            if (path2 != null) {
                                t6.i(path2);
                            }
                        }
                    }
                } catch (SQLiteException unused) {
                }
                try {
                    gl1Var.close();
                } catch (IOException unused2) {
                }
                if (attachedDbs != null) {
                    return;
                }
            }
        });
        context.getClass();
        t6Var.getClass();
        this.b = context;
        this.f = zf2Var;
        this.z = t6Var;
        this.A = z;
        if (str == null) {
            string = UUID.randomUUID().toString();
            string.getClass();
        } else {
            string = str;
        }
        this.Y = new l53(string, context.getCacheDir(), false);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public final void close() {
        l53 l53Var = this.Y;
        try {
            l53Var.a(l53Var.a);
            super.close();
            this.f.f = null;
            this.Z = false;
        } finally {
            l53Var.b();
        }
    }

    public final gl1 g(boolean z) {
        l53 l53Var = this.Y;
        try {
            l53Var.a((this.Z || getDatabaseName() == null) ? false : true);
            this.X = false;
            SQLiteDatabase sQLiteDatabaseS = s(z);
            if (!this.X) {
                gl1 gl1VarN = n(sQLiteDatabaseS);
                l53Var.b();
                return gl1VarN;
            }
            close();
            gl1 gl1VarG = g(z);
            l53Var.b();
            return gl1VarG;
        } catch (Throwable th) {
            l53Var.b();
            throw th;
        }
    }

    public final gl1 n(SQLiteDatabase sQLiteDatabase) {
        zf2 zf2Var = this.f;
        gl1 gl1Var = (gl1) zf2Var.f;
        if (gl1Var != null && gl1Var.b.equals(sQLiteDatabase)) {
            return gl1Var;
        }
        gl1 gl1Var2 = new gl1(sQLiteDatabase);
        zf2Var.f = gl1Var2;
        return gl1Var2;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onConfigure(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.getClass();
        boolean z = this.X;
        t6 t6Var = this.z;
        if (!z && t6Var.f != sQLiteDatabase.getVersion()) {
            sQLiteDatabase.setMaxSqlCacheSize(1);
        }
        try {
            n(sQLiteDatabase);
            t6Var.getClass();
        } catch (Throwable th) {
            throw new il1(jl1.b, th);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.getClass();
        try {
            ((ew) this.z.z).e(new c64(n(sQLiteDatabase)));
        } catch (Throwable th) {
            throw new il1(jl1.f, th);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.getClass();
        this.X = true;
        try {
            this.z.n(n(sQLiteDatabase), i, i2);
        } catch (Throwable th) {
            throw new il1(jl1.A, th);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.getClass();
        if (!this.X) {
            try {
                t6 t6Var = this.z;
                gl1 gl1VarN = n(sQLiteDatabase);
                ew ewVar = (ew) t6Var.z;
                ewVar.g(new c64(gl1VarN));
                ewVar.g = gl1VarN;
            } catch (Throwable th) {
                throw new il1(jl1.X, th);
            }
        }
        this.Z = true;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.getClass();
        this.X = true;
        try {
            this.z.n(n(sQLiteDatabase), i, i2);
        } catch (Throwable th) {
            throw new il1(jl1.z, th);
        }
    }

    public final SQLiteDatabase s(boolean z) throws Throwable {
        SQLiteDatabase readableDatabase;
        SQLiteDatabase readableDatabase2;
        File parentFile;
        String databaseName = getDatabaseName();
        boolean z2 = this.Z;
        Context context = this.b;
        if (databaseName != null && !z2 && (parentFile = context.getDatabasePath(databaseName).getParentFile()) != null) {
            parentFile.mkdirs();
            if (!parentFile.isDirectory()) {
                a1.n("SupportSQLite", "Invalid database parent file, not a directory: " + parentFile);
            }
        }
        try {
            if (z) {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.getClass();
                return writableDatabase;
            }
            SQLiteDatabase readableDatabase3 = getReadableDatabase();
            readableDatabase3.getClass();
            return readableDatabase3;
        } catch (Throwable unused) {
            try {
                Thread.sleep(500L);
            } catch (InterruptedException unused2) {
            }
            try {
                if (z) {
                    readableDatabase2 = getWritableDatabase();
                    readableDatabase2.getClass();
                } else {
                    readableDatabase2 = getReadableDatabase();
                    readableDatabase2.getClass();
                }
                return readableDatabase2;
            } catch (Throwable th) {
                th = th;
                if (th instanceof il1) {
                    il1 il1Var = (il1) th;
                    int iOrdinal = il1Var.b.ordinal();
                    th = il1Var.f;
                    if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3) {
                        throw th;
                    }
                    if (iOrdinal != 4) {
                        g.d();
                        return null;
                    }
                    if (!(th instanceof SQLiteException)) {
                        throw th;
                    }
                }
                if (!(th instanceof SQLiteException) || databaseName == null || !this.A) {
                    throw th;
                }
                context.deleteDatabase(databaseName);
                try {
                    if (z) {
                        readableDatabase = getWritableDatabase();
                        readableDatabase.getClass();
                    } else {
                        readableDatabase = getReadableDatabase();
                        readableDatabase.getClass();
                    }
                    return readableDatabase;
                } catch (il1 e) {
                    throw e.f;
                }
            }
        }
    }
}
