package defpackage;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class h91 {
    public static volatile h91 f;
    public static final ReentrantLock g = new ReentrantLock();
    public final Context a;
    public final c31 b;
    public final CopyOnWriteArrayList c;
    public final eg0 d;
    public final n84 e;

    public h91(Context context, b31 b31Var) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        this.a = context;
        this.b = b31Var;
        g91 g91Var = new g91(this);
        this.c = new CopyOnWriteArrayList();
        if (b31Var != null) {
            b31Var.c(g91Var);
        }
        this.d = new eg0(14);
        this.e = new n84(new fn(3, this));
    }
}
