package defpackage;

import java.util.function.ToIntFunction;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class at0 implements ToIntFunction {
    public final /* synthetic */ int a;

    public /* synthetic */ at0(int i) {
        this.a = i;
    }

    @Override // java.util.function.ToIntFunction
    public final int applyAsInt(Object obj) {
        switch (this.a) {
            case 0:
                return ((bt0) obj).z.Z;
            case 1:
                return ((ft0) obj).z.Z;
            default:
                return ((Integer) obj).intValue();
        }
    }
}
