node {

    environment {
        SSH_INFO="ssh -o StrictHostKeyChecking=no -tt logisoft 14.225.5.109"
    }

    stage('Example') {
        sshagent (credentials: ['ssh-logisoft']) {
            sh '''
                ${SSH_INFO} << EOF
                docker ps -a
                EOF
            '''
        }
    }
}
