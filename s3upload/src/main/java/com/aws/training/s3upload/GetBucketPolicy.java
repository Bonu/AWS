package com.aws.training.s3upload;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetBucketPolicyRequest;
import software.amazon.awssdk.services.s3.model.GetBucketPolicyResponse;
import software.amazon.awssdk.services.s3.model.S3Exception;

public class GetBucketPolicy {

	public static void main(String[] args)
	   {
	      final String USAGE = "\n" +
	         "Usage:\n" +
	         "    GetBucketPolicy <bucket>\n\n" +
	         "Where:\n" +
	         "    bucket - the bucket to get the policy from.\n\n" +
	         "Example:\n" +
	         "    GetBucketPolicy testbucket\n\n";

	      if (args.length < 1) {
	         System.out.println(USAGE);
	         System.exit(1);
	      }

	      String bucket_name = args[0];
	      String policy_text = null;

	      System.out.format("Getting policy for bucket: \"%s\"\n\n", bucket_name);

	      Region region = Region.US_EAST_2;
	      S3Client s3 = S3Client.builder().region(region).build();

	      GetBucketPolicyRequest policyReq = GetBucketPolicyRequest.builder()
	    		  .bucket(bucket_name)
	    		  .build();

	      try {
	         GetBucketPolicyResponse policy_res = s3.getBucketPolicy(policyReq);
	         policy_text = policy_res.policy();
	      } catch (S3Exception e) {
	         System.err.println(e.awsErrorDetails().errorMessage());
	         System.exit(1);
	      }

	      if (policy_text == null) {
	         System.out.println("The specified bucket has no bucket policy.");
	      } else {
	         System.out.println("Returned policy:");
	         System.out.println("----");
	         System.out.println(policy_text);
	         System.out.println("----\n");
	      }

	      System.out.println("Done!");
	   }
}
