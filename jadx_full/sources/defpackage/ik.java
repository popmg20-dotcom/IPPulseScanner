package defpackage;

import j$.util.Optional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ik implements Supplier {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;

    public /* synthetic */ ik(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i = this.b;
        Object obj = this.f;
        switch (i) {
            case 0:
                ds2 ds2Var = (ds2) obj;
                return new v90(null, Optional.empty(), "could not determine a constructor for the tag " + ds2Var.b, ds2Var.a, null);
            case 1:
                return new ArrayList((List) obj);
            case 2:
                return new HashMap((Map) obj);
            case 3:
                return obj;
            default:
                return ((Class) obj).getClassLoader();
        }
    }
}
