package ch.zli.m223.controller;

import javax.ws.rs.Path;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Entry;
import ch.zli.m223.service.EntryService;
import ch.zli.m223.service.TagService;

import javax.ws.rs.core.Response;

@Path("/tags")
@Tag(name = "Tags", description = "Handling of tags")
public class TagController {
    @Inject
    TagService tagService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new entry.", description = "Creates a new entry and returns the newly added entry.")
    public Response create(ch.zli.m223.model.Tag tag) {
        return Response.ok(tagService.createTag(tag)).build();
    }
}
