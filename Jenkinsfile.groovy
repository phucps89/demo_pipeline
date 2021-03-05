def COLOR_MAP = ['SUCCESS': 'good', 'FAILURE': 'danger', 'UNSTABLE': 'danger', 'ABORTED': 'danger']

pipeline {
    agent any 
    options {
        ansiColor('xterm')
        disableConcurrentBuilds()
    }

    environment {
        SSH_INFO="logisoft@14.225.5.109"
    }

    stage('Example') {
        sshagent (credentials: ['ssh-logisoft']) {
            sh """
                ssh -o StrictHostKeyChecking=no -vv ${SSH_INFO} "
                    docker ps -a
                "
            """
        }
    }
}
