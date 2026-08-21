package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.getsurfboard.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class oe2 extends rb2 {
    public static final SimpleDateFormat i = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.getDefault());
    public static final d63 j = new d63(5);
    public final ArrayList e;
    public final Object f;
    public String g;
    public String h;

    public oe2() {
        super(j);
        this.e = new ArrayList();
        this.f = new Object();
    }

    @Override // defpackage.rf3
    public final void g(rg3 rg3Var, int i2) {
        Object objQ = q(i2);
        objQ.getClass();
        ge2 ge2Var = (ge2) objQ;
        v92 v92Var = ((ne2) rg3Var).u;
        ((TextView) v92Var.X).setText(String.format(Locale.getDefault(), "%s %d-%d", Arrays.copyOf(new Object[]{i.format(ge2Var.a), Integer.valueOf(ge2Var.b), Integer.valueOf(ge2Var.c)}, 3)));
        ((TextView) v92Var.f).setText(ge2Var.f);
        TextView textView = (TextView) v92Var.z;
        String str = ge2Var.d;
        textView.setText(str);
        textView.setBackgroundResource(((Integer) ge2.j.get(str)).intValue());
        ((TextView) v92Var.A).setText(ge2Var.e);
    }

    @Override // defpackage.rf3
    public final rg3 i(ViewGroup viewGroup, int i2) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.logcat_viewer_item_logcat, viewGroup, false);
        int i3 = R.id.content;
        TextView textView = (TextView) vf2.l(viewInflate, R.id.content);
        if (textView != null) {
            i3 = R.id.level;
            TextView textView2 = (TextView) vf2.l(viewInflate, R.id.level);
            if (textView2 != null) {
                i3 = R.id.tag;
                TextView textView3 = (TextView) vf2.l(viewInflate, R.id.tag);
                if (textView3 != null) {
                    i3 = R.id.time;
                    TextView textView4 = (TextView) vf2.l(viewInflate, R.id.time);
                    if (textView4 != null) {
                        return new ne2(new v92((LinearLayout) viewInflate, textView, textView2, textView3, textView4));
                    }
                }
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i3)));
        return null;
    }

    public final void t(ArrayList arrayList) {
        List listU;
        if (arrayList.isEmpty()) {
            return;
        }
        synchronized (this.f) {
            this.e.addAll(arrayList);
            listU = u();
        }
        r(listU);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List u() {
        /*
            r9 = this;
            java.lang.String r0 = r9.g
            java.util.ArrayList r1 = r9.e
            if (r0 != 0) goto Lb
            java.lang.String r0 = r9.h
            if (r0 != 0) goto Lb
            goto L6e
        Lb:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r1 = r1.iterator()
        L14:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L6d
            java.lang.Object r2 = r1.next()
            r3 = r2
            ge2 r3 = (defpackage.ge2) r3
            java.lang.String r4 = r9.g
            r5 = 1
            if (r4 == 0) goto L35
            fe2 r6 = defpackage.ge2.k
            java.lang.String r7 = r3.d
            int r7 = r6.indexOf(r7)
            int r4 = r6.indexOf(r4)
            if (r7 >= r4) goto L35
            goto L67
        L35:
            java.lang.String r4 = r9.h
            r6 = 0
            if (r4 == 0) goto L66
            java.lang.String r7 = r3.e
            java.lang.String r3 = r3.f
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r7)
            java.lang.String r7 = " "
            r8.append(r7)
            r8.append(r3)
            java.lang.String r3 = r8.toString()
            java.util.Locale r7 = java.util.Locale.getDefault()
            r7.getClass()
            java.lang.String r3 = r3.toLowerCase(r7)
            r3.getClass()
            boolean r3 = defpackage.p44.o0(r3, r4, r6)
            r5 = r5 ^ r3
            goto L67
        L66:
            r5 = r6
        L67:
            if (r5 != 0) goto L14
            r0.add(r2)
            goto L14
        L6d:
            r1 = r0
        L6e:
            java.util.List r9 = defpackage.d70.s0(r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.oe2.u():java.util.List");
    }
}
