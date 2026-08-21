package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class mo2 extends po2 {
    public final /* synthetic */ int f;
    public final /* synthetic */ String z;

    public /* synthetic */ mo2(String str, int i) {
        this.f = i;
        this.z = str;
    }

    @Override // defpackage.po2
    public final String a(String str) {
        int i = this.f;
        String str2 = this.z;
        switch (i) {
            case 0:
                return fw.y(new StringBuilder(), str2, str);
            default:
                return str + str2;
        }
    }

    public final String toString() {
        switch (this.f) {
            case 0:
                return fw.y(new StringBuilder("[PrefixTransformer('"), this.z, "')]");
            default:
                return fw.y(new StringBuilder("[SuffixTransformer('"), this.z, "')]");
        }
    }
}
