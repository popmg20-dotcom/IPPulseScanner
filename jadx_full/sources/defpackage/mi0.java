package defpackage;

import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class mi0 extends ie0 {
    public Serializable A;
    public Iterator X;
    public /* synthetic */ Object Y;
    public final /* synthetic */ d7 Z;
    public int y0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mi0(d7 d7Var, ie0 ie0Var) {
        super(ie0Var);
        this.Z = d7Var;
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        this.Y = obj;
        this.y0 |= Integer.MIN_VALUE;
        return this.Z.q(null, null, this);
    }
}
