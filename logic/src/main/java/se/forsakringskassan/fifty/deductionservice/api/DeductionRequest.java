package se.forsakringskassan.fifty.deductionservice.api;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.UUID;

@RegisterForReflection
public final class DeductionRequest
{
    public String id;
    public double gross;


    @Override
    public String toString()
    {
        return "DeductionRequest{" +
                "id=" + id +
                ", gross=" + gross +
                '}';
    }
}
