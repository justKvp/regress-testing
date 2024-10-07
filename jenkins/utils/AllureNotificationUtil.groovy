def callAllureNotification(String recipients,
                           String url, String login, String password, boolean isLinux) {
    createConfig(recipients, url, login, password)

    if (isLinux) {
        sh 'java "-DconfigFile=lib/config.json" -jar lib/allure-notifications-4.7.0.jar'
    }
    else {
        bat 'java "-DconfigFile=lib/config.json" -jar lib/allure-notifications-4.7.0.jar'
    }

    deleteConfig(isLinux)
}

def createConfig(String recipients, String url, String login, String password) {
    String body = '{\n' +
            '  "base": {\n' +
            '    "logo": "lib/logo.png",\n' +
            '    "project": "${JOB_NAME}",\n' +
            '    "environment": "some env",\n' +
            '    "comment": "some comment",\n' +
            '    "reportLink": "' + url + '",\n' +
            '    "language": "ru",\n' +
            '    "allureFolder": "allure-report",\n' +
            '    "enableChart": true,\n' +
            '    "enableSuitesPublishing": true\n' +
            '  },\n' +
            '  "mail": {\n' +
            '    "host": "smtp.rosatom.ru",\n' +
            '    "port": "25",\n' +
            '    "username": "' + login + '",\n' +
            '    "password": "' + password + '",\n' +
            '    "securityProtocol": null,\n' +
            '    "from": "jenkins@greenatom.ru",\n' +
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