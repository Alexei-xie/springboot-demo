package com.itself.common.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 1.全局异常处理注解，使用时可以放在application类上
 * 2.可以通过spring自动装配来进行全局引用，这样就不需要手动添加注解了，需要在resources文件夹下建 META-INF/spring.factories文件
 * @Author xxw
 * @Date 2023/07/12
 */
@Import(GlobalExceptionAnnotation.class)//导入配置类
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface GlobalExceptionAnnotation {
}
