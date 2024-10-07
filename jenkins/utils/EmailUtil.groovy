def sendAllureNotificationMailReport(String comments, String recipients, boolean isLinux) {
    def allureNotificationUtil = load "jenkins/utils/AllureNotificationUtil.groovy"

    withCredentials([usernamePassword(credentialsId: 'qvipka', usernameVariable: 'EMAIL_LOGIN', passwordVariable: 'EMAIL_PASSWORD')]) {
        allureNotificationUtil.callAllureNotification(JOB_NAME, BUILD_NUMBER, comments, recipients, BUILD_URL, EMAIL_LOGIN, EMAIL_PASSWORD, isLinux);
    }
}

def sendClassicMailReport(boolean withStackTraceDetails, String testStand, String recipients) {
    if (recipients == null || recipients.isEmpty())
        return

    String tstDetailsString = ""
    /** Блок для добавления стек трейса, если нужно в письме выводить какие тесты упали и почему **/
    if (withStackTraceDetails) {
        tstDetailsString = ''' 
            Tests details :<br/> 
            ${FAILED_TESTS, showStack="false"} 
            '''
    }

    String subject = '$DEFAULT_SUBJECT'
    String testCount = '${TEST_COUNTS,var="total"}'
    String passed = '${TEST_COUNTS,var="pass"}'
    String failed = '${TEST_COUNTS,var="fail"}'
    //String jobName = '${JOB_NAME}'
    //String buildNumber = '${BUILD_NUMBER}'
    String buildUrl = '${BUILD_URL}'
    String jobDescription = '${JOB_DESCRIPTION}'

    emailext subject: subject,
            body: """ 
                     <b>Execution results:<br/> 
                     Total: ${testCount} 
                     <span style="color:rgb(0,255,0);">&nbsp;&nbsp;&nbsp;Passed: ${passed}</span> 
                     <span style="color:rgb(255,0,0);">&nbsp;&nbsp;&nbsp;Failed: ${failed}</span></b><br/> 
                     ${tstDetailsString}<br/> 
                     <br/> 
                     <b>Report link:</b> ${buildUrl}<br/> 
                     <br/> 
                     <b>Test stand:</b> ${testStand}<br/> 
                     <b>Description:</b> ${jobDescription}<br/> 
                        """,
            to: recipients,
            mimeType: 'text/html',
            attachmentsPattern: '*-report*'
}

static String getRecipientsFromArrayList(ArrayList recipients) {
    StringBuilder result = new StringBuilder()
    for (int i = 0; i < recipients.size(); i++) {
        result.append(recipients.get(i))
        if (i + 1 < recipients.size())
            result.append(", ")
    }
    return result.toString()
}

return this
