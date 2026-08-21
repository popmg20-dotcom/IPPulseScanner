package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m20 {
    public ArrayList a;

    public m20(v92 v92Var) {
        ir2 ir2Var;
        v92Var.getClass();
        im imVar = new im((bc0) v92Var.f, 0);
        im imVar2 = new im((jm) v92Var.z, 1);
        im imVar3 = new im((bc0) v92Var.X, 4);
        bc0 bc0Var = (bc0) v92Var.A;
        im imVar4 = new im(bc0Var, 2);
        im imVar5 = new im(bc0Var, 3);
        fr2 fr2Var = new fr2(bc0Var);
        er2 er2Var = new er2(bc0Var);
        if (Build.VERSION.SDK_INT >= 28) {
            Context context = (Context) v92Var.b;
            String str = mw4.a;
            Object systemService = context.getSystemService("connectivity");
            systemService.getClass();
            ir2Var = new ir2((ConnectivityManager) systemService);
        } else {
            ir2Var = null;
        }
        this.a = qe.l0(new nb0[]{imVar, imVar2, imVar3, imVar4, imVar5, fr2Var, er2Var, ir2Var});
    }

    public void a(String str) {
        ArrayList arrayList = this.a;
        int i = 0;
        while (i < arrayList.size()) {
            if (str.equalsIgnoreCase((String) arrayList.get(i))) {
                arrayList.remove(i);
                arrayList.remove(i);
                i -= 2;
            }
            i += 2;
        }
    }

    public zf1 b(gx4 gx4Var) {
        gx4Var.getClass();
        ArrayList arrayList = this.a;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((nb0) obj).c(gx4Var)) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList(f70.Q(10, arrayList2));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((nb0) it.next()).b(gx4Var.j));
        }
        return ji0.n(new av(8, (zf1[]) d70.y0(arrayList3).toArray(new zf1[0])));
    }

    public m20(int i) {
        switch (i) {
            case 1:
                this.a = new ArrayList(20);
                break;
            default:
                this.a = new ArrayList();
                break;
        }
    }
}
