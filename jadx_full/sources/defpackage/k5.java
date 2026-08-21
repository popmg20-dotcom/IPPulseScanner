package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.ui.service.ExplorerService;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFactory;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k5 {
    public int a;
    public final Object b;
    public Object c;
    public Object d;
    public Object e;
    public Object f;

    public k5(pf3 pf3Var) {
        this.b = new c23(30);
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.a = 0;
        this.e = pf3Var;
        this.f = new wn1(10, this);
    }

    public void a() {
        View view = (View) this.b;
        Drawable background = view.getBackground();
        if (background != null) {
            if (((cb0) this.d) != null) {
                cb0 cb0Var = (cb0) this.f;
                if (cb0Var == null) {
                    cb0Var = new cb0();
                    this.f = cb0Var;
                }
                cb0Var.c = null;
                cb0Var.b = false;
                cb0Var.d = null;
                cb0Var.a = false;
                WeakHashMap weakHashMap = wp4.a;
                ColorStateList backgroundTintList = view.getBackgroundTintList();
                if (backgroundTintList != null) {
                    cb0Var.b = true;
                    cb0Var.c = backgroundTintList;
                }
                PorterDuff.Mode backgroundTintMode = view.getBackgroundTintMode();
                if (backgroundTintMode != null) {
                    cb0Var.a = true;
                    cb0Var.d = backgroundTintMode;
                }
                if (cb0Var.b || cb0Var.a) {
                    int[] drawableState = view.getDrawableState();
                    PorterDuff.Mode mode = db.b;
                    ck3.o(background, cb0Var, drawableState);
                    return;
                }
            }
            cb0 cb0Var2 = (cb0) this.e;
            if (cb0Var2 != null) {
                int[] drawableState2 = view.getDrawableState();
                PorterDuff.Mode mode2 = db.b;
                ck3.o(background, cb0Var2, drawableState2);
            } else {
                cb0 cb0Var3 = (cb0) this.d;
                if (cb0Var3 != null) {
                    int[] drawableState3 = view.getDrawableState();
                    PorterDuff.Mode mode3 = db.b;
                    ck3.o(background, cb0Var3, drawableState3);
                }
            }
        }
    }

    public boolean b(int i) {
        ArrayList arrayList = (ArrayList) this.d;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            j5 j5Var = (j5) arrayList.get(i2);
            int i3 = j5Var.a;
            if (i3 != 8) {
                if (i3 == 1) {
                    int i4 = j5Var.b;
                    int i5 = j5Var.d + i4;
                    while (i4 < i5) {
                        if (h(i4, i2 + 1) == i) {
                            return true;
                        }
                        i4++;
                    }
                } else {
                    continue;
                }
            } else {
                if (h(j5Var.d, i2 + 1) == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public void c() {
        ChannelFuture channelFutureClose;
        try {
            Channel channel = (Channel) this.f;
            if (channel != null && (channelFutureClose = channel.close()) != null) {
                channelFutureClose.sync2();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ((NioEventLoopGroup) this.d).shutdownGracefully();
        ((NioEventLoopGroup) this.e).shutdownGracefully();
    }

    public void d() {
        ArrayList arrayList = (ArrayList) this.d;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((pf3) this.e).a((j5) arrayList.get(i));
        }
        s(arrayList);
        this.a = 0;
    }

    public void e() {
        pf3 pf3Var = (pf3) this.e;
        d();
        ArrayList arrayList = (ArrayList) this.c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            j5 j5Var = (j5) arrayList.get(i);
            int i2 = j5Var.a;
            if (i2 == 1) {
                pf3Var.a(j5Var);
                pf3Var.d(j5Var.b, j5Var.d);
            } else if (i2 == 2) {
                pf3Var.a(j5Var);
                int i3 = j5Var.b;
                int i4 = j5Var.d;
                RecyclerView recyclerView = pf3Var.a;
                recyclerView.W(i3, i4, true);
                recyclerView.B1 = true;
                recyclerView.y1.c += i4;
            } else if (i2 == 4) {
                pf3Var.a(j5Var);
                pf3Var.c(j5Var.b, j5Var.d, j5Var.c);
            } else if (i2 == 8) {
                pf3Var.a(j5Var);
                pf3Var.e(j5Var.b, j5Var.d);
            }
        }
        s(arrayList);
        this.a = 0;
    }

    public void f(j5 j5Var) {
        int i;
        c23 c23Var = (c23) this.b;
        int i2 = j5Var.a;
        if (i2 == 1 || i2 == 8) {
            xe.k("should not dispatch add or move for pre layout");
            return;
        }
        int iW = w(j5Var.b, i2);
        int i3 = j5Var.b;
        int i4 = j5Var.a;
        if (i4 == 2) {
            i = 0;
        } else {
            if (i4 != 4) {
                vp1.h(j5Var, "op should be remove or update.");
                return;
            }
            i = 1;
        }
        int i5 = 1;
        for (int i6 = 1; i6 < j5Var.d; i6++) {
            int iW2 = w((i * i6) + j5Var.b, j5Var.a);
            int i7 = j5Var.a;
            if (i7 == 2 ? iW2 != iW : !(i7 == 4 && iW2 == iW + 1)) {
                j5 j5VarN = n(j5Var.c, i7, iW, i5);
                g(j5VarN, i3);
                j5VarN.c = null;
                c23Var.c(j5VarN);
                if (j5Var.a == 4) {
                    i3 += i5;
                }
                i5 = 1;
                iW = iW2;
            } else {
                i5++;
            }
        }
        Object obj = j5Var.c;
        j5Var.c = null;
        c23Var.c(j5Var);
        if (i5 > 0) {
            j5 j5VarN2 = n(obj, j5Var.a, iW, i5);
            g(j5VarN2, i3);
            j5VarN2.c = null;
            c23Var.c(j5VarN2);
        }
    }

    public void g(j5 j5Var, int i) {
        pf3 pf3Var = (pf3) this.e;
        pf3Var.a(j5Var);
        int i2 = j5Var.a;
        if (i2 != 2) {
            if (i2 == 4) {
                pf3Var.c(i, j5Var.d, j5Var.c);
                return;
            } else {
                xe.k("only remove and update ops can be dispatched in first pass");
                return;
            }
        }
        int i3 = j5Var.d;
        RecyclerView recyclerView = pf3Var.a;
        recyclerView.W(i, i3, true);
        recyclerView.B1 = true;
        recyclerView.y1.c += i3;
    }

    public int h(int i, int i2) {
        ArrayList arrayList = (ArrayList) this.d;
        int size = arrayList.size();
        while (i2 < size) {
            j5 j5Var = (j5) arrayList.get(i2);
            int i3 = j5Var.a;
            int i4 = j5Var.b;
            if (i3 == 8) {
                if (i4 == i) {
                    i = j5Var.d;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (j5Var.d <= i) {
                        i++;
                    }
                }
            } else if (i4 > i) {
                continue;
            } else if (i3 == 2) {
                int i5 = j5Var.d;
                if (i < i4 + i5) {
                    return -1;
                }
                i -= i5;
            } else if (i3 == 1) {
                i += j5Var.d;
            }
            i2++;
        }
        return i;
    }

    public ColorStateList i() {
        cb0 cb0Var = (cb0) this.e;
        if (cb0Var != null) {
            return (ColorStateList) cb0Var.c;
        }
        return null;
    }

    public PorterDuff.Mode j() {
        cb0 cb0Var = (cb0) this.e;
        if (cb0Var != null) {
            return (PorterDuff.Mode) cb0Var.d;
        }
        return null;
    }

    public boolean k() {
        return ((ArrayList) this.c).size() > 0;
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [io.netty.channel.ChannelFuture] */
    public void l(InetAddress inetAddress, int i) throws Exception {
        this.c = inetAddress;
        this.a = i;
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group((NioEventLoopGroup) this.d, (NioEventLoopGroup) this.e).channelFactory((ChannelFactory) new a71(3)).childHandler(new v81(this)).option(ChannelOption.SO_BACKLOG, 128).childOption(ChannelOption.SO_KEEPALIVE, Boolean.TRUE);
            this.f = serverBootstrap.bind(inetAddress, i).sync2().channel();
        } catch (Exception e) {
            c();
            throw e;
        }
    }

    public void m(AttributeSet attributeSet, int i) {
        ColorStateList colorStateListI;
        View view = (View) this.b;
        Context context = view.getContext();
        int[] iArr = cd3.A;
        n02 n02VarY = n02.y(context, attributeSet, iArr, i);
        TypedArray typedArray = (TypedArray) n02VarY.z;
        View view2 = (View) this.b;
        wp4.m(view2, view2.getContext(), iArr, attributeSet, (TypedArray) n02VarY.z, i);
        try {
            if (typedArray.hasValue(0)) {
                this.a = typedArray.getResourceId(0, -1);
                db dbVar = (db) this.c;
                Context context2 = view.getContext();
                int i2 = this.a;
                synchronized (dbVar) {
                    colorStateListI = dbVar.a.i(context2, i2);
                }
                if (colorStateListI != null) {
                    t(colorStateListI);
                }
            }
            if (typedArray.hasValue(1)) {
                view.setBackgroundTintList(n02VarY.n(1));
            }
            if (typedArray.hasValue(2)) {
                view.setBackgroundTintMode(tx0.c(typedArray.getInt(2, -1), null));
            }
            n02VarY.K();
        } catch (Throwable th) {
            n02VarY.K();
            throw th;
        }
    }

    public j5 n(Object obj, int i, int i2, int i3) {
        j5 j5Var = (j5) ((c23) this.b).a();
        if (j5Var != null) {
            j5Var.a = i;
            j5Var.b = i2;
            j5Var.d = i3;
            j5Var.c = obj;
            return j5Var;
        }
        j5 j5Var2 = new j5();
        j5Var2.a = i;
        j5Var2.b = i2;
        j5Var2.d = i3;
        j5Var2.c = obj;
        return j5Var2;
    }

    public void o() {
        this.a = -1;
        t(null);
        a();
    }

    public void p(int i) {
        ColorStateList colorStateListI;
        this.a = i;
        db dbVar = (db) this.c;
        if (dbVar != null) {
            Context context = ((View) this.b).getContext();
            synchronized (dbVar) {
                colorStateListI = dbVar.a.i(context, i);
            }
        } else {
            colorStateListI = null;
        }
        t(colorStateListI);
        a();
    }

    public void q(j5 j5Var) {
        pf3 pf3Var = (pf3) this.e;
        ((ArrayList) this.d).add(j5Var);
        int i = j5Var.a;
        if (i == 1) {
            pf3Var.d(j5Var.b, j5Var.d);
            return;
        }
        if (i == 2) {
            int i2 = j5Var.b;
            int i3 = j5Var.d;
            RecyclerView recyclerView = pf3Var.a;
            recyclerView.W(i2, i3, false);
            recyclerView.B1 = true;
            return;
        }
        if (i == 4) {
            pf3Var.c(j5Var.b, j5Var.d, j5Var.c);
        } else if (i == 8) {
            pf3Var.e(j5Var.b, j5Var.d);
        } else {
            vp1.h(j5Var, "Unknown update op type for ");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:188:0x00ae A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0130 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0123 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0012 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void r() {
        boolean z;
        byte b;
        j5 j5VarN;
        int i;
        int i2;
        j5 j5VarN2;
        boolean z2;
        boolean z3;
        Object obj;
        j5 j5Var;
        c23 c23Var = (c23) this.b;
        pf3 pf3Var = (pf3) this.e;
        wn1 wn1Var = (wn1) this.f;
        ArrayList arrayList = (ArrayList) this.c;
        while (true) {
            int size = arrayList.size() - 1;
            boolean z4 = false;
            while (true) {
                if (size < 0) {
                    size = -1;
                    break;
                }
                if (((j5) arrayList.get(size)).a == 8) {
                    if (z4) {
                        break;
                    }
                } else {
                    z4 = true;
                }
                size--;
            }
            if (size == -1) {
                break;
            }
            int i3 = size + 1;
            k5 k5Var = (k5) wn1Var.f;
            c23 c23Var2 = (c23) k5Var.b;
            j5 j5Var2 = (j5) arrayList.get(size);
            j5 j5Var3 = (j5) arrayList.get(i3);
            int i4 = j5Var3.a;
            if (i4 == 1) {
                int i5 = j5Var2.d;
                int i6 = j5Var3.b;
                int i7 = i5 < i6 ? -1 : 0;
                int i8 = j5Var2.b;
                if (i8 < i6) {
                    i7++;
                }
                if (i6 <= i8) {
                    j5Var2.b = i8 + j5Var3.d;
                }
                int i9 = j5Var3.b;
                if (i9 <= i5) {
                    j5Var2.d = i5 + j5Var3.d;
                }
                j5Var3.b = i9 + i7;
                arrayList.set(size, j5Var3);
                arrayList.set(i3, j5Var2);
            } else if (i4 == 2) {
                int i10 = j5Var2.b;
                int i11 = j5Var2.d;
                int i12 = j5Var3.b;
                if (i10 < i11) {
                    if (i12 == i10 && j5Var3.d == i11 - i10) {
                        z2 = false;
                        z3 = true;
                    } else {
                        z2 = false;
                        z3 = false;
                    }
                } else if (i12 == i11 + 1 && j5Var3.d == i10 - i11) {
                    z2 = true;
                    z3 = true;
                } else {
                    z2 = true;
                    z3 = false;
                }
                if (i11 < i12) {
                    i12--;
                    j5Var3.b = i12;
                } else {
                    int i13 = j5Var3.d;
                    if (i11 < i12 + i13) {
                        j5Var3.d = i13 - 1;
                        j5Var2.a = 2;
                        j5Var2.d = 1;
                        if (j5Var3.d == 0) {
                            arrayList.remove(i3);
                            j5Var3.c = null;
                            c23Var2.c(j5Var3);
                        }
                    }
                }
                int i14 = j5Var2.b;
                if (i14 <= i12) {
                    j5Var3.b = i12 + 1;
                } else {
                    int i15 = i12 + j5Var3.d;
                    if (i14 < i15) {
                        obj = null;
                        j5 j5VarN3 = k5Var.n(null, 2, i14 + 1, i15 - i14);
                        j5Var3.d = j5Var2.b - j5Var3.b;
                        j5Var = j5VarN3;
                    }
                    if (z3) {
                        if (z2) {
                            if (j5Var != null) {
                                int i16 = j5Var2.b;
                                if (i16 > j5Var.b) {
                                    j5Var2.b = i16 - j5Var.d;
                                }
                                int i17 = j5Var2.d;
                                if (i17 > j5Var.b) {
                                    j5Var2.d = i17 - j5Var.d;
                                }
                            }
                            int i18 = j5Var2.b;
                            if (i18 > j5Var3.b) {
                                j5Var2.b = i18 - j5Var3.d;
                            }
                            int i19 = j5Var2.d;
                            if (i19 > j5Var3.b) {
                                j5Var2.d = i19 - j5Var3.d;
                            }
                        } else {
                            if (j5Var != null) {
                                int i20 = j5Var2.b;
                                if (i20 >= j5Var.b) {
                                    j5Var2.b = i20 - j5Var.d;
                                }
                                int i21 = j5Var2.d;
                                if (i21 >= j5Var.b) {
                                    j5Var2.d = i21 - j5Var.d;
                                }
                            }
                            int i22 = j5Var2.b;
                            if (i22 >= j5Var3.b) {
                                j5Var2.b = i22 - j5Var3.d;
                            }
                            int i23 = j5Var2.d;
                            if (i23 >= j5Var3.b) {
                                j5Var2.d = i23 - j5Var3.d;
                            }
                        }
                        arrayList.set(size, j5Var3);
                        if (j5Var2.b != j5Var2.d) {
                            arrayList.set(i3, j5Var2);
                        } else {
                            arrayList.remove(i3);
                        }
                        if (j5Var != null) {
                            arrayList.add(size, j5Var);
                        }
                    } else {
                        arrayList.set(size, j5Var3);
                        arrayList.remove(i3);
                        j5Var2.c = obj;
                        c23Var2.c(j5Var2);
                    }
                }
                obj = null;
                j5Var = null;
                if (z3) {
                }
            } else if (i4 == 4) {
                int i24 = j5Var2.d;
                int i25 = j5Var3.b;
                if (i24 < i25) {
                    j5Var3.b = i25 - 1;
                } else {
                    int i26 = j5Var3.d;
                    if (i24 < i25 + i26) {
                        j5Var3.d = i26 - 1;
                        j5VarN = k5Var.n(j5Var3.c, 4, j5Var2.b, 1);
                    }
                    i = j5Var2.b;
                    i2 = j5Var3.b;
                    if (i > i2) {
                        j5Var3.b = i2 + 1;
                    } else {
                        int i27 = i2 + j5Var3.d;
                        if (i < i27) {
                            int i28 = i27 - i;
                            j5VarN2 = k5Var.n(j5Var3.c, 4, i + 1, i28);
                            j5Var3.d -= i28;
                        }
                        arrayList.set(i3, j5Var2);
                        if (j5Var3.d > 0) {
                            arrayList.set(size, j5Var3);
                        } else {
                            arrayList.remove(size);
                            j5Var3.c = null;
                            c23Var2.c(j5Var3);
                        }
                        if (j5VarN != null) {
                            arrayList.add(size, j5VarN);
                        }
                        if (j5VarN2 != null) {
                            arrayList.add(size, j5VarN2);
                        }
                    }
                    j5VarN2 = null;
                    arrayList.set(i3, j5Var2);
                    if (j5Var3.d > 0) {
                    }
                    if (j5VarN != null) {
                    }
                    if (j5VarN2 != null) {
                    }
                }
                j5VarN = null;
                i = j5Var2.b;
                i2 = j5Var3.b;
                if (i > i2) {
                }
                j5VarN2 = null;
                arrayList.set(i3, j5Var2);
                if (j5Var3.d > 0) {
                }
                if (j5VarN != null) {
                }
                if (j5VarN2 != null) {
                }
            }
        }
        int size2 = arrayList.size();
        for (int i29 = 0; i29 < size2; i29++) {
            j5 j5VarN4 = (j5) arrayList.get(i29);
            int i30 = j5VarN4.a;
            if (i30 == 1) {
                q(j5VarN4);
            } else if (i30 == 2) {
                int i31 = j5VarN4.b;
                int i32 = j5VarN4.d + i31;
                int i33 = i31;
                int i34 = 0;
                byte b2 = -1;
                while (i33 < i32) {
                    if (pf3Var.b(i33) != null || b(i33)) {
                        if (b2 == 0) {
                            f(n(null, 2, i31, i34));
                            z = true;
                        } else {
                            z = false;
                        }
                        b = 1;
                    } else {
                        if (b2 == 1) {
                            q(n(null, 2, i31, i34));
                            z = true;
                        } else {
                            z = false;
                        }
                        b = 0;
                    }
                    if (z) {
                        i33 -= i34;
                        i32 -= i34;
                        i34 = 1;
                    } else {
                        i34++;
                    }
                    i33++;
                    b2 = b;
                }
                if (i34 != j5VarN4.d) {
                    j5VarN4.c = null;
                    c23Var.c(j5VarN4);
                    j5VarN4 = n(null, 2, i31, i34);
                }
                if (b2 == 0) {
                    f(j5VarN4);
                } else {
                    q(j5VarN4);
                }
            } else if (i30 == 4) {
                int i35 = j5VarN4.b;
                int i36 = j5VarN4.d + i35;
                int i37 = i35;
                int i38 = 0;
                byte b3 = -1;
                while (i35 < i36) {
                    if (pf3Var.b(i35) != null || b(i35)) {
                        if (b3 == 0) {
                            f(n(j5VarN4.c, 4, i37, i38));
                            i37 = i35;
                            i38 = 0;
                        }
                        b3 = 1;
                    } else {
                        if (b3 == 1) {
                            q(n(j5VarN4.c, 4, i37, i38));
                            i37 = i35;
                            i38 = 0;
                        }
                        b3 = 0;
                    }
                    i38++;
                    i35++;
                }
                if (i38 != j5VarN4.d) {
                    Object obj2 = j5VarN4.c;
                    j5VarN4.c = null;
                    c23Var.c(j5VarN4);
                    j5VarN4 = n(obj2, 4, i37, i38);
                }
                if (b3 == 0) {
                    f(j5VarN4);
                } else {
                    q(j5VarN4);
                }
            } else if (i30 == 8) {
                q(j5VarN4);
            }
        }
        arrayList.clear();
    }

    public void s(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            j5 j5Var = (j5) arrayList.get(i);
            j5Var.c = null;
            ((c23) this.b).c(j5Var);
        }
        arrayList.clear();
    }

    public void t(ColorStateList colorStateList) {
        if (colorStateList != null) {
            cb0 cb0Var = (cb0) this.d;
            if (cb0Var == null) {
                cb0Var = new cb0();
                this.d = cb0Var;
            }
            cb0Var.c = colorStateList;
            cb0Var.b = true;
        } else {
            this.d = null;
        }
        a();
    }

    public void u(ColorStateList colorStateList) {
        cb0 cb0Var = (cb0) this.e;
        if (cb0Var == null) {
            cb0Var = new cb0();
            this.e = cb0Var;
        }
        cb0Var.c = colorStateList;
        cb0Var.b = true;
        a();
    }

    public void v(PorterDuff.Mode mode) {
        cb0 cb0Var = (cb0) this.e;
        if (cb0Var == null) {
            cb0Var = new cb0();
            this.e = cb0Var;
        }
        cb0Var.d = mode;
        cb0Var.a = true;
        a();
    }

    public int w(int i, int i2) {
        int i3;
        int i4;
        c23 c23Var = (c23) this.b;
        ArrayList arrayList = (ArrayList) this.d;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            j5 j5Var = (j5) arrayList.get(size);
            int i5 = j5Var.a;
            int i6 = j5Var.b;
            if (i5 == 8) {
                int i7 = j5Var.d;
                if (i6 < i7) {
                    i4 = i7;
                    i3 = i6;
                } else {
                    i3 = i7;
                    i4 = i6;
                }
                if (i < i3 || i > i4) {
                    if (i < i6) {
                        if (i2 == 1) {
                            j5Var.b = i6 + 1;
                            j5Var.d = i7 + 1;
                        } else if (i2 == 2) {
                            j5Var.b = i6 - 1;
                            j5Var.d = i7 - 1;
                        }
                    }
                } else if (i3 == i6) {
                    if (i2 == 1) {
                        j5Var.d = i7 + 1;
                    } else if (i2 == 2) {
                        j5Var.d = i7 - 1;
                    }
                    i++;
                } else {
                    if (i2 == 1) {
                        j5Var.b = i6 + 1;
                    } else if (i2 == 2) {
                        j5Var.b = i6 - 1;
                    }
                    i--;
                }
            } else if (i6 <= i) {
                if (i5 == 1) {
                    i -= j5Var.d;
                } else if (i5 == 2) {
                    i += j5Var.d;
                }
            } else if (i2 == 1) {
                j5Var.b = i6 + 1;
            } else if (i2 == 2) {
                j5Var.b = i6 - 1;
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            j5 j5Var2 = (j5) arrayList.get(size2);
            int i8 = j5Var2.a;
            int i9 = j5Var2.d;
            if (i8 == 8) {
                if (i9 == j5Var2.b || i9 < 0) {
                    arrayList.remove(size2);
                    j5Var2.c = null;
                    c23Var.c(j5Var2);
                }
            } else if (i9 <= 0) {
                arrayList.remove(size2);
                j5Var2.c = null;
                c23Var.c(j5Var2);
            }
        }
        return i;
    }

    public k5(ExplorerService explorerService) {
        this.b = explorerService;
        this.a = -1;
        this.d = new NioEventLoopGroup(1);
        this.e = new NioEventLoopGroup();
    }

    public k5(View view) {
        this.a = -1;
        this.b = view;
        this.c = db.a();
    }
}
