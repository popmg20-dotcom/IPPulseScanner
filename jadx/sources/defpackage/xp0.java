package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xp0 extends ln1 {
    public int Y;
    public int Z = 0;
    public int y0 = 0;
    public int z0 = 0;
    public int A0 = 0;
    public int B0 = 0;
    public int C0 = 0;
    public int D0 = 0;
    public int E0 = 0;

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = vs0.z1;
        vn1Var.a(gq0.class, xp0.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public final gq0 p() {
        gq0 gq0VarQ = q();
        if (gq0VarQ.c()) {
            return gq0VarQ;
        }
        throw a1.C(gq0VarQ);
    }

    @Override // defpackage.ol2
    public final c1 a() {
        return gq0.G0;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public final gq0 q() {
        gq0 gq0Var = new gq0(this);
        int i = 0;
        gq0Var.Z = 0;
        gq0Var.y0 = 0;
        gq0Var.z0 = 0;
        gq0Var.A0 = 0;
        gq0Var.B0 = 0;
        gq0Var.C0 = 0;
        gq0Var.D0 = 0;
        gq0Var.E0 = 0;
        gq0Var.F0 = (byte) -1;
        int i2 = this.Y;
        if (i2 != 0) {
            if ((i2 & 1) != 0) {
                gq0Var.Z = this.Z;
                i = 1;
            }
            if ((i2 & 2) != 0) {
                gq0Var.y0 = this.y0;
                i |= 2;
            }
            if ((i2 & 4) != 0) {
                gq0Var.z0 = this.z0;
                i |= 4;
            }
            if ((i2 & 8) != 0) {
                gq0Var.A0 = this.A0;
                i |= 8;
            }
            if ((i2 & 16) != 0) {
                gq0Var.B0 = this.B0;
                i |= 16;
            }
            if ((i2 & 32) != 0) {
                gq0Var.C0 = this.C0;
                i |= 32;
            }
            if ((i2 & 64) != 0) {
                gq0Var.D0 = this.D0;
                i |= 64;
            }
            if ((i2 & 128) != 0) {
                gq0Var.E0 = this.E0;
                i |= 128;
            }
            gq0Var.Y = i | gq0Var.Y;
        }
        R();
        return gq0Var;
    }

    public final void b0(gq0 gq0Var) {
        bq0 bq0Var;
        cq0 cq0Var;
        eq0 eq0Var;
        dq0 dq0Var;
        zp0 zp0Var;
        aq0 aq0Var;
        if (gq0Var == gq0.G0) {
            return;
        }
        yp0 yp0Var = null;
        if ((gq0Var.Y & 1) != 0) {
            int i = gq0Var.Z;
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
            this.Y |= 1;
            this.Z = aq0Var.b;
            S();
        }
        if (gq0Var.N()) {
            int i2 = gq0Var.y0;
            if (i2 == 0) {
                zp0Var = zp0.ENUM_TYPE_UNKNOWN;
            } else if (i2 == 1) {
                zp0Var = zp0.OPEN;
            } else if (i2 != 2) {
                zp0 zp0Var2 = zp0.ENUM_TYPE_UNKNOWN;
                zp0Var = null;
            } else {
                zp0Var = zp0.CLOSED;
            }
            if (zp0Var == null) {
                zp0Var = zp0.ENUM_TYPE_UNKNOWN;
            }
            this.Y |= 2;
            this.y0 = zp0Var.b;
            S();
        }
        if (gq0Var.Q()) {
            int i3 = gq0Var.z0;
            if (i3 == 0) {
                dq0Var = dq0.REPEATED_FIELD_ENCODING_UNKNOWN;
            } else if (i3 == 1) {
                dq0Var = dq0.PACKED;
            } else if (i3 != 2) {
                dq0 dq0Var2 = dq0.REPEATED_FIELD_ENCODING_UNKNOWN;
                dq0Var = null;
            } else {
                dq0Var = dq0.EXPANDED;
            }
            if (dq0Var == null) {
                dq0Var = dq0.REPEATED_FIELD_ENCODING_UNKNOWN;
            }
            d0(dq0Var);
        }
        if (gq0Var.R()) {
            int i4 = gq0Var.A0;
            if (i4 == 0) {
                eq0Var = eq0.UTF8_VALIDATION_UNKNOWN;
            } else if (i4 == 2) {
                eq0Var = eq0.VERIFY;
            } else if (i4 != 3) {
                eq0 eq0Var2 = eq0.UTF8_VALIDATION_UNKNOWN;
                eq0Var = null;
            } else {
                eq0Var = eq0.NONE;
            }
            if (eq0Var == null) {
                eq0Var = eq0.UTF8_VALIDATION_UNKNOWN;
            }
            this.Y |= 8;
            this.A0 = eq0Var.b;
            S();
        }
        if (gq0Var.P()) {
            int i5 = gq0Var.B0;
            if (i5 == 0) {
                cq0Var = cq0.MESSAGE_ENCODING_UNKNOWN;
            } else if (i5 == 1) {
                cq0Var = cq0.LENGTH_PREFIXED;
            } else if (i5 != 2) {
                cq0 cq0Var2 = cq0.MESSAGE_ENCODING_UNKNOWN;
                cq0Var = null;
            } else {
                cq0Var = cq0.DELIMITED;
            }
            if (cq0Var == null) {
                cq0Var = cq0.MESSAGE_ENCODING_UNKNOWN;
            }
            this.Y |= 16;
            this.B0 = cq0Var.b;
            S();
        }
        if (gq0Var.O()) {
            int i6 = gq0Var.C0;
            if (i6 == 0) {
                bq0Var = bq0.JSON_FORMAT_UNKNOWN;
            } else if (i6 == 1) {
                bq0Var = bq0.ALLOW;
            } else if (i6 != 2) {
                bq0 bq0Var2 = bq0.JSON_FORMAT_UNKNOWN;
                bq0Var = null;
            } else {
                bq0Var = bq0.LEGACY_BEST_EFFORT;
            }
            if (bq0Var == null) {
                bq0Var = bq0.JSON_FORMAT_UNKNOWN;
            }
            this.Y |= 32;
            this.C0 = bq0Var.b;
            S();
        }
        if (gq0Var.L()) {
            int i7 = gq0Var.D0;
            if (i7 == 0) {
                yp0Var = yp0.ENFORCE_NAMING_STYLE_UNKNOWN;
            } else if (i7 == 1) {
                yp0Var = yp0.STYLE2024;
            } else if (i7 != 2) {
                yp0 yp0Var2 = yp0.ENFORCE_NAMING_STYLE_UNKNOWN;
            } else {
                yp0Var = yp0.STYLE_LEGACY;
            }
            if (yp0Var == null) {
                yp0Var = yp0.ENFORCE_NAMING_STYLE_UNKNOWN;
            }
            this.Y |= 64;
            this.D0 = yp0Var.b;
            S();
        }
        if (gq0Var.K()) {
            fq0 fq0VarB = fq0.b(gq0Var.E0);
            if (fq0VarB == null) {
                fq0VarB = fq0.DEFAULT_SYMBOL_VISIBILITY_UNKNOWN;
            }
            this.Y |= 128;
            this.E0 = fq0VarB.b;
            S();
        }
        W(gq0Var);
        A(gq0Var.z);
        S();
    }

    @Override // defpackage.ol2
    public final boolean c() {
        return V();
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
    public final void y(m60 m60Var, o91 o91Var) {
        o91Var.getClass();
        boolean z = false;
        while (!z) {
            try {
                try {
                    int iS = m60Var.s();
                    if (iS != 0) {
                        Enum r4 = null;
                        if (iS == 8) {
                            int iO = m60Var.o();
                            if (iO == 0) {
                                r4 = aq0.FIELD_PRESENCE_UNKNOWN;
                            } else if (iO == 1) {
                                r4 = aq0.EXPLICIT;
                            } else if (iO == 2) {
                                r4 = aq0.IMPLICIT;
                            } else if (iO != 3) {
                                aq0 aq0Var = aq0.FIELD_PRESENCE_UNKNOWN;
                            } else {
                                r4 = aq0.LEGACY_REQUIRED;
                            }
                            if (r4 == null) {
                                Q(1, iO);
                            } else {
                                this.Z = iO;
                                this.Y |= 1;
                            }
                        } else if (iS == 16) {
                            int iO2 = m60Var.o();
                            if (iO2 == 0) {
                                r4 = zp0.ENUM_TYPE_UNKNOWN;
                            } else if (iO2 == 1) {
                                r4 = zp0.OPEN;
                            } else if (iO2 != 2) {
                                zp0 zp0Var = zp0.ENUM_TYPE_UNKNOWN;
                            } else {
                                r4 = zp0.CLOSED;
                            }
                            if (r4 == null) {
                                Q(2, iO2);
                            } else {
                                this.y0 = iO2;
                                this.Y |= 2;
                            }
                        } else if (iS == 24) {
                            int iO3 = m60Var.o();
                            if (iO3 == 0) {
                                r4 = dq0.REPEATED_FIELD_ENCODING_UNKNOWN;
                            } else if (iO3 == 1) {
                                r4 = dq0.PACKED;
                            } else if (iO3 != 2) {
                                dq0 dq0Var = dq0.REPEATED_FIELD_ENCODING_UNKNOWN;
                            } else {
                                r4 = dq0.EXPANDED;
                            }
                            if (r4 == null) {
                                Q(3, iO3);
                            } else {
                                this.z0 = iO3;
                                this.Y |= 4;
                            }
                        } else if (iS == 32) {
                            int iO4 = m60Var.o();
                            if (iO4 == 0) {
                                r4 = eq0.UTF8_VALIDATION_UNKNOWN;
                            } else if (iO4 == 2) {
                                r4 = eq0.VERIFY;
                            } else if (iO4 != 3) {
                                eq0 eq0Var = eq0.UTF8_VALIDATION_UNKNOWN;
                            } else {
                                r4 = eq0.NONE;
                            }
                            if (r4 == null) {
                                Q(4, iO4);
                            } else {
                                this.A0 = iO4;
                                this.Y |= 8;
                            }
                        } else if (iS == 40) {
                            int iO5 = m60Var.o();
                            if (iO5 == 0) {
                                r4 = cq0.MESSAGE_ENCODING_UNKNOWN;
                            } else if (iO5 == 1) {
                                r4 = cq0.LENGTH_PREFIXED;
                            } else if (iO5 != 2) {
                                cq0 cq0Var = cq0.MESSAGE_ENCODING_UNKNOWN;
                            } else {
                                r4 = cq0.DELIMITED;
                            }
                            if (r4 == null) {
                                Q(5, iO5);
                            } else {
                                this.B0 = iO5;
                                this.Y |= 16;
                            }
                        } else if (iS == 48) {
                            int iO6 = m60Var.o();
                            if (iO6 == 0) {
                                r4 = bq0.JSON_FORMAT_UNKNOWN;
                            } else if (iO6 == 1) {
                                r4 = bq0.ALLOW;
                            } else if (iO6 != 2) {
                                bq0 bq0Var = bq0.JSON_FORMAT_UNKNOWN;
                            } else {
                                r4 = bq0.LEGACY_BEST_EFFORT;
                            }
                            if (r4 == null) {
                                Q(6, iO6);
                            } else {
                                this.C0 = iO6;
                                this.Y |= 32;
                            }
                        } else if (iS == 56) {
                            int iO7 = m60Var.o();
                            if (iO7 == 0) {
                                r4 = yp0.ENFORCE_NAMING_STYLE_UNKNOWN;
                            } else if (iO7 == 1) {
                                r4 = yp0.STYLE2024;
                            } else if (iO7 != 2) {
                                yp0 yp0Var = yp0.ENFORCE_NAMING_STYLE_UNKNOWN;
                            } else {
                                r4 = yp0.STYLE_LEGACY;
                            }
                            if (r4 == null) {
                                Q(7, iO7);
                            } else {
                                this.D0 = iO7;
                                this.Y |= 64;
                            }
                        } else if (iS == 64) {
                            int iO8 = m60Var.o();
                            if (fq0.b(iO8) == null) {
                                Q(8, iO8);
                            } else {
                                this.E0 = iO8;
                                this.Y |= 128;
                            }
                        } else if (!X(m60Var, o91Var, iS)) {
                        }
                    }
                    z = true;
                } catch (s12 e) {
                    throw e.c();
                }
            } catch (Throwable th) {
                S();
                throw th;
            }
        }
        S();
    }

    public final void d0(dq0 dq0Var) {
        this.Y |= 4;
        this.z0 = dq0Var.b;
        S();
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return vs0.y1;
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof gq0) {
            b0((gq0) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: w */
    public final /* bridge */ /* synthetic */ a1 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    public final a1 x(c1 c1Var) {
        if (c1Var instanceof gq0) {
            b0((gq0) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
