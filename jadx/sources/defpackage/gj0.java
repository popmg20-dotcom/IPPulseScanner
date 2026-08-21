package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gj0 extends ie0 {
    public Object A;
    public /* synthetic */ Object A0;
    public final /* synthetic */ lj0 B0;
    public int C0;
    public Object X;
    public Serializable Y;
    public bh3 Z;
    public boolean y0;
    public int z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gj0(lj0 lj0Var, ie0 ie0Var) {
        super(ie0Var);
        this.B0 = lj0Var;
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        this.A0 = obj;
        this.C0 |= Integer.MIN_VALUE;
        return this.B0.h(false, this);
    }
}
