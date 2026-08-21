package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r24 extends es2 {
    protected int state;

    public void clearMark1() {
        this.state &= -9;
    }

    public void clearMark2() {
        this.state &= -17;
    }

    public boolean isAddrFixed() {
        return (this.state & 512) != 0;
    }

    public boolean isByNumber() {
        return (this.state & 16384) != 0;
    }

    public boolean isCLenFixed() {
        return (this.state & 4) != 0;
    }

    public boolean isCalled() {
        return (this.state & 256) != 0;
    }

    public boolean isInRepeat() {
        return (this.state & 4096) != 0;
    }

    public boolean isMark1() {
        return (this.state & 8) != 0;
    }

    public boolean isMark2() {
        return (this.state & 16) != 0;
    }

    public boolean isMaxFixed() {
        return (this.state & 2) != 0;
    }

    public boolean isMemBackrefed() {
        return (this.state & 32) != 0;
    }

    public boolean isMinFixed() {
        return (this.state & 1) != 0;
    }

    public boolean isNameRef() {
        return (this.state & 2048) != 0;
    }

    public boolean isNamedGroup() {
        return (this.state & 1024) != 0;
    }

    public boolean isNestLevel() {
        return (this.state & 8192) != 0;
    }

    public boolean isRecursion() {
        return (this.state & 128) != 0;
    }

    public boolean isStopBtSimpleRepeat() {
        return (this.state & 64) != 0;
    }

    public void setAddrFixed() {
        this.state |= 512;
    }

    public void setCLenFixed() {
        this.state |= 4;
    }

    public void setCalled() {
        this.state |= 256;
    }

    public void setMark1() {
        this.state |= 8;
    }

    public void setMark2() {
        this.state |= 16;
    }

    public void setMaxFixed() {
        this.state |= 2;
    }

    public void setMemBackrefed() {
        this.state |= 32;
    }

    public void setMinFixed() {
        this.state |= 1;
    }

    public void setNameRef() {
        this.state |= 2048;
    }

    public void setRecursion() {
        this.state |= 128;
    }

    public void setStopBtSimpleRepeat() {
        this.state |= 64;
    }

    public String stateToString() {
        StringBuilder sb = new StringBuilder();
        if (isMinFixed()) {
            sb.append("MIN_FIXED ");
        }
        if (isMaxFixed()) {
            sb.append("MAX_FIXED ");
        }
        if (isMark1()) {
            sb.append("MARK1 ");
        }
        if (isMark2()) {
            sb.append("MARK2 ");
        }
        if (isMemBackrefed()) {
            sb.append("MEM_BACKREFED ");
        }
        if (isStopBtSimpleRepeat()) {
            sb.append("STOP_BT_SIMPLE_REPEAT ");
        }
        if (isRecursion()) {
            sb.append("RECURSION ");
        }
        if (isCalled()) {
            sb.append("CALLED ");
        }
        if (isAddrFixed()) {
            sb.append("ADDR_FIXED ");
        }
        if (isNamedGroup()) {
            sb.append("NAMED_GROUP ");
        }
        if (isNameRef()) {
            sb.append("NAME_REF ");
        }
        if (isInRepeat()) {
            sb.append("IN_REPEAT ");
        }
        if (isNestLevel()) {
            sb.append("NEST_LEVEL ");
        }
        if (isByNumber()) {
            sb.append("BY_NUMBER ");
        }
        return sb.toString();
    }

    @Override // defpackage.es2
    public String toString(int i) {
        return "\n  state: " + stateToString();
    }
}
