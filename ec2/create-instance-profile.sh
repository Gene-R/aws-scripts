aws iam create-instance-profile --instance-profile-name my-ec2-instance-profile
aws iam add-role-to-instance-profile --role-name S3_Read_Only --instance-profile-name my-ec2-instance-profile

