/**
 * All rights Reserved, Designed By monang<br>
 * <br>
 *
 * @Copyright: 2018 monang. All rights reserved.
 */
package com.monang.community.exception;

/**
 * 类名 ：FrameException<br>
 * <br>
 * 功能概要：框架异常类<br>
 * <br>
 * 创建日期：2018年6月14日 yubin<br>
 * <br>
 * 修改日期：<br>
 */
public class FrameException extends RuntimeException {

    public FrameException() {

    }

    public FrameException(String message) {
        super(message);
    }

    public FrameException(Throwable t) {
        super(t);
    }

    public FrameException(String message, Throwable t) {
        super(message, t);
    }

}
