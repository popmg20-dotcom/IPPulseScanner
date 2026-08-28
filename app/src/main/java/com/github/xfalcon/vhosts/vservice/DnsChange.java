package com.github.xfalcon.vhosts.vservice;

import com.github.xfalcon.vhosts.util.LogUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xbill.DNS.Address;

/* JADX INFO: loaded from: classes5.dex */
public class DnsChange {
    static String TAG = DnsChange.class.getSimpleName();
    static ConcurrentHashMap<String, String> DOMAINS_IP_MAPS4 = null;
    static ConcurrentHashMap<String, String> DOMAINS_IP_MAPS6 = null;

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ad, code lost:

        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.nio.ByteBuffer handle_dns_packet(com.github.xfalcon.vhosts.vservice.Packet r24) {
        /*
            Method dump skipped, instruction units count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.xfalcon.vhosts.vservice.DnsChange.handle_dns_packet(com.github.xfalcon.vhosts.vservice.Packet):java.nio.ByteBuffer");
    }

    public static int handle_hosts(InputStream inputStream) {
        String line;
        String HOST_PATTERN_STR = "^\\s*(#?)\\s*(\\S*)\\s*([^#]*)#?(.*)$";
        Pattern HOST_PATTERN = Pattern.compile(HOST_PATTERN_STR);
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            DOMAINS_IP_MAPS4 = new ConcurrentHashMap<>();
            DOMAINS_IP_MAPS6 = new ConcurrentHashMap<>();
            while (!Thread.interrupted() && (line = reader.readLine()) != null) {
                if (line.length() <= 1000 && !line.startsWith("#")) {
                    Matcher matcher = HOST_PATTERN.matcher(line);
                    if (matcher.find()) {
                        String ip = matcher.group(2).trim();
                        try {
                            Address.getByAddress(ip);
                            if (ip.contains(":")) {
                                DOMAINS_IP_MAPS6.put(matcher.group(3).trim() + ".", ip);
                            } else {
                                DOMAINS_IP_MAPS4.put(matcher.group(3).trim() + ".", ip);
                            }
                        } catch (Exception e) {
                        }
                    }
                }
            }
            reader.close();
            inputStream.close();
            LogUtils.d(TAG, DOMAINS_IP_MAPS4.toString());
            LogUtils.d(TAG, DOMAINS_IP_MAPS6.toString());
            return DOMAINS_IP_MAPS4.size() + DOMAINS_IP_MAPS6.size();
        } catch (IOException e2) {
            LogUtils.d(TAG, "Hook dns error", e2);
            return 0;
        }
    }
}
