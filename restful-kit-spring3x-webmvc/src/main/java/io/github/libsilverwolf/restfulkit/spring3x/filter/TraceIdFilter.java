package io.github.libsilverwolf.restfulkit.spring3x.filter;

import io.github.libsilverwolf.restfulkit.spring3x.dto.WebMvcBaseResponse;
import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@Slf4j
public class TraceIdFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String uuid = UUID.randomUUID().toString();

        log.debug("Generated new trace id: {}", uuid);
        
        MDC.put("traceId", uuid);

        WebMvcBaseResponse.setCurrentTraceId(uuid);

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
