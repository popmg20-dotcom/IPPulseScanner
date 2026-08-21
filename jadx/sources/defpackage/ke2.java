package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public enum ke2 {
    /* JADX INFO: Fake field, exist only in values array */
    VERBOSE(2),
    DEBUG(3),
    /* JADX INFO: Fake field, exist only in values array */
    INFO(4),
    /* JADX INFO: Fake field, exist only in values array */
    WARN(5),
    ERROR(6),
    /* JADX INFO: Fake field, exist only in values array */
    ASSERT(7);

    public final int b;

    ke2(int i) {
        this.b = i;
    }

    public final int a() {
        return this.b - 2;
    }
}
