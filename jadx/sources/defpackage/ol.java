package defpackage;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.R;
import com.google.android.material.bottomsheet.BottomSheetDragHandleView;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.NavigationMenuItemView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ol extends h2 {
    public final /* synthetic */ int d;
    public final /* synthetic */ Object e;

    public /* synthetic */ ol(int i, Object obj) {
        this.d = i;
        this.e = obj;
    }

    @Override // defpackage.h2
    public void c(View view, AccessibilityEvent accessibilityEvent) {
        switch (this.d) {
            case 3:
                super.c(view, accessibilityEvent);
                accessibilityEvent.setChecked(((CheckableImageButton) this.e).A);
                break;
            default:
                super.c(view, accessibilityEvent);
                break;
        }
    }

    @Override // defpackage.h2
    public final void d(View view, p2 p2Var) {
        int i = this.d;
        View.AccessibilityDelegate accessibilityDelegate = this.a;
        Object obj = this.e;
        switch (i) {
            case 0:
                AccessibilityNodeInfo accessibilityNodeInfo = p2Var.a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                p2Var.a(1048576);
                accessibilityNodeInfo.setDismissable(true);
                break;
            case 1:
                AccessibilityNodeInfo accessibilityNodeInfo2 = p2Var.a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo2);
                if (!((po) obj).B0) {
                    accessibilityNodeInfo2.setDismissable(false);
                } else {
                    p2Var.a(1048576);
                    accessibilityNodeInfo2.setDismissable(true);
                }
                break;
            case 2:
                AccessibilityNodeInfo accessibilityNodeInfo3 = p2Var.a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo3);
                BottomSheetDragHandleView bottomSheetDragHandleView = (BottomSheetDragHandleView) obj;
                int i2 = BottomSheetDragHandleView.H0;
                if (bottomSheetDragHandleView.y0 != null) {
                    CharSequence contentDescription = bottomSheetDragHandleView.getContentDescription();
                    int i3 = bottomSheetDragHandleView.y0.f1;
                    String string = i3 != 3 ? i3 != 4 ? i3 != 6 ? null : bottomSheetDragHandleView.getResources().getString(R.string.bottomsheet_state_half_expanded) : bottomSheetDragHandleView.getResources().getString(R.string.bottomsheet_state_collapsed) : bottomSheetDragHandleView.getResources().getString(R.string.bottomsheet_state_expanded);
                    if (!TextUtils.isEmpty(string)) {
                        if (!TextUtils.isEmpty(contentDescription)) {
                            string = string + ". " + ((Object) contentDescription);
                        }
                        accessibilityNodeInfo3.setContentDescription(string);
                    }
                }
                break;
            case 3:
                AccessibilityNodeInfo accessibilityNodeInfo4 = p2Var.a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo4);
                CheckableImageButton checkableImageButton = (CheckableImageButton) obj;
                accessibilityNodeInfo4.setCheckable(checkableImageButton.y0);
                accessibilityNodeInfo4.setChecked(checkableImageButton.A);
                break;
            case 4:
                AccessibilityNodeInfo accessibilityNodeInfo5 = p2Var.a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo5);
                NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) obj;
                accessibilityNodeInfo5.setCheckable(navigationMenuItemView.R0);
                accessibilityNodeInfo5.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", navigationMenuItemView.getResources().getString(R.string.item_view_role_description));
                break;
            default:
                s33 s33Var = (s33) obj;
                s33Var.g.d(view, p2Var);
                RecyclerView recyclerView = s33Var.f;
                recyclerView.getClass();
                rg3 rg3VarO = RecyclerView.O(view);
                int iB = rg3VarO != null ? rg3VarO.b() : -1;
                rf3 adapter = recyclerView.getAdapter();
                if (adapter instanceof m33) {
                    ((m33) adapter).s(iB);
                    break;
                }
                break;
        }
    }

    @Override // defpackage.h2
    public void e(View view, AccessibilityEvent accessibilityEvent) {
        switch (this.d) {
            case 2:
                super.e(view, accessibilityEvent);
                if (accessibilityEvent.getEventType() == 1) {
                    BottomSheetDragHandleView bottomSheetDragHandleView = (BottomSheetDragHandleView) this.e;
                    int i = BottomSheetDragHandleView.H0;
                    bottomSheetDragHandleView.c();
                }
                break;
            default:
                super.e(view, accessibilityEvent);
                break;
        }
    }

    @Override // defpackage.h2
    public boolean g(View view, int i, Bundle bundle) {
        int i2 = this.d;
        Object obj = this.e;
        switch (i2) {
            case 0:
                if (i != 1048576) {
                    return super.g(view, i, bundle);
                }
                ((oy3) ((sl) obj)).a(3);
                return true;
            case 1:
                if (i == 1048576) {
                    po poVar = (po) obj;
                    if (poVar.B0) {
                        poVar.cancel();
                        return true;
                    }
                }
                return super.g(view, i, bundle);
            case 5:
                return ((s33) obj).g.g(view, i, bundle);
            default:
                return super.g(view, i, bundle);
        }
    }
}
