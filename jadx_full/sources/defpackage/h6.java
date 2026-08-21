package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class h6 {
    public final /* synthetic */ int a;
    public final boolean b;
    public final String c;

    public /* synthetic */ h6(String str, boolean z, int i) {
        this.a = i;
        this.c = str;
        this.b = z;
    }

    public String toString() {
        switch (this.a) {
            case 0:
                String str = this.c;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
                sb.append("{");
                sb.append(str);
                sb.append("}");
                sb.append(this.b);
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ h6(boolean z, String str, int i) {
        this.a = i;
        this.b = z;
        this.c = str;
    }
}
