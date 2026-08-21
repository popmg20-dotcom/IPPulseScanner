package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.ListMenuItemView;
import com.getsurfboard.R;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tk2 extends rg3 {
    public static final /* synthetic */ int A = 0;
    public final ListMenuItemView u;
    public final ViewGroup v;
    public final View w;
    public final z82 x;
    public final ImageView y;
    public m5 z;

    public tk2(ListMenuItemView listMenuItemView) {
        super(listMenuItemView);
        this.u = listMenuItemView;
        View viewFindViewById = listMenuItemView.findViewById(R.id.title);
        viewFindViewById.getClass();
        ViewParent parent = ((TextView) viewFindViewById).getParent();
        parent.getClass();
        this.v = (ViewGroup) parent;
        View viewFindViewById2 = listMenuItemView.findViewById(R.id.content);
        viewFindViewById2.getClass();
        this.w = viewFindViewById2;
        this.x = ek0.v(new v10(3, this));
        View viewFindViewById3 = listMenuItemView.findViewById(R.id.submenuarrow);
        viewFindViewById3.getClass();
        this.y = (ImageView) viewFindViewById3;
        View viewFindViewById4 = listMenuItemView.findViewById(R.id.group_divider);
        viewFindViewById4.getClass();
        je.h0(viewFindViewById4, 0, 12);
    }

    public final int s(int i) {
        Context context = this.u.getContext();
        context.getClass();
        return ek0.e(context, i);
    }
}
