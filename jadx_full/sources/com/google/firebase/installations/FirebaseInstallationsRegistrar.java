package com.google.firebase.installations;

import com.google.firebase.components.ComponentRegistrar;
import defpackage.a71;
import defpackage.bi;
import defpackage.cf1;
import defpackage.df1;
import defpackage.fc3;
import defpackage.ho0;
import defpackage.j90;
import defpackage.l72;
import defpackage.pr1;
import defpackage.qr1;
import defpackage.un;
import defpackage.w80;
import defpackage.x80;
import defpackage.zd;
import defpackage.ze1;
import defpackage.zs3;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class FirebaseInstallationsRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-installations";

    /* JADX INFO: Access modifiers changed from: private */
    public static df1 lambda$getComponents$0(j90 j90Var) {
        return new cf1((ze1) j90Var.get(ze1.class), j90Var.b(qr1.class), (ExecutorService) j90Var.d(new fc3(bi.class, ExecutorService.class)), new zs3((Executor) j90Var.d(new fc3(un.class, Executor.class))));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<x80> getComponents() {
        zd zdVar = new zd(df1.class, new Class[0]);
        zdVar.z = LIBRARY_NAME;
        zdVar.a(ho0.a(ze1.class));
        zdVar.a(new ho0(0, 1, qr1.class));
        zdVar.a(new ho0(new fc3(bi.class, ExecutorService.class), 1, 0));
        zdVar.a(new ho0(new fc3(un.class, Executor.class), 1, 0));
        zdVar.Y = new a71(24);
        x80 x80VarH = zdVar.h();
        pr1 pr1Var = new pr1();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(fc3.a(pr1.class));
        return Arrays.asList(x80VarH, new x80(null, new HashSet(hashSet), new HashSet(hashSet2), 0, 1, new w80(0, pr1Var), hashSet3), l72.i(LIBRARY_NAME, "19.1.0"));
    }
}
