package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pt0 extends eg0 {
    public final boolean A;

    public pt0(xo xoVar, boolean z) {
        super(xoVar);
        this.A = z;
    }

    public final tj Y() {
        tj[] tjVarArr = (tj[]) this.z;
        uj ujVar = new uj();
        uj ujVar2 = new uj();
        uj ujVar3 = new uj();
        uj ujVar4 = new uj();
        for (tj tjVar : tjVarArr) {
            if (tjVar != null) {
                tjVar.c();
                int i = tjVar.e % 30;
                int i2 = tjVar.f;
                if (!this.A) {
                    i2 += 2;
                }
                int i3 = i2 % 3;
                if (i3 == 0) {
                    ujVar2.b((i * 3) + 1);
                } else if (i3 == 1) {
                    ujVar4.b(i / 3);
                    ujVar3.b(i % 3);
                } else if (i3 == 2) {
                    ujVar.b(i + 1);
                }
            }
        }
        if (ujVar.a().length == 0 || ujVar2.a().length == 0 || ujVar3.a().length == 0 || ujVar4.a().length == 0 || ujVar.a()[0] < 1 || ujVar2.a()[0] + ujVar3.a()[0] < 3 || ujVar2.a()[0] + ujVar3.a()[0] > 90) {
            return null;
        }
        tj tjVar2 = new tj(ujVar.a()[0], ujVar2.a()[0], ujVar3.a()[0], ujVar4.a()[0], 0);
        Z(tjVarArr, tjVar2);
        return tjVar2;
    }

    public final void Z(tj[] tjVarArr, tj tjVar) {
        for (int i = 0; i < tjVarArr.length; i++) {
            tj tjVar2 = tjVarArr[i];
            if (tjVar2 != null) {
                int i2 = tjVar2.e % 30;
                int i3 = tjVar2.f;
                if (i3 > tjVar.f) {
                    tjVarArr[i] = null;
                } else {
                    if (!this.A) {
                        i3 += 2;
                    }
                    int i4 = i3 % 3;
                    if (i4 != 0) {
                        if (i4 != 1) {
                            if (i4 == 2 && i2 + 1 != tjVar.b) {
                                tjVarArr[i] = null;
                            }
                        } else if (i2 / 3 != tjVar.c || i2 % 3 != tjVar.e) {
                            tjVarArr[i] = null;
                        }
                    } else if ((i2 * 3) + 1 != tjVar.d) {
                        tjVarArr[i] = null;
                    }
                }
            }
        }
    }

    @Override // defpackage.eg0
    public final String toString() {
        return "IsLeft: " + this.A + '\n' + super.toString();
    }
}
