package defpackage;

import android.app.ApplicationExitInfo;
import android.hardware.camera2.params.DynamicRangeProfiles;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.installations.FirebaseInstallationsRegistrar;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFactory;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import java.io.FileNotFoundException;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a71 implements n90, ChannelFactory {
    public final /* synthetic */ int b;

    public /* synthetic */ a71(int i) {
        this.b = i;
    }

    public static /* bridge */ /* synthetic */ ApplicationExitInfo a(Object obj) {
        return (ApplicationExitInfo) obj;
    }

    public static /* bridge */ /* synthetic */ DynamicRangeProfiles b(Object obj) {
        return (DynamicRangeProfiles) obj;
    }

    public static /* synthetic */ void d(int i, Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(obj);
        throw new IllegalArgumentException(sb.toString());
    }

    public static /* synthetic */ void e(int i, String str) {
        throw new IllegalArgumentException(str + i);
    }

    public static /* synthetic */ void f(Object obj, String str) throws FileNotFoundException {
        throw new FileNotFoundException(str + obj);
    }

    public static /* synthetic */ void h(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        throw new IllegalArgumentException(str + obj + obj2 + obj3 + obj4);
    }

    public static /* synthetic */ void i(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        throw new IllegalArgumentException(str + obj + obj2 + obj3 + obj4 + obj5);
    }

    public static /* synthetic */ void j(String str, Object obj, Throwable th) {
        throw new IllegalArgumentException(str + obj, th);
    }

    @Override // defpackage.n90
    public Object g(rk3 rk3Var) {
        switch (this.b) {
            case 0:
                return (ScheduledExecutorService) ExecutorsRegistrar.c.get();
            case 1:
                return (ScheduledExecutorService) ExecutorsRegistrar.b.get();
            case 2:
                a92 a92Var = ExecutorsRegistrar.a;
                return vk4.b;
            default:
                return FirebaseInstallationsRegistrar.lambda$getComponents$0(rk3Var);
        }
    }

    @Override // io.netty.channel.ChannelFactory, io.netty.bootstrap.ChannelFactory
    public Channel newChannel() {
        return new NioServerSocketChannel();
    }
}
