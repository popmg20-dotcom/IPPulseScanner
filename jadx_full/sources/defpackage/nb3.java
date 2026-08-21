package defpackage;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.util.concurrent.Future;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class nb3 implements ChannelFutureListener {
    public final /* synthetic */ Channel b;
    public final /* synthetic */ ob3 f;

    public nb3(Channel channel, ob3 ob3Var) {
        this.b = channel;
        this.f = ob3Var;
    }

    @Override // io.netty.util.concurrent.GenericFutureListener
    public final void operationComplete(Future future) {
        ChannelFuture channelFuture = (ChannelFuture) future;
        channelFuture.getClass();
        boolean zIsSuccess = channelFuture.isSuccess();
        Channel channel = this.b;
        if (zIsSuccess) {
            channel.read();
            return;
        }
        channel.close();
        ob3 ob3Var = this.f;
        ob3Var.A.close();
        ((Map) ob3Var.b.Z).remove(ob3Var.f);
    }
}
