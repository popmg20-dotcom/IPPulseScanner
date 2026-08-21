package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wz {
    public final Executor a;
    public rw c;
    public a00 d;
    public tx e;
    public final Object b = new Object();
    public final vz f = new vz(0, this);
    public volatile List g = g41.b;
    public final AtomicBoolean h = new AtomicBoolean(false);
    public final CopyOnWriteArrayList i = new CopyOnWriteArrayList();
    public final CopyOnWriteArrayList j = new CopyOnWriteArrayList();
    public final LinkedHashMap k = new LinkedHashMap();

    public wz(Executor executor) {
        this.a = executor;
    }

    public final void a(String str) {
        a00 a00Var = this.d;
        if (a00Var == null) {
            return;
        }
        try {
            kz kzVarR = a00Var.b(str).r();
            kzVarR.getClass();
            d(kzVarR);
        } catch (IllegalArgumentException unused) {
            ez4.a0("CameraPresencePrvdr", "CameraInternal not found for " + str + ". Cannot setup state observer.");
        }
    }

    public final void b(Set set, Set set2) {
        boolean zIsEmpty = set.isEmpty();
        CopyOnWriteArrayList copyOnWriteArrayList = this.j;
        if (!zIsEmpty) {
            ez4.D("CameraPresencePrvdr", "Notifying " + set.size() + " cameras added.");
            Iterator it = copyOnWriteArrayList.iterator();
            if (it.hasNext()) {
                throw dw2.z(it);
            }
        }
        if (set2.isEmpty()) {
            return;
        }
        ez4.D("CameraPresencePrvdr", "Notifying " + set2.size() + " cameras removed.");
        Iterator it2 = copyOnWriteArrayList.iterator();
        if (it2.hasNext()) {
            throw dw2.z(it2);
        }
    }

    public final void c(String str) {
        synchronized (this.b) {
            hu2 hu2Var = (hu2) this.k.remove(str);
            a00 a00Var = this.d;
            if (hu2Var != null && a00Var != null) {
                try {
                    ((xq1) vf2.q()).execute(new s7(11, a00Var.b(str), hu2Var));
                    ez4.o("CameraPresencePrvdr", "Removed state observer for: " + str);
                } catch (IllegalArgumentException unused) {
                }
            }
        }
    }

    public final void d(kz kzVar) {
        final String strD = kzVar.d();
        strD.getClass();
        if (this.h.get()) {
            synchronized (this.b) {
                if (this.k.containsKey(strD)) {
                    return;
                }
                hu2 hu2Var = new hu2() { // from class: uz
                    @Override // defpackage.hu2
                    public final void b(Object obj) {
                        lg lgVar = (lg) obj;
                        wz wzVar = this.b;
                        if (!wzVar.h.get()) {
                            ez4.o("CameraPresencePrvdr", "Ignore camera state change handling since already stop monitoring");
                            return;
                        }
                        if ((lgVar != null ? lgVar.b : null) == null) {
                            if ((lgVar != null ? lgVar.a : 0) != 5) {
                                return;
                            }
                        }
                        StringBuilder sbD = fw.D("Camera ", strD, " state changed to ");
                        sbD.append(fw.I(lgVar.a));
                        sbD.append(" with error: ");
                        mg mgVar = lgVar.b;
                        sbD.append(mgVar != null ? Integer.valueOf(mgVar.a) : null);
                        sbD.append(". Triggering refresh.");
                        ez4.a0("CameraPresencePrvdr", sbD.toString());
                        tx txVar = wzVar.e;
                        if (txVar != null) {
                            txVar.b();
                        }
                    }
                };
                ((xq1) vf2.q()).execute(new s7(12, kzVar, hu2Var));
                this.k.put(strD, hu2Var);
                ez4.o("CameraPresencePrvdr", "Registered state observer for camera: ".concat(strD));
            }
        }
    }

    public final void e() {
        if (!this.h.getAndSet(false)) {
            ez4.o("CameraPresencePrvdr", "Shutdown called when not monitoring. Ignoring.");
            return;
        }
        ez4.D("CameraPresencePrvdr", "Shutting down CameraPresenceProvider monitoring.");
        tx txVar = this.e;
        if (txVar != null) {
            txVar.f(this.f);
        }
        synchronized (this.b) {
            if (!this.k.isEmpty()) {
                Map mapY = fh2.Y(this.k);
                this.k.clear();
                a00 a00Var = this.d;
                if (a00Var != null) {
                    LinkedHashSet linkedHashSetC = a00Var.c();
                    ArrayList arrayList = new ArrayList(f70.Q(10, linkedHashSetC));
                    Iterator it = linkedHashSetC.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((mz) it.next()).r());
                    }
                    ez4.o("CameraPresencePrvdr", "Clearing all " + mapY.size() + " state observers.");
                    ArrayList arrayList2 = new ArrayList(mapY.size());
                    for (Map.Entry entry : mapY.entrySet()) {
                        String str = (String) entry.getKey();
                        ((xq1) vf2.q()).execute(new b0(3, arrayList, (hu2) entry.getValue(), str));
                        arrayList2.add(xl4.a);
                    }
                }
            }
        }
        this.i.clear();
        this.j.clear();
        this.g = g41.b;
        this.c = null;
        this.d = null;
    }

    public final void f(rw rwVar, a00 a00Var) {
        rwVar.getClass();
        a00Var.getClass();
        if (this.h.compareAndSet(false, true)) {
            ez4.D("CameraPresencePrvdr", "Starting CameraPresenceProvider monitoring.");
            LinkedHashSet<String> linkedHashSetA = rwVar.a();
            ArrayList arrayList = new ArrayList(f70.Q(10, linkedHashSetA));
            for (String str : linkedHashSetA) {
                str.getClass();
                arrayList.add(new jz(e70.L(str), null));
            }
            this.g = arrayList;
            this.c = rwVar;
            this.d = a00Var;
            tx txVar = rwVar.j;
            this.e = txVar;
            if (txVar != null) {
                txVar.a(this.a, this.f);
            }
        }
    }
}
