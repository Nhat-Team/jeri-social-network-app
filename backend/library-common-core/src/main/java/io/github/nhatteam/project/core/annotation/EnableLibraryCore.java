package io.github.nhatteam.project.core.annotation;

import io.github.nhatteam.project.core.config.AppConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(AppConfig.class)
public @interface EnableLibraryCore {

}
