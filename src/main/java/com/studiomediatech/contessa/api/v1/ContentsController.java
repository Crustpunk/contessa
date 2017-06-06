package com.studiomediatech.contessa.api.v1;

import com.studiomediatech.contessa.contents.ContentsService;
import com.studiomediatech.contessa.logging.Loggable;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;


/**
 * Provides end-points for handling contents.
 *
 * <p>Basically fails fast or delegates on to the contents service.</p>
 */
public class ContentsController implements Loggable {

    private final ContentsService contentsService;

    @Autowired
    public ContentsController(ContentsService contentsService) {

        this.contentsService = contentsService;
    }

    @PostMapping("/api/v1/contents/{name:.+}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addMediaContent(@PathVariable("name") String name, @RequestBody byte[] payload) {

        logger().info("Received contents file '{}' with payload of {} bytes", name, payload.length);
        contentsService.addMediaContent(name, payload);
        logger().debug("Done handling content");
    }


    @GetMapping("/api/v1/contents/{id:.+}")
    @ResponseBody
    public byte[] getMediaContent(@PathVariable("id") String id) {

        logger().info("Request for {} received", id);

        Map<String, Object> mediaContent = contentsService.getMediaContent(id);
        logger().debug("Done serving content");

        return (byte[]) mediaContent.get("image");
    }
}
