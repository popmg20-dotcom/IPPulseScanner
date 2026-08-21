package defpackage;

import j$.util.Optional;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class z1 extends k70 implements mr3, nw2, v83 {
    @Override // defpackage.v83
    public final Map F() {
        return null;
    }

    public Optional W0() {
        return Optional.empty();
    }

    public boolean X0() {
        boolean zContains;
        List list = nr3.a;
        n12.g(null, "No provider name specified");
        TreeSet treeSet = nr3.e;
        synchronized (treeSet) {
            zContains = treeSet.contains(null);
        }
        if (zContains) {
            return false;
        }
        return x83.a(this, "org.apache.sshd.security.provider.null.".concat("enabled"));
    }

    public boolean Y0() {
        throw null;
    }

    public boolean Z() {
        return x83.a(this, "org.apache.sshd.security.provider.null.".concat("useNamed"));
    }

    @Override // defpackage.to2
    public final String getName() {
        return null;
    }

    @Override // defpackage.v83
    public final v83 q0() {
        return t84.b;
    }

    @Override // defpackage.k70
    public final String toString() {
        return getClass().getSimpleName().concat("[null]");
    }

    public String x0() {
        return null;
    }
}
