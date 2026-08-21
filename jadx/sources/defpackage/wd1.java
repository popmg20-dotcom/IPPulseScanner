package defpackage;

import java.io.FileInputStream;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wd1 extends ie0 {
    public Object A;
    public FileInputStream X;
    public /* synthetic */ Object Y;
    public final /* synthetic */ xd1 Z;
    public int y0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wd1(xd1 xd1Var, ie0 ie0Var) {
        super(ie0Var);
        this.Z = xd1Var;
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        this.Y = obj;
        this.y0 |= Integer.MIN_VALUE;
        return xd1.a(this.Z, this);
    }
}
