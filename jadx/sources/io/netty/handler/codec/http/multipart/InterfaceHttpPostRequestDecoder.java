package io.netty.handler.codec.http.multipart;

import io.netty.handler.codec.http.HttpContent;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceHttpPostRequestDecoder {
    void cleanFiles();

    InterfaceHttpData currentPartialHttpData();

    void destroy();

    InterfaceHttpData getBodyHttpData(String str);

    List<InterfaceHttpData> getBodyHttpDatas();

    List<InterfaceHttpData> getBodyHttpDatas(String str);

    int getDiscardThreshold();

    boolean hasNext();

    boolean isMultipart();

    InterfaceHttpData next();

    InterfaceHttpPostRequestDecoder offer(HttpContent httpContent);

    void removeHttpDataFromClean(InterfaceHttpData interfaceHttpData);

    void setDiscardThreshold(int i);
}
