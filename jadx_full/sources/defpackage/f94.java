package defpackage;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class f94 implements ChannelFutureListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ g94 f;
    public final /* synthetic */ Channel z;

    public f94(int i, g94 g94Var, Channel channel) {
        this.b = i;
        this.f = g94Var;
        this.z = channel;
    }

    @Override // io.netty.util.concurrent.GenericFutureListener
    public final void operationComplete(Future future) {
        ChannelFuture channelFuture = (ChannelFuture) future;
        channelFuture.getClass();
        boolean zIsSuccess = channelFuture.isSuccess();
        Channel channel = this.z;
        g94 g94Var = this.f;
        if (!zIsSuccess) {
            channel.close();
            g94Var.b.close();
        } else {
            int i = this.b;
            if (i > 0) {
                dg4.a.a(g94Var.A ? -i : i, g94Var.f, g94Var.Y);
            }
            channel.read();
        }
    }
}
