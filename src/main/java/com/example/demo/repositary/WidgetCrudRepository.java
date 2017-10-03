package com.example.demo.repositary;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;

import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;

import com.example.demo.domain.Widget;
import com.example.demo.domain.WidgetId;

import java.util.Collection;



@EnableScan

public interface WidgetCrudRepository extends CrudRepository<Widget, WidgetId> {

	Collection<Widget> findByGroup(@Param("group") Long group);

}
