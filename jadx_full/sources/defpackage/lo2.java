package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lo2 extends po2 {
    public final /* synthetic */ String f;
    public final /* synthetic */ String z;

    public lo2(String str, String str2) {
        this.f = str;
        this.z = str2;
    }

    @Override // defpackage.po2
    public final String a(String str) {
        return this.f + str + this.z;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[PreAndSuffixTransformer('");
        sb.append(this.f);
        sb.append("','");
        return fw.y(sb, this.z, "')]");
    }
}
