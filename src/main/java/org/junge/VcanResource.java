package org.junge;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/messages")
public class VcanResource {

    private final CanMessages service;

    public VcanResource(CanMessages service) {
        this.service = service;
    }

    @GET
    @Path("/{interfaceId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response recentMessages(@PathParam("interfaceId") String interfaceId) {
        try {
            return Response.ok(service.fetchRecentMessages(interfaceId)).build();
        } catch (RuntimeException e) {
            return Response.serverError().build();
        }
    }
}