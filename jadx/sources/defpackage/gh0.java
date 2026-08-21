package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class gh0 implements to2 {
    public final /* synthetic */ int b;
    public final /* synthetic */ wr f;

    public /* synthetic */ gh0(wr wrVar, int i) {
        this.b = i;
        this.f = wrVar;
    }

    @Override // defpackage.to2
    public final String getName() {
        int i = this.b;
        wr wrVar = this.f;
        switch (i) {
        }
        return wrVar.b;
    }

    public final String toString() {
        int i = this.b;
        wr wrVar = this.f;
        switch (i) {
            case 0:
                StringBuilder sb = new StringBuilder(qo2.class.getSimpleName());
                sb.append("<");
                sb.append(i82.class.getSimpleName());
                sb.append(">[");
                return fw.y(sb, wrVar.b, "]");
            default:
                StringBuilder sb2 = new StringBuilder(qo2.class.getSimpleName());
                sb2.append("<");
                sb2.append(i82.class.getSimpleName());
                sb2.append(">[");
                return fw.y(sb2, wrVar.b, "]");
        }
    }
}
