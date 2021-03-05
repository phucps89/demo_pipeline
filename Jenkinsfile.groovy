node {

    environment {
        SSH_INFO="logisoft@14.225.5.109"
    }

    stage('Example') {
        sshagent (credentials: ['ssh-logisoft']) {
            sh '''
                ssh -o StrictHostKeyChecking=no -vv $SSH_INFO "
                docker ps -a
                "
            '''
        }
    }
}
