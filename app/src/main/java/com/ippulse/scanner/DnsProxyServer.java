package com.ippulse.scanner;

import java.io.ByteArrayOutputStream;
import java.net.InetAddress;
import java.util.Locale;

public final class DnsProxyServer {

    private DnsProxyServer() {}

    public static String normalizeDomain(String domain) {
        if (domain == null) return "";

        domain =
                domain.trim()
                        .toLowerCase(Locale.US);

        while (domain.endsWith(".")) {
            domain =
                    domain.substring(
                            0,
                            domain.length() - 1
                    );
        }

        return domain;
    }

    public static byte[] buildMappedResponse(
            byte[] query,
            String mappedIp
    ) {

        try {

            if (query == null
                    || query.length < 17
                    || mappedIp == null) {
                return null;
            }

            Question q =
                    parseQuestion(query);

            if (q == null) return null;

            InetAddress address =
                    InetAddress.getByName(mappedIp);

            byte[] ip =
                    address.getAddress();

            if (ip.length == 4
                    && q.type != 1) {
                return null;
            }

            if (ip.length == 16
                    && q.type != 28) {
                return null;
            }

            ByteArrayOutputStream out =
                    new ByteArrayOutputStream(
                            query.length + 64
                    );

            out.write(query[0]);
            out.write(query[1]);

            out.write(0x85);
            out.write(0x80);

            out.write(0);
            out.write(1);

            out.write(0);
            out.write(1);

            out.write(0);
            out.write(0);

            out.write(0);
            out.write(0);

            out.write(
                    query,
                    12,
                    q.questionLength
            );

            out.write(0xC0);
            out.write(0x0C);

            out.write(
                    (q.type >> 8) & 0xff
            );

            out.write(
                    q.type & 0xff
            );

            out.write(0);
            out.write(1);

            out.write(0);
            out.write(0);
            out.write(0);
            out.write(60);

            out.write(
                    (ip.length >> 8) & 0xff
            );

            out.write(
                    ip.length & 0xff
            );

            out.write(ip);

            return out.toByteArray();

        } catch (Throwable ignored) {
            return null;
        }
    }

    public static String extractQuestionName(
            byte[] query
    ) {

        try {

            Question q =
                    parseQuestion(query);

            return q == null
                    ? null
                    : q.domain;

        } catch (Throwable ignored) {
            return null;
        }
    }

    private static Question parseQuestion(
            byte[] packet
    ) {

        if (packet == null
                || packet.length < 17) {
            return null;
        }

        int pos = 12;

        StringBuilder domain =
                new StringBuilder();

        while (true) {

            if (pos >= packet.length) {
                return null;
            }

            int len =
                    packet[pos++] & 0xff;

            if (len == 0) {
                break;
            }

            if (len > 63
                    || pos + len > packet.length) {
                return null;
            }

            if (domain.length() > 0) {
                domain.append(".");
            }

            for (int i = 0; i < len; i++) {

                domain.append(
                        (char)
                                (packet[pos++] & 0xff)
                );
            }
        }

        if (pos + 4 > packet.length) {
            return null;
        }

        int type =
                ((packet[pos] & 0xff) << 8)
                        | (packet[pos + 1] & 0xff);

        Question q =
                new Question();

        q.domain =
                normalizeDomain(
                        domain.toString()
                );

        q.type = type;

        q.questionLength =
                pos + 4 - 12;

        return q;
    }

    private static final class Question {
        String domain;
        int type;
        int questionLength;
    }
}
