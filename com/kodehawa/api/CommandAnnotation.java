package com.kodehawa.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Tells the class loader that this is a command
 * 
 * @author godshawk
 * 
 */
@Retention( RetentionPolicy.RUNTIME )
public @interface CommandAnnotation {
}
