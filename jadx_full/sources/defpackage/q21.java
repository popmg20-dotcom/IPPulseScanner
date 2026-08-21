package defpackage;

import android.os.IBinder;
import androidx.window.extensions.embedding.ActivityStack;
import androidx.window.extensions.embedding.SplitAttributes;
import androidx.window.extensions.embedding.SplitInfo;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q21 {
    public final /* synthetic */ r21 a;

    public q21(r21 r21Var) {
        this.a = r21Var;
    }

    public final p04 a(SplitInfo splitInfo) {
        splitInfo.getClass();
        o21 o21Var = this.a.b;
        ActivityStack primaryActivityStack = splitInfo.getPrimaryActivityStack();
        primaryActivityStack.getClass();
        o21Var.getClass();
        a5 a5VarE = o21.e(primaryActivityStack);
        ActivityStack secondaryActivityStack = splitInfo.getSecondaryActivityStack();
        secondaryActivityStack.getClass();
        o21Var.getClass();
        a5 a5VarE2 = o21.e(secondaryActivityStack);
        SplitAttributes splitAttributes = splitInfo.getSplitAttributes();
        splitAttributes.getClass();
        n04 n04VarE = r21.e(splitAttributes);
        IBinder token = splitInfo.getToken();
        token.getClass();
        p04 p04Var = new p04(a5VarE, a5VarE2, n04VarE, token, null);
        int iA = y91.a();
        b12 b12Var = new b12(3, 4, 1);
        if (3 <= iA && iA <= b12Var.f) {
            return p04Var;
        }
        throw new UnsupportedOperationException("This API requires extension version " + b12Var + ", but the device is on " + iA);
    }
}
