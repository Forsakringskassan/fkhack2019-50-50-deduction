package se.forsakringskassan.fifty.deductionservice.api;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class Deduction
{
    public double amount;
    public DeductionType deductionType;

    @Override
    public String toString()
    {
        return "Deduction{" +
                "amount=" + amount +
                ", deductionType=" + deductionType +
                '}';
    }
}
