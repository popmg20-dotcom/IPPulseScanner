package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import com.getsurfboard.R;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class l90 extends Dialog implements da2, xu2, kp3 {
    public final n84 A;
    public fa2 b;
    public final ip3 f;
    public final n84 z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l90(Context context, int i) {
        super(context, i);
        context.getClass();
        this.f = new ip3(new jp3(this, new fn(22, this)));
        final int i2 = 0;
        this.z = new n84(new pl1(this) { // from class: k90
            public final /* synthetic */ l90 f;

            {
                this.f = this;
            }

            @Override // defpackage.pl1
            public final Object a() {
                int i3 = i2;
                l90 l90Var = this.f;
                switch (i3) {
                    case 0:
                        zu0 zu0Var = new zu0();
                        l90Var.b().c().c.c(zu0Var);
                        return zu0Var;
                    default:
                        return new wu2(new d4(15, l90Var));
                }
            }
        });
        final int i3 = 1;
        this.A = new n84(new pl1(this) { // from class: k90
            public final /* synthetic */ l90 f;

            {
                this.f = this;
            }

            @Override // defpackage.pl1
            public final Object a() {
                int i32 = i3;
                l90 l90Var = this.f;
                switch (i32) {
                    case 0:
                        zu0 zu0Var = new zu0();
                        l90Var.b().c().c.c(zu0Var);
                        return zu0Var;
                    default:
                        return new wu2(new d4(15, l90Var));
                }
            }
        });
    }

    public static final void c(l90 l90Var) {
        super.onBackPressed();
    }

    public final void a() {
        Window window = getWindow();
        window.getClass();
        View decorView = window.getDecorView();
        decorView.getClass();
        decorView.setTag(R.id.view_tree_lifecycle_owner, this);
        Window window2 = getWindow();
        window2.getClass();
        View decorView2 = window2.getDecorView();
        decorView2.getClass();
        decorView2.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, this);
        Window window3 = getWindow();
        window3.getClass();
        View decorView3 = window3.getDecorView();
        decorView3.getClass();
        decorView3.setTag(R.id.view_tree_saved_state_registry_owner, this);
        Window window4 = getWindow();
        window4.getClass();
        View decorView4 = window4.getDecorView();
        decorView4.getClass();
        decorView4.setTag(R.id.view_tree_navigation_event_dispatcher_owner, this);
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        view.getClass();
        a();
        super.addContentView(view, layoutParams);
    }

    @Override // defpackage.xu2
    public final wu2 b() {
        return (wu2) this.A.getValue();
    }

    @Override // defpackage.da2
    public final r92 getLifecycle() {
        fa2 fa2Var = this.b;
        if (fa2Var != null) {
            return fa2Var;
        }
        fa2 fa2Var2 = new fa2(this);
        this.b = fa2Var2;
        return fa2Var2;
    }

    @Override // defpackage.kp3
    public final hp3 getSavedStateRegistry() {
        return this.f.b;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        ((zu0) this.z.getValue()).a();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            wu2 wu2VarB = b();
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            onBackInvokedDispatcher.getClass();
            wu2VarB.e(onBackInvokedDispatcher);
        }
        this.f.a(bundle);
        fa2 fa2Var = this.b;
        if (fa2Var == null) {
            fa2Var = new fa2(this);
            this.b = fa2Var;
        }
        fa2Var.f(p92.ON_CREATE);
    }

    @Override // android.app.Dialog
    public final Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        bundleOnSaveInstanceState.getClass();
        this.f.b(bundleOnSaveInstanceState);
        return bundleOnSaveInstanceState;
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        fa2 fa2Var = this.b;
        if (fa2Var == null) {
            fa2Var = new fa2(this);
            this.b = fa2Var;
        }
        fa2Var.f(p92.ON_RESUME);
    }

    @Override // android.app.Dialog
    public void onStop() {
        fa2 fa2Var = this.b;
        if (fa2Var == null) {
            fa2Var = new fa2(this);
            this.b = fa2Var;
        }
        fa2Var.f(p92.ON_DESTROY);
        this.b = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        view.getClass();
        a();
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        a();
        super.setContentView(i);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        view.getClass();
        a();
        super.setContentView(view, layoutParams);
    }
}
