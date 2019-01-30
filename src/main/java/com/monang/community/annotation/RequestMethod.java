/**
 * All rights Reserved, Designed By monang<br>
 * <br>
 *
 * @Copyright: 2019 monang. All rights reserved.
 */
package com.monang.community.annotation;

import java.lang.annotation.*;

/**
 * 类名：RequestMethod<br>
 * <br>
 * 功能概要：servlet请求分发注解<br>
 * <br>
 * 创建日期：2019年01月30日 yubin<br>
 * <br>
 * 修改日期：<br>
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestMethod {
    /**
     * Servlet请求分发对应路径
     *
     * @return
     */
    String value();
}
