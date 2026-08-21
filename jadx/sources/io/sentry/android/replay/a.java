package io.sentry.android.replay;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import defpackage.pl1;
import defpackage.r82;
import defpackage.uh3;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a extends r82 implements pl1 {
    public static final a A;
    public static final a A0;
    public static final a X;
    public static final a Y;
    public static final a Z;
    public static final a y0;
    public static final a z;
    public static final a z0;
    public final /* synthetic */ int f;

    static {
        int i = 0;
        z = new a(i, 0);
        A = new a(i, 1);
        X = new a(i, 2);
        Y = new a(i, 3);
        Z = new a(i, 4);
        y0 = new a(i, 5);
        z0 = new a(i, 6);
        A0 = new a(i, 7);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(int i, int i2) {
        super(i);
        this.f = i2;
    }

    @Override // defpackage.pl1
    public final Object a() throws NoSuchFieldException {
        Method method;
        switch (this.f) {
            case 0:
                return new uh3("_[a-z]");
            case 1:
                return new io.sentry.util.k();
            case 2:
                s sVar = new s();
                new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new io.sentry.android.core.g(13, sVar));
                return sVar;
            case 3:
                Class cls = (Class) y.a.getValue();
                if (cls == null) {
                    return null;
                }
                Field declaredField = cls.getDeclaredField("mViews");
                declaredField.setAccessible(true);
                return declaredField;
            case 4:
                try {
                    return Class.forName("android.view.WindowManagerGlobal");
                } catch (Throwable th) {
                    Log.w("WindowManagerSpy", th);
                    return null;
                }
            case 5:
                Class cls2 = (Class) y.a.getValue();
                if (cls2 == null || (method = cls2.getMethod("getInstance", null)) == null) {
                    return null;
                }
                return method.invoke(null, null);
            case 6:
                try {
                    return Class.forName("com.android.internal.policy.DecorView");
                } catch (Throwable th2) {
                    Log.d("WindowSpy", "Unexpected exception loading DecorView on API " + Build.VERSION.SDK_INT, th2);
                    return null;
                }
            default:
                Class cls3 = (Class) d0.a.getValue();
                if (cls3 == null) {
                    return null;
                }
                try {
                    Field declaredField2 = cls3.getDeclaredField("mWindow");
                    declaredField2.setAccessible(true);
                    return declaredField2;
                } catch (NoSuchFieldException e) {
                    Log.d("WindowSpy", "Unexpected exception retrieving " + cls3 + "#mWindow on API " + Build.VERSION.SDK_INT, e);
                    return null;
                }
        }
    }
}
