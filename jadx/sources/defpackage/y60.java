package defpackage;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class y60 implements Consumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ StringBuilder b;

    public /* synthetic */ y60(int i, StringBuilder sb) {
        this.a = i;
        this.b = sb;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.a;
        StringBuilder sb = this.b;
        switch (i) {
            case 0:
                sb.append(" &" + ((f7) obj));
                break;
            case 1:
                sb.append(" <" + ((String) obj) + ">");
                break;
            case 2:
                sb.append(" &" + ((f7) obj));
                break;
            default:
                sb.append(" <" + ((String) obj) + ">");
                break;
        }
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        int i = this.a;
        return Consumer$CC.$default$andThen(this, consumer);
    }
}
