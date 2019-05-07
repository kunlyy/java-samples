package com.crk.proxy;

import lombok.Data;

/**
 * Created by chenrongkun on 2019/3/27.
 */
@Data
public class MethodDTO {

	private byte[] methodName;

	private Class<?>[] parameterTypes;

	private Object[] arguments;
}