package androidx.emoji2.text;

import android.content.Context;
import androidx.lifecycle.ProcessLifecycleInitializer;
import defpackage.ci1;
import defpackage.d02;
import defpackage.da2;
import defpackage.e;
import defpackage.ed4;
import defpackage.k31;
import defpackage.m31;
import defpackage.r92;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class EmojiCompatInitializer implements d02 {
    @Override // defpackage.d02
    public final List a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // defpackage.d02
    public final Object b(Context context) {
        ci1 ci1Var = new ci1(new m31(context, 0));
        ci1Var.a = 1;
        if (k31.k == null) {
            synchronized (k31.j) {
                try {
                    if (k31.k == null) {
                        k31.k = new k31(ci1Var);
                    }
                } finally {
                }
            }
        }
        c(context);
        return Boolean.TRUE;
    }

    public final void c(Context context) {
        Object objW;
        ed4 ed4VarC = ed4.C(context);
        ed4VarC.getClass();
        synchronized (ed4.Z) {
            try {
                objW = ((HashMap) ed4VarC.f).get(ProcessLifecycleInitializer.class);
                if (objW == null) {
                    objW = ed4VarC.w(ProcessLifecycleInitializer.class, new HashSet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        r92 lifecycle = ((da2) objW).getLifecycle();
        lifecycle.a(new e(this, lifecycle));
    }
}
