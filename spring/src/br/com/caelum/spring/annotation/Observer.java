/**
 * 
 */
package br.com.caelum.spring.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author arq3849
 *
 */
@Retention(RUNTIME)
@Target(PARAMETER)
@Documented
public @interface Observer {

}
