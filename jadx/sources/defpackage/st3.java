package defpackage;

import android.hardware.camera2.params.InputConfiguration;
import android.util.Range;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class st3 extends ot3 {
    public final id0 j = new id0(4);
    public boolean k = true;
    public final StringBuilder l = new StringBuilder();
    public boolean m = false;
    public final ArrayList n = new ArrayList();

    public final void a(tt3 tt3Var) {
        e10 e10Var = this.b;
        HashSet hashSet = (HashSet) e10Var.z;
        f10 f10Var = tt3Var.g;
        int i = f10Var.c;
        if (i != -1) {
            this.m = true;
            int i2 = e10Var.b;
            List list = tt3.j;
            if (list.indexOf(Integer.valueOf(i)) < list.indexOf(Integer.valueOf(i2))) {
                i = i2;
            }
            e10Var.b = i;
        }
        Range rangeA = f10Var.a();
        Range range = ih.h;
        boolean zEquals = rangeA.equals(range);
        StringBuilder sb = this.l;
        if (!zEquals) {
            qn2 qn2Var = (qn2) e10Var.A;
            pg pgVar = f10.j;
            boolean zEquals2 = ((Range) qn2Var.p(pgVar, range)).equals(range);
            qn2 qn2Var2 = (qn2) e10Var.A;
            if (zEquals2) {
                qn2Var2.g(pgVar, rangeA);
            } else if (!((Range) qn2Var2.p(pgVar, range)).equals(rangeA)) {
                this.k = false;
                String str = "Different ExpectedFrameRateRange values; current = " + ((Range) ((qn2) e10Var.A).p(pgVar, range)) + ", new = " + rangeA;
                ez4.q("ValidatingBuilder", str);
                sb.append(str);
            }
        }
        int iB = f10Var.b();
        if (iB != 0 && iB != 0) {
            ((qn2) e10Var.A).g(mn4.l0, Integer.valueOf(iB));
        }
        int iC = f10Var.c();
        if (iC != 0 && iC != 0) {
            ((qn2) e10Var.A).g(mn4.m0, Integer.valueOf(iC));
        }
        ((vn2) e10Var.Y).a.putAll((Map) f10Var.f.a);
        this.c.addAll(tt3Var.c);
        this.d.addAll(tt3Var.d);
        e10Var.a(f10Var.d);
        this.e.addAll(tt3Var.e);
        rt3 rt3Var = tt3Var.f;
        if (rt3Var != null) {
            this.n.add(rt3Var);
        }
        InputConfiguration inputConfiguration = tt3Var.i;
        if (inputConfiguration != null) {
            this.g = inputConfiguration;
        }
        ArrayList arrayList = tt3Var.a;
        LinkedHashSet<fh> linkedHashSet = this.a;
        linkedHashSet.addAll(arrayList);
        hashSet.addAll(DesugarCollections.unmodifiableList(f10Var.a));
        ArrayList arrayList2 = new ArrayList();
        for (fh fhVar : linkedHashSet) {
            arrayList2.add(fhVar.a);
            Iterator it = fhVar.b.iterator();
            while (it.hasNext()) {
                arrayList2.add((dn0) it.next());
            }
        }
        if (!arrayList2.containsAll(hashSet)) {
            ez4.o("ValidatingBuilder", "Invalid configuration due to capture request surfaces are not a subset of surfaces");
            this.k = false;
            sb.append("Invalid configuration due to capture request surfaces are not a subset of surfaces");
        }
        int i3 = tt3Var.h;
        int i4 = this.h;
        if (i3 != i4 && i3 != 0 && i4 != 0) {
            ez4.o("ValidatingBuilder", "Invalid configuration due to that two non-default session types are set");
            this.k = false;
            sb.append("Invalid configuration due to that two non-default session types are set");
        } else if (i3 != 0) {
            this.h = i3;
        }
        fh fhVar2 = tt3Var.b;
        if (fhVar2 != null) {
            fh fhVar3 = this.i;
            if (fhVar3 == fhVar2 || fhVar3 == null) {
                this.i = fhVar2;
            } else {
                ez4.o("ValidatingBuilder", "Invalid configuration due to that two different postview output configs are set");
                this.k = false;
                sb.append("Invalid configuration due to that two different postview output configs are set");
            }
        }
        e10Var.d(f10Var.b);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.tt3 b() {
        /*
            Method dump skipped, instruction units count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.st3.b():tt3");
    }

    public final boolean c() {
        return this.m && this.k;
    }
}
