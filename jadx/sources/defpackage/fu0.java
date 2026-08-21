package defpackage;

import android.util.Log;
import android.view.View;
import androidx.fragment.app.i;
import androidx.fragment.app.u;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fu0 implements hu2 {
    public final /* synthetic */ i b;

    public fu0(i iVar) {
        this.b = iVar;
    }

    @Override // defpackage.hu2
    public final void b(Object obj) {
        if (((da2) obj) != null) {
            i iVar = this.b;
            if (iVar.y0) {
                View viewRequireView = iVar.requireView();
                if (viewRequireView.getParent() != null) {
                    xe.q("DialogFragment can not be attached to a container view");
                    return;
                }
                if (iVar.C0 != null) {
                    if (u.M(3)) {
                        Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + iVar.C0);
                    }
                    iVar.C0.setContentView(viewRequireView);
                }
            }
        }
    }
}
