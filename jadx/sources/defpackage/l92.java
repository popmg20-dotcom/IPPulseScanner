package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public enum l92 {
    /* JADX INFO: Fake field, exist only in values array */
    ERROR("ERROR"),
    /* JADX INFO: Fake field, exist only in values array */
    WARN("WARN"),
    /* JADX INFO: Fake field, exist only in values array */
    INFO("INFO"),
    /* JADX INFO: Fake field, exist only in values array */
    DEBUG("DEBUG"),
    /* JADX INFO: Fake field, exist only in values array */
    TRACE("TRACE");

    public final String b;

    l92(String str) {
        this.b = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.b;
    }
}
