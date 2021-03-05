node {
    sshagent (credentials: ['ssh-logisoft']) {
        sh 'ssh -o StrictHostKeyChecking=no -l logisoft 14.225.5.109 uname -a'
    }
    stage('Example') {
        if (env.BRANCH_NAME == 'main') {
            echo 'I only execute on the master branch'
        } else {
            echo 'I execute elsewhere'
        }
    }
}
