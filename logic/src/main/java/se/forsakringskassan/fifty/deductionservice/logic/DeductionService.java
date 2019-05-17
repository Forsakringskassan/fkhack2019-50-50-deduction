package se.forsakringskassan.fifty.deductionservice.logic;

import se.forsakringskassan.fifty.deductionservice.api.Deduction;
import se.forsakringskassan.fifty.deductionservice.api.DeductionReply;
import se.forsakringskassan.fifty.deductionservice.api.DeductionRequest;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class DeductionService
{
    // in mem "db"
    private final static Map<UUID, List<Deduction>> m = new ConcurrentHashMap<>();

    public void storeCustomerDeduction(UUID id, Deduction deduction)
    {
        List<Deduction> l = m.get(id);
        if(null == l)
        {
            l = new ArrayList<>();
            m.put(id, l);
        }
        l.add(deduction);
    }

    public List<Deduction> getDeductionForCustomer(UUID id)
    {
        return m.get(id);
    }

    public DeductionReply makeDeduction(DeductionRequest request)
    {
        DeductionReply reply = new DeductionReply();
        reply.gross = request.gross;
        reply.deductions = new ArrayList<>();
        double amountAvailable = reply.gross;
        double amountReduced = 0;
        for(Deduction d : m.get(UUID.fromString(request.id)))
        {
            double amountToReduce = amountToReduce(amountAvailable, d);
            d.amount -= amountToReduce;
            amountAvailable -= amountToReduce;
            amountReduced += amountToReduce;
            Deduction deductionMade = new Deduction();
            deductionMade.amount = amountToReduce;
            deductionMade.deductionType = d.deductionType;
            reply.deductions.add(deductionMade);
        }
        reply.nett = reply.gross - amountReduced;
        return reply;
    }

    private double amountToReduce(double amountAvailable, Deduction d)
    {
        return (amountAvailable >= d.amount) ? d.amount : amountAvailable;
    }

}
