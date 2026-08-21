package defpackage;

import android.os.Build;
import android.util.Log;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class rf {
    public final cf0 a;
    public oj1 b;
    public wk4 c = new rz2();
    public ez2 d;
    public final n02 e;
    public final we0 f;
    public final oj1 g;
    public volatile boolean h;
    public volatile int i;
    public final m24 j;
    public final fe3 k;
    public final hv3 l;
    public final /* synthetic */ vf m;

    public rf(vf vfVar, cf0 cf0Var) {
        this.m = vfVar;
        this.a = cf0Var;
        ez2 ez2Var = ez2.e;
        ez2Var.getClass();
        this.d = ez2Var;
        n02 n02Var = new n02(9);
        this.e = n02Var;
        we0 we0Var = new we0();
        this.f = we0Var;
        this.g = new oj1((byte) 0, 26);
        this.j = n24.a(Boolean.FALSE);
        this.k = (fe3) n02Var.A;
        this.l = iv3.a(0, 64, jp.f);
        ((CopyOnWriteArrayList) we0Var.f).add(new fn(13, this));
    }

    public final Object a(int i) {
        Object objI;
        Object objI2;
        m24 m24Var = this.j;
        do {
            objI = m24Var.i();
            ((Boolean) objI).getClass();
        } while (!m24Var.g(objI, Boolean.TRUE));
        this.h = true;
        this.i = i;
        if (Build.ID != null && Log.isLoggable("Paging", 2)) {
            Log.v("Paging", "Accessing item index[" + i + ']', null);
        }
        oj1 oj1Var = this.b;
        if (oj1Var != null) {
            oj1Var.u(this.d.a(i));
        }
        Object objB = this.d.b(i);
        m24 m24Var2 = this.j;
        do {
            objI2 = m24Var2.i();
            ((Boolean) objI2).getClass();
        } while (!m24Var2.g(objI2, Boolean.FALSE));
        return objB;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object b(List list, int i, int i2, boolean z, gd2 gd2Var, gd2 gd2Var2, oj1 oj1Var, ie0 ie0Var) {
        sz2 sz2Var;
        String str;
        ez2 ez2Var;
        oj1 oj1Var2;
        gd2 gd2Var3;
        gd2 gd2Var4;
        List list2;
        boolean z2;
        oj1 oj1Var3;
        ez2 ez2Var2;
        oj1 oj1Var4;
        int i3 = i;
        int i4 = i2;
        if (ie0Var instanceof sz2) {
            sz2Var = (sz2) ie0Var;
            int i5 = sz2Var.G0;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                sz2Var.G0 = i5 - Integer.MIN_VALUE;
            } else {
                sz2Var = new sz2(this, ie0Var);
            }
        }
        Object obj = sz2Var.E0;
        Object obj2 = mf0.b;
        int i6 = sz2Var.G0;
        if (i6 == 0) {
            n12.S(obj);
            if (z && gd2Var == null) {
                xe.k("Cannot dispatch LoadStates in PagingDataPresenter without source LoadStates set.");
                return null;
            }
            this.h = false;
            ez2 ez2Var3 = this.d;
            oj1 oj1Var5 = this.b;
            ez2 ez2Var4 = new ez2(list, i3, i4);
            ez2 ez2Var5 = this.d;
            ez2Var5.getClass();
            this.d = ez2Var4;
            this.b = oj1Var;
            str = "|)";
            try {
                ke0 qz2Var = new qz2(ez2Var4, ez2Var5);
                sz2Var.A = list;
                sz2Var.X = gd2Var;
                sz2Var.Y = gd2Var2;
                sz2Var.Z = oj1Var;
                sz2Var.y0 = ez2Var3;
                sz2Var.z0 = oj1Var5;
                sz2Var.A0 = ez2Var4;
                sz2Var.B0 = i3;
                sz2Var.C0 = i4;
                sz2Var.D0 = z;
                sz2Var.G0 = 1;
                if (c(qz2Var, sz2Var) == obj2) {
                    return obj2;
                }
                gd2Var3 = gd2Var;
                oj1Var2 = oj1Var5;
                gd2Var4 = gd2Var2;
                list2 = list;
                z2 = z;
                oj1Var3 = oj1Var;
                ez2Var = ez2Var3;
                ez2Var2 = ez2Var4;
            } catch (CancellationException e) {
                e = e;
                ez2Var = ez2Var3;
                oj1Var2 = oj1Var5;
                this.d = ez2Var;
                this.b = oj1Var2;
                throw e;
            }
        } else {
            if (i6 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            z2 = sz2Var.D0;
            int i7 = sz2Var.C0;
            int i8 = sz2Var.B0;
            ez2Var2 = sz2Var.A0;
            oj1Var2 = sz2Var.z0;
            ez2Var = sz2Var.y0;
            oj1Var3 = sz2Var.Z;
            gd2Var4 = sz2Var.Y;
            gd2Var3 = sz2Var.X;
            list2 = sz2Var.A;
            try {
                n12.S(obj);
                i4 = i7;
                i3 = i8;
                str = "|)";
            } catch (CancellationException e2) {
                e = e2;
                this.d = ez2Var;
                this.b = oj1Var2;
                throw e;
            }
        }
        if (Build.ID != null && Log.isLoggable("Paging", 3)) {
            StringBuilder sb = new StringBuilder("Presenting data (\n                            |   first item: ");
            lg4 lg4Var = (lg4) d70.e0(list2);
            sb.append(lg4Var != null ? d70.e0(lg4Var.b) : null);
            sb.append("\n                            |   last item: ");
            lg4 lg4Var2 = (lg4) d70.l0(list2);
            sb.append(lg4Var2 != null ? d70.l0(lg4Var2.b) : null);
            sb.append("\n                            |   placeholdersBefore: ");
            sb.append(i3);
            sb.append("\n                            |   placeholdersAfter: ");
            sb.append(i4);
            sb.append("\n                            |   hintReceiver: ");
            sb.append(oj1Var3);
            sb.append("\n                            |   sourceLoadStates: ");
            sb.append(gd2Var3);
            sb.append("\n                        ");
            String string = sb.toString();
            if (gd2Var4 != null) {
                string = string + "|   mediatorLoadStates: " + gd2Var4 + '\n';
            }
            Log.d("Paging", q44.c0(string.concat(str)), null);
        }
        if (z2) {
            n02 n02Var = this.e;
            gd2Var3.getClass();
            n02Var.M(gd2Var3, gd2Var4);
        }
        if (ez2Var2.f() == 0 && (oj1Var4 = this.b) != null) {
            int i9 = ez2Var2.b / 2;
            oj1Var4.u(new zr4(i9, i9, ez2Var2.d(), ez2Var2.e()));
        }
        return xl4.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object c(ke0 ke0Var, ie0 ie0Var) {
        qf qfVar;
        qz2 qz2Var;
        int iV;
        int iA;
        vf vfVar = this.m;
        zf2 zf2Var = vfVar.a;
        if (ie0Var instanceof qf) {
            qfVar = (qf) ie0Var;
            int i = qfVar.y0;
            if ((i & Integer.MIN_VALUE) != 0) {
                qfVar.y0 = i - Integer.MIN_VALUE;
            } else {
                qfVar = new qf(this, ie0Var);
            }
        }
        Object objB0 = qfVar.Y;
        int i2 = qfVar.y0;
        int i3 = 1;
        ge0 ge0Var = null;
        try {
            if (i2 == 0) {
                n12.S(objB0);
                if (ke0Var instanceof qz2) {
                    qz2Var = (qz2) ke0Var;
                    ez2 ez2Var = qz2Var.e;
                    ez2 ez2Var2 = qz2Var.f;
                    if (ez2Var2.f() == 0) {
                        if (ez2Var.f() > 0) {
                            zf2Var.D(0, ez2Var.f());
                        }
                    } else if (ez2Var.f() != 0) {
                        vfVar.e.set(ez2Var2);
                        cf0 cf0Var = vfVar.b;
                        gd gdVar = new gd(qz2Var, vfVar, ge0Var, i3);
                        qfVar.A = vfVar;
                        qfVar.X = qz2Var;
                        qfVar.y0 = 1;
                        objB0 = ji0.b0(cf0Var, gdVar, qfVar);
                        mf0 mf0Var = mf0.b;
                        if (objB0 == mf0Var) {
                            return mf0Var;
                        }
                    } else if (ez2Var2.f() > 0) {
                        zf2Var.P(0, ez2Var2.f());
                    }
                } else if (ke0Var instanceof pz2) {
                    pz2 pz2Var = (pz2) ke0Var;
                    int i4 = pz2Var.g;
                    int size = pz2Var.e.size();
                    int iMin = Math.min(i4, size);
                    int i5 = i4 - iMin;
                    int i6 = size - iMin;
                    if (iMin > 0) {
                        zf2Var.d0(i5, iMin, null);
                    }
                    if (i6 > 0) {
                        zf2Var.D(0, i6);
                    }
                    int i7 = (pz2Var.f - i4) + iMin;
                    if (i7 > 0) {
                        zf2Var.D(0, i7);
                    } else if (i7 < 0) {
                        zf2Var.P(0, -i7);
                    }
                } else if (ke0Var instanceof mz2) {
                    mz2 mz2Var = (mz2) ke0Var;
                    int i8 = mz2Var.e;
                    int i9 = mz2Var.h;
                    int size2 = mz2Var.f.size();
                    int iMin2 = Math.min(i9, size2);
                    int i10 = size2 - iMin2;
                    int i11 = i8 + iMin2;
                    if (iMin2 > 0) {
                        zf2Var.d0(i8, iMin2, null);
                    }
                    if (i10 > 0) {
                        zf2Var.D(i11, i10);
                    }
                    int i12 = mz2Var.g;
                    int i13 = (i12 - i9) + iMin2;
                    int i14 = i8 + size2 + i12;
                    if (i13 > 0) {
                        zf2Var.D(i14 - i13, i13);
                    } else if (i13 < 0) {
                        zf2Var.P(i14, -i13);
                    }
                } else if (ke0Var instanceof oz2) {
                    oz2 oz2Var = (oz2) ke0Var;
                    int i15 = oz2Var.g;
                    int i16 = oz2Var.f;
                    int i17 = (i16 - oz2Var.e) - i15;
                    if (i17 > 0) {
                        zf2Var.D(0, i17);
                    } else if (i17 < 0) {
                        zf2Var.P(0, -i17);
                    }
                    int iMax = Math.max(0, i15 + i17);
                    int i18 = i16 - iMax;
                    if (i18 > 0) {
                        zf2Var.d0(iMax, i18, null);
                    }
                } else {
                    if (!(ke0Var instanceof nz2)) {
                        g.d();
                        return null;
                    }
                    nz2 nz2Var = (nz2) ke0Var;
                    int i19 = nz2Var.e;
                    int i20 = nz2Var.g;
                    int i21 = nz2Var.h;
                    int i22 = (i20 - nz2Var.f) - i21;
                    int i23 = i19 + i20;
                    if (i22 > 0) {
                        zf2Var.D(i23 - i22, i22);
                    } else if (i22 < 0) {
                        zf2Var.P(i23, -i22);
                    }
                    int iMin3 = (i20 - i21) + (i22 < 0 ? Math.min(i21, -i22) : 0);
                    if (iMin3 > 0) {
                        zf2Var.d0(i19, iMin3, null);
                    }
                }
                return xl4.a;
            }
            if (i2 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            qz2Var = qfVar.X;
            vfVar = qfVar.A;
            n12.S(objB0);
            h13 h13Var = (h13) objB0;
            vfVar.e.set(null);
            ez2 ez2Var3 = qz2Var.f;
            ez2 ez2Var4 = qz2Var.e;
            zf2 zf2Var2 = vfVar.a;
            ez2Var3.getClass();
            h13Var.getClass();
            ju0 ju0Var = h13Var.a;
            boolean z = h13Var.b;
            if (z) {
                ox2 ox2Var = new ox2(ez2Var3, ez2Var4, zf2Var2);
                ju0Var.b(ox2Var);
                int iMin4 = Math.min(ez2Var3.c, ox2Var.z);
                int i24 = ez2Var4.c - ox2Var.z;
                pu0 pu0Var = pu0.z;
                if (i24 > 0) {
                    if (iMin4 > 0) {
                        zf2Var2.d0(0, iMin4, pu0Var);
                    }
                    zf2Var2.D(0, i24);
                } else if (i24 < 0) {
                    zf2Var2.P(0, -i24);
                    int i25 = iMin4 + i24;
                    if (i25 > 0) {
                        zf2Var2.d0(0, i25, pu0Var);
                    }
                }
                ox2Var.z = ez2Var4.c;
                int iMin5 = Math.min(ez2Var3.d, ox2Var.A);
                int i26 = ez2Var4.d;
                int i27 = ox2Var.A;
                int i28 = i26 - i27;
                int i29 = ox2Var.z + ox2Var.X + i27;
                int i30 = i29 - iMin5;
                boolean z2 = i30 != ez2Var3.f() - iMin5;
                if (i28 > 0) {
                    zf2Var2.D(i29, i28);
                } else if (i28 < 0) {
                    zf2Var2.P(i29 + i28, -i28);
                    iMin5 += i28;
                }
                if (iMin5 > 0 && z2) {
                    zf2Var2.d0(i30, iMin5, pu0Var);
                }
                ox2Var.A = ez2Var4.d;
            } else {
                int iMax2 = Math.max(ez2Var3.c, ez2Var4.c);
                int iMin6 = Math.min(ez2Var3.c + ez2Var3.b, ez2Var4.c + ez2Var4.b);
                int i31 = iMin6 - iMax2;
                if (i31 > 0) {
                    zf2Var2.P(iMax2, i31);
                    zf2Var2.D(iMax2, i31);
                }
                int iMin7 = Math.min(iMax2, iMin6);
                int iMax3 = Math.max(iMax2, iMin6);
                int i32 = ez2Var3.c;
                int iF = ez2Var4.f();
                if (i32 > iF) {
                    i32 = iF;
                }
                int i33 = ez2Var3.c + ez2Var3.b;
                int iF2 = ez2Var4.f();
                if (i33 > iF2) {
                    i33 = iF2;
                }
                int i34 = iMin7 - i32;
                pu0 pu0Var2 = pu0.b;
                if (i34 > 0) {
                    zf2Var2.d0(i32, i34, pu0Var2);
                }
                int i35 = i33 - iMax3;
                if (i35 > 0) {
                    zf2Var2.d0(iMax3, i35, pu0Var2);
                }
                int i36 = ez2Var4.c;
                int iF3 = ez2Var3.f();
                if (i36 > iF3) {
                    i36 = iF3;
                }
                int i37 = ez2Var4.c + ez2Var4.b;
                int iF4 = ez2Var3.f();
                if (i37 > iF4) {
                    i37 = iF4;
                }
                int i38 = iMin7 - i36;
                pu0 pu0Var3 = pu0.f;
                if (i38 > 0) {
                    zf2Var2.d0(i36, i38, pu0Var3);
                }
                int i39 = i37 - iMax3;
                if (i39 > 0) {
                    zf2Var2.d0(iMax3, i39, pu0Var3);
                }
                int iF5 = ez2Var4.f() - ez2Var3.f();
                if (iF5 > 0) {
                    zf2Var2.D(ez2Var3.f(), iF5);
                } else if (iF5 < 0) {
                    zf2Var2.P(ez2Var3.f() + iF5, -iF5);
                }
            }
            ez2 ez2Var5 = qz2Var.f;
            int i40 = vfVar.d;
            ez2Var5.getClass();
            if (z) {
                int i41 = i40 - ez2Var5.c;
                int i42 = ez2Var5.b;
                if (i41 < 0 || i41 >= i42) {
                    iV = gb4.v(i40, gb4.d0(0, ez2Var4.f()));
                } else {
                    for (int i43 = 0; i43 < 30; i43++) {
                        int i44 = ((i43 / 2) * (i43 % 2 == 1 ? -1 : 1)) + i41;
                        if (i44 >= 0 && i44 < ez2Var5.b && (iA = ju0Var.a(i44)) != -1) {
                            iV = ez2Var4.c + iA;
                            break;
                        }
                    }
                    iV = gb4.v(i40, gb4.d0(0, ez2Var4.f()));
                }
                return xl4.a;
            }
            iV = gb4.v(i40, gb4.d0(0, ez2Var4.f()));
            vfVar.d = iV;
            a(iV);
            return xl4.a;
        } catch (Throwable th) {
            vfVar.e.set(null);
            throw th;
        }
    }
}
