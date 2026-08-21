package defpackage;

import android.content.Context;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b32 {
    public static final /* synthetic */ d82[] d;
    public final String a;
    public final ThreadLocal b;
    public final qi0 c;

    static {
        r83 r83Var = new r83(qv.b, b32.class, "dataStore", "getDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0);
        dh3.a.getClass();
        d = new d82[]{r83Var};
    }

    public b32(Context context, String str) {
        oj1 oj1Var;
        context.getClass();
        this.a = str;
        this.b = new ThreadLocal();
        int i = 0;
        wn1 wn1Var = new wn1(16, new a32(this, i));
        a32 a32Var = new a32(this, 1);
        gm0 gm0Var = qv0.a;
        pl0 pl0Var = pl0.z;
        r54 r54VarD = gb4.d();
        pl0Var.getClass();
        ce0 ce0VarA = p95.a(tj4.W(pl0Var, r54VarD));
        c33 c33Var = new c33(str, wn1Var, a32Var, ce0VarA);
        d[0].getClass();
        oj1 oj1Var2 = c33Var.c;
        if (oj1Var2 == null) {
            synchronized (c33Var.b) {
                try {
                    if (c33Var.c == null) {
                        Context applicationContext = context.getApplicationContext();
                        applicationContext.getClass();
                        List list = (List) a32Var.g(applicationContext);
                        ig0 ig0Var = new ig0(5, applicationContext, c33Var);
                        list.getClass();
                        int i2 = 19;
                        c33Var.c = new oj1(i2, new oj1(i2, new lj0(new be1(new v10(4, ig0Var)), p95.x(new li0(list, null, i)), wn1Var, ce0VarA)));
                    }
                    oj1Var = c33Var.c;
                    oj1Var.getClass();
                } catch (Throwable th) {
                    throw th;
                }
            }
            oj1Var2 = oj1Var;
        }
        this.c = oj1Var2;
    }
}
