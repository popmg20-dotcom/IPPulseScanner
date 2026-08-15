package com.ippulse.scanner;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class SocketRelay {
    private SocketRelay() { }

    public static void relay(Socket client, Socket remote) throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        try {
            executor.execute(() -> copy(client, remote));
            executor.execute(() -> copy(remote, client));
            executor.shutdown();
            while (!executor.isTerminated()) {
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            try { client.close(); } catch (Exception ignored) { }
            try { remote.close(); } catch (Exception ignored) { }
            executor.shutdownNow();
        }
    }

    private static void copy(Socket source, Socket destination) {
        try {
            InputStream in = source.getInputStream();
            OutputStream out = destination.getOutputStream();
            byte[] buffer = new byte[32 * 1024];
            int read;
            while ((read = in.read(buffer)) >= 0) {
                if (read == 0) continue;
                out.write(buffer, 0, read);
                out.flush();
            }
        } catch (Exception ignored) { }
    }
}
