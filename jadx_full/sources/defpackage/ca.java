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
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.p;
import io.sentry.android.core.a1;
import j$.util.Objects;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
    */
    public final void attachBaseContext(Context context) {
        Configuration configuration;
        Method method;
        za zaVar = (za) w();
        zaVar.e1 = true;
        int i = zaVar.i1;
        if (i == -100) {
            i = ma.f;
        }
        int iG = zaVar.G(context, i);
        if (ma.e(context)) {
            ma.p(context);
        }
        rd2 rd2VarS = za.s(context);
        if (context instanceof ContextThemeWrapper) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(za.w(context, iG, rd2VarS, null, false));
            } catch (IllegalStateException unused) {
                if (!(context instanceof de0)) {
                }
            }
        } else if (!(context instanceof de0)) {
            try {
                ((de0) context).a(za.w(context, iG, rd2VarS, null, false));
            } catch (IllegalStateException unused2) {
                if (za.z1) {
                }
            }
        } else if (za.z1) {
            Configuration configuration2 = new Configuration();
            configuration2.uiMode = -1;
            configuration2.fontScale = 0.0f;
            Configuration configuration3 = context.createConfigurationContext(configuration2).getResources().getConfiguration();
            Configuration configuration4 = context.getResources().getConfiguration();
            configuration3.uiMode = configuration4.uiMode;
            if (configuration3.equals(configuration4)) {
                configuration = null;
            } else {
                configuration = new Configuration();
                configuration.fontScale = 0.0f;
                if (configuration3.diff(configuration4) != 0) {
                    float f = configuration3.fontScale;
                    float f2 = configuration4.fontScale;
                    if (f != f2) {
                        configuration.fontScale = f2;
                    }
                    int i2 = configuration3.mcc;
                    int i3 = configuration4.mcc;
                    if (i2 != i3) {
                        configuration.mcc = i3;
                    }
                    int i4 = configuration3.mnc;
                    int i5 = configuration4.mnc;
                    if (i4 != i5) {
                        configuration.mnc = i5;
                    }
                    int i6 = Build.VERSION.SDK_INT;
                    if (i6 >= 24) {
                        ra.a(configuration3, configuration4, configuration);
                    } else if (!Objects.equals(configuration3.locale, configuration4.locale)) {
                        configuration.locale = configuration4.locale;
                    }
                    int i7 = configuration3.touchscreen;
                    int i8 = configuration4.touchscreen;
                    if (i7 != i8) {
                        configuration.touchscreen = i8;
                    }
                    int i9 = configuration3.keyboard;
                    int i10 = configuration4.keyboard;
                    if (i9 != i10) {
                        configuration.keyboard = i10;
                    }
                    int i11 = configuration3.keyboardHidden;
                    int i12 = configuration4.keyboardHidden;
                    if (i11 != i12) {
                        configuration.keyboardHidden = i12;
                    }
                    int i13 = configuration3.navigation;
                    int i14 = configuration4.navigation;
                    if (i13 != i14) {
                        configuration.navigation = i14;
                    }
                    int i15 = configuration3.navigationHidden;
                    int i16 = configuration4.navigationHidden;
                    if (i15 != i16) {
                        configuration.navigationHidden = i16;
                    }
                    int i17 = configuration3.orientation;
                    int i18 = configuration4.orientation;
                    if (i17 != i18) {
                        configuration.orientation = i18;
                    }
                    int i19 = configuration3.screenLayout & 15;
                    int i20 = configuration4.screenLayout & 15;
                    if (i19 != i20) {
                        configuration.screenLayout |= i20;
                    }
                    int i21 = configuration3.screenLayout & 192;
                    int i22 = configuration4.screenLayout & 192;
                    if (i21 != i22) {
                        configuration.screenLayout |= i22;
                    }
                    int i23 = configuration3.screenLayout & 48;
                    int i24 = configuration4.screenLayout & 48;
                    if (i23 != i24) {
                        configuration.screenLayout |= i24;
                    }
                    int i25 = configuration3.screenLayout & 768;
                    int i26 = configuration4.screenLayout & 768;
                    if (i25 != i26) {
                        configuration.screenLayout |= i26;
                    }
                    if (i6 >= 26) {
                        v02.f(configuration3, configuration4, configuration);
                    }
                    int i27 = configuration3.uiMode & 15;
                    int i28 = configuration4.uiMode & 15;
                    if (i27 != i28) {
                        configuration.uiMode |= i28;
                    }
                    int i29 = configuration3.uiMode & 48;
                    int i30 = configuration4.uiMode & 48;
                    if (i29 != i30) {
                        configuration.uiMode |= i30;
                    }
                    int i31 = configuration3.screenWidthDp;
                    int i32 = configuration4.screenWidthDp;
                    if (i31 != i32) {
                        configuration.screenWidthDp = i32;
                    }
                    int i33 = configuration3.screenHeightDp;
                    int i34 = configuration4.screenHeightDp;
                    if (i33 != i34) {
                        configuration.screenHeightDp = i34;
                    }
                    int i35 = configuration3.smallestScreenWidthDp;
                    int i36 = configuration4.smallestScreenWidthDp;
                    if (i35 != i36) {
                        configuration.smallestScreenWidthDp = i36;
                    }
                    int i37 = configuration3.densityDpi;
                    int i38 = configuration4.densityDpi;
                    if (i37 != i38) {
                        configuration.densityDpi = i38;
                    }
                }
            }
            Configuration configurationW = za.w(context, iG, rd2VarS, configuration, true);
            de0 de0Var = new de0(context, com.getsurfboard.R.style.Theme_AppCompat_Empty);
            de0Var.a(configurationW);
            try {
                if (context.getTheme() != null) {
                    Resources.Theme theme = de0Var.getTheme();
                    if (Build.VERSION.SDK_INT >= 29) {
                        v9.p(theme);
                    } else {
                        synchronized (uf2.Z) {
                            if (uf2.z0) {
                                method = uf2.y0;
                                if (method != null) {
                                }
                            } else {
                                try {
                                    Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", null);
                                    uf2.y0 = declaredMethod;
                                    declaredMethod.setAccessible(true);
                                } catch (NoSuchMethodException e) {
                                    Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e);
                                }
                                uf2.z0 = true;
                                method = uf2.y0;
                                if (method != null) {
                                    try {
                                        method.invoke(theme, null);
                                    } catch (IllegalAccessException | InvocationTargetException e2) {
                                        Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e2);
                                        uf2.y0 = null;
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (NullPointerException unused3) {
            }
            context = de0Var;
        }
        super.attachBaseContext(context);
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
