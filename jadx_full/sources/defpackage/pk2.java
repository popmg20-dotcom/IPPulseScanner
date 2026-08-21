package defpackage;

import android.R;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pk2 extends rg3 {
    public static final /* synthetic */ int x = 0;
    public final View u;
    public final TextView v;
    public l5 w;

    public pk2(View view) {
        super(view);
        this.u = view;
        View viewFindViewById = view.findViewById(R.id.title);
        viewFindViewById.getClass();
        TextView textView = (TextView) viewFindViewById;
        this.v = textView;
        textView.setEnabled(false);
        textView.setGravity(8388627);
    }
}
