package defpackage;

import android.os.Handler;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class v80 {
    public final Handler d;
    public final r01 e;
    public i60 f;
    public boolean g = false;
    public final ArrayList a = new ArrayList();
    public final ArrayList b = new ArrayList();
    public final ReentrantLock c = new ReentrantLock(true);

    public v80(Handler handler, r01 r01Var) {
        this.d = handler;
        this.e = r01Var;
    }
}
