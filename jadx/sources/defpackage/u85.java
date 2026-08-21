package defpackage;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class u85 implements Callable {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ i95 e;

    public /* synthetic */ u85(i95 i95Var, String str, String str2, String str3, int i) {
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = i95Var;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        int i = this.a;
        String str = this.d;
        String str2 = this.c;
        String str3 = this.b;
        i95 i95Var = this.e;
        switch (i) {
            case 0:
                ff5 ff5Var = i95Var.c;
                ff5Var.x();
                m25 m25Var = ff5Var.z;
                ff5.R(m25Var);
                return m25Var.R1(str3, str2, str);
            case 1:
                ff5 ff5Var2 = i95Var.c;
                ff5Var2.x();
                m25 m25Var2 = ff5Var2.z;
                ff5.R(m25Var2);
                return m25Var2.R1(str3, str2, str);
            case 2:
                ff5 ff5Var3 = i95Var.c;
                ff5Var3.x();
                m25 m25Var3 = ff5Var3.z;
                ff5.R(m25Var3);
                return m25Var3.V1(str3, str2, str);
            default:
                ff5 ff5Var4 = i95Var.c;
                ff5Var4.x();
                m25 m25Var4 = ff5Var4.z;
                ff5.R(m25Var4);
                return m25Var4.V1(str3, str2, str);
        }
    }
}
