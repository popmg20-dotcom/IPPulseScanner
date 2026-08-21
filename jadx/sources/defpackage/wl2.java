package defpackage;

import android.media.ImageReader;
import android.util.LongSparseArray;
import android.view.Surface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wl2 implements oy1, vi1 {
    public final jd A;
    public final LongSparseArray A0;
    public int B0;
    public final ArrayList C0;
    public final ArrayList D0;
    public boolean X;
    public final fa5 Y;
    public ny1 Z;
    public final Object b;
    public final vl2 f;
    public Executor y0;
    public int z;
    public final LongSparseArray z0;

    public wl2(int i, int i2, int i3, int i4) {
        fa5 fa5Var = new fa5(ImageReader.newInstance(i, i2, i3, i4));
        this.b = new Object();
        this.f = new vl2(this);
        this.z = 0;
        this.A = new jd(23, this);
        this.X = false;
        this.z0 = new LongSparseArray();
        this.A0 = new LongSparseArray();
        this.D0 = new ArrayList();
        this.Y = fa5Var;
        this.B0 = 0;
        this.C0 = new ArrayList(s());
    }

    @Override // defpackage.vi1
    public final void a(wi1 wi1Var) {
        synchronized (this.b) {
            b(wi1Var);
        }
    }

    public final void b(wi1 wi1Var) {
        synchronized (this.b) {
            try {
                int iIndexOf = this.C0.indexOf(wi1Var);
                if (iIndexOf >= 0) {
                    this.C0.remove(iIndexOf);
                    int i = this.B0;
                    if (iIndexOf <= i) {
                        this.B0 = i - 1;
                    }
                }
                this.D0.remove(wi1Var);
                if (this.z > 0) {
                    e(this.Y);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.oy1
    public final int c() {
        int iC;
        synchronized (this.b) {
            iC = this.Y.c();
        }
        return iC;
    }

    @Override // defpackage.oy1
    public final void close() {
        synchronized (this.b) {
            try {
                if (this.X) {
                    return;
                }
                Iterator it = new ArrayList(this.C0).iterator();
                while (it.hasNext()) {
                    ((my1) it.next()).close();
                }
                this.C0.clear();
                this.Y.close();
                this.X = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(du3 du3Var) {
        ny1 ny1Var;
        Executor executor;
        synchronized (this.b) {
            try {
                if (this.C0.size() < s()) {
                    du3Var.g(this);
                    this.C0.add(du3Var);
                    ny1Var = this.Z;
                    executor = this.y0;
                } else {
                    ez4.o("TAG", "Maximum image number reached.");
                    du3Var.close();
                    ny1Var = null;
                    executor = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (ny1Var != null) {
            if (executor != null) {
                executor.execute(new xy0(10, this, ny1Var));
            } else {
                ny1Var.o(this);
            }
        }
    }

    public final void e(oy1 oy1Var) {
        my1 my1VarT;
        synchronized (this.b) {
            try {
                if (this.X) {
                    return;
                }
                int size = this.A0.size() + this.C0.size();
                if (size >= oy1Var.s()) {
                    ez4.o("MetadataImageReader", "Skip to acquire the next image because the acquired image count has reached the max images count.");
                    return;
                }
                do {
                    try {
                        my1VarT = oy1Var.t();
                        if (my1VarT != null) {
                            this.z--;
                            size++;
                            this.A0.put(my1VarT.g0().c(), my1VarT);
                            g();
                        }
                    } catch (IllegalStateException e) {
                        ez4.p("MetadataImageReader", "Failed to acquire next image.", e);
                        my1VarT = null;
                    }
                    if (my1VarT == null || this.z <= 0) {
                        break;
                    }
                } while (size < oy1Var.s());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.oy1
    public final int f() {
        int iF;
        synchronized (this.b) {
            iF = this.Y.f();
        }
        return iF;
    }

    public final void g() {
        synchronized (this.b) {
            try {
                for (int size = this.z0.size() - 1; size >= 0; size--) {
                    cy1 cy1Var = (cy1) this.z0.valueAt(size);
                    long jC = cy1Var.c();
                    my1 my1Var = (my1) this.A0.get(jC);
                    if (my1Var != null) {
                        this.A0.remove(jC);
                        this.z0.removeAt(size);
                        d(new du3(my1Var, null, cy1Var));
                    }
                }
                h();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.oy1
    public final Surface getSurface() {
        Surface surface;
        synchronized (this.b) {
            surface = this.Y.getSurface();
        }
        return surface;
    }

    public final void h() {
        synchronized (this.b) {
            try {
                if (this.A0.size() != 0 && this.z0.size() != 0) {
                    long jKeyAt = this.A0.keyAt(0);
                    Long lValueOf = Long.valueOf(jKeyAt);
                    long jKeyAt2 = this.z0.keyAt(0);
                    r25.e(!Long.valueOf(jKeyAt2).equals(lValueOf));
                    if (jKeyAt2 > jKeyAt) {
                        for (int size = this.A0.size() - 1; size >= 0; size--) {
                            if (this.A0.keyAt(size) < jKeyAt2) {
                                ((my1) this.A0.valueAt(size)).close();
                                this.A0.removeAt(size);
                            }
                        }
                    } else {
                        for (int size2 = this.z0.size() - 1; size2 >= 0; size2--) {
                            if (this.z0.keyAt(size2) < jKeyAt) {
                                this.z0.removeAt(size2);
                            }
                        }
                    }
                }
            } finally {
            }
        }
    }

    @Override // defpackage.oy1
    public final my1 i() {
        synchronized (this.b) {
            try {
                if (this.C0.isEmpty()) {
                    return null;
                }
                if (this.B0 >= this.C0.size()) {
                    throw new IllegalStateException("Maximum image number reached.");
                }
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < this.C0.size() - 1; i++) {
                    if (!this.D0.contains(this.C0.get(i))) {
                        arrayList.add((my1) this.C0.get(i));
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((my1) it.next()).close();
                }
                int size = this.C0.size();
                ArrayList arrayList2 = this.C0;
                this.B0 = size;
                my1 my1Var = (my1) arrayList2.get(size - 1);
                this.D0.add(my1Var);
                return my1Var;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.oy1
    public final int j() {
        int iJ;
        synchronized (this.b) {
            iJ = this.Y.j();
        }
        return iJ;
    }

    @Override // defpackage.oy1
    public final void l() {
        synchronized (this.b) {
            this.Y.l();
            this.Z = null;
            this.y0 = null;
            this.z = 0;
        }
    }

    @Override // defpackage.oy1
    public final void p(ny1 ny1Var, Executor executor) {
        synchronized (this.b) {
            ny1Var.getClass();
            this.Z = ny1Var;
            executor.getClass();
            this.y0 = executor;
            this.Y.p(this.A, executor);
        }
    }

    @Override // defpackage.oy1
    public final int s() {
        int iS;
        synchronized (this.b) {
            iS = this.Y.s();
        }
        return iS;
    }

    @Override // defpackage.oy1
    public final my1 t() {
        synchronized (this.b) {
            try {
                if (this.C0.isEmpty()) {
                    return null;
                }
                if (this.B0 >= this.C0.size()) {
                    throw new IllegalStateException("Maximum image number reached.");
                }
                ArrayList arrayList = this.C0;
                int i = this.B0;
                this.B0 = i + 1;
                my1 my1Var = (my1) arrayList.get(i);
                this.D0.add(my1Var);
                return my1Var;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
