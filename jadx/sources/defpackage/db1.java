package defpackage;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class db1 extends p95 {
    public final Object n;
    public final String o;
    public final String p;
    public final uo4 q;
    public final w9 r;

    public db1(Object obj, String str, String str2, d7 d7Var, uo4 uo4Var) {
        Collection collectionX;
        this.n = obj;
        this.o = str;
        this.p = str2;
        this.q = uo4Var;
        w9 w9Var = new w9(str2 + " value: " + obj);
        StackTraceElement[] stackTrace = w9Var.getStackTrace();
        stackTrace.getClass();
        int length = stackTrace.length + (-2);
        length = length < 0 ? 0 : length;
        if (length < 0) {
            e04.f(ha0.k("Requested element count ", length, " is less than zero."));
            throw null;
        }
        if (length == 0) {
            collectionX = g41.b;
        } else {
            int length2 = stackTrace.length;
            if (length >= length2) {
                collectionX = qe.s0(stackTrace);
            } else if (length == 1) {
                collectionX = p95.x(stackTrace[length2 - 1]);
            } else {
                ArrayList arrayList = new ArrayList(length);
                for (int i = length2 - length; i < length2; i++) {
                    arrayList.add(stackTrace[i]);
                }
                collectionX = arrayList;
            }
        }
        w9Var.setStackTrace((StackTraceElement[]) collectionX.toArray(new StackTraceElement[0]));
        this.r = w9Var;
    }

    @Override // defpackage.p95
    public final Object g() throws w9 {
        int iOrdinal = this.q.ordinal();
        if (iOrdinal == 0) {
            throw this.r;
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                return null;
            }
            g.d();
            return null;
        }
        Log.d(this.o, this.p + " value: " + this.n);
        return null;
    }

    @Override // defpackage.p95
    public final p95 B(String str, am1 am1Var) {
        return this;
    }
}
