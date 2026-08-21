package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mars.xlog.Xlog;
import defpackage.ac0;
import defpackage.dp4;
import defpackage.ed4;
import defpackage.fw;
import defpackage.gb2;
import defpackage.ha0;
import defpackage.jc0;
import defpackage.kc0;
import defpackage.ks1;
import defpackage.lb;
import defpackage.mb0;
import defpackage.nc0;
import defpackage.no0;
import defpackage.nq1;
import defpackage.nt4;
import defpackage.ob0;
import defpackage.oq1;
import defpackage.pb0;
import defpackage.q20;
import defpackage.qb0;
import defpackage.rb0;
import defpackage.sb0;
import defpackage.tb0;
import defpackage.uv3;
import defpackage.vb0;
import defpackage.vj;
import defpackage.wb0;
import defpackage.wc3;
import defpackage.wj;
import defpackage.yb0;
import defpackage.ye;
import defpackage.zb0;
import defpackage.zo2;
import io.netty.channel.internal.ChannelUtils;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.netty.handler.ssl.OpenSslSessionTicketKey;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import io.sentry.android.core.a1;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.conscrypt.FileClientSessionCache;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {
    public static uv3 J0;
    public int A;
    public int A0;
    public boolean B0;
    public int C0;
    public ac0 D0;
    public lb E0;
    public int F0;
    public HashMap G0;
    public final SparseArray H0;
    public final rb0 I0;
    public final SparseArray b;
    public final ArrayList f;
    public int y0;
    public final kc0 z;
    public int z0;

    public ConstraintLayout(Context context) {
        super(context);
        this.b = new SparseArray();
        this.f = new ArrayList(4);
        this.z = new kc0();
        this.A = 0;
        this.y0 = 0;
        this.z0 = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
        this.A0 = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
        this.B0 = true;
        this.C0 = 257;
        this.D0 = null;
        this.E0 = null;
        this.F0 = -1;
        this.G0 = new HashMap();
        this.H0 = new SparseArray();
        this.I0 = new rb0(this, this);
        i(null);
    }

    public static qb0 g() {
        qb0 qb0Var = new qb0(-2, -2);
        qb0Var.a = -1;
        qb0Var.b = -1;
        qb0Var.c = -1.0f;
        qb0Var.d = true;
        qb0Var.e = -1;
        qb0Var.f = -1;
        qb0Var.g = -1;
        qb0Var.h = -1;
        qb0Var.i = -1;
        qb0Var.j = -1;
        qb0Var.k = -1;
        qb0Var.l = -1;
        qb0Var.m = -1;
        qb0Var.n = -1;
        qb0Var.o = -1;
        qb0Var.p = -1;
        qb0Var.q = 0;
        qb0Var.r = 0.0f;
        qb0Var.s = -1;
        qb0Var.t = -1;
        qb0Var.u = -1;
        qb0Var.v = -1;
        qb0Var.w = Integer.MIN_VALUE;
        qb0Var.x = Integer.MIN_VALUE;
        qb0Var.y = Integer.MIN_VALUE;
        qb0Var.z = Integer.MIN_VALUE;
        qb0Var.A = Integer.MIN_VALUE;
        qb0Var.B = Integer.MIN_VALUE;
        qb0Var.C = Integer.MIN_VALUE;
        qb0Var.D = 0;
        qb0Var.E = 0.5f;
        qb0Var.F = 0.5f;
        qb0Var.G = null;
        qb0Var.H = -1.0f;
        qb0Var.I = -1.0f;
        qb0Var.J = 0;
        qb0Var.K = 0;
        qb0Var.L = 0;
        qb0Var.M = 0;
        qb0Var.N = 0;
        qb0Var.O = 0;
        qb0Var.P = 0;
        qb0Var.Q = 0;
        qb0Var.R = 1.0f;
        qb0Var.S = 1.0f;
        qb0Var.T = -1;
        qb0Var.U = -1;
        qb0Var.V = -1;
        qb0Var.W = false;
        qb0Var.X = false;
        qb0Var.Y = null;
        qb0Var.Z = 0;
        qb0Var.a0 = true;
        qb0Var.b0 = true;
        qb0Var.c0 = false;
        qb0Var.d0 = false;
        qb0Var.e0 = false;
        qb0Var.f0 = -1;
        qb0Var.g0 = -1;
        qb0Var.h0 = -1;
        qb0Var.i0 = -1;
        qb0Var.j0 = Integer.MIN_VALUE;
        qb0Var.k0 = Integer.MIN_VALUE;
        qb0Var.l0 = 0.5f;
        qb0Var.p0 = new jc0();
        return qb0Var;
    }

    private int getPaddingWidth() {
        int iMax = Math.max(0, getPaddingRight()) + Math.max(0, getPaddingLeft());
        int iMax2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        return iMax2 > 0 ? iMax2 : iMax;
    }

    public static uv3 getSharedValues() {
        uv3 uv3Var = J0;
        if (uv3Var != null) {
            return uv3Var;
        }
        uv3 uv3Var2 = new uv3();
        new SparseIntArray();
        new HashMap();
        J0 = uv3Var2;
        return uv3Var2;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof qb0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList arrayList = this.f;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i = 0; i < size; i++) {
                ((ob0) arrayList.get(i)).getClass();
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(",");
                    if (strArrSplit.length == 4) {
                        int i3 = Integer.parseInt(strArrSplit[0]);
                        int i4 = Integer.parseInt(strArrSplit[1]);
                        int i5 = Integer.parseInt(strArrSplit[2]);
                        int i6 = (int) ((i3 / 1080.0f) * width);
                        int i7 = (int) ((i4 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f = i6;
                        float f2 = i7;
                        float f3 = i6 + ((int) ((i5 / 1080.0f) * width));
                        canvas.drawLine(f, f2, f3, f2, paint);
                        float f4 = i7 + ((int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height));
                        canvas.drawLine(f3, f2, f3, f4, paint);
                        canvas.drawLine(f3, f4, f, f4, paint);
                        canvas.drawLine(f, f4, f, f2, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f, f2, f3, f4, paint);
                        canvas.drawLine(f, f4, f3, f2, paint);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public final void forceLayout() {
        this.B0 = true;
        super.forceLayout();
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return g();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        qb0 qb0Var = new qb0(context, attributeSet);
        qb0Var.a = -1;
        qb0Var.b = -1;
        qb0Var.c = -1.0f;
        qb0Var.d = true;
        qb0Var.e = -1;
        qb0Var.f = -1;
        qb0Var.g = -1;
        qb0Var.h = -1;
        qb0Var.i = -1;
        qb0Var.j = -1;
        qb0Var.k = -1;
        qb0Var.l = -1;
        qb0Var.m = -1;
        qb0Var.n = -1;
        qb0Var.o = -1;
        qb0Var.p = -1;
        qb0Var.q = 0;
        qb0Var.r = 0.0f;
        qb0Var.s = -1;
        qb0Var.t = -1;
        qb0Var.u = -1;
        qb0Var.v = -1;
        qb0Var.w = Integer.MIN_VALUE;
        qb0Var.x = Integer.MIN_VALUE;
        qb0Var.y = Integer.MIN_VALUE;
        qb0Var.z = Integer.MIN_VALUE;
        qb0Var.A = Integer.MIN_VALUE;
        qb0Var.B = Integer.MIN_VALUE;
        qb0Var.C = Integer.MIN_VALUE;
        qb0Var.D = 0;
        qb0Var.E = 0.5f;
        qb0Var.F = 0.5f;
        qb0Var.G = null;
        qb0Var.H = -1.0f;
        qb0Var.I = -1.0f;
        qb0Var.J = 0;
        qb0Var.K = 0;
        qb0Var.L = 0;
        qb0Var.M = 0;
        qb0Var.N = 0;
        qb0Var.O = 0;
        qb0Var.P = 0;
        qb0Var.Q = 0;
        qb0Var.R = 1.0f;
        qb0Var.S = 1.0f;
        qb0Var.T = -1;
        qb0Var.U = -1;
        qb0Var.V = -1;
        qb0Var.W = false;
        qb0Var.X = false;
        qb0Var.Y = null;
        qb0Var.Z = 0;
        qb0Var.a0 = true;
        qb0Var.b0 = true;
        qb0Var.c0 = false;
        qb0Var.d0 = false;
        qb0Var.e0 = false;
        qb0Var.f0 = -1;
        qb0Var.g0 = -1;
        qb0Var.h0 = -1;
        qb0Var.i0 = -1;
        qb0Var.j0 = Integer.MIN_VALUE;
        qb0Var.k0 = Integer.MIN_VALUE;
        qb0Var.l0 = 0.5f;
        qb0Var.p0 = new jc0();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, wc3.b);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            int i2 = pb0.a.get(index);
            switch (i2) {
                case 1:
                    qb0Var.V = typedArrayObtainStyledAttributes.getInt(index, qb0Var.V);
                    break;
                case 2:
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, qb0Var.p);
                    qb0Var.p = resourceId;
                    if (resourceId == -1) {
                        qb0Var.p = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 3:
                    qb0Var.q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, qb0Var.q);
                    break;
                case 4:
                    float f = typedArrayObtainStyledAttributes.getFloat(index, qb0Var.r) % 360.0f;
                    qb0Var.r = f;
                    if (f < 0.0f) {
                        qb0Var.r = (360.0f - f) % 360.0f;
                    }
                    break;
                case 5:
                    qb0Var.a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, qb0Var.a);
                    break;
                case 6:
                    qb0Var.b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, qb0Var.b);
                    break;
                case 7:
                    qb0Var.c = typedArrayObtainStyledAttributes.getFloat(index, qb0Var.c);
                    break;
                case 8:
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, qb0Var.e);
                    qb0Var.e = resourceId2;
                    if (resourceId2 == -1) {
                        qb0Var.e = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case Xlog.COMPRESS_LEVEL9 /* 9 */:
                    int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, qb0Var.f);
                    qb0Var.f = resourceId3;
                    if (resourceId3 == -1) {
                        qb0Var.f = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 10:
                    int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, qb0Var.g);
                    qb0Var.g = resourceId4;
                    if (resourceId4 == -1) {
                        qb0Var.g = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 11:
                    int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, qb0Var.h);
                    qb0Var.h = resourceId5;
                    if (resourceId5 == -1) {
                        qb0Var.h = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case FileClientSessionCache.MAX_SIZE /* 12 */:
                    int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, qb0Var.i);
                    qb0Var.i = resourceId6;
                    if (resourceId6 == -1) {
                        qb0Var.i = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 13:
                    int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, qb0Var.j);
                    qb0Var.j = resourceId7;
                    if (resourceId7 == -1) {
                        qb0Var.j = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 14:
                    int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, qb0Var.k);
                    qb0Var.k = resourceId8;
                    if (resourceId8 == -1) {
                        qb0Var.k = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                    int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, qb0Var.l);
                    qb0Var.l = resourceId9;
                    if (resourceId9 == -1) {
                        qb0Var.l = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 16:
                    int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, qb0Var.m);
                    qb0Var.m = resourceId10;
                    if (resourceId10 == -1) {
                        qb0Var.m = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 17:
                    int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, qb0Var.s);
                    qb0Var.s = resourceId11;
                    if (resourceId11 == -1) {
                        qb0Var.s = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 18:
                    int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, qb0Var.t);
                    qb0Var.t = resourceId12;
                    if (resourceId12 == -1) {
                        qb0Var.t = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 19:
                    int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, qb0Var.u);
                    qb0Var.u = resourceId13;
                    if (resourceId13 == -1) {
                        qb0Var.u = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 20:
                    int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, qb0Var.v);
                    qb0Var.v = resourceId14;
                    if (resourceId14 == -1) {
                        qb0Var.v = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 21:
                    qb0Var.w = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, qb0Var.w);
                    break;
                case 22:
                    qb0Var.x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, qb0Var.x);
                    break;
                case 23:
                    qb0Var.y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, qb0Var.y);
                    break;
                case 24:
                    qb0Var.z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, qb0Var.z);
                    break;
                case 25:
                    qb0Var.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, qb0Var.A);
                    break;
                case 26:
                    qb0Var.B = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, qb0Var.B);
                    break;
                case 27:
                    qb0Var.W = typedArrayObtainStyledAttributes.getBoolean(index, qb0Var.W);
                    break;
                case 28:
                    qb0Var.X = typedArrayObtainStyledAttributes.getBoolean(index, qb0Var.X);
                    break;
                case 29:
                    qb0Var.E = typedArrayObtainStyledAttributes.getFloat(index, qb0Var.E);
                    break;
                case 30:
                    qb0Var.F = typedArrayObtainStyledAttributes.getFloat(index, qb0Var.F);
                    break;
                case 31:
                    int i3 = typedArrayObtainStyledAttributes.getInt(index, 0);
                    qb0Var.L = i3;
                    if (i3 == 1) {
                        a1.d("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                    }
                    break;
                case 32:
                    int i4 = typedArrayObtainStyledAttributes.getInt(index, 0);
                    qb0Var.M = i4;
                    if (i4 == 1) {
                        a1.d("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                    }
                    break;
                case 33:
                    try {
                        qb0Var.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, qb0Var.N);
                    } catch (Exception unused) {
                        if (typedArrayObtainStyledAttributes.getInt(index, qb0Var.N) == -2) {
                            qb0Var.N = -2;
                        }
                    }
                    break;
                case 34:
                    try {
                        qb0Var.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, qb0Var.P);
                    } catch (Exception unused2) {
                        if (typedArrayObtainStyledAttributes.getInt(index, qb0Var.P) == -2) {
                            qb0Var.P = -2;
                        }
                    }
                    break;
                case 35:
                    qb0Var.R = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, qb0Var.R));
                    qb0Var.L = 2;
                    break;
                case 36:
                    try {
                        qb0Var.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, qb0Var.O);
                    } catch (Exception unused3) {
                        if (typedArrayObtainStyledAttributes.getInt(index, qb0Var.O) == -2) {
                            qb0Var.O = -2;
                        }
                    }
                    break;
                case 37:
                    try {
                        qb0Var.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, qb0Var.Q);
                    } catch (Exception unused4) {
                        if (typedArrayObtainStyledAttributes.getInt(index, qb0Var.Q) == -2) {
                            qb0Var.Q = -2;
                        }
                    }
                    break;
                case 38:
                    qb0Var.S = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, qb0Var.S));
                    qb0Var.M = 2;
                    break;
                default:
                    switch (i2) {
                        case 44:
                            ac0.g(qb0Var, typedArrayObtainStyledAttributes.getString(index));
                            break;
                        case 45:
                            qb0Var.H = typedArrayObtainStyledAttributes.getFloat(index, qb0Var.H);
                            break;
                        case 46:
                            qb0Var.I = typedArrayObtainStyledAttributes.getFloat(index, qb0Var.I);
                            break;
                        case 47:
                            qb0Var.J = typedArrayObtainStyledAttributes.getInt(index, 0);
                            break;
                        case OpenSslSessionTicketKey.TICKET_KEY_SIZE /* 48 */:
                            qb0Var.K = typedArrayObtainStyledAttributes.getInt(index, 0);
                            break;
                        case 49:
                            qb0Var.T = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, qb0Var.T);
                            break;
                        case 50:
                            qb0Var.U = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, qb0Var.U);
                            break;
                        case 51:
                            qb0Var.Y = typedArrayObtainStyledAttributes.getString(index);
                            break;
                        case 52:
                            int resourceId15 = typedArrayObtainStyledAttributes.getResourceId(index, qb0Var.n);
                            qb0Var.n = resourceId15;
                            if (resourceId15 == -1) {
                                qb0Var.n = typedArrayObtainStyledAttributes.getInt(index, -1);
                            }
                            break;
                        case 53:
                            int resourceId16 = typedArrayObtainStyledAttributes.getResourceId(index, qb0Var.o);
                            qb0Var.o = resourceId16;
                            if (resourceId16 == -1) {
                                qb0Var.o = typedArrayObtainStyledAttributes.getInt(index, -1);
                            }
                            break;
                        case 54:
                            qb0Var.D = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, qb0Var.D);
                            break;
                        case 55:
                            qb0Var.C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, qb0Var.C);
                            break;
                        default:
                            switch (i2) {
                                case 64:
                                    ac0.f(qb0Var, typedArrayObtainStyledAttributes, index, 0);
                                    break;
                                case 65:
                                    ac0.f(qb0Var, typedArrayObtainStyledAttributes, index, 1);
                                    break;
                                case 66:
                                    qb0Var.Z = typedArrayObtainStyledAttributes.getInt(index, qb0Var.Z);
                                    break;
                                case 67:
                                    qb0Var.d = typedArrayObtainStyledAttributes.getBoolean(index, qb0Var.d);
                                    break;
                            }
                            break;
                    }
                    break;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        qb0Var.a();
        return qb0Var;
    }

    public int getMaxHeight() {
        return this.A0;
    }

    public int getMaxWidth() {
        return this.z0;
    }

    public int getMinHeight() {
        return this.y0;
    }

    public int getMinWidth() {
        return this.A;
    }

    public int getOptimizationLevel() {
        return this.z.C0;
    }

    public String getSceneString() {
        int id;
        StringBuilder sb = new StringBuilder();
        kc0 kc0Var = this.z;
        String resourceEntryName = kc0Var.j;
        if (resourceEntryName == null) {
            int id2 = getId();
            if (id2 != -1) {
                resourceEntryName = getContext().getResources().getResourceEntryName(id2);
                kc0Var.j = resourceEntryName;
            } else {
                resourceEntryName = "parent";
                kc0Var.j = "parent";
            }
        }
        if (kc0Var.g0 == null) {
            kc0Var.g0 = resourceEntryName;
            Log.v("ConstraintLayout", " setDebugName " + kc0Var.g0);
        }
        for (jc0 jc0Var : kc0Var.p0) {
            View view = jc0Var.e0;
            if (view != null) {
                if (jc0Var.j == null && (id = view.getId()) != -1) {
                    jc0Var.j = getContext().getResources().getResourceEntryName(id);
                }
                if (jc0Var.g0 == null) {
                    jc0Var.g0 = jc0Var.j;
                    Log.v("ConstraintLayout", " setDebugName " + jc0Var.g0);
                }
            }
        }
        kc0Var.l(sb);
        return sb.toString();
    }

    public final jc0 h(View view) {
        if (view == this) {
            return this.z;
        }
        if (view == null) {
            return null;
        }
        if (view.getLayoutParams() instanceof qb0) {
            return ((qb0) view.getLayoutParams()).p0;
        }
        view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
        if (view.getLayoutParams() instanceof qb0) {
            return ((qb0) view.getLayoutParams()).p0;
        }
        return null;
    }

    public final void i(AttributeSet attributeSet) {
        kc0 kc0Var = this.z;
        kc0Var.e0 = this;
        rb0 rb0Var = this.I0;
        kc0Var.t0 = rb0Var;
        kc0Var.r0.h = rb0Var;
        this.b.put(getId(), this);
        this.D0 = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, wc3.b, 0, 0);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == 16) {
                    this.A = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.A);
                } else if (index == 17) {
                    this.y0 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.y0);
                } else if (index == 14) {
                    this.z0 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.z0);
                } else if (index == 15) {
                    this.A0 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.A0);
                } else if (index == 113) {
                    this.C0 = typedArrayObtainStyledAttributes.getInt(index, this.C0);
                } else if (index == 56) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            j(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.E0 = null;
                        }
                    }
                } else if (index == 34) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        ac0 ac0Var = new ac0();
                        this.D0 = ac0Var;
                        ac0Var.d(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.D0 = null;
                    }
                    this.F0 = resourceId2;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        kc0Var.C0 = this.C0;
        gb2.q = kc0Var.S(512);
    }

    public final void j(int i) {
        String str;
        Context context = getContext();
        lb lbVar = new lb(28, false);
        lbVar.f = new SparseArray();
        lbVar.z = new SparseArray();
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            sb0 sb0Var = null;
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 2) {
                    String name = xml.getName();
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                lbVar.G(context, xml);
                            }
                            break;
                        case 80204913:
                            if (name.equals("State")) {
                                sb0 sb0Var2 = new sb0(context, xml);
                                ((SparseArray) lbVar.f).put(sb0Var2.b, sb0Var2);
                                sb0Var = sb0Var2;
                            }
                            break;
                        case 1382829617:
                            str = "StateSet";
                            name.equals(str);
                            break;
                        case 1657696882:
                            str = "layoutDescription";
                            name.equals(str);
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                tb0 tb0Var = new tb0(context, xml);
                                if (sb0Var != null) {
                                    sb0Var.a.add(tb0Var);
                                }
                            }
                            break;
                    }
                }
            }
        } catch (IOException e) {
            a1.e("ConstraintLayoutStates", "Error parsing resource: " + i, e);
        } catch (XmlPullParserException e2) {
            a1.e("ConstraintLayoutStates", "Error parsing resource: " + i, e2);
        }
        this.E0 = lbVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:159:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x046e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void k(kc0 kc0Var, int i, int i2, int i3) {
        int iMin;
        int iMax;
        int iMin2;
        int iMax2;
        int i4;
        char c;
        boolean z;
        int i5;
        int i6;
        boolean z2;
        rb0 rb0Var;
        int i7;
        boolean zP;
        int i8;
        boolean z3;
        boolean z4;
        int i9;
        rb0 rb0Var2;
        int i10;
        int i11;
        ks1 ks1Var;
        dp4 dp4Var;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        boolean z5;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        int iMax3 = Math.max(0, getPaddingTop());
        int iMax4 = Math.max(0, getPaddingBottom());
        int i19 = iMax3 + iMax4;
        int paddingWidth = getPaddingWidth();
        rb0 rb0Var3 = this.I0;
        rb0Var3.b = iMax3;
        rb0Var3.c = iMax4;
        rb0Var3.d = paddingWidth;
        rb0Var3.e = i19;
        rb0Var3.f = i2;
        rb0Var3.g = i3;
        int iMax5 = Math.max(0, getPaddingStart());
        int iMax6 = Math.max(0, getPaddingEnd());
        int i20 = 1;
        if (iMax5 <= 0 && iMax6 <= 0) {
            iMax5 = Math.max(0, getPaddingLeft());
        } else if ((getContext().getApplicationInfo().flags & 4194304) != 0 && 1 == getLayoutDirection()) {
            iMax5 = iMax6;
        }
        int i21 = size - paddingWidth;
        int i22 = size2 - i19;
        int i23 = rb0Var3.e;
        int i24 = rb0Var3.d;
        int childCount = getChildCount();
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode != 1073741824) {
                    iMin = 0;
                } else {
                    iMin = Math.min(this.z0 - i24, i21);
                    i20 = 1;
                }
            } else if (childCount == 0) {
                iMax = Math.max(0, this.A);
                iMin = iMax;
                i20 = 2;
            } else {
                iMin = 0;
                i20 = 2;
            }
        } else if (childCount == 0) {
            iMax = Math.max(0, this.A);
            iMin = iMax;
            i20 = 2;
        } else {
            iMin = i21;
            i20 = 2;
        }
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 != 0) {
                iMin2 = mode2 != 1073741824 ? 0 : Math.min(this.A0 - i23, i22);
                i4 = 1;
            } else if (childCount == 0) {
                iMax2 = Math.max(0, this.y0);
                iMin2 = iMax2;
                i4 = 2;
            } else {
                iMin2 = 0;
                i4 = 2;
            }
        } else if (childCount == 0) {
            iMax2 = Math.max(0, this.y0);
            iMin2 = iMax2;
            i4 = 2;
        } else {
            iMin2 = i22;
            i4 = 2;
        }
        int iO = kc0Var.o();
        no0 no0Var = kc0Var.r0;
        int[] iArr = kc0Var.C;
        int i25 = iMin;
        if (i25 == iO && iMin2 == kc0Var.i()) {
            c = 1;
        } else {
            no0Var.c = true;
            c = 1;
        }
        kc0Var.X = 0;
        kc0Var.Y = 0;
        iArr[0] = this.z0 - i24;
        iArr[c] = this.A0 - i23;
        kc0Var.a0 = 0;
        kc0Var.b0 = 0;
        kc0Var.I(i20);
        kc0Var.K(i25);
        kc0Var.J(i4);
        kc0Var.H(iMin2);
        int i26 = this.A - i24;
        if (i26 < 0) {
            kc0Var.a0 = 0;
        } else {
            kc0Var.a0 = i26;
        }
        int i27 = this.y0 - i23;
        if (i27 < 0) {
            kc0Var.b0 = 0;
        } else {
            kc0Var.b0 = i27;
        }
        kc0Var.w0 = iMax5;
        kc0Var.x0 = iMax3;
        ed4 ed4Var = kc0Var.q0;
        kc0 kc0Var2 = (kc0) ed4Var.A;
        ArrayList arrayList = (ArrayList) ed4Var.f;
        rb0 rb0Var4 = kc0Var.t0;
        int size3 = kc0Var.p0.size();
        int iO2 = kc0Var.o();
        int i28 = kc0Var.i();
        boolean zK = ye.k(i, 128);
        boolean z6 = zK || ye.k(i, 64);
        if (z6) {
            int i29 = 0;
            while (i29 < size3) {
                boolean z7 = z6;
                jc0 jc0Var = (jc0) kc0Var.p0.get(i29);
                i5 = size3;
                int[] iArr2 = jc0Var.o0;
                int i30 = i29;
                boolean z8 = (iArr2[0] == 3) && (iArr2[1] == 3) && jc0Var.V > 0.0f;
                if ((jc0Var.v() && z8) || ((jc0Var.w() && z8) || jc0Var.v() || jc0Var.w())) {
                    i6 = Pow2.MAX_POW2;
                    z = false;
                    break;
                } else {
                    i29 = i30 + 1;
                    z6 = z7;
                    size3 = i5;
                }
            }
            z = z6;
            i5 = size3;
            i6 = Pow2.MAX_POW2;
        } else {
            z = z6;
            i5 = size3;
            i6 = Pow2.MAX_POW2;
        }
        boolean z9 = z & ((mode == i6 && mode2 == i6) || zK);
        if (z9) {
            int iMin3 = Math.min(iArr[0], i21);
            int iMin4 = Math.min(iArr[1], i22);
            int i31 = Pow2.MAX_POW2;
            if (mode == 1073741824) {
                if (kc0Var.o() != iMin3) {
                    kc0Var.K(iMin3);
                    no0Var.b = true;
                }
                i31 = Pow2.MAX_POW2;
            }
            if (mode2 == i31 && kc0Var.i() != iMin4) {
                kc0Var.H(iMin4);
                no0Var.b = true;
            }
            if (mode == i31 && mode2 == i31) {
                ArrayList<nt4> arrayList2 = (ArrayList) no0Var.f;
                kc0 kc0Var3 = (kc0) no0Var.d;
                if (no0Var.b || no0Var.c) {
                    for (jc0 jc0Var2 : kc0Var3.p0) {
                        jc0Var2.f();
                        jc0Var2.a = false;
                        jc0Var2.d.n();
                        jc0Var2.e.m();
                        z9 = z9;
                    }
                    z2 = z9;
                    kc0Var3.f();
                    i14 = 0;
                    kc0Var3.a = false;
                    kc0Var3.d.n();
                    kc0Var3.e.m();
                    no0Var.c = false;
                } else {
                    z2 = z9;
                    i14 = 0;
                }
                no0Var.b((kc0) no0Var.e);
                kc0Var3.X = i14;
                int[] iArr3 = kc0Var3.o0;
                kc0Var3.Y = i14;
                int iH = kc0Var3.h(i14);
                int iH2 = kc0Var3.h(1);
                if (no0Var.b) {
                    no0Var.c();
                }
                int iP = kc0Var3.p();
                int iQ = kc0Var3.q();
                rb0Var = rb0Var4;
                kc0Var3.d.h.d(iP);
                kc0Var3.e.h.d(iQ);
                no0Var.g();
                if (iH == 2 || iH2 == 2) {
                    if (zK) {
                        Iterator it = arrayList2.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (!((nt4) it.next()).k()) {
                                    zK = false;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    if (zK && iH == 2) {
                        kc0Var3.I(1);
                        i15 = iQ;
                        kc0Var3.K(no0Var.d(kc0Var3, 0));
                        kc0Var3.d.e.d(kc0Var3.o());
                    } else {
                        i15 = iQ;
                    }
                    if (zK && iH2 == 2) {
                        i16 = 1;
                        kc0Var3.J(1);
                        kc0Var3.H(no0Var.d(kc0Var3, 1));
                        kc0Var3.e.e.d(kc0Var3.i());
                    }
                    i17 = iArr3[0];
                    if (i17 != i16 || i17 == 4) {
                        int iO3 = kc0Var3.o() + iP;
                        kc0Var3.d.i.d(iO3);
                        kc0Var3.d.e.d(iO3 - iP);
                        no0Var.g();
                        i18 = iArr3[1];
                        if (i18 != 1 || i18 == 4) {
                            int i32 = kc0Var3.i() + i15;
                            kc0Var3.e.i.d(i32);
                            kc0Var3.e.e.d(i32 - i15);
                        }
                        no0Var.g();
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    for (nt4 nt4Var : arrayList2) {
                        if (nt4Var.b != kc0Var3 || nt4Var.g) {
                            nt4Var.e();
                        }
                    }
                    for (nt4 nt4Var2 : arrayList2) {
                        if (z5 || nt4Var2.b != kc0Var3) {
                            if (!nt4Var2.h.j || ((!nt4Var2.i.j && !(nt4Var2 instanceof oq1)) || (!nt4Var2.e.j && !(nt4Var2 instanceof q20) && !(nt4Var2 instanceof oq1)))) {
                                zP = false;
                                break;
                            }
                        }
                    }
                    zP = true;
                    kc0Var3.I(iH);
                    kc0Var3.J(iH2);
                    i7 = 2;
                    i13 = Pow2.MAX_POW2;
                } else {
                    i15 = iQ;
                }
                i16 = 1;
                i17 = iArr3[0];
                if (i17 != i16) {
                    int iO32 = kc0Var3.o() + iP;
                    kc0Var3.d.i.d(iO32);
                    kc0Var3.d.e.d(iO32 - iP);
                    no0Var.g();
                    i18 = iArr3[1];
                    if (i18 != 1) {
                        int i322 = kc0Var3.i() + i15;
                        kc0Var3.e.i.d(i322);
                        kc0Var3.e.e.d(i322 - i15);
                        no0Var.g();
                        z5 = true;
                        while (r8.hasNext()) {
                        }
                        while (r8.hasNext()) {
                        }
                        zP = true;
                        kc0Var3.I(iH);
                        kc0Var3.J(iH2);
                        i7 = 2;
                        i13 = Pow2.MAX_POW2;
                    }
                }
            } else {
                z2 = z9;
                rb0Var = rb0Var4;
                kc0 kc0Var4 = (kc0) no0Var.d;
                if (no0Var.b) {
                    for (jc0 jc0Var3 : kc0Var4.p0) {
                        jc0Var3.f();
                        jc0Var3.a = false;
                        ks1 ks1Var2 = jc0Var3.d;
                        ks1Var2.e.j = false;
                        ks1Var2.g = false;
                        ks1Var2.n();
                        dp4 dp4Var2 = jc0Var3.e;
                        dp4Var2.e.j = false;
                        dp4Var2.g = false;
                        dp4Var2.m();
                    }
                    i12 = 0;
                    kc0Var4.f();
                    kc0Var4.a = false;
                    ks1 ks1Var3 = kc0Var4.d;
                    ks1Var3.e.j = false;
                    ks1Var3.g = false;
                    ks1Var3.n();
                    dp4 dp4Var3 = kc0Var4.e;
                    dp4Var3.e.j = false;
                    dp4Var3.g = false;
                    dp4Var3.m();
                    no0Var.c();
                } else {
                    i12 = 0;
                }
                no0Var.b((kc0) no0Var.e);
                kc0Var4.X = i12;
                kc0Var4.Y = i12;
                kc0Var4.d.h.d(i12);
                kc0Var4.e.h.d(i12);
                i13 = Pow2.MAX_POW2;
                if (mode == 1073741824) {
                    zP = kc0Var.P(i12, zK);
                    i7 = 1;
                } else {
                    i7 = 0;
                    zP = true;
                }
                if (mode2 == 1073741824) {
                    zP &= kc0Var.P(1, zK);
                    i7++;
                }
            }
            if (zP) {
                kc0Var.L(mode == i13, mode2 == i13);
            }
        } else {
            z2 = z9;
            rb0Var = rb0Var4;
            i7 = 0;
            zP = false;
        }
        if (zP && i7 == 2) {
            return;
        }
        int i33 = kc0Var.C0;
        if (i5 > 0) {
            int size4 = kc0Var.p0.size();
            boolean zS = kc0Var.S(64);
            rb0 rb0Var5 = kc0Var.t0;
            int i34 = 0;
            while (i34 < size4) {
                jc0 jc0Var4 = (jc0) kc0Var.p0.get(i34);
                if (!(jc0Var4 instanceof nq1) && !(jc0Var4 instanceof wj)) {
                    jc0Var4.getClass();
                    if (zS && (ks1Var = jc0Var4.d) != null && (dp4Var = jc0Var4.e) != null && ks1Var.e.j && dp4Var.e.j) {
                        i11 = size4;
                    } else {
                        int iH3 = jc0Var4.h(0);
                        int iH4 = jc0Var4.h(1);
                        i11 = size4;
                        boolean z10 = iH3 == 3 && jc0Var4.r != 1 && iH4 == 3 && jc0Var4.s != 1;
                        if (!z10 && kc0Var.S(1)) {
                            if (iH3 == 3 && jc0Var4.r == 0 && iH4 != 3 && !jc0Var4.v()) {
                                z10 = true;
                            }
                            if (iH4 == 3 && jc0Var4.s == 0 && iH3 != 3 && !jc0Var4.v()) {
                                z10 = true;
                            }
                            if ((iH3 == 3 || iH4 == 3) && jc0Var4.V > 0.0f) {
                                z10 = true;
                            }
                        }
                        if (!z10) {
                            ed4Var.K(0, rb0Var5, jc0Var4);
                        }
                    }
                }
                i34++;
                size4 = i11;
            }
            ConstraintLayout constraintLayout = rb0Var5.a;
            int childCount2 = constraintLayout.getChildCount();
            ArrayList arrayList3 = constraintLayout.f;
            for (int i35 = 0; i35 < childCount2; i35++) {
                constraintLayout.getChildAt(i35);
            }
            int size5 = arrayList3.size();
            if (size5 > 0) {
                for (int i36 = 0; i36 < size5; i36++) {
                    ((ob0) arrayList3.get(i36)).getClass();
                }
            }
        }
        ed4Var.a0(kc0Var);
        int size6 = arrayList.size();
        int i37 = 0;
        if (i5 > 0) {
            ed4Var.Z(kc0Var, 0, iO2, i28);
        }
        if (size6 > 0) {
            int[] iArr4 = kc0Var.o0;
            boolean z11 = iArr4[0] == 2;
            boolean z12 = iArr4[1] == 2;
            int iMax7 = Math.max(kc0Var.o(), kc0Var2.a0);
            int iMax8 = Math.max(kc0Var.i(), kc0Var2.b0);
            for (int i38 = 0; i38 < size6; i38++) {
            }
            int i39 = 0;
            while (i39 < 2) {
                int i40 = i37;
                int i41 = i40;
                while (i40 < size6) {
                    jc0 jc0Var5 = (jc0) arrayList.get(i40);
                    if ((jc0Var5 instanceof wj) || (jc0Var5 instanceof nq1)) {
                        i8 = size6;
                    } else {
                        i8 = size6;
                        if (jc0Var5.f0 != 8 && (!z2 || !jc0Var5.d.e.j || !jc0Var5.e.e.j)) {
                            int iO4 = jc0Var5.o();
                            int i42 = jc0Var5.i();
                            z3 = z12;
                            int i43 = jc0Var5.Z;
                            z4 = z11;
                            int i44 = i39 == 1 ? 2 : 1;
                            i9 = i39;
                            rb0Var2 = rb0Var;
                            int i45 = (ed4Var.K(i44, rb0Var2, jc0Var5) ? 1 : 0) | i41;
                            int iO5 = jc0Var5.o();
                            int i46 = i45;
                            int i47 = jc0Var5.i();
                            if (iO5 != iO4) {
                                jc0Var5.K(iO5);
                                if (z4 && jc0Var5.p() + jc0Var5.T > iMax7) {
                                    iMax7 = Math.max(iMax7, jc0Var5.g(4).d() + jc0Var5.p() + jc0Var5.T);
                                }
                                i46 = 1;
                            }
                            if (i47 != i42) {
                                jc0Var5.H(i47);
                                if (z3 && jc0Var5.q() + jc0Var5.U > iMax8) {
                                    iMax8 = Math.max(iMax8, jc0Var5.g(5).d() + jc0Var5.q() + jc0Var5.U);
                                }
                                i10 = 1;
                            } else {
                                i10 = i46;
                            }
                            if (jc0Var5.E && i43 != jc0Var5.Z) {
                                i10 = 1;
                            }
                        }
                        i40++;
                        size6 = i8;
                        z12 = z3;
                        rb0Var = rb0Var2;
                        i41 = i10;
                        z11 = z4;
                        i39 = i9;
                    }
                    z3 = z12;
                    z4 = z11;
                    i9 = i39;
                    i10 = i41;
                    rb0Var2 = rb0Var;
                    i40++;
                    size6 = i8;
                    z12 = z3;
                    rb0Var = rb0Var2;
                    i41 = i10;
                    z11 = z4;
                    i39 = i9;
                }
                int i48 = size6;
                boolean z13 = z12;
                boolean z14 = z11;
                int i49 = i39;
                rb0 rb0Var6 = rb0Var;
                if (i41 == 0) {
                    break;
                }
                int i50 = i49 + 1;
                ed4Var.Z(kc0Var, i50, iO2, i28);
                z12 = z13;
                rb0Var = rb0Var6;
                z11 = z14;
                i37 = 0;
                i39 = i50;
                size6 = i48;
            }
        }
        kc0Var.C0 = i33;
        gb2.q = kc0Var.S(512);
    }

    public final void l(jc0 jc0Var, qb0 qb0Var, SparseArray sparseArray, int i, int i2) {
        View view = (View) this.b.get(i);
        jc0 jc0Var2 = (jc0) sparseArray.get(i);
        if (jc0Var2 == null || view == null || !(view.getLayoutParams() instanceof qb0)) {
            return;
        }
        qb0Var.c0 = true;
        if (i2 == 6) {
            qb0 qb0Var2 = (qb0) view.getLayoutParams();
            qb0Var2.c0 = true;
            qb0Var2.p0.E = true;
        }
        jc0Var.g(6).a(jc0Var2.g(i2), qb0Var.D, qb0Var.C);
        jc0Var.E = true;
        jc0Var.g(3).g();
        jc0Var.g(5).g();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            qb0 qb0Var = (qb0) childAt.getLayoutParams();
            jc0 jc0Var = qb0Var.p0;
            if (childAt.getVisibility() != 8 || qb0Var.d0 || qb0Var.e0 || zIsInEditMode) {
                int iP = jc0Var.p();
                int iQ = jc0Var.q();
                childAt.layout(iP, iQ, jc0Var.o() + iP, jc0Var.i() + iQ);
            }
        }
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        if (size > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                ((ob0) arrayList.get(i6)).getClass();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0667  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x066b  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0677  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0738  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x074b  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0764  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0780  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x07a8  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x07bc  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x07d9  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x07e8  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0809  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x0811  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x0935  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x093b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onMeasure(int i, int i2) {
        kc0 kc0Var;
        boolean z;
        boolean z2;
        SparseArray sparseArray;
        boolean z3;
        int i3;
        int i4;
        int i5;
        int i6;
        float f;
        jc0 jc0Var;
        int i7;
        int i8;
        int i9;
        jc0 jc0Var2;
        int i10;
        int i11;
        int i12;
        int i13;
        jc0 jc0Var3;
        int i14;
        int i15;
        jc0 jc0Var4;
        float f2;
        int i16;
        int i17;
        jc0 jc0Var5;
        int i18;
        int i19;
        ConstraintLayout constraintLayout;
        float f3;
        int i20;
        int i21;
        char c;
        int i22;
        int i23;
        float fAbs;
        int i24;
        byte b;
        SparseArray sparseArray2;
        String str;
        int iD;
        SparseArray sparseArray3;
        HashSet hashSet;
        int i25;
        kc0 kc0Var2;
        boolean z4;
        boolean z5;
        int i26;
        kc0 kc0Var3;
        String resourceEntryName;
        int i27;
        jc0 jc0Var6;
        ConstraintLayout constraintLayout2 = this;
        boolean z6 = constraintLayout2.B0;
        constraintLayout2.B0 = z6;
        int i28 = 0;
        if (!z6) {
            int childCount = constraintLayout2.getChildCount();
            int i29 = 0;
            while (true) {
                if (i29 >= childCount) {
                    break;
                }
                if (constraintLayout2.getChildAt(i29).isLayoutRequested()) {
                    constraintLayout2.B0 = true;
                    break;
                }
                i29++;
            }
        }
        boolean z7 = (constraintLayout2.getContext().getApplicationInfo().flags & 4194304) != 0 && 1 == constraintLayout2.getLayoutDirection();
        kc0 kc0Var4 = constraintLayout2.z;
        kc0Var4.u0 = z7;
        if (constraintLayout2.B0) {
            constraintLayout2.B0 = false;
            int childCount2 = constraintLayout2.getChildCount();
            int i30 = 0;
            while (true) {
                if (i30 >= childCount2) {
                    z = false;
                    break;
                } else {
                    if (constraintLayout2.getChildAt(i30).isLayoutRequested()) {
                        z = true;
                        break;
                    }
                    i30++;
                }
            }
            if (z) {
                boolean zIsInEditMode = constraintLayout2.isInEditMode();
                int childCount3 = constraintLayout2.getChildCount();
                for (int i31 = 0; i31 < childCount3; i31++) {
                    jc0 jc0VarH = constraintLayout2.h(constraintLayout2.getChildAt(i31));
                    if (jc0VarH != null) {
                        jc0VarH.A();
                    }
                }
                SparseArray sparseArray4 = constraintLayout2.b;
                if (zIsInEditMode) {
                    int i32 = 0;
                    while (i32 < childCount3) {
                        View childAt = constraintLayout2.getChildAt(i32);
                        try {
                            String resourceName = constraintLayout2.getResources().getResourceName(childAt.getId());
                            Integer numValueOf = Integer.valueOf(childAt.getId());
                            if ((resourceName != null ? 1 : i28) != 0) {
                                if (constraintLayout2.G0 == null) {
                                    constraintLayout2.G0 = new HashMap();
                                }
                                int iIndexOf = resourceName.indexOf("/");
                                i27 = i28;
                                try {
                                    constraintLayout2.G0.put(iIndexOf != -1 ? resourceName.substring(iIndexOf + 1) : resourceName, numValueOf);
                                } catch (Resources.NotFoundException unused) {
                                }
                            } else {
                                i27 = i28;
                            }
                            int iIndexOf2 = resourceName.indexOf(47);
                            if (iIndexOf2 != -1) {
                                resourceName = resourceName.substring(iIndexOf2 + 1);
                            }
                            int id = childAt.getId();
                            if (id != 0) {
                                View viewFindViewById = (View) sparseArray4.get(id);
                                if (viewFindViewById == null && (viewFindViewById = constraintLayout2.findViewById(id)) != null && viewFindViewById != constraintLayout2 && viewFindViewById.getParent() == constraintLayout2) {
                                    constraintLayout2.onViewAdded(viewFindViewById);
                                }
                                if (viewFindViewById == constraintLayout2) {
                                    jc0Var6 = kc0Var4;
                                    jc0Var6.g0 = resourceName;
                                } else {
                                    jc0Var6 = viewFindViewById == null ? null : ((qb0) viewFindViewById.getLayoutParams()).p0;
                                    jc0Var6.g0 = resourceName;
                                }
                            } else {
                                jc0Var6 = kc0Var4;
                                jc0Var6.g0 = resourceName;
                            }
                        } catch (Resources.NotFoundException unused2) {
                            i27 = i28;
                        }
                        i32++;
                        i28 = i27;
                    }
                }
                int i33 = i28;
                if (constraintLayout2.F0 != -1) {
                    for (int i34 = i33; i34 < childCount3; i34++) {
                        constraintLayout2.getChildAt(i34).getId();
                    }
                }
                ac0 ac0Var = constraintLayout2.D0;
                if (ac0Var != null) {
                    int childCount4 = constraintLayout2.getChildCount();
                    HashMap map = ac0Var.b;
                    HashSet<Integer> hashSet2 = new HashSet(map.keySet());
                    int i35 = i33;
                    boolean z8 = z;
                    while (i35 < childCount4) {
                        View childAt2 = constraintLayout2.getChildAt(i35);
                        int id2 = childAt2.getId();
                        if (!map.containsKey(Integer.valueOf(id2))) {
                            StringBuilder sb = new StringBuilder("id unknown ");
                            try {
                                resourceEntryName = childAt2.getContext().getResources().getResourceEntryName(childAt2.getId());
                            } catch (Exception unused3) {
                                resourceEntryName = "UNKNOWN";
                            }
                            sb.append(resourceEntryName);
                            a1.n("ConstraintSet", sb.toString());
                        } else {
                            if (id2 == -1) {
                                zo2.w("All children of ConstraintLayout must have ids to use ConstraintSet");
                                return;
                            }
                            if (id2 != -1) {
                                if (map.containsKey(Integer.valueOf(id2))) {
                                    hashSet2.remove(Integer.valueOf(id2));
                                    vb0 vb0Var = (vb0) map.get(Integer.valueOf(id2));
                                    if (vb0Var != null) {
                                        yb0 yb0Var = vb0Var.b;
                                        hashSet = hashSet2;
                                        wb0 wb0Var = vb0Var.d;
                                        i25 = i35;
                                        zb0 zb0Var = vb0Var.e;
                                        z4 = z8;
                                        if (childAt2 instanceof vj) {
                                            wb0Var.h0 = 1;
                                            vj vjVar = (vj) childAt2;
                                            vjVar.setId(id2);
                                            vjVar.setType(wb0Var.f0);
                                            vjVar.setMargin(wb0Var.g0);
                                            vjVar.setAllowsGoneWidget(wb0Var.n0);
                                            int[] iArr = wb0Var.i0;
                                            if (iArr != null) {
                                                vjVar.setReferencedIds(iArr);
                                            } else {
                                                String str2 = wb0Var.j0;
                                                if (str2 != null) {
                                                    int[] iArrB = ac0.b(vjVar, str2);
                                                    wb0Var.i0 = iArrB;
                                                    vjVar.setReferencedIds(iArrB);
                                                }
                                            }
                                        }
                                        qb0 qb0Var = (qb0) childAt2.getLayoutParams();
                                        qb0Var.a();
                                        vb0Var.a(qb0Var);
                                        HashMap map2 = vb0Var.f;
                                        z5 = zIsInEditMode;
                                        Class<?> cls = childAt2.getClass();
                                        for (String str3 : map2.keySet()) {
                                            int i36 = childCount3;
                                            mb0 mb0Var = (mb0) map2.get(str3);
                                            HashMap map3 = map2;
                                            String strN = !mb0Var.a ? ha0.n("set", str3) : str3;
                                            SparseArray sparseArray5 = sparseArray4;
                                            try {
                                                int iG = fw.G(mb0Var.b);
                                                Class<?> cls2 = Float.TYPE;
                                                Class<?> cls3 = Integer.TYPE;
                                                switch (iG) {
                                                    case 0:
                                                        kc0Var3 = kc0Var4;
                                                        Class<?>[] clsArr = new Class[1];
                                                        clsArr[i33] = cls3;
                                                        Method method = cls.getMethod(strN, clsArr);
                                                        Integer numValueOf2 = Integer.valueOf(mb0Var.c);
                                                        Object[] objArr = new Object[1];
                                                        objArr[i33] = numValueOf2;
                                                        method.invoke(childAt2, objArr);
                                                        break;
                                                    case 1:
                                                        kc0Var3 = kc0Var4;
                                                        Class<?>[] clsArr2 = new Class[1];
                                                        clsArr2[i33] = cls2;
                                                        Method method2 = cls.getMethod(strN, clsArr2);
                                                        Float fValueOf = Float.valueOf(mb0Var.d);
                                                        Object[] objArr2 = new Object[1];
                                                        objArr2[i33] = fValueOf;
                                                        method2.invoke(childAt2, objArr2);
                                                        break;
                                                    case 2:
                                                        kc0Var3 = kc0Var4;
                                                        Class<?>[] clsArr3 = new Class[1];
                                                        clsArr3[i33] = cls3;
                                                        Method method3 = cls.getMethod(strN, clsArr3);
                                                        Integer numValueOf3 = Integer.valueOf(mb0Var.g);
                                                        Object[] objArr3 = new Object[1];
                                                        objArr3[i33] = numValueOf3;
                                                        method3.invoke(childAt2, objArr3);
                                                        break;
                                                    case 3:
                                                        kc0Var3 = kc0Var4;
                                                        Class<?>[] clsArr4 = new Class[1];
                                                        clsArr4[i33] = Drawable.class;
                                                        Method method4 = cls.getMethod(strN, clsArr4);
                                                        ColorDrawable colorDrawable = new ColorDrawable();
                                                        colorDrawable.setColor(mb0Var.g);
                                                        Object[] objArr4 = new Object[1];
                                                        objArr4[i33] = colorDrawable;
                                                        method4.invoke(childAt2, objArr4);
                                                        break;
                                                    case 4:
                                                        kc0Var3 = kc0Var4;
                                                        Class<?>[] clsArr5 = new Class[1];
                                                        clsArr5[i33] = CharSequence.class;
                                                        Method method5 = cls.getMethod(strN, clsArr5);
                                                        String str4 = mb0Var.e;
                                                        Object[] objArr5 = new Object[1];
                                                        objArr5[i33] = str4;
                                                        method5.invoke(childAt2, objArr5);
                                                        break;
                                                    case 5:
                                                        kc0Var3 = kc0Var4;
                                                        Class<?>[] clsArr6 = new Class[1];
                                                        clsArr6[i33] = Boolean.TYPE;
                                                        Method method6 = cls.getMethod(strN, clsArr6);
                                                        Boolean boolValueOf = Boolean.valueOf(mb0Var.f);
                                                        Object[] objArr6 = new Object[1];
                                                        objArr6[i33] = boolValueOf;
                                                        method6.invoke(childAt2, objArr6);
                                                        break;
                                                    case 6:
                                                        kc0Var3 = kc0Var4;
                                                        Class<?>[] clsArr7 = new Class[1];
                                                        clsArr7[i33] = cls2;
                                                        Method method7 = cls.getMethod(strN, clsArr7);
                                                        Float fValueOf2 = Float.valueOf(mb0Var.d);
                                                        Object[] objArr7 = new Object[1];
                                                        objArr7[i33] = fValueOf2;
                                                        method7.invoke(childAt2, objArr7);
                                                        break;
                                                    case 7:
                                                        kc0Var3 = kc0Var4;
                                                        try {
                                                            Class<?>[] clsArr8 = new Class[1];
                                                            clsArr8[i33] = cls3;
                                                            Method method8 = cls.getMethod(strN, clsArr8);
                                                            Integer numValueOf4 = Integer.valueOf(mb0Var.c);
                                                            Object[] objArr8 = new Object[1];
                                                            objArr8[i33] = numValueOf4;
                                                            method8.invoke(childAt2, objArr8);
                                                        } catch (IllegalAccessException e) {
                                                            e = e;
                                                            StringBuilder sbD = fw.D(" Custom Attribute \"", str3, "\" not found on ");
                                                            sbD.append(cls.getName());
                                                            a1.e("TransitionLayout", sbD.toString(), e);
                                                        } catch (NoSuchMethodException e2) {
                                                            e = e2;
                                                            a1.e("TransitionLayout", cls.getName() + " must have a method " + strN, e);
                                                        } catch (InvocationTargetException e3) {
                                                            e = e3;
                                                            StringBuilder sbD2 = fw.D(" Custom Attribute \"", str3, "\" not found on ");
                                                            sbD2.append(cls.getName());
                                                            a1.e("TransitionLayout", sbD2.toString(), e);
                                                        }
                                                        break;
                                                    default:
                                                        kc0Var3 = kc0Var4;
                                                        break;
                                                }
                                            } catch (IllegalAccessException e4) {
                                                e = e4;
                                                kc0Var3 = kc0Var4;
                                            } catch (NoSuchMethodException e5) {
                                                e = e5;
                                                kc0Var3 = kc0Var4;
                                            } catch (InvocationTargetException e6) {
                                                e = e6;
                                                kc0Var3 = kc0Var4;
                                            }
                                            childCount3 = i36;
                                            map2 = map3;
                                            sparseArray4 = sparseArray5;
                                            kc0Var4 = kc0Var3;
                                        }
                                        sparseArray3 = sparseArray4;
                                        kc0Var2 = kc0Var4;
                                        i26 = childCount3;
                                        childAt2.setLayoutParams(qb0Var);
                                        if (yb0Var.b == 0) {
                                            childAt2.setVisibility(yb0Var.a);
                                        }
                                        childAt2.setAlpha(yb0Var.c);
                                        childAt2.setRotation(zb0Var.a);
                                        childAt2.setRotationX(zb0Var.b);
                                        childAt2.setRotationY(zb0Var.c);
                                        childAt2.setScaleX(zb0Var.d);
                                        childAt2.setScaleY(zb0Var.e);
                                        if (zb0Var.h != -1) {
                                            if (((View) childAt2.getParent()).findViewById(zb0Var.h) != null) {
                                                float bottom = (r0.getBottom() + r0.getTop()) / 2.0f;
                                                float right = (r0.getRight() + r0.getLeft()) / 2.0f;
                                                if (childAt2.getRight() - childAt2.getLeft() > 0 && childAt2.getBottom() - childAt2.getTop() > 0) {
                                                    childAt2.setPivotX(right - childAt2.getLeft());
                                                    childAt2.setPivotY(bottom - childAt2.getTop());
                                                }
                                            }
                                        } else {
                                            if (!Float.isNaN(zb0Var.f)) {
                                                childAt2.setPivotX(zb0Var.f);
                                            }
                                            if (!Float.isNaN(zb0Var.g)) {
                                                childAt2.setPivotY(zb0Var.g);
                                            }
                                        }
                                        childAt2.setTranslationX(zb0Var.i);
                                        childAt2.setTranslationY(zb0Var.j);
                                        childAt2.setTranslationZ(zb0Var.k);
                                        if (zb0Var.l) {
                                            childAt2.setElevation(zb0Var.m);
                                        }
                                    }
                                } else {
                                    sparseArray3 = sparseArray4;
                                    hashSet = hashSet2;
                                    i25 = i35;
                                    kc0Var2 = kc0Var4;
                                    z4 = z8;
                                    z5 = zIsInEditMode;
                                    i26 = childCount3;
                                    Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id2);
                                }
                            }
                            i35 = i25 + 1;
                            hashSet2 = hashSet;
                            z8 = z4;
                            zIsInEditMode = z5;
                            childCount3 = i26;
                            sparseArray4 = sparseArray3;
                            kc0Var4 = kc0Var2;
                        }
                        sparseArray3 = sparseArray4;
                        hashSet = hashSet2;
                        i25 = i35;
                        kc0Var2 = kc0Var4;
                        z4 = z8;
                        z5 = zIsInEditMode;
                        i26 = childCount3;
                        i35 = i25 + 1;
                        hashSet2 = hashSet;
                        z8 = z4;
                        zIsInEditMode = z5;
                        childCount3 = i26;
                        sparseArray4 = sparseArray3;
                        kc0Var4 = kc0Var2;
                    }
                    sparseArray = sparseArray4;
                    kc0 kc0Var5 = kc0Var4;
                    z2 = z8;
                    z3 = zIsInEditMode;
                    i3 = childCount3;
                    for (Integer num : hashSet2) {
                        vb0 vb0Var2 = (vb0) map.get(num);
                        if (vb0Var2 != null) {
                            wb0 wb0Var2 = vb0Var2.d;
                            if (wb0Var2.h0 == 1) {
                                Context context = constraintLayout2.getContext();
                                vj vjVar2 = new vj(context);
                                vjVar2.b = new int[32];
                                vjVar2.A0 = new HashMap();
                                vjVar2.z = context;
                                wj wjVar = new wj();
                                wjVar.p0 = new jc0[4];
                                boolean z9 = i33;
                                wjVar.q0 = z9 ? 1 : 0;
                                wjVar.r0 = z9 ? 1 : 0;
                                wjVar.s0 = true;
                                wjVar.t0 = z9 ? 1 : 0;
                                wjVar.u0 = z9;
                                vjVar2.C0 = wjVar;
                                vjVar2.A = wjVar;
                                vjVar2.e();
                                vjVar2.setVisibility(8);
                                vjVar2.setId(num.intValue());
                                int[] iArr2 = wb0Var2.i0;
                                if (iArr2 != null) {
                                    vjVar2.setReferencedIds(iArr2);
                                } else {
                                    String str5 = wb0Var2.j0;
                                    if (str5 != null) {
                                        int[] iArrB2 = ac0.b(vjVar2, str5);
                                        wb0Var2.i0 = iArrB2;
                                        vjVar2.setReferencedIds(iArrB2);
                                    }
                                }
                                vjVar2.setType(wb0Var2.f0);
                                vjVar2.setMargin(wb0Var2.g0);
                                qb0 qb0VarG = g();
                                vjVar2.e();
                                vb0Var2.a(qb0VarG);
                                constraintLayout2.addView(vjVar2, qb0VarG);
                            }
                            if (wb0Var2.a) {
                                Guideline guideline = new Guideline(constraintLayout2.getContext());
                                guideline.setId(num.intValue());
                                qb0 qb0VarG2 = g();
                                vb0Var2.a(qb0VarG2);
                                constraintLayout2.addView(guideline, qb0VarG2);
                            }
                            i33 = 0;
                        }
                    }
                    for (int i37 = 0; i37 < childCount4; i37++) {
                        constraintLayout2.getChildAt(i37);
                    }
                    kc0Var = kc0Var5;
                } else {
                    sparseArray = sparseArray4;
                    z2 = z;
                    z3 = zIsInEditMode;
                    i3 = childCount3;
                    kc0Var = kc0Var4;
                }
                kc0Var.p0.clear();
                ArrayList arrayList = constraintLayout2.f;
                int size = arrayList.size();
                char c2 = 2;
                if (size > 0) {
                    int i38 = 0;
                    while (i38 < size) {
                        ob0 ob0Var = (ob0) arrayList.get(i38);
                        HashMap map4 = ob0Var.A0;
                        if (ob0Var.isInEditMode()) {
                            ob0Var.setIds(ob0Var.y0);
                        }
                        wj wjVar2 = ob0Var.A;
                        if (wjVar2 == null) {
                            sparseArray2 = sparseArray;
                        } else {
                            wjVar2.q0 = 0;
                            Arrays.fill(wjVar2.p0, (Object) null);
                            int i39 = 0;
                            while (i39 < ob0Var.f) {
                                int i40 = ob0Var.b[i39];
                                SparseArray sparseArray6 = sparseArray;
                                View view = (View) sparseArray6.get(i40);
                                if (view == null && (iD = ob0Var.d(constraintLayout2, (str = (String) map4.get(Integer.valueOf(i40))))) != 0) {
                                    ob0Var.b[i39] = iD;
                                    map4.put(Integer.valueOf(iD), str);
                                    view = (View) sparseArray6.get(iD);
                                }
                                if (view != null) {
                                    wj wjVar3 = ob0Var.A;
                                    jc0 jc0VarH2 = constraintLayout2.h(view);
                                    wjVar3.getClass();
                                    if (jc0VarH2 != wjVar3 && jc0VarH2 != null) {
                                        int i41 = wjVar3.q0 + 1;
                                        jc0[] jc0VarArr = wjVar3.p0;
                                        if (i41 > jc0VarArr.length) {
                                            jc0VarArr = (jc0[]) Arrays.copyOf(jc0VarArr, jc0VarArr.length * 2);
                                            wjVar3.p0 = jc0VarArr;
                                        }
                                        int i42 = wjVar3.q0;
                                        jc0VarArr[i42] = jc0VarH2;
                                        wjVar3.q0 = i42 + 1;
                                    }
                                }
                                i39++;
                                sparseArray = sparseArray6;
                            }
                            sparseArray2 = sparseArray;
                            ob0Var.A.getClass();
                        }
                        i38++;
                        sparseArray = sparseArray2;
                    }
                }
                int i43 = i3;
                for (int i44 = 0; i44 < i43; i44++) {
                    constraintLayout2.getChildAt(i44);
                }
                SparseArray sparseArray7 = constraintLayout2.H0;
                sparseArray7.clear();
                sparseArray7.put(0, kc0Var);
                sparseArray7.put(constraintLayout2.getId(), kc0Var);
                for (int i45 = 0; i45 < i43; i45++) {
                    View childAt3 = constraintLayout2.getChildAt(i45);
                    sparseArray7.put(childAt3.getId(), constraintLayout2.h(childAt3));
                }
                int i46 = 0;
                constraintLayout2 = constraintLayout2;
                while (i46 < i43) {
                    View childAt4 = constraintLayout2.getChildAt(i46);
                    jc0 jc0VarH3 = constraintLayout2.h(childAt4);
                    if (jc0VarH3 == null) {
                        c = c2;
                    } else {
                        qb0 qb0Var2 = (qb0) childAt4.getLayoutParams();
                        kc0Var.p0.add(jc0VarH3);
                        kc0 kc0Var6 = jc0VarH3.S;
                        if (kc0Var6 != null) {
                            kc0Var6.p0.remove(jc0VarH3);
                            jc0VarH3.A();
                        }
                        jc0VarH3.S = kc0Var;
                        qb0Var2.a();
                        jc0VarH3.f0 = childAt4.getVisibility();
                        jc0VarH3.e0 = childAt4;
                        if (childAt4 instanceof ob0) {
                            boolean z10 = kc0Var.u0;
                            int i47 = ((vj) ((ob0) childAt4)).B0;
                            if (z10) {
                                if (i47 == 5) {
                                    i47 = 1;
                                } else if (i47 == 6) {
                                    i47 = 0;
                                }
                                if (jc0VarH3 instanceof wj) {
                                    ((wj) jc0VarH3).r0 = i47;
                                }
                            } else {
                                if (i47 != 5) {
                                    if (i47 == 6) {
                                    }
                                }
                                if (jc0VarH3 instanceof wj) {
                                }
                            }
                        }
                        if (qb0Var2.d0) {
                            nq1 nq1Var = (nq1) jc0VarH3;
                            int i48 = qb0Var2.m0;
                            int i49 = qb0Var2.n0;
                            float f4 = qb0Var2.o0;
                            if (f4 != -1.0f) {
                                if (f4 > -1.0f) {
                                    nq1Var.p0 = f4;
                                    b = -1;
                                    nq1Var.q0 = -1;
                                    nq1Var.r0 = -1;
                                    c = c2;
                                }
                                c = c2;
                            } else {
                                b = -1;
                                if (i48 != -1) {
                                    if (i48 > -1) {
                                        nq1Var.p0 = -1.0f;
                                        nq1Var.q0 = i48;
                                        nq1Var.r0 = -1;
                                    }
                                } else if (i49 != -1 && i49 > -1) {
                                    nq1Var.p0 = -1.0f;
                                    nq1Var.q0 = -1;
                                    nq1Var.r0 = i49;
                                    c = c2;
                                }
                                c = c2;
                            }
                        } else {
                            int i50 = qb0Var2.f0;
                            int i51 = qb0Var2.g0;
                            int i52 = qb0Var2.h0;
                            int i53 = qb0Var2.i0;
                            int i54 = qb0Var2.j0;
                            int i55 = qb0Var2.k0;
                            float f5 = qb0Var2.l0;
                            int i56 = qb0Var2.p;
                            if (i56 != -1) {
                                jc0 jc0Var7 = (jc0) sparseArray7.get(i56);
                                if (jc0Var7 != null) {
                                    float f6 = qb0Var2.r;
                                    jc0VarH3.t(7, 7, qb0Var2.q, 0, jc0Var7);
                                    jc0VarH3.D = f6;
                                }
                                jc0Var5 = jc0VarH3;
                                i17 = 4;
                                i18 = 2;
                                i13 = 5;
                                i19 = 3;
                                constraintLayout2 = constraintLayout2;
                            } else {
                                if (i50 != -1) {
                                    jc0 jc0Var8 = (jc0) sparseArray7.get(i50);
                                    if (jc0Var8 != null) {
                                        i5 = i55;
                                        f = f5;
                                        i4 = i53;
                                        i6 = 2;
                                        jc0VarH3.t(2, 2, ((ViewGroup.MarginLayoutParams) qb0Var2).leftMargin, i54, jc0Var8);
                                    } else {
                                        i4 = i53;
                                        i5 = i55;
                                        f = f5;
                                        i6 = 2;
                                    }
                                } else {
                                    i4 = i53;
                                    i5 = i55;
                                    i6 = 2;
                                    if (i51 == -1 || (jc0Var = (jc0) sparseArray7.get(i51)) == null) {
                                        f = f5;
                                    } else {
                                        f = f5;
                                        jc0VarH3.t(2, 4, ((ViewGroup.MarginLayoutParams) qb0Var2).leftMargin, i54, jc0Var);
                                        i7 = 2;
                                        i8 = 4;
                                        if (i52 == -1) {
                                            jc0 jc0Var9 = (jc0) sparseArray7.get(i52);
                                            if (jc0Var9 != null) {
                                                jc0VarH3.t(i8, i7, ((ViewGroup.MarginLayoutParams) qb0Var2).rightMargin, i5, jc0Var9);
                                            }
                                            i9 = i7;
                                        } else {
                                            i9 = i7;
                                            int i57 = i5;
                                            if (i4 != -1 && (jc0Var2 = (jc0) sparseArray7.get(i4)) != null) {
                                                jc0VarH3.t(i8, i8, ((ViewGroup.MarginLayoutParams) qb0Var2).rightMargin, i57, jc0Var2);
                                            }
                                        }
                                        int i58 = i8;
                                        i10 = qb0Var2.i;
                                        if (i10 == -1) {
                                            jc0 jc0Var10 = (jc0) sparseArray7.get(i10);
                                            if (jc0Var10 != null) {
                                                i20 = 3;
                                                jc0VarH3.t(3, 3, ((ViewGroup.MarginLayoutParams) qb0Var2).topMargin, qb0Var2.x, jc0Var10);
                                            } else {
                                                i20 = 3;
                                            }
                                            i12 = i20;
                                            i13 = 5;
                                            i11 = -1;
                                        } else {
                                            int i59 = qb0Var2.j;
                                            if (i59 == -1 || (jc0Var3 = (jc0) sparseArray7.get(i59)) == null) {
                                                i11 = -1;
                                                i12 = 3;
                                                i13 = 5;
                                            } else {
                                                i11 = -1;
                                                jc0VarH3.t(3, 5, ((ViewGroup.MarginLayoutParams) qb0Var2).topMargin, qb0Var2.x, jc0Var3);
                                                i12 = 3;
                                                i13 = 5;
                                            }
                                        }
                                        i14 = qb0Var2.k;
                                        if (i14 == i11) {
                                            jc0 jc0Var11 = (jc0) sparseArray7.get(i14);
                                            if (jc0Var11 != null) {
                                                jc0VarH3.t(i13, i12, ((ViewGroup.MarginLayoutParams) qb0Var2).bottomMargin, qb0Var2.z, jc0Var11);
                                            }
                                            i15 = i12;
                                        } else {
                                            i15 = i12;
                                            int i60 = qb0Var2.l;
                                            if (i60 != i11 && (jc0Var4 = (jc0) sparseArray7.get(i60)) != null) {
                                                jc0VarH3.t(i13, i13, ((ViewGroup.MarginLayoutParams) qb0Var2).bottomMargin, qb0Var2.z, jc0Var4);
                                            }
                                        }
                                        f2 = f;
                                        i16 = qb0Var2.m;
                                        if (i16 == -1) {
                                            i18 = i9;
                                            i17 = i58;
                                            jc0Var5 = jc0VarH3;
                                            constraintLayout2.l(jc0Var5, qb0Var2, sparseArray7, i16, 6);
                                            constraintLayout = this;
                                            i19 = i15;
                                        } else {
                                            i17 = i58;
                                            jc0Var5 = jc0VarH3;
                                            i18 = i9;
                                            int i61 = qb0Var2.n;
                                            if (i61 != -1) {
                                                ConstraintLayout constraintLayout3 = this;
                                                int i62 = i15;
                                                constraintLayout3.l(jc0Var5, qb0Var2, sparseArray7, i61, i62);
                                                i19 = i62;
                                                constraintLayout = constraintLayout3;
                                            } else {
                                                i19 = i15;
                                                int i63 = qb0Var2.o;
                                                ConstraintLayout constraintLayout4 = this;
                                                constraintLayout = constraintLayout4;
                                                if (i63 != -1) {
                                                    constraintLayout4.l(jc0Var5, qb0Var2, sparseArray7, i63, i13);
                                                    constraintLayout = constraintLayout4;
                                                }
                                            }
                                        }
                                        if (f2 >= 0.0f) {
                                            jc0Var5.c0 = f2;
                                        }
                                        f3 = qb0Var2.F;
                                        constraintLayout2 = constraintLayout;
                                        if (f3 >= 0.0f) {
                                            jc0Var5.d0 = f3;
                                            constraintLayout2 = constraintLayout;
                                        }
                                    }
                                }
                                i7 = i6;
                                i8 = 4;
                                if (i52 == -1) {
                                }
                                int i582 = i8;
                                i10 = qb0Var2.i;
                                if (i10 == -1) {
                                }
                                i14 = qb0Var2.k;
                                if (i14 == i11) {
                                }
                                f2 = f;
                                i16 = qb0Var2.m;
                                if (i16 == -1) {
                                }
                                if (f2 >= 0.0f) {
                                }
                                f3 = qb0Var2.F;
                                constraintLayout2 = constraintLayout;
                                if (f3 >= 0.0f) {
                                }
                            }
                            if (z3 && ((i24 = qb0Var2.T) != -1 || qb0Var2.U != -1)) {
                                int i64 = qb0Var2.U;
                                jc0Var5.X = i24;
                                jc0Var5.Y = i64;
                            }
                            if (qb0Var2.a0) {
                                jc0Var5.I(1);
                                jc0Var5.K(((ViewGroup.MarginLayoutParams) qb0Var2).width);
                                if (((ViewGroup.MarginLayoutParams) qb0Var2).width == -2) {
                                    jc0Var5.I(2);
                                }
                            } else if (((ViewGroup.MarginLayoutParams) qb0Var2).width == -1) {
                                if (qb0Var2.W) {
                                    jc0Var5.I(3);
                                } else {
                                    jc0Var5.I(4);
                                }
                                jc0Var5.g(i18).g = ((ViewGroup.MarginLayoutParams) qb0Var2).leftMargin;
                                jc0Var5.g(i17).g = ((ViewGroup.MarginLayoutParams) qb0Var2).rightMargin;
                            } else {
                                jc0Var5.I(3);
                                jc0Var5.K(0);
                            }
                            if (qb0Var2.b0) {
                                i21 = -1;
                                jc0Var5.J(1);
                                jc0Var5.H(((ViewGroup.MarginLayoutParams) qb0Var2).height);
                                if (((ViewGroup.MarginLayoutParams) qb0Var2).height == -2) {
                                    jc0Var5.J(2);
                                }
                            } else {
                                i21 = -1;
                                if (((ViewGroup.MarginLayoutParams) qb0Var2).height == -1) {
                                    if (qb0Var2.X) {
                                        jc0Var5.J(3);
                                    } else {
                                        jc0Var5.J(4);
                                    }
                                    jc0Var5.g(i19).g = ((ViewGroup.MarginLayoutParams) qb0Var2).topMargin;
                                    jc0Var5.g(i13).g = ((ViewGroup.MarginLayoutParams) qb0Var2).bottomMargin;
                                } else {
                                    jc0Var5.J(3);
                                    jc0Var5.H(0);
                                }
                            }
                            String str6 = qb0Var2.G;
                            if (str6 == null || str6.length() == 0) {
                                jc0Var5.V = 0.0f;
                            } else {
                                int length = str6.length();
                                int iIndexOf3 = str6.indexOf(44);
                                if (iIndexOf3 <= 0 || iIndexOf3 >= length - 1) {
                                    i22 = i21;
                                    i23 = 0;
                                } else {
                                    String strSubstring = str6.substring(0, iIndexOf3);
                                    i22 = strSubstring.equalsIgnoreCase("W") ? 0 : strSubstring.equalsIgnoreCase("H") ? 1 : i21;
                                    i23 = iIndexOf3 + 1;
                                }
                                int iIndexOf4 = str6.indexOf(58);
                                if (iIndexOf4 < 0 || iIndexOf4 >= length - 1) {
                                    String strSubstring2 = str6.substring(i23);
                                    fAbs = strSubstring2.length() > 0 ? Float.parseFloat(strSubstring2) : 0.0f;
                                    if (fAbs > 0.0f) {
                                        jc0Var5.V = fAbs;
                                        jc0Var5.W = i22;
                                    }
                                } else {
                                    String strSubstring3 = str6.substring(i23, iIndexOf4);
                                    String strSubstring4 = str6.substring(iIndexOf4 + 1);
                                    if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                                        try {
                                            float f7 = Float.parseFloat(strSubstring3);
                                            float f8 = Float.parseFloat(strSubstring4);
                                            if (f7 > 0.0f && f8 > 0.0f) {
                                                fAbs = i22 == 1 ? Math.abs(f8 / f7) : Math.abs(f7 / f8);
                                            }
                                        } catch (NumberFormatException unused4) {
                                        }
                                        if (fAbs > 0.0f) {
                                        }
                                    }
                                }
                            }
                            float f9 = qb0Var2.H;
                            float[] fArr = jc0Var5.j0;
                            fArr[0] = f9;
                            fArr[1] = qb0Var2.I;
                            jc0Var5.h0 = qb0Var2.J;
                            jc0Var5.i0 = qb0Var2.K;
                            int i65 = qb0Var2.Z;
                            if (i65 >= 0 && i65 <= 3) {
                                jc0Var5.q = i65;
                            }
                            int i66 = qb0Var2.L;
                            int i67 = qb0Var2.N;
                            int i68 = qb0Var2.P;
                            float f10 = qb0Var2.R;
                            jc0Var5.r = i66;
                            jc0Var5.u = i67;
                            if (i68 == Integer.MAX_VALUE) {
                                i68 = 0;
                            }
                            jc0Var5.v = i68;
                            jc0Var5.w = f10;
                            if (f10 > 0.0f && f10 < 1.0f && i66 == 0) {
                                jc0Var5.r = 2;
                            }
                            int i69 = qb0Var2.M;
                            int i70 = qb0Var2.O;
                            int i71 = qb0Var2.Q;
                            float f11 = qb0Var2.S;
                            jc0Var5.s = i69;
                            jc0Var5.x = i70;
                            if (i71 == Integer.MAX_VALUE) {
                                i71 = 0;
                            }
                            jc0Var5.y = i71;
                            jc0Var5.z = f11;
                            if (f11 <= 0.0f || f11 >= 1.0f || i69 != 0) {
                                c = 2;
                            } else {
                                c = 2;
                                jc0Var5.s = 2;
                            }
                        }
                    }
                    i46++;
                    c2 = c;
                    constraintLayout2 = constraintLayout2;
                }
            } else {
                kc0Var = kc0Var4;
                z2 = z;
            }
            if (z2) {
                kc0Var.q0.a0(kc0Var);
            }
        } else {
            kc0Var = kc0Var4;
        }
        kc0Var.v0.getClass();
        constraintLayout2.k(kc0Var, constraintLayout2.C0, i, i2);
        int iO = kc0Var.o();
        int i72 = kc0Var.i();
        boolean z11 = kc0Var.D0;
        boolean z12 = kc0Var.E0;
        rb0 rb0Var = constraintLayout2.I0;
        int i73 = rb0Var.e;
        int iResolveSizeAndState = View.resolveSizeAndState(iO + rb0Var.d, i, 0);
        int iResolveSizeAndState2 = View.resolveSizeAndState(i72 + i73, i2, 0) & 16777215;
        int iMin = Math.min(constraintLayout2.z0, iResolveSizeAndState & 16777215);
        int iMin2 = Math.min(constraintLayout2.A0, iResolveSizeAndState2);
        if (z11) {
            iMin |= 16777216;
        }
        if (z12) {
            iMin2 |= 16777216;
        }
        constraintLayout2.setMeasuredDimension(iMin, iMin2);
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        super.onViewAdded(view);
        jc0 jc0VarH = h(view);
        if ((view instanceof Guideline) && !(jc0VarH instanceof nq1)) {
            qb0 qb0Var = (qb0) view.getLayoutParams();
            nq1 nq1Var = new nq1();
            qb0Var.p0 = nq1Var;
            qb0Var.d0 = true;
            nq1Var.O(qb0Var.V);
        }
        if (view instanceof ob0) {
            ob0 ob0Var = (ob0) view;
            ob0Var.e();
            ((qb0) view.getLayoutParams()).e0 = true;
            ArrayList arrayList = this.f;
            if (!arrayList.contains(ob0Var)) {
                arrayList.add(ob0Var);
            }
        }
        this.b.put(view.getId(), view);
        this.B0 = true;
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.b.remove(view.getId());
        jc0 jc0VarH = h(view);
        this.z.p0.remove(jc0VarH);
        jc0VarH.A();
        this.f.remove(view);
        this.B0 = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        this.B0 = true;
        super.requestLayout();
    }

    public void setConstraintSet(ac0 ac0Var) {
        this.D0 = ac0Var;
    }

    @Override // android.view.View
    public void setId(int i) {
        int id = getId();
        SparseArray sparseArray = this.b;
        sparseArray.remove(id);
        super.setId(i);
        sparseArray.put(getId(), this);
    }

    public void setMaxHeight(int i) {
        if (i == this.A0) {
            return;
        }
        this.A0 = i;
        requestLayout();
    }

    public void setMaxWidth(int i) {
        if (i == this.z0) {
            return;
        }
        this.z0 = i;
        requestLayout();
    }

    public void setMinHeight(int i) {
        if (i == this.y0) {
            return;
        }
        this.y0 = i;
        requestLayout();
    }

    public void setMinWidth(int i) {
        if (i == this.A) {
            return;
        }
        this.A = i;
        requestLayout();
    }

    public void setOnConstraintsChanged(nc0 nc0Var) {
        lb lbVar = this.E0;
        if (lbVar != null) {
            lbVar.getClass();
        }
    }

    public void setOptimizationLevel(int i) {
        this.C0 = i;
        kc0 kc0Var = this.z;
        kc0Var.C0 = i;
        gb2.q = kc0Var.S(512);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new SparseArray();
        this.f = new ArrayList(4);
        this.z = new kc0();
        this.A = 0;
        this.y0 = 0;
        this.z0 = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
        this.A0 = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
        this.B0 = true;
        this.C0 = 257;
        this.D0 = null;
        this.E0 = null;
        this.F0 = -1;
        this.G0 = new HashMap();
        this.H0 = new SparseArray();
        this.I0 = new rb0(this, this);
        i(attributeSet);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        qb0 qb0Var = new qb0(layoutParams);
        qb0Var.a = -1;
        qb0Var.b = -1;
        qb0Var.c = -1.0f;
        qb0Var.d = true;
        qb0Var.e = -1;
        qb0Var.f = -1;
        qb0Var.g = -1;
        qb0Var.h = -1;
        qb0Var.i = -1;
        qb0Var.j = -1;
        qb0Var.k = -1;
        qb0Var.l = -1;
        qb0Var.m = -1;
        qb0Var.n = -1;
        qb0Var.o = -1;
        qb0Var.p = -1;
        qb0Var.q = 0;
        qb0Var.r = 0.0f;
        qb0Var.s = -1;
        qb0Var.t = -1;
        qb0Var.u = -1;
        qb0Var.v = -1;
        qb0Var.w = Integer.MIN_VALUE;
        qb0Var.x = Integer.MIN_VALUE;
        qb0Var.y = Integer.MIN_VALUE;
        qb0Var.z = Integer.MIN_VALUE;
        qb0Var.A = Integer.MIN_VALUE;
        qb0Var.B = Integer.MIN_VALUE;
        qb0Var.C = Integer.MIN_VALUE;
        qb0Var.D = 0;
        qb0Var.E = 0.5f;
        qb0Var.F = 0.5f;
        qb0Var.G = null;
        qb0Var.H = -1.0f;
        qb0Var.I = -1.0f;
        qb0Var.J = 0;
        qb0Var.K = 0;
        qb0Var.L = 0;
        qb0Var.M = 0;
        qb0Var.N = 0;
        qb0Var.O = 0;
        qb0Var.P = 0;
        qb0Var.Q = 0;
        qb0Var.R = 1.0f;
        qb0Var.S = 1.0f;
        qb0Var.T = -1;
        qb0Var.U = -1;
        qb0Var.V = -1;
        qb0Var.W = false;
        qb0Var.X = false;
        qb0Var.Y = null;
        qb0Var.Z = 0;
        qb0Var.a0 = true;
        qb0Var.b0 = true;
        qb0Var.c0 = false;
        qb0Var.d0 = false;
        qb0Var.e0 = false;
        qb0Var.f0 = -1;
        qb0Var.g0 = -1;
        qb0Var.h0 = -1;
        qb0Var.i0 = -1;
        qb0Var.j0 = Integer.MIN_VALUE;
        qb0Var.k0 = Integer.MIN_VALUE;
        qb0Var.l0 = 0.5f;
        qb0Var.p0 = new jc0();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) qb0Var).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) qb0Var).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) qb0Var).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) qb0Var).bottomMargin = marginLayoutParams.bottomMargin;
            qb0Var.setMarginStart(marginLayoutParams.getMarginStart());
            qb0Var.setMarginEnd(marginLayoutParams.getMarginEnd());
        }
        if (!(layoutParams instanceof qb0)) {
            return qb0Var;
        }
        qb0 qb0Var2 = (qb0) layoutParams;
        qb0Var.a = qb0Var2.a;
        qb0Var.b = qb0Var2.b;
        qb0Var.c = qb0Var2.c;
        qb0Var.d = qb0Var2.d;
        qb0Var.e = qb0Var2.e;
        qb0Var.f = qb0Var2.f;
        qb0Var.g = qb0Var2.g;
        qb0Var.h = qb0Var2.h;
        qb0Var.i = qb0Var2.i;
        qb0Var.j = qb0Var2.j;
        qb0Var.k = qb0Var2.k;
        qb0Var.l = qb0Var2.l;
        qb0Var.m = qb0Var2.m;
        qb0Var.n = qb0Var2.n;
        qb0Var.o = qb0Var2.o;
        qb0Var.p = qb0Var2.p;
        qb0Var.q = qb0Var2.q;
        qb0Var.r = qb0Var2.r;
        qb0Var.s = qb0Var2.s;
        qb0Var.t = qb0Var2.t;
        qb0Var.u = qb0Var2.u;
        qb0Var.v = qb0Var2.v;
        qb0Var.w = qb0Var2.w;
        qb0Var.x = qb0Var2.x;
        qb0Var.y = qb0Var2.y;
        qb0Var.z = qb0Var2.z;
        qb0Var.A = qb0Var2.A;
        qb0Var.B = qb0Var2.B;
        qb0Var.C = qb0Var2.C;
        qb0Var.D = qb0Var2.D;
        qb0Var.E = qb0Var2.E;
        qb0Var.F = qb0Var2.F;
        qb0Var.G = qb0Var2.G;
        qb0Var.H = qb0Var2.H;
        qb0Var.I = qb0Var2.I;
        qb0Var.J = qb0Var2.J;
        qb0Var.K = qb0Var2.K;
        qb0Var.W = qb0Var2.W;
        qb0Var.X = qb0Var2.X;
        qb0Var.L = qb0Var2.L;
        qb0Var.M = qb0Var2.M;
        qb0Var.N = qb0Var2.N;
        qb0Var.P = qb0Var2.P;
        qb0Var.O = qb0Var2.O;
        qb0Var.Q = qb0Var2.Q;
        qb0Var.R = qb0Var2.R;
        qb0Var.S = qb0Var2.S;
        qb0Var.T = qb0Var2.T;
        qb0Var.U = qb0Var2.U;
        qb0Var.V = qb0Var2.V;
        qb0Var.a0 = qb0Var2.a0;
        qb0Var.b0 = qb0Var2.b0;
        qb0Var.c0 = qb0Var2.c0;
        qb0Var.d0 = qb0Var2.d0;
        qb0Var.f0 = qb0Var2.f0;
        qb0Var.g0 = qb0Var2.g0;
        qb0Var.h0 = qb0Var2.h0;
        qb0Var.i0 = qb0Var2.i0;
        qb0Var.j0 = qb0Var2.j0;
        qb0Var.k0 = qb0Var2.k0;
        qb0Var.l0 = qb0Var2.l0;
        qb0Var.Y = qb0Var2.Y;
        qb0Var.Z = qb0Var2.Z;
        qb0Var.p0 = qb0Var2.p0;
        return qb0Var;
    }
}
