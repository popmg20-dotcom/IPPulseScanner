package defpackage;

import android.R;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.p;
import io.sentry.android.core.a1;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ca extends p implements ea {
    public za R0;

    public ca() {
        this.A.b.c("androidx:appcompat", new aa(this));
        r(new ba(this));
    }

    @Override // android.app.Activity
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        s();
        za zaVar = (za) w();
        zaVar.z();
        ((ViewGroup) zaVar.Q0.findViewById(R.id.content)).addView(view, layoutParams);
        zaVar.D0.a(zaVar.C0.getCallback());
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x01b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004b  */
    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void attachBaseContext(android.content.Context r11) {
        /*
            Method dump skipped, instruction units count: 457
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ca.attachBaseContext(android.content.Context):void");
    }

    @Override // android.app.Activity
    public final void closeOptionsMenu() {
        za zaVar = (za) w();
        zaVar.E();
        tj4 tj4Var = zaVar.E0;
        if (getWindow().hasFeature(0)) {
            if (tj4Var == null || !tj4Var.p()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // defpackage.h90, android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        za zaVar = (za) w();
        zaVar.E();
        tj4 tj4Var = zaVar.E0;
        if (keyCode == 82 && tj4Var != null && tj4Var.T(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public final View findViewById(int i) {
        za zaVar = (za) w();
        zaVar.z();
        return zaVar.C0.findViewById(i);
    }

    @Override // android.app.Activity
    public final MenuInflater getMenuInflater() {
        za zaVar = (za) w();
        a64 a64Var = zaVar.F0;
        if (a64Var == null) {
            zaVar.E();
            tj4 tj4Var = zaVar.E0;
            a64Var = new a64(tj4Var != null ? tj4Var.F() : zaVar.B0);
            zaVar.F0 = a64Var;
        }
        return a64Var;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        int i = ro4.a;
        return super.getResources();
    }

    @Override // android.app.Activity
    public final void invalidateOptionsMenu() {
        w().d();
    }

    @Override // defpackage.i90, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        za zaVar = (za) w();
        if (zaVar.V0 && zaVar.P0) {
            zaVar.E();
            tj4 tj4Var = zaVar.E0;
            if (tj4Var != null) {
                tj4Var.Q();
            }
        }
        db dbVarA = db.a();
        Context context = zaVar.B0;
        synchronized (dbVarA) {
            dbVarA.a.l(context);
        }
        zaVar.h1 = new Configuration(zaVar.B0.getResources().getConfiguration());
        zaVar.q(false, false);
    }

    @Override // androidx.fragment.app.p, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        w().g();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        Window window;
        if (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // androidx.fragment.app.p, defpackage.i90, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        Intent intentU;
        if (!super.onMenuItemSelected(i, menuItem)) {
            za zaVar = (za) w();
            zaVar.E();
            tj4 tj4Var = zaVar.E0;
            if (menuItem.getItemId() != 16908332 || tj4Var == null || (tj4Var.C() & 4) == 0 || (intentU = uf2.u(this)) == null) {
                return false;
            }
            if (!shouldUpRecreateTask(intentU)) {
                navigateUpTo(intentU);
                return true;
            }
            ArrayList arrayList = new ArrayList();
            Intent intentU2 = uf2.u(this);
            if (intentU2 == null) {
                intentU2 = uf2.u(this);
            }
            if (intentU2 != null) {
                ComponentName component = intentU2.getComponent();
                if (component == null) {
                    component = intentU2.resolveActivity(getPackageManager());
                }
                int size = arrayList.size();
                try {
                    Intent intentV = uf2.v(this, component);
                    while (intentV != null) {
                        arrayList.add(size, intentV);
                        intentV = uf2.v(this, intentV.getComponent());
                    }
                    arrayList.add(intentU2);
                } catch (PackageManager.NameNotFoundException e) {
                    a1.d("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                    throw new IllegalArgumentException(e);
                }
            }
            if (arrayList.isEmpty()) {
                xe.q("No intents added to TaskStackBuilder; cannot startActivities");
                return false;
            }
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[0]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            startActivities(intentArr, null);
            try {
                finishAffinity();
            } catch (IllegalStateException unused) {
                finish();
            }
        }
        return true;
    }

    @Override // android.app.Activity
    public final void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ((za) w()).z();
    }

    @Override // androidx.fragment.app.p, android.app.Activity
    public final void onPostResume() {
        super.onPostResume();
        za zaVar = (za) w();
        zaVar.E();
        tj4 tj4Var = zaVar.E0;
        if (tj4Var != null) {
            tj4Var.b0(true);
        }
    }

    @Override // androidx.fragment.app.p, android.app.Activity
    public final void onStart() {
        super.onStart();
        ((za) w()).q(true, false);
    }

    @Override // androidx.fragment.app.p, android.app.Activity
    public final void onStop() {
        super.onStop();
        za zaVar = (za) w();
        zaVar.E();
        tj4 tj4Var = zaVar.E0;
        if (tj4Var != null) {
            tj4Var.b0(false);
        }
    }

    @Override // android.app.Activity
    public final void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        w().o(charSequence);
    }

    @Override // android.app.Activity
    public final void openOptionsMenu() {
        za zaVar = (za) w();
        zaVar.E();
        tj4 tj4Var = zaVar.E0;
        if (getWindow().hasFeature(0)) {
            if (tj4Var == null || !tj4Var.U()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // android.app.Activity
    public final void setContentView(int i) {
        s();
        w().k(i);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        super.setTheme(i);
        ((za) w()).j1 = i;
    }

    public final ma w() {
        za zaVar = this.R0;
        if (zaVar != null) {
            return zaVar;
        }
        la laVar = ma.b;
        za zaVar2 = new za(this, null, this, this);
        this.R0 = zaVar2;
        return zaVar2;
    }

    @Override // defpackage.i90, android.app.Activity
    public void setContentView(View view) {
        s();
        w().l(view);
    }

    @Override // android.app.Activity
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        s();
        w().m(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onContentChanged() {
    }
}
