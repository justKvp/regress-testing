def handlePostAction(boolean withStackTrace, String testStand, String recipients) {
    def modules = [:]
    modules.ReportUtil = load "jenkins/utils/ReportUtil.groovy"
    modules.EmailUtil = load "jenkins/utils/EmailUtil.groovy"
    modules.CleanUtil = load "jenkins/utils/CleanUtil.groovy"

    /** Формируем отчет **/
    modules.ReportUtil.handleJunitAndAllureReports()

    /** Отправляем отчет на почту **/
    //modules.EmailUtil.sendClassicMailReport(withStackTrace, testStand, recipients)
    modules.EmailUtil.sendAllureNotificationMailReport(recipients, isUnix())

    /** Очищаем **/
    modules.CleanUtil.cleanProject(isUnix())
}

return this
