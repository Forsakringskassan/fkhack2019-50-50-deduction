package se.forsakringskassan.fifty.deductionservice.api;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public enum PaymentMethod
{
    SWISH("SWISH"),
    BANKGIRO("BANKGIRO"),
    POSTGIRA("POSTGIRA");

    private final String paymentMethod;

    PaymentMethod(String paymentMethod)
    {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethod()
    {
        return paymentMethod;
    }
}
