package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.getsurfboard.R;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class bb extends l90 implements ea {
    public za X;
    public final ab Y;

    /* JADX WARN: Type inference failed for: r2v2, types: [ab] */
    public bb(Context context, int i) {
        int i2;
        if (i == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue, true);
            i2 = typedValue.resourceId;
        } else {
            i2 = i;
        }
        super(context, i2);
        this.Y = new h82() { // from class: ab
            @Override // defpackage.h82
            public final boolean k(KeyEvent keyEvent) {
                return this.b.e(keyEvent);
            }
        };
        ma maVarD = d();
        if (i == 0) {
            TypedValue typedValue2 = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue2, true);
            i = typedValue2.resourceId;
        }
        ((za) maVarD).j1 = i;
        maVarD.f();
    }

    @Override // defpackage.l90, android.app.Dialog
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a();
        za zaVar = (za) d();
        zaVar.z();
        ((ViewGroup) zaVar.Q0.findViewById(android.R.id.content)).addView(view, layoutParams);
        zaVar.D0.a(zaVar.C0.getCallback());
    }

    public final ma d() {
        za zaVar = this.X;
        if (zaVar != null) {
            return zaVar;
        }
        la laVar = ma.b;
        za zaVar2 = new za(getContext(), getWindow(), this, this);
        this.X = zaVar2;
        return zaVar2;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        d().g();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return ji0.m(this.Y, getWindow().getDecorView(), this, keyEvent);
    }

    public final boolean e(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog
    public final View findViewById(int i) {
        za zaVar = (za) d();
        zaVar.z();
        return zaVar.C0.findViewById(i);
    }

    @Override // android.app.Dialog
    public final void invalidateOptionsMenu() {
        d().d();
    }

    @Override // defpackage.l90, android.app.Dialog
    public void onCreate(Bundle bundle) {
        d().c();
        super.onCreate(bundle);
        d().f();
    }

    @Override // defpackage.l90, android.app.Dialog
    public final void onStop() {
        super.onStop();
        za zaVar = (za) d();
        zaVar.E();
        tj4 tj4Var = zaVar.E0;
        if (tj4Var != null) {
            tj4Var.b0(false);
        }
    }

    @Override // defpackage.l90, android.app.Dialog
    public void setContentView(int i) {
        a();
        d().k(i);
    }

    @Override // android.app.Dialog
    public final void setTitle(int i) {
        super.setTitle(i);
        d().o(getContext().getString(i));
    }

    @Override // defpackage.l90, android.app.Dialog
    public void setContentView(View view) {
        a();
        d().l(view);
    }

    @Override // defpackage.l90, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a();
        d().m(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        d().o(charSequence);
    }
}
