package defpackage;

import android.view.Surface;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class jx2 {
    public final Object a;

    public jx2(Surface surface) {
        this.a = new ix2(surface);
    }

    public void a(Surface surface) {
        if (e() == surface) {
            throw new IllegalStateException("Surface is already added!");
        }
        if (!f()) {
            throw new IllegalStateException("Cannot have 2 surfaces for a non-sharing configuration");
        }
        throw new IllegalArgumentException("Exceeds maximum number of surfaces");
    }

    public void b() {
        ((ix2) this.a).f = true;
    }

    public Object c() {
        return null;
    }

    public String d() {
        return ((ix2) this.a).e;
    }

    public Surface e() {
        List list = ((ix2) this.a).a;
        if (list.size() == 0) {
            return null;
        }
        return (Surface) list.get(0);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof jx2)) {
            return false;
        }
        return this.a.equals(((jx2) obj).a);
    }

    public boolean f() {
        return ((ix2) this.a).f;
    }

    public void g(long j) {
        ((ix2) this.a).g = j;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public void i(String str) {
        ((ix2) this.a).e = str;
    }

    public jx2(Object obj) {
        this.a = obj;
    }

    public void h(int i) {
    }

    public void j(long j) {
    }
}
