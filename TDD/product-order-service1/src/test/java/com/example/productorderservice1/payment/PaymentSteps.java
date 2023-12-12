package com.example.productorderservice1.payment;

import com.example.productorderservice1.payment.application.service.PaymenetRequest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

public class PaymentSteps {
    public static PaymenetRequest 주문결제요청_생성() {
        final Long orderId = 1L;
        final String cardNumber = "1234-1234-1234-1234";
        return new PaymenetRequest(orderId, cardNumber);
    }

    static ExtractableResponse<Response> 주문결제요청(PaymenetRequest request) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/payments")
                .then().log().all()
                .extract();
    }
}