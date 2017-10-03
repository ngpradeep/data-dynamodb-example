package com.example.demo.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.Request;
import com.example.demo.domain.Widget;
import com.example.demo.domain.WidgetId;
import com.example.demo.repositary.WidgetCrudRepository;;

@RestController
@RequestMapping ("/widgets")
public class WidgetRestControlller {
	
	
	private WidgetCrudRepository widgetCrudRepositary;
	
	@Autowired
	public WidgetRestControlller (WidgetCrudRepository widgetCrudRepositary){
		this.widgetCrudRepositary = widgetCrudRepositary;
	}
	
	@GetMapping("/{group}")
	public ResponseEntity<Collection<Widget>>  findWidgetsbyGroup(@PathVariable final long group ) {
		
		return new ResponseEntity<>(widgetCrudRepositary.findByGroup(group),HttpStatus.OK);
		//return null;
	}
	
	
	@RequestMapping (value="/addwidgets/{group}/{id}",method=RequestMethod.POST)
	
	public void addWidgets(@PathVariable("group") final Long group , @PathVariable("id") final String id,@RequestBody final String properties ){
		
		System.out.println("properties value----->"+properties);
		Widget addWidget = new Widget(properties, new WidgetId(group,id));
		widgetCrudRepositary.save(addWidget);
		
	}

	
	
	
	
}
