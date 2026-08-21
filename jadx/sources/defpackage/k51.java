package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public enum k51 implements rj0 {
    /* JADX INFO: Fake field, exist only in values array */
    READ_ENUM_KEYS_USING_INDEX,
    WRITE_ENUMS_TO_LOWERCASE;

    public final int b = 1 << ordinal();

    k51() {
    }

    @Override // defpackage.t22
    public final boolean a(int i) {
        return (this.b & i) != 0;
    }

    @Override // defpackage.rj0
    public final int b() {
        return 0;
    }
}
