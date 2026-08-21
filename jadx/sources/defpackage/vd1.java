package defpackage;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vd1 {
    public static vd1 b;
    public final ArrayList a;

    public vd1() {
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        arrayList.add(zd1.a);
    }

    public static synchronized vd1 a() {
        vd1 vd1Var;
        vd1Var = b;
        if (vd1Var == null) {
            vd1Var = new vd1();
            b = vd1Var;
        }
        return vd1Var;
    }

    public Object b() {
        return this.a.remove(r1.size() - 1);
    }

    public void c(Object obj) {
        this.a.add(obj);
    }

    public InputStream d(String str) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            InputStream inputStreamA = ((zd1) it.next()).a(str);
            if (inputStreamA != null) {
                return inputStreamA;
            }
        }
        return null;
    }

    public vd1(int i) {
        this.a = new ArrayList(i);
    }
}
