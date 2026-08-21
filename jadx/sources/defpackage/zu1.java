package defpackage;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zu1 implements fd1 {
    public final n84 a;
    public final n84 b;

    public zu1(n84 n84Var, n84 n84Var2) {
        this.a = n84Var;
        this.b = n84Var2;
    }

    @Override // defpackage.fd1
    public final gd1 a(Object obj, rw2 rw2Var) {
        Uri uri = (Uri) obj;
        if (n12.c(uri.getScheme(), "http") || n12.c(uri.getScheme(), "https")) {
            return new cv1(uri.toString(), rw2Var, this.a, this.b);
        }
        return null;
    }
}
