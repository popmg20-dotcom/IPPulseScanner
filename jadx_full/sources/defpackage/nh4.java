package defpackage;

import java.util.ArrayList;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class nh4 implements ag1 {
    public final /* synthetic */ String[] A;
    public final /* synthetic */ int[] X;
    public final /* synthetic */ bh3 b;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ ag1 z;

    public nh4(bh3 bh3Var, boolean z, ag1 ag1Var, String[] strArr, int[] iArr) {
        this.b = bh3Var;
        this.f = z;
        this.z = ag1Var;
        this.A = strArr;
        this.X = iArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0061, code lost:
    
        if (r9.h(r2, r3) == r10) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a9, code lost:
    
        if (r9.h(r2, r3) == r10) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ab, code lost:
    
        return r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Override // defpackage.ag1
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(int[] iArr, ge0 ge0Var) {
        mh4 mh4Var;
        nh4 nh4Var = this;
        int[] iArr2 = iArr;
        if (ge0Var instanceof mh4) {
            mh4Var = (mh4) ge0Var;
            int i = mh4Var.y0;
            if ((i & Integer.MIN_VALUE) != 0) {
                mh4Var.y0 = i - Integer.MIN_VALUE;
            } else {
                mh4Var = new mh4(nh4Var, ge0Var);
            }
        }
        Object obj = mh4Var.Y;
        int i2 = mh4Var.y0;
        Object obj2 = null;
        if (i2 == 0) {
            n12.S(obj);
            bh3 bh3Var = nh4Var.b;
            Object obj3 = bh3Var.b;
            String[] strArr = nh4Var.A;
            ag1 ag1Var = nh4Var.z;
            mf0 mf0Var = mf0.b;
            if (obj3 != null) {
                ArrayList arrayList = new ArrayList();
                int length = strArr.length;
                int i3 = 0;
                int i4 = 0;
                while (i3 < length) {
                    String str = strArr[i3];
                    int i5 = i4 + 1;
                    Object obj4 = bh3Var.b;
                    if (obj4 == null) {
                        Object obj5 = obj2;
                        xe.q("Required value was null.");
                        return obj5;
                    }
                    Object obj6 = obj2;
                    int i6 = nh4Var.X[i4];
                    if (((int[]) obj4)[i6] != iArr2[i6]) {
                        arrayList.add(str);
                    }
                    i3++;
                    obj2 = obj6;
                    i4 = i5;
                }
                if (!arrayList.isEmpty()) {
                    Set setC0 = d70.C0(arrayList);
                    mh4Var.A = nh4Var;
                    mh4Var.X = iArr2;
                    mh4Var.y0 = 2;
                }
            } else if (nh4Var.f) {
                Set setT0 = qe.t0(strArr);
                mh4Var.A = nh4Var;
                mh4Var.X = iArr2;
                mh4Var.y0 = 1;
            }
        } else {
            if (i2 != 1 && i2 != 2) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            int[] iArr3 = mh4Var.X;
            nh4 nh4Var2 = mh4Var.A;
            n12.S(obj);
            iArr2 = iArr3;
            nh4Var = nh4Var2;
        }
        nh4Var.b.b = iArr2;
        return xl4.a;
    }
}
