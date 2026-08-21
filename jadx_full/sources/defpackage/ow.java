package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ow implements k12 {
    public final pz b;
    public final Object a = new Object();
    public HashMap d = new HashMap();
    public HashSet e = new HashSet();
    public final ArrayList f = new ArrayList();
    public int g = 0;
    public final ArrayList c = new ArrayList();

    public ow(pz pzVar) {
        this.b = pzVar;
        try {
            a(Arrays.asList(pzVar.c()));
        } catch (f00 | xx e) {
            ez4.r("Camera2CameraCoordinator", "Failed to get concurrent camera ids", e);
        }
    }

    public static void d(ArrayList arrayList, int i, int i2) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            d00 d00Var = (d00) it.next();
            synchronized (d00Var.b) {
                boolean z = true;
                d00Var.c = i2 == 2 ? 2 : 1;
                boolean z2 = i != 2 && i2 == 2;
                if (i != 2 || i2 == 2) {
                    z = false;
                }
                if (z2 || z) {
                    d00Var.b();
                }
            }
        }
    }

    @Override // defpackage.k12
    public final void a(List list) throws f00 {
        HashMap map = new HashMap();
        HashSet hashSet = new HashSet();
        try {
            for (Set set : this.b.a.x()) {
                if (list.containsAll(set)) {
                    ArrayList arrayList = new ArrayList(set);
                    if (arrayList.size() >= 2) {
                        String str = (String) arrayList.get(0);
                        String str2 = (String) arrayList.get(1);
                        try {
                            if (ez4.E(this.b, str) && ez4.E(this.b, str2)) {
                                hashSet.add(new HashSet(Arrays.asList(str, str2)));
                                if (!map.containsKey(str)) {
                                    map.put(str, new ArrayList());
                                }
                                ((List) map.get(str)).add(str2);
                                if (!map.containsKey(str2)) {
                                    map.put(str2, new ArrayList());
                                }
                                ((List) map.get(str2)).add(str);
                            }
                        } catch (c02 unused) {
                            ez4.o("Camera2CameraCoordinator", "Concurrent camera id pair: (" + str + ", " + str + ") is not backward compatible");
                        }
                    }
                }
            }
            synchronized (this.a) {
                this.d = map;
                this.e = hashSet;
                ez4.o("Camera2CameraCoordinator", "Updated concurrent camera map: " + this.d);
            }
        } catch (xx e) {
            throw new f00("Failed to retrieve concurrent camera id info.", e);
        }
    }

    public final int b() {
        int i;
        synchronized (this.a) {
            i = this.g;
        }
        return i;
    }

    public final String c(String str) {
        synchronized (this.a) {
            try {
                if (!this.d.containsKey(str)) {
                    return null;
                }
                List<String> list = (List) this.d.get(str);
                if (list == null) {
                    return null;
                }
                for (String str2 : list) {
                    Iterator it = this.f.iterator();
                    while (it.hasNext()) {
                        kz implementation = ((kz) it.next()).getImplementation();
                        r25.f(implementation instanceof gx, "CameraInfo doesn't contain Camera2 implementation.");
                        if (str2.equals(((gx) ((gx) implementation).c.f).a)) {
                            return str2;
                        }
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
