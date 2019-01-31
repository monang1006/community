/**
 * All rights Reserved, Designed By monang<br>
 * <br>
 *
 * @Copyright: 2019 monang. All rights reserved.
 */
package com.monang.community.controller;

/**
 * 类名：ControllerBuilder<br>
 * <br>
 * 功能概要：<br>
 * <br>
 * 创建日期：2019年01月31日 monang<br>
 * <br>
 * 修改日期：<br>
 */
public class ControllerBuilder {

    public static void build() throws Exception{
        ClassPool classPool = ClassPool.getDefault();

        // 创建一个类
        CtClass ctClass = classPool.makeClass("com.test.Person");

        // 为类型设置字段
        CtField field = new CtField(classPool.get(String.class.getName()), "userName", ctClass);
        field.setModifiers(Modifier.PRIVATE);
        // 添加getter和setter方法
        ctClass.addMethod(CtNewMethod.setter("setUserName", field));
        ctClass.addMethod(CtNewMethod.getter("getUserName", field));
        ctClass.addField(field);

        // 为类设置构造器
        // 无参构造器
        CtConstructor constructor = new CtConstructor(null, ctClass);
        constructor.setModifiers(Modifier.PUBLIC);
        constructor.setBody("{}");
        ctClass.addConstructor(constructor);
        // 参数构造器
        constructor = new CtConstructor(new CtClass[] {classPool.get(String.class.getName())}, ctClass);
        constructor.setModifiers(Modifier.PUBLIC);
        constructor.setBody("{this.userName=$1;}");
        ctClass.addConstructor(constructor);

        // 为类设置方法
        CtMethod method = new CtMethod(CtClass.voidType, "show", null, ctClass);
        method.setModifiers(Modifier.PUBLIC);
        method.setBody("{System.out.println(\"执行结果\" + this.userName);}");
        ctClass.addMethod(method);

        // 加载和执行生成的类
        Class<?> clazz = ctClass.toClass();
        Object obj = clazz.newInstance();
        clazz.getMethod("setUserName", String.class).invoke(obj, "jhp");
        clazz.getMethod("show").invoke(obj);
        //执行构造器传递进来的参数
        obj = clazz.getConstructor(String.class).newInstance("lyn");
        clazz.getMethod("show").invoke(obj);
    }
}
