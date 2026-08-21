package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.google.android.material.card.MaterialCardView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pa3 extends rb2 {
    public final t53 e;
    public final na3 f;
    public String g;
    public Map h;
    public final cd i;
    public mb3 j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pa3(t53 t53Var, na3 na3Var, String str, Map map, cd cdVar) {
        super(qa3.b);
        na3Var.getClass();
        map.getClass();
        this.e = t53Var;
        this.f = na3Var;
        this.g = str;
        this.h = map;
        this.i = cdVar;
        this.j = t23.n();
        r(u());
    }

    @Override // defpackage.rf3
    public final void g(rg3 rg3Var, int i) {
        String strQ;
        fb3 fb3Var = (fb3) rg3Var;
        cm2 cm2Var = fb3Var.u;
        FrameLayout frameLayout = (FrameLayout) cm2Var.f;
        MaterialCardView materialCardView = (MaterialCardView) cm2Var.z;
        TextView textView = (TextView) cm2Var.A;
        Context context = frameLayout.getContext();
        f82 f82Var = (f82) q(i);
        ((AppCompatTextView) cm2Var.X).setText(p44.H0(p44.H0(f82Var.z, "\""), "'"));
        TextView textView2 = (TextView) cm2Var.Y;
        String str = f82Var.z;
        t53 t53Var = this.e;
        t53Var.getClass();
        str.getClass();
        LinkedHashMap linkedHashMap = t53Var.H0;
        na3 na3Var = (na3) linkedHashMap.get(str);
        if (na3Var == null && (na3Var = (na3) linkedHashMap.get(p44.H0(str, "\""))) == null) {
            na3Var = (na3) linkedHashMap.get(p44.H0(str, "'"));
        }
        int i2 = 1;
        if (na3Var instanceof ka3) {
            strQ = ContextUtilsKt.k(R.string.proxy_type_select);
        } else if (na3Var instanceof ma3) {
            strQ = ContextUtilsKt.k(R.string.proxy_type_url_test);
        } else if (na3Var instanceof ia3) {
            strQ = ContextUtilsKt.k(R.string.proxy_type_fallback_test);
        } else if (na3Var instanceof ja3) {
            strQ = ContextUtilsKt.k(R.string.proxy_type_load_balance);
        } else if (na3Var instanceof la3) {
            strQ = ContextUtilsKt.k(R.string.proxy_type_subnet);
        } else {
            ea3 ea3VarU = t53Var.u(str);
            if (ea3VarU == null && (ea3VarU = t53Var.u(p44.H0(str, "\""))) == null) {
                ea3VarU = t53Var.u(p44.H0(str, "'"));
            }
            strQ = ek0.q(ea3VarU, true);
        }
        textView2.setText(strQ);
        ((TextView) cm2Var.Z).setVisibility(ek0.u(t53Var, str, this.h) ? 0 : 8);
        materialCardView.setOnCheckedChangeListener(new o73(i2, fb3Var));
        materialCardView.setOnLongClickListener(new dk(i2, this, f82Var));
        na3 na3Var2 = this.f;
        if (!(na3Var2 instanceof ja3)) {
            materialCardView.setChecked(str.equals(this.g));
        }
        pn0 pn0Var = (pn0) b04.a.get(f82Var);
        if (pn0Var == null) {
            textView.setText(R.string.empty);
        } else if (pn0Var instanceof ln0) {
            if (na3Var2 instanceof ia3) {
                textView.setText(R.string.empty);
            } else {
                textView.setText(ContextUtilsKt.k(R.string.delay_failed));
                textView.setTextColor(context.getColor(R.color.delay_failed));
            }
        } else if (pn0Var instanceof mn0) {
            textView.setText(ContextUtilsKt.k(R.string.delay_testing));
            textView.setTextColor(context.getColor(R.color.delay_testing));
        } else {
            if (!(pn0Var instanceof nn0)) {
                g.d();
                return;
            }
            long j = ((nn0) pn0Var).a;
            textView.setText(ContextUtilsKt.l(R.string.delay_template, Long.valueOf(j)));
            if (j < 300) {
                textView.setTextColor(context.getColor(R.color.delay_low));
            } else {
                textView.setTextColor(context.getColor(R.color.delay_high));
            }
        }
        if (na3Var2 instanceof ka3) {
            materialCardView.setOnClickListener(new d81(4, this, f82Var, fb3Var));
        } else {
            materialCardView.setOnClickListener(new w3(7));
        }
    }

    @Override // defpackage.rf3
    public final void h(rg3 rg3Var, int i, List list) {
        fb3 fb3Var = (fb3) rg3Var;
        cm2 cm2Var = fb3Var.u;
        list.getClass();
        if (list.isEmpty()) {
            g(fb3Var, i);
            return;
        }
        for (Object obj : list) {
            if (obj instanceof Boolean) {
                ((MaterialCardView) cm2Var.z).setChecked(((Boolean) obj).booleanValue());
            } else if (n12.c(obj, "payload_udp")) {
                ((TextView) cm2Var.Z).setVisibility(ek0.u(this.e, ((f82) q(i)).z, this.h) ? 0 : 8);
            } else {
                g(fb3Var, i);
            }
        }
    }

    @Override // defpackage.rf3
    public final rg3 i(ViewGroup viewGroup, int i) {
        View viewInflate = ContextUtilsKt.f(viewGroup).inflate(R.layout.item_proxy, (ViewGroup) null, false);
        int i2 = R.id.card;
        MaterialCardView materialCardView = (MaterialCardView) vf2.l(viewInflate, R.id.card);
        if (materialCardView != null) {
            i2 = R.id.delay;
            TextView textView = (TextView) vf2.l(viewInflate, R.id.delay);
            if (textView != null) {
                i2 = R.id.title;
                AppCompatTextView appCompatTextView = (AppCompatTextView) vf2.l(viewInflate, R.id.title);
                if (appCompatTextView != null) {
                    i2 = R.id.type;
                    TextView textView2 = (TextView) vf2.l(viewInflate, R.id.type);
                    if (textView2 != null) {
                        i2 = R.id.udp_tag;
                        TextView textView3 = (TextView) vf2.l(viewInflate, R.id.udp_tag);
                        if (textView3 != null) {
                            return new fb3(new cm2((FrameLayout) viewInflate, materialCardView, textView, appCompatTextView, textView2, textView3, 8));
                        }
                    }
                }
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
        return null;
    }

    @Override // defpackage.rb2
    public final void r(List list) {
        t((ArrayList) list);
        super.r(list);
    }

    @Override // defpackage.rb2
    public final void s(List list, Runnable runnable) {
        t((ArrayList) list);
        super.s(list, runnable);
    }

    public final void t(ArrayList arrayList) {
        HashMap map = new HashMap(b04.a);
        int iOrdinal = this.j.ordinal();
        if (iOrdinal == 0) {
            arrayList.clear();
            arrayList.addAll(u());
            return;
        }
        if (iOrdinal == 1) {
            if (arrayList.size() > 1) {
                h70.T(arrayList, new oa3(0, map));
            }
        } else if (iOrdinal != 2) {
            g.d();
        } else if (arrayList.size() > 1) {
            h70.T(arrayList, new e1(18));
        }
    }

    public final ArrayList u() {
        na3 na3Var = this.f;
        LinkedHashSet linkedHashSetW = na3Var.w();
        linkedHashSetW.getClass();
        List listY0 = d70.y0(d70.B0(linkedHashSetW));
        ArrayList arrayList = new ArrayList(f70.Q(10, listY0));
        Iterator it = listY0.iterator();
        while (it.hasNext()) {
            arrayList.add(new f82(this.e.b, na3Var.getName(), (String) it.next()));
        }
        return new ArrayList(arrayList);
    }
}
