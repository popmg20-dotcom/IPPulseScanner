package com.google.firebase;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.google.firebase.components.ComponentRegistrar;
import defpackage.a71;
import defpackage.ad0;
import defpackage.an0;
import defpackage.bi;
import defpackage.ez4;
import defpackage.fc3;
import defpackage.ho0;
import defpackage.jd;
import defpackage.l72;
import defpackage.n82;
import defpackage.nl0;
import defpackage.pr1;
import defpackage.qr1;
import defpackage.rr1;
import defpackage.x80;
import defpackage.xe;
import defpackage.zd;
import defpackage.ze1;
import defpackage.zg;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class FirebaseCommonRegistrar implements ComponentRegistrar {
    public static /* synthetic */ String a(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return (applicationInfo == null || Build.VERSION.SDK_INT < 24) ? "" : String.valueOf(applicationInfo.minSdkVersion);
    }

    public static String b(String str) {
        return str.replace(' ', '_').replace('/', '_');
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public final List getComponents() {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(fc3.a(an0.class));
        for (Class cls : new Class[0]) {
            ez4.k(cls, "Null interface");
            hashSet.add(fc3.a(cls));
        }
        ho0 ho0Var = new ho0(2, 0, zg.class);
        String str = null;
        if (hashSet.contains(ho0Var.a)) {
            xe.k("Components are not allowed to depend on interfaces they themselves provide.");
            return null;
        }
        hashSet2.add(ho0Var);
        arrayList.add(new x80(null, new HashSet(hashSet), new HashSet(hashSet2), 0, 0, new ad0(11), hashSet3));
        fc3 fc3Var = new fc3(bi.class, Executor.class);
        zd zdVar = new zd(nl0.class, qr1.class, rr1.class);
        zdVar.a(ho0.a(Context.class));
        zdVar.a(ho0.a(ze1.class));
        zdVar.a(new ho0(2, 0, pr1.class));
        zdVar.a(new ho0(1, 1, an0.class));
        zdVar.a(new ho0(fc3Var, 1, 0));
        zdVar.Y = new jd(7, fc3Var);
        arrayList.add(zdVar.h());
        arrayList.add(l72.i("fire-android", String.valueOf(Build.VERSION.SDK_INT)));
        arrayList.add(l72.i("fire-core", "22.0.1"));
        arrayList.add(l72.i("device-name", b(Build.PRODUCT)));
        arrayList.add(l72.i("device-model", b(Build.DEVICE)));
        arrayList.add(l72.i("device-brand", b(Build.BRAND)));
        arrayList.add(l72.l("android-target-sdk", new a71(20)));
        arrayList.add(l72.l("android-min-sdk", new a71(21)));
        arrayList.add(l72.l("android-platform", new a71(22)));
        arrayList.add(l72.l("android-installer", new a71(23)));
        try {
            n82.f.getClass();
            str = "2.3.10";
        } catch (NoClassDefFoundError unused) {
        }
        if (str != null) {
            arrayList.add(l72.i("kotlin", str));
        }
        return arrayList;
    }
}
