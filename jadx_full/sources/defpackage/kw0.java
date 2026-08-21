package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class kw0 {
    public static final ew0 c = new ew0(-1, -16777216);
    public final int a;
    public final int b;

    public kw0(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(kw0.class.getSimpleName());
        sb.append("{width=");
        sb.append(this.a);
        sb.append(", color=");
        return ha0.p(sb, this.b, '}');
    }
}
