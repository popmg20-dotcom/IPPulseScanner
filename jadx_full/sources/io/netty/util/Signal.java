package io.netty.util;

import defpackage.s53;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class Signal extends Error implements Constant<Signal> {
    private static final ConstantPool<Signal> pool = new ConstantPool<Signal>() { // from class: io.netty.util.Signal.1
        @Override // io.netty.util.ConstantPool
        public Signal newConstant(int i, String str) {
            return new Signal(i, str);
        }
    };
    private static final long serialVersionUID = -221145131122459977L;
    private final SignalConstant constant;

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static final class SignalConstant extends AbstractConstant<SignalConstant> {
        public SignalConstant(int i, String str) {
            super(i, str);
        }
    }

    private Signal(int i, String str) {
        this.constant = new SignalConstant(i, str);
    }

    public static Signal valueOf(String str) {
        return (Signal) pool.valueOf(str);
    }

    @Override // java.lang.Comparable
    public int compareTo(Signal signal) {
        if (this == signal) {
            return 0;
        }
        return this.constant.compareTo(signal.constant);
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    public void expect(Signal signal) {
        if (this == signal) {
            return;
        }
        s53.j(signal, "unexpected signal: ");
    }

    public int hashCode() {
        return System.identityHashCode(this);
    }

    @Override // io.netty.util.Constant
    public int id() {
        return this.constant.id();
    }

    @Override // io.netty.util.Constant
    public String name() {
        return this.constant.name();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return name();
    }

    public static Signal valueOf(Class<?> cls, String str) {
        return (Signal) pool.valueOf(cls, str);
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    @Override // java.lang.Throwable
    public Throwable initCause(Throwable th) {
        return this;
    }
}
