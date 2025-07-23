package com.cursonelio.course.entities.enums;

public enum OrderStatus {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code; // Código associado a cada status do pedido

    private OrderStatus(int code){ // Construtor privado para inicializar o código do status
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static OrderStatus valueOf(int code){ // Método estático para converter um código em um OrderStatus
        for (OrderStatus o : OrderStatus.values()){
            if (o.getCode() == code){
                return o;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }
}
