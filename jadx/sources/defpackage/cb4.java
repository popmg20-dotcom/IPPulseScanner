package defpackage;

import j$.util.DesugarCollections;
import java.util.EnumSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public enum cb4 implements to2 {
    /* JADX INFO: Fake field, exist only in values array */
    Direct("direct-tcpip"),
    /* JADX INFO: Fake field, exist only in values array */
    Forwarded("forwarded-tcpip");

    public static final Set f = DesugarCollections.unmodifiableSet(EnumSet.allOf(cb4.class));
    public final String b;

    cb4(String str) {
        this.b = str;
    }

    @Override // defpackage.to2
    public final String getName() {
        return this.b;
    }
}
