package se.forsakringskassan.fifty.deductionservice.api;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public enum DeductionType
{
    KRONOFOGDEN("KRONOFOGDEN"),
    CSN("CSN");

    private final String deductionType;

    DeductionType(String paymentMethod)
    {
        this.deductionType = paymentMethod;
    }

    public String getDeductionType()
    {
        return deductionType;
    }
}
