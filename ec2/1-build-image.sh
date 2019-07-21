CUR_DIR=$PWD
BUILD_DIR=.tmp-build
rm -rf $BUILD_DIR
mkdir -p $BUILD_DIR
cd $BUILD_DIR
git clone https://github.com/DogeLiveOnForever/HTML-Projects 
cd ./HTML-Projects/Websites/My-First-Website/
./create-ec2.sh
rm -f $CUR_DIR/max-html.tar
docker save --output $CUR_DIR/max-html.tar max-html:v1
cd $CUR_DIR
echo "Copying image to s3 bucket ..."
aws s3 cp ./max-html.tar s3://123-567-my-test-bucket-us-east-2
aws s3 ls 123-567-my-test-bucket-us-east-2
echo "All done"
