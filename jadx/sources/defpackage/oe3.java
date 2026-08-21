package defpackage;

import android.os.Bundle;
import java.lang.ref.Reference;
import java.util.ArrayList;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public defpackage.w75 c(java.lang.String r22, defpackage.w75 r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 629
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.oe3.c(java.lang.String, w75):w75");
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
