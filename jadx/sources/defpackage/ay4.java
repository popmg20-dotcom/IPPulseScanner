package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ay4 {
    public static final ay4 b;
    public ey2 a;

    static {
        ay4 ay4Var = new ay4();
        ay4Var.a = null;
        b = ay4Var;
    }

    public static ey2 a(Context context) {
        ey2 ey2Var;
        ay4 ay4Var = b;
        synchronized (ay4Var) {
            try {
                ey2Var = ay4Var.a;
                if (ey2Var == null) {
                    if (context.getApplicationContext() != null) {
                        context = context.getApplicationContext();
                    }
                    ey2Var = new ey2(context);
                    ay4Var.a = ey2Var;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return ey2Var;
    }
}
