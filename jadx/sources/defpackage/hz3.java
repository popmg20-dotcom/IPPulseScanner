package defpackage;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class hz3 extends SimpleChannelInboundHandler {
    public final /* synthetic */ int b = 0;
    public final Object f;

    public hz3(cm2 cm2Var) {
        cm2Var.getClass();
        this.f = cm2Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0318 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02ac A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02fd  */
    @Override // io.netty.channel.SimpleChannelInboundHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void channelRead0(final io.netty.channel.ChannelHandlerContext r36, java.lang.Object r37) {
        /*
            Method dump skipped, instruction units count: 1094
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hz3.channelRead0(io.netty.channel.ChannelHandlerContext, java.lang.Object):void");
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
        switch (this.b) {
            case 1:
                channelHandlerContext.getClass();
                th.getClass();
                channelHandlerContext.close();
                break;
            default:
                super.exceptionCaught(channelHandlerContext, th);
                break;
        }
    }

    public hz3(i94 i94Var) {
        this.f = i94Var;
    }
}
