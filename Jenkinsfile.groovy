node {

    environment {
        SSH_INFO="ssh -o StrictHostKeyChecking=no -l logisoft 14.225.5.109 uname -a"
    }

    stage('Example') {
        sshagent (credentials: ['ssh-logisoft']) {
            sh '''
                ${SSH_INFO} << EOF
                docker ps -a
            '''
        }
    }
}
