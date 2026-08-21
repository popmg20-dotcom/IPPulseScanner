package defpackage;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import io.netty.handler.codec.dns.DnsRecord;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class wi2 extends Drawable.ConstantState {
    public nu3 a;
    public f21 b;
    public ColorStateList c;
    public ColorStateList d;
    public ColorStateList e;
    public PorterDuff.Mode f;
    public Rect g;
    public final float h;
    public float i;
    public float j;
    public int k;
    public float l;
    public float m;
    public int n;
    public int o;
    public int p;
    public final Paint.Style q;

    public wi2(wi2 wi2Var) {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = PorterDuff.Mode.SRC_IN;
        this.g = null;
        this.h = 1.0f;
        this.i = 1.0f;
        this.k = DnsRecord.CLASS_ANY;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = Paint.Style.FILL_AND_STROKE;
        this.a = wi2Var.a;
        this.b = wi2Var.b;
        this.j = wi2Var.j;
        this.c = wi2Var.c;
        this.d = wi2Var.d;
        this.f = wi2Var.f;
        this.e = wi2Var.e;
        this.k = wi2Var.k;
        this.h = wi2Var.h;
        this.p = wi2Var.p;
        this.n = wi2Var.n;
        this.i = wi2Var.i;
        this.l = wi2Var.l;
        this.m = wi2Var.m;
        this.o = wi2Var.o;
        this.q = wi2Var.q;
        if (wi2Var.g != null) {
            this.g = new Rect(wi2Var.g);
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        yi2 yi2Var = new yi2(this);
        yi2Var.Y = true;
        yi2Var.Z = true;
        return yi2Var;
    }

    public wi2(nu3 nu3Var) {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = PorterDuff.Mode.SRC_IN;
        this.g = null;
        this.h = 1.0f;
        this.i = 1.0f;
        this.k = DnsRecord.CLASS_ANY;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = Paint.Style.FILL_AND_STROKE;
        this.a = nu3Var;
        this.b = null;
    }
}
