package defpackage;

import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.netty.util.internal.StringUtil;
import j$.util.DesugarCollections;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ft0 extends it0 implements Comparable {
    public static final at0 F0 = new at0(1);
    public static final aw4[] G0 = aw4.values();
    public volatile er0 A;
    public et0 A0;
    public ws0 B0;
    public final kt0 C0;
    public it0 D0;
    public Object E0;
    public final String X;
    public final it0 Y;
    public final ws0 Z;
    public final int f;
    public final boolean y0;
    public final rq0 z;
    public volatile dt0 z0;

    static {
        if (et0.Z.length == qq0.values().length) {
            return;
        }
        zo2.w("descriptor.proto has a new declared type but Descriptors.java wasn't updated.");
    }

    public ft0(rq0 rq0Var, gt0 gt0Var, ws0 ws0Var, int i, boolean z) throws xs0 {
        this.f = i;
        this.z = rq0Var;
        this.X = mt0.b(gt0Var, ws0Var, rq0Var.L());
        if (rq0Var.X()) {
            this.A0 = et0.Z[(qq0.b(rq0Var.z0) == null ? qq0.TYPE_DOUBLE : r5).b - 1];
        }
        this.y0 = rq0Var.G0;
        if (rq0Var.Z <= 0) {
            throw new xs0(this, "Field numbers must be positive integers.");
        }
        if (z) {
            if (!rq0Var.Q()) {
                throw new xs0(this, "FieldDescriptorProto.extendee not set for extension field.");
            }
            this.B0 = null;
            if (ws0Var != null) {
                this.Z = ws0Var;
                this.Y = ws0Var;
            } else {
                this.Z = null;
                this.Y = gt0Var;
            }
            if (rq0Var.U()) {
                throw new xs0(this, "FieldDescriptorProto.oneof_index set for extension field.");
            }
            this.C0 = null;
        } else {
            if (rq0Var.Q()) {
                throw new xs0(this, "FieldDescriptorProto.extendee set for non-extension field.");
            }
            this.B0 = ws0Var;
            if (rq0Var.U()) {
                int i2 = rq0Var.D0;
                if (i2 < 0 || i2 >= ws0Var.f.C0.size()) {
                    throw new xs0(this, "FieldDescriptorProto.oneof_index is out of range for type ".concat(ws0Var.f.H()));
                }
                kt0 kt0Var = (kt0) DesugarCollections.unmodifiableList(Arrays.asList(ws0Var.B0)).get(rq0Var.D0);
                this.C0 = kt0Var;
                kt0Var.Y++;
                this.Y = kt0Var;
            } else {
                this.C0 = null;
                ws0Var.getClass();
                this.Y = ws0Var;
            }
            this.Z = null;
        }
        gt0Var.z0.e(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0031, code lost:
    
        if (((defpackage.bt0) r3).j().z0 != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static dt0 u(ft0 ft0Var, Object obj) {
        if (ft0Var.r() == et0.Y) {
            if (ft0Var.y()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    if (((bt0) it.next()).j().z0) {
                        return dt0.f;
                    }
                }
            }
        } else if (ft0Var.r().b == ct0.MESSAGE) {
            if (ft0Var.y()) {
                Iterator it2 = ((List) obj).iterator();
                while (it2.hasNext()) {
                    for (Map.Entry entry : ((c1) it2.next()).l().entrySet()) {
                        dt0 dt0VarU = u((ft0) entry.getKey(), entry.getValue());
                        if (dt0VarU.b) {
                            return dt0VarU;
                        }
                    }
                }
            } else {
                for (Map.Entry entry2 : ((c1) obj).l().entrySet()) {
                    dt0 dt0VarU2 = u((ft0) entry2.getKey(), entry2.getValue());
                    if (dt0VarU2.b) {
                        return dt0VarU2;
                    }
                }
            }
        }
        return dt0.d;
    }

    public final boolean A() {
        zp0 zp0Var = null;
        if (DesugarCollections.unmodifiableList(Arrays.asList(this.Y.c().Z)).isEmpty()) {
            if (r() == et0.Y) {
                int i = l().b().y0;
                if (i == 0) {
                    zp0Var = zp0.ENUM_TYPE_UNKNOWN;
                } else if (i == 1) {
                    zp0Var = zp0.OPEN;
                } else if (i != 2) {
                    zp0 zp0Var2 = zp0.ENUM_TYPE_UNKNOWN;
                } else {
                    zp0Var = zp0.CLOSED;
                }
                if (zp0Var == null) {
                    zp0Var = zp0.ENUM_TYPE_UNKNOWN;
                }
                return zp0Var == zp0.CLOSED;
            }
            return false;
        }
        if (r() == et0.Y) {
            if (!((g32) b().H(h32.A0)).Y) {
                int i2 = l().b().y0;
                if (i2 == 0) {
                    zp0Var = zp0.ENUM_TYPE_UNKNOWN;
                } else if (i2 == 1) {
                    zp0Var = zp0.OPEN;
                } else if (i2 != 2) {
                    zp0 zp0Var3 = zp0.ENUM_TYPE_UNKNOWN;
                } else {
                    zp0Var = zp0.CLOSED;
                }
                if (zp0Var == null) {
                    zp0Var = zp0.ENUM_TYPE_UNKNOWN;
                }
                if (zp0Var != zp0.CLOSED) {
                    return false;
                }
            }
        }
        return false;
    }

    public final boolean B() {
        f32 f32Var;
        if (r() != et0.f) {
            return false;
        }
        if (!this.B0.f.J().A0) {
            int i = ((g32) b().H(h32.A0)).Z;
            eq0 eq0Var = null;
            if (i == 0) {
                f32Var = f32.UTF8_VALIDATION_UNKNOWN;
            } else if (i == 1) {
                f32Var = f32.DEFAULT;
            } else if (i != 2) {
                f32 f32Var2 = f32.UTF8_VALIDATION_UNKNOWN;
                f32Var = null;
            } else {
                f32Var = f32.VERIFY;
            }
            if (f32Var == null) {
                f32Var = f32.UTF8_VALIDATION_UNKNOWN;
            }
            if (!f32Var.equals(f32.VERIFY)) {
                int i2 = b().A0;
                if (i2 == 0) {
                    eq0Var = eq0.UTF8_VALIDATION_UNKNOWN;
                } else if (i2 == 2) {
                    eq0Var = eq0.VERIFY;
                } else if (i2 != 3) {
                    eq0 eq0Var2 = eq0.UTF8_VALIDATION_UNKNOWN;
                } else {
                    eq0Var = eq0.NONE;
                }
                if (eq0Var == null) {
                    eq0Var = eq0.UTF8_VALIDATION_UNKNOWN;
                }
                return eq0Var.equals(eq0.VERIFY);
            }
        }
        return true;
    }

    @Override // defpackage.it0
    public final gt0 c() {
        return this.Y.c();
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        ft0 ft0Var = (ft0) obj;
        if (ft0Var.B0 == this.B0) {
            return this.z.Z - ft0Var.z.Z;
        }
        xe.k("FieldDescriptors can only be compared to other FieldDescriptors for fields of the same message type.");
        return 0;
    }

    @Override // defpackage.it0
    public final String d() {
        return this.X;
    }

    @Override // defpackage.it0
    public final it0 e() {
        return this.Y;
    }

    @Override // defpackage.it0
    public final gq0 f() {
        pq0 pq0Var;
        it0 it0Var = this.Y;
        int i = it0Var.c().k().b;
        zo0 zo0Var = zo0.EDITION_UNKNOWN;
        if (i >= 1000) {
            return gq0.G0;
        }
        rq0 rq0Var = this.z;
        int i2 = rq0Var.y0;
        xp0 xp0VarS = null;
        if (i2 == 1) {
            pq0Var = pq0.LABEL_OPTIONAL;
        } else if (i2 == 2) {
            pq0Var = pq0.LABEL_REQUIRED;
        } else if (i2 != 3) {
            pq0 pq0Var2 = pq0.LABEL_OPTIONAL;
            pq0Var = null;
        } else {
            pq0Var = pq0.LABEL_REPEATED;
        }
        if (pq0Var == null) {
            pq0Var = pq0.LABEL_OPTIONAL;
        }
        if (pq0Var == pq0.LABEL_REQUIRED) {
            xp0VarS = gq0.G0.u();
            aq0 aq0Var = aq0.FIELD_PRESENCE_UNKNOWN;
            xp0VarS.Y |= 1;
            xp0VarS.Z = 3;
            xp0VarS.S();
        }
        qq0 qq0VarB = qq0.b(rq0Var.z0);
        if (qq0VarB == null) {
            qq0VarB = qq0.TYPE_DOUBLE;
        }
        if (qq0VarB == qq0.TYPE_GROUP) {
            if (xp0VarS == null) {
                xp0VarS = gq0.G0.u();
            }
            cq0 cq0Var = cq0.MESSAGE_ENCODING_UNKNOWN;
            xp0VarS.Y |= 16;
            xp0VarS.B0 = 2;
            xp0VarS.S();
        }
        if (it0Var.c().k() == zo0.EDITION_PROTO2 && rq0Var.N().y0) {
            if (xp0VarS == null) {
                xp0VarS = gq0.G0.u();
            }
            xp0VarS.d0(dq0.PACKED);
        }
        if (it0Var.c().k() == zo0.EDITION_PROTO3 && rq0Var.N().T() && !rq0Var.N().y0) {
            if (xp0VarS == null) {
                xp0VarS = gq0.G0.u();
            }
            xp0VarS.d0(dq0.EXPANDED);
        }
        return xp0VarS != null ? xp0VarS.p() : gq0.G0;
    }

    @Override // defpackage.it0
    public final String getName() {
        return this.z.L();
    }

    @Override // defpackage.it0
    public final c1 h() {
        return this.z;
    }

    @Override // defpackage.it0
    public final void i() throws xs0 {
        ws0 ws0Var = this.B0;
        if (ws0Var != null && ws0Var.f.J().Z && this.z.Q()) {
            if (z() || y() || r() != et0.A) {
                throw new xs0(this, "Extensions of MessageSets may not be required or repeated messages.");
            }
        }
    }

    public final void j() throws xs0 {
        rq0 rq0Var = this.z;
        boolean zQ = rq0Var.Q();
        it0 it0Var = this.Y;
        if (zQ) {
            it0 it0VarQ = it0Var.c().z0.q(this, rq0Var.J());
            if (!(it0VarQ instanceof ws0)) {
                throw new xs0(this, "\"" + rq0Var.J() + "\" is not a message type.");
            }
            ws0 ws0Var = (ws0) it0VarQ;
            this.B0 = ws0Var;
            int i = rq0Var.Z;
            int iBinarySearch = Arrays.binarySearch(ws0Var.D0, i);
            if (iBinarySearch < 0) {
                iBinarySearch = (~iBinarySearch) - 1;
            }
            if (iBinarySearch < 0 || i >= ws0Var.E0[iBinarySearch]) {
                StringBuilder sb = new StringBuilder("\"");
                sb.append(this.B0.A);
                sb.append("\" does not declare ");
                throw new xs0(this, fw.w(" as an extension number.", sb, rq0Var.Z));
            }
        }
        if (rq0Var.Y()) {
            it0 it0VarQ2 = it0Var.c().z0.q(this, rq0Var.O());
            if (!rq0Var.X()) {
                if (it0VarQ2 instanceof ws0) {
                    this.A0 = et0.A;
                } else {
                    if (!(it0VarQ2 instanceof zs0)) {
                        throw new xs0(this, "\"" + rq0Var.O() + "\" is not a type.");
                    }
                    this.A0 = et0.Y;
                }
            }
            ct0 ct0Var = this.A0.b;
            if (ct0Var == ct0.MESSAGE) {
                if (!(it0VarQ2 instanceof ws0)) {
                    throw new xs0(this, "\"" + rq0Var.O() + "\" is not a message type.");
                }
                this.D0 = it0VarQ2;
                if (rq0Var.P()) {
                    throw new xs0(this, "Messages can't have default values.");
                }
            } else {
                if (ct0Var != ct0.ENUM) {
                    throw new xs0(this, "Field with primitive type has type_name.");
                }
                if (!(it0VarQ2 instanceof zs0)) {
                    throw new xs0(this, "\"" + rq0Var.O() + "\" is not an enum type.");
                }
                this.D0 = it0VarQ2;
            }
        } else {
            ct0 ct0Var2 = this.A0.b;
            if (ct0Var2 == ct0.MESSAGE || ct0Var2 == ct0.ENUM) {
                throw new xs0(this, "Field with message or enum type missing type_name.");
            }
        }
        if (rq0Var.N().y0 && !w()) {
            throw new xs0(this, "[packed = true] can only be specified for repeated primitive fields.");
        }
        if (!rq0Var.P()) {
            if (y()) {
                this.E0 = Collections.EMPTY_LIST;
                return;
            }
            int iOrdinal = this.A0.b.ordinal();
            if (iOrdinal == 7) {
                this.E0 = l().X[0];
                return;
            } else if (iOrdinal != 8) {
                this.E0 = this.A0.b.b;
                return;
            } else {
                this.E0 = null;
                return;
            }
        }
        if (y()) {
            throw new xs0(this, "Repeated fields cannot have default values.");
        }
        try {
            switch (this.A0.ordinal()) {
                case 0:
                    if (rq0Var.H().equals("inf")) {
                        this.E0 = Double.valueOf(Double.POSITIVE_INFINITY);
                        return;
                    }
                    if (rq0Var.H().equals("-inf")) {
                        this.E0 = Double.valueOf(Double.NEGATIVE_INFINITY);
                        return;
                    } else if (rq0Var.H().equals("nan")) {
                        this.E0 = Double.valueOf(Double.NaN);
                        return;
                    } else {
                        this.E0 = Double.valueOf(rq0Var.H());
                        return;
                    }
                case 1:
                    if (rq0Var.H().equals("inf")) {
                        this.E0 = Float.valueOf(Float.POSITIVE_INFINITY);
                        return;
                    }
                    if (rq0Var.H().equals("-inf")) {
                        this.E0 = Float.valueOf(Float.NEGATIVE_INFINITY);
                        return;
                    } else if (rq0Var.H().equals("nan")) {
                        this.E0 = Float.valueOf(Float.NaN);
                        return;
                    } else {
                        this.E0 = Float.valueOf(rq0Var.H());
                        return;
                    }
                case 2:
                case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                case 17:
                    this.E0 = Long.valueOf(tb4.c(rq0Var.H(), true, true));
                    return;
                case 3:
                case 5:
                    this.E0 = Long.valueOf(tb4.c(rq0Var.H(), false, true));
                    return;
                case 4:
                case 14:
                case 16:
                    this.E0 = Integer.valueOf((int) tb4.c(rq0Var.H(), true, false));
                    return;
                case 6:
                case FileClientSessionCache.MAX_SIZE /* 12 */:
                    this.E0 = Integer.valueOf((int) tb4.c(rq0Var.H(), false, false));
                    return;
                case 7:
                    this.E0 = Boolean.valueOf(rq0Var.H());
                    return;
                case 8:
                    this.E0 = rq0Var.H();
                    return;
                case Xlog.COMPRESS_LEVEL9 /* 9 */:
                case 10:
                    throw new xs0(this, "Message type had default value.");
                case 11:
                    try {
                        this.E0 = tb4.d(rq0Var.H());
                        return;
                    } catch (pb4 e) {
                        xs0 xs0Var = new xs0(this, "Couldn't parse default value: " + e.getMessage());
                        xs0Var.initCause(e);
                        throw xs0Var;
                    }
                case 13:
                    zs0 zs0VarL = l();
                    String strH = rq0Var.H();
                    it0 it0VarN = zs0VarL.A.c().z0.n(3, zs0VarL.z + '.' + strH);
                    bt0 bt0Var = it0VarN instanceof bt0 ? (bt0) it0VarN : null;
                    this.E0 = bt0Var;
                    if (bt0Var != null) {
                        return;
                    }
                    throw new xs0(this, "Unknown enum default value: \"" + rq0Var.H() + StringUtil.DOUBLE_QUOTE);
                default:
                    return;
            }
        } catch (NumberFormatException e2) {
            xs0 xs0Var2 = new xs0(this, "Could not parse default value: \"" + rq0Var.H() + StringUtil.DOUBLE_QUOTE);
            xs0Var2.initCause(e2);
            throw xs0Var2;
        }
        xs0 xs0Var22 = new xs0(this, "Could not parse default value: \"" + rq0Var.H() + StringUtil.DOUBLE_QUOTE);
        xs0Var22.initCause(e2);
        throw xs0Var22;
    }

    public final Object k() {
        if (n() != ct0.MESSAGE) {
            return this.E0;
        }
        vp1.n("FieldDescriptor.getDefaultValue() called on an embedded message field.");
        return null;
    }

    public final zs0 l() {
        if (r().b == ct0.ENUM) {
            return (zs0) this.D0;
        }
        vp1.n(ha0.o("This field is not of enum type. (", this.X, ")"));
        return null;
    }

    public final ws0 m() {
        if (this.z.Q()) {
            return this.Z;
        }
        vp1.n(ha0.o("This field is not an extension. (", this.X, ")"));
        return null;
    }

    public final ct0 n() {
        return r().b;
    }

    public final aw4 o() {
        return G0[r().ordinal()];
    }

    public final ws0 p() {
        if (n() == ct0.MESSAGE) {
            return (ws0) this.D0;
        }
        vp1.n(ha0.o("This field is not of message type. (", this.X, ")"));
        return null;
    }

    public final er0 q() {
        if (this.A == null) {
            er0 er0VarN = this.z.N();
            if (er0VarN.Q()) {
                tq0 tq0VarX = er0VarN.u();
                tq0VarX.Y &= -2049;
                tq0VarX.I0 = null;
                ue1 ue1Var = tq0VarX.J0;
                if (ue1Var != null) {
                    ue1Var.b = null;
                    tq0VarX.J0 = null;
                }
                tq0VarX.S();
                er0VarN = tq0VarX.q();
                if (!er0VarN.c()) {
                    throw a1.C(er0VarN);
                }
            }
            synchronized (this) {
                try {
                    if (this.A == null) {
                        this.A = er0VarN;
                    }
                } finally {
                }
            }
        }
        return this.A;
    }

    public final et0 r() {
        it0 it0Var;
        ws0 ws0Var;
        cq0 cq0Var;
        if (this.A0 == et0.A && (((it0Var = this.D0) == null || !((ws0) it0Var).f.J().A0) && (((ws0Var = this.B0) == null || !ws0Var.f.J().A0) && this.b != null))) {
            int i = b().B0;
            if (i == 0) {
                cq0Var = cq0.MESSAGE_ENCODING_UNKNOWN;
            } else if (i == 1) {
                cq0Var = cq0.LENGTH_PREFIXED;
            } else if (i != 2) {
                cq0 cq0Var2 = cq0.MESSAGE_ENCODING_UNKNOWN;
                cq0Var = null;
            } else {
                cq0Var = cq0.DELIMITED;
            }
            if (cq0Var == null) {
                cq0Var = cq0.MESSAGE_ENCODING_UNKNOWN;
            }
            if (cq0Var == cq0.DELIMITED) {
                return et0.z;
            }
        }
        return this.A0;
    }

    public final boolean s() {
        aq0 aq0Var;
        if (y()) {
            return false;
        }
        if (!this.y0 && r() != et0.A && r() != et0.z && !this.z.Q() && this.C0 == null) {
            int i = b().Z;
            if (i == 0) {
                aq0Var = aq0.FIELD_PRESENCE_UNKNOWN;
            } else if (i == 1) {
                aq0Var = aq0.EXPLICIT;
            } else if (i == 2) {
                aq0Var = aq0.IMPLICIT;
            } else if (i != 3) {
                aq0 aq0Var2 = aq0.FIELD_PRESENCE_UNKNOWN;
                aq0Var = null;
            } else {
                aq0Var = aq0.LEGACY_REQUIRED;
            }
            if (aq0Var == null) {
                aq0Var = aq0.FIELD_PRESENCE_UNKNOWN;
            }
            if (aq0Var == aq0.IMPLICIT) {
                return false;
            }
        }
        return true;
    }

    public final boolean t() {
        return r() == et0.A && y() && p().f.J().A0;
    }

    public final String toString() {
        return this.X;
    }

    public final boolean v() {
        pq0 pq0Var;
        int i = this.z.y0;
        aq0 aq0Var = null;
        if (i == 1) {
            pq0Var = pq0.LABEL_OPTIONAL;
        } else if (i == 2) {
            pq0Var = pq0.LABEL_REQUIRED;
        } else if (i != 3) {
            pq0 pq0Var2 = pq0.LABEL_OPTIONAL;
            pq0Var = null;
        } else {
            pq0Var = pq0.LABEL_REPEATED;
        }
        if (pq0Var == null) {
            pq0Var = pq0.LABEL_OPTIONAL;
        }
        if (pq0Var != pq0.LABEL_OPTIONAL) {
            return false;
        }
        int i2 = b().Z;
        if (i2 == 0) {
            aq0Var = aq0.FIELD_PRESENCE_UNKNOWN;
        } else if (i2 == 1) {
            aq0Var = aq0.EXPLICIT;
        } else if (i2 == 2) {
            aq0Var = aq0.IMPLICIT;
        } else if (i2 != 3) {
            aq0 aq0Var2 = aq0.FIELD_PRESENCE_UNKNOWN;
        } else {
            aq0Var = aq0.LEGACY_REQUIRED;
        }
        if (aq0Var == null) {
            aq0Var = aq0.FIELD_PRESENCE_UNKNOWN;
        }
        return aq0Var != aq0.LEGACY_REQUIRED;
    }

    public final boolean w() {
        return y() && o().a();
    }

    public final boolean x() {
        dq0 dq0Var;
        if (!w()) {
            return false;
        }
        int i = b().z0;
        if (i == 0) {
            dq0Var = dq0.REPEATED_FIELD_ENCODING_UNKNOWN;
        } else if (i == 1) {
            dq0Var = dq0.PACKED;
        } else if (i != 2) {
            dq0 dq0Var2 = dq0.REPEATED_FIELD_ENCODING_UNKNOWN;
            dq0Var = null;
        } else {
            dq0Var = dq0.EXPANDED;
        }
        if (dq0Var == null) {
            dq0Var = dq0.REPEATED_FIELD_ENCODING_UNKNOWN;
        }
        return dq0Var.equals(dq0.PACKED);
    }

    public final boolean y() {
        pq0 pq0Var;
        int i = this.z.y0;
        if (i == 1) {
            pq0Var = pq0.LABEL_OPTIONAL;
        } else if (i == 2) {
            pq0Var = pq0.LABEL_REQUIRED;
        } else if (i != 3) {
            pq0 pq0Var2 = pq0.LABEL_OPTIONAL;
            pq0Var = null;
        } else {
            pq0Var = pq0.LABEL_REPEATED;
        }
        if (pq0Var == null) {
            pq0Var = pq0.LABEL_OPTIONAL;
        }
        return pq0Var == pq0.LABEL_REPEATED;
    }

    public final boolean z() {
        aq0 aq0Var;
        int i = b().Z;
        if (i == 0) {
            aq0Var = aq0.FIELD_PRESENCE_UNKNOWN;
        } else if (i == 1) {
            aq0Var = aq0.EXPLICIT;
        } else if (i == 2) {
            aq0Var = aq0.IMPLICIT;
        } else if (i != 3) {
            aq0 aq0Var2 = aq0.FIELD_PRESENCE_UNKNOWN;
            aq0Var = null;
        } else {
            aq0Var = aq0.LEGACY_REQUIRED;
        }
        if (aq0Var == null) {
            aq0Var = aq0.FIELD_PRESENCE_UNKNOWN;
        }
        return aq0Var == aq0.LEGACY_REQUIRED;
    }
}
