package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ya0 extends ie0 {
    public Object A;
    public boolean A0;
    public /* synthetic */ Object B0;
    public final /* synthetic */ za0 C0;
    public int D0;
    public Serializable X;
    public q13 Y;
    public bh3 Z;
    public cf0 y0;
    public bh3 z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ya0(za0 za0Var, ie0 ie0Var) {
        super(ie0Var);
        this.C0 = za0Var;
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        this.B0 = obj;
        this.D0 |= Integer.MIN_VALUE;
        return this.C0.m(false, null, this);
    }
}
