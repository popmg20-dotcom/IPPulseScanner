package defpackage;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class aj3 implements Comparable {
    public final Object A;
    public fm0 A0;
    public ju B0;
    public Object C0;
    public ih4 D0;
    public pk3 X;
    public Integer Y;
    public y3 Z;
    public final ps4 b;
    public final String f;
    public boolean y0;
    public final int z;
    public boolean z0;

    public aj3(String str, pk3 pk3Var) {
        Uri uri;
        String host;
        this.b = ps4.c ? new ps4() : null;
        this.A = new Object();
        int iHashCode = 0;
        this.y0 = false;
        this.z0 = false;
        this.B0 = null;
        this.f = str;
        this.X = pk3Var;
        this.A0 = new fm0(2500, 1);
        if (!TextUtils.isEmpty(str) && (uri = Uri.parse(str)) != null && (host = uri.getHost()) != null) {
            iHashCode = host.hashCode();
        }
        this.z = iHashCode;
    }

    public final void a(String str) {
        if (ps4.c) {
            this.b.a(Thread.currentThread().getId(), str);
        }
    }

    public void b() {
        synchronized (this.A) {
            this.y0 = true;
            this.X = null;
        }
    }

    public abstract void c(Object obj);

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        aj3 aj3Var = (aj3) obj;
        aj3Var.getClass();
        return this.Y.intValue() - aj3Var.Y.intValue();
    }

    public final void d(String str) {
        y3 y3Var = this.Z;
        if (y3Var != null) {
            synchronized (((HashSet) y3Var.d)) {
                ((HashSet) y3Var.d).remove(this);
            }
            synchronized (((ArrayList) y3Var.c)) {
                Iterator it = ((ArrayList) y3Var.c).iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            }
            y3Var.f();
        }
        if (ps4.c) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new yi3(this, str, id));
            } else {
                this.b.a(id, str);
                this.b.b(toString());
            }
        }
    }

    public Map e() {
        return Collections.EMPTY_MAP;
    }

    public final boolean f() {
        boolean z;
        synchronized (this.A) {
            z = this.z0;
        }
        return z;
    }

    public final boolean g() {
        boolean z;
        synchronized (this.A) {
            z = this.y0;
        }
        return z;
    }

    public final void h() {
        ih4 ih4Var;
        synchronized (this.A) {
            ih4Var = this.D0;
        }
        if (ih4Var != null) {
            ih4Var.c(this);
        }
    }

    public final void i(ue1 ue1Var) {
        ih4 ih4Var;
        synchronized (this.A) {
            ih4Var = this.D0;
        }
        if (ih4Var != null) {
            ih4Var.d(this, ue1Var);
        }
    }

    public abstract ue1 j(jr2 jr2Var);

    public final void k() {
        y3 y3Var = this.Z;
        if (y3Var != null) {
            y3Var.f();
        }
    }

    public final void l(ih4 ih4Var) {
        synchronized (this.A) {
            this.D0 = ih4Var;
        }
    }

    public final String toString() {
        String str = "0x" + Integer.toHexString(this.z);
        StringBuilder sb = new StringBuilder(g() ? "[X] " : "[ ] ");
        ha0.v(sb, this.f, " ", str, " ");
        sb.append("NORMAL");
        sb.append(" ");
        sb.append(this.Y);
        return sb.toString();
    }
}
