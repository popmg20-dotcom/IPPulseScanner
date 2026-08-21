package defpackage;

import android.util.Base64;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d04 {
    public static final lu2 g;
    public final t53 a;
    public final Map b;
    public final int c;
    public final String d;
    public final String e;
    public final f82 f;

    static {
        ku2 ku2Var = new ku2();
        ku2Var.i = false;
        ku2Var.j = false;
        g = new lu2(ku2Var);
    }

    public d04(t53 t53Var, Map map, int i, String str, String str2, f82 f82Var) {
        t53Var.getClass();
        str.getClass();
        str2.getClass();
        f82Var.getClass();
        this.a = t53Var;
        this.b = map;
        this.c = i;
        this.d = str;
        this.e = str2;
        this.f = f82Var;
    }

    public final cm2 a(String str, boolean z) {
        v92 v92Var = new v92(15);
        v92Var.w(str);
        v92Var.m("HEAD", null);
        v92Var.l("Connection", "close");
        if (!z) {
            byte[] bytes = this.f.z.getBytes(y30.a);
            bytes.getClass();
            String strEncodeToString = Base64.encodeToString(bytes, 2);
            strEncodeToString.getClass();
            v92Var.l("SurfboardProxy", strEncodeToString);
        }
        return new cm2(v92Var);
    }

    public final Object b(hd hdVar) {
        String string = UUID.randomUUID().toString();
        string.getClass();
        String strSubstring = string.substring(0, 8);
        long j = ((long) this.c) * 1000;
        gm0 gm0Var = qv0.a;
        return ji0.b0(pl0.z, new c04(this, j, strSubstring, null), hdVar);
    }
}
