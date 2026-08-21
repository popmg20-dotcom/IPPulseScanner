package defpackage;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class t45 implements Callable {
    public static final /* synthetic */ t45 a = new t45();

    @Override // java.util.concurrent.Callable
    public final Object call() {
        uc5 uc5Var = new uc5("internal.platform", 4);
        uc5Var.f.put("getVersion", new uc5("getVersion", 3));
        return uc5Var;
    }
}
