package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class ba0 implements to2 {
    public final String b;
    public final /* synthetic */ int f;

    public ba0(String str, int i) {
        this.f = i;
        this.b = n12.g(str, "No compression name");
    }

    public final String a() {
        return this.b;
    }

    @Override // defpackage.to2
    public final String getName() {
        return this.b;
    }

    public String toString() {
        switch (this.f) {
            case 0:
                return fw.y(new StringBuilder(), this.b, "[null/0]");
            default:
                return a();
        }
    }
}
