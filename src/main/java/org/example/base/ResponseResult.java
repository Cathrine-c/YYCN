package org.example.base;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter

public class ResponseResult {

    //业务操作是否成功：前端统一在成功回调处理
    private boolean ok;

    //业务操作成功.
    private Object data;

    //业务操作失败，返回提示信息
    private String message;



}
