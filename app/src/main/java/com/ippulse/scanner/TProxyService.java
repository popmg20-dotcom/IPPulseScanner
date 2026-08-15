package com.ippulse.scanner;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import hev.socks5.tunnel.Tunnel;

public class TProxyService {
    private final Context context;
    private Tunnel tunnel;

    public TProxyService(Context context) {
        this.context = context;
        this.tunnel = new Tunnel();
    }

    public void start(int fd, int mtu) {
        File configFile = new File(context.getCacheDir(), "tun.yml");
        String config =
                "tunnel:\n" +
                "  mtu: " + mtu + "\n" +
                "  ipv4: '10.0.0.2'\n" +
                "socks5:\n" +
                "  address: '127.0.0.1'\n" +
                "  port: 1080\n" +
                "  udp: 'udp'\n";

        try (FileOutputStream fos = new FileOutputStream(configFile)) {
            fos.write(config.getBytes());
            tunnel.StartService(configFile.getAbsolutePath(), fd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        if (tunnel != null) tunnel.StopService();
    }
}
