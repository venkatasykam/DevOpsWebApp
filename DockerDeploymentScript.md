docker login -u ${dockerId} -p ${dockerPwd}

docker build -t devopswebapp:${releaseVersion} "${WORKSPACE}" -f "${Dockerfile}"

imageId=$(docker images devopswebapp:${releaseVersion} -q)

echo imageId: ${imageId}

docker tag ${imageId} venkatasykam/devopswebapp:${releaseVersion}

docker push venkatasykam/devopswebapp:${releaseVersion}

#docker run -d -it -p 8082:8080 venkatasykam/devopswebapp:${releaseVersion}
