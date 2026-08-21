package androidx.preference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.getsurfboard.R;
import defpackage.ad3;
import defpackage.c3;
import defpackage.f33;
import defpackage.fw;
import defpackage.j33;
import defpackage.l72;
import defpackage.m33;
import defpackage.r33;
import defpackage.t33;
import defpackage.v23;
import defpackage.vo;
import defpackage.w23;
import defpackage.wp4;
import defpackage.x23;
import defpackage.xe;
import defpackage.y23;
import io.netty.channel.internal.ChannelUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class Preference implements Comparable<Preference> {
    public boolean A;
    public int A0;
    public Drawable B0;
    public final String C0;
    public Intent D0;
    public final String E0;
    public Bundle F0;
    public final boolean G0;
    public final boolean H0;
    public final boolean I0;
    public final String J0;
    public final Object K0;
    public boolean L0;
    public boolean M0;
    public boolean N0;
    public final boolean O0;
    public final boolean P0;
    public final boolean Q0;
    public final boolean R0;
    public final boolean S0;
    public final boolean T0;
    public final boolean U0;
    public int V0;
    public final int W0;
    public v23 X;
    public m33 X0;
    public w23 Y;
    public ArrayList Y0;
    public int Z;
    public PreferenceGroup Z0;
    public boolean a1;
    public final Context b;
    public x23 b1;
    public y23 c1;
    public final c3 d1;
    public r33 f;
    public CharSequence y0;
    public long z;
    public CharSequence z0;

    public Preference(Context context, AttributeSet attributeSet, int i) {
        this.Z = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
        this.G0 = true;
        this.H0 = true;
        this.I0 = true;
        this.L0 = true;
        this.M0 = true;
        this.N0 = true;
        this.O0 = true;
        this.P0 = true;
        this.R0 = true;
        this.U0 = true;
        this.V0 = R.layout.preference;
        this.d1 = new c3(6, this);
        this.b = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ad3.g, i, 0);
        this.A0 = typedArrayObtainStyledAttributes.getResourceId(23, typedArrayObtainStyledAttributes.getResourceId(0, 0));
        String string = typedArrayObtainStyledAttributes.getString(26);
        this.C0 = string == null ? typedArrayObtainStyledAttributes.getString(6) : string;
        CharSequence text = typedArrayObtainStyledAttributes.getText(34);
        this.y0 = text == null ? typedArrayObtainStyledAttributes.getText(4) : text;
        CharSequence text2 = typedArrayObtainStyledAttributes.getText(33);
        this.z0 = text2 == null ? typedArrayObtainStyledAttributes.getText(7) : text2;
        this.Z = typedArrayObtainStyledAttributes.getInt(28, typedArrayObtainStyledAttributes.getInt(8, ChannelUtils.WRITE_STATUS_SNDBUF_FULL));
        String string2 = typedArrayObtainStyledAttributes.getString(22);
        this.E0 = string2 == null ? typedArrayObtainStyledAttributes.getString(13) : string2;
        this.V0 = typedArrayObtainStyledAttributes.getResourceId(27, typedArrayObtainStyledAttributes.getResourceId(3, R.layout.preference));
        this.W0 = typedArrayObtainStyledAttributes.getResourceId(35, typedArrayObtainStyledAttributes.getResourceId(9, 0));
        this.G0 = typedArrayObtainStyledAttributes.getBoolean(21, typedArrayObtainStyledAttributes.getBoolean(2, true));
        boolean z = typedArrayObtainStyledAttributes.getBoolean(30, typedArrayObtainStyledAttributes.getBoolean(5, true));
        this.H0 = z;
        this.I0 = typedArrayObtainStyledAttributes.getBoolean(29, typedArrayObtainStyledAttributes.getBoolean(1, true));
        String string3 = typedArrayObtainStyledAttributes.getString(19);
        this.J0 = string3 == null ? typedArrayObtainStyledAttributes.getString(10) : string3;
        this.O0 = typedArrayObtainStyledAttributes.getBoolean(16, typedArrayObtainStyledAttributes.getBoolean(16, z));
        this.P0 = typedArrayObtainStyledAttributes.getBoolean(17, typedArrayObtainStyledAttributes.getBoolean(17, z));
        if (typedArrayObtainStyledAttributes.hasValue(18)) {
            this.K0 = p(typedArrayObtainStyledAttributes, 18);
        } else if (typedArrayObtainStyledAttributes.hasValue(11)) {
            this.K0 = p(typedArrayObtainStyledAttributes, 11);
        }
        this.U0 = typedArrayObtainStyledAttributes.getBoolean(31, typedArrayObtainStyledAttributes.getBoolean(12, true));
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(32);
        this.Q0 = zHasValue;
        if (zHasValue) {
            this.R0 = typedArrayObtainStyledAttributes.getBoolean(32, typedArrayObtainStyledAttributes.getBoolean(14, true));
        }
        this.S0 = typedArrayObtainStyledAttributes.getBoolean(24, typedArrayObtainStyledAttributes.getBoolean(15, false));
        this.N0 = typedArrayObtainStyledAttributes.getBoolean(25, typedArrayObtainStyledAttributes.getBoolean(25, true));
        this.T0 = typedArrayObtainStyledAttributes.getBoolean(20, typedArrayObtainStyledAttributes.getBoolean(20, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    public static void v(View view, boolean z) {
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                v(viewGroup.getChildAt(childCount), z);
            }
        }
    }

    public final boolean a(Serializable serializable) {
        v23 v23Var = this.X;
        return v23Var == null || v23Var.i(this, serializable);
    }

    public void b(Bundle bundle) {
        Parcelable parcelable;
        String str = this.C0;
        if (TextUtils.isEmpty(str) || (parcelable = bundle.getParcelable(str)) == null) {
            return;
        }
        this.a1 = false;
        q(parcelable);
        if (this.a1) {
            return;
        }
        xe.q("Derived class did not call super.onRestoreInstanceState()");
    }

    public void c(Bundle bundle) {
        String str = this.C0;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.a1 = false;
        Parcelable parcelableR = r();
        if (!this.a1) {
            xe.q("Derived class did not call super.onSaveInstanceState()");
        } else if (parcelableR != null) {
            bundle.putParcelable(str, parcelableR);
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Preference preference) {
        Preference preference2 = preference;
        int i = this.Z;
        int i2 = preference2.Z;
        if (i != i2) {
            return i - i2;
        }
        CharSequence charSequence = this.y0;
        CharSequence charSequence2 = preference2.y0;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference2.y0.toString());
    }

    public final Bundle d() {
        Bundle bundle = this.F0;
        if (bundle != null) {
            return bundle;
        }
        Bundle bundle2 = new Bundle();
        this.F0 = bundle2;
        return bundle2;
    }

    public long e() {
        return this.z;
    }

    public final String f(String str) {
        return !z() ? str : this.f.c().getString(this.C0, str);
    }

    public CharSequence g() {
        y23 y23Var = this.c1;
        return y23Var != null ? y23Var.e(this) : this.z0;
    }

    public boolean h() {
        return this.G0 && this.L0 && this.M0;
    }

    public void i() {
        int iIndexOf;
        m33 m33Var = this.X0;
        if (m33Var == null || (iIndexOf = m33Var.f.indexOf(this)) == -1) {
            return;
        }
        m33Var.a.d(iIndexOf, 1, this);
    }

    public void j(boolean z) {
        ArrayList arrayList = this.Y0;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Preference preference = (Preference) arrayList.get(i);
            if (preference.L0 == z) {
                preference.L0 = !z;
                preference.j(preference.y());
                preference.i();
            }
        }
    }

    public void k() {
        PreferenceScreen preferenceScreen;
        String str = this.J0;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        r33 r33Var = this.f;
        Preference preferenceA = null;
        if (r33Var != null && (preferenceScreen = r33Var.g) != null) {
            preferenceA = preferenceScreen.A(str);
        }
        if (preferenceA == null) {
            StringBuilder sbD = fw.D("Dependency \"", str, "\" not found for preference \"");
            sbD.append(this.C0);
            sbD.append("\" (title: \"");
            sbD.append((Object) this.y0);
            sbD.append("\"");
            throw new IllegalStateException(sbD.toString());
        }
        ArrayList arrayList = preferenceA.Y0;
        if (arrayList == null) {
            arrayList = new ArrayList();
            preferenceA.Y0 = arrayList;
        }
        arrayList.add(this);
        boolean zY = preferenceA.y();
        if (this.L0 == zY) {
            this.L0 = !zY;
            j(y());
            i();
        }
    }

    public final void l(r33 r33Var) {
        this.f = r33Var;
        if (!this.A) {
            this.z = r33Var.b();
        }
        if (z()) {
            r33 r33Var2 = this.f;
            if ((r33Var2 != null ? r33Var2.c() : null).contains(this.C0)) {
                s(null);
                return;
            }
        }
        Object obj = this.K0;
        if (obj != null) {
            s(obj);
        }
    }

    public void m(t33 t33Var) {
        Integer numValueOf;
        View view = t33Var.a;
        view.setOnClickListener(this.d1);
        view.setId(0);
        TextView textView = (TextView) t33Var.s(android.R.id.summary);
        if (textView != null) {
            CharSequence charSequenceG = g();
            if (TextUtils.isEmpty(charSequenceG)) {
                textView.setVisibility(8);
                numValueOf = null;
            } else {
                textView.setText(charSequenceG);
                textView.setVisibility(0);
                numValueOf = Integer.valueOf(textView.getCurrentTextColor());
            }
        } else {
            numValueOf = null;
        }
        TextView textView2 = (TextView) t33Var.s(android.R.id.title);
        boolean z = this.H0;
        if (textView2 != null) {
            CharSequence charSequence = this.y0;
            if (TextUtils.isEmpty(charSequence)) {
                textView2.setVisibility(8);
            } else {
                textView2.setText(charSequence);
                textView2.setVisibility(0);
                if (this.Q0) {
                    textView2.setSingleLine(this.R0);
                }
                if (!z && h() && numValueOf != null) {
                    textView2.setTextColor(numValueOf.intValue());
                }
            }
        }
        ImageView imageView = (ImageView) t33Var.s(android.R.id.icon);
        boolean z2 = this.S0;
        if (imageView != null) {
            int i = this.A0;
            if (i != 0 || this.B0 != null) {
                Drawable drawableR = this.B0;
                if (drawableR == null) {
                    drawableR = vo.r(this.b, i);
                    this.B0 = drawableR;
                }
                if (drawableR != null) {
                    imageView.setImageDrawable(drawableR);
                }
            }
            if (this.B0 != null) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(z2 ? 4 : 8);
            }
        }
        View viewS = t33Var.s(R.id.icon_frame);
        if (viewS == null) {
            viewS = t33Var.s(android.R.id.icon_frame);
        }
        if (viewS != null) {
            if (this.B0 != null) {
                viewS.setVisibility(0);
            } else {
                viewS.setVisibility(z2 ? 4 : 8);
            }
        }
        if (this.U0) {
            v(view, h());
        } else {
            v(view, true);
        }
        view.setFocusable(z);
        view.setClickable(z);
        t33Var.x = this.O0;
        t33Var.y = this.P0;
        boolean z3 = this.T0;
        if (z3 && this.b1 == null) {
            this.b1 = new x23(this);
        }
        view.setOnCreateContextMenuListener(z3 ? this.b1 : null);
        view.setLongClickable(z3);
        if (!z3 || z) {
            return;
        }
        WeakHashMap weakHashMap = wp4.a;
        view.setBackground(null);
    }

    public void o() {
        ArrayList arrayList;
        PreferenceScreen preferenceScreen;
        String str = this.J0;
        if (str != null) {
            r33 r33Var = this.f;
            Preference preferenceA = null;
            if (r33Var != null && (preferenceScreen = r33Var.g) != null) {
                preferenceA = preferenceScreen.A(str);
            }
            if (preferenceA == null || (arrayList = preferenceA.Y0) == null) {
                return;
            }
            arrayList.remove(this);
        }
    }

    public Object p(TypedArray typedArray, int i) {
        return null;
    }

    public void q(Parcelable parcelable) {
        this.a1 = true;
        if (parcelable == AbsSavedState.EMPTY_STATE || parcelable == null) {
            return;
        }
        xe.k("Wrong state class -- expecting Preference State");
    }

    public Parcelable r() {
        this.a1 = true;
        return AbsSavedState.EMPTY_STATE;
    }

    public void t(View view) {
        Intent intent;
        j33 j33Var;
        if (h() && this.H0) {
            n();
            w23 w23Var = this.Y;
            if (w23Var == null || !w23Var.k(this)) {
                r33 r33Var = this.f;
                if ((r33Var == null || (j33Var = r33Var.h) == null || !j33Var.onPreferenceTreeClick(this)) && (intent = this.D0) != null) {
                    this.b.startActivity(intent);
                }
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        CharSequence charSequence = this.y0;
        if (!TextUtils.isEmpty(charSequence)) {
            sb.append(charSequence);
            sb.append(' ');
        }
        CharSequence charSequenceG = g();
        if (!TextUtils.isEmpty(charSequenceG)) {
            sb.append(charSequenceG);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public final void u(String str) {
        if (z() && !TextUtils.equals(str, f(null))) {
            SharedPreferences.Editor editorA = this.f.a();
            editorA.putString(this.C0, str);
            if (this.f.e) {
                return;
            }
            editorA.apply();
        }
    }

    public void w(CharSequence charSequence) {
        if (this.c1 != null) {
            xe.q("Preference already has a SummaryProvider set.");
        } else {
            if (TextUtils.equals(this.z0, charSequence)) {
                return;
            }
            this.z0 = charSequence;
            i();
        }
    }

    public final void x(boolean z) {
        if (this.N0 != z) {
            this.N0 = z;
            m33 m33Var = this.X0;
            if (m33Var != null) {
                Handler handler = m33Var.h;
                f33 f33Var = m33Var.i;
                handler.removeCallbacks(f33Var);
                handler.post(f33Var);
            }
        }
    }

    public boolean y() {
        return !h();
    }

    public final boolean z() {
        return (this.f == null || !this.I0 || TextUtils.isEmpty(this.C0)) ? false : true;
    }

    public void n() {
    }

    public void s(Object obj) {
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, l72.p(context, R.attr.preferenceStyle, android.R.attr.preferenceStyle));
    }
}
