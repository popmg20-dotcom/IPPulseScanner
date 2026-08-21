package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public enum bk2 implements ca3 {
    UNKNOWN(0),
    /* JADX INFO: Fake field, exist only in values array */
    USE_AFTER_FREE(1),
    /* JADX INFO: Fake field, exist only in values array */
    DOUBLE_FREE(2),
    /* JADX INFO: Fake field, exist only in values array */
    INVALID_FREE(3),
    /* JADX INFO: Fake field, exist only in values array */
    BUFFER_OVERFLOW(4),
    /* JADX INFO: Fake field, exist only in values array */
    BUFFER_UNDERFLOW(5),
    UNRECOGNIZED(-1);

    public final int b;

    static {
        ao3.a(4, "Type");
        values();
    }

    bk2(int i) {
        this.b = i;
    }

    @Override // defpackage.g12
    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.b;
        }
        xe.k("Can't get the number of an unknown enum value.");
        return 0;
    }
}
