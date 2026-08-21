package defpackage;

import android.app.Application;
import android.app.PictureInPictureUiState;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.window.OnBackInvokedDispatcher;
import androidx.fragment.app.p;
import com.getsurfboard.R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class i90 extends h90 implements pq4, er1, kp3, xu2, y4, yu2, mv2, fv2, gv2, qk2 {
    public final ip3 A;
    public final CopyOnWriteArrayList A0;
    public final CopyOnWriteArrayList B0;
    public final CopyOnWriteArrayList C0;
    public final CopyOnWriteArrayList D0;
    public final CopyOnWriteArrayList E0;
    public final CopyOnWriteArrayList F0;
    public final CopyOnWriteArrayList G0;
    public boolean H0;
    public boolean I0;
    public final n84 J0;
    public final n84 K0;
    public final n84 L0;
    public oq4 X;
    public final f90 Y;
    public final n84 Z;
    public final ae0 f = new ae0();
    public final AtomicInteger y0;
    public final n02 z;
    public final g90 z0;

    public i90() {
        p pVar = (p) this;
        int i = 0;
        this.z = new n02(new y80(pVar, i));
        jp3 jp3Var = new jp3(this, new fn(22, this));
        ip3 ip3Var = new ip3(jp3Var);
        this.A = ip3Var;
        this.Y = new f90(pVar);
        int i2 = 1;
        this.Z = new n84(new z80(pVar, 1));
        this.y0 = new AtomicInteger();
        this.z0 = new g90(pVar);
        this.A0 = new CopyOnWriteArrayList();
        this.B0 = new CopyOnWriteArrayList();
        this.C0 = new CopyOnWriteArrayList();
        this.D0 = new CopyOnWriteArrayList();
        this.E0 = new CopyOnWriteArrayList();
        this.F0 = new CopyOnWriteArrayList();
        this.G0 = new CopyOnWriteArrayList();
        this.J0 = new n84(new z80(pVar, 2));
        fa2 fa2Var = this.b;
        if (fa2Var == null) {
            xe.q("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
            throw null;
        }
        fa2Var.a(new b90(i, pVar));
        this.b.a(new b90(i2, pVar));
        this.b.a(new nf3(i2, pVar));
        jp3Var.a();
        cp3.b(this);
        if (Build.VERSION.SDK_INT == 23) {
            this.b.a(new xy1(pVar));
        }
        ip3Var.b.c("android:support:activity-result", new c90(i, pVar));
        r(new d90(pVar, i));
        this.K0 = new n84(new z80(pVar, 3));
        this.L0 = new n84(new z80(pVar, 4));
    }

    public static final void q(wu2 wu2Var, i90 i90Var, da2 da2Var, p92 p92Var) {
        if (p92Var == p92.ON_CREATE) {
            OnBackInvokedDispatcher onBackInvokedDispatcher = i90Var.getOnBackInvokedDispatcher();
            onBackInvokedDispatcher.getClass();
            wu2Var.e(onBackInvokedDispatcher);
        }
    }

    public static final void t(p pVar) {
        try {
            super.onBackPressed();
        } catch (IllegalStateException e) {
            if (!n12.c(e.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                throw e;
            }
        } catch (NullPointerException e2) {
            if (!n12.c(e2.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                throw e2;
            }
        }
    }

    @Override // defpackage.xu2
    public final wu2 b() {
        return (wu2) this.L0.getValue();
    }

    @Override // defpackage.gv2
    public final void c(dd0 dd0Var) {
        dd0Var.getClass();
        this.E0.add(dd0Var);
    }

    @Override // defpackage.fv2
    public final void d(dd0 dd0Var) {
        dd0Var.getClass();
        this.D0.add(dd0Var);
    }

    @Override // defpackage.mv2
    public final void f(dd0 dd0Var) {
        dd0Var.getClass();
        this.B0.add(dd0Var);
    }

    @Override // defpackage.y4
    public final x4 g() {
        return this.z0;
    }

    @Override // defpackage.er1
    public final dg0 getDefaultViewModelCreationExtras() {
        in2 in2Var = new in2(0);
        Application application = getApplication();
        LinkedHashMap linkedHashMap = in2Var.a;
        if (application != null) {
            linkedHashMap.put(lq4.e, getApplication());
        }
        linkedHashMap.put(cp3.a, this);
        linkedHashMap.put(cp3.b, this);
        Intent intent = getIntent();
        Bundle extras = intent != null ? intent.getExtras() : null;
        if (extras != null) {
            linkedHashMap.put(cp3.c, extras);
        }
        return in2Var;
    }

    @Override // defpackage.da2
    public final r92 getLifecycle() {
        return this.b;
    }

    @Override // defpackage.kp3
    public final hp3 getSavedStateRegistry() {
        return this.A.b;
    }

    @Override // defpackage.pq4
    public final oq4 getViewModelStore() {
        if (getApplication() == null) {
            xe.q("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
            return null;
        }
        oq4 oq4Var = this.X;
        if (oq4Var == null) {
            e90 e90Var = (e90) getLastNonConfigurationInstance();
            if (e90Var != null) {
                this.X = e90Var.a;
            }
            oq4Var = this.X;
            if (oq4Var == null) {
                oq4Var = new oq4();
                this.X = oq4Var;
            }
        }
        oq4Var.getClass();
        return oq4Var;
    }

    @Override // defpackage.mv2
    public final void h(dd0 dd0Var) {
        dd0Var.getClass();
        this.B0.remove(dd0Var);
    }

    @Override // defpackage.qk2
    public final void j(sj1 sj1Var) {
        sj1Var.getClass();
        n02 n02Var = this.z;
        ((CopyOnWriteArrayList) n02Var.z).remove(sj1Var);
        if (((HashMap) n02Var.A).remove(sj1Var) == null) {
            ((Runnable) n02Var.f).run();
        } else {
            st4.n();
        }
    }

    @Override // defpackage.yu2
    public final void l(dd0 dd0Var) {
        dd0Var.getClass();
        this.A0.add(dd0Var);
    }

    @Override // defpackage.yu2
    public final void m(dd0 dd0Var) {
        dd0Var.getClass();
        this.A0.remove(dd0Var);
    }

    @Override // defpackage.qk2
    public final void n(sj1 sj1Var) {
        sj1Var.getClass();
        n02 n02Var = this.z;
        ((CopyOnWriteArrayList) n02Var.z).add(sj1Var);
        ((Runnable) n02Var.f).run();
    }

    @Override // defpackage.gv2
    public final void o(dd0 dd0Var) {
        dd0Var.getClass();
        this.E0.remove(dd0Var);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.z0.a(i, i2, intent)) {
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        ((zu0) this.J0.getValue()).a();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        configuration.getClass();
        super.onConfigurationChanged(configuration);
        Iterator it = this.A0.iterator();
        it.getClass();
        while (it.hasNext()) {
            ((dd0) it.next()).accept(configuration);
        }
    }

    @Override // defpackage.h90, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.A.a(bundle);
        ae0 ae0Var = this.f;
        ae0Var.getClass();
        ae0Var.a = this;
        Iterator it = ((CopyOnWriteArraySet) ae0Var.b).iterator();
        while (it.hasNext()) {
            ((av2) it.next()).a(this);
        }
        super.onCreate(bundle);
        int i = wi3.f;
        ui3.b(this);
        getPackageManager().hasSystemFeature("android.software.picture_in_picture");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i, Menu menu) {
        menu.getClass();
        if (i != 0) {
            return true;
        }
        super.onCreatePanelMenu(i, menu);
        MenuInflater menuInflater = getMenuInflater();
        Iterator it = ((CopyOnWriteArrayList) this.z.z).iterator();
        while (it.hasNext()) {
            ((sj1) it.next()).a.k(menu, menuInflater);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        menuItem.getClass();
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            Iterator it = ((CopyOnWriteArrayList) this.z.z).iterator();
            while (it.hasNext()) {
                if (((sj1) it.next()).a.p(menuItem)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.app.Activity
    public final void onMultiWindowModeChanged(boolean z, Configuration configuration) {
        configuration.getClass();
        this.H0 = true;
        try {
            super.onMultiWindowModeChanged(z, configuration);
            this.H0 = false;
            Iterator it = this.D0.iterator();
            it.getClass();
            while (it.hasNext()) {
                ((dd0) it.next()).accept(new dn2(z));
            }
        } catch (Throwable th) {
            this.H0 = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        intent.getClass();
        super.onNewIntent(intent);
        Iterator it = this.C0.iterator();
        it.getClass();
        while (it.hasNext()) {
            ((dd0) it.next()).accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        menu.getClass();
        Iterator it = ((CopyOnWriteArrayList) this.z.z).iterator();
        while (it.hasNext()) {
            ((sj1) it.next()).a.q(menu);
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        configuration.getClass();
        this.I0 = true;
        try {
            super.onPictureInPictureModeChanged(z, configuration);
            this.I0 = false;
            Iterator it = this.E0.iterator();
            it.getClass();
            while (it.hasNext()) {
                ((dd0) it.next()).accept(new f13(z));
            }
        } catch (Throwable th) {
            this.I0 = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public final void onPictureInPictureUiStateChanged(PictureInPictureUiState pictureInPictureUiState) {
        pictureInPictureUiState.getClass();
        super.onPictureInPictureUiStateChanged(pictureInPictureUiState);
        vd3 vd3VarA = tq2.a(pictureInPictureUiState);
        Iterator it = this.F0.iterator();
        it.getClass();
        while (it.hasNext()) {
            ((dd0) it.next()).accept(vd3VarA);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onPreparePanel(int i, View view, Menu menu) {
        menu.getClass();
        if (i != 0) {
            return true;
        }
        super.onPreparePanel(i, view, menu);
        Iterator it = ((CopyOnWriteArrayList) this.z.z).iterator();
        while (it.hasNext()) {
            ((sj1) it.next()).a.t(menu);
        }
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        strArr.getClass();
        iArr.getClass();
        if (this.z0.a(i, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            return;
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        e90 e90Var;
        oq4 oq4Var = this.X;
        if (oq4Var == null && (e90Var = (e90) getLastNonConfigurationInstance()) != null) {
            oq4Var = e90Var.a;
        }
        if (oq4Var == null) {
            return null;
        }
        e90 e90Var2 = new e90();
        e90Var2.a = oq4Var;
        return e90Var2;
    }

    @Override // defpackage.h90, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.getClass();
        fa2 fa2Var = this.b;
        if (fa2Var != null) {
            fa2Var.getClass();
            fa2Var.e("setCurrentState");
            fa2Var.g(q92.z);
        }
        super.onSaveInstanceState(bundle);
        this.A.b(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        super.onTrimMemory(i);
        Iterator it = this.B0.iterator();
        it.getClass();
        while (it.hasNext()) {
            ((dd0) it.next()).accept(Integer.valueOf(i));
        }
    }

    @Override // android.app.Activity
    public final void onUserLeaveHint() {
        super.onUserLeaveHint();
        Iterator it = this.G0.iterator();
        it.getClass();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    @Override // defpackage.fv2
    public final void p(dd0 dd0Var) {
        dd0Var.getClass();
        this.D0.remove(dd0Var);
    }

    public final void r(av2 av2Var) {
        ae0 ae0Var = this.f;
        ae0Var.getClass();
        i90 i90Var = (i90) ae0Var.a;
        if (i90Var != null) {
            av2Var.a(i90Var);
        }
        ((CopyOnWriteArraySet) ae0Var.b).add(av2Var);
    }

    @Override // android.app.Activity
    public final void reportFullyDrawn() {
        try {
            if (vo.A()) {
                Trace.beginSection(vo.O("reportFullyDrawn() for ComponentActivity"));
            }
            super.reportFullyDrawn();
            ol1 ol1Var = (ol1) this.Z.getValue();
            synchronized (ol1Var.b) {
                try {
                    ol1Var.c = true;
                    Iterator it = ol1Var.d.iterator();
                    while (it.hasNext()) {
                        ((pl1) it.next()).a();
                    }
                    ol1Var.d.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
        } finally {
            Trace.endSection();
        }
    }

    public final void s() {
        View decorView = getWindow().getDecorView();
        decorView.getClass();
        decorView.setTag(R.id.view_tree_lifecycle_owner, this);
        View decorView2 = getWindow().getDecorView();
        decorView2.getClass();
        decorView2.setTag(R.id.view_tree_view_model_store_owner, this);
        View decorView3 = getWindow().getDecorView();
        decorView3.getClass();
        decorView3.setTag(R.id.view_tree_saved_state_registry_owner, this);
        View decorView4 = getWindow().getDecorView();
        decorView4.getClass();
        decorView4.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, this);
        View decorView5 = getWindow().getDecorView();
        decorView5.getClass();
        decorView5.setTag(R.id.report_drawn, this);
        View decorView6 = getWindow().getDecorView();
        decorView6.getClass();
        decorView6.setTag(R.id.view_tree_navigation_event_dispatcher_owner, this);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        s();
        View decorView = getWindow().getDecorView();
        decorView.getClass();
        f90 f90Var = this.Y;
        f90Var.getClass();
        if (!f90Var.z) {
            f90Var.z = true;
            decorView.getViewTreeObserver().addOnDrawListener(f90Var);
        }
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public final void startActivityForResult(Intent intent, int i) {
        intent.getClass();
        super.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    public final void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        intentSender.getClass();
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Override // android.app.Activity
    public final void startActivityForResult(Intent intent, int i, Bundle bundle) {
        intent.getClass();
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    public final void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        intentSender.getClass();
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    @Override // android.app.Activity
    public final void onMultiWindowModeChanged(boolean z) {
        if (this.H0) {
            return;
        }
        Iterator it = this.D0.iterator();
        it.getClass();
        while (it.hasNext()) {
            ((dd0) it.next()).accept(new dn2(z));
        }
    }

    @Override // android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z) {
        if (this.I0) {
            return;
        }
        Iterator it = this.E0.iterator();
        it.getClass();
        while (it.hasNext()) {
            ((dd0) it.next()).accept(new f13(z));
        }
    }
}
