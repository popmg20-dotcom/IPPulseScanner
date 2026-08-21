package defpackage;

import androidx.window.extensions.embedding.ActivityStack;
import androidx.window.extensions.embedding.SplitAttributes;
import androidx.window.extensions.embedding.SplitInfo;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class p21 {
    public final /* synthetic */ r21 a;

    public p21(r21 r21Var) {
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
        return new p04(a5VarE, a5VarE2, r21.e(splitAttributes), null, null);
    }
}
