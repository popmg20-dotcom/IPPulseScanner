package defpackage;

import android.graphics.Matrix;
import android.graphics.Paint;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ko4 extends lo4 {
    public final Matrix a;
    public final ArrayList b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public final Matrix j;
    public String k;

    public ko4(ko4 ko4Var, ie ieVar) {
        mo4 io4Var;
        this.a = new Matrix();
        this.b = new ArrayList();
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 1.0f;
        this.g = 1.0f;
        this.h = 0.0f;
        this.i = 0.0f;
        Matrix matrix = new Matrix();
        this.j = matrix;
        this.k = null;
        this.c = ko4Var.c;
        this.d = ko4Var.d;
        this.e = ko4Var.e;
        this.f = ko4Var.f;
        this.g = ko4Var.g;
        this.h = ko4Var.h;
        this.i = ko4Var.i;
        String str = ko4Var.k;
        this.k = str;
        if (str != null) {
            ieVar.put(str, this);
        }
        matrix.set(ko4Var.j);
        ArrayList arrayList = ko4Var.b;
        for (int i = 0; i < arrayList.size(); i++) {
            Object obj = arrayList.get(i);
            if (obj instanceof ko4) {
                this.b.add(new ko4((ko4) obj, ieVar));
            } else {
                if (obj instanceof jo4) {
                    jo4 jo4Var = (jo4) obj;
                    jo4 jo4Var2 = new jo4(jo4Var);
                    jo4Var2.e = 0.0f;
                    jo4Var2.g = 1.0f;
                    jo4Var2.h = 1.0f;
                    jo4Var2.i = 0.0f;
                    jo4Var2.j = 1.0f;
                    jo4Var2.k = 0.0f;
                    jo4Var2.l = Paint.Cap.BUTT;
                    jo4Var2.m = Paint.Join.MITER;
                    jo4Var2.n = 4.0f;
                    jo4Var2.d = jo4Var.d;
                    jo4Var2.e = jo4Var.e;
                    jo4Var2.g = jo4Var.g;
                    jo4Var2.f = jo4Var.f;
                    jo4Var2.c = jo4Var.c;
                    jo4Var2.h = jo4Var.h;
                    jo4Var2.i = jo4Var.i;
                    jo4Var2.j = jo4Var.j;
                    jo4Var2.k = jo4Var.k;
                    jo4Var2.l = jo4Var.l;
                    jo4Var2.m = jo4Var.m;
                    jo4Var2.n = jo4Var.n;
                    io4Var = jo4Var2;
                } else {
                    if (!(obj instanceof io4)) {
                        xe.q("Unknown object in the tree!");
                        throw null;
                    }
                    io4Var = new io4((io4) obj);
                }
                this.b.add(io4Var);
                Object obj2 = io4Var.b;
                if (obj2 != null) {
                    ieVar.put(obj2, io4Var);
                }
            }
        }
    }

    @Override // defpackage.lo4
    public final boolean a() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.b;
            if (i >= arrayList.size()) {
                return false;
            }
            if (((lo4) arrayList.get(i)).a()) {
                return true;
            }
            i++;
        }
    }

    @Override // defpackage.lo4
    public final boolean b(int[] iArr) {
        int i = 0;
        boolean zB = false;
        while (true) {
            ArrayList arrayList = this.b;
            if (i >= arrayList.size()) {
                return zB;
            }
            zB |= ((lo4) arrayList.get(i)).b(iArr);
            i++;
        }
    }

    public final void c() {
        Matrix matrix = this.j;
        matrix.reset();
        matrix.postTranslate(-this.d, -this.e);
        matrix.postScale(this.f, this.g);
        matrix.postRotate(this.c, 0.0f, 0.0f);
        matrix.postTranslate(this.h + this.d, this.i + this.e);
    }

    public String getGroupName() {
        return this.k;
    }

    public Matrix getLocalMatrix() {
        return this.j;
    }

    public float getPivotX() {
        return this.d;
    }

    public float getPivotY() {
        return this.e;
    }

    public float getRotation() {
        return this.c;
    }

    public float getScaleX() {
        return this.f;
    }

    public float getScaleY() {
        return this.g;
    }

    public float getTranslateX() {
        return this.h;
    }

    public float getTranslateY() {
        return this.i;
    }

    public void setPivotX(float f) {
        if (f != this.d) {
            this.d = f;
            c();
        }
    }

    public void setPivotY(float f) {
        if (f != this.e) {
            this.e = f;
            c();
        }
    }

    public void setRotation(float f) {
        if (f != this.c) {
            this.c = f;
            c();
        }
    }

    public void setScaleX(float f) {
        if (f != this.f) {
            this.f = f;
            c();
        }
    }

    public void setScaleY(float f) {
        if (f != this.g) {
            this.g = f;
            c();
        }
    }

    public void setTranslateX(float f) {
        if (f != this.h) {
            this.h = f;
            c();
        }
    }

    public void setTranslateY(float f) {
        if (f != this.i) {
            this.i = f;
            c();
        }
    }

    public ko4() {
        this.a = new Matrix();
        this.b = new ArrayList();
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 1.0f;
        this.g = 1.0f;
        this.h = 0.0f;
        this.i = 0.0f;
        this.j = new Matrix();
        this.k = null;
    }
}
