package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class uh {
    public static final /* synthetic */ AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(uh.class, "notCompletedCount$volatile");
    public final fn0[] a;
    private volatile /* synthetic */ int notCompletedCount$volatile;

    public uh(fn0[] fn0VarArr) {
        this.a = fn0VarArr;
        this.notCompletedCount$volatile = fn0VarArr.length;
    }
}
