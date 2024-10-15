pipeline {

    agent any

    parameters {
        string(name: 'config', defaultValue: 'default', description: 'YAML config for run')
        string(name: 'tags', defaultValue: 'run', description: 'List of tags for running')
        string(name: 'emailList', defaultValue: 'kvipka90@yandex.ru', description: 'List of recipients for reports')
    }

    stages {
        stage('Run Tests') {

            steps('run docker image') {
                // This step should not normally be used in your script. Consult the inline help for details.
                //withDockerContainer(image: 'qvipka/playwright-1.45.0:latest') {
                //    sh './mvnw -Dconfig=$config -Dgroups=tags clean test'
                //}

                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    sh "./mvnw -Dconfig=${config} -Dgroups=${tags} -DbuildUrl=${BUILD_URL} clean test"
                }
            }

        }
    }

    post {
        always {
            script {
                def aftUtil = load "jenkins/utils/AftUtil.groovy"
                aftUtil.handlePostAction(false, "Test stand", params.emailList)
            }
        }
    }
}