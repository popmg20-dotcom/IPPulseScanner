package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m33 extends rf3 {
    public final PreferenceGroup d;
    public ArrayList e;
    public ArrayList f;
    public final ArrayList g;
    public final f33 i = new f33(20, this);
    public final Handler h = new Handler(Looper.getMainLooper());

    public m33(PreferenceScreen preferenceScreen) {
        this.d = preferenceScreen;
        preferenceScreen.X0 = this;
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
        o(preferenceScreen.k1);
        v();
    }

    @Override // defpackage.rf3
    public final int b() {
        return this.f.size();
    }

    @Override // defpackage.rf3
    public final long c(int i) {
        if (this.b) {
            return s(i).e();
        }
        return -1L;
    }

    @Override // defpackage.rf3
    public final int d(int i) {
        l33 l33Var = new l33(s(i));
        ArrayList arrayList = this.g;
        int iIndexOf = arrayList.indexOf(l33Var);
        if (iIndexOf != -1) {
            return iIndexOf;
        }
        int size = arrayList.size();
        arrayList.add(l33Var);
        return size;
    }

    @Override // defpackage.rf3
    public final void g(rg3 rg3Var, int i) {
        t33 t33Var = (t33) rg3Var;
        Preference preferenceS = s(i);
        ColorStateList colorStateList = t33Var.v;
        View view = t33Var.a;
        Drawable background = view.getBackground();
        Drawable drawable = t33Var.u;
        if (background != drawable) {
            WeakHashMap weakHashMap = wp4.a;
            view.setBackground(drawable);
        }
        TextView textView = (TextView) t33Var.s(R.id.title);
        if (textView != null && colorStateList != null && !textView.getTextColors().equals(colorStateList)) {
            textView.setTextColor(colorStateList);
        }
        preferenceS.m(t33Var);
    }

    @Override // defpackage.rf3
    public final rg3 i(ViewGroup viewGroup, int i) {
        l33 l33Var = (l33) this.g.get(i);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(viewGroup.getContext());
        TypedArray typedArrayObtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes((AttributeSet) null, ad3.a);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        if (drawable == null) {
            drawable = vo.r(viewGroup.getContext(), R.drawable.list_selector_background);
        }
        typedArrayObtainStyledAttributes.recycle();
        View viewInflate = layoutInflaterFrom.inflate(l33Var.a, viewGroup, false);
        if (viewInflate.getBackground() == null) {
            WeakHashMap weakHashMap = wp4.a;
            viewInflate.setBackground(drawable);
        }
        ViewGroup viewGroup2 = (ViewGroup) viewInflate.findViewById(R.id.widget_frame);
        if (viewGroup2 != null) {
            int i2 = l33Var.b;
            if (i2 != 0) {
                layoutInflaterFrom.inflate(i2, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return new t33(viewInflate);
    }

    public final ArrayList q(PreferenceGroup preferenceGroup) {
        ArrayList arrayList = new ArrayList();
        ArrayList<Preference> arrayList2 = new ArrayList();
        int size = preferenceGroup.f1.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            CharSequence string = null;
            if (i >= size) {
                int i3 = preferenceGroup.j1;
                if (i3 != Integer.MAX_VALUE && i2 > i3) {
                    Context context = preferenceGroup.b;
                    long j = preferenceGroup.z;
                    h81 h81Var = new h81(context, null);
                    h81Var.V0 = com.getsurfboard.R.layout.expand_button;
                    Context context2 = h81Var.b;
                    Drawable drawableR = vo.r(context2, com.getsurfboard.R.drawable.ic_arrow_down_24dp);
                    if (h81Var.B0 != drawableR) {
                        h81Var.B0 = drawableR;
                        h81Var.A0 = 0;
                        h81Var.i();
                    }
                    h81Var.A0 = com.getsurfboard.R.drawable.ic_arrow_down_24dp;
                    String string2 = context2.getString(com.getsurfboard.R.string.expand_button_title);
                    if (!TextUtils.equals(string2, h81Var.y0)) {
                        h81Var.y0 = string2;
                        h81Var.i();
                    }
                    if (999 != h81Var.Z) {
                        h81Var.Z = 999;
                        m33 m33Var = h81Var.X0;
                        if (m33Var != null) {
                            Handler handler = m33Var.h;
                            f33 f33Var = m33Var.i;
                            handler.removeCallbacks(f33Var);
                            handler.post(f33Var);
                        }
                    }
                    ArrayList arrayList3 = new ArrayList();
                    for (Preference preference : arrayList2) {
                        CharSequence charSequence = preference.y0;
                        boolean z = preference instanceof PreferenceGroup;
                        if (z && !TextUtils.isEmpty(charSequence)) {
                            arrayList3.add((PreferenceGroup) preference);
                        }
                        if (arrayList3.contains(preference.Z0)) {
                            if (z) {
                                arrayList3.add((PreferenceGroup) preference);
                            }
                        } else if (!TextUtils.isEmpty(charSequence)) {
                            string = string == null ? charSequence : context2.getString(com.getsurfboard.R.string.summary_collapsed_preference_list, string, charSequence);
                        }
                    }
                    h81Var.w(string);
                    h81Var.e1 = j + 1000000;
                    h81Var.Y = new v62(14, this, preferenceGroup);
                    arrayList.add(h81Var);
                }
                return arrayList;
            }
            Preference preferenceB = preferenceGroup.B(i);
            if (preferenceB.N0) {
                int i4 = preferenceGroup.j1;
                if (i4 == Integer.MAX_VALUE || i2 < i4) {
                    arrayList.add(preferenceB);
                } else {
                    arrayList2.add(preferenceB);
                }
                if (preferenceB instanceof PreferenceGroup) {
                    PreferenceGroup preferenceGroup2 = (PreferenceGroup) preferenceB;
                    if (preferenceGroup2 instanceof PreferenceScreen) {
                        continue;
                    } else {
                        if (preferenceGroup.j1 != Integer.MAX_VALUE && preferenceGroup2.j1 != Integer.MAX_VALUE) {
                            xe.q("Nesting an expandable group inside of another expandable group is not supported!");
                            return null;
                        }
                        for (Preference preference2 : q(preferenceGroup2)) {
                            int i5 = preferenceGroup.j1;
                            if (i5 == Integer.MAX_VALUE || i2 < i5) {
                                arrayList.add(preference2);
                            } else {
                                arrayList2.add(preference2);
                            }
                            i2++;
                        }
                    }
                } else {
                    i2++;
                }
            }
            i++;
        }
    }

    public final void r(ArrayList arrayList, PreferenceGroup preferenceGroup) {
        synchronized (preferenceGroup) {
            Collections.sort(preferenceGroup.f1);
        }
        int size = preferenceGroup.f1.size();
        for (int i = 0; i < size; i++) {
            Preference preferenceB = preferenceGroup.B(i);
            arrayList.add(preferenceB);
            l33 l33Var = new l33(preferenceB);
            if (!this.g.contains(l33Var)) {
                this.g.add(l33Var);
            }
            if (preferenceB instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) preferenceB;
                if (!(preferenceGroup2 instanceof PreferenceScreen)) {
                    r(arrayList, preferenceGroup2);
                }
            }
            preferenceB.X0 = this;
        }
    }

    public final Preference s(int i) {
        if (i < 0 || i >= this.f.size()) {
            return null;
        }
        return (Preference) this.f.get(i);
    }

    public final int t(Preference preference) {
        int size = this.f.size();
        for (int i = 0; i < size; i++) {
            Preference preference2 = (Preference) this.f.get(i);
            if (preference2 != null && preference2.equals(preference)) {
                return i;
            }
        }
        return -1;
    }

    public final int u(String str) {
        int size = this.f.size();
        for (int i = 0; i < size; i++) {
            if (TextUtils.equals(str, ((Preference) this.f.get(i)).C0)) {
                return i;
            }
        }
        return -1;
    }

    public final void v() {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((Preference) it.next()).X0 = null;
        }
        ArrayList arrayList = new ArrayList(this.e.size());
        this.e = arrayList;
        PreferenceGroup preferenceGroup = this.d;
        r(arrayList, preferenceGroup);
        this.f = q(preferenceGroup);
        this.a.b();
        Iterator it2 = this.e.iterator();
        while (it2.hasNext()) {
            ((Preference) it2.next()).getClass();
        }
    }
}
