package defpackage;

import android.content.res.AssetManager;
import android.os.Build;
import android.util.Log;
import io.sentry.android.core.a1;
import j$.util.DesugarCollections;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tx implements eu2 {
    public final Object A;
    public Object X;
    public Serializable Y;
    public Object Z;
    public final Executor b;
    public boolean f;
    public Object y0;
    public final Object z;

    public tx(List list, pz pzVar, Executor executor) {
        list.getClass();
        executor.getClass();
        this.z = new Object();
        this.A = new CopyOnWriteArrayList();
        this.Y = null;
        this.f = false;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            str.getClass();
            arrayList.add(new jz(e70.L(str), null));
        }
        this.X = arrayList;
        this.Z = pzVar;
        this.b = executor;
    }

    @Override // defpackage.eu2
    public void a(Executor executor, du2 du2Var) {
        List listUnmodifiableList;
        Throwable th;
        executor.getClass();
        ((CopyOnWriteArrayList) this.A).add(new c0(executor, du2Var));
        synchronized (this.z) {
            try {
                if (!this.f && !((CopyOnWriteArrayList) this.A).isEmpty()) {
                    Log.i("CameraPresenceSrc", "First observer added. Starting monitoring.");
                    this.f = true;
                    e();
                }
                listUnmodifiableList = DesugarCollections.unmodifiableList((List) this.X);
                th = (Throwable) this.Y;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        executor.execute(new b0(0, th, new c0(executor, du2Var), listUnmodifiableList));
    }

    public nc2 b() {
        vv vvVar = new vv();
        vvVar.c = new wj3();
        yv yvVar = new yv(vvVar);
        vvVar.b = yvVar;
        vvVar.a = fw.class;
        try {
            this.b.execute(new s7(10, this, vvVar));
            vvVar.a = "FetchData for CameraAvailability";
        } catch (Exception e) {
            yvVar.b(e);
        }
        return yvVar;
    }

    public FileInputStream c(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e) {
            String message = e.getMessage();
            if (message == null || !message.contains("compressed")) {
                return null;
            }
            ((a73) this.z).j();
            return null;
        }
    }

    public void d(int i, Serializable serializable) {
        this.b.execute(new iw(this, i, serializable, 6));
    }

    public void e() {
        if (((sx) this.y0) != null) {
            a1.n("Camera2PresenceSrc", "Monitoring already started. Unregistering existing callback.");
            g();
        }
        Log.i("Camera2PresenceSrc", "Starting system availability monitoring.");
        sx sxVar = new sx(this);
        this.y0 = sxVar;
        pz pzVar = (pz) this.Z;
        pzVar.a.I(this.b, sxVar);
        fx3.m(new rm1(b(), 1));
    }

    @Override // defpackage.eu2
    public void f(du2 du2Var) {
        c0 c0Var;
        Iterator it = ((CopyOnWriteArrayList) this.A).iterator();
        while (true) {
            if (!it.hasNext()) {
                c0Var = null;
                break;
            } else {
                c0Var = (c0) it.next();
                if (c0Var.b.equals(du2Var)) {
                    break;
                }
            }
        }
        if (c0Var != null) {
            ((CopyOnWriteArrayList) this.A).remove(c0Var);
        }
        synchronized (this.z) {
            try {
                if (this.f && ((CopyOnWriteArrayList) this.A).isEmpty()) {
                    Log.i("CameraPresenceSrc", "Last observer removed. Stopping monitoring.");
                    this.f = false;
                    g();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void g() {
        Log.i("Camera2PresenceSrc", "Stopping system availability monitoring.");
        sx sxVar = (sx) this.y0;
        if (sxVar != null) {
            try {
                ((pz) this.Z).a.R(sxVar);
            } catch (Exception e) {
                a1.o("Camera2PresenceSrc", "Failed to unregister system availability callback.", e);
            } finally {
                this.y0 = null;
            }
        }
    }

    public void h(ArrayList arrayList, e00 e00Var) {
        int i;
        List list;
        boolean z;
        List listUnmodifiableList;
        Throwable th;
        synchronized (this.z) {
            i = 0;
            try {
                if (e00Var != null) {
                    z = ((Throwable) this.Y) == null || !((List) this.X).isEmpty();
                    this.Y = e00Var;
                    list = Collections.EMPTY_LIST;
                    this.X = list;
                } else {
                    arrayList.getClass();
                    boolean z2 = (((Throwable) this.Y) == null && ((List) this.X).equals(arrayList)) ? false : true;
                    this.Y = null;
                    this.X = arrayList;
                    boolean z3 = z2;
                    list = arrayList;
                    z = z3;
                }
                listUnmodifiableList = DesugarCollections.unmodifiableList(list);
                th = (Throwable) this.Y;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z) {
            StringBuilder sb = new StringBuilder("Data changed. Notifying ");
            sb.append(((CopyOnWriteArrayList) this.A).size());
            sb.append(" observers. Error: ");
            sb.append(th != null);
            Log.d("CameraPresenceSrc", sb.toString());
            for (c0 c0Var : (CopyOnWriteArrayList) this.A) {
                c0Var.a.execute(new b0(i, th, c0Var, listUnmodifiableList));
            }
        }
    }

    public tx(AssetManager assetManager, Executor executor, a73 a73Var, String str, File file) {
        this.f = false;
        this.b = executor;
        this.z = a73Var;
        this.Y = str;
        this.X = file;
        int i = Build.VERSION.SDK_INT;
        byte[] bArr = null;
        if (i >= 24) {
            if (i >= 31) {
                bArr = ek0.e;
            } else {
                switch (i) {
                    case 24:
                    case 25:
                        bArr = ek0.i;
                        break;
                    case 26:
                        bArr = ek0.h;
                        break;
                    case 27:
                        bArr = ek0.g;
                        break;
                    case 28:
                    case 29:
                    case 30:
                        bArr = ek0.f;
                        break;
                }
            }
        }
        this.A = bArr;
    }
}
