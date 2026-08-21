package defpackage;

import android.content.ClipData;
import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentContainerView;
import androidx.preference.Preference;
import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.activity.AppThemeConfigActivity;
import com.getsurfboard.ui.activity.DeveloperOptionsActivity;
import com.getsurfboard.ui.activity.HostsListActivity;
import com.getsurfboard.ui.activity.NATDetectActivity;
import com.getsurfboard.ui.activity.OverrideDoHActivity;
import com.getsurfboard.ui.fragment.settings.OthersSettingsFragment;
import com.google.android.material.bottomsheet.BottomSheetDragHandleView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.navigationrail.NavigationRailView;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.sentry.android.core.a1;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class jd implements mu2, l4, z2, wv, st2, n90, i61, hx1, gf, ny1, nw0, w23 {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;

    public /* synthetic */ jd(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    @Override // defpackage.mu2
    public bv4 Z(View view, bv4 bv4Var) {
        int i = this.b;
        Object obj = this.f;
        switch (i) {
            case 0:
                AppThemeConfigActivity appThemeConfigActivity = (AppThemeConfigActivity) obj;
                int i2 = AppThemeConfigActivity.T0;
                view.getClass();
                yu4 yu4Var = bv4Var.a;
                y3 y3Var = appThemeConfigActivity.S0;
                if (y3Var == null) {
                    n12.T("binding");
                    throw null;
                }
                NestedScrollView nestedScrollView = (NestedScrollView) y3Var.j;
                nestedScrollView.setPadding(nestedScrollView.getPaddingLeft(), nestedScrollView.getPaddingTop(), nestedScrollView.getPaddingRight(), yu4Var.h(519).d);
                y3 y3Var2 = appThemeConfigActivity.S0;
                if (y3Var2 == null) {
                    n12.T("binding");
                    throw null;
                }
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) y3Var2.a;
                coordinatorLayout.getClass();
                coordinatorLayout.setPadding(yu4Var.h(519).a, coordinatorLayout.getPaddingTop(), yu4Var.h(519).c, coordinatorLayout.getPaddingBottom());
                return bv4Var;
            case 8:
                lb lbVar = (lb) obj;
                int i3 = DeveloperOptionsActivity.S0;
                view.getClass();
                CoordinatorLayout coordinatorLayout2 = (CoordinatorLayout) lbVar.f;
                coordinatorLayout2.getClass();
                yu4 yu4Var2 = bv4Var.a;
                coordinatorLayout2.setPadding(yu4Var2.h(519).a, coordinatorLayout2.getPaddingTop(), yu4Var2.h(519).c, coordinatorLayout2.getPaddingBottom());
                NestedScrollView nestedScrollView2 = (NestedScrollView) lbVar.z;
                nestedScrollView2.setPadding(nestedScrollView2.getPaddingLeft(), nestedScrollView2.getPaddingTop(), nestedScrollView2.getPaddingRight(), yu4Var2.h(519).d);
                return bv4Var;
            case 11:
                a81 a81Var = (a81) obj;
                view.getClass();
                t02 t02VarH = bv4Var.a.h(519);
                t02VarH.getClass();
                v92 v92Var = a81Var.b;
                v92Var.getClass();
                CoordinatorLayout coordinatorLayout3 = (CoordinatorLayout) v92Var.b;
                coordinatorLayout3.getClass();
                coordinatorLayout3.setPadding(t02VarH.a, coordinatorLayout3.getPaddingTop(), t02VarH.c, coordinatorLayout3.getPaddingBottom());
                v92 v92Var2 = a81Var.b;
                v92Var2.getClass();
                RecyclerView recyclerView = (RecyclerView) v92Var2.z;
                recyclerView.setPadding(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), recyclerView.getPaddingRight(), t02VarH.d);
                return bv4Var;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                view.getClass();
                cm2 cm2Var = ((ma1) obj).b;
                cm2Var.getClass();
                RecyclerView recyclerView2 = (RecyclerView) cm2Var.Y;
                recyclerView2.setPadding(recyclerView2.getPaddingLeft(), recyclerView2.getPaddingTop(), recyclerView2.getPaddingRight(), bv4Var.a.h(519).d);
                return bv4Var;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                HostsListActivity hostsListActivity = (HostsListActivity) obj;
                int i4 = HostsListActivity.a1;
                view.getClass();
                yu4 yu4Var3 = bv4Var.a;
                j80 j80Var = hostsListActivity.S0;
                if (j80Var == null) {
                    n12.T("binding");
                    throw null;
                }
                RecyclerView recyclerView3 = (RecyclerView) j80Var.e;
                recyclerView3.setPadding(recyclerView3.getPaddingLeft(), recyclerView3.getPaddingTop(), recyclerView3.getPaddingRight(), yu4Var3.h(519).d);
                j80 j80Var2 = hostsListActivity.S0;
                if (j80Var2 == null) {
                    n12.T("binding");
                    throw null;
                }
                FloatingActionButton floatingActionButton = (FloatingActionButton) j80Var2.a;
                ViewGroup.LayoutParams layoutParams = floatingActionButton.getLayoutParams();
                if (layoutParams != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    j80 j80Var3 = hostsListActivity.S0;
                    if (j80Var3 == null) {
                        n12.T("binding");
                        throw null;
                    }
                    marginLayoutParams.bottomMargin = hostsListActivity.getResources().getDimensionPixelOffset(R.dimen.fab_margin) + ((RecyclerView) j80Var3.e).getPaddingBottom();
                    floatingActionButton.setLayoutParams(marginLayoutParams);
                    j80 j80Var4 = hostsListActivity.S0;
                    if (j80Var4 == null) {
                        n12.T("binding");
                        throw null;
                    }
                    CoordinatorLayout coordinatorLayout4 = (CoordinatorLayout) j80Var4.f;
                    coordinatorLayout4.getClass();
                    coordinatorLayout4.setPadding(yu4Var3.h(519).a, coordinatorLayout4.getPaddingTop(), yu4Var3.h(519).c, coordinatorLayout4.getPaddingBottom());
                    if (Build.VERSION.SDK_INT < 30) {
                        return bv4Var;
                    }
                    int i5 = yu4Var3.h(8).d;
                    j80 j80Var5 = hostsListActivity.S0;
                    if (i5 > 0) {
                        if (j80Var5 == null) {
                            n12.T("binding");
                            throw null;
                        }
                        FragmentContainerView fragmentContainerView = (FragmentContainerView) j80Var5.b;
                        ViewGroup.LayoutParams layoutParams2 = fragmentContainerView.getLayoutParams();
                        if (layoutParams2 != null) {
                            te0 te0Var = (te0) layoutParams2;
                            te0Var.c = 81;
                            ((ViewGroup.MarginLayoutParams) te0Var).bottomMargin = ContextUtilsKt.c(16.0f) + i5;
                            fragmentContainerView.setLayoutParams(te0Var);
                            return bv4Var;
                        }
                        zo2.n("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
                    } else {
                        if (j80Var5 == null) {
                            n12.T("binding");
                            throw null;
                        }
                        FragmentContainerView fragmentContainerView2 = (FragmentContainerView) j80Var5.b;
                        ViewGroup.LayoutParams layoutParams3 = fragmentContainerView2.getLayoutParams();
                        if (layoutParams3 != null) {
                            te0 te0Var2 = (te0) layoutParams3;
                            te0Var2.c = 17;
                            ((ViewGroup.MarginLayoutParams) te0Var2).bottomMargin = 0;
                            fragmentContainerView2.setLayoutParams(te0Var2);
                            return bv4Var;
                        }
                        zo2.n("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
                    }
                } else {
                    zo2.n("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                }
                return null;
            case 19:
                se2 se2Var = (se2) obj;
                view.getClass();
                yu4 yu4Var4 = bv4Var.a;
                t02 t02VarH2 = yu4Var4.h(519);
                t02VarH2.getClass();
                view.setPadding(se2Var.getResources().getDimensionPixelSize(R.dimen.logcat_filter_padding_horizontal), se2Var.getResources().getDimensionPixelSize(R.dimen.logcat_filter_padding_vertical), se2Var.getResources().getDimensionPixelSize(R.dimen.logcat_filter_padding_horizontal), se2Var.getResources().getDimensionPixelSize(R.dimen.logcat_filter_padding_vertical) + (yu4Var4.h(8).d <= 0 ? t02VarH2.d : 0));
                return bv4Var;
            case 21:
                tf2 tf2Var = (tf2) obj;
                view.getClass();
                t02 t02VarH3 = bv4Var.a.h(128);
                ed4 ed4Var = tf2Var.b;
                ed4Var.getClass();
                FrameLayout frameLayout = (NavigationView) ed4Var.A;
                if (frameLayout == null) {
                    ed4 ed4Var2 = tf2Var.b;
                    ed4Var2.getClass();
                    frameLayout = (up2) ed4Var2.z;
                }
                if (frameLayout != null) {
                    if (frameLayout instanceof NavigationRailView) {
                        ViewGroup.LayoutParams layoutParams4 = frameLayout.getLayoutParams();
                        if (layoutParams4 == null) {
                            zo2.n("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                            return null;
                        }
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams4;
                        marginLayoutParams2.leftMargin = t02VarH3.a;
                        frameLayout.setLayoutParams(marginLayoutParams2);
                    } else if (frameLayout instanceof NavigationView) {
                        frameLayout.setPadding(t02VarH3.a, frameLayout.getPaddingTop(), frameLayout.getPaddingRight(), frameLayout.getPaddingBottom());
                    }
                }
                ed4 ed4Var3 = tf2Var.b;
                ed4Var3.getClass();
                ConstraintLayout constraintLayout = (ConstraintLayout) ed4Var3.f;
                constraintLayout.getClass();
                constraintLayout.setPadding(constraintLayout.getPaddingLeft(), constraintLayout.getPaddingTop(), t02VarH3.c, constraintLayout.getPaddingBottom());
                return bv4Var;
            case 24:
                NATDetectActivity nATDetectActivity = (NATDetectActivity) obj;
                int i6 = NATDetectActivity.V0;
                view.getClass();
                yu4 yu4Var5 = bv4Var.a;
                h4 h4Var = nATDetectActivity.S0;
                if (h4Var == null) {
                    n12.T("binding");
                    throw null;
                }
                ConstraintLayout constraintLayout2 = (ConstraintLayout) h4Var.c;
                constraintLayout2.setPadding(constraintLayout2.getPaddingLeft(), constraintLayout2.getPaddingTop(), constraintLayout2.getPaddingRight(), ContextUtilsKt.c(12.0f) + yu4Var5.h(519).d);
                int i7 = yu4Var5.h(8).d;
                h4 h4Var2 = nATDetectActivity.S0;
                if (h4Var2 == null) {
                    n12.T("binding");
                    throw null;
                }
                CoordinatorLayout coordinatorLayout5 = (CoordinatorLayout) h4Var2.b;
                coordinatorLayout5.getClass();
                coordinatorLayout5.setPadding(coordinatorLayout5.getPaddingLeft(), coordinatorLayout5.getPaddingTop(), coordinatorLayout5.getPaddingRight(), i7);
                if (i7 > 0) {
                    h4 h4Var3 = nATDetectActivity.S0;
                    if (h4Var3 == null) {
                        n12.T("binding");
                        throw null;
                    }
                    ConstraintLayout constraintLayout3 = (ConstraintLayout) h4Var3.c;
                    constraintLayout3.setPadding(constraintLayout3.getPaddingLeft(), constraintLayout3.getPaddingTop(), constraintLayout3.getPaddingRight(), ContextUtilsKt.c(12.0f));
                }
                return bv4Var;
            default:
                OverrideDoHActivity overrideDoHActivity = (OverrideDoHActivity) obj;
                int i8 = OverrideDoHActivity.X0;
                view.getClass();
                yu4 yu4Var6 = bv4Var.a;
                t02 t02VarH4 = yu4Var6.h(519);
                t02VarH4.getClass();
                int i9 = t02VarH4.d;
                int i10 = t02VarH4.c;
                uf4 uf4Var = overrideDoHActivity.S0;
                if (uf4Var == null) {
                    n12.T("binding");
                    throw null;
                }
                RecyclerView recyclerView4 = (RecyclerView) uf4Var.e;
                recyclerView4.setPadding(t02VarH4.a, recyclerView4.getPaddingTop(), i10, i9);
                uf4 uf4Var2 = overrideDoHActivity.S0;
                if (uf4Var2 == null) {
                    n12.T("binding");
                    throw null;
                }
                FloatingActionButton floatingActionButton2 = (FloatingActionButton) uf4Var2.c;
                ViewGroup.LayoutParams layoutParams5 = floatingActionButton2.getLayoutParams();
                if (layoutParams5 != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams5;
                    marginLayoutParams3.rightMargin = ContextUtilsKt.c(16.0f) + i10;
                    marginLayoutParams3.bottomMargin = ContextUtilsKt.c(16.0f) + i9;
                    floatingActionButton2.setLayoutParams(marginLayoutParams3);
                    if (Build.VERSION.SDK_INT < 30) {
                        return bv4Var;
                    }
                    int i11 = yu4Var6.h(8).d;
                    uf4 uf4Var3 = overrideDoHActivity.S0;
                    if (i11 > 0) {
                        if (uf4Var3 == null) {
                            n12.T("binding");
                            throw null;
                        }
                        FragmentContainerView fragmentContainerView3 = (FragmentContainerView) uf4Var3.b;
                        ViewGroup.LayoutParams layoutParams6 = fragmentContainerView3.getLayoutParams();
                        if (layoutParams6 != null) {
                            te0 te0Var3 = (te0) layoutParams6;
                            te0Var3.c = 81;
                            ((ViewGroup.MarginLayoutParams) te0Var3).bottomMargin = ContextUtilsKt.c(16.0f) + i11;
                            fragmentContainerView3.setLayoutParams(te0Var3);
                            return bv4Var;
                        }
                        zo2.n("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
                    } else {
                        if (uf4Var3 == null) {
                            n12.T("binding");
                            throw null;
                        }
                        FragmentContainerView fragmentContainerView4 = (FragmentContainerView) uf4Var3.b;
                        ViewGroup.LayoutParams layoutParams7 = fragmentContainerView4.getLayoutParams();
                        if (layoutParams7 != null) {
                            te0 te0Var4 = (te0) layoutParams7;
                            te0Var4.c = 17;
                            ((ViewGroup.MarginLayoutParams) te0Var4).bottomMargin = 0;
                            fragmentContainerView4.setLayoutParams(te0Var4);
                            return bv4Var;
                        }
                        zo2.n("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
                    }
                } else {
                    zo2.n("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                }
                return null;
        }
    }

    @Override // defpackage.st2
    public Object a() {
        int i = this.b;
        Object obj = this.f;
        switch (i) {
            case 4:
                Constructor constructor = (Constructor) obj;
                try {
                    return constructor.newInstance(null);
                } catch (IllegalAccessException e) {
                    ez4 ez4Var = hh3.a;
                    zo2.o("Unexpected IllegalAccessException occurred (Gson 2.13.2). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e);
                    return null;
                } catch (InstantiationException e2) {
                    throw new RuntimeException("Failed to invoke constructor '" + hh3.b(constructor) + "' with no args", e2);
                } catch (InvocationTargetException e3) {
                    zo2.o("Failed to invoke constructor '" + hh3.b(constructor) + "' with no args", e3.getCause());
                    return null;
                }
            default:
                Class cls = (Class) obj;
                try {
                    return pm4.a.a(cls);
                } catch (Exception e4) {
                    throw new RuntimeException("Unable to create instance of " + cls + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e4);
                }
        }
    }

    @Override // defpackage.gf
    /* JADX INFO: renamed from: apply */
    public nc2 mo23apply(Object obj) {
        return (nc2) ((f0) this.f).g(obj);
    }

    public boolean b(wn1 wn1Var, int i, Bundle bundle) {
        qd0 pd0Var;
        fb fbVar = (fb) this.f;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 25 && (i & 1) != 0) {
            try {
                ((o02) wn1Var.f).d();
                Parcelable parcelable = (Parcelable) ((o02) wn1Var.f).e();
                bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", parcelable);
            } catch (Exception e) {
                a1.o("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e);
                return false;
            }
        }
        o02 o02Var = (o02) wn1Var.f;
        ClipData clipData = new ClipData(o02Var.getDescription(), new ClipData.Item(o02Var.c()));
        if (i2 >= 31) {
            pd0Var = new pd0(clipData, 2);
        } else {
            rd0 rd0Var = new rd0();
            rd0Var.b = clipData;
            rd0Var.c = 2;
            pd0Var = rd0Var;
        }
        pd0Var.d(o02Var.b());
        pd0Var.setExtras(bundle);
        return wp4.j(fbVar, pd0Var.build()) == null;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean c(android.view.MotionEvent r7) {
        /*
            r6 = this;
            java.lang.Object r6 = r6.f
            bc1 r6 = (defpackage.bc1) r6
            android.view.View r0 = r6.j
            boolean r1 = r6.l
            r2 = 0
            if (r1 != 0) goto Lc
            return r2
        Lc:
            float r1 = r7.getX()
            float r3 = r7.getY()
            android.graphics.Rect r4 = r6.a()
            int r7 = r7.getAction()
            r5 = 1
            if (r7 == 0) goto L86
            if (r7 == r5) goto L82
            r1 = 2
            if (r7 == r1) goto L29
            r0 = 3
            if (r7 == r0) goto L82
            goto La2
        L29:
            boolean r7 = r6.s
            if (r7 != 0) goto L72
            android.view.View r7 = r6.i
            float r1 = r6.n
            float r2 = r6.o
            boolean r7 = r6.d(r7, r1, r2)
            if (r7 == 0) goto L72
            float r7 = r6.o
            float r7 = r3 - r7
            float r7 = java.lang.Math.abs(r7)
            int r1 = r6.b
            float r1 = (float) r1
            int r7 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r7 <= 0) goto L72
            float r7 = r6.n
            float r1 = r6.o
            boolean r7 = r6.d(r0, r7, r1)
            if (r7 == 0) goto L5b
            float r7 = r6.p
            r6.q = r7
            int r7 = r6.m
            r6.r = r7
            goto L6f
        L5b:
            r6.q = r3
            int r7 = r4.top
            float r7 = (float) r7
            float r7 = r3 - r7
            int r0 = r6.h
            float r0 = (float) r0
            r1 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r1
            float r7 = r7 - r0
            int r7 = (int) r7
            r6.r = r7
            r6.g(r7)
        L6f:
            r6.h(r5)
        L72:
            boolean r7 = r6.s
            if (r7 == 0) goto La2
            int r7 = r6.r
            float r0 = r6.q
            float r0 = r3 - r0
            int r0 = (int) r0
            int r7 = r7 + r0
            r6.g(r7)
            goto La2
        L82:
            r6.h(r2)
            goto La2
        L86:
            r6.n = r1
            r6.o = r3
            float r7 = r0.getAlpha()
            r2 = 0
            int r7 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r7 <= 0) goto La2
            boolean r7 = r6.d(r0, r1, r3)
            if (r7 == 0) goto La2
            r6.q = r3
            int r7 = r6.m
            r6.r = r7
            r6.h(r5)
        La2:
            r6.p = r3
            boolean r6 = r6.s
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jd.c(android.view.MotionEvent):boolean");
    }

    @Override // defpackage.z2
    public boolean d(View view) {
        BottomSheetDragHandleView bottomSheetDragHandleView = (BottomSheetDragHandleView) this.f;
        int i = BottomSheetDragHandleView.H0;
        return bottomSheetDragHandleView.c();
    }

    @Override // defpackage.nw0
    public List e(String str) throws UnknownHostException {
        v62 v62Var = (v62) this.f;
        str.getClass();
        try {
            return ((pw0) v62Var.z).e(str);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            try {
                InetAddress[] allByName = InetAddress.getAllByName(str);
                allByName.getClass();
                return qe.s0(allByName);
            } catch (NullPointerException e2) {
                UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of ".concat(str));
                unknownHostException.initCause(e2);
                throw unknownHostException;
            }
        }
    }

    @Override // defpackage.n90
    public Object g(rk3 rk3Var) {
        return new nl0((Context) rk3Var.get(Context.class), ((ze1) rk3Var.get(ze1.class)).c(), rk3Var.e(pr1.class), rk3Var.b(an0.class), (Executor) rk3Var.d((fc3) this.f));
    }

    @Override // defpackage.l4
    public void h(Object obj) throws IOException {
        iv1 iv1Var;
        Context context;
        int i = this.b;
        Object obj2 = this.f;
        ge0 ge0Var = null;
        switch (i) {
            case 1:
                jj jjVar = (jj) obj2;
                Uri uri = (Uri) obj;
                if (uri != null) {
                    da2 viewLifecycleOwner = jjVar.a.getViewLifecycleOwner();
                    viewLifecycleOwner.getClass();
                    ji0.B(uf2.t(viewLifecycleOwner), null, null, new hj(jjVar, uri, ge0Var, 0), 3);
                    return;
                }
                return;
            default:
                po1 po1Var = (po1) obj2;
                Uri uri2 = (Uri) obj;
                if (uri2 == null || (iv1Var = po1Var.I0) == null || (context = po1Var.getContext()) == null) {
                    return;
                }
                bh3 bh3Var = new bh3();
                bh3Var.b = "database.mmdb";
                Cursor cursorQuery = context.getContentResolver().query(uri2, null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        int columnIndex = cursorQuery.getColumnIndex("_display_name");
                        if (cursorQuery.moveToFirst()) {
                            String string = cursorQuery.getString(columnIndex);
                            string.getClass();
                            bh3Var.b = string;
                        }
                        cursorQuery.close();
                        break;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            ez4.l(cursorQuery, th);
                            throw th2;
                        }
                    }
                }
                ji0.B(uf2.t(po1Var), null, null, new hd(iv1Var, uri2, po1Var, bh3Var, (ge0) null), 3);
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [w01] */
    /* JADX WARN: Type inference failed for: r5v3, types: [w01] */
    /* JADX WARN: Type inference failed for: r7v1, types: [w01] */
    /* JADX WARN: Type inference failed for: r8v3, types: [w01] */
    @Override // defpackage.i61
    public void j(p60 p60Var) {
        int i = this.b;
        Object obj = this.f;
        switch (i) {
            case 10:
                final zf2 zf2Var = (zf2) obj;
                ag0 ag0Var = (ag0) p60Var;
                ag0Var.getClass();
                ContextMenu contextMenu = ag0Var.c;
                contextMenu.getClass();
                CodeEditor codeEditor = (CodeEditor) zf2Var.f;
                Context context = codeEditor.getContext();
                context.getClass();
                ArrayList<x01> arrayList = new ArrayList();
                x01 x01Var = new x01(context);
                x01Var.a(android.R.string.selectAll);
                x01Var.d = R.drawable.round_select_all_20;
                ld0 text = codeEditor.getText();
                text.getClass();
                final int i2 = 1;
                final int i3 = 0;
                x01Var.c = !(text.A == 0);
                final int i4 = 3;
                final pl1 pl1Var = new pl1() { // from class: v01
                    @Override // defpackage.pl1
                    public final Object a() {
                        int i5 = i4;
                        xl4 xl4Var = xl4.a;
                        zf2 zf2Var2 = zf2Var;
                        switch (i5) {
                            case 0:
                                ((CodeEditor) zf2Var2.f).Y();
                                break;
                            case 1:
                                ((CodeEditor) zf2Var2.f).f(true);
                                break;
                            case 2:
                                ((CodeEditor) zf2Var2.f).i();
                                break;
                            default:
                                ((CodeEditor) zf2Var2.f).f0();
                                break;
                        }
                        return xl4Var;
                    }
                };
                x01Var.e = new MenuItem.OnMenuItemClickListener() { // from class: w01
                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        menuItem.getClass();
                        pl1Var.a();
                        return true;
                    }
                };
                arrayList.add(x01Var);
                x01 x01Var2 = new x01(context);
                x01Var2.a(android.R.string.copy);
                x01Var2.d = R.drawable.round_content_copy_20;
                x01Var2.c = codeEditor.I1.a();
                final pl1 pl1Var2 = new pl1() { // from class: v01
                    @Override // defpackage.pl1
                    public final Object a() {
                        int i5 = i2;
                        xl4 xl4Var = xl4.a;
                        zf2 zf2Var2 = zf2Var;
                        switch (i5) {
                            case 0:
                                ((CodeEditor) zf2Var2.f).Y();
                                break;
                            case 1:
                                ((CodeEditor) zf2Var2.f).f(true);
                                break;
                            case 2:
                                ((CodeEditor) zf2Var2.f).i();
                                break;
                            default:
                                ((CodeEditor) zf2Var2.f).f0();
                                break;
                        }
                        return xl4Var;
                    }
                };
                x01Var2.e = new MenuItem.OnMenuItemClickListener() { // from class: w01
                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        menuItem.getClass();
                        pl1Var2.a();
                        return true;
                    }
                };
                arrayList.add(x01Var2);
                x01 x01Var3 = new x01(context);
                x01Var3.a(android.R.string.cut);
                x01Var3.d = R.drawable.round_content_cut_20;
                x01Var3.c = codeEditor.I1.a();
                final int i5 = 2;
                final pl1 pl1Var3 = new pl1() { // from class: v01
                    @Override // defpackage.pl1
                    public final Object a() {
                        int i52 = i5;
                        xl4 xl4Var = xl4.a;
                        zf2 zf2Var2 = zf2Var;
                        switch (i52) {
                            case 0:
                                ((CodeEditor) zf2Var2.f).Y();
                                break;
                            case 1:
                                ((CodeEditor) zf2Var2.f).f(true);
                                break;
                            case 2:
                                ((CodeEditor) zf2Var2.f).i();
                                break;
                            default:
                                ((CodeEditor) zf2Var2.f).f0();
                                break;
                        }
                        return xl4Var;
                    }
                };
                x01Var3.e = new MenuItem.OnMenuItemClickListener() { // from class: w01
                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        menuItem.getClass();
                        pl1Var3.a();
                        return true;
                    }
                };
                arrayList.add(x01Var3);
                x01 x01Var4 = new x01(context);
                x01Var4.a(android.R.string.paste);
                x01Var4.d = R.drawable.round_content_paste_20;
                x01Var4.c = codeEditor.G1.hasPrimaryClip();
                final pl1 pl1Var4 = new pl1() { // from class: v01
                    @Override // defpackage.pl1
                    public final Object a() {
                        int i52 = i3;
                        xl4 xl4Var = xl4.a;
                        zf2 zf2Var2 = zf2Var;
                        switch (i52) {
                            case 0:
                                ((CodeEditor) zf2Var2.f).Y();
                                break;
                            case 1:
                                ((CodeEditor) zf2Var2.f).f(true);
                                break;
                            case 2:
                                ((CodeEditor) zf2Var2.f).i();
                                break;
                            default:
                                ((CodeEditor) zf2Var2.f).f0();
                                break;
                        }
                        return xl4Var;
                    }
                };
                x01Var4.e = new MenuItem.OnMenuItemClickListener() { // from class: w01
                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        menuItem.getClass();
                        pl1Var4.a();
                        return true;
                    }
                };
                arrayList.add(x01Var4);
                for (x01 x01Var5 : arrayList) {
                    x01Var5.getClass();
                    MenuItem onMenuItemClickListener = contextMenu.add(0, 0, 0, x01Var5.b).setEnabled(x01Var5.c).setOnMenuItemClickListener(x01Var5.e);
                    int i6 = x01Var5.d;
                    if (i6 != 0) {
                        onMenuItemClickListener.setIcon(i6);
                    }
                }
                break;
            default:
                nf2 nf2Var = (nf2) obj;
                Drawable background = nf2Var.b.getContentView().getBackground();
                if (background != null) {
                    background.setTint(nf2Var.a.getColorScheme().e(4));
                }
                break;
        }
    }

    @Override // defpackage.w23
    public boolean k(Preference preference) {
        return OthersSettingsFragment.onResume$lambda$0$0((yo4) this.f, preference);
    }

    @Override // defpackage.hx1
    public void l(du3 du3Var) {
        ((n02) this.f).l(du3Var);
    }

    @Override // defpackage.wv
    public Object n(vv vvVar) {
        nc2 nc2Var;
        n00 n00Var = (n00) this.f;
        n00Var.n.e();
        a00 a00Var = n00Var.a;
        synchronized (a00Var.a) {
            try {
                boolean zIsEmpty = a00Var.b.isEmpty();
                yv yvVar = a00Var.d;
                nc2 nc2Var2 = yvVar;
                yv yvVar2 = yvVar;
                if (!zIsEmpty) {
                    if (yvVar == null) {
                        vv vvVar2 = new vv();
                        vvVar2.c = new wj3();
                        yv yvVar3 = new yv(vvVar2);
                        vvVar2.b = yvVar3;
                        vvVar2.a = fw.class;
                        try {
                            synchronized (a00Var.a) {
                                a00Var.e = vvVar2;
                            }
                            vvVar2.a = "CameraRepository-deinit";
                        } catch (Exception e) {
                            yvVar3.b(e);
                        }
                        a00Var.d = yvVar3;
                        yvVar2 = yvVar3;
                    }
                    a00Var.c.addAll(a00Var.b.values());
                    for (mz mzVar : a00Var.b.values()) {
                        mzVar.release().a(new s7(13, a00Var, mzVar), yu0.a());
                    }
                    a00Var.b.clear();
                    nc2Var = yvVar2;
                } else if (yvVar == null) {
                    nc2Var2 = zy1.z;
                }
            } finally {
            }
        }
        nc2Var.a(new s7(14, n00Var, vvVar), n00Var.d);
        return "CameraX shutdownInternal";
    }

    @Override // defpackage.ny1
    public void o(oy1 oy1Var) {
        wl2 wl2Var = (wl2) this.f;
        synchronized (wl2Var.b) {
            wl2Var.z++;
        }
        wl2Var.e(oy1Var);
    }
}
