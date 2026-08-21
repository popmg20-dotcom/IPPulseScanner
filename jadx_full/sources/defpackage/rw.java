package defpackage;

import android.content.Context;
import io.sentry.android.core.a1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class rw {
    public final Context a;
    public final ow b;
    public final ng c;
    public final d00 d;
    public final pz e;
    public final sv0 f;
    public final long g;
    public final q00 i;
    public final tx j;
    public final b00 k;
    public final HashMap h = new HashMap();
    public final Object l = new Object();
    public ArrayList m = new ArrayList();

    public rw(Context context, ng ngVar, b00 b00Var, long j, q00 q00Var, e24 e24Var) throws c02 {
        this.a = context;
        this.c = ngVar;
        pz pzVarA = pz.a(context, ngVar.b);
        this.e = pzVarA;
        this.f = sv0.b(context);
        ow owVar = new ow(pzVarA);
        this.b = owVar;
        d00 d00Var = new d00(owVar);
        this.d = d00Var;
        synchronized (owVar.a) {
            owVar.c.add(d00Var);
        }
        this.g = j;
        this.i = q00Var;
        this.k = b00Var;
        try {
            List listAsList = Arrays.asList(pzVarA.c());
            this.j = new tx(listAsList, pzVarA, ngVar.a);
            e(listAsList);
        } catch (xx e) {
            throw new c02(new e00(e));
        }
    }

    public final LinkedHashSet a() {
        LinkedHashSet linkedHashSet;
        synchronized (this.l) {
            linkedHashSet = new LinkedHashSet(this.m);
        }
        return linkedHashSet;
    }

    public final ArrayList b(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str.equals("0") || str.equals("1")) {
                arrayList2.add(str);
            } else if (ez4.E(this.e, str)) {
                arrayList2.add(str);
            } else {
                ez4.o("Camera2CameraFactory", "Camera " + str + " is filtered out because its capabilities do not contain REQUEST_AVAILABLE_CAPABILITIES_BACKWARD_COMPATIBLE.");
            }
        }
        return arrayList2;
    }

    public final ex c(String str) throws e00 {
        synchronized (this.l) {
            if (!this.m.contains(str)) {
                throw new IllegalArgumentException("The given camera id is not on the available camera id list.");
            }
        }
        Context context = this.a;
        pz pzVar = this.e;
        gx gxVarD = d(str);
        ow owVar = this.b;
        d00 d00Var = this.d;
        ng ngVar = this.c;
        return new ex(context, pzVar, str, gxVarD, owVar, d00Var, ngVar.a, ngVar.b, this.f, this.g, this.i);
    }

    public final gx d(String str) throws e00 {
        HashMap map = this.h;
        try {
            gx gxVar = (gx) map.get(str);
            if (gxVar != null) {
                return gxVar;
            }
            gx gxVar2 = new gx(this.e, str);
            map.put(str, gxVar2);
            return gxVar2;
        } catch (xx e) {
            throw new e00(e);
        }
    }

    public final void e(List list) throws c02 {
        try {
            ArrayList arrayListB = b(xb5.v(this, this.k, new ArrayList(list)));
            synchronized (this.l) {
                try {
                    if (this.m.equals(arrayListB)) {
                        return;
                    }
                    ez4.o("Camera2CameraFactory", "Updated available camera list: " + this.m + " -> " + arrayListB);
                    this.m = arrayListB;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (c02 e) {
            a1.e("Camera2CameraFactory", "Unable to get backward compatible camera ids", e);
            throw e;
        }
    }
}
