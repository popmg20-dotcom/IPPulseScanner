package defpackage;

import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class wi1 implements my1 {
    public final my1 f;
    public final Object b = new Object();
    public final HashSet z = new HashSet();

    public wi1(my1 my1Var) {
        this.f = my1Var;
    }

    @Override // defpackage.my1
    public int c() {
        return this.f.c();
    }

    @Override // java.lang.AutoCloseable
    public void close() throws Exception {
        HashSet hashSet;
        this.f.close();
        synchronized (this.b) {
            hashSet = new HashSet(this.z);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((vi1) it.next()).a(this);
        }
    }

    @Override // defpackage.my1
    public int f() {
        return this.f.f();
    }

    public final void g(vi1 vi1Var) {
        synchronized (this.b) {
            this.z.add(vi1Var);
        }
    }

    @Override // defpackage.my1
    public cy1 g0() {
        return this.f.g0();
    }

    @Override // defpackage.my1
    public final int getFormat() {
        return this.f.getFormat();
    }

    @Override // defpackage.my1
    public ly1[] p() {
        return this.f.p();
    }
}
