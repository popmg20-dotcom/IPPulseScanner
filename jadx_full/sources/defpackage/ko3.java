package defpackage;

import android.app.Activity;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ko3 implements pl1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ lo3 f;

    public /* synthetic */ ko3(lo3 lo3Var, int i) {
        this.b = i;
        this.f = lo3Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0097  */
    @Override // defpackage.pl1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a() throws NoSuchMethodException, ClassNotFoundException {
        boolean zIsPublic;
        boolean z;
        int i = this.b;
        Class clsJ0 = null;
        lo3 lo3Var = this.f;
        switch (i) {
            case 0:
                Method method = lo3Var.b().getMethod("clearEmbeddedActivityWindowInfoCallback", null);
                method.getClass();
                zIsPublic = Modifier.isPublic(method.getModifiers());
                break;
            case 1:
                Method method2 = lo3Var.b().getMethod("clearSplitInfoCallback", null);
                method2.getClass();
                zIsPublic = Modifier.isPublic(method2.getModifiers());
                break;
            case 2:
                Method method3 = lo3Var.b().getMethod("invalidateTopVisibleSplitAttributes", null);
                method3.getClass();
                zIsPublic = Modifier.isPublic(method3.getModifiers());
                break;
            case 3:
                Method method4 = lo3Var.b().getMethod("isActivityEmbedded", Activity.class);
                if (dw2.H(method4)) {
                    Class cls = Boolean.TYPE;
                    z = dw2.G(cls, method4, cls);
                }
                return Boolean.valueOf(z);
            case 4:
                try {
                    clsJ0 = lo3Var.b.j0();
                    break;
                } catch (ClassNotFoundException unused) {
                }
                return Boolean.valueOf(clsJ0 != null ? dw2.H(lo3Var.b().getMethod("setSplitInfoCallback", clsJ0)) : false);
            case 5:
                Method method5 = lo3Var.b().getMethod("setEmbeddingRules", Set.class);
                method5.getClass();
                zIsPublic = Modifier.isPublic(method5.getModifiers());
                break;
            default:
                Class<?> clsLoadClass = lo3Var.d.a.loadClass("androidx.window.extensions.WindowExtensions");
                clsLoadClass.getClass();
                Method method6 = clsLoadClass.getMethod("getActivityEmbeddingComponent", null);
                return Boolean.valueOf(dw2.H(method6) && method6.getReturnType().equals(lo3Var.b()));
        }
        return Boolean.valueOf(zIsPublic);
    }
}
