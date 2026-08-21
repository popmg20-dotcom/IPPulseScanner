package defpackage;

import android.os.Process;
import android.util.Log;
import com.tencent.mars.xlog.Xlog;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class e94 extends ChannelInboundHandlerAdapter {
    @Override // io.netty.channel.ChannelHandlerAdapter
    public final boolean isSharable() {
        return true;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public final void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) {
        channelHandlerContext.getClass();
        obj.getClass();
        if (obj instanceof IdleStateEvent) {
            String str = "Closing idle connection: " + channelHandlerContext.channel().remoteAddress() + " -> " + channelHandlerContext.channel().localAddress();
            if (fy4.b) {
                Xlog.logWrite2(0L, 1, "SystemHttpProxy", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str);
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                Log.d("SystemHttpProxy", str, null);
            }
            channelHandlerContext.close();
        }
    }
}
