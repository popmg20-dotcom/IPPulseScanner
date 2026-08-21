package defpackage;

import android.os.Looper;
import androidx.lifecycle.DefaultLifecycleObserver;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fa2 extends r92 {
    public vb1 b = new vb1();
    public q92 c;
    public final WeakReference d;
    public int e;
    public boolean f;
    public boolean g;
    public final ArrayList h;
    public final m24 i;

    public fa2(da2 da2Var) {
        q92 q92Var = q92.f;
        this.c = q92Var;
        this.h = new ArrayList();
        this.d = new WeakReference(da2Var);
        this.i = n24.a(q92Var);
    }

    @Override // defpackage.r92
    public final void a(ca2 ca2Var) {
        aa2 bm0Var;
        Object obj;
        da2 da2Var;
        ca2Var.getClass();
        e("addObserver");
        q92 q92Var = this.c;
        q92 q92Var2 = q92.b;
        if (q92Var != q92Var2) {
            q92Var2 = q92.f;
        }
        ea2 ea2Var = new ea2();
        HashMap map = ga2.a;
        boolean z = ca2Var instanceof aa2;
        boolean z2 = ca2Var instanceof DefaultLifecycleObserver;
        int i = 2;
        Object obj2 = null;
        if (z && z2) {
            bm0Var = new bm0(i, (DefaultLifecycleObserver) ca2Var, (aa2) ca2Var);
        } else if (z2) {
            bm0Var = new bm0(i, (DefaultLifecycleObserver) ca2Var, obj2);
        } else if (z) {
            bm0Var = (aa2) ca2Var;
        } else {
            Class<?> cls = ca2Var.getClass();
            if (ga2.b(cls) == 2) {
                Object obj3 = ga2.b.get(cls);
                obj3.getClass();
                List list = (List) obj3;
                if (list.size() == 1) {
                    ga2.a((Constructor) list.get(0), ca2Var);
                    throw null;
                }
                int size = list.size();
                jn1[] jn1VarArr = new jn1[size];
                if (size > 0) {
                    ga2.a((Constructor) list.get(0), ca2Var);
                    throw null;
                }
                bm0Var = new nf3(i, jn1VarArr);
            } else {
                bm0Var = new bm0(ca2Var);
            }
        }
        ea2Var.b = bm0Var;
        ea2Var.a = q92Var2;
        vb1 vb1Var = this.b;
        qo3 qo3VarA = vb1Var.a(ca2Var);
        if (qo3VarA != null) {
            obj = qo3VarA.f;
        } else {
            HashMap map2 = vb1Var.X;
            qo3 qo3Var = new qo3(ca2Var, ea2Var);
            vb1Var.A++;
            qo3 qo3Var2 = vb1Var.f;
            if (qo3Var2 == null) {
                vb1Var.b = qo3Var;
                vb1Var.f = qo3Var;
            } else {
                qo3Var2.z = qo3Var;
                qo3Var.A = qo3Var2;
                vb1Var.f = qo3Var;
            }
            map2.put(ca2Var, qo3Var);
            obj = null;
        }
        if (((ea2) obj) == null && (da2Var = (da2) this.d.get()) != null) {
            i = (this.e != 0 || this.f) ? 1 : 0;
            q92 q92VarD = d(ca2Var);
            this.e++;
            while (ea2Var.a.compareTo(q92VarD) < 0 && this.b.X.containsKey(ca2Var)) {
                q92 q92Var3 = ea2Var.a;
                ArrayList arrayList = this.h;
                arrayList.add(q92Var3);
                n92 n92Var = p92.Companion;
                q92 q92Var4 = ea2Var.a;
                n92Var.getClass();
                q92Var4.getClass();
                int iOrdinal = q92Var4.ordinal();
                p92 p92Var = iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? null : p92.ON_RESUME : p92.ON_START : p92.ON_CREATE;
                if (p92Var == null) {
                    zo2.v(ea2Var.a, "no event up from ");
                    return;
                } else {
                    ea2Var.a(da2Var, p92Var);
                    arrayList.remove(arrayList.size() - 1);
                    q92VarD = d(ca2Var);
                }
            }
            if (i == 0) {
                h();
            }
            this.e--;
        }
    }

    @Override // defpackage.r92
    public final q92 b() {
        return this.c;
    }

    @Override // defpackage.r92
    public final void c(ca2 ca2Var) {
        ca2Var.getClass();
        e("removeObserver");
        this.b.b(ca2Var);
    }

    public final q92 d(ca2 ca2Var) {
        HashMap map = this.b.X;
        qo3 qo3Var = map.containsKey(ca2Var) ? ((qo3) map.get(ca2Var)).A : null;
        q92 q92Var = qo3Var != null ? ((ea2) qo3Var.f).a : null;
        ArrayList arrayList = this.h;
        q92 q92Var2 = arrayList.isEmpty() ? null : (q92) fw.r(arrayList, 1);
        q92 q92Var3 = this.c;
        if (q92Var == null || q92Var.compareTo(q92Var3) >= 0) {
            q92Var = q92Var3;
        }
        return (q92Var2 == null || q92Var2.compareTo(q92Var) >= 0) ? q92Var : q92Var2;
    }

    public final void e(String str) {
        ym0 ym0Var = rd.w0().z0;
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return;
        }
        g.g(ha0.o("Method ", str, " must be called on the main thread"));
    }

    public final void f(p92 p92Var) {
        p92Var.getClass();
        e("handleLifecycleEvent");
        g(p92Var.a());
    }

    public final void g(q92 q92Var) {
        if (this.c == q92Var) {
            return;
        }
        da2 da2Var = (da2) this.d.get();
        q92 q92Var2 = this.c;
        q92 q92Var3 = q92.f;
        q92 q92Var4 = q92.b;
        if (q92Var2 == q92Var3 && q92Var == q92Var4) {
            throw new IllegalStateException(("State must be at least '" + q92.z + "' to be moved to '" + q92Var + "' in component " + da2Var).toString());
        }
        if (q92Var2 == q92Var4 && q92Var2 != q92Var) {
            throw new IllegalStateException(("State is '" + q92Var4 + "' and cannot be moved to `" + q92Var + "` in component " + da2Var).toString());
        }
        this.c = q92Var;
        if (this.f || this.e != 0) {
            this.g = true;
            return;
        }
        this.f = true;
        h();
        this.f = false;
        if (this.c == q92Var4) {
            this.b = new vb1();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0031, code lost:
    
        r11.g = false;
        r11.i.j(null, r11.c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003a, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h() {
        da2 da2Var = (da2) this.d.get();
        if (da2Var == null) {
            xe.q("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
            return;
        }
        while (true) {
            vb1 vb1Var = this.b;
            if (vb1Var.A != 0) {
                qo3 qo3Var = vb1Var.b;
                qo3Var.getClass();
                q92 q92Var = ((ea2) qo3Var.f).a;
                qo3 qo3Var2 = this.b.f;
                qo3Var2.getClass();
                q92 q92Var2 = ((ea2) qo3Var2.f).a;
                if (q92Var == q92Var2 && this.c == q92Var2) {
                    break;
                }
                this.g = false;
                q92 q92Var3 = this.c;
                qo3 qo3Var3 = this.b.b;
                qo3Var3.getClass();
                int iCompareTo = q92Var3.compareTo(((ea2) qo3Var3.f).a);
                ArrayList arrayList = this.h;
                if (iCompareTo < 0) {
                    vb1 vb1Var2 = this.b;
                    po3 po3Var = new po3(vb1Var2.f, vb1Var2.b, 1);
                    vb1Var2.z.put(po3Var, Boolean.FALSE);
                    while (po3Var.hasNext() && !this.g) {
                        Map.Entry entry = (Map.Entry) po3Var.next();
                        entry.getClass();
                        ca2 ca2Var = (ca2) entry.getKey();
                        ea2 ea2Var = (ea2) entry.getValue();
                        while (ea2Var.a.compareTo(this.c) > 0 && !this.g && this.b.X.containsKey(ca2Var)) {
                            n92 n92Var = p92.Companion;
                            q92 q92Var4 = ea2Var.a;
                            n92Var.getClass();
                            q92Var4.getClass();
                            int iOrdinal = q92Var4.ordinal();
                            p92 p92Var = iOrdinal != 2 ? iOrdinal != 3 ? iOrdinal != 4 ? null : p92.ON_PAUSE : p92.ON_STOP : p92.ON_DESTROY;
                            if (p92Var == null) {
                                zo2.v(ea2Var.a, "no event down from ");
                                return;
                            } else {
                                arrayList.add(p92Var.a());
                                ea2Var.a(da2Var, p92Var);
                                arrayList.remove(arrayList.size() - 1);
                            }
                        }
                    }
                }
                qo3 qo3Var4 = this.b.f;
                if (!this.g && qo3Var4 != null && this.c.compareTo(((ea2) qo3Var4.f).a) > 0) {
                    vb1 vb1Var3 = this.b;
                    ro3 ro3Var = new ro3(vb1Var3);
                    vb1Var3.z.put(ro3Var, Boolean.FALSE);
                    while (ro3Var.hasNext() && !this.g) {
                        Map.Entry entry2 = (Map.Entry) ro3Var.next();
                        ca2 ca2Var2 = (ca2) entry2.getKey();
                        ea2 ea2Var2 = (ea2) entry2.getValue();
                        while (ea2Var2.a.compareTo(this.c) < 0 && !this.g && this.b.X.containsKey(ca2Var2)) {
                            arrayList.add(ea2Var2.a);
                            n92 n92Var2 = p92.Companion;
                            q92 q92Var5 = ea2Var2.a;
                            n92Var2.getClass();
                            q92Var5.getClass();
                            int iOrdinal2 = q92Var5.ordinal();
                            p92 p92Var2 = iOrdinal2 != 1 ? iOrdinal2 != 2 ? iOrdinal2 != 3 ? null : p92.ON_RESUME : p92.ON_START : p92.ON_CREATE;
                            if (p92Var2 == null) {
                                zo2.v(ea2Var2.a, "no event up from ");
                                return;
                            } else {
                                ea2Var2.a(da2Var, p92Var2);
                                arrayList.remove(arrayList.size() - 1);
                            }
                        }
                    }
                }
            } else {
                break;
            }
        }
    }
}
