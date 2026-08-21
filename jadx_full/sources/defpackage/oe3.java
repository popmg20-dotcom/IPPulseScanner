package defpackage;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import java.io.IOException;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class oe3 {
    public final /* synthetic */ int a = 1;
    public long b;
    public Object c;
    public Object d;
    public final Object e;

    public oe3(ab4 ab4Var) {
        TimeUnit.MINUTES.getClass();
        this.b = 300000000000L;
        this.c = ab4Var.d();
        this.d = new ne3(this, fw.y(new StringBuilder(), jz4.b, " ConnectionPool connection closer"));
        this.e = new ConcurrentLinkedQueue();
    }

    public static oe3 b(z25 z25Var) {
        String str = z25Var.b;
        String str2 = z25Var.z;
        return new oe3(z25Var.A, z25Var.f.l(), str, str2);
    }

    public int a(me3 me3Var, long j) {
        TimeZone timeZone = jz4.a;
        ArrayList arrayList = me3Var.p;
        int i = 0;
        while (i < arrayList.size()) {
            Reference reference = (Reference) arrayList.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                String str = "A connection to " + me3Var.c.a.i + " was leaked. Did you forget to close a response body?";
                k13 k13Var = k13.a;
                k13.a.j(((je3) reference).a, str);
                arrayList.remove(i);
                if (arrayList.isEmpty()) {
                    me3Var.q = j - this.b;
                    return 0;
                }
            }
        }
        return arrayList.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fe A[PHI: r7 r16 r17
      0x00fe: PHI (r7v1 android.database.Cursor) = (r7v2 android.database.Cursor), (r7v4 android.database.Cursor) binds: [B:61:0x0129, B:46:0x00f7] A[DONT_GENERATE, DONT_INLINE]
      0x00fe: PHI (r16v5 w75) = (r16v7 w75), (r16v11 w75) binds: [B:61:0x0129, B:46:0x00f7] A[DONT_GENERATE, DONT_INLINE]
      0x00fe: PHI (r17v2 long) = (r17v4 long), (r17v7 long) binds: [B:61:0x0129, B:46:0x00f7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x012e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public w75 c(String str, w75 w75Var) throws Throwable {
        Cursor cursor;
        w75 w75Var2;
        long j;
        Cursor cursorRawQuery;
        Pair pair;
        Object obj;
        Pair pair2;
        String strQ = w75Var.q();
        List listN = w75Var.n();
        e15 e15Var = (e15) this.e;
        ff5 ff5Var = e15Var.X;
        k85 k85Var = (k85) e15Var.f;
        ff5Var.h0();
        b85 b85VarD1 = z65.d1("_eid", w75Var);
        Long l = (Long) (b85VarD1 == null ? null : z65.k1(b85VarD1));
        if (l != null) {
            if (strQ.equals("_ep")) {
                ff5Var.h0();
                b85 b85VarD12 = z65.d1("_en", w75Var);
                String str2 = (String) (b85VarD12 == null ? null : z65.k1(b85VarD12));
                if (TextUtils.isEmpty(str2)) {
                    t65 t65Var = k85Var.Y;
                    k85.h(t65Var);
                    t65Var.A0.b(l, "Extra parameter without an event name. eventId");
                    return null;
                }
                if (((w75) this.c) == null || ((Long) this.d) == null || l.longValue() != ((Long) this.d).longValue()) {
                    m25 m25Var = ff5Var.z;
                    ff5.R(m25Var);
                    k85 k85Var2 = (k85) m25Var.f;
                    m25Var.V0();
                    m25Var.W0();
                    try {
                        cursorRawQuery = m25Var.K1().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, l.toString()});
                        try {
                            try {
                                if (cursorRawQuery.moveToFirst()) {
                                    w75Var2 = null;
                                    try {
                                        try {
                                            Pair pairCreate = Pair.create((w75) ((v75) z65.I1(w75.x(), cursorRawQuery.getBlob(0))).e(), Long.valueOf(cursorRawQuery.getLong(1)));
                                            cursorRawQuery.close();
                                            pair2 = pairCreate;
                                        } catch (SQLiteException e) {
                                            e = e;
                                            j = 0;
                                            t65 t65Var2 = k85Var2.Y;
                                            k85.h(t65Var2);
                                            t65Var2.z0.b(e, "Error selecting main event");
                                            if (cursorRawQuery != null) {
                                            }
                                            pair = w75Var2;
                                            if (pair != 0) {
                                            }
                                            t65 t65Var3 = k85Var.Y;
                                            k85.h(t65Var3);
                                            t65Var3.A0.c("Extra parameter without existing main event. eventName, eventId", str2, l);
                                            return w75Var2;
                                        }
                                    } catch (IOException e2) {
                                        t65 t65Var4 = k85Var2.Y;
                                        k85.h(t65Var4);
                                        j = 0;
                                        try {
                                            t65Var4.z0.d("Failed to merge main event. appId, eventId", t65.Z0(str), l, e2);
                                        } catch (SQLiteException e3) {
                                            e = e3;
                                            t65 t65Var22 = k85Var2.Y;
                                            k85.h(t65Var22);
                                            t65Var22.z0.b(e, "Error selecting main event");
                                            if (cursorRawQuery != null) {
                                                cursorRawQuery.close();
                                            }
                                            pair = w75Var2;
                                            if (pair != 0) {
                                            }
                                            t65 t65Var32 = k85Var.Y;
                                            k85.h(t65Var32);
                                            t65Var32.A0.c("Extra parameter without existing main event. eventName, eventId", str2, l);
                                            return w75Var2;
                                        }
                                        cursorRawQuery.close();
                                        pair = w75Var2;
                                    }
                                } else {
                                    t65 t65Var5 = k85Var2.Y;
                                    k85.h(t65Var5);
                                    t65Var5.H0.a("Main event not found");
                                    cursorRawQuery.close();
                                    pair2 = null;
                                    w75Var2 = null;
                                }
                                j = 0;
                                pair = pair2;
                            } catch (SQLiteException e4) {
                                e = e4;
                                w75Var2 = null;
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor = cursorRawQuery;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    } catch (SQLiteException e5) {
                        e = e5;
                        w75Var2 = null;
                        j = 0;
                        cursorRawQuery = null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = null;
                    }
                    if (pair != 0 || (obj = pair.first) == null) {
                        t65 t65Var322 = k85Var.Y;
                        k85.h(t65Var322);
                        t65Var322.A0.c("Extra parameter without existing main event. eventName, eventId", str2, l);
                        return w75Var2;
                    }
                    this.c = (w75) obj;
                    this.b = ((Long) pair.second).longValue();
                    ff5Var.h0();
                    this.d = (Long) z65.e1("_eid", (w75) this.c);
                } else {
                    j = 0;
                }
                long j2 = this.b - 1;
                this.b = j2;
                if (j2 <= j) {
                    m25 m25Var2 = ff5Var.z;
                    ff5.R(m25Var2);
                    k85 k85Var3 = (k85) m25Var2.f;
                    m25Var2.V0();
                    t65 t65Var6 = k85Var3.Y;
                    k85.h(t65Var6);
                    t65Var6.H0.b(str, "Clearing complex main event info. appId");
                    try {
                        m25Var2.K1().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                    } catch (SQLiteException e6) {
                        t65 t65Var7 = k85Var3.Y;
                        k85.h(t65Var7);
                        t65Var7.z0.b(e6, "Error clearing complex main event");
                    }
                } else {
                    m25 m25Var3 = ff5Var.z;
                    ff5.R(m25Var3);
                    m25Var3.m1(str, l, this.b, (w75) this.c);
                }
                ArrayList arrayList = new ArrayList();
                for (b85 b85Var : ((w75) this.c).n()) {
                    ff5Var.h0();
                    if (z65.d1(b85Var.o(), w75Var) == null) {
                        arrayList.add(b85Var);
                    }
                }
                if (arrayList.isEmpty()) {
                    t65 t65Var8 = k85Var.Y;
                    k85.h(t65Var8);
                    t65Var8.A0.b(str2, "No unique parameters in main event. eventName");
                } else {
                    arrayList.addAll(listN);
                    listN = arrayList;
                }
                strQ = str2;
            } else {
                this.d = l;
                this.c = w75Var;
                ff5Var.h0();
                b85 b85VarD13 = z65.d1("_epc", w75Var);
                Serializable serializableK1 = b85VarD13 != null ? z65.k1(b85VarD13) : null;
                long jLongValue = ((Long) (serializableK1 != null ? serializableK1 : 0L)).longValue();
                this.b = jLongValue;
                if (jLongValue <= 0) {
                    t65 t65Var9 = k85Var.Y;
                    k85.h(t65Var9);
                    t65Var9.A0.b(strQ, "Complex event with zero extra param count. eventName");
                } else {
                    m25 m25Var4 = ff5Var.z;
                    ff5.R(m25Var4);
                    m25Var4.m1(str, l, this.b, w75Var);
                }
            }
        }
        v75 v75Var = (v75) w75Var.g();
        v75Var.c();
        ((w75) v75Var.f).D(strQ);
        v75Var.c();
        ((w75) v75Var.f).B();
        v75Var.c();
        ((w75) v75Var.f).A(listN);
        return (w75) v75Var.e();
    }

    public z25 d() {
        return new z25((String) this.c, new y25(new Bundle((Bundle) this.e)), (String) this.d, this.b);
    }

    public String toString() {
        switch (this.a) {
            case 1:
                String str = (String) this.d;
                String string = ((Bundle) this.e).toString();
                int length = String.valueOf(str).length();
                String str2 = (String) this.c;
                StringBuilder sb = new StringBuilder(length + 13 + String.valueOf(str2).length() + 8 + string.length());
                ha0.v(sb, "origin=", str, ",name=", str2);
                return fw.y(sb, ",params=", string);
            default:
                return super.toString();
        }
    }

    public oe3(long j, Bundle bundle, String str, String str2) {
        this.c = str;
        this.d = str2;
        this.e = bundle;
        this.b = j;
    }
}
