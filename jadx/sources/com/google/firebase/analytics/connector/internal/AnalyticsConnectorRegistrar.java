package com.google.firebase.analytics.connector.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.firebase.components.ComponentRegistrar;
import defpackage.b55;
import defpackage.c7;
import defpackage.d7;
import defpackage.g54;
import defpackage.ho0;
import defpackage.j90;
import defpackage.k01;
import defpackage.l72;
import defpackage.p84;
import defpackage.tj4;
import defpackage.x80;
import defpackage.xe;
import defpackage.y51;
import defpackage.zd;
import defpackage.ze1;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class AnalyticsConnectorRegistrar implements ComponentRegistrar {
    /* JADX INFO: Access modifiers changed from: private */
    public static c7 lambda$getComponents$0(j90 j90Var) {
        ze1 ze1Var = (ze1) j90Var.get(ze1.class);
        Context context = (Context) j90Var.get(Context.class);
        g54 g54Var = (g54) j90Var.get(g54.class);
        tj4.i(ze1Var);
        tj4.i(context);
        tj4.i(g54Var);
        tj4.i(context.getApplicationContext());
        if (d7.f == null) {
            synchronized (d7.class) {
                try {
                    if (d7.f == null) {
                        Bundle bundle = new Bundle(1);
                        ze1Var.a();
                        if ("[DEFAULT]".equals(ze1Var.b)) {
                            ((y51) g54Var).a();
                            bundle.putBoolean("dataCollectionDefaultEnabled", ze1Var.g());
                        }
                        k01 k01Var = b55.c(context, bundle).b;
                        d7 d7Var = new d7(0);
                        tj4.i(k01Var);
                        new ConcurrentHashMap();
                        d7.f = d7Var;
                    }
                } finally {
                }
            }
        }
        return d7.f;
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<x80> getComponents() {
        zd zdVar = new zd(c7.class, new Class[0]);
        zdVar.a(ho0.a(ze1.class));
        zdVar.a(ho0.a(Context.class));
        zdVar.a(ho0.a(g54.class));
        zdVar.Y = p84.z;
        if (zdVar.b == 0) {
            zdVar.b = 2;
            return Arrays.asList(zdVar.h(), l72.i("fire-analytics", "23.0.0"));
        }
        xe.q("Instantiation type has already been set.");
        return null;
    }
}
