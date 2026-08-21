package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class y42 {
    public boolean a() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int b() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public final g62 c() {
        if (this instanceof g62) {
            return (g62) this;
        }
        s53.j(this, "Not a JSON Object: ");
        return null;
    }

    public String d() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public final String toString() {
        try {
            StringBuilder sb = new StringBuilder();
            v72 v72Var = new v72(new h44(sb));
            v72Var.y0 = 1;
            mj4.z.getClass();
            z42.e(this, v72Var);
            return sb.toString();
        } catch (IOException e) {
            xe.i(e);
            return null;
        }
    }
}
