def call(body) {
    def pipelineParams = [
        NUMBER: 1
    ]

    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipelineParams
    body()

    if ( pipelineParams.NUMBER % 2 == 0 ) {
        pipeline {
            agent any
            stages {
                stage('Even Stage') {
                steps {
                    echo "number is even"
                }
                }
            }
        }
    } else {
        pipeline {
            agent any
            stages {
                stage('Odd Stage') {
                steps {
                    echo "number is odd"
                }
                }
            }
        }
    }
}