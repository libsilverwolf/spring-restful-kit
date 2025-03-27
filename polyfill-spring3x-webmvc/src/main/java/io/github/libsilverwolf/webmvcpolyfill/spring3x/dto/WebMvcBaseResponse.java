package io.github.libsilverwolf.webmvcpolyfill.spring3x.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WebMvcBaseResponse<T> {
    public static final ThreadLocal<String> traceIdHolder = ThreadLocal.withInitial(() -> "unset");

    public static String getCurrentTraceId() {
        return traceIdHolder.get();
    }

    public static void setCurrentTraceId(String traceId) {
        traceIdHolder.set(traceId);
    }

    public static <T> WebMvcBaseResponse<T> success(T data) {
        return WebMvcBaseResponse.<T>builder()
                .success(true)
                .data(data)
                .traceId(getCurrentTraceId())
                .host(System.getenv("HOST"))
                .build();
    }

    public static <T> WebMvcBaseResponse<T> success() {
        return success(null);
    }

    public static <T> WebMvcBaseResponse<T> failed(String errorCode, String errorMessage) {
        return WebMvcBaseResponse.<T>builder()
                .success(false)
                .errorCode(errorCode)
                .errorMessage(errorMessage)
                .traceId(getCurrentTraceId())
                .host(System.getenv("HOST"))
                .build();
    }

    /**
     * if request is success
     */
    private Boolean success;
    /**
     * response data
     */
    private T data;
    /**
     * code for errorType
     */
    private String errorCode;
    /**
     * message display to user
     */
    private String errorMessage;
    /**
     * Convenient for back-end Troubleshooting: unique request ID
     */
    private String traceId;
    /**
     * Convenient for backend Troubleshooting: host of current access server
     */
    private String host;
}
