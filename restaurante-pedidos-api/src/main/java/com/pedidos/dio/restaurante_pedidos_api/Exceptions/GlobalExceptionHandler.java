package com.pedidos.dio.restaurante_pedidos_api.Exceptions;

public class GlobalExceptionHandler extends RuntimeException {
    public GlobalExceptionHandler(String message) {
        super(message);
    }
}

public class ResourceNotFoundException extends GlobalExceptionHandler {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}


