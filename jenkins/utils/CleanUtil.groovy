def cleanProject(boolean isLinux) {
    // Очищаем target
    if (isLinux) {
        sh 'mvn clean'
        //sh 'rm -r build'
    }
    else {
        bat 'mvn clean'
        //bat 'rmdir /s /q build'
    }
}
return this
