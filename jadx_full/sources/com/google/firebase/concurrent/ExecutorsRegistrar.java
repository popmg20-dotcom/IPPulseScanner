package com.google.firebase.concurrent;

import android.os.Build;
import android.os.StrictMode;
import com.google.firebase.components.ComponentRegistrar;
import defpackage.a71;
import defpackage.a92;
import defpackage.ad0;
import defpackage.bi;
import defpackage.ez4;
import defpackage.fc3;
import defpackage.ha2;
import defpackage.p90;
import defpackage.tg0;
import defpackage.un;
import defpackage.x80;
import defpackage.xk4;
import defpackage.yn0;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ExecutorsRegistrar implements ComponentRegistrar {
    public static final a92 a = new a92(new p90(1));
    public static final a92 b = new a92(new p90(2));
    public static final a92 c = new a92(new p90(3));
    public static final a92 d = new a92(new p90(4));

    public static yn0 a() {
        StrictMode.ThreadPolicy.Builder builderDetectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
        builderDetectNetwork.detectResourceMismatches();
        if (Build.VERSION.SDK_INT >= 26) {
            builderDetectNetwork.detectUnbufferedIo();
        }
        return new yn0(Executors.newFixedThreadPool(4, new tg0("Firebase Background", 10, builderDetectNetwork.penaltyLog().build())), (ScheduledExecutorService) d.get());
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public final List getComponents() {
        fc3 fc3Var = new fc3(bi.class, ScheduledExecutorService.class);
        int i = 2;
        int i2 = 0;
        int i3 = 1;
        fc3[] fc3VarArr = {new fc3(bi.class, ExecutorService.class), new fc3(bi.class, Executor.class)};
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(fc3Var);
        for (int i4 = 0; i4 < 2; i4++) {
            ez4.k(fc3VarArr[i4], "Null interface");
        }
        Collections.addAll(hashSet, fc3VarArr);
        x80 x80Var = new x80(null, new HashSet(hashSet), new HashSet(hashSet2), 0, 0, new ad0(29), hashSet3);
        fc3 fc3Var2 = new fc3(un.class, ScheduledExecutorService.class);
        fc3[] fc3VarArr2 = {new fc3(un.class, ExecutorService.class), new fc3(un.class, Executor.class)};
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        HashSet hashSet6 = new HashSet();
        hashSet4.add(fc3Var2);
        for (int i5 = 0; i5 < 2; i5++) {
            ez4.k(fc3VarArr2[i5], "Null interface");
        }
        Collections.addAll(hashSet4, fc3VarArr2);
        x80 x80Var2 = new x80(null, new HashSet(hashSet4), new HashSet(hashSet5), 0, 0, new a71(i2), hashSet6);
        fc3 fc3Var3 = new fc3(ha2.class, ScheduledExecutorService.class);
        fc3[] fc3VarArr3 = {new fc3(ha2.class, ExecutorService.class), new fc3(ha2.class, Executor.class)};
        HashSet hashSet7 = new HashSet();
        HashSet hashSet8 = new HashSet();
        HashSet hashSet9 = new HashSet();
        hashSet7.add(fc3Var3);
        for (int i6 = 0; i6 < 2; i6++) {
            ez4.k(fc3VarArr3[i6], "Null interface");
        }
        Collections.addAll(hashSet7, fc3VarArr3);
        x80 x80Var3 = new x80(null, new HashSet(hashSet7), new HashSet(hashSet8), 0, 0, new a71(i3), hashSet9);
        fc3 fc3Var4 = new fc3(xk4.class, Executor.class);
        fc3[] fc3VarArr4 = new fc3[0];
        HashSet hashSet10 = new HashSet();
        HashSet hashSet11 = new HashSet();
        HashSet hashSet12 = new HashSet();
        hashSet10.add(fc3Var4);
        for (fc3 fc3Var5 : fc3VarArr4) {
            ez4.k(fc3Var5, "Null interface");
        }
        Collections.addAll(hashSet10, fc3VarArr4);
        return Arrays.asList(x80Var, x80Var2, x80Var3, new x80(null, new HashSet(hashSet10), new HashSet(hashSet11), 0, 0, new a71(i), hashSet12));
    }
}
