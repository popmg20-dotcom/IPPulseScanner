package defpackage;

import j$.util.DesugarCollections;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class dv0 {
    public long a;
    public final String b;
    public final String c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;
    public final List h;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.util.List] */
    public dv0(String str, ju juVar) {
        String str2 = juVar.b;
        long j = juVar.c;
        long j2 = juVar.d;
        long j3 = juVar.e;
        long j4 = juVar.f;
        ?? arrayList = juVar.h;
        if (arrayList == 0) {
            Map map = juVar.g;
            arrayList = new ArrayList(map.size());
            for (Map.Entry entry : map.entrySet()) {
                arrayList.add(new ir1((String) entry.getKey(), (String) entry.getValue()));
            }
        }
        this(str, str2, j, j2, j3, j4, arrayList);
    }

    public static dv0 a(ev0 ev0Var) throws IOException {
        if (fv0.p(ev0Var) != 538247942) {
            throw new IOException();
        }
        String strR = fv0.r(ev0Var);
        String strR2 = fv0.r(ev0Var);
        long jQ = fv0.q(ev0Var);
        long jQ2 = fv0.q(ev0Var);
        long jQ3 = fv0.q(ev0Var);
        long jQ4 = fv0.q(ev0Var);
        int iP = fv0.p(ev0Var);
        if (iP < 0) {
            vp1.i(dw2.A(iP, "readHeaderList size="));
            return null;
        }
        List arrayList = iP == 0 ? Collections.EMPTY_LIST : new ArrayList();
        for (int i = 0; i < iP; i++) {
            arrayList.add(new ir1(fv0.r(ev0Var).intern(), fv0.r(ev0Var).intern()));
        }
        return new dv0(strR, strR2, jQ, jQ2, jQ3, jQ4, arrayList);
    }

    public final ju b(byte[] bArr) {
        ju juVar = new ju();
        juVar.a = bArr;
        juVar.b = this.c;
        juVar.c = this.d;
        juVar.d = this.e;
        juVar.e = this.f;
        juVar.f = this.g;
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        List<ir1> list = this.h;
        for (ir1 ir1Var : list) {
            treeMap.put(ir1Var.a, ir1Var.b);
        }
        juVar.g = treeMap;
        juVar.h = DesugarCollections.unmodifiableList(list);
        return juVar;
    }

    public final boolean c(BufferedOutputStream bufferedOutputStream) {
        try {
            fv0.u(bufferedOutputStream, 538247942);
            fv0.w(bufferedOutputStream, this.b);
            String str = this.c;
            if (str == null) {
                str = "";
            }
            fv0.w(bufferedOutputStream, str);
            fv0.v(bufferedOutputStream, this.d);
            fv0.v(bufferedOutputStream, this.e);
            fv0.v(bufferedOutputStream, this.f);
            fv0.v(bufferedOutputStream, this.g);
            List<ir1> list = this.h;
            if (list != null) {
                fv0.u(bufferedOutputStream, list.size());
                for (ir1 ir1Var : list) {
                    fv0.w(bufferedOutputStream, ir1Var.a);
                    fv0.w(bufferedOutputStream, ir1Var.b);
                }
            } else {
                fv0.u(bufferedOutputStream, 0);
            }
            bufferedOutputStream.flush();
            return true;
        } catch (IOException e) {
            qs4.b("%s", e.toString());
            return false;
        }
    }

    public dv0(String str, String str2, long j, long j2, long j3, long j4, List list) {
        this.b = str;
        this.c = "".equals(str2) ? null : str2;
        this.d = j;
        this.e = j2;
        this.f = j3;
        this.g = j4;
        this.h = list;
    }
}
