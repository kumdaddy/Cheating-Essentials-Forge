package com.kodehawa.ce.module.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention( RetentionPolicy.RUNTIME )
public @interface ModuleLoader {

	 String type( );
}
