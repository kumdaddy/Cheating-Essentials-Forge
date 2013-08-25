package com.kodehawa.module.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention( RetentionPolicy.RUNTIME )
public @interface ModuleExperimental {

	/**
	 * WIP, Unstable, Unreliable or Randomly errors.
	 */
	String setAs();
	
}
