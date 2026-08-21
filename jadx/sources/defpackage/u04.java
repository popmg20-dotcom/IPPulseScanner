package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class u04 {
    public static final u04 d = new u04("NEVER", 0, 0);
    public static final u04 e = new u04("ALWAYS", 1, 0);
    public static final u04 f = new u04("ADJACENT", 2, 0);
    public final /* synthetic */ int a;
    public final String b;
    public final int c;

    public u04(String str, int i, int i2) {
        this.a = i2;
        switch (i2) {
            case 1:
                this.b = str;
                this.c = i;
                if (i < 0 || i > str.length()) {
                    xe.k("invalid shiftLeft");
                    throw null;
                }
                return;
            default:
                this.b = str;
                this.c = i;
                return;
        }
    }

    public int hashCode() {
        switch (this.a) {
            case 0:
                return (this.b.hashCode() * 31) + this.c;
            default:
                return super.hashCode();
        }
    }

    public String toString() {
        switch (this.a) {
            case 0:
                return this.b;
            default:
                return super.toString();
        }
    }
}
