package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import defpackage.b55;
import defpackage.cf1;
import defpackage.e45;
import defpackage.jb5;
import defpackage.k45;
import defpackage.m45;
import defpackage.tj4;
import defpackage.vo;
import defpackage.zo2;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class FirebaseAnalytics {
    public static volatile FirebaseAnalytics b;
    public final b55 a;

    public FirebaseAnalytics(b55 b55Var) {
        tj4.i(b55Var);
        this.a = b55Var;
    }

    public static FirebaseAnalytics getInstance(Context context) {
        if (b == null) {
            synchronized (FirebaseAnalytics.class) {
                try {
                    if (b == null) {
                        b = new FirebaseAnalytics(b55.c(context, null));
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public static jb5 getScionFrontendApiImplementation(Context context, Bundle bundle) {
        b55 b55VarC = b55.c(context, bundle);
        if (b55VarC == null) {
            return null;
        }
        return new e45(b55VarC);
    }

    public String getFirebaseInstanceId() {
        try {
            return (String) vo.f(cf1.d().c());
        } catch (InterruptedException e) {
            zo2.q(e);
            return null;
        } catch (ExecutionException e2) {
            zo2.q(e2.getCause());
            return null;
        } catch (TimeoutException unused) {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        }
    }

    @Deprecated
    public void setCurrentScreen(Activity activity, String str, String str2) {
        k45 k45VarA = k45.a(activity);
        b55 b55Var = this.a;
        b55Var.getClass();
        b55Var.a(new m45(b55Var, k45VarA, str, str2));
    }
}
