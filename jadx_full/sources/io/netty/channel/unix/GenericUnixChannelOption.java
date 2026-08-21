package io.netty.channel.unix;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class GenericUnixChannelOption<T> extends UnixChannelOption<T> {
    private final int level;
    private final int optname;

    public GenericUnixChannelOption(String str, int i, int i2) {
        super(str);
        this.level = i;
        this.optname = i2;
    }

    public int level() {
        return this.level;
    }

    public int optname() {
        return this.optname;
    }
}
