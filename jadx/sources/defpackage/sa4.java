package defpackage;

import android.util.Log;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sa4 implements vi1 {
    public ed4 f;
    public final ArrayList z;
    public final ArrayDeque b = new ArrayDeque();
    public boolean A = false;

    public sa4(vd3 vd3Var) {
        co4.h();
        this.z = new ArrayList();
    }

    @Override // defpackage.vi1
    public final void a(wi1 wi1Var) {
        ((xq1) vf2.q()).execute(new ga1(24, this));
    }

    public final void b() {
        co4.h();
        new w9("Camera is closed.", null);
        ArrayDeque arrayDeque = this.b;
        Iterator it = arrayDeque.iterator();
        if (it.hasNext()) {
            throw dw2.z(it);
        }
        arrayDeque.clear();
        Iterator it2 = new ArrayList(this.z).iterator();
        if (it2.hasNext()) {
            dw2.I(it2.next());
            throw null;
        }
    }

    public final void c() {
        int iS;
        co4.h();
        Log.d("TakePictureManagerImpl", "Issue the next TakePictureRequest.");
        if (this.A) {
            Log.d("TakePictureManagerImpl", "The class is paused.");
            return;
        }
        ed4 ed4Var = this.f;
        ed4Var.getClass();
        co4.h();
        ed4 ed4Var2 = (ed4) ed4Var.z;
        co4.h();
        r25.j("The ImageReader is not initialized.", ((e10) ed4Var2.f) != null);
        e10 e10Var = (e10) ed4Var2.f;
        synchronized (e10Var.z) {
            iS = ((oy1) e10Var.A).s() - e10Var.b;
        }
        if (iS == 0) {
            Log.d("TakePictureManagerImpl", "Too many acquire images. Close image to be able to process next.");
        } else if (this.b.poll() == null) {
            Log.d("TakePictureManagerImpl", "No new request.");
        } else {
            st4.n();
        }
    }
}
