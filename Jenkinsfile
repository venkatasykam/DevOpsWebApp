/*
Find more info - https://github.com/DevOpsOnlineTraining-2021/Docker/blob/main/Jenkins_with_docker/Example-5.md
*/


node {
    checkout scm

    docker.withRegistry('http://50.19.128.197:5000/repository/docker-hosted/', 'jenkinsnexus') {

        def customImage = docker.build("my-image:${env.BUILD_ID}")

        /* Push the image to the custom Registry */
        customImage.push()
    }
}
