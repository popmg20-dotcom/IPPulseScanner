package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.PopupWindow;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ViewStubCompat;
import com.getsurfboard.R;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ua implements Window.Callback {
    public boolean A;
    public boolean X;
    public final /* synthetic */ za Y;
    public final Window.Callback b;
    public wn1 f;
    public boolean z;

    public ua(za zaVar, Window.Callback callback) {
        this.Y = zaVar;
        if (callback != null) {
            this.b = callback;
        } else {
            xe.k("Window callback may not be null");
            throw null;
        }
    }

    public final void a(Window.Callback callback) {
        try {
            this.z = true;
            callback.onContentChanged();
        } finally {
            this.z = false;
        }
    }

    public final boolean b(int i, Menu menu) {
        return this.b.onMenuOpened(i, menu);
    }

    public final void c(int i, Menu menu) {
        this.b.onPanelClosed(i, menu);
    }

    public final void d(List list, Menu menu, int i) {
        qt4.a(this.b, list, menu, i);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.b.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z = this.A;
        Window.Callback callback = this.b;
        return z ? callback.dispatchKeyEvent(keyEvent) : this.Y.x(keyEvent) || callback.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        if (!this.b.dispatchKeyShortcutEvent(keyEvent)) {
            int keyCode = keyEvent.getKeyCode();
            za zaVar = this.Y;
            zaVar.E();
            tj4 tj4Var = zaVar.E0;
            if (tj4Var == null || !tj4Var.S(keyCode, keyEvent)) {
                ya yaVar = zaVar.c1;
                if (yaVar == null || !zaVar.J(yaVar, keyEvent.getKeyCode(), keyEvent)) {
                    if (zaVar.c1 == null) {
                        ya yaVarD = zaVar.D(0);
                        zaVar.K(yaVarD, keyEvent);
                        boolean zJ = zaVar.J(yaVarD, keyEvent.getKeyCode(), keyEvent);
                        yaVarD.k = false;
                        if (zJ) {
                        }
                    }
                    return false;
                }
                ya yaVar2 = zaVar.c1;
                if (yaVar2 != null) {
                    yaVar2.l = true;
                    return true;
                }
            }
        }
        return true;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.b.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.b.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.b.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode actionMode) {
        this.b.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode actionMode) {
        this.b.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        this.b.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        if (this.z) {
            this.b.onContentChanged();
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0 || (menu instanceof nk2)) {
            return this.b.onCreatePanelMenu(i, menu);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int i) {
        wn1 wn1Var = this.f;
        if (wn1Var != null) {
            View view = i == 0 ? new View(((kf4) wn1Var.f).l.a.getContext()) : null;
            if (view != null) {
                return view;
            }
        }
        return this.b.onCreatePanelView(i);
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.b.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.b.onMenuItemSelected(i, menuItem);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int i, Menu menu) {
        b(i, menu);
        if (i == 108) {
            za zaVar = this.Y;
            zaVar.E();
            tj4 tj4Var = zaVar.E0;
            if (tj4Var != null) {
                tj4Var.w(true);
            }
        }
        return true;
    }

    @Override // android.view.Window.Callback
    public final void onPanelClosed(int i, Menu menu) {
        if (this.X) {
            this.b.onPanelClosed(i, menu);
            return;
        }
        c(i, menu);
        za zaVar = this.Y;
        if (i == 108) {
            zaVar.E();
            tj4 tj4Var = zaVar.E0;
            if (tj4Var != null) {
                tj4Var.w(false);
                return;
            }
            return;
        }
        if (i == 0) {
            ya yaVarD = zaVar.D(i);
            if (yaVarD.m) {
                zaVar.v(yaVarD, false);
            }
        }
    }

    @Override // android.view.Window.Callback
    public final void onPointerCaptureChanged(boolean z) {
        rt4.a(this.b, z);
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int i, View view, Menu menu) {
        nk2 nk2Var = menu instanceof nk2 ? (nk2) menu : null;
        if (i == 0 && nk2Var == null) {
            return false;
        }
        if (nk2Var != null) {
            nk2Var.y = true;
        }
        wn1 wn1Var = this.f;
        if (wn1Var != null && i == 0) {
            kf4 kf4Var = (kf4) wn1Var.f;
            if (!kf4Var.o) {
                kf4Var.l.l = true;
                kf4Var.o = true;
            }
        }
        boolean zOnPreparePanel = this.b.onPreparePanel(i, view, menu);
        if (nk2Var != null) {
            nk2Var.y = false;
        }
        return zOnPreparePanel;
    }

    @Override // android.view.Window.Callback
    public final void onProvideKeyboardShortcuts(List list, Menu menu, int i) {
        nk2 nk2Var = this.Y.D(0).h;
        if (nk2Var != null) {
            d(list, nk2Var, i);
        } else {
            d(list, menu, i);
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent searchEvent) {
        return pt4.a(this.b, searchEvent);
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.b.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        this.b.onWindowFocusChanged(z);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        ViewGroup viewGroup;
        za zaVar = this.Y;
        Context context = zaVar.B0;
        if (i != 0) {
            return pt4.b(this.b, callback, i);
        }
        iv1 iv1Var = new iv1(context, callback);
        u3 u3Var = zaVar.K0;
        if (u3Var != null) {
            u3Var.a();
        }
        lb lbVar = new lb(zaVar, iv1Var);
        zaVar.E();
        tj4 tj4Var = zaVar.E0;
        if (tj4Var != null) {
            zaVar.K0 = tj4Var.e0(lbVar);
        }
        if (zaVar.K0 == null) {
            cr4 cr4Var = zaVar.O0;
            if (cr4Var != null) {
                cr4Var.b();
            }
            u3 u3Var2 = zaVar.K0;
            if (u3Var2 != null) {
                u3Var2.a();
            }
            int i2 = 1;
            if (zaVar.L0 == null) {
                if (zaVar.Y0) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = context.getTheme();
                    theme.resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = context.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        de0 de0Var = new de0(context, 0);
                        de0Var.getTheme().setTo(themeNewTheme);
                        context = de0Var;
                    }
                    zaVar.L0 = new ActionBarContextView(context);
                    PopupWindow popupWindow = new PopupWindow(context, (AttributeSet) null, R.attr.actionModePopupWindowStyle);
                    zaVar.M0 = popupWindow;
                    popupWindow.setWindowLayoutType(2);
                    zaVar.M0.setContentView(zaVar.L0);
                    zaVar.M0.setWidth(-1);
                    context.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
                    zaVar.L0.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()));
                    zaVar.M0.setHeight(-2);
                    zaVar.N0 = new na(zaVar, i2);
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) zaVar.Q0.findViewById(R.id.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        zaVar.E();
                        tj4 tj4Var2 = zaVar.E0;
                        Context contextF = tj4Var2 != null ? tj4Var2.F() : null;
                        if (contextF != null) {
                            context = contextF;
                        }
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(context));
                        zaVar.L0 = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (zaVar.L0 != null) {
                cr4 cr4Var2 = zaVar.O0;
                if (cr4Var2 != null) {
                    cr4Var2.b();
                }
                zaVar.L0.e();
                Context context2 = zaVar.L0.getContext();
                ActionBarContextView actionBarContextView = zaVar.L0;
                y14 y14Var = new y14();
                y14Var.z = context2;
                y14Var.A = actionBarContextView;
                y14Var.X = lbVar;
                nk2 nk2Var = new nk2(actionBarContextView.getContext());
                nk2Var.l = 1;
                y14Var.y0 = nk2Var;
                nk2Var.e = y14Var;
                if (((iv1) lbVar.f).v(y14Var, nk2Var)) {
                    y14Var.g();
                    zaVar.L0.c(y14Var);
                    zaVar.K0 = y14Var;
                    boolean z = zaVar.P0 && (viewGroup = zaVar.Q0) != null && viewGroup.isLaidOut();
                    ActionBarContextView actionBarContextView2 = zaVar.L0;
                    if (z) {
                        actionBarContextView2.setAlpha(0.0f);
                        cr4 cr4VarA = wp4.a(zaVar.L0);
                        cr4VarA.a(1.0f);
                        zaVar.O0 = cr4VarA;
                        cr4VarA.d(new pa(i2, zaVar));
                    } else {
                        actionBarContextView2.setAlpha(1.0f);
                        zaVar.L0.setVisibility(0);
                        if (zaVar.L0.getParent() instanceof View) {
                            View view = (View) zaVar.L0.getParent();
                            WeakHashMap weakHashMap = wp4.a;
                            view.requestApplyInsets();
                        }
                    }
                    if (zaVar.M0 != null) {
                        zaVar.C0.getDecorView().post(zaVar.N0);
                    }
                } else {
                    zaVar.K0 = null;
                }
            }
            zaVar.M();
            zaVar.K0 = zaVar.K0;
        }
        zaVar.M();
        u3 u3Var3 = zaVar.K0;
        if (u3Var3 != null) {
            return iv1Var.n(u3Var3);
        }
        return null;
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        return this.b.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return null;
    }
}
