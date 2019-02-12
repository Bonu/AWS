package com.aws.training.s3upload;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.CopyObjectRequest;
import software.amazon.awssdk.services.s3.model.CopyObjectResponse;
import software.amazon.awssdk.services.s3.model.S3Exception;

public class CopyObject {

	public static void main(String[] args)
    {
        final String USAGE = "\n" +
            "To run this example, supply the name (key) of an S3 object, the bucket name\n" +
            "that it's contained within, and the bucket to copy it to.\n" +
            "\n" +
            "Ex: CopyObject <objectname> <frombucket> <tobucket>\n";

        if (args.length < 3) {
            System.out.println(USAGE);
            System.exit(1);
        }

        String object_key = args[0];
        String from_bucket = args[1];
        String to_bucket = args[2];

        System.out.format("Copying object %s from bucket %s to %s\n",
                object_key, from_bucket, to_bucket);
        Region region = Region.US_EAST_2;
        S3Client s3 = S3Client.builder().region(region).build();

        CopyObjectRequest copyReq = CopyObjectRequest.builder()
        		.copySource(from_bucket + "/" + object_key)
        		.bucket(to_bucket)
        		.key(object_key)
        		.build();

        try {
        	CopyObjectResponse copyRes = s3.copyObject(copyReq);
        	System.out.println(copyRes.copyObjectResult().toString());
        } catch (S3Exception e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
        System.out.println("Done!");
    }
}
