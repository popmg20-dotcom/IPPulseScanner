package io.sentry.android.fragment;

import defpackage.bh3;
import defpackage.p44;
import io.sentry.android.replay.ReplayIntegration;
import io.sentry.d1;
import io.sentry.h4;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements h4 {
    public final /* synthetic */ int b;
    public final /* synthetic */ bh3 f;

    public /* synthetic */ c(bh3 bh3Var, int i) {
        this.b = i;
        this.f = bh3Var;
    }

    @Override // io.sentry.h4
    public final void m(d1 d1Var) {
        int i = this.b;
        bh3 bh3Var = this.f;
        switch (i) {
            case 0:
                d1Var.getClass();
                bh3Var.b = d1Var.i();
                break;
            case 1:
                int i2 = ReplayIntegration.J0;
                d1Var.getClass();
                String strC = d1Var.C();
                bh3Var.b = strC != null ? p44.P0(strC, '.', strC) : null;
                break;
            default:
                d1Var.getClass();
                bh3Var.b = new ArrayList(d1Var.q());
                break;
        }
    }
}
