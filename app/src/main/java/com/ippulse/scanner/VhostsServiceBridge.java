package com.ippulse.scanner;

import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.github.xfalcon.vhosts.vservice.VhostsService;

public final class VhostsServiceBridge {

    private VhostsServiceBridge() {
    }

    public static void start(
            Context context,
            int mtu,
            String hosts
    ) {
        Intent intent =
                new Intent(
                        context,
                        VhostsService.class
                );

        intent.putExtra(
                "mtu",
                mtu > 0 ? mtu : 247
        );

        intent.putExtra(
                "hosts",
                hosts == null ? "" : hosts
        );

        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    public static void stop(
            Context context
    ) {
        context.stopService(
                new Intent(
                        context,
                        VhostsService.class
                )
        );
    }
}
