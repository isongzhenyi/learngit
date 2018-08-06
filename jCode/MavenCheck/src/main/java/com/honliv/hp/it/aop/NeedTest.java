package com.honliv.hp.it.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
// 只能在目标类的方法上使用
@Target(ElementType.METHOD)
// @interface认定为注解类
public @interface NeedTest
{
	boolean value() default true;
}
