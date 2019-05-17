package se.forsakringskassan.fifty.deductionservice.resource;


import se.forsakringskassan.fifty.deductionservice.api.Deduction;
import se.forsakringskassan.fifty.deductionservice.api.DeductionReply;
import se.forsakringskassan.fifty.deductionservice.api.DeductionRequest;
import se.forsakringskassan.fifty.deductionservice.logic.DeductionService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

@Path("/deductionservice")
public class DeductionServiceResource
{
    @Inject
    DeductionService deductionService;

    @Path("/")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello()
    {
        return "hello";
    }

    @Path("/customers/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Deduction> getDeduction(@PathParam("id") String id)
    {
        return deductionService.getDeductionForCustomer(UUID.fromString(id));
    }

    @Path("/customers/{id}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createDeduction(@PathParam("id") String id, Deduction deduction)
    {
        deductionService.storeCustomerDeduction(UUID.fromString(id), deduction);
    }

    @Path("/reduce")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public DeductionReply executeReduction(DeductionRequest request)
    {
        return deductionService.makeDeduction(request);
    }




}
