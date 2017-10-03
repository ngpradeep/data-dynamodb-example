package com.example.demo.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonRawValue;

import net.minidev.json.annotate.JsonIgnore;

@DynamoDBTable(tableName = "widgets")
public class Widget implements Serializable {
	public static final long serialVersionId = 100L;

	@Id
	@DynamoDBIgnore
	@JsonIgnore

	private WidgetId widgetId;

	@JsonRawValue
	@DynamoDBAttribute
	private String properties;

	

	public Widget() {
	};

	public Widget(String properties, WidgetId widgetId) {

		this.properties = properties;

		this.widgetId = widgetId;

	}

	@DynamoDBHashKey (attributeName ="group")
	public Long getGroup() {
		if (widgetId != null)
			return widgetId.getGroup();
		else
			return null;
	}

	
	public void setGroup(Long group) {
		if (widgetId == null)
			widgetId = new WidgetId();
		widgetId.setGroup(group);

	}

	@DynamoDBRangeKey (attributeName ="id")
	public String getId() {
		if (widgetId != null)
			return widgetId.getId();
		else
			return null;
	}

	
	public void setId(String id) {
		if (widgetId == null)
			widgetId = new WidgetId();
		widgetId.setId(id);
	}
	

	public String getProperties() {
		return properties;
	}

	public void setProperties(String properties) {
		this.properties = properties;
	}

	@Override

	public boolean equals(Object o) {

		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		Widget widget = (Widget) o;

		return !(widgetId != null ? !widgetId.equals(widget.widgetId) : widget.widgetId != null);

	}

	@Override

	public int hashCode() {

		return widgetId != null ? widgetId.hashCode() : 0;

	}

}
