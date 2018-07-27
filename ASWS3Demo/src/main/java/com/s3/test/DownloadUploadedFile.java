package com.s3.test;


import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;

public class DownloadUploadedFile {

	public static void main(String[] args) throws IOException {
		String existingBucketName = "<your bucketName>";
		  String keyName = "Koala.jpg";
		  AmazonS3 s3Client = new AmazonS3Client(new PropertiesCredentials(DownloadUploadedFile.class.getResourceAsStream("AwsCredentials.properties")));
		  GetObjectRequest request = new GetObjectRequest(existingBucketName, keyName);
		  System.out.println(request);
		  S3Object object = s3Client.getObject(request);
		  System.out.println(object);
		  S3ObjectInputStream objectContent = object.getObjectContent();
		  System.out.println(objectContent);
		  IOUtils.copy(objectContent, new FileOutputStream("D://upload//Koala.jpg"));

	}

}
