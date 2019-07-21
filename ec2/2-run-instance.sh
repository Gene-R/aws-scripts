aws ec2 run-instances \
	--image-id ami-0d8f6eb4f641ef691 \
	--count 1 \
	--instance-type t2.micro \
	--key-name new-key \
	--iam-instance-profile Name=my-ec2-instance-profile \
	--associate-public-ip-address \
	--security-group-ids sg-3b5b7f55 \
	--subnet-id subnet-08e84ad3d82b9d175 \
	--user-data file://user-data-script \
	--tag-specification \
	   'ResourceType=instance,Tags=[{Key=linux,Value=test}]' \
	   'ResourceType=volume,Tags=[{Key=cost,Value=evaluation-only}]' 






