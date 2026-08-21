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
    */
    public final List u() {
        String str = this.g;
        ArrayList arrayList = this.e;
        if (str != null || this.h != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                ge2 ge2Var = (ge2) obj;
                String str2 = this.g;
                boolean zO0 = true;
                if (str2 != null) {
                    fe2 fe2Var = ge2.k;
                    if (fe2Var.indexOf(ge2Var.d) >= fe2Var.indexOf(str2)) {
                        String str3 = this.h;
                        if (str3 != null) {
                            String str4 = ge2Var.e + " " + ge2Var.f;
                            Locale locale = Locale.getDefault();
                            locale.getClass();
                            String lowerCase = str4.toLowerCase(locale);
                            lowerCase.getClass();
                            zO0 = true ^ p44.o0(lowerCase, str3, false);
                        } else {
                            zO0 = false;
                        }
                    }
                }
                if (!zO0) {
                    arrayList2.add(obj);
                }
            }
            arrayList = arrayList2;
        }
        return d70.s0(arrayList);
    }
}
