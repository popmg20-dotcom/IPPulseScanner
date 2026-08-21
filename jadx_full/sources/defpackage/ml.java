package defpackage;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import com.google.android.material.snackbar.BaseTransientBottomBar$Behavior;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ml implements Handler.Callback {
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        int i = message.what;
        int i2 = 0;
        if (i == 0) {
            sl slVar = (sl) message.obj;
            rl rlVar = slVar.i;
            if (rlVar.getParent() == null) {
                ViewGroup.LayoutParams layoutParams = rlVar.getLayoutParams();
                if (layoutParams instanceof te0) {
                    te0 te0Var = (te0) layoutParams;
                    BaseTransientBottomBar$Behavior baseTransientBottomBar$Behavior = new BaseTransientBottomBar$Behavior();
                    cp1 cp1Var = baseTransientBottomBar$Behavior.z0;
                    cp1Var.getClass();
                    cp1Var.f = slVar.u;
                    baseTransientBottomBar$Behavior.f = new zf2(8, slVar);
                    te0Var.b(baseTransientBottomBar$Behavior);
                    te0Var.g = 80;
                }
                ViewGroup viewGroup = slVar.g;
                rlVar.E0 = true;
                viewGroup.addView(rlVar);
                rlVar.E0 = false;
                slVar.f();
                rlVar.setVisibility(4);
            }
            if (rlVar.isLaidOut()) {
                slVar.e();
                return true;
            }
            slVar.r = true;
            return true;
        }
        if (i != 1) {
            return false;
        }
        sl slVar2 = (sl) message.obj;
        int i3 = message.arg1;
        rl rlVar2 = slVar2.i;
        AccessibilityManager accessibilityManager = slVar2.t;
        if ((accessibilityManager != null && ((enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1)) == null || !enabledAccessibilityServiceList.isEmpty())) || rlVar2.getVisibility() != 0) {
            slVar2.c();
            return true;
        }
        int i4 = 2;
        if (rlVar2.getAnimationMode() == 1) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            valueAnimatorOfFloat.setInterpolator(slVar2.d);
            valueAnimatorOfFloat.addUpdateListener(new ll(slVar2, i2));
            valueAnimatorOfFloat.setDuration(slVar2.b);
            valueAnimatorOfFloat.addListener(new kl(slVar2, i3, i2));
            valueAnimatorOfFloat.start();
            return true;
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        rl rlVar3 = slVar2.i;
        int height = rlVar3.getHeight();
        ViewGroup.LayoutParams layoutParams2 = rlVar3.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            height += ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
        }
        valueAnimator.setIntValues(0, height);
        valueAnimator.setInterpolator(slVar2.e);
        valueAnimator.setDuration(slVar2.c);
        valueAnimator.addListener(new kl(slVar2, i3, i4));
        valueAnimator.addUpdateListener(new ll(slVar2, 3));
        valueAnimator.start();
        return true;
    }
}
