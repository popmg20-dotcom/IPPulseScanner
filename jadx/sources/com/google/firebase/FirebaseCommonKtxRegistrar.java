package com.google.firebase;

import com.google.firebase.components.ComponentRegistrar;
import defpackage.bi;
import defpackage.d7;
import defpackage.e70;
import defpackage.ef0;
import defpackage.ez4;
import defpackage.fc3;
import defpackage.ha2;
import defpackage.ho0;
import defpackage.t60;
import defpackage.un;
import defpackage.vd3;
import defpackage.wl3;
import defpackage.x80;
import defpackage.xe;
import defpackage.xk4;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class FirebaseCommonKtxRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<x80> getComponents() {
        fc3 fc3Var = new fc3(bi.class, ef0.class);
        fc3[] fc3VarArr = new fc3[0];
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(fc3Var);
        for (fc3 fc3Var2 : fc3VarArr) {
            ez4.k(fc3Var2, "Null interface");
        }
        Collections.addAll(hashSet, fc3VarArr);
        ho0 ho0Var = new ho0(new fc3(bi.class, Executor.class), 1, 0);
        if (hashSet.contains(ho0Var.a)) {
            xe.k("Components are not allowed to depend on interfaces they themselves provide.");
            return null;
        }
        hashSet2.add(ho0Var);
        x80 x80Var = new x80(null, new HashSet(hashSet), new HashSet(hashSet2), 0, 0, vd3.X, hashSet3);
        fc3 fc3Var3 = new fc3(ha2.class, ef0.class);
        fc3[] fc3VarArr2 = new fc3[0];
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        HashSet hashSet6 = new HashSet();
        hashSet4.add(fc3Var3);
        for (fc3 fc3Var4 : fc3VarArr2) {
            ez4.k(fc3Var4, "Null interface");
        }
        Collections.addAll(hashSet4, fc3VarArr2);
        ho0 ho0Var2 = new ho0(new fc3(ha2.class, Executor.class), 1, 0);
        if (hashSet4.contains(ho0Var2.a)) {
            xe.k("Components are not allowed to depend on interfaces they themselves provide.");
            return null;
        }
        hashSet5.add(ho0Var2);
        x80 x80Var2 = new x80(null, new HashSet(hashSet4), new HashSet(hashSet5), 0, 0, wl3.Y, hashSet6);
        fc3 fc3Var5 = new fc3(un.class, ef0.class);
        fc3[] fc3VarArr3 = new fc3[0];
        HashSet hashSet7 = new HashSet();
        HashSet hashSet8 = new HashSet();
        HashSet hashSet9 = new HashSet();
        hashSet7.add(fc3Var5);
        for (fc3 fc3Var6 : fc3VarArr3) {
            ez4.k(fc3Var6, "Null interface");
        }
        Collections.addAll(hashSet7, fc3VarArr3);
        ho0 ho0Var3 = new ho0(new fc3(un.class, Executor.class), 1, 0);
        if (hashSet7.contains(ho0Var3.a)) {
            xe.k("Components are not allowed to depend on interfaces they themselves provide.");
            return null;
        }
        hashSet8.add(ho0Var3);
        x80 x80Var3 = new x80(null, new HashSet(hashSet7), new HashSet(hashSet8), 0, 0, t60.Z, hashSet9);
        fc3 fc3Var7 = new fc3(xk4.class, ef0.class);
        fc3[] fc3VarArr4 = new fc3[0];
        HashSet hashSet10 = new HashSet();
        HashSet hashSet11 = new HashSet();
        HashSet hashSet12 = new HashSet();
        hashSet10.add(fc3Var7);
        for (fc3 fc3Var8 : fc3VarArr4) {
            ez4.k(fc3Var8, "Null interface");
        }
        Collections.addAll(hashSet10, fc3VarArr4);
        ho0 ho0Var4 = new ho0(new fc3(xk4.class, Executor.class), 1, 0);
        if (hashSet10.contains(ho0Var4.a)) {
            xe.k("Components are not allowed to depend on interfaces they themselves provide.");
            return null;
        }
        hashSet11.add(ho0Var4);
        return e70.K(x80Var, x80Var2, x80Var3, new x80(null, new HashSet(hashSet10), new HashSet(hashSet11), 0, 0, d7.Z, hashSet12));
    }
}
