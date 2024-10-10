/** Считываем результаты из junit surefire **/
def prepareJunitReport() {
    echo '--- Считываем результаты из junit surefire'
    junit 'target/surefire-reports/*.xml', skipPublishingChecks: true
}

/** Подготавливаем allure report **/
def prepareAllureReport() {
    echo '--- Подготавливаем allure report'
    allure([
            includeProperties: false,
            jdk              : '',
            properties       : [],
            reportBuildPolicy: 'ALWAYS',
            results          : [[path: 'target/allure-results']]
    ])
}

def handleJunitAndAllureReports() {
    // Сначала считываем junit результаты
    prepareJunitReport()

    // Формируем аллюр отчет
    prepareAllureReport()
}

return this
