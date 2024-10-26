package vn.edu.iuh.fit.backend.api;

import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.backend.api.dto.XeDTO;
import vn.edu.iuh.fit.backend.business.HangXeRemote;
import vn.edu.iuh.fit.backend.business.XeRemote;
import vn.edu.iuh.fit.backend.repositories.entities.Hangxe;
import vn.edu.iuh.fit.backend.repositories.entities.Xe;

import java.util.ArrayList;
import java.util.List;


@Path("/xes")
public class XeResource {
    @EJB
    private XeRemote xeRemote;
    @EJB
    private HangXeRemote HangXeRemote;
    @GET
    public Response getAllXe() {
        List<XeDTO> xedtos = new ArrayList<>();
        List<Xe> xes = xeRemote.getAllXe();
        for (Xe xe : xes) {
            Hangxe hangxe = HangXeRemote.getHangXeById(xe.getMahangxe().getId());
            XeDTO xeDTO = new XeDTO(xe.getId(), xe.getTenxe(), xe.getNamsanxuat(), hangxe.getId(),xe.getGiaXe());
            xedtos.add(xeDTO);
        }
        return Response.ok(xedtos).build();
    }
    @GET
    @Path("/{id}")
    public Response getXeById(@PathParam("id") int id) {
        Xe xe = xeRemote.getXeById(id);
        Hangxe hangxe = HangXeRemote.getHangXeById(xe.getMahangxe().getId());
        XeDTO xeDTO = new XeDTO(xe.getId(), xe.getTenxe(), xe.getNamsanxuat(), hangxe.getId(),xe.getGiaXe());

        return Response.ok(xeDTO).build();
    }
    @POST
    public Response addXe(XeDTO xeDTO) {
        Xe xe = new Xe();
        xe.setTenxe(xeDTO.getTenxe());
        xe.setNamsanxuat(xeDTO.getNamsanxuat());
        xe.setGiaXe(xeDTO.getGiaXe());
        Hangxe hangxe = HangXeRemote.getHangXeById(xeDTO.getMahangxe());
        xe.setMahangxe(hangxe);
        xeRemote.addXe(xe);
        return Response.ok().build();
    }



}
