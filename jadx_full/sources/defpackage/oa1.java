package defpackage;

import android.os.Bundle;
import androidx.fragment.app.o;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class oa1 extends kk1 {
    @Override // defpackage.rf3
    public final int b() {
        return 3;
    }

    @Override // defpackage.kk1
    public final o s(int i) {
        if (i == 0) {
            Bundle bundle = new Bundle();
            bundle.putInt("type", 0);
            ma1 ma1Var = new ma1();
            ma1Var.setArguments(bundle);
            return ma1Var;
        }
        if (i == 1) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("type", 1);
            ma1 ma1Var2 = new ma1();
            ma1Var2.setArguments(bundle2);
            return ma1Var2;
        }
        if (i != 2) {
            xe.q("Unknown external resource index");
            return null;
        }
        Bundle bundle3 = new Bundle();
        bundle3.putInt("type", 2);
        ma1 ma1Var3 = new ma1();
        ma1Var3.setArguments(bundle3);
        return ma1Var3;
    }
}
