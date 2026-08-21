package defpackage;

import android.app.Application;
import android.os.Bundle;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lp3 implements mq4 {
    public final Application a;
    public final lq4 b;
    public final Bundle c;
    public final r92 d;
    public final hp3 e;

    public lp3(Application application, kp3 kp3Var, Bundle bundle) {
        lq4 lq4Var;
        this.e = kp3Var.getSavedStateRegistry();
        this.d = kp3Var.getLifecycle();
        this.c = bundle;
        this.a = application;
        if (application != null) {
            lq4Var = lq4.d;
            if (lq4Var == null) {
                lq4Var = new lq4(application);
                lq4.d = lq4Var;
            }
        } else {
            lq4Var = new lq4(null);
        }
        this.b = lq4Var;
    }

    @Override // defpackage.mq4
    public final iq4 a(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return d(cls, canonicalName);
        }
        xe.k("Local and anonymous classes can not be ViewModels");
        return null;
    }

    @Override // defpackage.mq4
    public final iq4 b(Class cls, in2 in2Var) {
        LinkedHashMap linkedHashMap = in2Var.a;
        String str = (String) linkedHashMap.get(nq4.a);
        if (str == null) {
            xe.q("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
            return null;
        }
        if (linkedHashMap.get(cp3.a) == null || linkedHashMap.get(cp3.b) == null) {
            if (this.d != null) {
                return d(cls, str);
            }
            xe.q("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
            return null;
        }
        Application application = (Application) linkedHashMap.get(lq4.e);
        boolean zIsAssignableFrom = b8.class.isAssignableFrom(cls);
        Constructor constructorA = (!zIsAssignableFrom || application == null) ? mp3.a(cls, mp3.b) : mp3.a(cls, mp3.a);
        return constructorA == null ? this.b.b(cls, in2Var) : (!zIsAssignableFrom || application == null) ? mp3.b(cls, constructorA, cp3.a(in2Var)) : mp3.b(cls, constructorA, application, cp3.a(in2Var));
    }

    @Override // defpackage.mq4
    public final iq4 c(j50 j50Var, in2 in2Var) {
        Class cls = j50Var.a;
        cls.getClass();
        return b(cls, in2Var);
    }

    public final iq4 d(Class cls, String str) {
        ap3 ap3Var;
        r92 r92Var = this.d;
        if (r92Var == null) {
            vp1.n("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
            return null;
        }
        boolean zIsAssignableFrom = b8.class.isAssignableFrom(cls);
        Application application = this.a;
        Constructor constructorA = (!zIsAssignableFrom || application == null) ? mp3.a(cls, mp3.b) : mp3.a(cls, mp3.a);
        int i = 3;
        if (constructorA == null) {
            if (application != null) {
                return this.b.a(cls);
            }
            ck1 ck1Var = ck1.b;
            if (ck1Var == null) {
                ck1Var = new ck1(i);
                ck1.b = ck1Var;
            }
            return ck1Var.a(cls);
        }
        hp3 hp3Var = this.e;
        hp3Var.getClass();
        Bundle bundleA = hp3Var.a(str);
        if (bundleA == null) {
            bundleA = this.c;
        }
        if (bundleA == null) {
            ap3Var = new ap3();
        } else {
            ClassLoader classLoader = ap3.class.getClassLoader();
            classLoader.getClass();
            bundleA.setClassLoader(classLoader);
            dg2 dg2Var = new dg2(bundleA.size());
            for (String str2 : bundleA.keySet()) {
                str2.getClass();
                dg2Var.put(str2, bundleA.get(str2));
            }
            ap3Var = new ap3(dg2Var.b());
        }
        bp3 bp3Var = new bp3(str, ap3Var);
        bp3Var.x(hp3Var, r92Var);
        q92 q92VarB = r92Var.b();
        if (q92VarB == q92.f || q92VarB.compareTo(q92.A) >= 0) {
            hp3Var.d();
        } else {
            r92Var.a(new bm0(i, r92Var, hp3Var));
        }
        iq4 iq4VarB = (!zIsAssignableFrom || application == null) ? mp3.b(cls, constructorA, ap3Var) : mp3.b(cls, constructorA, application, ap3Var);
        iq4VarB.a("androidx.lifecycle.savedstate.vm.tag", bp3Var);
        return iq4VarB;
    }
}
