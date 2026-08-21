package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mars.xlog.Xlog;
import defpackage.ac0;
import defpackage.gb2;
import defpackage.jc0;
import defpackage.kc0;
import defpackage.lb;
import defpackage.nc0;
import defpackage.nq1;
import defpackage.ob0;
import defpackage.pb0;
import defpackage.qb0;
import defpackage.rb0;
import defpackage.sb0;
import defpackage.tb0;
import defpackage.uv3;
import defpackage.wc3;
import io.netty.channel.internal.ChannelUtils;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.netty.handler.ssl.OpenSslSessionTicketKey;
import io.sentry.android.core.a1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(defpackage.kc0 r27, int r28, int r29, int r30) {
        /*
            Method dump skipped, instruction units count: 1624
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.k(kc0, int, int, int):void");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r33, int r34) {
        /*
            Method dump skipped, instruction units count: 2584
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.onMeasure(int, int):void");
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
