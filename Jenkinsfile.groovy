node {

    environment {
        SSH_INFO="ssh -o StrictHostKeyChecking=no -vv logisoft@14.225.5.109"
    }

    stage('Example') {
        sshagent (credentials: ['ssh-logisoft']) {
            sh '''
                $SSH_INFO echo testing connection || true
                ssh-add -L
                echo done running remote windows test
            '''
        }
    }
}
