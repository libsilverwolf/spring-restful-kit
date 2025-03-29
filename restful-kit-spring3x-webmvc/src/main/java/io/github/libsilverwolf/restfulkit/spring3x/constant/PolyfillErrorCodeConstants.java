package io.github.libsilverwolf.restfulkit.spring3x.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PolyfillErrorCodeConstants {
    NOT_FOUND("ERROR_ROUTE_NOT_FOUND", "Route not found"),
    INTERNAL_SERVER_ERROR("ERROR_INTERNAL_SERVER_ERROR", "Interval server error"),
    BAD_REQUEST("ERROR_BAD_REQUEST", "Bad request");

    private final String errorCode;
    private final String errorMessage;
}
