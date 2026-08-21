package defpackage;

import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.card.MaterialCardView;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fb3 extends rg3 {
    public final cm2 u;

    public fb3(cm2 cm2Var) {
        super((FrameLayout) cm2Var.f);
        this.u = cm2Var;
        final vr1 vr1Var = new vr1(2, this);
        ((MaterialCardView) cm2Var.z).setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: eb3
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                cm2 cm2Var2 = this.a.u;
                vr1 vr1Var2 = vr1Var;
                if (z) {
                    FrameLayout frameLayout = (FrameLayout) cm2Var2.f;
                    WeakHashMap weakHashMap = wp4.a;
                    frameLayout.setElevation(1.0f);
                    ((MaterialCardView) cm2Var2.z).animate().scaleX(1.1f).scaleY(1.1f).setDuration(200L).setListener(vr1Var2).start();
                    return;
                }
                FrameLayout frameLayout2 = (FrameLayout) cm2Var2.f;
                WeakHashMap weakHashMap2 = wp4.a;
                frameLayout2.setElevation(0.0f);
                ((MaterialCardView) cm2Var2.z).animate().scaleX(1.0f).scaleY(1.0f).setDuration(200L).setListener(vr1Var2).start();
            }
        });
    }
}
