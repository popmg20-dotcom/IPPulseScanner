package io.netty.handler.codec.http;

import com.tencent.mars.xlog.Xlog;
import defpackage.ha0;
import defpackage.xe;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.PrematureChannelClosureException;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.AppendableCharSequence;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class HttpObjectDecoder extends ByteToMessageDecoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final boolean DEFAULT_ALLOW_DUPLICATE_CONTENT_LENGTHS = false;
    public static final boolean DEFAULT_ALLOW_PARTIAL_CHUNKS = true;
    public static final boolean DEFAULT_CHUNKED_SUPPORTED = true;
    public static final int DEFAULT_INITIAL_BUFFER_SIZE = 128;
    public static final int DEFAULT_MAX_CHUNK_SIZE = 8192;
    public static final int DEFAULT_MAX_HEADER_SIZE = 8192;
    public static final int DEFAULT_MAX_INITIAL_LINE_LENGTH = 4096;
    public static final boolean DEFAULT_VALIDATE_HEADERS = true;
    private static final String EMPTY_VALUE = "";
    private final boolean allowDuplicateContentLengths;
    private final boolean allowPartialChunks;
    private long chunkSize;
    private final boolean chunkedSupported;
    private long contentLength;
    private State currentState;
    private final HeaderParser headerParser;
    private final LineParser lineParser;
    private final int maxChunkSize;
    private HttpMessage message;
    private CharSequence name;
    private volatile boolean resetRequested;
    private LastHttpContent trailer;
    protected final boolean validateHeaders;
    private CharSequence value;

    /* JADX INFO: renamed from: io.netty.handler.codec.http.HttpObjectDecoder$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State = iArr;
            try {
                iArr[State.SKIP_CONTROL_CHARS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_CHUNK_SIZE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_INITIAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_HEADER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_VARIABLE_LENGTH_CONTENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_FIXED_LENGTH_CONTENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_CHUNKED_CONTENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_CHUNK_DELIMITER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_CHUNK_FOOTER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.BAD_MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.UPGRADED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static class HeaderParser implements ByteProcessor {
        private final int maxLength;
        private final AppendableCharSequence seq;
        int size;

        public HeaderParser(AppendableCharSequence appendableCharSequence, int i) {
            this.seq = appendableCharSequence;
            this.maxLength = i;
        }

        public final void increaseCount() {
            int i = this.size + 1;
            this.size = i;
            int i2 = this.maxLength;
            if (i > i2) {
                throw newException(i2);
            }
        }

        public TooLongFrameException newException(int i) {
            return new TooLongHttpHeaderException(ha0.k("HTTP header is larger than ", i, " bytes."));
        }

        public AppendableCharSequence parse(ByteBuf byteBuf) {
            int i = this.size;
            this.seq.reset();
            int iForEachByte = byteBuf.forEachByte(this);
            if (iForEachByte == -1) {
                this.size = i;
                return null;
            }
            byteBuf.readerIndex(iForEachByte + 1);
            return this.seq;
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b) {
            char c = (char) (b & 255);
            if (c != '\n') {
                increaseCount();
                this.seq.append(c);
                return true;
            }
            int length = this.seq.length();
            if (length < 1) {
                return false;
            }
            int i = length - 1;
            if (this.seq.charAtUnsafe(i) != '\r') {
                return false;
            }
            this.size--;
            this.seq.setLength(i);
            return false;
        }

        public void reset() {
            this.size = 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public final class LineParser extends HeaderParser {
        public LineParser(AppendableCharSequence appendableCharSequence, int i) {
            super(appendableCharSequence, i);
        }

        @Override // io.netty.handler.codec.http.HttpObjectDecoder.HeaderParser
        public TooLongFrameException newException(int i) {
            return new TooLongHttpLineException(ha0.k("An HTTP line is larger than ", i, " bytes."));
        }

        @Override // io.netty.handler.codec.http.HttpObjectDecoder.HeaderParser
        public AppendableCharSequence parse(ByteBuf byteBuf) {
            reset();
            return super.parse(byteBuf);
        }

        @Override // io.netty.handler.codec.http.HttpObjectDecoder.HeaderParser, io.netty.util.ByteProcessor
        public boolean process(byte b) {
            if (HttpObjectDecoder.this.currentState == State.SKIP_CONTROL_CHARS) {
                char c = (char) (b & 255);
                if (Character.isISOControl(c) || Character.isWhitespace(c)) {
                    increaseCount();
                    return true;
                }
                HttpObjectDecoder.this.currentState = State.READ_INITIAL;
            }
            return super.process(b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public enum State {
        SKIP_CONTROL_CHARS,
        READ_INITIAL,
        READ_HEADER,
        READ_VARIABLE_LENGTH_CONTENT,
        READ_FIXED_LENGTH_CONTENT,
        READ_CHUNK_SIZE,
        READ_CHUNKED_CONTENT,
        READ_CHUNK_DELIMITER,
        READ_CHUNK_FOOTER,
        BAD_MESSAGE,
        UPGRADED
    }

    public HttpObjectDecoder(int i, int i2, int i3, boolean z, boolean z2, int i4, boolean z3, boolean z4) {
        this.contentLength = Long.MIN_VALUE;
        this.currentState = State.SKIP_CONTROL_CHARS;
        ObjectUtil.checkPositive(i, "maxInitialLineLength");
        ObjectUtil.checkPositive(i2, "maxHeaderSize");
        ObjectUtil.checkPositive(i3, "maxChunkSize");
        AppendableCharSequence appendableCharSequence = new AppendableCharSequence(i4);
        this.lineParser = new LineParser(appendableCharSequence, i);
        this.headerParser = new HeaderParser(appendableCharSequence, i2);
        this.maxChunkSize = i3;
        this.chunkedSupported = z;
        this.validateHeaders = z2;
        this.allowDuplicateContentLengths = z3;
        this.allowPartialChunks = z4;
    }

    private long contentLength() {
        long j = this.contentLength;
        if (j != Long.MIN_VALUE) {
            return j;
        }
        long contentLength = HttpUtil.getContentLength(this.message, -1L);
        this.contentLength = contentLength;
        return contentLength;
    }

    private static int findEndOfString(AppendableCharSequence appendableCharSequence) {
        for (int length = appendableCharSequence.length() - 1; length > 0; length--) {
            if (!Character.isWhitespace(appendableCharSequence.charAtUnsafe(length))) {
                return length + 1;
            }
        }
        return 0;
    }

    private static int findNonSPLenient(AppendableCharSequence appendableCharSequence, int i) {
        while (i < appendableCharSequence.length()) {
            char cCharAtUnsafe = appendableCharSequence.charAtUnsafe(i);
            if (!isSPLenient(cCharAtUnsafe)) {
                if (!Character.isWhitespace(cCharAtUnsafe)) {
                    return i;
                }
                xe.k("Invalid separator");
                return 0;
            }
            i++;
        }
        return appendableCharSequence.length();
    }

    private static int findNonWhitespace(AppendableCharSequence appendableCharSequence, int i) {
        while (i < appendableCharSequence.length()) {
            char cCharAtUnsafe = appendableCharSequence.charAtUnsafe(i);
            if (!Character.isWhitespace(cCharAtUnsafe)) {
                return i;
            }
            if (!isOWS(cCharAtUnsafe)) {
                throw new IllegalArgumentException("Invalid separator, only a single space or horizontal tab allowed, but received a '" + cCharAtUnsafe + "' (0x" + Integer.toHexString(cCharAtUnsafe) + ")");
            }
            i++;
        }
        return appendableCharSequence.length();
    }

    private static int findSPLenient(AppendableCharSequence appendableCharSequence, int i) {
        while (i < appendableCharSequence.length()) {
            if (isSPLenient(appendableCharSequence.charAtUnsafe(i))) {
                return i;
            }
            i++;
        }
        return appendableCharSequence.length();
    }

    private static int getChunkSize(String str) {
        String strTrim = str.trim();
        for (int i = 0; i < strTrim.length(); i++) {
            char cCharAt = strTrim.charAt(i);
            if (cCharAt == ';' || Character.isWhitespace(cCharAt) || Character.isISOControl(cCharAt)) {
                strTrim = strTrim.substring(0, i);
                break;
            }
        }
        return Integer.parseInt(strTrim, 16);
    }

    private HttpContent invalidChunk(ByteBuf byteBuf, Exception exc) {
        this.currentState = State.BAD_MESSAGE;
        byteBuf.skipBytes(byteBuf.readableBytes());
        DefaultLastHttpContent defaultLastHttpContent = new DefaultLastHttpContent(Unpooled.EMPTY_BUFFER);
        defaultLastHttpContent.setDecoderResult(DecoderResult.failure(exc));
        this.message = null;
        this.trailer = null;
        return defaultLastHttpContent;
    }

    private HttpMessage invalidMessage(ByteBuf byteBuf, Exception exc) {
        this.currentState = State.BAD_MESSAGE;
        byteBuf.skipBytes(byteBuf.readableBytes());
        HttpMessage httpMessageCreateInvalidMessage = this.message;
        if (httpMessageCreateInvalidMessage == null) {
            httpMessageCreateInvalidMessage = createInvalidMessage();
            this.message = httpMessageCreateInvalidMessage;
        }
        httpMessageCreateInvalidMessage.setDecoderResult(DecoderResult.failure(exc));
        HttpMessage httpMessage = this.message;
        this.message = null;
        return httpMessage;
    }

    private static boolean isOWS(char c) {
        return c == ' ' || c == '\t';
    }

    private static boolean isSPLenient(char c) {
        return c == ' ' || c == '\t' || c == 11 || c == '\f' || c == '\r';
    }

    private State readHeaders(ByteBuf byteBuf) {
        HttpMessage httpMessage = this.message;
        HttpHeaders httpHeadersHeaders = httpMessage.headers();
        AppendableCharSequence appendableCharSequence = this.headerParser.parse(byteBuf);
        if (appendableCharSequence == null) {
            return null;
        }
        if (appendableCharSequence.length() > 0) {
            do {
                char cCharAtUnsafe = appendableCharSequence.charAtUnsafe(0);
                CharSequence charSequence = this.name;
                if (charSequence == null || !(cCharAtUnsafe == ' ' || cCharAtUnsafe == '\t')) {
                    if (charSequence != null) {
                        httpHeadersHeaders.add(charSequence, this.value);
                    }
                    splitHeader(appendableCharSequence);
                } else {
                    this.value = String.valueOf(this.value) + ' ' + appendableCharSequence.toString().trim();
                }
                appendableCharSequence = this.headerParser.parse(byteBuf);
                if (appendableCharSequence == null) {
                    return null;
                }
            } while (appendableCharSequence.length() > 0);
        }
        CharSequence charSequence2 = this.name;
        if (charSequence2 != null) {
            httpHeadersHeaders.add(charSequence2, this.value);
        }
        this.name = null;
        this.value = null;
        httpMessage.setDecoderResult(new HttpMessageDecoderResult(this.lineParser.size, this.headerParser.size));
        AsciiString asciiString = HttpHeaderNames.CONTENT_LENGTH;
        List<String> all = httpHeadersHeaders.getAll(asciiString);
        if (!all.isEmpty()) {
            HttpVersion httpVersionProtocolVersion = httpMessage.protocolVersion();
            long jNormalizeAndGetContentLength = HttpUtil.normalizeAndGetContentLength(all, httpVersionProtocolVersion.majorVersion() < 1 || (httpVersionProtocolVersion.majorVersion() == 1 && httpVersionProtocolVersion.minorVersion() == 0), this.allowDuplicateContentLengths);
            this.contentLength = jNormalizeAndGetContentLength;
            if (jNormalizeAndGetContentLength != -1) {
                String strTrim = all.get(0).trim();
                if (all.size() > 1 || !strTrim.equals(Long.toString(this.contentLength))) {
                    httpHeadersHeaders.set(asciiString, Long.valueOf(this.contentLength));
                }
            }
        }
        if (isContentAlwaysEmpty(httpMessage)) {
            HttpUtil.setTransferEncodingChunked(httpMessage, false);
            return State.SKIP_CONTROL_CHARS;
        }
        if (!HttpUtil.isTransferEncodingChunked(httpMessage)) {
            return contentLength() >= 0 ? State.READ_FIXED_LENGTH_CONTENT : State.READ_VARIABLE_LENGTH_CONTENT;
        }
        if (!all.isEmpty() && httpMessage.protocolVersion() == HttpVersion.HTTP_1_1) {
            handleTransferEncodingChunkedWithContentLength(httpMessage);
        }
        return State.READ_CHUNK_SIZE;
    }

    private LastHttpContent readTrailingHeaders(ByteBuf byteBuf) {
        AppendableCharSequence appendableCharSequence = this.headerParser.parse(byteBuf);
        if (appendableCharSequence == null) {
            return null;
        }
        LastHttpContent defaultLastHttpContent = this.trailer;
        if (appendableCharSequence.length() == 0 && defaultLastHttpContent == null) {
            return LastHttpContent.EMPTY_LAST_CONTENT;
        }
        if (defaultLastHttpContent == null) {
            defaultLastHttpContent = new DefaultLastHttpContent(Unpooled.EMPTY_BUFFER, this.validateHeaders);
            this.trailer = defaultLastHttpContent;
        }
        CharSequence charSequence = null;
        while (appendableCharSequence.length() > 0) {
            char cCharAtUnsafe = appendableCharSequence.charAtUnsafe(0);
            if (charSequence == null || !(cCharAtUnsafe == ' ' || cCharAtUnsafe == '\t')) {
                splitHeader(appendableCharSequence);
                CharSequence charSequence2 = this.name;
                if (!HttpHeaderNames.CONTENT_LENGTH.contentEqualsIgnoreCase(charSequence2) && !HttpHeaderNames.TRANSFER_ENCODING.contentEqualsIgnoreCase(charSequence2) && !HttpHeaderNames.TRAILER.contentEqualsIgnoreCase(charSequence2)) {
                    defaultLastHttpContent.trailingHeaders().add(charSequence2, this.value);
                }
                charSequence = this.name;
                this.name = null;
                this.value = null;
            } else {
                List<String> all = defaultLastHttpContent.trailingHeaders().getAll(charSequence);
                if (!all.isEmpty()) {
                    int size = all.size() - 1;
                    String strTrim = appendableCharSequence.toString().trim();
                    all.set(size, all.get(size) + strTrim);
                }
            }
            appendableCharSequence = this.headerParser.parse(byteBuf);
            if (appendableCharSequence == null) {
                return null;
            }
        }
        this.trailer = null;
        return defaultLastHttpContent;
    }

    private void resetNow() {
        HttpResponse httpResponse;
        HttpMessage httpMessage = this.message;
        this.message = null;
        this.name = null;
        this.value = null;
        this.contentLength = Long.MIN_VALUE;
        this.lineParser.reset();
        this.headerParser.reset();
        this.trailer = null;
        if (!isDecodingRequest() && (httpResponse = (HttpResponse) httpMessage) != null && isSwitchingToNonHttp1Protocol(httpResponse)) {
            this.currentState = State.UPGRADED;
        } else {
            this.resetRequested = false;
            this.currentState = State.SKIP_CONTROL_CHARS;
        }
    }

    private void splitHeader(AppendableCharSequence appendableCharSequence) {
        char cCharAtUnsafe;
        int length = appendableCharSequence.length();
        int iFindNonWhitespace = findNonWhitespace(appendableCharSequence, 0);
        int i = iFindNonWhitespace;
        while (i < length && (cCharAtUnsafe = appendableCharSequence.charAtUnsafe(i)) != ':' && (isDecodingRequest() || !isOWS(cCharAtUnsafe))) {
            i++;
        }
        if (i == length) {
            xe.k("No colon found");
            return;
        }
        int i2 = i;
        while (true) {
            if (i2 >= length) {
                break;
            }
            if (appendableCharSequence.charAtUnsafe(i2) == ':') {
                i2++;
                break;
            }
            i2++;
        }
        this.name = appendableCharSequence.subStringUnsafe(iFindNonWhitespace, i);
        int iFindNonWhitespace2 = findNonWhitespace(appendableCharSequence, i2);
        if (iFindNonWhitespace2 == length) {
            this.value = "";
        } else {
            this.value = appendableCharSequence.subStringUnsafe(iFindNonWhitespace2, findEndOfString(appendableCharSequence));
        }
    }

    private static String[] splitInitialLine(AppendableCharSequence appendableCharSequence) {
        int iFindNonSPLenient = findNonSPLenient(appendableCharSequence, 0);
        int iFindSPLenient = findSPLenient(appendableCharSequence, iFindNonSPLenient);
        int iFindNonSPLenient2 = findNonSPLenient(appendableCharSequence, iFindSPLenient);
        int iFindSPLenient2 = findSPLenient(appendableCharSequence, iFindNonSPLenient2);
        int iFindNonSPLenient3 = findNonSPLenient(appendableCharSequence, iFindSPLenient2);
        int iFindEndOfString = findEndOfString(appendableCharSequence);
        return new String[]{appendableCharSequence.subStringUnsafe(iFindNonSPLenient, iFindSPLenient), appendableCharSequence.subStringUnsafe(iFindNonSPLenient2, iFindSPLenient2), iFindNonSPLenient3 < iFindEndOfString ? appendableCharSequence.subStringUnsafe(iFindNonSPLenient3, iFindEndOfString) : ""};
    }

    public abstract HttpMessage createInvalidMessage();

    public abstract HttpMessage createMessage(String[] strArr);

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0117 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x014d A[Catch: Exception -> 0x0170, TryCatch #0 {Exception -> 0x0170, blocks: (B:80:0x0146, B:83:0x014d, B:87:0x015b, B:91:0x0169, B:96:0x0172, B:98:0x017b, B:100:0x017e, B:102:0x018c, B:104:0x0190, B:106:0x0196, B:107:0x019d, B:108:0x019e), top: B:114:0x0146 }] */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        State headers;
        int iWriterIndex;
        int i;
        int i2;
        int iMin;
        if (this.resetRequested) {
            resetNow();
        }
        int[] iArr = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State;
        switch (iArr[this.currentState.ordinal()]) {
            case 1:
            case 3:
                try {
                    AppendableCharSequence appendableCharSequence = this.lineParser.parse(byteBuf);
                    if (appendableCharSequence == null) {
                        return;
                    }
                    String[] strArrSplitInitialLine = splitInitialLine(appendableCharSequence);
                    if (strArrSplitInitialLine.length < 3) {
                        this.currentState = State.SKIP_CONTROL_CHARS;
                        return;
                    }
                    this.message = createMessage(strArrSplitInitialLine);
                    this.currentState = State.READ_HEADER;
                    try {
                        headers = readHeaders(byteBuf);
                        if (headers != null) {
                            return;
                        }
                        this.currentState = headers;
                        int i3 = iArr[headers.ordinal()];
                        if (i3 == 1) {
                            list.add(this.message);
                            list.add(LastHttpContent.EMPTY_LAST_CONTENT);
                            resetNow();
                            return;
                        }
                        if (i3 == 2) {
                            if (!this.chunkedSupported) {
                                throw new IllegalArgumentException("Chunked messages not supported");
                            }
                            list.add(this.message);
                            return;
                        }
                        long jContentLength = contentLength();
                        if (jContentLength != 0 && (jContentLength != -1 || !isDecodingRequest())) {
                            list.add(this.message);
                            if (headers == State.READ_FIXED_LENGTH_CONTENT) {
                                this.chunkSize = jContentLength;
                                return;
                            }
                            return;
                        }
                        list.add(this.message);
                        list.add(LastHttpContent.EMPTY_LAST_CONTENT);
                        resetNow();
                        return;
                    } catch (Exception e) {
                        list.add(invalidMessage(byteBuf, e));
                        return;
                    }
                } catch (Exception e2) {
                    list.add(invalidMessage(byteBuf, e2));
                    return;
                }
            case 2:
                try {
                    AppendableCharSequence appendableCharSequence2 = this.lineParser.parse(byteBuf);
                    if (appendableCharSequence2 == null) {
                        return;
                    }
                    int chunkSize = getChunkSize(appendableCharSequence2.toString());
                    this.chunkSize = chunkSize;
                    if (chunkSize == 0) {
                        this.currentState = State.READ_CHUNK_FOOTER;
                        return;
                    }
                    this.currentState = State.READ_CHUNKED_CONTENT;
                    int iMin2 = Math.min((int) this.chunkSize, this.maxChunkSize);
                    if ((!this.allowPartialChunks || byteBuf.readableBytes() >= iMin2) && (iMin = Math.min(iMin2, byteBuf.readableBytes())) != 0) {
                        DefaultHttpContent defaultHttpContent = new DefaultHttpContent(byteBuf.readRetainedSlice(iMin));
                        this.chunkSize -= (long) iMin;
                        list.add(defaultHttpContent);
                        if (this.chunkSize == 0) {
                            return;
                        }
                        this.currentState = State.READ_CHUNK_DELIMITER;
                        iWriterIndex = byteBuf.writerIndex();
                        i = byteBuf.readerIndex();
                        while (true) {
                            if (iWriterIndex <= i) {
                                i2 = i + 1;
                                if (byteBuf.getByte(i) == 10) {
                                    this.currentState = State.READ_CHUNK_SIZE;
                                    i = i2;
                                } else {
                                    i = i2;
                                }
                            }
                        }
                        byteBuf.readerIndex(i);
                        return;
                    }
                    return;
                } catch (Exception e3) {
                    list.add(invalidChunk(byteBuf, e3));
                    return;
                }
            case 4:
                headers = readHeaders(byteBuf);
                if (headers != null) {
                }
                break;
            case 5:
                int iMin3 = Math.min(byteBuf.readableBytes(), this.maxChunkSize);
                if (iMin3 > 0) {
                    list.add(new DefaultHttpContent(byteBuf.readRetainedSlice(iMin3)));
                    return;
                }
                return;
            case 6:
                int i4 = byteBuf.readableBytes();
                if (i4 == 0) {
                    return;
                }
                int iMin4 = Math.min(i4, this.maxChunkSize);
                long j = iMin4;
                long j2 = this.chunkSize;
                if (j > j2) {
                    iMin4 = (int) j2;
                }
                ByteBuf retainedSlice = byteBuf.readRetainedSlice(iMin4);
                long j3 = this.chunkSize - ((long) iMin4);
                this.chunkSize = j3;
                if (j3 != 0) {
                    list.add(new DefaultHttpContent(retainedSlice));
                    return;
                } else {
                    list.add(new DefaultLastHttpContent(retainedSlice, this.validateHeaders));
                    resetNow();
                    return;
                }
            case 7:
                int iMin22 = Math.min((int) this.chunkSize, this.maxChunkSize);
                if (this.allowPartialChunks) {
                }
                DefaultHttpContent defaultHttpContent2 = new DefaultHttpContent(byteBuf.readRetainedSlice(iMin));
                this.chunkSize -= (long) iMin;
                list.add(defaultHttpContent2);
                if (this.chunkSize == 0) {
                }
                break;
            case 8:
                iWriterIndex = byteBuf.writerIndex();
                i = byteBuf.readerIndex();
                while (true) {
                    if (iWriterIndex <= i) {
                    }
                    i = i2;
                }
                byteBuf.readerIndex(i);
                return;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                try {
                    LastHttpContent trailingHeaders = readTrailingHeaders(byteBuf);
                    if (trailingHeaders == null) {
                        return;
                    }
                    list.add(trailingHeaders);
                    resetNow();
                    return;
                } catch (Exception e4) {
                    list.add(invalidChunk(byteBuf, e4));
                    return;
                }
            case 10:
                byteBuf.skipBytes(byteBuf.readableBytes());
                return;
            case 11:
                int i5 = byteBuf.readableBytes();
                if (i5 > 0) {
                    list.add(byteBuf.readBytes(i5));
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decodeLast(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        super.decodeLast(channelHandlerContext, byteBuf, list);
        if (this.resetRequested) {
            resetNow();
        }
        HttpMessage httpMessage = this.message;
        if (httpMessage != null) {
            boolean zIsTransferEncodingChunked = HttpUtil.isTransferEncodingChunked(httpMessage);
            if (this.currentState == State.READ_VARIABLE_LENGTH_CONTENT && !byteBuf.isReadable() && !zIsTransferEncodingChunked) {
                list.add(LastHttpContent.EMPTY_LAST_CONTENT);
                resetNow();
            } else {
                if (this.currentState == State.READ_HEADER) {
                    list.add(invalidMessage(Unpooled.EMPTY_BUFFER, new PrematureChannelClosureException("Connection closed before received headers")));
                    resetNow();
                    return;
                }
                if (!isDecodingRequest() && !zIsTransferEncodingChunked && contentLength() <= 0) {
                    list.add(LastHttpContent.EMPTY_LAST_CONTENT);
                }
                resetNow();
            }
        }
    }

    public void handleTransferEncodingChunkedWithContentLength(HttpMessage httpMessage) {
        httpMessage.headers().remove(HttpHeaderNames.CONTENT_LENGTH);
        this.contentLength = Long.MIN_VALUE;
    }

    public boolean isContentAlwaysEmpty(HttpMessage httpMessage) {
        if (!(httpMessage instanceof HttpResponse)) {
            return false;
        }
        HttpResponse httpResponse = (HttpResponse) httpMessage;
        HttpResponseStatus httpResponseStatusStatus = httpResponse.status();
        int iCode = httpResponseStatusStatus.code();
        return httpResponseStatusStatus.codeClass() == HttpStatusClass.INFORMATIONAL ? (iCode == 101 && !httpResponse.headers().contains(HttpHeaderNames.SEC_WEBSOCKET_ACCEPT) && httpResponse.headers().contains((CharSequence) HttpHeaderNames.UPGRADE, (CharSequence) HttpHeaderValues.WEBSOCKET, true)) ? false : true : iCode == 204 || iCode == 304;
    }

    public abstract boolean isDecodingRequest();

    public boolean isSwitchingToNonHttp1Protocol(HttpResponse httpResponse) {
        if (httpResponse.status().code() != HttpResponseStatus.SWITCHING_PROTOCOLS.code()) {
            return false;
        }
        String str = httpResponse.headers().get(HttpHeaderNames.UPGRADE);
        if (str != null) {
            return (str.contains(HttpVersion.HTTP_1_0.text()) || str.contains(HttpVersion.HTTP_1_1.text())) ? false : true;
        }
        return true;
    }

    public void reset() {
        this.resetRequested = true;
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) {
        int i;
        if ((obj instanceof HttpExpectationFailedEvent) && ((i = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[this.currentState.ordinal()]) == 2 || i == 5 || i == 6)) {
            reset();
        }
        super.userEventTriggered(channelHandlerContext, obj);
    }

    public HttpObjectDecoder(int i, int i2, int i3, boolean z) {
        this(i, i2, i3, z, true);
    }

    public HttpObjectDecoder(int i, int i2, int i3, boolean z, boolean z2) {
        this(i, i2, i3, z, z2, 128);
    }

    public HttpObjectDecoder(int i, int i2, int i3, boolean z, boolean z2, int i4) {
        this(i, i2, i3, z, z2, i4, false);
    }

    public HttpObjectDecoder(int i, int i2, int i3, boolean z, boolean z2, int i4, boolean z3) {
        this(i, i2, i3, z, z2, i4, z3, true);
    }

    public HttpObjectDecoder() {
        this(4096, 8192, 8192, true);
    }
}
