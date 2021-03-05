node {
    sshagent (credentials: ['ssh-logisoft']) {
        sh 'ssh -o StrictHostKeyChecking=no -l logisoft 14.225.5.109 uname -a'
    }
    stage('Example') {
        sh '''
            docker ps -a
        '''
    }
}
