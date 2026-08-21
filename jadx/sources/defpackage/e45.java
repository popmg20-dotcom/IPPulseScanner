package defpackage;

import android.os.Bundle;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class e45 implements jb5 {
    public final /* synthetic */ b55 a;

    public e45(b55 b55Var) {
        this.a = b55Var;
    }

    @Override // defpackage.jb5
    public final void b(String str, String str2, Bundle bundle) {
        b55 b55Var = this.a;
        b55Var.a(new u45(b55Var, str, str2, bundle, true));
    }

    @Override // defpackage.jb5
    public final String c() {
        q35 q35Var = new q35();
        b55 b55Var = this.a;
        b55Var.a(new q45(b55Var, q35Var, 3));
        return (String) q35.c(q35Var.b(500L), String.class);
    }

    @Override // defpackage.jb5
    public final String d() {
        q35 q35Var = new q35();
        b55 b55Var = this.a;
        b55Var.a(new q45(b55Var, q35Var, 4));
        return (String) q35.c(q35Var.b(500L), String.class);
    }

    @Override // defpackage.jb5
    public final void e(Bundle bundle) {
        b55 b55Var = this.a;
        b55Var.a(new l45(b55Var, bundle, 0));
    }

    @Override // defpackage.jb5
    public final void f(String str) {
        b55 b55Var = this.a;
        b55Var.a(new o45(b55Var, str, 1));
    }

    @Override // defpackage.jb5
    public final void g(String str) {
        b55 b55Var = this.a;
        b55Var.a(new o45(b55Var, str, 0));
    }

    @Override // defpackage.jb5
    public final long h() {
        q35 q35Var = new q35();
        b55 b55Var = this.a;
        b55Var.a(new q45(b55Var, q35Var, 2));
        Long l = (Long) q35.c(q35Var.b(500L), Long.class);
        if (l != null) {
            return l.longValue();
        }
        long jNextLong = new Random(System.nanoTime() ^ System.currentTimeMillis()).nextLong();
        int i = b55Var.c + 1;
        b55Var.c = i;
        return jNextLong + ((long) i);
    }

    @Override // defpackage.jb5
    public final void i(String str, String str2, Bundle bundle) {
        b55 b55Var = this.a;
        b55Var.a(new m45(b55Var, str, str2, bundle, 0));
    }

    @Override // defpackage.jb5
    public final List j(String str, String str2) {
        q35 q35Var = new q35();
        b55 b55Var = this.a;
        b55Var.a(new m45(b55Var, str, str2, q35Var, 1));
        List list = (List) q35.c(q35Var.b(5000L), List.class);
        return list == null ? Collections.EMPTY_LIST : list;
    }

    @Override // defpackage.jb5
    public final int k(String str) {
        q35 q35Var = new q35();
        b55 b55Var = this.a;
        b55Var.a(new n45(b55Var, str, q35Var, 1));
        Integer num = (Integer) q35.c(q35Var.b(10000L), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    @Override // defpackage.jb5
    public final String l() {
        q35 q35Var = new q35();
        b55 b55Var = this.a;
        b55Var.a(new q45(b55Var, q35Var, 1));
        return (String) q35.c(q35Var.b(50L), String.class);
    }

    @Override // defpackage.jb5
    public final String m() {
        q35 q35Var = new q35();
        b55 b55Var = this.a;
        b55Var.a(new q45(b55Var, q35Var, 0));
        return (String) q35.c(q35Var.b(500L), String.class);
    }

    @Override // defpackage.jb5
    public final Map n(String str, String str2, boolean z) {
        q35 q35Var = new q35();
        b55 b55Var = this.a;
        b55Var.a(new u45(b55Var, str, str2, z, q35Var));
        Bundle bundleB = q35Var.b(5000L);
        if (bundleB == null || bundleB.size() == 0) {
            return Collections.EMPTY_MAP;
        }
        HashMap map = new HashMap(bundleB.size());
        for (String str3 : bundleB.keySet()) {
            Object obj = bundleB.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                map.put(str3, obj);
            }
        }
        return map;
    }
}
