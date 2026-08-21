package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class dl2 extends jy0 {
    public final int G0;
    public final int H0;
    public rk2 I0;
    public sk2 J0;

    public dl2(Context context, boolean z) {
        super(context, z);
        if (1 == context.getResources().getConfiguration().getLayoutDirection()) {
            this.G0 = 21;
            this.H0 = 22;
        } else {
            this.G0 = 22;
            this.H0 = 21;
        }
    }

    @Override // defpackage.jy0, android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        kk2 kk2Var;
        int headersCount;
        int iPointToPosition;
        int i;
        if (this.I0 != null) {
            ListAdapter adapter = getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                headersCount = headerViewListAdapter.getHeadersCount();
                kk2Var = (kk2) headerViewListAdapter.getWrappedAdapter();
            } else {
                kk2Var = (kk2) adapter;
                headersCount = 0;
            }
            sk2 sk2VarB = (motionEvent.getAction() == 10 || (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i = iPointToPosition - headersCount) < 0 || i >= kk2Var.getCount()) ? null : kk2Var.getItem(i);
            sk2 sk2Var = this.J0;
            if (sk2Var != sk2VarB) {
                nk2 nk2Var = kk2Var.b;
                if (sk2Var != null) {
                    this.I0.d(nk2Var, sk2Var);
                }
                this.J0 = sk2VarB;
                if (sk2VarB != null) {
                    this.I0.G(nk2Var, sk2VarB);
                }
            }
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
        if (listMenuItemView != null && i == this.G0) {
            if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
            }
            return true;
        }
        if (listMenuItemView == null || i != this.H0) {
            return super.onKeyDown(i, keyEvent);
        }
        setSelection(-1);
        ListAdapter adapter = getAdapter();
        (adapter instanceof HeaderViewListAdapter ? (kk2) ((HeaderViewListAdapter) adapter).getWrappedAdapter() : (kk2) adapter).b.c(false);
        return true;
    }

    public void setHoverListener(rk2 rk2Var) {
        this.I0 = rk2Var;
    }

    @Override // defpackage.jy0, android.widget.AbsListView
    public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
        super.setSelector(drawable);
    }
}
