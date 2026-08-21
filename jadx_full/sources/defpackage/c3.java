package defpackage;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Message;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.Preference;
import com.google.android.material.internal.NavigationMenuItemView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c3 implements View.OnClickListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;

    public /* synthetic */ c3(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Message message;
        Message message2;
        Message message3;
        int i = this.b;
        Message messageObtain = null;
        messageObtain = null;
        boolean z = true;
        Object obj = this.f;
        switch (i) {
            case 0:
                ((u3) obj).a();
                break;
            case 1:
                s6 s6Var = (s6) obj;
                if (view == s6Var.j && (message3 = s6Var.l) != null) {
                    messageObtain = Message.obtain(message3);
                } else if (view == s6Var.m && (message2 = s6Var.o) != null) {
                    messageObtain = Message.obtain(message2);
                } else if (view == s6Var.p && (message = s6Var.r) != null) {
                    messageObtain = Message.obtain(message);
                }
                if (messageObtain != null) {
                    messageObtain.sendToTarget();
                }
                s6Var.H.obtainMessage(1, s6Var.b).sendToTarget();
                break;
            case 2:
                po poVar = (po) obj;
                if (poVar.B0 && poVar.isShowing()) {
                    if (!poVar.D0) {
                        TypedArray typedArrayObtainStyledAttributes = poVar.getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
                        poVar.C0 = typedArrayObtainStyledAttributes.getBoolean(0, true);
                        typedArrayObtainStyledAttributes.recycle();
                        poVar.D0 = true;
                    }
                    if (poVar.C0) {
                        poVar.cancel();
                    }
                    break;
                }
                break;
            case 3:
                vs4 vs4Var = (vs4) ws4.c.d();
                if (vs4Var != null && vs4Var.b) {
                    ma1 ma1Var = (ma1) obj;
                    ma1Var.X = true;
                    Context contextRequireContext = ma1Var.requireContext();
                    contextRequireContext.getClass();
                    zw1.d(contextRequireContext);
                    break;
                }
                break;
            case 4:
                sk2 itemData = ((ip2) view).getItemData();
                mp2 mp2Var = (mp2) obj;
                boolean zS = mp2Var.g1.a.s(itemData, mp2Var.f1, 0);
                if (itemData != null && itemData.isCheckable()) {
                    if (!zS || itemData.isChecked()) {
                        mp2Var.setCheckedItem(itemData);
                    }
                    break;
                }
                break;
            case 5:
                NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) view;
                mq2 mq2Var = (mq2) obj;
                eq2 eq2Var = mq2Var.X;
                if (eq2Var != null) {
                    eq2Var.f = true;
                }
                sk2 itemData2 = navigationMenuItemView.getItemData();
                boolean zS2 = mq2Var.z.s(itemData2, mq2Var, 0);
                if (itemData2 != null && itemData2.isCheckable() && zS2) {
                    mq2Var.X.r(itemData2);
                } else {
                    z = false;
                }
                eq2 eq2Var2 = mq2Var.X;
                if (eq2Var2 != null) {
                    eq2Var2.f = false;
                }
                if (z) {
                    mq2Var.c(false);
                }
                break;
            case 6:
                ((Preference) obj).t(view);
                break;
            default:
                ff4 ff4Var = ((Toolbar) obj).g1;
                sk2 sk2Var = ff4Var != null ? ff4Var.f : null;
                if (sk2Var != null) {
                    sk2Var.collapseActionView();
                }
                break;
        }
    }
}
