package defpackage;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import java.util.ArrayList;
import java.util.Iterator;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xk extends Property {
    public final /* synthetic */ int a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ xk(int i, Class cls, String str) {
        super(cls, str);
        this.a = i;
    }

    @Override // android.util.Property
    public final Object get(Object obj) {
        switch (this.a) {
            case 0:
                int iAlpha = Color.alpha(((ExtendedFloatingActionButton) obj).getCurrentOriginalTextColor());
                return Float.valueOf(iAlpha != 0 ? Color.alpha(r2.getCurrentTextColor()) / iAlpha : 0.0f);
            case 1:
                return null;
            case 2:
                return null;
            case 3:
                return null;
            case 4:
                return null;
            case 5:
                return null;
            case 6:
                return Float.valueOf(((a50) obj).h);
            case 7:
                return Float.valueOf(((a50) obj).i);
            case 8:
                return Float.valueOf(((c50) obj).h);
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return Float.valueOf(((c50) obj).i);
            case 10:
                return Float.valueOf(((vx0) obj).b());
            case 11:
                return Float.valueOf(((View) obj).getLayoutParams().width);
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return Float.valueOf(((View) obj).getLayoutParams().height);
            case 13:
                return Float.valueOf(((View) obj).getPaddingStart());
            case 14:
                return Float.valueOf(((View) obj).getPaddingEnd());
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                return Float.valueOf(((wa2) obj).h);
            case 16:
                return Float.valueOf(((ya2) obj).i);
            case 17:
                return Float.valueOf(((ld2) obj).b);
            case 18:
                return Float.valueOf(((SwitchCompat) obj).T0);
            case 19:
                return Float.valueOf(or4.a.B((View) obj));
            default:
                return ((View) obj).getClipBounds();
        }
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        float f = 90.0f;
        switch (this.a) {
            case 0:
                ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) obj;
                Float f2 = (Float) obj2;
                if (f2.floatValue() == 1.0f) {
                    extendedFloatingActionButton.w(extendedFloatingActionButton.getOriginalTextColor());
                } else {
                    extendedFloatingActionButton.w(ColorStateList.valueOf(u70.e(extendedFloatingActionButton.getCurrentOriginalTextColor(), Math.round(t8.a(0.0f, Color.alpha(r2), f2.floatValue())))));
                }
                break;
            case 1:
                v20 v20Var = (v20) obj;
                PointF pointF = (PointF) obj2;
                v20Var.getClass();
                v20Var.a = Math.round(pointF.x);
                int iRound = Math.round(pointF.y);
                v20Var.b = iRound;
                int i = v20Var.f + 1;
                v20Var.f = i;
                if (i == v20Var.g) {
                    or4.a(v20Var.e, v20Var.a, iRound, v20Var.c, v20Var.d);
                    v20Var.f = 0;
                    v20Var.g = 0;
                }
                break;
            case 2:
                v20 v20Var2 = (v20) obj;
                PointF pointF2 = (PointF) obj2;
                v20Var2.getClass();
                v20Var2.c = Math.round(pointF2.x);
                int iRound2 = Math.round(pointF2.y);
                v20Var2.d = iRound2;
                int i2 = v20Var2.g + 1;
                v20Var2.g = i2;
                if (v20Var2.f == i2) {
                    or4.a(v20Var2.e, v20Var2.a, v20Var2.b, v20Var2.c, iRound2);
                    v20Var2.f = 0;
                    v20Var2.g = 0;
                }
                break;
            case 3:
                View view = (View) obj;
                PointF pointF3 = (PointF) obj2;
                or4.a(view, view.getLeft(), view.getTop(), Math.round(pointF3.x), Math.round(pointF3.y));
                break;
            case 4:
                View view2 = (View) obj;
                PointF pointF4 = (PointF) obj2;
                or4.a(view2, Math.round(pointF4.x), Math.round(pointF4.y), view2.getRight(), view2.getBottom());
                break;
            case 5:
                View view3 = (View) obj;
                PointF pointF5 = (PointF) obj2;
                int iRound3 = Math.round(pointF5.x);
                int iRound4 = Math.round(pointF5.y);
                or4.a(view3, iRound3, iRound4, view3.getWidth() + iRound3, view3.getHeight() + iRound4);
                break;
            case 6:
                a50 a50Var = (a50) obj;
                float fFloatValue = ((Float) obj2).floatValue();
                a50Var.h = fFloatValue;
                int i3 = (int) (fFloatValue * 5400.0f);
                ub1 ub1Var = a50Var.e;
                ArrayList arrayList = (ArrayList) a50Var.b;
                yx0 yx0Var = (yx0) arrayList.get(0);
                float f3 = a50Var.h * 1520.0f;
                yx0Var.a = (-20.0f) + f3;
                yx0Var.b = f3;
                for (int i4 = 0; i4 < 4; i4++) {
                    yx0Var.b = (ub1Var.getInterpolation(m0.k(i3, a50.k[i4], 667)) * 250.0f) + yx0Var.b;
                    yx0Var.a = (ub1Var.getInterpolation(m0.k(i3, a50.l[i4], 667)) * 250.0f) + yx0Var.a;
                }
                float f4 = yx0Var.a;
                float f5 = yx0Var.b;
                yx0Var.a = (((f5 - f4) * a50Var.i) + f4) / 360.0f;
                yx0Var.b = f5 / 360.0f;
                int i5 = 0;
                while (true) {
                    if (i5 < 4) {
                        float fK = m0.k(i3, a50.m[i5], 333);
                        if (fK <= 0.0f || fK >= 1.0f) {
                            i5++;
                        } else {
                            int i6 = i5 + a50Var.g;
                            int[] iArr = a50Var.f.e;
                            int length = i6 % iArr.length;
                            int length2 = (length + 1) % iArr.length;
                            ((yx0) arrayList.get(0)).c = ud.a(ub1Var.getInterpolation(fK), Integer.valueOf(iArr[length]), Integer.valueOf(iArr[length2])).intValue();
                        }
                    }
                }
                ((rz1) a50Var.a).invalidateSelf();
                break;
            case 7:
                ((a50) obj).i = ((Float) obj2).floatValue();
                break;
            case 8:
                c50 c50Var = (c50) obj;
                float fFloatValue2 = ((Float) obj2).floatValue();
                c50Var.h = fFloatValue2;
                int i7 = (int) (fFloatValue2 * 6000.0f);
                TimeInterpolator timeInterpolator = c50Var.e;
                ArrayList arrayList2 = (ArrayList) c50Var.b;
                yx0 yx0Var2 = (yx0) arrayList2.get(0);
                float f6 = c50Var.h * 1080.0f;
                int[] iArr2 = c50.l;
                int length3 = iArr2.length;
                int i8 = 0;
                float interpolation = 0.0f;
                while (i8 < length3) {
                    float f7 = f;
                    interpolation += timeInterpolator.getInterpolation(m0.k(i7, iArr2[i8], 500)) * f7;
                    i8++;
                    f = f7;
                }
                yx0Var2.g = f6 + interpolation;
                float interpolation2 = timeInterpolator.getInterpolation(m0.k(i7, 0, 3000)) - timeInterpolator.getInterpolation(m0.k(i7, 3000, 3000));
                yx0Var2.a = 0.0f;
                float[] fArr = c50.m;
                float fS = fx3.s(fArr[0], fArr[1], interpolation2);
                yx0Var2.b = fS;
                float f8 = c50Var.i;
                if (f8 > 0.0f) {
                    yx0Var2.b = (1.0f - f8) * fS;
                }
                int i9 = 0;
                while (true) {
                    if (i9 < iArr2.length) {
                        float fK2 = m0.k(i7, iArr2[i9], 100);
                        if (fK2 < 0.0f || fK2 > 1.0f) {
                            i9++;
                        } else {
                            int i10 = i9 + c50Var.g;
                            int[] iArr3 = c50Var.f.e;
                            int length4 = i10 % iArr3.length;
                            int length5 = (length4 + 1) % iArr3.length;
                            ((yx0) arrayList2.get(0)).c = ud.a(timeInterpolator.getInterpolation(fK2), Integer.valueOf(iArr3[length4]), Integer.valueOf(iArr3[length5])).intValue();
                        }
                    }
                }
                ((rz1) c50Var.a).invalidateSelf();
                break;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                ((c50) obj).i = ((Float) obj2).floatValue();
                break;
            case 10:
                vx0 vx0Var = (vx0) obj;
                float fFloatValue3 = ((Float) obj2).floatValue();
                if (vx0Var.z0 != fFloatValue3) {
                    vx0Var.z0 = fFloatValue3;
                    vx0Var.invalidateSelf();
                }
                break;
            case 11:
                View view4 = (View) obj;
                view4.getLayoutParams().width = ((Float) obj2).intValue();
                view4.requestLayout();
                break;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                View view5 = (View) obj;
                view5.getLayoutParams().height = ((Float) obj2).intValue();
                view5.requestLayout();
                break;
            case 13:
                View view6 = (View) obj;
                view6.setPaddingRelative(((Float) obj2).intValue(), view6.getPaddingTop(), view6.getPaddingEnd(), view6.getPaddingBottom());
                break;
            case 14:
                View view7 = (View) obj;
                view7.setPaddingRelative(view7.getPaddingStart(), view7.getPaddingTop(), ((Float) obj2).intValue(), view7.getPaddingBottom());
                break;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                wa2 wa2Var = (wa2) obj;
                float fFloatValue4 = ((Float) obj2).floatValue();
                wa2Var.h = fFloatValue4;
                ArrayList arrayList3 = (ArrayList) wa2Var.b;
                ((yx0) arrayList3.get(0)).a = 0.0f;
                float fK3 = m0.k((int) (fFloatValue4 * 333.0f), 0, 667);
                yx0 yx0Var3 = (yx0) arrayList3.get(0);
                yx0 yx0Var4 = (yx0) arrayList3.get(1);
                ub1 ub1Var2 = wa2Var.d;
                float interpolation3 = ub1Var2.getInterpolation(fK3);
                yx0Var4.a = interpolation3;
                yx0Var3.b = interpolation3;
                yx0 yx0Var5 = (yx0) arrayList3.get(1);
                yx0 yx0Var6 = (yx0) arrayList3.get(2);
                float interpolation4 = ub1Var2.getInterpolation(fK3 + 0.49925038f);
                yx0Var6.a = interpolation4;
                yx0Var5.b = interpolation4;
                ((yx0) arrayList3.get(2)).b = 1.0f;
                if (wa2Var.g && ((yx0) arrayList3.get(1)).b < 1.0f) {
                    ((yx0) arrayList3.get(2)).c = ((yx0) arrayList3.get(1)).c;
                    ((yx0) arrayList3.get(1)).c = ((yx0) arrayList3.get(0)).c;
                    ((yx0) arrayList3.get(0)).c = wa2Var.e.e[wa2Var.f];
                    wa2Var.g = false;
                }
                ((rz1) wa2Var.a).invalidateSelf();
                break;
            case 16:
                ya2 ya2Var = (ya2) obj;
                float fFloatValue5 = ((Float) obj2).floatValue();
                ya2Var.i = fFloatValue5;
                int i11 = (int) (fFloatValue5 * 1800.0f);
                Interpolator[] interpolatorArr = ya2Var.e;
                ArrayList arrayList4 = (ArrayList) ya2Var.b;
                for (int i12 = 0; i12 < arrayList4.size(); i12++) {
                    yx0 yx0Var7 = (yx0) arrayList4.get(i12);
                    int[] iArr4 = ya2.l;
                    int i13 = i12 * 2;
                    int i14 = iArr4[i13];
                    int[] iArr5 = ya2.k;
                    yx0Var7.a = tj4.l(interpolatorArr[i13].getInterpolation(m0.k(i11, i14, iArr5[i13])), 0.0f, 1.0f);
                    int i15 = i13 + 1;
                    yx0Var7.b = tj4.l(interpolatorArr[i15].getInterpolation(m0.k(i11, iArr4[i15], iArr5[i15])), 0.0f, 1.0f);
                }
                if (ya2Var.h) {
                    Iterator it = arrayList4.iterator();
                    while (it.hasNext()) {
                        ((yx0) it.next()).c = ya2Var.f.e[ya2Var.g];
                    }
                    ya2Var.h = false;
                }
                ((rz1) ya2Var.a).invalidateSelf();
                break;
            case 17:
                ld2 ld2Var = (ld2) obj;
                ld2Var.b = ((Float) obj2).floatValue();
                float f9 = ld2Var.a - 1;
                float f10 = ((int) (r1 * 650.0f)) / 650.0f;
                ld2Var.h.c = (((ld2Var.c - f9) * 90.0f) + (((f10 != 1.0f ? f10 : 0.0f) * 50.0f) + (f9 * 140.0f))) % 360.0f;
                md2 md2Var = ld2Var.g;
                if (md2Var != null) {
                    md2Var.invalidateSelf();
                }
                break;
            case 18:
                ((SwitchCompat) obj).setThumbPosition(((Float) obj2).floatValue());
                break;
            case 19:
                or4.a.V((View) obj, ((Float) obj2).floatValue());
                break;
            default:
                ((View) obj).setClipBounds((Rect) obj2);
                break;
        }
    }
}
