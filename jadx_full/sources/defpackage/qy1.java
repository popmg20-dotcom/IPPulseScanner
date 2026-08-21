package defpackage;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.widget.ImageView;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qy1 {
    public Object a;
    public Object b;
    public Object c;
    public Object d;
    public Object e;
    public Object f;
    public Object g;
    public Object h;
    public Object i;
    public Object j;
    public Object k;
    public Object l;

    public qy1() {
        this.a = new cm3();
        this.b = new cm3();
        this.c = new cm3();
        this.d = new cm3();
        this.e = new a0(0.0f);
        this.f = new a0(0.0f);
        this.g = new a0(0.0f);
        this.h = new a0(0.0f);
        int i = 0;
        this.i = new k01(i);
        this.j = new k01(i);
        this.k = new k01(i);
        this.l = new k01(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x012c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ry1 a() {
        ImageView.ScaleType scaleType;
        Context context = (Context) this.a;
        Object obj = this.c;
        if (obj == null) {
            obj = d7.y0;
        }
        Object obj2 = obj;
        ty1 ty1Var = (ty1) this.d;
        em0 em0Var = (em0) this.b;
        Bitmap.Config config = em0Var.e;
        em0Var.getClass();
        qg4 qg4Var = (qg4) this.e;
        if (qg4Var == null) {
            ((em0) this.b).getClass();
            qg4Var = qg4.a;
        }
        qg4 qg4Var2 = qg4Var;
        m20 m20Var = (m20) this.f;
        lr1 lr1VarY = m20Var != null ? gb4.y(m20Var) : null;
        if (lr1VarY == null) {
            lr1VarY = j.b;
        } else {
            Bitmap.Config config2 = j.a;
        }
        lr1 lr1Var = lr1VarY;
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.g;
        ra4 ra4Var = linkedHashMap != null ? new ra4(ke0.I(linkedHashMap)) : null;
        if (ra4Var == null) {
            ra4Var = ra4.b;
        }
        ra4 ra4Var2 = ra4Var;
        ((em0) this.b).getClass();
        ((em0) this.b).getClass();
        ((em0) this.b).getClass();
        ((em0) this.b).getClass();
        ((em0) this.b).getClass();
        em0 em0Var2 = (em0) this.b;
        ef0 ef0Var = em0Var2.a;
        ef0 ef0Var2 = em0Var2.b;
        ef0 ef0Var3 = em0Var2.c;
        ef0 ef0Var4 = em0Var2.d;
        r92 lifecycle = (r92) this.j;
        if (lifecycle == null) {
            ty1 ty1Var2 = (ty1) this.d;
            Object context2 = ty1Var2 instanceof ty1 ? ty1Var2.f.getContext() : context;
            while (true) {
                if (context2 instanceof da2) {
                    lifecycle = ((da2) context2).getLifecycle();
                    break;
                }
                if (!(context2 instanceof ContextWrapper)) {
                    lifecycle = null;
                    break;
                }
                context2 = ((ContextWrapper) context2).getBaseContext();
            }
            if (lifecycle == null) {
                lifecycle = ep1.b;
            }
        }
        r92 r92Var = lifecycle;
        xx3 wv0Var = (xx3) this.k;
        if (wv0Var == null) {
            ty1 ty1Var3 = (ty1) this.d;
            if (ty1Var3 instanceof ty1) {
                ImageView imageView = ty1Var3.f;
                if (imageView == null || !((scaleType = imageView.getScaleType()) == ImageView.ScaleType.CENTER || scaleType == ImageView.ScaleType.MATRIX)) {
                    wv0Var = new cf3(imageView);
                } else {
                    wx3 wx3Var = wx3.c;
                    wv0Var = new ze3();
                }
            } else {
                wv0Var = new wv0(context);
            }
        }
        xx3 xx3Var = wv0Var;
        sp3 sp3Var = (sp3) this.l;
        if (sp3Var == null) {
            ty1 ty1Var4 = (ty1) this.d;
            if (!(ty1Var4 instanceof ty1)) {
                ty1Var4 = null;
            }
            ImageView imageView2 = ty1Var4 != null ? ty1Var4.f : null;
            boolean z = imageView2 instanceof ImageView;
            sp3 sp3Var2 = sp3.f;
            if (z) {
                Bitmap.Config config3 = j.a;
                ImageView.ScaleType scaleType2 = imageView2.getScaleType();
                int i = scaleType2 == null ? -1 : i.a[scaleType2.ordinal()];
                sp3Var = (i == 1 || i == 2 || i == 3 || i == 4) ? sp3Var2 : sp3.b;
            }
        }
        sp3 sp3Var3 = sp3Var;
        jf2 jf2Var = (jf2) this.h;
        i03 i03Var = jf2Var != null ? new i03(ke0.I(jf2Var.a)) : null;
        if (i03Var == null) {
            i03Var = i03.f;
        }
        i03 i03Var2 = i03Var;
        Integer num = (Integer) this.i;
        jn0 jn0Var = new jn0((qg4) this.e);
        em0 em0Var3 = (em0) this.b;
        m23 m23Var = m23.b;
        mu muVar = mu.ENABLED;
        return new ry1(context, obj2, ty1Var, config, m23Var, qg4Var2, lr1Var, ra4Var2, true, false, muVar, muVar, muVar, ef0Var, ef0Var2, ef0Var3, ef0Var4, r92Var, xx3Var, sp3Var3, i03Var2, num, jn0Var, em0Var3);
    }

    public ou3 b() {
        ou3 ou3Var = new ou3();
        ou3Var.a = (fx3) this.a;
        ou3Var.b = (fx3) this.b;
        ou3Var.c = (fx3) this.c;
        ou3Var.d = (fx3) this.d;
        ou3Var.e = (ye0) this.e;
        ou3Var.f = (ye0) this.f;
        ou3Var.g = (ye0) this.g;
        ou3Var.h = (ye0) this.h;
        ou3Var.i = (k01) this.i;
        ou3Var.j = (k01) this.j;
        ou3Var.k = (k01) this.k;
        ou3Var.l = (k01) this.l;
        return ou3Var;
    }

    public void c() {
        this.e = new gg0(100);
    }

    public void d(ImageView imageView) {
        this.d = new ty1(imageView);
        this.j = null;
        this.k = null;
        this.l = null;
    }

    public qy1(Context context) {
        this.a = context;
        this.b = h.a;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
    }
}
