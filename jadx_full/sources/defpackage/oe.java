package defpackage;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class oe implements ii4 {
    @Override // defpackage.ii4
    public final hi4 a(iq1 iq1Var, bk4 bk4Var) {
        Type type = bk4Var.b;
        boolean z = type instanceof GenericArrayType;
        if (!z && (!(type instanceof Class) || !((Class) type).isArray())) {
            return null;
        }
        Type genericComponentType = z ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
        return new pe(iq1Var, iq1Var.d(new bk4(genericComponentType)), l72.B(genericComponentType));
    }
}
