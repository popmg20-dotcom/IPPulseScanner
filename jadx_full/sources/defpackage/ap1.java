package defpackage;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ap1 extends aj3 implements sw0 {
    public final e24 E0;
    public final Object F0;

    public ap1(e24 e24Var) {
        super("https://api.github.com/repos/getsurfboard/surfboard/releases/latest", e24Var);
        this.E0 = e24Var;
        this.F0 = new Object();
    }

    @Override // defpackage.aj3
    public final void c(Object obj) {
        e24 e24Var;
        synchronized (this.F0) {
            e24Var = this.E0;
        }
        e24Var.p(obj);
    }

    @Override // defpackage.aj3
    public final Map e() {
        e03[] e03VarArr = {new e03("X-GitHub-Api-Version", "2022-11-28"), new e03("Accept", "application/vnd.github+json")};
        LinkedHashMap linkedHashMap = new LinkedHashMap(fh2.U(2));
        for (int i = 0; i < 2; i++) {
            e03 e03Var = e03VarArr[i];
            linkedHashMap.put(e03Var.b, e03Var.f);
        }
        return linkedHashMap;
    }

    @Override // defpackage.aj3
    public final ue1 j(jr2 jr2Var) {
        try {
            u61 u61Var = u61.A;
            HashMap map = new HashMap();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            si1 si1Var = iq1.j;
            int i = iq1.l;
            int i2 = iq1.m;
            ArrayDeque arrayDeque = new ArrayDeque();
            u61 u61VarClone = u61Var.clone();
            u61VarClone.b = true;
            ArrayList arrayList3 = new ArrayList(arrayList2.size() + arrayList.size() + 3);
            arrayList3.addAll(arrayList);
            Collections.reverse(arrayList3);
            ArrayList arrayList4 = new ArrayList(arrayList2);
            Collections.reverse(arrayList4);
            arrayList3.addAll(arrayList4);
            boolean z = d14.a;
            HashMap map2 = new HashMap(map);
            new ArrayList(arrayList);
            new ArrayList(arrayList2);
            iq1 iq1Var = new iq1(u61VarClone, 1, map2, si1Var, 0, arrayList3, i, i2, new ArrayList(arrayDeque));
            byte[] bArr = (byte[]) jr2Var.c;
            bArr.getClass();
            return new ue1(iq1Var.c(new String(bArr, y30.a), new bk4(bp1.class)), ji0.G(jr2Var));
        } catch (Exception e) {
            return new ue1(new ag(e));
        }
    }
}
