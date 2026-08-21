package org.joni.ast;

import defpackage.es2;
import defpackage.gc3;
import defpackage.j44;
import defpackage.ja0;
import defpackage.k0;
import defpackage.r24;
import defpackage.up3;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class QuantifierNode extends r24 {
    static final String[] PopularQStr;
    static final gc3[][] REDUCE_TABLE;
    public static final int REPEAT_INFINITE = -1;
    static final String[] ReduceQStr;
    public int combExpCheckNum;
    public boolean greedy;
    public es2 headExact;
    public boolean isRefered;
    public int lower;
    public es2 nextHeadExact;
    public es2 target;
    public int targetEmptyInfo;
    public int upper;

    static {
        gc3 gc3Var = gc3.f;
        gc3 gc3Var2 = gc3.z;
        gc3 gc3Var3 = gc3.A;
        gc3 gc3Var4 = gc3.b;
        gc3[] gc3VarArr = {gc3Var, gc3Var2, gc3Var2, gc3.X, gc3Var3, gc3Var4};
        gc3 gc3Var5 = gc3.Y;
        REDUCE_TABLE = new gc3[][]{gc3VarArr, new gc3[]{gc3Var, gc3Var, gc3Var, gc3Var5, gc3Var5, gc3Var}, new gc3[]{gc3Var2, gc3Var2, gc3Var, gc3Var4, gc3Var5, gc3Var}, new gc3[]{gc3Var, gc3Var3, gc3Var3, gc3Var, gc3Var3, gc3Var3}, new gc3[]{gc3Var, gc3Var, gc3Var, gc3Var, gc3Var, gc3Var}, new gc3[]{gc3Var4, gc3Var4, gc3Var4, gc3Var3, gc3Var3, gc3Var}};
        PopularQStr = new String[]{"?", WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD, "+", "??", "*?", "+?"};
        ReduceQStr = new String[]{"", "", WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD, "*?", "??", "+ and ??", "+? and ?"};
    }

    public QuantifierNode(int i, int i2, boolean z) {
        super(5);
        this.lower = i;
        this.upper = i2;
        this.greedy = true;
        this.targetEmptyInfo = 0;
        if (z) {
            setByNumber();
        }
    }

    public static boolean isRepeatInfinite(int i) {
        return i == -1;
    }

    public void clearAddrFixed() {
        this.state &= -513;
    }

    public void clearByNumber() {
        this.state &= -16385;
    }

    public void clearCAlled() {
        this.state &= -257;
    }

    public void clearCLenFixed() {
        this.state &= -5;
    }

    public void clearInRepeat() {
        this.state &= -4097;
    }

    @Override // defpackage.r24
    public /* bridge */ /* synthetic */ void clearMark1() {
        super.clearMark1();
    }

    @Override // defpackage.r24
    public /* bridge */ /* synthetic */ void clearMark2() {
        super.clearMark2();
    }

    public void clearMaxFixed() {
        this.state &= -3;
    }

    public void clearMemBackrefed() {
        this.state &= -33;
    }

    public void clearMinFixed() {
        this.state &= -2;
    }

    public void clearNameRef() {
        this.state &= -2049;
    }

    public void clearNamedGroup() {
        this.state &= -1025;
    }

    public void clearNestLevel() {
        this.state &= -8193;
    }

    public void clearRecursion() {
        this.state &= -129;
    }

    public void clearStopBtSimpleRepeat() {
        this.state &= -65;
    }

    public void copy(QuantifierNode quantifierNode) {
        this.state = quantifierNode.state;
        setTarget(quantifierNode.target);
        quantifierNode.target = null;
        this.lower = quantifierNode.lower;
        this.upper = quantifierNode.upper;
        this.greedy = quantifierNode.greedy;
        this.targetEmptyInfo = quantifierNode.targetEmptyInfo;
        this.headExact = quantifierNode.headExact;
        this.nextHeadExact = quantifierNode.nextHeadExact;
        this.isRefered = quantifierNode.isRefered;
        this.combExpCheckNum = quantifierNode.combExpCheckNum;
    }

    public es2 getChild() {
        return this.target;
    }

    @Override // defpackage.es2
    public String getName() {
        return "Quantifier";
    }

    @Override // defpackage.r24
    public /* bridge */ /* synthetic */ boolean isAddrFixed() {
        return super.isAddrFixed();
    }

    public boolean isAnyCharStar() {
        return this.greedy && isRepeatInfinite(this.upper) && this.target.getType() == 3;
    }

    @Override // defpackage.r24
    public /* bridge */ /* synthetic */ boolean isByNumber() {
        return super.isByNumber();
    }

    @Override // defpackage.r24
    public /* bridge */ /* synthetic */ boolean isCLenFixed() {
        return super.isCLenFixed();
    }

    @Override // defpackage.r24
    public /* bridge */ /* synthetic */ boolean isCalled() {
        return super.isCalled();
    }

    @Override // defpackage.r24
    public /* bridge */ /* synthetic */ boolean isInRepeat() {
        return super.isInRepeat();
    }

    @Override // defpackage.r24
    public /* bridge */ /* synthetic */ boolean isMark1() {
        return super.isMark1();
    }

    @Override // defpackage.r24
    public /* bridge */ /* synthetic */ boolean isMark2() {
        return super.isMark2();
    }

    @Override // defpackage.r24
    public /* bridge */ /* synthetic */ boolean isMaxFixed() {
        return super.isMaxFixed();
    }

    @Override // defpackage.r24
    public /* bridge */ /* synthetic */ boolean isMemBackrefed() {
        return super.isMemBackrefed();
    }

    @Override // defpackage.r24
    public /* bridge */ /* synthetic */ boolean isMinFixed() {
        return super.isMinFixed();
    }

    @Override // defpackage.r24
    public /* bridge */ /* synthetic */ boolean isNameRef() {
        return super.isNameRef();
    }

    @Override // defpackage.r24
    public /* bridge */ /* synthetic */ boolean isNamedGroup() {
        return super.isNamedGroup();
    }

    @Override // defpackage.r24
    public /* bridge */ /* synthetic */ boolean isNestLevel() {
        return super.isNestLevel();
    }

    @Override // defpackage.r24
    public /* bridge */ /* synthetic */ boolean isRecursion() {
        return super.isRecursion();
    }

    @Override // defpackage.r24
    public /* bridge */ /* synthetic */ boolean isStopBtSimpleRepeat() {
        return super.isStopBtSimpleRepeat();
    }

    public int popularNum() {
        boolean z = this.greedy;
        int i = this.lower;
        if (z) {
            if (i != 0) {
                return (i == 1 && isRepeatInfinite(this.upper)) ? 2 : -1;
            }
            int i2 = this.upper;
            if (i2 == 1) {
                return 0;
            }
            return isRepeatInfinite(i2) ? 1 : -1;
        }
        if (i != 0) {
            return (i == 1 && isRepeatInfinite(this.upper)) ? 5 : -1;
        }
        int i3 = this.upper;
        if (i3 == 1) {
            return 3;
        }
        return isRepeatInfinite(i3) ? 4 : -1;
    }

    public void reduceNestedQuantifier(QuantifierNode quantifierNode) {
        int iPopularNum = popularNum();
        int iPopularNum2 = quantifierNode.popularNum();
        if (iPopularNum < 0 || iPopularNum2 < 0) {
            return;
        }
        int iOrdinal = REDUCE_TABLE[iPopularNum2][iPopularNum].ordinal();
        if (iOrdinal == 0) {
            setTarget(quantifierNode);
            return;
        }
        if (iOrdinal == 1) {
            copy(quantifierNode);
        } else if (iOrdinal == 2) {
            setTarget(quantifierNode.target);
            this.lower = 0;
            this.upper = -1;
            this.greedy = true;
        } else if (iOrdinal == 3) {
            setTarget(quantifierNode.target);
            this.lower = 0;
            this.upper = -1;
            this.greedy = false;
        } else if (iOrdinal == 4) {
            setTarget(quantifierNode.target);
            this.lower = 0;
            this.upper = 1;
            this.greedy = false;
        } else if (iOrdinal == 5) {
            setTarget(quantifierNode);
            this.lower = 0;
            this.upper = 1;
            this.greedy = false;
            quantifierNode.lower = 1;
            quantifierNode.upper = -1;
            quantifierNode.greedy = true;
            return;
        }
        quantifierNode.target = null;
    }

    @Override // defpackage.r24
    public /* bridge */ /* synthetic */ void setAddrFixed() {
        super.setAddrFixed();
    }

    public void setByNumber() {
        this.state |= 16384;
    }

    @Override // defpackage.r24
    public /* bridge */ /* synthetic */ void setCLenFixed() {
        super.setCLenFixed();
    }

    @Override // defpackage.r24
    public /* bridge */ /* synthetic */ void setCalled() {
        super.setCalled();
    }

    @Override // defpackage.es2
    public void setChild(es2 es2Var) {
        this.target = es2Var;
    }

    public void setInRepeat() {
        this.state |= 4096;
    }

    @Override // defpackage.r24
    public /* bridge */ /* synthetic */ void setMark1() {
        super.setMark1();
    }

    @Override // defpackage.r24
    public /* bridge */ /* synthetic */ void setMark2() {
        super.setMark2();
    }

    @Override // defpackage.r24
    public /* bridge */ /* synthetic */ void setMaxFixed() {
        super.setMaxFixed();
    }

    @Override // defpackage.r24
    public /* bridge */ /* synthetic */ void setMemBackrefed() {
        super.setMemBackrefed();
    }

    @Override // defpackage.r24
    public /* bridge */ /* synthetic */ void setMinFixed() {
        super.setMinFixed();
    }

    @Override // defpackage.r24
    public /* bridge */ /* synthetic */ void setNameRef() {
        super.setNameRef();
    }

    public void setNamedGroup() {
        this.state |= 1024;
    }

    public void setNestLevel() {
        this.state |= 8192;
    }

    public int setQuantifier(es2 es2Var, boolean z, up3 up3Var, byte[] bArr, int i, int i2) {
        j44 j44Var;
        int iV;
        if (this.lower == 1 && this.upper == 1) {
            up3Var.getClass();
            return 1;
        }
        int type = es2Var.getType();
        if (type != 0) {
            if (type == 5) {
                QuantifierNode quantifierNode = (QuantifierNode) es2Var;
                int iPopularNum = popularNum();
                int iPopularNum2 = quantifierNode.popularNum();
                if (ja0.k && iPopularNum >= 0 && iPopularNum2 >= 0) {
                    up3Var.getClass();
                    if ((33554432 & (-2019556389)) != 0) {
                        gc3[][] gc3VarArr = REDUCE_TABLE;
                        int iOrdinal = gc3VarArr[iPopularNum2][iPopularNum].ordinal();
                        if (iOrdinal != 0) {
                            if (iOrdinal != 1) {
                                String[] strArr = PopularQStr;
                                String str = strArr[iPopularNum2];
                                String str2 = strArr[iPopularNum];
                                String str3 = ReduceQStr[gc3VarArr[iPopularNum2][iPopularNum].ordinal()];
                                new String(bArr, i, i2 - i);
                            } else {
                                String str4 = PopularQStr[iPopularNum2];
                                new String(bArr, i, i2 - i);
                            }
                        }
                    }
                }
                if (iPopularNum2 >= 0) {
                    if (iPopularNum >= 0) {
                        reduceNestedQuantifier(quantifierNode);
                        return 0;
                    }
                    if ((iPopularNum2 == 1 || iPopularNum2 == 2) && !isRepeatInfinite(this.upper) && this.upper > 1 && this.greedy) {
                        int i3 = this.lower;
                        this.upper = i3 != 0 ? i3 : 1;
                    }
                }
            }
        } else if (!z) {
            j44 j44Var2 = (j44) es2Var;
            k0 k0Var = up3Var.c;
            int i4 = j44Var2.c;
            int i5 = j44Var2.b;
            if (i4 > i5) {
                int iR = k0Var.r(i5, i4, j44Var2.a);
                int i6 = j44Var2.c;
                int i7 = j44Var2.b;
                if (iR < i6 - i7) {
                    k0 k0Var2 = up3Var.c;
                    if (i6 <= i7 || (iV = k0Var2.v(i7, i6, i6, j44Var2.a)) == -1 || iV <= j44Var2.b) {
                        j44Var = null;
                    } else {
                        j44Var = new j44(iV, j44Var2.c, j44Var2.a);
                        if (j44Var2.d()) {
                            j44Var.d |= 1;
                        }
                        j44Var2.c = iV;
                    }
                    if (j44Var != null) {
                        setTarget(j44Var);
                        return 2;
                    }
                }
            }
        }
        setTarget(es2Var);
        return 0;
    }

    @Override // defpackage.r24
    public /* bridge */ /* synthetic */ void setRecursion() {
        super.setRecursion();
    }

    @Override // defpackage.r24
    public /* bridge */ /* synthetic */ void setStopBtSimpleRepeat() {
        super.setStopBtSimpleRepeat();
    }

    public void setTarget(es2 es2Var) {
        this.target = es2Var;
        es2Var.parent = this;
    }

    @Override // defpackage.r24
    public /* bridge */ /* synthetic */ String stateToString() {
        return super.stateToString();
    }

    @Override // defpackage.r24, defpackage.es2
    public String toString(int i) {
        StringBuilder sb = new StringBuilder(super.toString(i));
        sb.append("\n  lower: " + this.lower);
        sb.append(", upper: " + this.upper);
        sb.append(", greedy: " + this.greedy);
        sb.append(", isRefered: " + this.isRefered);
        sb.append(", targetEmptyInfo: " + this.targetEmptyInfo);
        sb.append(", combExpCheckNum: " + this.combExpCheckNum);
        StringBuilder sb2 = new StringBuilder("\n  headExact: ");
        int i2 = i + 1;
        sb2.append(es2.pad(this.headExact, i2));
        sb.append(sb2.toString());
        sb.append("\n  nextHeadExact: " + es2.pad(this.nextHeadExact, i2));
        sb.append("\n  target: " + es2.pad(this.target, i2));
        return sb.toString();
    }
}
