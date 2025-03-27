package io.github.libsilverwolf.webmvcpolyfill.spring3x.annotation;

import io.github.libsilverwolf.webmvcpolyfill.spring3x.WebMvcPolyfillConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({ WebMvcPolyfillConfiguration.class })
public @interface EnableRestfulPolyfill {
}
