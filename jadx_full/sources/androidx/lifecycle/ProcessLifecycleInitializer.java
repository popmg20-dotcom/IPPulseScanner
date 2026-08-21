package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import defpackage.d02;
import defpackage.ed4;
import defpackage.g41;
import defpackage.k53;
import defpackage.p92;
import defpackage.xe;
import defpackage.y92;
import defpackage.z92;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements d02 {
    @Override // defpackage.d02
    public final List a() {
        return g41.b;
    }

    @Override // defpackage.d02
    public final Object b(Context context) {
        context.getClass();
        ed4 ed4VarC = ed4.C(context);
        ed4VarC.getClass();
        if (!((HashSet) ed4VarC.z).contains(ProcessLifecycleInitializer.class)) {
            xe.q("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml");
            return null;
        }
        if (!z92.a.getAndSet(true)) {
            Context applicationContext = context.getApplicationContext();
            applicationContext.getClass();
            ((Application) applicationContext).registerActivityLifecycleCallbacks(new y92());
        }
        ProcessLifecycleOwner processLifecycleOwner = ProcessLifecycleOwner.z0;
        processLifecycleOwner.getClass();
        processLifecycleOwner.X = new Handler();
        processLifecycleOwner.Y.f(p92.ON_CREATE);
        Context applicationContext2 = context.getApplicationContext();
        applicationContext2.getClass();
        ((Application) applicationContext2).registerActivityLifecycleCallbacks(new k53(processLifecycleOwner));
        return processLifecycleOwner;
    }
}
