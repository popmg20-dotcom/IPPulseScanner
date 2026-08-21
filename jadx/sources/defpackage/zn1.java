package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zn1 implements ll2 {
    public static final zn1 b = new zn1(0);
    public final /* synthetic */ int a;

    public /* synthetic */ zn1(int i) {
        this.a = i;
    }

    @Override // defpackage.ll2
    public final qd3 a(Class cls) {
        switch (this.a) {
            case 0:
                if (!co1.class.isAssignableFrom(cls)) {
                    xe.k("Unsupported message type: ".concat(cls.getName()));
                    return null;
                }
                try {
                    return (qd3) co1.d(cls.asSubclass(co1.class)).c(3);
                } catch (Exception e) {
                    zo2.o("Unable to get message info for ".concat(cls.getName()), e);
                    return null;
                }
            default:
                throw new IllegalStateException("This should never be called.");
        }
    }

    @Override // defpackage.ll2
    public final boolean b(Class cls) {
        switch (this.a) {
            case 0:
                return co1.class.isAssignableFrom(cls);
            default:
                return false;
        }
    }
}
