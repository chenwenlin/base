package com.chen.basecommon.exceptions;

import com.chen.basecommon.net.DataResponse;
import com.chen.basecommon.net.NetworkCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;


/**
 * 全局异常处理器, 这是个抽象类, 需要继承并自行注册到 Spring 容器
 *
 * @author qinkangdeid
 * @date 2020/10/17 17:34:39
 */
@Slf4j(topic = "global-exception-handler")
public abstract class AbstractGlobalExceptionHandler {

    /**
     * 异常处理程序
     * 顶级的Exception 如果没有捕获到具体的异常 会由此异常处理器处理
     *
     * @param e Exception
     * @return Exception
     */
    @ExceptionHandler(value = Exception.class)
    public DataResponse<String> exceptionHandler(Exception e) {
        log.error("服务异常处理{}", e.getMessage(), e);
        return DataResponse.failed(e.getMessage());
    }


    /**
     * 方法参数不是有效的异常处理程序
     *
     * @param e e
     * @return {@link DataResponse<String>}
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public DataResponse<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        log.warn("MethodArgumentNotValidException:" + e.getMessage(), e);
        BindingResult bindingResult = e.getBindingResult();
        StringBuilder errorMessage = new StringBuilder("");
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errorMessage.append(fieldError.getDefaultMessage()).append(",");
        }
        return DataResponse.failed(NetworkCode.BAD_REQUEST, StringUtils.removeEnd(errorMessage.toString(), ","));
    }

    /**
     * 无效的格式异常处理程序
     *
     * @param e e
     * @return {@link DataResponse<String>}
     */
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public DataResponse<String> httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException e) {
        log.warn("HttpMessageNotReadableException:" + e.getMessage(), e);
        return DataResponse.failed(NetworkCode.BAD_REQUEST, "数据参数不正确");
    }

    /**
     * Exception
     *
     * @param e Exception
     * @return Exception
     */
    @ExceptionHandler(value = IllegalArgumentException.class)
    public DataResponse<String> illegalArgumentExceptionHandle(IllegalArgumentException e) {
        log.error("业务异常:{}", e.getMessage(), e);
        return DataResponse.failed(e.getMessage());
    }

    /**
     * sql约束异常
     *
     * @param e Exception
     * @return Exception
     */
    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public DataResponse<String> sQLIntegrityConstraintViolationExceptionHandler(SQLIntegrityConstraintViolationException e) {
        log.warn("数据库校验异常:{}", e.getMessage(), e);
        return DataResponse.failed(e.getMessage());
    }

    /**
     * Exception
     *
     * @param e Exception
     * @return Exception
     */
    @ExceptionHandler(value = NumberFormatException.class)
    public DataResponse<String> numberFormatExceptionHandler(NumberFormatException e) {
        log.warn("NumberFormatException：{}", e.getMessage(), e);
        return DataResponse.failed("数据转换异常请检查输入参数".concat(e.getMessage()));
    }

    /**
     * Exception
     *
     * @param e Exception
     * @return Exception
     */
    @ExceptionHandler(value = org.springframework.web.HttpRequestMethodNotSupportedException.class)
    public DataResponse<String> exceptionHandler(org.springframework.web.HttpRequestMethodNotSupportedException e) {
        log.warn("HttpRequestMethodNotSupportedException：{}", e.getMessage(), e);
        return DataResponse.failed(e.getMessage());
    }
}
