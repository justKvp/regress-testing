def callAllureNotification(String subject, String buildNumber, String jobDescription, String recipients,
                           String url, String login, String password, boolean isLinux) {
    createConfig(subject, buildNumber, jobDescription, recipients, url, login, password)

    if (isLinux) {
        sh 'java "-DconfigFile=lib/config.json" -jar lib/allure-notifications-4.7.0.jar'
    }
    else {
        bat 'java "-DconfigFile=lib/config.json" -jar lib/allure-notifications-4.7.0.jar'
    }

    deleteConfig(isLinux)
}

def createConfig(String subject, String buildNumber, String jobDescription, String recipients, String url, String login, String password) {
    String project = subject + " - build #" + buildNumber
    String body = '{\n' +
            '  "base": {\n' +
            '    "logo": "lib/logo.png",\n' +
            '    "project": "' + project + '",\n' +
            '    "environment": "some env",\n' +
            '    "comment": "' + jobDescription + '",\n' +
            '    "reportLink": "' + url + '",\n' +
            '    "language": "ru",\n' +
            '    "allureFolder": "allure-report",\n' +
            '    "enableChart": true,\n' +
            '    "enableSuitesPublishing": true\n' +
            '  },\n' +
            '  "mail": {\n' +
            '    "host": "smtp.gmail.com",\n' +
            '    "port": "465",\n' +
            '    "username": "' + login + '",\n' +
            '    "password": "' + password + '",\n' +
            '    "securityProtocol": "SSL",\n' +
            '    "from": "qvipka@gmail.com",\n' +
            '    "recipient": "' + recipients + '",\n' +
            '    "templatePath": "/templates/html.ftl"\n' +
            '  }\n' +
            '}';

    writeFile file: 'lib/config.json', text: body
}

def deleteConfig(boolean isLinux) {
    if (isLinux) {
        sh 'rm lib/config.json'
    }
    else {
        bat 'del lib/config.json'
    }
}

return this