package defpackage;

import android.text.Editable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n31 extends Editable.Factory {
    public static final Object a = new Object();
    public static volatile n31 b;
    public static Class c;

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence charSequence) {
        Class cls = c;
        return cls != null ? new rz3(cls, charSequence) : super.newEditable(charSequence);
    }
}
