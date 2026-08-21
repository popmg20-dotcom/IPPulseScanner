package defpackage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c74 {
    public final int a;
    public final Matrix b;
    public final boolean c;
    public final Rect d;
    public final boolean e;
    public final int f;
    public final ih g;
    public int h;
    public int i;
    public j74 k;
    public b74 l;
    public boolean j = false;
    public final HashSet m = new HashSet();
    public boolean n = false;
    public final ArrayList o = new ArrayList();

    public c74(int i, int i2, ih ihVar, Matrix matrix, boolean z, Rect rect, int i3, int i4, boolean z2) {
        this.f = i;
        this.a = i2;
        this.g = ihVar;
        this.b = matrix;
        this.c = z;
        this.d = rect;
        this.i = i3;
        this.h = i4;
        this.e = z2;
        this.l = new b74(ihVar.a, i2);
    }

    public final void a() {
        r25.j("Edge is already closed.", !this.n);
    }

    public final void b() {
        co4.h();
        this.l.a();
        this.n = true;
        this.o.clear();
        this.m.clear();
    }

    public final j74 c(mz mzVar, boolean z) {
        co4.h();
        a();
        ih ihVar = this.g;
        Size size = ihVar.a;
        oz0 oz0Var = ihVar.c;
        int i = 0;
        j74 j74Var = new j74(size, mzVar, z, oz0Var, new x64(this, i));
        try {
            az1 az1Var = j74Var.k;
            b74 b74Var = this.l;
            if (b74Var.g(az1Var, new y64(b74Var, i))) {
                n12.K(b74Var.e).a(new z64(az1Var, 0), yu0.a());
            }
            this.k = j74Var;
            e();
            return j74Var;
        } catch (cn0 e) {
            throw new AssertionError("Surface is somehow already closed", e);
        } catch (RuntimeException e2) {
            j74Var.c();
            throw e2;
        }
    }

    public final void d() {
        boolean z;
        co4.h();
        a();
        b74 b74Var = this.l;
        co4.h();
        if (b74Var.q == null) {
            synchronized (b74Var.a) {
                z = b74Var.c;
            }
            if (!z) {
                return;
            }
        }
        this.j = false;
        this.l.a();
        this.l = new b74(this.g.a, this.a);
        Iterator it = this.m.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    public final void e() {
        i74 i74Var;
        Executor executor;
        co4.h();
        oh ohVar = new oh(this.d, this.i, this.h, this.c, this.b, this.e);
        j74 j74Var = this.k;
        if (j74Var != null) {
            synchronized (j74Var.a) {
                j74Var.l = ohVar;
                i74Var = j74Var.m;
                executor = j74Var.n;
            }
            if (i74Var != null && executor != null) {
                executor.execute(new f74(i74Var, ohVar, 0));
            }
        }
        Iterator it = this.o.iterator();
        while (it.hasNext()) {
            ((dd0) it.next()).accept(ohVar);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SurfaceEdge{targets=");
        sb.append(this.f);
        sb.append(", format=");
        sb.append(this.a);
        sb.append(", resolution=");
        sb.append(this.g.a);
        sb.append(", cropRect=");
        sb.append(this.d);
        sb.append(", rotationDegrees=");
        sb.append(this.i);
        sb.append(", mirroring=");
        sb.append(this.e);
        sb.append(", sensorToBufferTransform= ");
        Matrix matrix = this.b;
        sb.append(matrix);
        sb.append(", rotationInTransform= ");
        sb.append(kg4.b(matrix));
        sb.append(", isMirrorInTransform= ");
        sb.append(kg4.e(matrix));
        sb.append(", isClosed=");
        sb.append(this.n);
        sb.append('}');
        return sb.toString();
    }
}
