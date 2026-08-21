package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class hq extends zw3 {
    public final /* synthetic */ int Z = 0;
    public final Object y0;

    public hq(String str, Object obj, ArrayList arrayList) {
        super(str, obj);
        this.y0 = arrayList;
    }

    @Override // defpackage.zw3
    public final void Y0(boolean z) {
        int i = this.Z;
        Object obj = this.y0;
        switch (i) {
            case 0:
                try {
                    ((Runnable) obj).run();
                    return;
                } finally {
                    super.Y0(z);
                }
            default:
                new xs3(this, ((Iterable) obj).iterator(), z).s(null);
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hq(String str, Object obj, Runnable runnable) {
        super(str, obj);
        this.y0 = runnable;
    }
}
