package defpackage;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Trace;
import android.util.Base64;
import android.util.Log;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.provider.FirebaseInitProvider;
import io.sentry.android.core.a1;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ze1 {
    public static final Object j = new Object();
    public static final ie k = new ie(0);
    public final Context a;
    public final String b;
    public final ff1 c;
    public final r90 d;
    public final a92 g;
    public final da3 h;
    public final AtomicBoolean e = new AtomicBoolean(false);
    public final AtomicBoolean f = new AtomicBoolean();
    public final CopyOnWriteArrayList i = new CopyOnWriteArrayList();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.List] */
    public ze1(Context context, String str, ff1 ff1Var) {
        ?? arrayList;
        int i = 0;
        new CopyOnWriteArrayList();
        this.a = context;
        tj4.f(str);
        this.b = str;
        this.c = ff1Var;
        gh ghVar = FirebaseInitProvider.b;
        Trace.beginSection("Firebase");
        Trace.beginSection("ComponentDiscovery");
        ArrayList arrayList2 = new ArrayList();
        Bundle bundle = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                a1.n("ComponentDiscovery", "Context has no PackageManager.");
            } else {
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) ComponentDiscoveryService.class), 128);
                if (serviceInfo == null) {
                    a1.n("ComponentDiscovery", ComponentDiscoveryService.class + " has no service info.");
                } else {
                    bundle = serviceInfo.metaData;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
            a1.n("ComponentDiscovery", "Application info not found.");
        }
        if (bundle == null) {
            a1.n("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
            arrayList = Collections.EMPTY_LIST;
        } else {
            arrayList = new ArrayList();
            for (String str2 : bundle.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(bundle.get(str2)) && str2.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str2.substring(31));
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new m90(i, (String) it.next()));
        }
        Trace.endSection();
        Trace.beginSection("Runtime");
        vk4 vk4Var = vk4.b;
        ArrayList arrayList3 = new ArrayList();
        ArrayList<x80> arrayList4 = new ArrayList();
        arrayList3.addAll(arrayList2);
        int i2 = 1;
        arrayList3.add(new m90(i2, new FirebaseCommonRegistrar()));
        arrayList3.add(new m90(i2, new ExecutorsRegistrar()));
        arrayList4.add(x80.a(context, Context.class, new Class[0]));
        arrayList4.add(x80.a(this, ze1.class, new Class[0]));
        arrayList4.add(x80.a(ff1Var, ff1.class, new Class[0]));
        vd3 vd3Var = new vd3(13);
        if (p95.v(context) && FirebaseInitProvider.f.get()) {
            arrayList4.add(x80.a(ghVar, gh.class, new Class[0]));
        }
        vk4 vk4Var2 = vk4.b;
        r90 r90Var = new r90();
        r90Var.a = new HashMap();
        r90Var.b = new HashMap();
        r90Var.c = new HashMap();
        r90Var.d = new HashSet();
        r90Var.f = new AtomicReference();
        y51 y51Var = new y51();
        r90Var.e = y51Var;
        r90Var.g = vd3Var;
        ArrayList<x80> arrayList5 = new ArrayList();
        int i3 = 2;
        arrayList5.add(x80.a(y51Var, y51.class, g54.class, vb3.class));
        arrayList5.add(x80.a(r90Var, r90.class, new Class[0]));
        for (x80 x80Var : arrayList4) {
            if (x80Var != null) {
                arrayList5.add(x80Var);
            }
        }
        ArrayList arrayList6 = new ArrayList();
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList6.add(it2.next());
        }
        ArrayList arrayList7 = new ArrayList();
        synchronized (r90Var) {
            Iterator it3 = arrayList6.iterator();
            while (it3.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = (ComponentRegistrar) ((da3) it3.next()).get();
                    if (componentRegistrar != null) {
                        arrayList5.addAll(((vd3) r90Var.g).y(componentRegistrar));
                        it3.remove();
                    }
                } catch (u12 e) {
                    it3.remove();
                    a1.o("ComponentDiscovery", "Invalid component registrar.", e);
                }
            }
            Iterator it4 = arrayList5.iterator();
            while (it4.hasNext()) {
                Object[] array = ((x80) it4.next()).b.toArray();
                int length = array.length;
                int i4 = 0;
                while (true) {
                    if (i4 < length) {
                        Object obj = array[i4];
                        if (obj.toString().contains("kotlinx.coroutines.CoroutineDispatcher")) {
                            if (((HashSet) r90Var.d).contains(obj.toString())) {
                                it4.remove();
                                break;
                            }
                            ((HashSet) r90Var.d).add(obj.toString());
                        }
                        i4++;
                    }
                }
            }
            if (((HashMap) r90Var.a).isEmpty()) {
                ye.j(arrayList5);
            } else {
                ArrayList arrayList8 = new ArrayList(((HashMap) r90Var.a).keySet());
                arrayList8.addAll(arrayList5);
                ye.j(arrayList8);
            }
            for (x80 x80Var2 : arrayList5) {
                ((HashMap) r90Var.a).put(x80Var2, new a92(new q90(i, r90Var, x80Var2)));
            }
            arrayList7.addAll(r90Var.j(arrayList5));
            arrayList7.addAll(r90Var.k());
            r90Var.i();
        }
        Iterator it5 = arrayList7.iterator();
        while (it5.hasNext()) {
            ((Runnable) it5.next()).run();
        }
        Boolean bool = (Boolean) ((AtomicReference) r90Var.f).get();
        if (bool != null) {
            r90Var.g((HashMap) r90Var.a, bool.booleanValue());
        }
        this.d = r90Var;
        Trace.endSection();
        this.g = new a92(new q90(i3, this, context));
        this.h = r90Var.b(nl0.class);
        we1 we1Var = new we1(this);
        a();
        if (this.e.get()) {
            di.X.b.get();
        }
        this.i.add(we1Var);
        Trace.endSection();
    }

    public static ze1 b() {
        ze1 ze1Var;
        synchronized (j) {
            try {
                ze1Var = (ze1) k.get("[DEFAULT]");
                if (ze1Var == null) {
                    throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + u9.i() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
                }
                ((nl0) ze1Var.h.get()).b();
            } catch (Throwable th) {
                throw th;
            }
        }
        return ze1Var;
    }

    public static ze1 e(Context context) {
        synchronized (j) {
            try {
                if (k.containsKey("[DEFAULT]")) {
                    return b();
                }
                ff1 ff1VarA = ff1.a(context);
                if (ff1VarA == null) {
                    a1.n("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                    return null;
                }
                return f(context, ff1VarA);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static ze1 f(Context context, ff1 ff1Var) {
        ze1 ze1Var;
        AtomicReference atomicReference = xe1.a;
        if (context.getApplicationContext() instanceof Application) {
            Application application = (Application) context.getApplicationContext();
            AtomicReference atomicReference2 = xe1.a;
            if (atomicReference2.get() == null) {
                xe1 xe1Var = new xe1();
                while (true) {
                    if (atomicReference2.compareAndSet(null, xe1Var)) {
                        di.b(application);
                        di.X.a(xe1Var);
                        break;
                    }
                    if (atomicReference2.get() != null) {
                        break;
                    }
                }
            }
        }
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (j) {
            ie ieVar = k;
            tj4.k("FirebaseApp name [DEFAULT] already exists!", !ieVar.containsKey("[DEFAULT]"));
            tj4.j(context, "Application context cannot be null.");
            ze1Var = new ze1(context, "[DEFAULT]", ff1Var);
            ieVar.put("[DEFAULT]", ze1Var);
        }
        ze1Var.d();
        return ze1Var;
    }

    public final void a() {
        tj4.k("FirebaseApp was deleted", !this.f.get());
    }

    public final String c() {
        StringBuilder sb = new StringBuilder();
        a();
        byte[] bytes = this.b.getBytes(Charset.defaultCharset());
        sb.append(bytes == null ? null : Base64.encodeToString(bytes, 11));
        sb.append("+");
        a();
        byte[] bytes2 = this.c.b.getBytes(Charset.defaultCharset());
        sb.append(bytes2 != null ? Base64.encodeToString(bytes2, 11) : null);
        return sb.toString();
    }

    public final void d() {
        HashMap map;
        if (!p95.v(this.a)) {
            StringBuilder sb = new StringBuilder("Device in Direct Boot Mode: postponing initialization of Firebase APIs for app ");
            a();
            sb.append(this.b);
            Log.i("FirebaseApp", sb.toString());
            Context context = this.a;
            AtomicReference atomicReference = ye1.b;
            if (atomicReference.get() == null) {
                ye1 ye1Var = new ye1(context);
                while (!atomicReference.compareAndSet(null, ye1Var)) {
                    if (atomicReference.get() != null) {
                        return;
                    }
                }
                context.registerReceiver(ye1Var, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder("Device unlocked: initializing all Firebase APIs for app ");
        a();
        sb2.append(this.b);
        Log.i("FirebaseApp", sb2.toString());
        r90 r90Var = this.d;
        a();
        boolean zEquals = "[DEFAULT]".equals(this.b);
        AtomicReference atomicReference2 = (AtomicReference) r90Var.f;
        Boolean boolValueOf = Boolean.valueOf(zEquals);
        while (true) {
            if (atomicReference2.compareAndSet(null, boolValueOf)) {
                synchronized (r90Var) {
                    map = new HashMap((HashMap) r90Var.a);
                }
                r90Var.g(map, zEquals);
                break;
            } else if (atomicReference2.get() != null) {
                break;
            }
        }
        ((nl0) this.h.get()).b();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ze1)) {
            return false;
        }
        ze1 ze1Var = (ze1) obj;
        ze1Var.a();
        return this.b.equals(ze1Var.b);
    }

    public final boolean g() {
        boolean z;
        a();
        ii0 ii0Var = (ii0) this.g.get();
        synchronized (ii0Var) {
            z = ii0Var.a;
        }
        return z;
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        v62 v62Var = new v62(this);
        v62Var.o(this.b, "name");
        v62Var.o(this.c, "options");
        return v62Var.toString();
    }
}
