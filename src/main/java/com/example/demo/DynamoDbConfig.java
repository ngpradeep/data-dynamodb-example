package com.example.demo;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

@Configuration
@EnableDynamoDBRepositories (basePackages="com.example.demo.repositary")

public class DynamoDbConfig  {
	
	@Value("${amazon.dynamodb.endpoint}")
	private String dynamodbendpoint;
	
	@Value("${amazon.aws.accesskey}")
	private String dynamodbaccesskey;
	
	@Value("${amazon.aws.secretkey}")
	private String dynamodbsecretaccess;
	
	@Value("${amazon.dynamodb.table}")
	private String table;
	
	@Value("${amazon.aws.region}")
	private String region;
	
	@Bean
	public AmazonDynamoDB amazonDynamoDB(){
		System.out.println("endpoint--->"+dynamodbendpoint);
		AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(awsCredentials()))
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(dynamodbendpoint, region)).build();
		return amazonDynamoDB;
	}

	@Bean
	public AWSCredentials awsCredentials(){
		return new BasicAWSCredentials(dynamodbaccesskey, dynamodbsecretaccess);
	}
	
	@Bean
	public String getTable(){
		return table;
	}
}

