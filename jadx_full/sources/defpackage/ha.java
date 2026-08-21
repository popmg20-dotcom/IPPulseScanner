package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.TextView;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ha {
    public final /* synthetic */ int a;
    public Object b;
    public Serializable c;
    public boolean d;
    public boolean e;
    public boolean f;
    public final Object g;

    public ha(Object obj, ha haVar, p83 p83Var, boolean z, boolean z2, boolean z3) {
        this.a = 2;
        this.g = obj;
        this.b = haVar;
        p83 p83Var2 = (p83Var == null || p83Var.c()) ? null : p83Var;
        this.c = p83Var2;
        if (z) {
            if (p83Var2 == null) {
                xe.k("Cannot pass true for 'explName' if name is null/empty");
                throw null;
            }
            if (p83Var.b.isEmpty()) {
                z = false;
            }
        }
        this.d = z;
        this.e = z2;
        this.f = z3;
    }

    public ha a(ha haVar) {
        ha haVar2 = (ha) this.b;
        return haVar2 == null ? f(haVar) : f(haVar2.a(haVar));
    }

    public void b() {
        CompoundButton compoundButton = (CompoundButton) this.g;
        Drawable buttonDrawable = compoundButton.getButtonDrawable();
        if (buttonDrawable != null) {
            if (this.d || this.e) {
                Drawable drawableMutate = buttonDrawable.mutate();
                if (this.d) {
                    drawableMutate.setTintList((ColorStateList) this.b);
                }
                if (this.e) {
                    drawableMutate.setTintMode((PorterDuff.Mode) this.c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(compoundButton.getDrawableState());
                }
                compoundButton.setButtonDrawable(drawableMutate);
            }
        }
    }

    public void c() {
        ga gaVar = (ga) this.g;
        Drawable checkMarkDrawable = gaVar.getCheckMarkDrawable();
        if (checkMarkDrawable != null) {
            if (this.d || this.e) {
                Drawable drawableMutate = checkMarkDrawable.mutate();
                if (this.d) {
                    drawableMutate.setTintList((ColorStateList) this.b);
                }
                if (this.e) {
                    drawableMutate.setTintMode((PorterDuff.Mode) this.c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(gaVar.getDrawableState());
                }
                gaVar.setCheckMarkDrawable(drawableMutate);
            }
        }
    }

    public void d(AttributeSet attributeSet, int i) {
        int resourceId;
        int resourceId2;
        CompoundButton compoundButton = (CompoundButton) this.g;
        Context context = compoundButton.getContext();
        int[] iArr = cd3.m;
        n02 n02VarY = n02.y(context, attributeSet, iArr, i);
        TypedArray typedArray = (TypedArray) n02VarY.z;
        wp4.m(compoundButton, compoundButton.getContext(), iArr, attributeSet, (TypedArray) n02VarY.z, i);
        try {
            if (typedArray.hasValue(1) && (resourceId2 = typedArray.getResourceId(1, 0)) != 0) {
                try {
                    compoundButton.setButtonDrawable(vo.r(compoundButton.getContext(), resourceId2));
                } catch (Resources.NotFoundException unused) {
                    if (typedArray.hasValue(0)) {
                        compoundButton.setButtonDrawable(vo.r(compoundButton.getContext(), resourceId));
                    }
                }
            } else if (typedArray.hasValue(0) && (resourceId = typedArray.getResourceId(0, 0)) != 0) {
                compoundButton.setButtonDrawable(vo.r(compoundButton.getContext(), resourceId));
            }
            if (typedArray.hasValue(2)) {
                compoundButton.setButtonTintList(n02VarY.n(2));
            }
            if (typedArray.hasValue(3)) {
                compoundButton.setButtonTintMode(tx0.c(typedArray.getInt(3, -1), null));
            }
            n02VarY.K();
        } catch (Throwable th) {
            n02VarY.K();
            throw th;
        }
    }

    public ha e() {
        ha haVar = (ha) this.b;
        if (haVar == null) {
            return this;
        }
        ha haVarE = haVar.e();
        if (((p83) this.c) != null) {
            return ((p83) haVarE.c) == null ? f(null) : f(haVarE);
        }
        if (((p83) haVarE.c) == null) {
            boolean z = this.e;
            if (z == haVarE.e) {
                return f(haVarE);
            }
            if (z) {
                return f(null);
            }
        }
        return haVarE;
    }

    public ha f(ha haVar) {
        if (haVar == ((ha) this.b)) {
            return this;
        }
        return new ha(this.g, haVar, (p83) this.c, this.d, this.e, this.f);
    }

    public ha g() {
        ha haVarG;
        boolean z = this.f;
        ha haVar = (ha) this.b;
        if (!z) {
            return (haVar == null || (haVarG = haVar.g()) == haVar) ? this : f(haVarG);
        }
        if (haVar == null) {
            return null;
        }
        return haVar.g();
    }

    public ha h() {
        if (((ha) this.b) == null) {
            return this;
        }
        return new ha(this.g, null, (p83) this.c, this.d, this.e, this.f);
    }

    public ha i() {
        ha haVar = (ha) this.b;
        ha haVarI = haVar == null ? null : haVar.i();
        return this.e ? f(haVarI) : haVarI;
    }

    public String toString() {
        switch (this.a) {
            case 2:
                String str = this.g.toString() + "[visible=" + this.e + ",ignore=" + this.f + ",explicitName=" + this.d + "]";
                ha haVar = (ha) this.b;
                if (haVar == null) {
                    return str;
                }
                StringBuilder sbQ = ha0.q(str, ", ");
                sbQ.append(haVar.toString());
                return sbQ.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ ha(TextView textView, int i) {
        this.a = i;
        this.b = null;
        this.c = null;
        this.d = false;
        this.e = false;
        this.g = textView;
    }
}
