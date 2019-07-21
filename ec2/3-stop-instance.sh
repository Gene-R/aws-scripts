#IDS=$(aws ec2 describe-instances --filters "Name=instance-type,Values=t2.micro" --query "Reservations[].Instances[].InstanceId")
IDS=$(aws ec2 describe-volumes   --query 'Volumes[*].{InstanceId:Attachments[0].InstanceId}')
aws ec2 terminate-instances --instance-ids $IDS
