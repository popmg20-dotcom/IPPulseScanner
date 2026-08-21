package defpackage;

import android.os.Bundle;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jp3 {
    public final kp3 a;
    public final fn b;
    public boolean e;
    public Bundle f;
    public boolean g;
    public final p84 c = new p84(0);
    public final LinkedHashMap d = new LinkedHashMap();
    public boolean h = true;

    public jp3(kp3 kp3Var, fn fnVar) {
        this.a = kp3Var;
        this.b = fnVar;
    }

    public final void a() {
        kp3 kp3Var = this.a;
        if (kp3Var.getLifecycle().b() != q92.f) {
            xe.q("Restarter must be created only during owner's initialization stage");
        } else {
            if (this.e) {
                xe.q("SavedStateRegistry was already attached.");
                return;
            }
            this.b.a();
            kp3Var.getLifecycle().a(new b90(2, this));
            this.e = true;
        }
    }
}
