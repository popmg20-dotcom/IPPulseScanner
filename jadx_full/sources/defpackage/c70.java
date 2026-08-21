package defpackage;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c70 implements ii4 {
    public final /* synthetic */ int b;
    public final lb f;

    public /* synthetic */ c70(lb lbVar, int i) {
        this.b = i;
        this.f = lbVar;
    }

    @Override // defpackage.ii4
    public final hi4 a(iq1 iq1Var, bk4 bk4Var) {
        Class cls;
        Type[] actualTypeArguments;
        int i = this.b;
        lb lbVar = this.f;
        cls = Object.class;
        switch (i) {
            case 0:
                Type type = bk4Var.b;
                Class cls2 = bk4Var.a;
                if (!Collection.class.isAssignableFrom(cls2)) {
                    return null;
                }
                Type typeD = l72.D(type, cls2, Collection.class);
                cls = typeD instanceof ParameterizedType ? ((ParameterizedType) typeD).getActualTypeArguments()[0] : Object.class;
                return new b70(new xg2(iq1Var, iq1Var.d(new bk4(cls)), cls), lbVar.t(bk4Var, false));
            default:
                Type type2 = bk4Var.b;
                Class cls3 = bk4Var.a;
                if (!Map.class.isAssignableFrom(cls3)) {
                    return null;
                }
                if (Properties.class.isAssignableFrom(cls3)) {
                    actualTypeArguments = new Type[]{String.class, String.class};
                } else {
                    Type typeD2 = l72.D(type2, cls3, Map.class);
                    actualTypeArguments = typeD2 instanceof ParameterizedType ? ((ParameterizedType) typeD2).getActualTypeArguments() : new Type[]{cls, cls};
                }
                Type type3 = actualTypeArguments[0];
                Type type4 = actualTypeArguments[1];
                return new xg2(this, new xg2(iq1Var, (type3 == Boolean.TYPE || type3 == Boolean.class) ? mj4.c : iq1Var.d(new bk4(type3)), type3), new xg2(iq1Var, iq1Var.d(new bk4(type4)), type4), lbVar.t(bk4Var, false));
        }
    }
}
