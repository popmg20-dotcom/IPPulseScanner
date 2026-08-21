package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class hh2 implements we2, Serializable {
    public String b;

    @Override // defpackage.we2
    public String getName() {
        return this.b;
    }

    public final String toString() {
        return getClass().getName() + "(" + getName() + ")";
    }
}
