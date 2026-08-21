package defpackage;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class db {
    public static final PorterDuff.Mode b = PorterDuff.Mode.SRC_IN;
    public static db c;
    public ck3 a;

    public static synchronized db a() {
        try {
            if (c == null) {
                d();
            }
        } catch (Throwable th) {
            throw th;
        }
        return c;
    }

    public static synchronized PorterDuffColorFilter c(int i, PorterDuff.Mode mode) {
        return ck3.h(i, mode);
    }

    public static synchronized void d() {
        if (c == null) {
            db dbVar = new db();
            c = dbVar;
            dbVar.a = ck3.d();
            c.a.m(new cm2(2));
        }
    }

    public final synchronized Drawable b(Context context, int i) {
        return this.a.f(context, i);
    }
}
