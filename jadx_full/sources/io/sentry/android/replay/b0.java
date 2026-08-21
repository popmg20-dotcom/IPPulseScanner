package io.sentry.android.replay;

import android.view.View;
import defpackage.am1;
import defpackage.n12;
import defpackage.r82;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b0 extends r82 implements am1 {
    public final /* synthetic */ int f;
    public final /* synthetic */ View z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b0(View view, int i) {
        super(1);
        this.f = i;
        this.z = view;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) {
        int i = this.f;
        View view = this.z;
        switch (i) {
            case 0:
                WeakReference weakReference = (WeakReference) obj;
                weakReference.getClass();
                return Boolean.valueOf(n12.c(weakReference.get(), view));
            default:
                WeakReference weakReference2 = (WeakReference) obj;
                weakReference2.getClass();
                return Boolean.valueOf(n12.c(weakReference2.get(), view));
        }
    }
}
