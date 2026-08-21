package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class it0 {
    public volatile gq0 b;

    public final gq0 b() {
        if (this.b == null && (c().k() == zo0.EDITION_PROTO2 || c().k() == zo0.EDITION_PROTO3)) {
            c().m();
        }
        if (this.b != null) {
            return this.b;
        }
        zo2.n(ha0.o("Features not yet loaded for ", d(), "."));
        return null;
    }

    public abstract gt0 c();

    public abstract String d();

    public abstract it0 e();

    public gq0 f() {
        return gq0.G0;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(defpackage.gq0 r11) {
        /*
            Method dump skipped, instruction units count: 495
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.it0.g(gq0):void");
    }

    public abstract String getName();

    public abstract c1 h();

    public void i() {
    }
}
