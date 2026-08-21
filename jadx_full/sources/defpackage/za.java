package defpackage;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.view.menu.ExpandedMenuView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.HttpConstants;
import io.sentry.android.core.a1;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.WeakHashMap;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class za extends ma implements lk2, LayoutInflater.Factory2 {
    public static final xw3 x1 = new xw3(0);
    public static final int[] y1 = {R.attr.windowBackground};
    public static final boolean z1 = !"robolectric".equals(Build.FINGERPRINT);
    public final Object A0;
    public final Context B0;
    public Window C0;
    public ua D0;
    public tj4 E0;
    public a64 F0;
    public CharSequence G0;
    public ActionBarOverlayLayout H0;
    public zf2 I0;
    public oa J0;
    public u3 K0;
    public ActionBarContextView L0;
    public PopupWindow M0;
    public na N0;
    public boolean P0;
    public ViewGroup Q0;
    public TextView R0;
    public View S0;
    public boolean T0;
    public boolean U0;
    public boolean V0;
    public boolean W0;
    public boolean X0;
    public boolean Y0;
    public boolean Z0;
    public boolean a1;
    public ya[] b1;
    public ya c1;
    public boolean d1;
    public boolean e1;
    public boolean f1;
    public boolean g1;
    public Configuration h1;
    public final int i1;
    public int j1;
    public int k1;
    public boolean l1;
    public va m1;
    public va n1;
    public boolean o1;
    public int p1;
    public boolean r1;
    public Rect s1;
    public Rect t1;
    public uc u1;
    public OnBackInvokedDispatcher v1;
    public OnBackInvokedCallback w1;
    public cr4 O0 = null;
    public final na q1 = new na(this, 0);

    public za(Context context, Window window, ea eaVar, Object obj) {
        ca caVar = null;
        this.i1 = -100;
        this.B0 = context;
        this.A0 = obj;
        if (obj instanceof Dialog) {
            while (true) {
                if (context != null) {
                    if (!(context instanceof ca)) {
                        if (!(context instanceof ContextWrapper)) {
                            break;
                        } else {
                            context = ((ContextWrapper) context).getBaseContext();
                        }
                    } else {
                        caVar = (ca) context;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (caVar != null) {
                this.i1 = ((za) caVar.w()).i1;
            }
        }
        if (this.i1 == -100) {
            String name = this.A0.getClass().getName();
            xw3 xw3Var = x1;
            Integer num = (Integer) xw3Var.get(name);
            if (num != null) {
                this.i1 = num.intValue();
                xw3Var.remove(this.A0.getClass().getName());
            }
        }
        if (window != null) {
            r(window);
        }
        db.d();
    }

    public static rd2 C(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? ra.b(configuration) : rd2.b(qa.b(configuration.locale));
    }

    public static rd2 s(Context context) {
        rd2 rd2Var;
        rd2 rd2VarB;
        int i = Build.VERSION.SDK_INT;
        if (i >= 33 || (rd2Var = ma.z) == null) {
            return null;
        }
        td2 td2Var = rd2Var.a;
        rd2 rd2VarC = C(context.getApplicationContext().getResources().getConfiguration());
        int i2 = 0;
        if (i < 24) {
            rd2VarB = td2Var.isEmpty() ? rd2.b : rd2.b(qa.b(td2Var.get(0)));
        } else if (td2Var.isEmpty()) {
            rd2VarB = rd2.b;
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (i2 < rd2VarC.a.size() + td2Var.size()) {
                Locale locale = i2 < td2Var.size() ? td2Var.get(i2) : rd2VarC.a.get(i2 - td2Var.size());
                if (locale != null) {
                    linkedHashSet.add(locale);
                }
                i2++;
            }
            rd2VarB = rd2.a((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
        }
        return rd2VarB.a.isEmpty() ? rd2VarC : rd2VarB;
    }

    public static Configuration w(Context context, int i, rd2 rd2Var, Configuration configuration, boolean z) {
        int i2 = i != 1 ? i != 2 ? z ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i2 | (configuration2.uiMode & (-49));
        if (rd2Var != null) {
            td2 td2Var = rd2Var.a;
            if (Build.VERSION.SDK_INT >= 24) {
                ra.d(configuration2, rd2Var);
                return configuration2;
            }
            configuration2.setLocale(td2Var.get(0));
            configuration2.setLayoutDirection(td2Var.get(0));
        }
        return configuration2;
    }

    public final void A() {
        if (this.C0 == null) {
            Object obj = this.A0;
            if (obj instanceof Activity) {
                r(((Activity) obj).getWindow());
            }
        }
        if (this.C0 != null) {
            return;
        }
        xe.q("We have not been given a Window");
    }

    public final m0 B(Context context) {
        va vaVar = this.m1;
        if (vaVar == null) {
            n02 n02Var = n02.X;
            if (n02Var == null) {
                Context applicationContext = context.getApplicationContext();
                n02Var = new n02(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
                n02.X = n02Var;
            }
            vaVar = new va(this, n02Var);
            this.m1 = vaVar;
        }
        return vaVar;
    }

    public final ya D(int i) {
        ya[] yaVarArr = this.b1;
        if (yaVarArr == null || yaVarArr.length <= i) {
            ya[] yaVarArr2 = new ya[i + 1];
            if (yaVarArr != null) {
                System.arraycopy(yaVarArr, 0, yaVarArr2, 0, yaVarArr.length);
            }
            this.b1 = yaVarArr2;
            yaVarArr = yaVarArr2;
        }
        ya yaVar = yaVarArr[i];
        if (yaVar != null) {
            return yaVar;
        }
        ya yaVar2 = new ya();
        yaVar2.a = i;
        yaVar2.n = false;
        yaVarArr[i] = yaVar2;
        return yaVar2;
    }

    public final void E() {
        tj4 vt4Var;
        z();
        if (this.V0 && (vt4Var = this.E0) == null) {
            Object obj = this.A0;
            if (obj instanceof Activity) {
                vt4Var = new vt4((Activity) obj, this.W0);
                this.E0 = vt4Var;
            } else if (obj instanceof Dialog) {
                vt4Var = new vt4((Dialog) obj);
                this.E0 = vt4Var;
            }
            if (vt4Var != null) {
                vt4Var.Z(this.r1);
            }
        }
    }

    public final void F(int i) {
        this.p1 = (1 << i) | this.p1;
        if (this.o1) {
            return;
        }
        View decorView = this.C0.getDecorView();
        WeakHashMap weakHashMap = wp4.a;
        decorView.postOnAnimation(this.q1);
        this.o1 = true;
    }

    public final int G(Context context, int i) {
        if (i != -100) {
            if (i != -1) {
                if (i != 0) {
                    if (i != 1 && i != 2) {
                        if (i != 3) {
                            xe.q("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                            return 0;
                        }
                        va vaVar = this.n1;
                        if (vaVar == null) {
                            vaVar = new va(this, context);
                            this.n1 = vaVar;
                        }
                        return vaVar.j();
                    }
                } else if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) {
                    return B(context).j();
                }
            }
            return i;
        }
        return -1;
    }

    public final boolean H() {
        boolean z = this.d1;
        this.d1 = false;
        ya yaVarD = D(0);
        if (!yaVarD.m) {
            u3 u3Var = this.K0;
            if (u3Var != null) {
                u3Var.a();
                return true;
            }
            E();
            tj4 tj4Var = this.E0;
            if (tj4Var == null || !tj4Var.q()) {
                return false;
            }
        } else if (!z) {
            v(yaVarD, true);
            return true;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x016f, code lost:
    
        if (r6.getCount() > 0) goto L88;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void I(ya yaVar, KeyEvent keyEvent) {
        int i;
        ViewGroup.LayoutParams layoutParams;
        boolean z = yaVar.m;
        int i2 = yaVar.a;
        if (z || this.g1) {
            return;
        }
        Context context = this.B0;
        if (i2 == 0 && (context.getResources().getConfiguration().screenLayout & 15) == 4) {
            return;
        }
        Window.Callback callback = this.C0.getCallback();
        if (callback != null && !callback.onMenuOpened(i2, yaVar.h)) {
            v(yaVar, true);
            return;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null || !K(yaVar, keyEvent)) {
            return;
        }
        xa xaVar = yaVar.e;
        if (xaVar != null && !yaVar.n) {
            View view = yaVar.g;
            if (view != null && (layoutParams = view.getLayoutParams()) != null && layoutParams.width == -1) {
                i = -1;
            }
            yaVar.l = false;
            WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(i, -2, 0, 0, 1002, 8519680, -3);
            layoutParams2.gravity = yaVar.c;
            layoutParams2.windowAnimations = yaVar.d;
            windowManager.addView(yaVar.e, layoutParams2);
            yaVar.m = true;
            if (i2 != 0) {
                M();
                return;
            }
            return;
        }
        if (xaVar == null) {
            E();
            tj4 tj4Var = this.E0;
            Context contextF = tj4Var != null ? tj4Var.F() : null;
            if (contextF != null) {
                context = contextF;
            }
            TypedValue typedValue = new TypedValue();
            Resources.Theme themeNewTheme = context.getResources().newTheme();
            themeNewTheme.setTo(context.getTheme());
            themeNewTheme.resolveAttribute(com.getsurfboard.R.attr.actionBarPopupTheme, typedValue, true);
            int i3 = typedValue.resourceId;
            if (i3 != 0) {
                themeNewTheme.applyStyle(i3, true);
            }
            themeNewTheme.resolveAttribute(com.getsurfboard.R.attr.panelMenuListTheme, typedValue, true);
            int i4 = typedValue.resourceId;
            if (i4 != 0) {
                themeNewTheme.applyStyle(i4, true);
            } else {
                themeNewTheme.applyStyle(com.getsurfboard.R.style.Theme_AppCompat_CompactMenu, true);
            }
            de0 de0Var = new de0(context, 0);
            de0Var.getTheme().setTo(themeNewTheme);
            yaVar.j = de0Var;
            TypedArray typedArrayObtainStyledAttributes = de0Var.obtainStyledAttributes(cd3.j);
            yaVar.b = typedArrayObtainStyledAttributes.getResourceId(86, 0);
            yaVar.d = typedArrayObtainStyledAttributes.getResourceId(1, 0);
            typedArrayObtainStyledAttributes.recycle();
            yaVar.e = new xa(this, yaVar.j);
            yaVar.c = 81;
        } else if (yaVar.n && xaVar.getChildCount() > 0) {
            yaVar.e.removeAllViews();
        }
        View view2 = yaVar.g;
        if (view2 == null) {
            if (yaVar.h != null) {
                oa oaVar = this.J0;
                if (oaVar == null) {
                    oaVar = new oa(this);
                    this.J0 = oaVar;
                }
                if (yaVar.i == null) {
                    ac2 ac2Var = new ac2(yaVar.j);
                    yaVar.i = ac2Var;
                    ac2Var.X = oaVar;
                    nk2 nk2Var = yaVar.h;
                    nk2Var.b(ac2Var, nk2Var.a);
                }
                ac2 ac2Var2 = yaVar.i;
                xa xaVar2 = yaVar.e;
                if (ac2Var2.A == null) {
                    ac2Var2.A = (ExpandedMenuView) ac2Var2.f.inflate(com.getsurfboard.R.layout.abc_expanded_menu_layout, (ViewGroup) xaVar2, false);
                    zb2 zb2Var = ac2Var2.Y;
                    if (zb2Var == null) {
                        zb2Var = new zb2(ac2Var2);
                        ac2Var2.Y = zb2Var;
                    }
                    ac2Var2.A.setAdapter((ListAdapter) zb2Var);
                    ac2Var2.A.setOnItemClickListener(ac2Var2);
                }
                ExpandedMenuView expandedMenuView = ac2Var2.A;
                yaVar.f = expandedMenuView;
                if (expandedMenuView != null) {
                }
            }
            yaVar.n = true;
            return;
        }
        yaVar.f = view2;
        if (yaVar.f != null) {
            if (yaVar.g == null) {
                ac2 ac2Var3 = yaVar.i;
                zb2 zb2Var2 = ac2Var3.Y;
                if (zb2Var2 == null) {
                    zb2Var2 = new zb2(ac2Var3);
                    ac2Var3.Y = zb2Var2;
                }
            }
            ViewGroup.LayoutParams layoutParams3 = yaVar.f.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
            }
            yaVar.e.setBackgroundResource(yaVar.b);
            ViewParent parent = yaVar.f.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(yaVar.f);
            }
            yaVar.e.addView(yaVar.f, layoutParams3);
            if (!yaVar.f.hasFocus()) {
                yaVar.f.requestFocus();
            }
        }
        yaVar.n = true;
        return;
        i = -2;
        yaVar.l = false;
        WindowManager.LayoutParams layoutParams22 = new WindowManager.LayoutParams(i, -2, 0, 0, 1002, 8519680, -3);
        layoutParams22.gravity = yaVar.c;
        layoutParams22.windowAnimations = yaVar.d;
        windowManager.addView(yaVar.e, layoutParams22);
        yaVar.m = true;
        if (i2 != 0) {
        }
    }

    public final boolean J(ya yaVar, int i, KeyEvent keyEvent) {
        nk2 nk2Var;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((yaVar.k || K(yaVar, keyEvent)) && (nk2Var = yaVar.h) != null) {
            return nk2Var.performShortcut(i, keyEvent, 1);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00d6 A[PHI: r6
      0x00d6: PHI (r6v2 nk2) = (r6v1 nk2), (r6v8 nk2) binds: [B:34:0x0054, B:60:0x00d3] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean K(ya yaVar, KeyEvent keyEvent) {
        ActionBarOverlayLayout actionBarOverlayLayout;
        ActionBarOverlayLayout actionBarOverlayLayout2;
        Resources.Theme themeNewTheme;
        ActionBarOverlayLayout actionBarOverlayLayout3;
        ActionBarOverlayLayout actionBarOverlayLayout4;
        if (!this.g1) {
            boolean z = yaVar.k;
            int i = yaVar.a;
            if (z) {
                return true;
            }
            ya yaVar2 = this.c1;
            if (yaVar2 != null && yaVar2 != yaVar) {
                v(yaVar2, false);
            }
            Window.Callback callback = this.C0.getCallback();
            if (callback != null) {
                yaVar.g = callback.onCreatePanelView(i);
            }
            boolean z2 = i == 0 || i == 108;
            if (z2 && (actionBarOverlayLayout4 = this.H0) != null) {
                actionBarOverlayLayout4.k();
                ((mf4) actionBarOverlayLayout4.y0).l = true;
            }
            if (yaVar.g == null && (!z2 || !(this.E0 instanceof kf4))) {
                nk2 nk2Var = yaVar.h;
                if (nk2Var == null || yaVar.o) {
                    if (nk2Var == null) {
                        Context context = this.B0;
                        if ((i == 0 || i == 108) && this.H0 != null) {
                            TypedValue typedValue = new TypedValue();
                            Resources.Theme theme = context.getTheme();
                            theme.resolveAttribute(com.getsurfboard.R.attr.actionBarTheme, typedValue, true);
                            if (typedValue.resourceId != 0) {
                                themeNewTheme = context.getResources().newTheme();
                                themeNewTheme.setTo(theme);
                                themeNewTheme.applyStyle(typedValue.resourceId, true);
                                themeNewTheme.resolveAttribute(com.getsurfboard.R.attr.actionBarWidgetTheme, typedValue, true);
                            } else {
                                theme.resolveAttribute(com.getsurfboard.R.attr.actionBarWidgetTheme, typedValue, true);
                                themeNewTheme = null;
                            }
                            if (typedValue.resourceId != 0) {
                                if (themeNewTheme == null) {
                                    themeNewTheme = context.getResources().newTheme();
                                    themeNewTheme.setTo(theme);
                                }
                                themeNewTheme.applyStyle(typedValue.resourceId, true);
                            }
                            if (themeNewTheme != null) {
                                de0 de0Var = new de0(context, 0);
                                de0Var.getTheme().setTo(themeNewTheme);
                                context = de0Var;
                            }
                        }
                        nk2 nk2Var2 = new nk2(context);
                        nk2Var2.e = this;
                        nk2 nk2Var3 = yaVar.h;
                        if (nk2Var2 != nk2Var3) {
                            if (nk2Var3 != null) {
                                nk2Var3.t(yaVar.i);
                            }
                            yaVar.h = nk2Var2;
                            ac2 ac2Var = yaVar.i;
                            if (ac2Var != null) {
                                nk2Var2.b(ac2Var, nk2Var2.a);
                            }
                        }
                        nk2Var = yaVar.h;
                        if (nk2Var != null) {
                            if (z2 && (actionBarOverlayLayout2 = this.H0) != null) {
                                zf2 zf2Var = this.I0;
                                if (zf2Var == null) {
                                    zf2Var = new zf2(5, this);
                                    this.I0 = zf2Var;
                                }
                                actionBarOverlayLayout2.l(nk2Var, zf2Var);
                            }
                            yaVar.h.y();
                            if (callback.onCreatePanelMenu(i, yaVar.h)) {
                                yaVar.o = false;
                            } else {
                                nk2 nk2Var4 = yaVar.h;
                                if (nk2Var4 != null) {
                                    if (nk2Var4 != null) {
                                        nk2Var4.t(yaVar.i);
                                    }
                                    yaVar.h = null;
                                }
                                if (z2 && (actionBarOverlayLayout = this.H0) != null) {
                                    actionBarOverlayLayout.l(null, this.I0);
                                }
                            }
                        }
                    }
                }
                yaVar.h.y();
                Bundle bundle = yaVar.p;
                if (bundle != null) {
                    yaVar.h.u(bundle);
                    yaVar.p = null;
                }
                if (!callback.onPreparePanel(0, yaVar.g, yaVar.h)) {
                    if (z2 && (actionBarOverlayLayout3 = this.H0) != null) {
                        actionBarOverlayLayout3.l(null, this.I0);
                    }
                    yaVar.h.x();
                    return false;
                }
                yaVar.h.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
                yaVar.h.x();
            }
            yaVar.k = true;
            yaVar.l = false;
            this.c1 = yaVar;
            return true;
        }
        return false;
    }

    public final void L() {
        if (this.P0) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final void M() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean z = false;
            if (this.v1 != null && (D(0).m || this.K0 != null)) {
                z = true;
            }
            if (z && this.w1 == null) {
                this.w1 = ta.b(this.v1, this);
            } else {
                if (z || (onBackInvokedCallback = this.w1) == null) {
                    return;
                }
                ta.c(this.v1, onBackInvokedCallback);
                this.w1 = null;
            }
        }
    }

    @Override // defpackage.lk2
    public final boolean V(nk2 nk2Var, sk2 sk2Var) {
        ya yaVar;
        Window.Callback callback = this.C0.getCallback();
        if (callback != null && !this.g1) {
            nk2 nk2VarM = nk2Var.m();
            ya[] yaVarArr = this.b1;
            int length = yaVarArr != null ? yaVarArr.length : 0;
            int i = 0;
            while (true) {
                if (i < length) {
                    yaVar = yaVarArr[i];
                    if (yaVar != null && yaVar.h == nk2VarM) {
                        break;
                    }
                    i++;
                } else {
                    yaVar = null;
                    break;
                }
            }
            if (yaVar != null) {
                return callback.onMenuItemSelected(yaVar.a, sk2Var);
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0044, code lost:
    
        if (r6.k() != false) goto L20;
     */
    @Override // defpackage.lk2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a0(nk2 nk2Var) {
        ActionMenuView actionMenuView;
        q3 q3Var;
        ActionBarOverlayLayout actionBarOverlayLayout = this.H0;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.k();
            Toolbar toolbar = ((mf4) actionBarOverlayLayout.y0).a;
            if (toolbar.getVisibility() == 0 && (actionMenuView = toolbar.b) != null && actionMenuView.M0) {
                if (ViewConfiguration.get(this.B0).hasPermanentMenuKey()) {
                    ActionBarOverlayLayout actionBarOverlayLayout2 = this.H0;
                    actionBarOverlayLayout2.k();
                    ActionMenuView actionMenuView2 = ((mf4) actionBarOverlayLayout2.y0).a.b;
                    if (actionMenuView2 != null) {
                        q3 q3Var2 = actionMenuView2.N0;
                        if (q3Var2 != null) {
                            if (q3Var2.M0 == null) {
                            }
                        }
                    }
                }
                Window.Callback callback = this.C0.getCallback();
                ActionBarOverlayLayout actionBarOverlayLayout3 = this.H0;
                actionBarOverlayLayout3.k();
                if (((mf4) actionBarOverlayLayout3.y0).a.r()) {
                    ActionBarOverlayLayout actionBarOverlayLayout4 = this.H0;
                    actionBarOverlayLayout4.k();
                    ActionMenuView actionMenuView3 = ((mf4) actionBarOverlayLayout4.y0).a.b;
                    if (actionMenuView3 != null && (q3Var = actionMenuView3.N0) != null) {
                        q3Var.g();
                    }
                    if (this.g1) {
                        return;
                    }
                    callback.onPanelClosed(108, D(0).h);
                    return;
                }
                if (callback == null || this.g1) {
                    return;
                }
                if (this.o1 && (1 & this.p1) != 0) {
                    View decorView = this.C0.getDecorView();
                    na naVar = this.q1;
                    decorView.removeCallbacks(naVar);
                    naVar.run();
                }
                ya yaVarD = D(0);
                nk2 nk2Var2 = yaVarD.h;
                if (nk2Var2 == null || yaVarD.o || !callback.onPreparePanel(0, yaVarD.g, nk2Var2)) {
                    return;
                }
                callback.onMenuOpened(108, yaVarD.h);
                ActionBarOverlayLayout actionBarOverlayLayout5 = this.H0;
                actionBarOverlayLayout5.k();
                ((mf4) actionBarOverlayLayout5.y0).a.x();
                return;
            }
        }
        ya yaVarD2 = D(0);
        yaVarD2.n = true;
        v(yaVarD2, false);
        I(yaVarD2, null);
    }

    @Override // defpackage.ma
    public final void c() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.B0);
        if (layoutInflaterFrom.getFactory() == null) {
            layoutInflaterFrom.setFactory2(this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof za) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // defpackage.ma
    public final void d() {
        if (this.E0 != null) {
            E();
            if (this.E0.I()) {
                return;
            }
            F(0);
        }
    }

    @Override // defpackage.ma
    public final void f() {
        String strW;
        this.e1 = true;
        q(false, true);
        A();
        Object obj = this.A0;
        if (obj instanceof Activity) {
            try {
                Activity activity = (Activity) obj;
                try {
                    strW = uf2.w(activity, activity.getComponentName());
                } catch (PackageManager.NameNotFoundException e) {
                    throw new IllegalArgumentException(e);
                }
            } catch (IllegalArgumentException unused) {
                strW = null;
            }
            if (strW != null) {
                tj4 tj4Var = this.E0;
                if (tj4Var == null) {
                    this.r1 = true;
                } else {
                    tj4Var.Z(true);
                }
            }
            synchronized (ma.y0) {
                ma.h(this);
                ma.Z.add(new WeakReference(this));
            }
        }
        this.h1 = new Configuration(this.B0.getResources().getConfiguration());
        this.f1 = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004d  */
    @Override // defpackage.ma
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g() {
        if (this.A0 instanceof Activity) {
            synchronized (ma.y0) {
                ma.h(this);
            }
        }
        if (this.o1) {
            this.C0.getDecorView().removeCallbacks(this.q1);
        }
        this.g1 = true;
        if (this.i1 != -100) {
            Object obj = this.A0;
            if ((obj instanceof Activity) && ((Activity) obj).isChangingConfigurations()) {
                x1.put(this.A0.getClass().getName(), Integer.valueOf(this.i1));
            } else {
                x1.remove(this.A0.getClass().getName());
            }
        }
        tj4 tj4Var = this.E0;
        if (tj4Var != null) {
            tj4Var.R();
        }
        va vaVar = this.m1;
        if (vaVar != null) {
            vaVar.f();
        }
        va vaVar2 = this.n1;
        if (vaVar2 != null) {
            vaVar2.f();
        }
    }

    @Override // defpackage.ma
    public final boolean i(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i = 108;
        } else if (i == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i = 109;
        }
        if (this.Z0 && i == 108) {
            return false;
        }
        if (this.V0 && i == 1) {
            this.V0 = false;
        }
        if (i == 1) {
            L();
            this.Z0 = true;
            return true;
        }
        if (i == 2) {
            L();
            this.T0 = true;
            return true;
        }
        if (i == 5) {
            L();
            this.U0 = true;
            return true;
        }
        if (i == 10) {
            L();
            this.X0 = true;
            return true;
        }
        if (i == 108) {
            L();
            this.V0 = true;
            return true;
        }
        if (i != 109) {
            return this.C0.requestFeature(i);
        }
        L();
        this.W0 = true;
        return true;
    }

    @Override // defpackage.ma
    public final void k(int i) {
        z();
        ViewGroup viewGroup = (ViewGroup) this.Q0.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.B0).inflate(i, viewGroup);
        this.D0.a(this.C0.getCallback());
    }

    @Override // defpackage.ma
    public final void l(View view) {
        z();
        ViewGroup viewGroup = (ViewGroup) this.Q0.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.D0.a(this.C0.getCallback());
    }

    @Override // defpackage.ma
    public final void m(View view, ViewGroup.LayoutParams layoutParams) {
        z();
        ViewGroup viewGroup = (ViewGroup) this.Q0.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.D0.a(this.C0.getCallback());
    }

    @Override // defpackage.ma
    public final void o(CharSequence charSequence) {
        this.G0 = charSequence;
        ActionBarOverlayLayout actionBarOverlayLayout = this.H0;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setWindowTitle(charSequence);
            return;
        }
        tj4 tj4Var = this.E0;
        if (tj4Var != null) {
            tj4Var.c0(charSequence);
            return;
        }
        TextView textView = this.R0;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View nbVar;
        uc ucVar = this.u1;
        View view2 = null;
        if (ucVar == null) {
            int[] iArr = cd3.j;
            Context context2 = this.B0;
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(iArr);
            String string = typedArrayObtainStyledAttributes.getString(116);
            typedArrayObtainStyledAttributes.recycle();
            if (string == null) {
                ucVar = new uc();
                this.u1 = ucVar;
            } else {
                try {
                    ucVar = (uc) context2.getClassLoader().loadClass(string).getDeclaredConstructor(null).newInstance(null);
                    this.u1 = ucVar;
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    ucVar = new uc();
                    this.u1 = ucVar;
                }
            }
        }
        int i = ro4.a;
        ucVar.getClass();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, cd3.z, 0, 0);
        byte b = 4;
        int resourceId = typedArrayObtainStyledAttributes2.getResourceId(4, 0);
        if (resourceId != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        typedArrayObtainStyledAttributes2.recycle();
        Context de0Var = (resourceId == 0 || ((context instanceof de0) && ((de0) context).a == resourceId)) ? context : new de0(context, resourceId);
        str.getClass();
        switch (str.hashCode()) {
            case -1946472170:
                b = !str.equals("RatingBar") ? (byte) -1 : (byte) 0;
                break;
            case -1455429095:
                b = !str.equals("CheckedTextView") ? (byte) -1 : (byte) 1;
                break;
            case -1346021293:
                b = !str.equals("MultiAutoCompleteTextView") ? (byte) -1 : (byte) 2;
                break;
            case -938935918:
                b = !str.equals("TextView") ? (byte) -1 : (byte) 3;
                break;
            case -937446323:
                if (!str.equals("ImageButton")) {
                    b = -1;
                }
                break;
            case -658531749:
                b = !str.equals("SeekBar") ? (byte) -1 : (byte) 5;
                break;
            case -339785223:
                b = !str.equals("Spinner") ? (byte) -1 : (byte) 6;
                break;
            case 776382189:
                b = !str.equals("RadioButton") ? (byte) -1 : (byte) 7;
                break;
            case 799298502:
                b = !str.equals("ToggleButton") ? (byte) -1 : (byte) 8;
                break;
            case 1125864064:
                b = !str.equals("ImageView") ? (byte) -1 : (byte) 9;
                break;
            case 1413872058:
                b = !str.equals("AutoCompleteTextView") ? (byte) -1 : (byte) 10;
                break;
            case 1601505219:
                b = !str.equals("CheckBox") ? (byte) -1 : (byte) 11;
                break;
            case 1666676343:
                b = !str.equals("EditText") ? (byte) -1 : (byte) 12;
                break;
            case 2001146706:
                b = !str.equals("Button") ? (byte) -1 : HttpConstants.CR;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                nbVar = new nb(de0Var, attributeSet);
                break;
            case 1:
                nbVar = new ga(de0Var, attributeSet);
                break;
            case 2:
                nbVar = new jb(de0Var, attributeSet);
                break;
            case 3:
                nbVar = ucVar.e(de0Var, attributeSet);
                break;
            case 4:
                nbVar = new hb(de0Var, attributeSet, com.getsurfboard.R.attr.imageButtonStyle);
                break;
            case 5:
                nbVar = new pb(de0Var, attributeSet);
                break;
            case 6:
                nbVar = new bc(de0Var, attributeSet);
                break;
            case 7:
                nbVar = ucVar.d(de0Var, attributeSet);
                break;
            case 8:
                nbVar = new sc(de0Var, attributeSet);
                break;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                nbVar = new ib(de0Var, attributeSet, 0);
                break;
            case 10:
                nbVar = ucVar.a(de0Var, attributeSet);
                break;
            case 11:
                nbVar = ucVar.c(de0Var, attributeSet);
                break;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                nbVar = new fb(de0Var, attributeSet);
                break;
            case 13:
                nbVar = ucVar.b(de0Var, attributeSet);
                break;
            default:
                nbVar = null;
                break;
        }
        if (nbVar == null && context != de0Var) {
            Object[] objArr = ucVar.a;
            if (str.equals("view")) {
                str = attributeSet.getAttributeValue(null, "class");
            }
            try {
                objArr[0] = de0Var;
                objArr[1] = attributeSet;
                if (-1 == str.indexOf(46)) {
                    int i2 = 0;
                    while (true) {
                        String[] strArr = uc.g;
                        if (i2 < 3) {
                            View viewF = ucVar.f(de0Var, str, strArr[i2]);
                            if (viewF != null) {
                                objArr[0] = null;
                                objArr[1] = null;
                                view2 = viewF;
                            } else {
                                i2++;
                            }
                        } else {
                            objArr[0] = null;
                            objArr[1] = null;
                        }
                    }
                } else {
                    View viewF2 = ucVar.f(de0Var, str, null);
                    objArr[0] = null;
                    objArr[1] = null;
                    view2 = viewF2;
                }
            } catch (Exception unused) {
                objArr[0] = null;
                objArr[1] = null;
            } catch (Throwable th2) {
                objArr[0] = null;
                objArr[1] = null;
                throw th2;
            }
            nbVar = view2;
        }
        if (nbVar != null) {
            Context context3 = nbVar.getContext();
            if ((context3 instanceof ContextWrapper) && nbVar.hasOnClickListeners()) {
                TypedArray typedArrayObtainStyledAttributes3 = context3.obtainStyledAttributes(attributeSet, uc.c);
                String string2 = typedArrayObtainStyledAttributes3.getString(0);
                if (string2 != null) {
                    nbVar.setOnClickListener(new tc(nbVar, string2));
                }
                typedArrayObtainStyledAttributes3.recycle();
            }
            if (Build.VERSION.SDK_INT <= 28) {
                TypedArray typedArrayObtainStyledAttributes4 = de0Var.obtainStyledAttributes(attributeSet, uc.d);
                if (typedArrayObtainStyledAttributes4.hasValue(0)) {
                    boolean z = typedArrayObtainStyledAttributes4.getBoolean(0, false);
                    WeakHashMap weakHashMap = wp4.a;
                    new ip4(com.getsurfboard.R.id.tag_accessibility_heading, Boolean.class, 0, 28, 3).f(nbVar, Boolean.valueOf(z));
                }
                typedArrayObtainStyledAttributes4.recycle();
                TypedArray typedArrayObtainStyledAttributes5 = de0Var.obtainStyledAttributes(attributeSet, uc.e);
                if (typedArrayObtainStyledAttributes5.hasValue(0)) {
                    wp4.o(nbVar, typedArrayObtainStyledAttributes5.getString(0));
                }
                typedArrayObtainStyledAttributes5.recycle();
                TypedArray typedArrayObtainStyledAttributes6 = de0Var.obtainStyledAttributes(attributeSet, uc.f);
                if (typedArrayObtainStyledAttributes6.hasValue(0)) {
                    boolean z2 = typedArrayObtainStyledAttributes6.getBoolean(0, false);
                    WeakHashMap weakHashMap2 = wp4.a;
                    new ip4(com.getsurfboard.R.id.tag_screen_reader_focusable, Boolean.class, 0, 28, 0).f(nbVar, Boolean.valueOf(z2));
                }
                typedArrayObtainStyledAttributes6.recycle();
            }
        }
        return nbVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean q(boolean z, boolean z2) {
        int i;
        boolean z3;
        Object obj;
        if (this.g1) {
            return false;
        }
        int i2 = this.i1;
        if (i2 == -100) {
            i2 = ma.f;
        }
        Context context = this.B0;
        int iG = G(context, i2);
        int i3 = Build.VERSION.SDK_INT;
        Object obj2 = null;
        rd2 rd2VarS = i3 < 33 ? s(context) : null;
        if (!z2 && rd2VarS != null) {
            rd2VarS = C(context.getResources().getConfiguration());
        }
        Configuration configurationW = w(context, iG, rd2VarS, null, false);
        boolean z4 = this.l1;
        boolean z5 = true;
        Object obj3 = this.A0;
        if (z4 || !(obj3 instanceof Activity)) {
            this.l1 = true;
            i = this.k1;
        } else {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                i = 0;
            } else {
                try {
                    ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, obj3.getClass()), i3 >= 29 ? 269221888 : i3 >= 24 ? 786432 : 0);
                    if (activityInfo != null) {
                        this.k1 = activityInfo.configChanges;
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
                    this.k1 = 0;
                }
                this.l1 = true;
                i = this.k1;
            }
        }
        Configuration configuration = this.h1;
        if (configuration == null) {
            configuration = context.getResources().getConfiguration();
        }
        int i4 = configuration.uiMode & 48;
        int i5 = configurationW.uiMode & 48;
        rd2 rd2VarC = C(configuration);
        rd2 rd2VarC2 = rd2VarS == null ? null : C(configurationW);
        int i6 = i4 != i5 ? 512 : 0;
        if (rd2VarC2 != null && !rd2VarC.equals(rd2VarC2)) {
            i6 |= 8196;
        }
        if (((~i) & i6) != 0 && z && this.e1 && ((z1 || this.f1) && (obj3 instanceof Activity))) {
            Activity activity = (Activity) obj3;
            if (!activity.isChild()) {
                if (Build.VERSION.SDK_INT >= 31 && (i6 & 8192) != 0) {
                    activity.getWindow().getDecorView().setLayoutDirection(configurationW.getLayoutDirection());
                }
                e4.A(activity);
                z3 = true;
            }
        } else {
            z3 = false;
        }
        if (z3 || i6 == 0) {
            z5 = z3;
        } else {
            boolean z6 = (i6 & i) == i6;
            Resources resources = context.getResources();
            Configuration configuration2 = new Configuration(resources.getConfiguration());
            configuration2.uiMode = (resources.getConfiguration().uiMode & (-49)) | i5;
            if (rd2VarC2 != null) {
                td2 td2Var = rd2VarC2.a;
                if (Build.VERSION.SDK_INT >= 24) {
                    ra.d(configuration2, rd2VarC2);
                } else {
                    configuration2.setLocale(td2Var.get(0));
                    configuration2.setLayoutDirection(td2Var.get(0));
                }
            }
            resources.updateConfiguration(configuration2, null);
            int i7 = Build.VERSION.SDK_INT;
            if (i7 < 26 && i7 < 28) {
                if (i7 >= 24) {
                    if (!ek0.s) {
                        try {
                            Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                            ek0.r = declaredField;
                            declaredField.setAccessible(true);
                        } catch (NoSuchFieldException e2) {
                            a1.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e2);
                        }
                        ek0.s = true;
                    }
                    Field field = ek0.r;
                    if (field != null) {
                        try {
                            obj = field.get(resources);
                        } catch (IllegalAccessException e3) {
                            a1.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e3);
                            obj = null;
                        }
                        if (obj != null) {
                            if (!ek0.m) {
                                try {
                                    Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                                    ek0.l = declaredField2;
                                    declaredField2.setAccessible(true);
                                } catch (NoSuchFieldException e4) {
                                    a1.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e4);
                                }
                                ek0.m = true;
                            }
                            Field field2 = ek0.l;
                            if (field2 != null) {
                                try {
                                    obj2 = field2.get(obj);
                                } catch (IllegalAccessException e5) {
                                    a1.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e5);
                                }
                            }
                            if (obj2 != null) {
                                ek0.h(obj2);
                            }
                        }
                    }
                } else {
                    if (!ek0.m) {
                        try {
                            Field declaredField3 = Resources.class.getDeclaredField("mDrawableCache");
                            ek0.l = declaredField3;
                            declaredField3.setAccessible(true);
                        } catch (NoSuchFieldException e6) {
                            a1.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e6);
                        }
                        ek0.m = true;
                    }
                    Field field3 = ek0.l;
                    if (field3 != null) {
                        try {
                            obj2 = field3.get(resources);
                        } catch (IllegalAccessException e7) {
                            a1.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e7);
                        }
                    }
                    if (obj2 != null) {
                        ek0.h(obj2);
                    }
                }
            }
            int i8 = this.j1;
            if (i8 != 0) {
                context.setTheme(i8);
                context.getTheme().applyStyle(this.j1, true);
            }
            if (z6 && (obj3 instanceof Activity)) {
                Activity activity2 = (Activity) obj3;
                if (activity2 instanceof da2) {
                    if (((da2) activity2).getLifecycle().b().compareTo(q92.z) >= 0) {
                        activity2.onConfigurationChanged(configuration2);
                    }
                } else if (this.f1 && !this.g1) {
                    activity2.onConfigurationChanged(configuration2);
                }
            }
        }
        if (rd2VarC2 != null) {
            rd2 rd2VarC3 = C(context.getResources().getConfiguration());
            if (Build.VERSION.SDK_INT >= 24) {
                ra.c(rd2VarC3);
            } else {
                Locale.setDefault(rd2VarC3.a.get(0));
            }
        }
        if (i2 == 0) {
            B(context).w();
        } else {
            va vaVar = this.m1;
            if (vaVar != null) {
                vaVar.f();
            }
        }
        va vaVar2 = this.n1;
        if (i2 == 3) {
            if (vaVar2 == null) {
                vaVar2 = new va(this, context);
                this.n1 = vaVar2;
            }
            vaVar2.w();
        } else if (vaVar2 != null) {
            vaVar2.f();
        }
        return z5;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void r(Window window) {
        Drawable drawableG;
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        OnBackInvokedCallback onBackInvokedCallback;
        int resourceId;
        if (this.C0 != null) {
            xe.q("AppCompat has already installed itself into the Window");
            return;
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof ua) {
            xe.q("AppCompat has already installed itself into the Window");
            return;
        }
        ua uaVar = new ua(this, callback);
        this.D0 = uaVar;
        window.setCallback(uaVar);
        Context context = this.B0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, y1);
        if (!typedArrayObtainStyledAttributes.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0)) == 0) {
            drawableG = null;
        } else {
            db dbVarA = db.a();
            synchronized (dbVarA) {
                drawableG = dbVarA.a.g(context, resourceId, true);
            }
        }
        if (drawableG != null) {
            window.setBackgroundDrawable(drawableG);
        }
        typedArrayObtainStyledAttributes.recycle();
        this.C0 = window;
        if (Build.VERSION.SDK_INT < 33 || (onBackInvokedDispatcher = this.v1) != null) {
            return;
        }
        Object obj = this.A0;
        if (onBackInvokedDispatcher != null && (onBackInvokedCallback = this.w1) != null) {
            ta.c(onBackInvokedDispatcher, onBackInvokedCallback);
            this.w1 = null;
        }
        if (obj instanceof Activity) {
            Activity activity = (Activity) obj;
            if (activity.getWindow() != null) {
                this.v1 = ta.a(activity);
            } else {
                this.v1 = null;
            }
        }
        M();
    }

    public final void t(int i, ya yaVar, nk2 nk2Var) {
        if (nk2Var == null) {
            if (yaVar == null && i >= 0) {
                ya[] yaVarArr = this.b1;
                if (i < yaVarArr.length) {
                    yaVar = yaVarArr[i];
                }
            }
            if (yaVar != null) {
                nk2Var = yaVar.h;
            }
        }
        if ((yaVar == null || yaVar.m) && !this.g1) {
            ua uaVar = this.D0;
            Window.Callback callback = this.C0.getCallback();
            uaVar.getClass();
            try {
                uaVar.X = true;
                callback.onPanelClosed(i, nk2Var);
            } finally {
                uaVar.X = false;
            }
        }
    }

    public final void u(nk2 nk2Var) {
        q3 q3Var;
        if (this.a1) {
            return;
        }
        this.a1 = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.H0;
        actionBarOverlayLayout.k();
        ActionMenuView actionMenuView = ((mf4) actionBarOverlayLayout.y0).a.b;
        if (actionMenuView != null && (q3Var = actionMenuView.N0) != null) {
            q3Var.g();
            l3 l3Var = q3Var.L0;
            if (l3Var != null && l3Var.b()) {
                l3Var.i.dismiss();
            }
        }
        Window.Callback callback = this.C0.getCallback();
        if (callback != null && !this.g1) {
            callback.onPanelClosed(108, nk2Var);
        }
        this.a1 = false;
    }

    public final void v(ya yaVar, boolean z) {
        xa xaVar;
        ActionBarOverlayLayout actionBarOverlayLayout;
        if (z && yaVar.a == 0 && (actionBarOverlayLayout = this.H0) != null) {
            actionBarOverlayLayout.k();
            if (((mf4) actionBarOverlayLayout.y0).a.r()) {
                u(yaVar.h);
                return;
            }
        }
        WindowManager windowManager = (WindowManager) this.B0.getSystemService("window");
        if (windowManager != null && yaVar.m && (xaVar = yaVar.e) != null) {
            windowManager.removeView(xaVar);
            if (z) {
                t(yaVar.a, yaVar, null);
            }
        }
        yaVar.k = false;
        yaVar.l = false;
        yaVar.m = false;
        yaVar.f = null;
        yaVar.n = true;
        if (this.c1 == yaVar) {
            this.c1 = null;
        }
        if (yaVar.a == 0) {
            M();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean x(KeyEvent keyEvent) {
        View decorView;
        boolean zX;
        boolean zK;
        ActionMenuView actionMenuView;
        q3 q3Var;
        Object obj = this.A0;
        if ((!(obj instanceof h82) && !(obj instanceof bb)) || (decorView = this.C0.getDecorView()) == null || !wp4.d(decorView, keyEvent)) {
            if (keyEvent.getKeyCode() == 82) {
                ua uaVar = this.D0;
                Window.Callback callback = this.C0.getCallback();
                uaVar.getClass();
                try {
                    uaVar.A = true;
                    if (!callback.dispatchKeyEvent(keyEvent)) {
                        int keyCode = keyEvent.getKeyCode();
                        if (keyEvent.getAction() == 0) {
                            if (keyCode == 4) {
                                this.d1 = (keyEvent.getFlags() & 128) != 0;
                                return false;
                            }
                            if (keyCode == 82) {
                                if (keyEvent.getRepeatCount() == 0) {
                                    ya yaVarD = D(0);
                                    if (!yaVarD.m) {
                                        K(yaVarD, keyEvent);
                                        return true;
                                    }
                                }
                            }
                            return false;
                        }
                        if (keyCode != 4) {
                            if (keyCode == 82) {
                                if (this.K0 == null) {
                                    ya yaVarD2 = D(0);
                                    ActionBarOverlayLayout actionBarOverlayLayout = this.H0;
                                    Context context = this.B0;
                                    if (actionBarOverlayLayout != null) {
                                        actionBarOverlayLayout.k();
                                        Toolbar toolbar = ((mf4) actionBarOverlayLayout.y0).a;
                                        if (toolbar.getVisibility() != 0 || (actionMenuView = toolbar.b) == null || !actionMenuView.M0 || ViewConfiguration.get(context).hasPermanentMenuKey()) {
                                            boolean z = yaVarD2.m;
                                            if (z || yaVarD2.l) {
                                                v(yaVarD2, true);
                                                zX = z;
                                                if (zX) {
                                                    AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio");
                                                    if (audioManager != null) {
                                                        audioManager.playSoundEffect(0);
                                                        return true;
                                                    }
                                                    a1.n("AppCompatDelegate", "Couldn't get audio manager");
                                                    return true;
                                                }
                                            } else {
                                                if (yaVarD2.k) {
                                                    if (yaVarD2.o) {
                                                        yaVarD2.k = false;
                                                        zK = K(yaVarD2, keyEvent);
                                                    } else {
                                                        zK = true;
                                                    }
                                                    if (zK) {
                                                        I(yaVarD2, keyEvent);
                                                        zX = true;
                                                        if (zX) {
                                                        }
                                                    }
                                                }
                                                zX = false;
                                                if (zX) {
                                                }
                                            }
                                        } else {
                                            ActionBarOverlayLayout actionBarOverlayLayout2 = this.H0;
                                            actionBarOverlayLayout2.k();
                                            if (((mf4) actionBarOverlayLayout2.y0).a.r()) {
                                                ActionBarOverlayLayout actionBarOverlayLayout3 = this.H0;
                                                actionBarOverlayLayout3.k();
                                                ActionMenuView actionMenuView2 = ((mf4) actionBarOverlayLayout3.y0).a.b;
                                                if (actionMenuView2 != null && (q3Var = actionMenuView2.N0) != null && q3Var.g()) {
                                                    zX = true;
                                                }
                                                if (zX) {
                                                }
                                            } else {
                                                if (!this.g1 && K(yaVarD2, keyEvent)) {
                                                    ActionBarOverlayLayout actionBarOverlayLayout4 = this.H0;
                                                    actionBarOverlayLayout4.k();
                                                    zX = ((mf4) actionBarOverlayLayout4.y0).a.x();
                                                }
                                                if (zX) {
                                                }
                                            }
                                            zX = false;
                                            if (zX) {
                                            }
                                        }
                                    }
                                }
                            }
                            return false;
                        }
                        if (!H()) {
                            return false;
                        }
                    }
                } finally {
                    uaVar.A = false;
                }
            }
        }
        return true;
    }

    public final void y(int i) {
        ya yaVarD = D(i);
        if (yaVarD.h != null) {
            Bundle bundle = new Bundle();
            yaVarD.h.v(bundle);
            if (bundle.size() > 0) {
                yaVarD.p = bundle;
            }
            yaVarD.h.y();
            yaVarD.h.clear();
        }
        yaVarD.o = true;
        yaVarD.n = true;
        if ((i == 108 || i == 0) && this.H0 != null) {
            ya yaVarD2 = D(0);
            yaVarD2.k = false;
            K(yaVarD2, null);
        }
    }

    public final void z() {
        ViewGroup viewGroup;
        if (this.P0) {
            return;
        }
        Context context = this.B0;
        int[] iArr = cd3.j;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        if (!typedArrayObtainStyledAttributes.hasValue(117)) {
            typedArrayObtainStyledAttributes.recycle();
            xe.q("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
            return;
        }
        if (typedArrayObtainStyledAttributes.getBoolean(126, false)) {
            i(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(117, false)) {
            i(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(118, false)) {
            i(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(119, false)) {
            i(10);
        }
        this.Y0 = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        A();
        this.C0.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        if (this.Z0) {
            viewGroup = this.X0 ? (ViewGroup) layoutInflaterFrom.inflate(com.getsurfboard.R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(com.getsurfboard.R.layout.abc_screen_simple, (ViewGroup) null);
        } else if (this.Y0) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(com.getsurfboard.R.layout.abc_dialog_title_material, (ViewGroup) null);
            this.W0 = false;
            this.V0 = false;
        } else if (this.V0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(com.getsurfboard.R.attr.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new de0(context, typedValue.resourceId) : context).inflate(com.getsurfboard.R.layout.abc_screen_toolbar, (ViewGroup) null);
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) viewGroup.findViewById(com.getsurfboard.R.id.decor_content_parent);
            this.H0 = actionBarOverlayLayout;
            actionBarOverlayLayout.setWindowCallback(this.C0.getCallback());
            if (this.W0) {
                this.H0.j(109);
            }
            if (this.T0) {
                this.H0.j(2);
            }
            if (this.U0) {
                this.H0.j(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.V0 + ", windowActionBarOverlay: " + this.W0 + ", android:windowIsFloating: " + this.Y0 + ", windowActionModeOverlay: " + this.X0 + ", windowNoTitle: " + this.Z0 + " }");
        }
        oa oaVar = new oa(this);
        WeakHashMap weakHashMap = wp4.a;
        mp4.c(viewGroup, oaVar);
        if (this.H0 == null) {
            this.R0 = (TextView) viewGroup.findViewById(com.getsurfboard.R.id.title);
        }
        boolean z = pr4.a;
        try {
            Method method = viewGroup.getClass().getMethod("makeOptionalFitsSystemWindows", null);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(viewGroup, null);
        } catch (IllegalAccessException e) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e);
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        } catch (InvocationTargetException e2) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e2);
        }
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(com.getsurfboard.R.id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.C0.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.C0.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new w7(7, this));
        this.Q0 = viewGroup;
        Object obj = this.A0;
        CharSequence title = obj instanceof Activity ? ((Activity) obj).getTitle() : this.G0;
        if (!TextUtils.isEmpty(title)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.H0;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setWindowTitle(title);
            } else {
                tj4 tj4Var = this.E0;
                if (tj4Var != null) {
                    tj4Var.c0(title);
                } else {
                    TextView textView = this.R0;
                    if (textView != null) {
                        textView.setText(title);
                    }
                }
            }
        }
        ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.Q0.findViewById(R.id.content);
        View decorView = this.C0.getDecorView();
        contentFrameLayout2.A0.set(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        if (contentFrameLayout2.isLaidOut()) {
            contentFrameLayout2.requestLayout();
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(iArr);
        typedArrayObtainStyledAttributes2.getValue(124, contentFrameLayout2.getMinWidthMajor());
        typedArrayObtainStyledAttributes2.getValue(125, contentFrameLayout2.getMinWidthMinor());
        if (typedArrayObtainStyledAttributes2.hasValue(122)) {
            typedArrayObtainStyledAttributes2.getValue(122, contentFrameLayout2.getFixedWidthMajor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(123)) {
            typedArrayObtainStyledAttributes2.getValue(123, contentFrameLayout2.getFixedWidthMinor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(120)) {
            typedArrayObtainStyledAttributes2.getValue(120, contentFrameLayout2.getFixedHeightMajor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(121)) {
            typedArrayObtainStyledAttributes2.getValue(121, contentFrameLayout2.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes2.recycle();
        contentFrameLayout2.requestLayout();
        this.P0 = true;
        ya yaVarD = D(0);
        if (this.g1 || yaVarD.h != null) {
            return;
        }
        F(108);
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
