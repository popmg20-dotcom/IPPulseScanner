package defpackage;

import android.view.View;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class jw implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ int f;
    public final /* synthetic */ Object z;

    public /* synthetic */ jw(int i, int i2, Object obj) {
        this.b = i2;
        this.z = obj;
        this.f = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.b) {
            case 0:
                ((yx) this.z).a(this.f);
                return;
            case 1:
                LinkedHashSet<m84> linkedHashSet = (LinkedHashSet) this.z;
                int i = this.f;
                for (m84 m84Var : linkedHashSet) {
                    if (i == 5) {
                        synchronized (m84Var.p) {
                            try {
                                if (m84Var.m() && m84Var.q != null) {
                                    m84Var.k("Close DeferrableSurfaces for CameraDevice error.");
                                    Iterator it = m84Var.q.iterator();
                                    while (it.hasNext()) {
                                        ((dn0) it.next()).a();
                                    }
                                }
                            } finally {
                            }
                        }
                    } else {
                        m84Var.getClass();
                    }
                }
                return;
            case 2:
                ((ji0) this.z).E(this.f);
                return;
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.z;
                int i2 = this.f;
                WeakReference weakReference = sideSheetBehavior.G0;
                View view = weakReference != null ? (View) weakReference.get() : null;
                if (view != null) {
                    sideSheetBehavior.z(view, i2, false);
                    return;
                }
                return;
        }
    }
}
