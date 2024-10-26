package vn.edu.iuh.fit.backend.api;

import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.backend.business.HangXeRemote;

@Path("/hangxes")
public class HangXeResource {
    @EJB
    private HangXeRemote hangXeRemote;
    @GET
    public Response getAllHangXe() {

        return Response.ok(hangXeRemote.getAllHangXe()).build();
    }
    @GET
    @Path("/{id}")
    public Response getHangXeById(@PathParam("id") int id) {
        return Response.ok(hangXeRemote.getHangXeById(id)).build();
    }
}
