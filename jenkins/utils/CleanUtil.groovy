def cleanProject(boolean isLinux) {
    // Очищаем target
    if (isLinux) {
        sh './mvnw clean'
        //sh 'rm -r build'
    }
    else {
        bat './mvnw clean'
        //bat 'rmdir /s /q build'
    }
}
return this
