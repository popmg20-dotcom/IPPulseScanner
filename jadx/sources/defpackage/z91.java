package defpackage;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import androidx.window.extensions.layout.FoldingFeature;
import androidx.window.extensions.layout.WindowLayoutInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class z91 {
    public static cr1 a(jv4 jv4Var, FoldingFeature foldingFeature) {
        br1 br1Var;
        th1 th1Var;
        jv4Var.getClass();
        foldingFeature.getClass();
        int type = foldingFeature.getType();
        if (type == 1) {
            br1Var = br1.z;
        } else {
            if (type != 2) {
                return null;
            }
            br1Var = br1.A;
        }
        int state = foldingFeature.getState();
        if (state == 1) {
            th1Var = th1.z;
        } else {
            if (state != 2) {
                return null;
            }
            th1Var = th1.A;
        }
        Rect bounds = foldingFeature.getBounds();
        bounds.getClass();
        yo yoVar = new yo(bounds);
        Rect rectC = jv4Var.a.c();
        if (yoVar.a() == 0 && yoVar.b() == 0) {
            return null;
        }
        if (yoVar.b() != rectC.width() && yoVar.a() != rectC.height()) {
            return null;
        }
        if (yoVar.b() < rectC.width() && yoVar.a() < rectC.height()) {
            return null;
        }
        if (yoVar.b() == rectC.width() && yoVar.a() == rectC.height()) {
            return null;
        }
        Rect bounds2 = foldingFeature.getBounds();
        bounds2.getClass();
        return new cr1(new yo(bounds2), br1Var, th1Var);
    }

    public static iv4 b(jv4 jv4Var, WindowLayoutInfo windowLayoutInfo) {
        jv4Var.getClass();
        List<FoldingFeature> displayFeatures = windowLayoutInfo.getDisplayFeatures();
        displayFeatures.getClass();
        ArrayList arrayList = new ArrayList();
        for (FoldingFeature foldingFeature : displayFeatures) {
            cr1 cr1VarA = foldingFeature instanceof FoldingFeature ? a(jv4Var, foldingFeature) : null;
            if (cr1VarA != null) {
                arrayList.add(cr1VarA);
            }
        }
        return new iv4(arrayList);
    }

    public static iv4 c(Context context, WindowLayoutInfo windowLayoutInfo) {
        kv4 kv4Var = t60.A0;
        bp bpVar = bp.f;
        fo0 fo0Var = fo0.f;
        int i = Build.VERSION.SDK_INT;
        eo0 eo0Var = i >= 34 ? fo0.b : k01.z;
        new ArrayList(new yd(new Integer[]{1, 2, 4, 8, 16, 32, 64, 128}, true));
        if (i >= 30) {
            if (i >= 34) {
                kv4Var = fo0Var;
            } else if (i >= 30) {
                kv4Var = bpVar;
            }
            return b(kv4Var.c(context, eo0Var), windowLayoutInfo);
        }
        if (i < 29 || !(context instanceof Activity)) {
            vp1.n("Display Features are only supported after Q. Display features for non-Activity contexts are not expected to be reported on devices running Q.");
            return null;
        }
        Activity activity = (Activity) context;
        if (i >= 34) {
            kv4Var = fo0Var;
        } else if (i >= 30) {
            kv4Var = bpVar;
        }
        return b(kv4Var.a(activity, eo0Var), windowLayoutInfo);
    }
}
