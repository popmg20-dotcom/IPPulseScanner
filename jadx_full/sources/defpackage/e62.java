package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public enum e62 implements rj0 {
    /* JADX INFO: Fake field, exist only in values array */
    READ_NULL_PROPERTIES(true),
    /* JADX INFO: Fake field, exist only in values array */
    WRITE_NULL_PROPERTIES(true),
    /* JADX INFO: Fake field, exist only in values array */
    WRITE_PROPERTIES_SORTED(false),
    /* JADX INFO: Fake field, exist only in values array */
    STRIP_TRAILING_BIGDECIMAL_ZEROES(true),
    /* JADX INFO: Fake field, exist only in values array */
    FAIL_ON_NAN_TO_BIG_DECIMAL_COERCION(false),
    /* JADX INFO: Fake field, exist only in values array */
    USE_BIG_DECIMAL_FOR_FLOATS(false);

    public final boolean b;
    public final int f = 1 << ordinal();

    e62(boolean z2) {
        this.b = z2;
    }

    @Override // defpackage.t22
    public final boolean a(int i) {
        return (this.f & i) != 0;
    }

    @Override // defpackage.rj0
    public final int b() {
        return 1;
    }
}
