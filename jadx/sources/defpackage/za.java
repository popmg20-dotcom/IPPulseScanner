package defpackage;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.ContentFrameLayout;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.HttpConstants;
import java.lang.ref.WeakReference;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final void I(defpackage.ya r18, android.view.KeyEvent r19) {
        /*
            Method dump skipped, instruction units count: 467
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.za.I(ya, android.view.KeyEvent):void");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean K(defpackage.ya r13, android.view.KeyEvent r14) {
        /*
            Method dump skipped, instruction units count: 357
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.za.K(ya, android.view.KeyEvent):boolean");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a0(defpackage.nk2 r6) {
        /*
            Method dump skipped, instruction units count: 215
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.za.a0(nk2):void");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.A0
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L11
            java.lang.Object r0 = defpackage.ma.y0
            monitor-enter(r0)
            defpackage.ma.h(r3)     // Catch: java.lang.Throwable -> Le
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            goto L11
        Le:
            r3 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            throw r3
        L11:
            boolean r0 = r3.o1
            if (r0 == 0) goto L20
            android.view.Window r0 = r3.C0
            android.view.View r0 = r0.getDecorView()
            na r1 = r3.q1
            r0.removeCallbacks(r1)
        L20:
            r0 = 1
            r3.g1 = r0
            int r0 = r3.i1
            r1 = -100
            if (r0 == r1) goto L4d
            java.lang.Object r0 = r3.A0
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L4d
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L4d
            xw3 r0 = defpackage.za.x1
            java.lang.Object r1 = r3.A0
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.i1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L5c
        L4d:
            xw3 r0 = defpackage.za.x1
            java.lang.Object r1 = r3.A0
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L5c:
            tj4 r0 = r3.E0
            if (r0 == 0) goto L63
            r0.R()
        L63:
            va r0 = r3.m1
            if (r0 == 0) goto L6a
            r0.f()
        L6a:
            va r3 = r3.n1
            if (r3 == 0) goto L71
            r3.f()
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.za.g():void");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q(boolean r14, boolean r15) {
        /*
            Method dump skipped, instruction units count: 587
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.za.q(boolean, boolean):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(android.view.Window r8) {
        /*
            r7 = this;
            java.lang.String r0 = "AppCompat has already installed itself into the Window"
            android.view.Window r1 = r7.C0
            if (r1 != 0) goto L7e
            android.view.Window$Callback r1 = r8.getCallback()
            boolean r2 = r1 instanceof defpackage.ua
            if (r2 != 0) goto L7a
            ua r0 = new ua
            r0.<init>(r7, r1)
            r7.D0 = r0
            r8.setCallback(r0)
            android.content.Context r0 = r7.B0
            int[] r1 = defpackage.za.y1
            r2 = 0
            android.content.res.TypedArray r1 = r0.obtainStyledAttributes(r2, r1)
            r3 = 0
            boolean r4 = r1.hasValue(r3)
            if (r4 == 0) goto L3f
            int r3 = r1.getResourceId(r3, r3)
            if (r3 == 0) goto L3f
            db r4 = defpackage.db.a()
            monitor-enter(r4)
            ck3 r5 = r4.a     // Catch: java.lang.Throwable -> L3c
            r6 = 1
            android.graphics.drawable.Drawable r0 = r5.g(r0, r3, r6)     // Catch: java.lang.Throwable -> L3c
            monitor-exit(r4)
            goto L40
        L3c:
            r7 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L3c
            throw r7
        L3f:
            r0 = r2
        L40:
            if (r0 == 0) goto L45
            r8.setBackgroundDrawable(r0)
        L45:
            r1.recycle()
            r7.C0 = r8
            int r8 = android.os.Build.VERSION.SDK_INT
            r0 = 33
            if (r8 < r0) goto L79
            android.window.OnBackInvokedDispatcher r8 = r7.v1
            if (r8 != 0) goto L79
            java.lang.Object r0 = r7.A0
            if (r8 == 0) goto L61
            android.window.OnBackInvokedCallback r1 = r7.w1
            if (r1 == 0) goto L61
            defpackage.ta.c(r8, r1)
            r7.w1 = r2
        L61:
            boolean r8 = r0 instanceof android.app.Activity
            if (r8 == 0) goto L74
            android.app.Activity r0 = (android.app.Activity) r0
            android.view.Window r8 = r0.getWindow()
            if (r8 == 0) goto L74
            android.window.OnBackInvokedDispatcher r8 = defpackage.ta.a(r0)
            r7.v1 = r8
            goto L76
        L74:
            r7.v1 = r2
        L76:
            r7.M()
        L79:
            return
        L7a:
            defpackage.xe.q(r0)
            return
        L7e:
            defpackage.xe.q(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.za.r(android.view.Window):void");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean x(android.view.KeyEvent r7) {
        /*
            Method dump skipped, instruction units count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.za.x(android.view.KeyEvent):boolean");
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
