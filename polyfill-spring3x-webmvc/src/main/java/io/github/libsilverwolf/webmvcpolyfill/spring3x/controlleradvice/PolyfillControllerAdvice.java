package io.github.libsilverwolf.webmvcpolyfill.spring3x.controlleradvice;

import io.github.libsilverwolf.webmvcpolyfill.spring3x.constant.PolyfillErrorCodeConstants;
import io.github.libsilverwolf.webmvcpolyfill.spring3x.dto.WebMvcBaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
// import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
@ResponseBody
@Slf4j
public class PolyfillControllerAdvice {

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public WebMvcBaseResponse<?> defaultExceptionHandler(Throwable exc) {
        log.error("Failed to handle request", exc);
        return WebMvcBaseResponse.failed("internal server error", "");
    }

    // @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public WebMvcBaseResponse<?> notFoundHandler(Throwable exc) {
        return WebMvcBaseResponse.failed(PolyfillErrorCodeConstants.NOT_FOUND.getErrorCode(), PolyfillErrorCodeConstants.NOT_FOUND.getErrorMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public WebMvcBaseResponse<?> badRequestHandler(Throwable exc) {
        return WebMvcBaseResponse.failed(PolyfillErrorCodeConstants.BAD_REQUEST.getErrorCode(), exc.getMessage());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public WebMvcBaseResponse<?> missingServletRequestParameter(Throwable exc) {
        return WebMvcBaseResponse.failed(PolyfillErrorCodeConstants.BAD_REQUEST.getErrorCode(), exc.getMessage());
    }

}
