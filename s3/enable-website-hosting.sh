aws s3api put-bucket-acl --bucket my-guinea-pig-website --acl public-read
aws s3api website s3://my-guinea-pig-website/ --index-document index.html --error-document error.html
