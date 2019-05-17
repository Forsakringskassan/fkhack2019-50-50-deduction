package se.forsakringskassan.fifty.deductionservice.api;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.List;

@RegisterForReflection
public class DeductionReply
{
    public double gross;
    public double nett;
    public List<Deduction> deductions;

    @Override
    public String toString()
    {
        return "DeductionReply{" +
                "gross=" + gross +
                ", nett=" + nett +
                ", deductions=" + deductions +
                '}';
    }
}
