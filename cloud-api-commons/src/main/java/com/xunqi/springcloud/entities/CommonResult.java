package com.xunqi.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Created with IntelliJ IDEA.
 * @author: 夏沫止水
 * @create: 2020-04-03 21:02
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {      //泛型：如果装的payment 返回payment,装的order 返回order

    private Integer code;

    private String message;

    private T data;

    public CommonResult(Integer code,String message) {
        this(code,message,null);
    }

}
