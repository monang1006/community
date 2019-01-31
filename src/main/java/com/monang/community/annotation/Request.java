/**
 * All rights Reserved, Designed By monang<br>
 * <br>
 *
 * @Copyright: 2019 monang. All rights reserved.
 */
package com.monang.community.annotation;

import java.lang.annotation.*;

/**
 * 类名：Request<br>
 * <br>
 * 功能概要：<br>
 * <br>
 * 创建日期：2019年01月31日 monang<br>
 * <br>
 * 修改日期：<br>
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Request {
    /**
     * Servlet请求分发对应路径
     *
     * @return
     */
    String value();
}
