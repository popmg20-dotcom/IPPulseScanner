package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import defpackage.ad3;
import defpackage.k33;
import defpackage.xe;
import defpackage.xw3;
import io.netty.channel.internal.ChannelUtils;
import io.sentry.android.core.a1;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class PreferenceGroup extends Preference {
    public final xw3 e1;
    public final ArrayList f1;
    public boolean g1;
    public int h1;
    public boolean i1;
    public int j1;

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.e1 = new xw3(0);
        new Handler(Looper.getMainLooper());
        this.g1 = true;
        this.h1 = 0;
        this.i1 = false;
        this.j1 = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
        this.f1 = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ad3.i, i, 0);
        this.g1 = typedArrayObtainStyledAttributes.getBoolean(2, typedArrayObtainStyledAttributes.getBoolean(2, true));
        if (typedArrayObtainStyledAttributes.hasValue(1)) {
            int i3 = typedArrayObtainStyledAttributes.getInt(1, typedArrayObtainStyledAttributes.getInt(1, ChannelUtils.WRITE_STATUS_SNDBUF_FULL));
            if (i3 != Integer.MAX_VALUE && TextUtils.isEmpty(this.C0)) {
                a1.d("PreferenceGroup", getClass().getSimpleName().concat(" should have a key defined if it contains an expandable preference"));
            }
            this.j1 = i3;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final Preference A(CharSequence charSequence) {
        Preference preferenceA;
        if (charSequence == null) {
            xe.k("Key cannot be null");
            return null;
        }
        if (TextUtils.equals(this.C0, charSequence)) {
            return this;
        }
        int size = this.f1.size();
        for (int i = 0; i < size; i++) {
            Preference preferenceB = B(i);
            if (TextUtils.equals(preferenceB.C0, charSequence)) {
                return preferenceB;
            }
            if ((preferenceB instanceof PreferenceGroup) && (preferenceA = ((PreferenceGroup) preferenceB).A(charSequence)) != null) {
                return preferenceA;
            }
        }
        return null;
    }

    public final Preference B(int i) {
        return (Preference) this.f1.get(i);
    }

    @Override // androidx.preference.Preference
    public final void b(Bundle bundle) {
        super.b(bundle);
        int size = this.f1.size();
        for (int i = 0; i < size; i++) {
            B(i).b(bundle);
        }
    }

    @Override // androidx.preference.Preference
    public final void c(Bundle bundle) {
        super.c(bundle);
        int size = this.f1.size();
        for (int i = 0; i < size; i++) {
            B(i).c(bundle);
        }
    }

    @Override // androidx.preference.Preference
    public final void j(boolean z) {
        super.j(z);
        int size = this.f1.size();
        for (int i = 0; i < size; i++) {
            Preference preferenceB = B(i);
            if (preferenceB.M0 == z) {
                preferenceB.M0 = !z;
                preferenceB.j(preferenceB.y());
                preferenceB.i();
            }
        }
    }

    @Override // androidx.preference.Preference
    public final void k() {
        super.k();
        this.i1 = true;
        int size = this.f1.size();
        for (int i = 0; i < size; i++) {
            B(i).k();
        }
    }

    @Override // androidx.preference.Preference
    public final void o() {
        super.o();
        this.i1 = false;
        int size = this.f1.size();
        for (int i = 0; i < size; i++) {
            B(i).o();
        }
    }

    @Override // androidx.preference.Preference
    public final void q(Parcelable parcelable) {
        if (!parcelable.getClass().equals(k33.class)) {
            super.q(parcelable);
            return;
        }
        k33 k33Var = (k33) parcelable;
        this.j1 = k33Var.b;
        super.q(k33Var.getSuperState());
    }

    @Override // androidx.preference.Preference
    public final Parcelable r() {
        super.r();
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        return new k33(this.j1);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
    }
}
