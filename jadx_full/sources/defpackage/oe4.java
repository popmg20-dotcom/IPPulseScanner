package defpackage;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.Toast;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class oe4 extends Toast {
    public static final /* synthetic */ int b = 0;
    public final Toast a;

    public oe4(Context context, Toast toast) {
        super(context);
        this.a = toast;
    }

    public static void a(View view, xo3 xo3Var) {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                Field declaredField = View.class.getDeclaredField("mContext");
                declaredField.setAccessible(true);
                declaredField.set(view, xo3Var);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // android.widget.Toast
    public final int getDuration() {
        return this.a.getDuration();
    }

    @Override // android.widget.Toast
    public final int getGravity() {
        return this.a.getGravity();
    }

    @Override // android.widget.Toast
    public final float getHorizontalMargin() {
        return this.a.getHorizontalMargin();
    }

    @Override // android.widget.Toast
    public final float getVerticalMargin() {
        return this.a.getVerticalMargin();
    }

    @Override // android.widget.Toast
    public final View getView() {
        return this.a.getView();
    }

    @Override // android.widget.Toast
    public final int getXOffset() {
        return this.a.getXOffset();
    }

    @Override // android.widget.Toast
    public final int getYOffset() {
        return this.a.getYOffset();
    }

    @Override // android.widget.Toast
    public final void setDuration(int i) {
        this.a.setDuration(i);
    }

    @Override // android.widget.Toast
    public final void setGravity(int i, int i2, int i3) {
        this.a.setGravity(i, i2, i3);
    }

    @Override // android.widget.Toast
    public final void setMargin(float f, float f2) {
        this.a.setMargin(f, f2);
    }

    @Override // android.widget.Toast
    public final void setText(int i) {
        this.a.setText(i);
    }

    @Override // android.widget.Toast
    public final void setView(View view) {
        this.a.setView(view);
        a(view, new xo3(view.getContext()));
    }

    @Override // android.widget.Toast
    public final void show() {
        this.a.show();
    }

    @Override // android.widget.Toast
    public final void setText(CharSequence charSequence) {
        this.a.setText(charSequence);
    }
}
