package defpackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i65 extends u55 {
    public static final String[] y0 = {"app_version", "ALTER TABLE messages ADD COLUMN app_version TEXT;", "app_version_int", "ALTER TABLE messages ADD COLUMN app_version_int INTEGER;"};
    public final k25 Y;
    public boolean Z;

    public i65(k85 k85Var) {
        super(k85Var);
        this.Y = new k25(this, ((k85) this.f).b);
    }

    @Override // defpackage.u55
    public final boolean Y0() {
        return false;
    }

    public final void Z0() {
        int iDelete;
        k85 k85Var = (k85) this.f;
        V0();
        try {
            SQLiteDatabase sQLiteDatabaseB1 = b1();
            if (sQLiteDatabaseB1 == null || (iDelete = sQLiteDatabaseB1.delete("messages", null, null)) <= 0) {
                return;
            }
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.H0.b(Integer.valueOf(iDelete), "Reset local analytics data. records");
        } catch (SQLiteException e) {
            t65 t65Var2 = k85Var.Y;
            k85.h(t65Var2);
            t65Var2.z0.b(e, "Error resetting local analytics data. error");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0070 A[PHI: r5
      0x0070: PHI (r5v4 int) = (r5v1 int), (r5v2 int), (r5v1 int) binds: [B:32:0x0081, B:28:0x006e, B:25:0x0067] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a1() {
        k85 k85Var = (k85) this.f;
        V0();
        if (!this.Z && k85Var.b.getDatabasePath("google_app_measurement_local.db").exists()) {
            int i = 5;
            int i2 = 0;
            while (true) {
                if (i2 >= 5) {
                    t65 t65Var = k85Var.Y;
                    k85.h(t65Var);
                    t65Var.C0.a("Error deleting app launch break from local database in reasonable time");
                    break;
                }
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    try {
                        SQLiteDatabase sQLiteDatabaseB1 = b1();
                        if (sQLiteDatabaseB1 != null) {
                            sQLiteDatabaseB1.beginTransaction();
                            sQLiteDatabaseB1.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                            sQLiteDatabaseB1.setTransactionSuccessful();
                            sQLiteDatabaseB1.endTransaction();
                            sQLiteDatabaseB1.close();
                            return true;
                        }
                        this.Z = true;
                    } catch (SQLiteException e) {
                        if (0 != 0) {
                            try {
                                if (sQLiteDatabase.inTransaction()) {
                                    sQLiteDatabase.endTransaction();
                                }
                            } catch (Throwable th) {
                                if (0 != 0) {
                                    sQLiteDatabase.close();
                                }
                                throw th;
                            }
                        }
                        t65 t65Var2 = k85Var.Y;
                        k85.h(t65Var2);
                        t65Var2.z0.b(e, "Error deleting app launch break from local database");
                        this.Z = true;
                        if (0 != 0) {
                            sQLiteDatabase.close();
                            i2++;
                        } else {
                            i2++;
                        }
                    }
                } catch (SQLiteDatabaseLockedException unused) {
                    SystemClock.sleep(i);
                    i += 20;
                    if (0 != 0) {
                        sQLiteDatabase.close();
                    }
                    i2++;
                } catch (SQLiteFullException e2) {
                    t65 t65Var3 = k85Var.Y;
                    k85.h(t65Var3);
                    t65Var3.z0.b(e2, "Error deleting app launch break from local database");
                    this.Z = true;
                    if (0 != 0) {
                    }
                    i2++;
                }
                i2++;
            }
        }
        return false;
    }

    public final SQLiteDatabase b1() {
        if (this.Z) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.Y.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.Z = true;
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x0170 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0170 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0170 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ae A[Catch: SQLiteException -> 0x0093, SQLiteDatabaseLockedException -> 0x009a, SQLiteFullException -> 0x009e, all -> 0x0154, TRY_ENTER, TryCatch #10 {all -> 0x0154, blocks: (B:30:0x0088, B:32:0x008e, B:43:0x00ae, B:45:0x00cf, B:47:0x00d8, B:49:0x00de, B:59:0x00f8, B:73:0x0120, B:75:0x0126, B:76:0x0129, B:93:0x015b, B:83:0x0144), top: B:109:0x0088 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0120 A[Catch: all -> 0x0154, TRY_ENTER, TryCatch #10 {all -> 0x0154, blocks: (B:30:0x0088, B:32:0x008e, B:43:0x00ae, B:45:0x00cf, B:47:0x00d8, B:49:0x00de, B:59:0x00f8, B:73:0x0120, B:75:0x0126, B:76:0x0129, B:93:0x015b, B:83:0x0144), top: B:109:0x0088 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0150 A[PHI: r8 r10 r17
      0x0150: PHI (r8v5 int) = (r8v3 int), (r8v3 int), (r8v6 int) binds: [B:79:0x013c, B:96:0x016d, B:87:0x014e] A[DONT_GENERATE, DONT_INLINE]
      0x0150: PHI (r10v7 android.database.sqlite.SQLiteDatabase) = 
      (r10v5 android.database.sqlite.SQLiteDatabase)
      (r10v6 android.database.sqlite.SQLiteDatabase)
      (r10v8 android.database.sqlite.SQLiteDatabase)
     binds: [B:79:0x013c, B:96:0x016d, B:87:0x014e] A[DONT_GENERATE, DONT_INLINE]
      0x0150: PHI (r17v7 boolean) = (r17v4 boolean), (r17v5 boolean), (r17v8 boolean) binds: [B:79:0x013c, B:96:0x016d, B:87:0x014e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x016a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean c1(int i, byte[] bArr) {
        SQLiteDatabase sQLiteDatabaseB1;
        boolean z;
        boolean z2;
        Cursor cursorRawQuery;
        k85 k85Var = (k85) this.f;
        V0();
        boolean z3 = false;
        z3 = false;
        if (!this.Z) {
            x15 x15Var = k85Var.A;
            t65 t65Var = k85Var.Y;
            q55 q55Var = r55.c1;
            Cursor cursor = null;
            cursor = null;
            tg5 tg5VarZ0 = x15Var.f1(null, q55Var) ? k85Var.l().Z0(null) : null;
            ContentValues contentValues = new ContentValues();
            contentValues.put("type", Integer.valueOf(i));
            contentValues.put("entry", bArr);
            if (k85Var.A.f1(null, q55Var) && tg5VarZ0 != null) {
                contentValues.put("app_version", tg5VarZ0.z);
                contentValues.put("app_version_int", Long.valueOf(tg5VarZ0.A0));
            }
            int i2 = 5;
            int i3 = 0;
            for (int i4 = 5; i3 < i4; i4 = 5) {
                try {
                    sQLiteDatabaseB1 = b1();
                } catch (SQLiteDatabaseLockedException unused) {
                    z = z3 ? 1 : 0;
                    sQLiteDatabaseB1 = null;
                    cursorRawQuery = null;
                } catch (SQLiteFullException e) {
                    e = e;
                    z = z3 ? 1 : 0;
                    sQLiteDatabaseB1 = null;
                    cursorRawQuery = null;
                } catch (SQLiteException e2) {
                    e = e2;
                    z = z3 ? 1 : 0;
                    z2 = true;
                    sQLiteDatabaseB1 = null;
                    cursorRawQuery = null;
                } catch (Throwable th) {
                    th = th;
                    sQLiteDatabaseB1 = null;
                }
                if (sQLiteDatabaseB1 == null) {
                    this.Z = true;
                } else {
                    try {
                        sQLiteDatabaseB1.beginTransaction();
                        cursorRawQuery = sQLiteDatabaseB1.rawQuery("select count(1) from messages", null);
                        long j = 0;
                        if (cursorRawQuery == null) {
                            if (j < 100000) {
                            }
                            sQLiteDatabaseB1.insertOrThrow("messages", null, contentValues);
                            sQLiteDatabaseB1.setTransactionSuccessful();
                            sQLiteDatabaseB1.endTransaction();
                            if (cursorRawQuery != null) {
                            }
                            sQLiteDatabaseB1.close();
                            return z2;
                        }
                        try {
                            try {
                                if (cursorRawQuery.moveToFirst()) {
                                    j = cursorRawQuery.getLong(z3 ? 1 : 0);
                                }
                                if (j < 100000) {
                                    k85.h(t65Var);
                                    t65Var.z0.a("Data loss, local db full");
                                    long j2 = 100001 - j;
                                    long jDelete = sQLiteDatabaseB1.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", new String[]{Long.toString(j2)});
                                    if (jDelete != j2) {
                                        k85.h(t65Var);
                                        q65 q65Var = t65Var.z0;
                                        z = z3 ? 1 : 0;
                                        try {
                                            try {
                                                z2 = true;
                                            } catch (SQLiteDatabaseLockedException unused2) {
                                                SystemClock.sleep(i2);
                                                i2 += 20;
                                                if (cursorRawQuery != null) {
                                                    cursorRawQuery.close();
                                                }
                                                if (sQLiteDatabaseB1 == null) {
                                                    sQLiteDatabaseB1.close();
                                                }
                                                i3++;
                                                z3 = z;
                                            }
                                        } catch (SQLiteFullException e3) {
                                            e = e3;
                                            k85.h(t65Var);
                                            t65Var.z0.b(e, "Error writing entry; local database full");
                                            this.Z = true;
                                            if (cursorRawQuery != null) {
                                                cursorRawQuery.close();
                                            }
                                            if (sQLiteDatabaseB1 != null) {
                                            }
                                            i3++;
                                            z3 = z;
                                        } catch (SQLiteException e4) {
                                            e = e4;
                                            z2 = true;
                                            if (sQLiteDatabaseB1 != null && sQLiteDatabaseB1.inTransaction()) {
                                                sQLiteDatabaseB1.endTransaction();
                                            }
                                            k85.h(t65Var);
                                            t65Var.z0.b(e, "Error writing entry to local database");
                                            this.Z = z2;
                                            if (cursorRawQuery != null) {
                                                cursorRawQuery.close();
                                            }
                                            if (sQLiteDatabaseB1 != null) {
                                            }
                                            i3++;
                                            z3 = z;
                                        }
                                        try {
                                            q65Var.d("Different delete count than expected in local db. expected, received, difference", Long.valueOf(j2), Long.valueOf(jDelete), Long.valueOf(j2 - jDelete));
                                        } catch (SQLiteFullException e5) {
                                            e = e5;
                                            k85.h(t65Var);
                                            t65Var.z0.b(e, "Error writing entry; local database full");
                                            this.Z = true;
                                            if (cursorRawQuery != null) {
                                            }
                                            if (sQLiteDatabaseB1 != null) {
                                            }
                                            i3++;
                                            z3 = z;
                                        } catch (SQLiteException e6) {
                                            e = e6;
                                            if (sQLiteDatabaseB1 != null) {
                                                sQLiteDatabaseB1.endTransaction();
                                            }
                                            k85.h(t65Var);
                                            t65Var.z0.b(e, "Error writing entry to local database");
                                            this.Z = z2;
                                            if (cursorRawQuery != null) {
                                            }
                                            if (sQLiteDatabaseB1 != null) {
                                            }
                                            i3++;
                                            z3 = z;
                                        }
                                    } else {
                                        z = z3 ? 1 : 0;
                                        z2 = true;
                                    }
                                }
                                sQLiteDatabaseB1.insertOrThrow("messages", null, contentValues);
                                sQLiteDatabaseB1.setTransactionSuccessful();
                                sQLiteDatabaseB1.endTransaction();
                                if (cursorRawQuery != null) {
                                    cursorRawQuery.close();
                                }
                                sQLiteDatabaseB1.close();
                                return z2;
                            } catch (Throwable th2) {
                                th = th2;
                                cursor = cursorRawQuery;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (sQLiteDatabaseB1 != null) {
                                    sQLiteDatabaseB1.close();
                                }
                                throw th;
                            }
                        } catch (SQLiteDatabaseLockedException unused3) {
                            z = z3 ? 1 : 0;
                            SystemClock.sleep(i2);
                            i2 += 20;
                            if (cursorRawQuery != null) {
                            }
                            if (sQLiteDatabaseB1 == null) {
                            }
                            i3++;
                            z3 = z;
                        } catch (SQLiteFullException e7) {
                            e = e7;
                            z = z3 ? 1 : 0;
                            k85.h(t65Var);
                            t65Var.z0.b(e, "Error writing entry; local database full");
                            this.Z = true;
                            if (cursorRawQuery != null) {
                            }
                            if (sQLiteDatabaseB1 != null) {
                            }
                            i3++;
                            z3 = z;
                        } catch (SQLiteException e8) {
                            e = e8;
                            z = z3 ? 1 : 0;
                            z2 = true;
                            if (sQLiteDatabaseB1 != null) {
                            }
                            k85.h(t65Var);
                            t65Var.z0.b(e, "Error writing entry to local database");
                            this.Z = z2;
                            if (cursorRawQuery != null) {
                            }
                            if (sQLiteDatabaseB1 != null) {
                            }
                            i3++;
                            z3 = z;
                        }
                    } catch (SQLiteDatabaseLockedException unused4) {
                        z = z3 ? 1 : 0;
                        cursorRawQuery = null;
                    } catch (SQLiteFullException e9) {
                        e = e9;
                        z = z3 ? 1 : 0;
                        cursorRawQuery = null;
                    } catch (SQLiteException e10) {
                        e = e10;
                        z = z3 ? 1 : 0;
                        z2 = true;
                        cursorRawQuery = null;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    i3++;
                    z3 = z;
                }
            }
            boolean z4 = z3 ? 1 : 0;
            k85.h(t65Var);
            t65Var.H0.a("Failed to write entry to local database");
            return z4;
        }
        return z3;
    }
}
