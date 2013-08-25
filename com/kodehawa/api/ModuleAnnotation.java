package com.kodehawa.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Tells the class loader that this is a module.
 * 
 * @author godshawk
 * 
 */
@Retention( RetentionPolicy.RUNTIME )
public @interface ModuleAnnotation {
}
