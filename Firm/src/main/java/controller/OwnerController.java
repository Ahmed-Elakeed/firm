package controller;

import domain.Owner;
import service.OwnerService;
import javax.ws.rs.*;

public class OwnerController {
    OwnerService ownerService=new OwnerService();
    @GET
    @Path(value = "/owner")
    public Owner owner(){
        return ownerService.findOwnerByID(1);
    }
}
