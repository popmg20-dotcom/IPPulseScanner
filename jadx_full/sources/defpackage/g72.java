package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public enum g72 {
    /* JADX INFO: Fake field, exist only in values array */
    EF0("NOT_AVAILABLE", null),
    A("START_OBJECT", "{"),
    /* JADX INFO: Fake field, exist only in values array */
    EF3("END_OBJECT", "}"),
    X("START_ARRAY", "["),
    /* JADX INFO: Fake field, exist only in values array */
    EF8("END_ARRAY", "]"),
    /* JADX INFO: Fake field, exist only in values array */
    EF10("FIELD_NAME", null),
    Y("VALUE_EMBEDDED_OBJECT", null),
    Z("VALUE_STRING", null),
    /* JADX INFO: Fake field, exist only in values array */
    EF7("VALUE_NUMBER_INT", null),
    y0("VALUE_NUMBER_FLOAT", null),
    /* JADX INFO: Fake field, exist only in values array */
    EF130("VALUE_TRUE", "true"),
    /* JADX INFO: Fake field, exist only in values array */
    EF143("VALUE_FALSE", "false"),
    /* JADX INFO: Fake field, exist only in values array */
    EF158("VALUE_NULL", "null");

    public final char[] b;
    public final byte[] f;
    public final boolean z;

    g72(String str, String str2) {
        if (str2 == null) {
            this.b = null;
            this.f = null;
        } else {
            char[] charArray = str2.toCharArray();
            this.b = charArray;
            int length = charArray.length;
            this.f = new byte[length];
            for (int i = 0; i < length; i++) {
                this.f[i] = (byte) this.b[i];
            }
        }
        if (i != 10) {
        }
        if (i != 7) {
        }
        this.z = i == 1 || i == 3;
    }
}
