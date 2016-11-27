package com.web.services;

import java.time.LocalDate;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mysql.jdbc.StringUtils;
import com.web.database.JavaSQL;


@Path("/")
public class TrainService {

	@GET
	@Path("/trains")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchTrains(@QueryParam(value="source") String source, @QueryParam(value = "destination") String destination, @QueryParam(value = "date") String date) {
		if(source==null||destination==null||source.isEmpty()||destination.isEmpty()){
			return Response.status(400).build();
		}
			//2016-12-02
		LocalDate localDate = LocalDate.parse(date);
		List<TrainBean> trainBeans = new JavaSQL().fetchTrains(source, destination, localDate);
		return Response.status(200).entity(trainBeans).build();

	}

}

